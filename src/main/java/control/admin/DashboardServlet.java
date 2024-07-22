package control.admin;

import dao.StatisticsDAO;
import utils.CheckPermission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if(!CheckPermission.checkAdmin(request, response)) return;
        StatisticsDAO statisticsDAO = new StatisticsDAO();

        Map<String, Object> statistics = statisticsDAO.getStatistics();
        request.setAttribute("statistics", statistics);
        String now = java.time.LocalDate.now().toString();
        String lastDay = java.time.LocalDate.now().minusDays(1).toString();
        String fromDate = request.getParameter("fromDate") == null ? lastDay : request.getParameter("fromDate");
        String toDate = request.getParameter("toDate") == null ? now : request.getParameter("toDate");
        request.setAttribute("fromDate", fromDate);
        request.setAttribute("toDate", toDate);
        Map<String, Long> revenueData = statisticsDAO.getRevenueBetweenDates(fromDate, toDate);
        request.setAttribute("revenueData", revenueData);

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);

    }

}
