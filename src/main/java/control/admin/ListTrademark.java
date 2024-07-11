package control.admin;

import dao.TradeMarkDB;
import entity.Trademark;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListTrademark", urlPatterns = "/list-trademark")
public class ListTrademark extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TradeMarkDB trademarkService = new TradeMarkDB();
        List<Trademark> trademarks = trademarkService.getAllTrademark();
        request.setAttribute("listTrademark", trademarks);
        request.getRequestDispatcher("listTrademark.jsp").forward(request, response);
    }
}
