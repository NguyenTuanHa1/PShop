package control.user;

import dao.DAO;
import dao.UserDB;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

@WebServlet(name = "UserInformationServlet", urlPatterns = {"/information"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class UserInformationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }
        int id = user.getUserID();
        UserDB userDB = new UserDB();
        User userInfo = userDB.findUserById(id);
        request.setAttribute("userInfo", userInfo);
        request.getRequestDispatcher("userInfo.jsp").forward(request, response);
    }

    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }

        UserDB userDB = new UserDB();

        int id = user.getUserID();
        User userInfo = userDB.findUserById(id);
        request.setAttribute("userInfo", userInfo);

        String name = request.getParameter("name");
        Date userDOB = Date.valueOf(request.getParameter("userDOB"));
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String address = request.getParameter("address");
        String description = request.getParameter("description");

        if (name.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Tên không được để trống!");
            request.getRequestDispatcher("userInfo.jsp").forward(request, response);
            return;
        }

        // Check if the email is in the correct format
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!email.matches(emailRegex)) {
            request.setAttribute("errorMessage", "Email không hợp lệ!");
            request.getRequestDispatcher("userInfo.jsp").forward(request, response);
            return;
        }

        String phoneRegex = "0\\d{9,10}";
        if (!phoneNumber.matches(phoneRegex)) {
            request.setAttribute("errorMessage", "Số điện thoại không hợp lệ!");
            request.getRequestDispatcher("userInfo.jsp").forward(request, response);
            return;
        }

        // Check userDOB, > 12 years old
        Date currentDate = new Date(System.currentTimeMillis());
        long diff = currentDate.getTime() - userDOB.getTime();
        long diffYears = diff / (24 * 60 * 60 * 1000) / 365;
        if (diffYears < 12) {
            request.setAttribute("errorMessage", "Ngày sinh không hợp lệ! Bạn phải lớn hơn 12 tuổi!");
            request.getRequestDispatcher("userInfo.jsp").forward(request, response);
            return;
        }


        Part filePart = request.getPart("avatarFile");
        String fileName = extractFileName(filePart);
        String avatarPath = user.getAvatar();

        if (fileName != null && !fileName.isEmpty()) {
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);
            avatarPath = UPLOAD_DIR + "/" + fileName;
        }

        user.setName(name);
        user.setUserDOB(userDOB);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setGender(gender);
        user.setAddress(address);
        user.setDescription(description);
        user.setAvatar(avatarPath);

        userDB.editInfoUser(user);

        session.setAttribute("user", user);

        response.sendRedirect("/information");
    }

    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String cd : contentDisposition.split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
