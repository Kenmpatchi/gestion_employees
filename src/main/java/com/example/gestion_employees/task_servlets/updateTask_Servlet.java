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
@WebServlet(name = "updateTask_Servlet",value="/updateTask")
public class updateTask_Servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
        try{
            int task_id= Integer.parseInt(req.getParameter("task_id"));
            String Name=req.getParameter("name");
            String title=req.getParameter("title");
            String description=req.getParameter("description");
            String main_content=req.getParameter("main_content");
            task c=new task(Name,title,description,main_content);
            Ctasks Cc=new Ctasks();
            Cc.update(c,task_id);
            new viewTasks(Cc.selectbyid(task_id).getGroup_id(),req,res);
        }
        catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("id",id);
        req.getRequestDispatcher("Mupdate_task.jsp").forward(req, res);
    }
}
