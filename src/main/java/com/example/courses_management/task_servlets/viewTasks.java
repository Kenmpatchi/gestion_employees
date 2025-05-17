package com.example.courses_management.task_servlets;

import com.example.courses_management.controllers.Ctasks;
import com.example.courses_management.model.task;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class viewTasks {
    public viewTasks(int group_id, HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
        try {
            Ctasks Cc = new Ctasks();
            String tasks = "<table border=1>";
            for (task c : Cc.selectAll(group_id)) {
                tasks += "<tr><td>" + c.getName() + "</td>" +
                        "<td><form action='deleteCourse' method='post'>" +
                        "    <input type='hidden' name='task_id' value='"+c.gettask_id()+"'>" +
                        "    <input type='submit' value='delete'>" +
                        "</form></td>" +
                        "<td><form action='viewCourse' method='get'>" +
                        "<input type='hidden' name='task_id' value='"+c.gettask_id()+"'>" +
                        "<input type='submit' value='view'>" +
                        "</form></td></tr>" +
                        "<td><button><a href='Mupdate_task.jsp?task_id="+c.gettask_id()+"'>update</a></button></td></tr>";
            }
            tasks += "</table>";
            req.setAttribute("tasks", tasks);
            req.setAttribute("group_id",group_id);
            req.getRequestDispatcher("Mview_tasks.jsp").forward(req, res);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
