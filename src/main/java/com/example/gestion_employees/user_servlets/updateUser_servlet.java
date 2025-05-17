package com.example.gestion_employees.user_servlets;

import com.example.gestion_employees.controllers.Cusers;
import com.example.gestion_employees.model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="updateUser_servlet",value="/updateUser")
public class updateUser_servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
        try{
            Cusers up=new Cusers();
            int id=Integer.parseInt(req.getParameter("id"));
            String first_name=req.getParameter("first_name");
            String last_name =req.getParameter("last_name");
            String email=req.getParameter("email");
            int phone=Integer.parseInt(req.getParameter("phone"));
            String password=req.getParameter("password");
            String OldPassword=req.getParameter("OldPassword");
            String valpass=up.selectbyid(id).getPassword();
            if(!valpass.equals(OldPassword))throw new Exception("invalide password");
            user u=new user(first_name,last_name,email,phone,password);

            up.update(u,id);
        }
        catch(SQLException|ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        catch(Exception ex){

        }
    }

}
