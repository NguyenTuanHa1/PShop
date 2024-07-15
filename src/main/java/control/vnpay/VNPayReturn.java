//package control.vnpay;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//
//@WebServlet("/vnpay-return")
//public class VNPayReturn extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //Command: refund
//        String vnp_RequestId = ConfigVNPay.getRandomNumber(8);
//        String vnp_Version = "2.1.0";
//        String vnp_Command = "refund";
//        String vnp_TmnCode = ConfigVNPay.vnp_TmnCode;
//        String vnp_TransactionType = req.getParameter("trantype");
//        String vnp_TxnRef = req.getParameter("order_id");
//        long amount = Integer.parseInt(req.getParameter("amount"))*100;
//        String vnp_Amount = String.valueOf(amount);
//        String vnp_OrderInfo = "Hoan tien GD OrderId:" + vnp_TxnRef;
//        String vnp_TransactionNo = ""; //Assuming value of the parameter "vnp_TransactionNo" does not exist on your system.
//        String vnp_TransactionDate = req.getParameter
//}
