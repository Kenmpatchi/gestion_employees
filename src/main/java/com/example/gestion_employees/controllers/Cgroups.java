package com.example.gestion_employees.controllers;

import com.example.gestion_employees.connection.DBconnection;
import com.example.gestion_employees.model.group;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Cgroups {
    DBconnection db=new DBconnection();
    private Connection conn=null;
    private Statement st=db.getSt();
    private ResultSet rs=db.getRs();
    public Cgroups() throws ClassNotFoundException, SQLException {
        db.connect();
        conn=db.getConn();
    }
    public void insert(group g)throws SQLException {
        st=conn.createStatement();
        st.executeUpdate("insert into study_group(manager_id,name,theme)values('"+g.getManager_id()+"','"+g.getNamegroup()+ "','"+g.getTheme()+"')");
    }
    public List<group> selectAllbyid(int id)throws SQLException{
        st=conn.createStatement();
        rs=st.executeQuery("select * from study_group where manager_id='"+id+"'");
        List<group> groups=new ArrayList<>();
        while (rs.next()){
            groups.add(new group(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4)));
        }
        return groups;
    }
    public List<group> selectAll()throws SQLException{
        st=conn.createStatement();
        rs=st.executeQuery("select * from study_group");
        List<group> groups=new ArrayList<>();
        while (rs.next()){
            groups.add(new group(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4)));
        }
        return groups;
    }
    public void delete(int id)throws SQLException{
        st=conn.createStatement();
        st.executeUpdate("delete from task where group_id='"+id+"'");
        st.executeUpdate("delete from study_group where group_id='"+id+"'");
    }
    public void update(group g)throws SQLException{
        st=conn.createStatement();
        st.executeUpdate("UPDATE study_group SET name='"+g.getNamegroup()+"', theme='"+g.getTheme()+"' WHERE group_id='"+g.getGroup_id()+"';");
    }
}
