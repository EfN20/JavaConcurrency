package task2.servlets;

import task2.domain.SearchThread;
import task2.services.SomeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    private SomeService someService = new SomeService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AAAAAAAAAAAAAAAAAA");
        String textToSearch = request.getParameter("textToSearch");
        System.out.println(textToSearch);
        if(!textToSearch.equals(null)) {
            ExecutorService executorService = Executors.newFixedThreadPool(3);
            List<Future<Integer>> resultList = new ArrayList<>();
            for(int i = 0; i < 3; i++) {
                SearchThread thread = new SearchThread(someService, textToSearch);
                Future<Integer> result = executorService.submit((Callable<Integer>) thread);
                resultList.add(result);
            }

            int count = 1;
            for(Future<Integer> future : resultList) {
                try {
                    request.setAttribute("file" + count, future.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                count++;
            }
            executorService.shutdownNow();
            try {
                executorService.awaitTermination(5, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(executorService.isTerminated()) {
                request.setAttribute("searchedWord", textToSearch);
                request.getRequestDispatcher("/result").forward(request, response);
            }
        }
    }
}
