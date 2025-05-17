package com.example.courses_management.user_servlets;

import com.example.courses_management.controllers.Cusers;
import com.example.courses_management.model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="settingUser_servlet",value = "/UserSetting")
public class settingUser_servlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
        try{
            int id=Integer.parseInt(req.getParameter("id"));
            Cusers user=new Cusers();
            user aff=user.selectbyid(id);
            req.setAttribute("aff",aff.tostring());
            req.getRequestDispatcher("view_user.jsp").forward(req,res);
        }
        catch(SQLException|ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
        try{
            int id=Integer.parseInt(req.getParameter("id"));
            Cusers u=new Cusers();
            u.delete(id);
            new view_users(req,res);
        }
        catch(SQLException|ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
