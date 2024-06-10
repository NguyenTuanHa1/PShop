package control;

import dao.DAO;
import dao.SearchDB;
import entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("keyword");
        SearchDB searchDB = new SearchDB();
        List<Product> list = searchDB.searchByKeyword(txtSearch);
        request.setAttribute("listP", list);
        request.setAttribute("keyword", txtSearch);
        request.getRequestDispatcher("searchResult.jsp").forward(request, response);
    }
}
