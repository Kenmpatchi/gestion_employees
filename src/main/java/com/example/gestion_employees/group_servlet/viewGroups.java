package com.example.gestion_employees.group_servlet;

import com.example.gestion_employees.controllers.Cgroups;
import com.example.gestion_employees.model.group;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class viewGroups {
    public viewGroups(int manager_id,HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
        try{
            Cgroups Cg=new Cgroups();
            String groups="<table>";
            for(group g:Cg.selectAllbyid(manager_id)){
                groups+="<tr><td>"+g.tostring()+"</td>"+
                        "<td><form action='Groupsetting' method='post'><input type='hidden' name='manager_id' value="+g.getManager_id()+"><input type='hidden' name='group_id' value="+g.getGroup_id()+"><input type='submit' value='delete'></form></td>" +
                        "<td><a href='Mupdate_groups.jsp?manager_id="+g.getManager_id()+"&group_id="+g.getGroup_id()+"'>update</a>" +
                        "</td><td><form action='view' method='get'><input type='hidden' name='group_id' value="+g.getGroup_id()+"><input type='submit' value='view'></form>" +
                        "</td></tr>";
            }
            groups+="</table>";
            req.setAttribute("groups",groups);
            req.setAttribute("manager_id",manager_id);
            req.getRequestDispatcher("Mview_groups.jsp").forward(req,res);
    }
        catch (SQLException|ClassNotFoundException e){
        throw new RuntimeException(e);
    }
    }
}
