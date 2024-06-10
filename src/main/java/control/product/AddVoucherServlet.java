package control.product;

import dao.DAO;
import dao.VoucherDB;
import entity.Voucher;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/addVoucher")
public class AddVoucherServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("addVoucher.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!CheckPermission.checkAdmin(request, response)) {
            return;
        }
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!CheckPermission.checkAdmin(request, response)) {
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        VoucherDB voucherDB = new VoucherDB();
String code = request.getParameter("code");
        int value = Integer.parseInt(request.getParameter("value"));
        boolean typeSale = request.getParameter("typeSale").equals("1");
        boolean status = request.getParameter("status").equals("1");
        String describeVoucher = request.getParameter("describeVoucher");
        int maxSale = Integer.parseInt(request.getParameter("maxSale"));
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        Voucher voucher = new Voucher(code, value, typeSale, status, describeVoucher, maxSale, startDate, endDate);
        if (voucherDB.addVoucher(voucher)) {
            request.setAttribute("successMessage", "Đã thêm voucher thành công");
        } else {
            request.setAttribute("errorMessage", "Thêm voucher thất bại");
        }
        processRequest(request, response);
    }
}
