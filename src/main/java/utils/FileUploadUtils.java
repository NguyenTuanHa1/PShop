package utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUploadUtils {

    private static final String UPLOAD_DIR = "uploads";

    public static String uploadFile(HttpServletRequest request, ServletContext context, Part filePart, String fileName) throws ServletException {
        String uploadPath = context.getRealPath("") + File.separator + UPLOAD_DIR;

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

//        for (Part part : request.getParts()) {
//            String fileName = getFileName(part);
//            part.write(uploadPath + File.separator + fileName);
//        }

//        String fileName = getFileName(filePart);
//        Random filename
        String fileNameRandom = UUID.randomUUID().toString() + fileName;
        try {
            filePart.write(uploadPath + File.separator + fileNameRandom);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return UPLOAD_DIR + "/" + fileNameRandom;
    }

    public static String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String cd : contentDisposition.split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return "";
    }
}
