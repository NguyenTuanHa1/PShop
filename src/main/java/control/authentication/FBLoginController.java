package control.authentication;

import Constrant.FBConstant;
import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FBLoginController", urlPatterns = {"/auth/facebook"})
public class FBLoginController extends HttpServlet implements FBConstant {

    public static final OAuth20Service service = new ServiceBuilder(FACEBOOK_CLIENT_ID)
            .apiSecret(FACEBOOK_CLIENT_SECRET)
            .callback(FACEBOOK_REDIRECT_URI)
            .build(FacebookApi.instance());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authorizationUrl = service.getAuthorizationUrl();
        resp.sendRedirect(authorizationUrl);
    }
}
