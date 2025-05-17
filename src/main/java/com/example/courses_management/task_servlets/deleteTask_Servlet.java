package com.example.courses_management.task_servlets;

import com.example.courses_management.controllers.Ctasks;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="deleteTask_Servlet",value = "/deleteCourse")
public class deleteTask_Servlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
        try{
            int task_id=Integer.parseInt(req.getParameter("task_id"));
            Ctasks cc=new Ctasks();
            int group_id=cc.selectbyid(task_id).getGroup_id();
            cc.delete(task_id);
            new viewTasks(group_id,req,res);
        }
        catch(SQLException|ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
