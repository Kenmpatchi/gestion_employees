package com.example.courses_management.task_servlets;

import com.example.courses_management.controllers.Ctasks;
import com.example.courses_management.model.task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "viewTask_servlet",value = "/viewCourse")
public class viewTask_servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
        try {
            int task_id=Integer.parseInt(req.getParameter("task_id"));
            Ctasks Cc = new Ctasks();
            task c=Cc.selectbyid(task_id);
            String name=c.getName();
            String task="<h1>"+c.getTitle()+"</h1><br>" +
                    "<h2>"+c.getDescription()+"</h2><br>" +
                    "<p>"+c.getMain_content()+"</p>";
            req.setAttribute("task",task);
            req.setAttribute("name",name);
            req.getRequestDispatcher("viewTask.jsp").forward(req, res);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
