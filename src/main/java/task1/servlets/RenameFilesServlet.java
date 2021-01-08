package task1.servlets;

import task1.domain.Consumer;
import task1.domain.FileBuffer;
import task1.domain.Producer;
import task1.domain.Task1Domain;
import task1.services.FileService;
import task1.services.interfaces.IFilesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "RenameFilesServlet", value = "/rename")
public class RenameFilesServlet extends HttpServlet {
    private IFilesService filesService = new FileService();
    private FileBuffer fileBuffer = new FileBuffer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new Task1Domain(fileBuffer, filesService.getFileList()));
        executorService.submit(new Task1Domain(fileBuffer, filesService.getFileList()));
        executorService.submit(new Task1Domain(fileBuffer, filesService.getFileList()));
        executorService.submit(new Task1Domain(fileBuffer, filesService.getFileList()));
        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(executorService.isTerminated()) {
            request.getRequestDispatcher("/task1").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
