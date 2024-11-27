package lk.ijse.gdse68.api;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("incoming request : " + req.getRemoteAddr());

        resp.getWriter().println("<h1>Hello! I'm from MyServlet!</h1>");

        ServletConfig config = getServletConfig();
        String city = config.getInitParameter("city");
        System.out.println("MyServlet : " + city);

        ServletContext context = getServletContext();
        String country = context.getInitParameter("country");
        System.out.println("MyServlet : " + country);
    }
}
