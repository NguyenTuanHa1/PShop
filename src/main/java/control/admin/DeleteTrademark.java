package control.admin;

import dao.TradeMarkDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteTrademark", urlPatterns = {"/deleteTrademark"})
public class DeleteTrademark extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TradeMarkDB trademarkDB = new TradeMarkDB();
        trademarkDB.deleteTrademark(Integer.parseInt(request.getParameter("trademarkId")));
        response.sendRedirect("listTrademark");
    }
}
