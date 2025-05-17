package com.example.gestion_employees.user_servlets;

import com.example.gestion_employees.controllers.Cusers;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Role_servlet",value="/role")
public class Role_servlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
        try{
            String role=req.getParameter("change_role");
            int id=Integer.parseInt(req.getParameter("id"));
            Cusers up=new Cusers();
            up.change(id,role);
            new view_users(req,res);

        }
        catch (SQLException|ClassNotFoundException e){
            throw new RuntimeException(e);
        }



    }
}
