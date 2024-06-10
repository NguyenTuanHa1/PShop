package control.admin;

import dao.DAO;
import entity.Voucher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/editVoucher")
public class EditVoucherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int voucherId = Integer.parseInt(request.getParameter("voucherID"));
        DAO dao = new DAO();
        Voucher voucher = dao.getVoucherById(voucherId);
        request.setAttribute("voucher", voucher);
        request.getRequestDispatcher("editVoucher.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int voucherId = Integer.parseInt(request.getParameter("voucherID"));
        String code = request.getParameter("code");
        int value = Integer.parseInt(request.getParameter("value"));
        boolean typeSale = request.getParameter("typeSale").equals("1");
        boolean status = request.getParameter("status").equals("1");
        String describeVoucher = request.getParameter("describeVoucher");
        int maxSale = Integer.parseInt(request.getParameter("maxSale"));
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        DAO dao = new DAO();
        Voucher voucher = new Voucher(voucherId, code, value, typeSale, status, describeVoucher, maxSale, startDate, endDate);
        dao.updateVoucher(voucher);
        response.sendRedirect("/listVoucher");
    }
}
