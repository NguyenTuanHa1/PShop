package control.admin;

import dao.TradeMarkDB;
import entity.Trademark;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditTrademark", urlPatterns = "/editTrademark")
public class EditTrademark extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TradeMarkDB trademarkService = new TradeMarkDB();
        int id = Integer.parseInt(request.getParameter("id"));
        Trademark trademark = trademarkService.findTrademarkByID(id);
        request.setAttribute("trademark", trademark);
        request.getRequestDispatcher("editTrademark.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TradeMarkDB trademarkService = new TradeMarkDB();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String logo = request.getParameter("logo");
        String description = request.getParameter("description");
        Trademark trademark = new Trademark(id, name, logo, description);
        trademarkService.updateTrademark(trademark);
        response.sendRedirect("list-trademark");
    }
}
