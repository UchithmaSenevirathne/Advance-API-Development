package lk.ijse.gdse68.helloservlet;

import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class HelloServlet extends HttpServlet {

    public HelloServlet() {
        System.out.println("Hello Servlet : constructor");
    }

    {
        System.out.println("Hello Servlet : instance");
    }

    static {
        System.out.println("Hello Servlet : static");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Hello Servlet : init(ServletConfig config)");
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Servlet : doGet()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Servlet : service()");
        super.service(req, resp);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Hello Servlet : init()");
    }
}