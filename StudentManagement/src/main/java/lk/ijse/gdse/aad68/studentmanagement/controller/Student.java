package lk.ijse.gdse.aad68.studentmanagement.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.aad68.studentmanagement.dto.StudentDTO;
import lk.ijse.gdse.aad68.studentmanagement.util.Util;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/student")
public class Student extends HttpServlet {

    Connection connection;
    public static String SAVE_STUDENT = "INSERT INTO student (id,name,email,level) VALUES (?,?,?,?)";

    @Override
    public void init() throws ServletException {
//        var initParam = getServletContext().getInitParameter("myparam");
//        System.out.println(initParam);
        try {
//            var dbClass = getServletContext().getInitParameter("db-class");
//            var dbUrl = getServletContext().getInitParameter("dburl");
//            var dbUserName = getServletContext().getInitParameter("db-username");
//            var dbPassword = getServletContext().getInitParameter("password");
//            Class.forName(dbClass);
//            this.connection = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);

            var ctx = new InitialContext();
            DataSource pool = (DataSource) ctx.lookup()
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo: get student
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo: save student
        //***param widiyata
//        var id = req.getParameter("id");
//        var name = req.getParameter("name");
//        var email = req.getParameter("email");
//        var level = req.getParameter("level");
//
//        System.out.println(id);
//        System.out.println(name);
//        System.out.println(email);
//        System.out.println(level);

        //***body eke json hadala
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
//            req null or not application/json type
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }


        //***read req
//        BufferedReader reader = req.getReader();

        //***string eka hadala pennanna - json eke thiyena tika
//        StringBuilder sb = new StringBuilder();

//        ***line by line read karano.line ekk iwara wuanma new line ekkt yano
//        reader.lines().forEach(line -> sb.append(line).append("\n"));
//        System.out.println(sb);


//        ***process the JSON
//        JsonReader reader = Json.createReader(req.getReader());

//        JsonObject jsonObject = reader.readObject();
//        String email = jsonObject.getString("email");
//        System.out.println(email);


        //optional - JSON array processing
//        JsonArray jsonValues = reader.readArray();
//        for (int i = 0; i < jsonValues.size(); i++) {
//            var jsonObj = jsonValues.getJsonObject(i);
//            System.out.println(jsonObj.getString("name"));
//            System.out.println(jsonObj.getString("email"));
//        }

        //***send data to the client
//        var writer = resp.getWriter();
//        writer.write(email);

        //object binding of the JSON
        try (var writer = resp.getWriter()){
            Jsonb jsonb = JsonbBuilder.create();
//        var writer = resp.getWriter();
            StudentDTO student = jsonb.fromJson(req.getReader(), StudentDTO.class);
            student.setId(Util.idGenerate());
            System.out.println(student);
//        writer.write(jsonb.toJson(studentDTO.toString()));

            //*****save data in db

            var ps = connection.prepareStatement(SAVE_STUDENT);
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getLevel());

            if (ps.executeUpdate()!= 0){
                resp.setStatus(HttpServletResponse.SC_CREATED);
                writer.write("save student successfully");
            }else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                writer.write("failed to save student");
            }

//        create response
//            resp.setContentType("application/json");
//            jsonb.toJson(student, writer);

        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo: update student
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo: delete student
    }
}
