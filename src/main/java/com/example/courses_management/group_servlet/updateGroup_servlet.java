package com.example.courses_management.group_servlet;

import com.example.courses_management.controllers.Cgroups;
import com.example.courses_management.model.group;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="updateGroup_servlet",value="/update")
public class updateGroup_servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
        try {
            int manager_id=Integer.parseInt(req.getParameter("manager_id"));
            int group_id=Integer.parseInt(req.getParameter("group_id"));
            String name=req.getParameter("name");
            String theme=req.getParameter("theme");
            group g=new group(group_id,manager_id,name,theme);
            Cgroups Cg=new Cgroups();
            Cg.update(g);
            new viewGroups(manager_id,req,res);
        }
        catch(SQLException|ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
