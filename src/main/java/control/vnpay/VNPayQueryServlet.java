package control.vnpay;
import Constrant.ConfigVNPay;
import com.google.gson.JsonObject;
import service.VNPayService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vnpay-query")
public class VNPayQueryServlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String amount = req.getParameter("amount");
        String bankCode = req.getParameter("bankCode");
        String language = req.getParameter("language");
        String currency = req.getParameter("currency");
        System.out.println("amount: " + amount);
        System.out.println("bankCode: " + bankCode);
        System.out.println("language: " + language);
        System.out.println("currency: " + currency);
        String paymentURL = VNPayService.getRequest(amount, bankCode, language, currency, req);
        // Json
        JsonObject json = new JsonObject();
        json.addProperty("code", "00");
        json.addProperty("message", "success");
        json.addProperty("data", paymentURL);
        resp.getWriter().write(json.toString());
    }
}
