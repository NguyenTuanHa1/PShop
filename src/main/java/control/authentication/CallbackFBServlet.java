package control.authentication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import dao.Authentication;
import dao.CartDB;
import dao.DAO;
import dao.UserDB;
import entity.CartProducts;
import entity.User;
import utils.JwtUtil;

@WebServlet("/callback")
public class CallbackFBServlet extends HttpServlet {
    private static final OAuth20Service service = FBLoginController.service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        try {
            OAuth2AccessToken accessToken = service.getAccessToken(code);
            OAuthRequest request = new OAuthRequest(Verb.GET, FBLoginController.FACEBOOK_LINK_GET_USER_INFO);
            service.signRequest(accessToken, request);
            Response response = service.execute(request);

            String responseBody = response.getBody();
            if (responseBody.startsWith("{")) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(responseBody);
                String userId = rootNode.path("id").asText();
                if (userId == null || userId.isEmpty()) {
                    throw new ServletException("Unable to retrieve Facebook user ID");
                }
                Authentication authenticationDB = new Authentication();
                CartDB cartDB = new CartDB();
                UserDB userDB = new UserDB();
                if (!authenticationDB.checkFB(userId)) {
                    String name = rootNode.path("name").asText();
                    String pictureUrl = rootNode.path("picture").path("data").path("url").asText();
                    authenticationDB.registerFB(name, pictureUrl, userId);
                    cartDB.createCart(userDB.findUserByFBId(userId).getUserID());
                }
                User user = authenticationDB.loginFB(userId);
                if (user.isBan()){
                    resp.sendRedirect("/login");
                    return;
                }
                List<CartProducts> listCartProducts = cartDB.getCartItems(user.getUserID());
                if (listCartProducts == null) {
                    listCartProducts = new ArrayList<>();
                }
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                session.setAttribute("cart", listCartProducts);
                session.setMaxInactiveInterval(60*60*24);
                String token = JwtUtil.generateToken(String.valueOf(user.getUserID()));
                resp.addCookie(new Cookie("token", token));
                resp.sendRedirect("/");
            } else {
                // Handle error or non-JSON response
//                resp.getWriter().write("Invalid response from Facebook: " + responseBody);
                resp.sendRedirect("/login");
            }
        } catch (InterruptedException | ExecutionException e) {
//            throw new ServletException(e);
            resp.sendRedirect("/login");
        }
    }
}

