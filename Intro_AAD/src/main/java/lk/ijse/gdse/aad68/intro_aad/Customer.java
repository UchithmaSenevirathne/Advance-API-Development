package lk.ijse.gdse.aad68.intro_aad;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/customer")
public class Customer extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Method Name : "+ request.getMethod());
        System.out.println("Context Path : "+ request.getContextPath());
        System.out.println("Servlet Path : "+ request.getServletPath());
        System.out.println("Path Info : "+ request.getPathInfo());
        System.out.println("Query String : "+ request.getQueryString());
        System.out.println("Protocol : "+ request.getProtocol());
        System.out.println("Scheme : "+ request.getScheme());
        System.out.println("URI : "+ request.getRequestURI());
        System.out.println("URL : "+ request.getRequestURL());
        System.out.println("Path Translated : "+ request.getPathTranslated());
    }
}
