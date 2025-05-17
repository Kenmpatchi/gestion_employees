package com.example.courses_management.user_servlets;

import com.example.courses_management.controllers.Cusers;
import com.example.courses_management.group_servlet.viewAllgroups;
import com.example.courses_management.group_servlet.viewGroups;
import com.example.courses_management.model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "account_servlet",value = "/account")
public class Account_servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
        try{
         String first_name=req.getParameter("first_name");
         String last_name =req.getParameter("last_name");
         String email=req.getParameter("email");
         int phone=Integer.parseInt(req.getParameter("phone"));
         String password=req.getParameter("password");
         String valpass=req.getParameter("valpass");
         if(!password.equals(valpass))throw new Exception("invalide password");
         user user=new user(first_name,last_name,email,phone,password);
            Cusers User=new Cusers();
            User.insert(user);
            new viewAllgroups(req,res);
        }
        catch(SQLException|ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        catch (Exception ex){
            System.err.println(ex.getMessage());
            req.getRequestDispatcher("index.jsp").forward(req,res);
        }
    }
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
        try{
            String email=req.getParameter("email");
            String password=req.getParameter("password");
            Cusers User=new Cusers();
            user data=User.selectOne(email);
            if(!password.equals(data.getPassword()))throw new Exception("invalide password");
            if(data.getRole().equals("admin")){
                new view_users(req,res);
            }
            else if(data.getRole().equals("manager")){
                new viewGroups(data.getId(),req,res);
            }
            else{
                new viewAllgroups(req,res);
            }
        }
        catch(SQLException|ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            req.getRequestDispatcher("login.jsp").forward(req,res);
        }
    }
}
