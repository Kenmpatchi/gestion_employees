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

@WebServlet(name = "StasksView_servlet",value="/Student_view")
public class StasksView_servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
        try{
            int group_id=Integer.parseInt(req.getParameter("group_id"));
            Ctasks Cc=new Ctasks();
            String tasks = "<table border=1>";
            for (task c : Cc.selectAll(group_id)) {
                tasks += "<tr><td>" + c.tostring() + "</td>" +
                        "<td><form action='viewTask' method='get'>" +
                        "<input type='hidden' name='task_id' value='"+c.gettask_id()+"'>" +
                        "<input type='submit' value='view'>" +
                        "</form></td></tr>";
            }
            tasks+="</table>";
            req.setAttribute("tasks",tasks);
            req.getRequestDispatcher("Sview_tasks.jsp").forward(req,res);
        }
        catch(SQLException|ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
