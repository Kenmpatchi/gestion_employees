package com.example.gestion_employees.task_servlets;

import com.example.gestion_employees.controllers.Ctasks;
import com.example.gestion_employees.model.task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addTask_Servlet",value = "/addTask")
public class addTask_Servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
        try{
            int group_id=Integer.parseInt(req.getParameter("group_id"));
            String Name=req.getParameter("name");
            String title=req.getParameter("title");
            String description=req.getParameter("description");
            String main_content=req.getParameter("main_content");
            task c=new task(Name,title,description,main_content);
            Ctasks Cc=new Ctasks();
            Cc.insert(c,group_id);

            new viewTasks(group_id,req,res);
        }
        catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }

}
