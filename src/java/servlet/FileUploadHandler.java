package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet to handle File upload request from Client
 *
 * @author Javin Paul
 */
public class FileUploadHandler extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "C:/xampp/htdocs/upload/";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = "";
        RequestDispatcher rd = null;
        //process only if its multipart content
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        name = new File(item.getName()).getName();
                        File imagem = new File(UPLOAD_DIRECTORY + File.separator + name);
                        HttpSession sessao = request.getSession();
                        sessao.setAttribute("imagem", "http://localhost/upload/" + File.separator + name);
                        item.write(imagem);
                    }
                }

                //File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully :" + name);
                rd = request.getRequestDispatcher("result.jsp?nome=" + name);
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
            // request.getRequestDispatcher("/result.jsp").forward(request, response);
        } else {
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }

        rd.forward(request, response);

    }

}
