package control.authentication;

import Constrant.GoogleConstant;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.MemoryDataStoreFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfo;
import dao.Authentication;
import dao.CartDB;
import dao.DAO;
import dao.UserDB;
import entity.CartProducts;
import entity.User;
import utils.JwtUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/callbackGoogle")
public class CallbackGoogleServlet extends HttpServlet implements GoogleConstant {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        if (code != null) {
            try {
                GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                        GoogleNetHttpTransport.newTrustedTransport(),
                        JacksonFactory.getDefaultInstance(),
                        CLIENT_ID,
                        CLIENT_SECRET,
                        Collections.singleton(AUTHORIZATION_SCOPE))
                        .setDataStoreFactory(new MemoryDataStoreFactory())
                        .setAccessType("offline")
                        .build();

                GoogleTokenResponse tokenResponse = flow.newTokenRequest(code).setRedirectUri(REDIRECT_URI).execute();
                String userId = "defaultUser";
                Credential credential = flow.createAndStoreCredential(tokenResponse, userId);

                Oauth2 oauth2 = new Oauth2.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), credential)
                        .setApplicationName("PetShop")
                        .build();

                Userinfo userInfo = oauth2.userinfo().get().execute();
                String googleUserId = userInfo.getId();
                Authentication dao = new Authentication();
                CartDB cartDB = new CartDB();
                UserDB userDB = new UserDB();
                if (!dao.checkGoogle(googleUserId)) {
                    String name = userInfo.getName();
                    String pictureUrl = userInfo.getPicture();
                    dao.registerGoogle(name, pictureUrl, googleUserId);
                    cartDB.createCart(userDB.findUserByGoogleId(googleUserId).getUserID());
                }
                User user = dao.loginGoogle(googleUserId);
                if (user.isBan()){
                    resp.sendRedirect("/login.jsp");
                    return;
                }
                List<CartProducts> listCartProducts = cartDB.getCartItems(user.getUserID());
                if (listCartProducts == null) {
                    listCartProducts = new ArrayList<>();
                }
                req.getSession().setAttribute("user", user);
                req.getSession().setAttribute("cart", listCartProducts);
                String token = JwtUtil.generateToken(String.valueOf(user.getUserID()));
                req.getSession().setAttribute("token", token);
                req.getSession().setMaxInactiveInterval(60*60*24);

                resp.sendRedirect("/");
//                resp.getWriter().write("Google User ID: " + googleUserId);

            } catch (GeneralSecurityException e) {
                System.out.println(e);
                throw new ServletException("Unable to complete Google OAuth process", e);
            }
        } else {
            resp.getWriter().write("No authorization code provided");
        }
    }
}
