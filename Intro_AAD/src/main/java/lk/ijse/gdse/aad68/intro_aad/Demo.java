package lk.ijse.gdse.aad68.intro_aad;

import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = "/demo" , loadOnStartup = 2)
public class Demo extends HttpServlet {
    @Override
    public void destroy() {
        System.out.println("mn yanooooo");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("hello init");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Hello doGet method");
    }

}