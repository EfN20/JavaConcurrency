package task1.servlets;

import task1.services.FileService;
import task1.services.interfaces.IFilesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DisplayFilesServlet", value = "/task1")
public class DisplayFilesServlet extends HttpServlet {
    IFilesService filesService = new FileService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("files", filesService.getFileList());
        request.getRequestDispatcher("/display").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
