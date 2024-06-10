package control.ajax;

import dao.DAO;
import entity.District;
import service.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DistrictAjaxServlet", urlPatterns = {"/getDistrict"})
public class DistrictAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String idProvince = request.getParameter("idProvince");
        CityService cityService = new CityService();
        List<District> list = cityService.getDistrictsByProvince(idProvince);
        String html = "";
        for (District d : list) {
            html += "<option value='" + d.getName() + "' data-name='" +d.getIdDistrict()  + "'>" + d.getName() + "</option>";
        }
        response.getWriter().print(html);
    }
}
