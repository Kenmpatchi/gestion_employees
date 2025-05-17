package com.example.courses_management.group_servlet;

import com.example.courses_management.controllers.Cgroups;
import com.example.courses_management.model.group;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class viewAllgroups {
    public viewAllgroups(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
        try{
            Cgroups Cg=new Cgroups();
            String groups="<table>";
            for(group g:Cg.selectAll()){
                groups+="<tr><td>"+g.tostring()+"</td>"+
                        "<td><form action='Student_view' method='get'><input type='hidden' name='group_id' value="+g.getGroup_id()+"><input type='submit' value='view'></form>" +
                        "</td></tr>";
            }
            groups+="</table>";
            req.setAttribute("groups",groups);
            req.getRequestDispatcher("Sview_groups.jsp").forward(req,res);
        }
        catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
