package com.example.gestion_employees.user_servlets;

import com.example.gestion_employees.controllers.Cusers;
import com.example.gestion_employees.model.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class view_users {
    public view_users(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
        try{
            Cusers User=new Cusers();
            String users="<table>";
            for(user usr:User.selectAll()){
                users+="<tr><td>"+usr.getFirst_name()+"</td><td>"+usr.getLast_name()+"</td><td>"+usr.getEmail()+"</td>" +
                        "<td><form action='role' method='post'><select name='change_role'><option selected disabled>"+usr.getRole()+"</option><option>manager</option><option>employee</option><option>admin</option></select>" +
                        "<input type='hidden' name='id' value="+usr.getId()+"><input type='submit' value='change'></form></td>" +
                        "<td><form action='UserSetting' method='get'><input type='hidden' name='id' value="+usr.getId()+"><input type='submit' value='delete'></form></td>" +
                        "<td><form action='UserSetting' method='post'><input type='hidden' name='id' value="+usr.getId()+"><input type='submit' value='view'></form>" +
                        "</td></tr>";
            }
            users+="</table>";
            req.setAttribute("users",users);
            req.getRequestDispatcher("role.jsp").forward(req,res);
        }
        catch (SQLException|ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
