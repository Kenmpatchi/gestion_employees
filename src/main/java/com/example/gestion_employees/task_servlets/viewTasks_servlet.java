package com.example.gestion_employees.task_servlets;

import com.example.gestion_employees.controllers.Ctasks;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.gestion_employees.model.task;

import java.io.IOException;
import java.sql.SQLException;
@WebServlet(name = "viewTasks_servlet",value = "/view")
public class viewTasks_servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
        try {
            int group_id=Integer.parseInt(req.getParameter("group_id"));
            Ctasks Cc = new Ctasks();
            String tasks = "<table border=1>";
            for (task c : Cc.selectAll(group_id)) {
                tasks += "<tr><td>" + c.getName() + "</td>" +
                        "<td><form action='deleteCourse' method='post'>" +
                        "    <input type='hidden' name='group_id' value='"+c.gettask_id()+"'>" +
                        "    <input type='submit' value='delete'>" +
                        "</form></td>" +
                        "<td><form action='viewCourse' method='get'>" +
                        "<input type='hidden' name='group_id' value='"+c.gettask_id()+"'>" +
                        "<input type='submit' value='view'>" +
                        "</form></td>" +
                        "<td><button><a href='Mupdate_task.jsp?task_id="+c.gettask_id()+"'>update</a></button></td></tr>";
            }
            tasks += "</table>";
            req.setAttribute("courses", tasks);
            req.setAttribute("group_id",group_id);
            req.getRequestDispatcher("Mview_tasks.jsp").forward(req, res);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}