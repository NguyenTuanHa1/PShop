package control.bill;

import dao.BillDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/buyAgain")
public class BuyAgainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int billID = Integer.parseInt(request.getParameter("billID"));
        BillDB billDB = new BillDB();
        if (billDB.checkQuantity(billID)) {
            billDB.buyAgain(billID);
            response.sendRedirect("/bills");
        } else {
            response.sendRedirect("/bills?error=1");
        }
    }
}
