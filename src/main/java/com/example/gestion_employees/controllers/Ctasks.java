package com.example.gestion_employees.controllers;

import com.example.gestion_employees.connection.DBconnection;
import com.example.gestion_employees.model.task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Ctasks {
    DBconnection db=new DBconnection();
    private Connection conn=null;
    private Statement st=db.getSt();
    private ResultSet rs=db.getRs();

    public Ctasks() throws ClassNotFoundException, SQLException {
        db.connect();
        conn=db.getConn();
    }
    public void insert(task c, int id)throws SQLException {
        st=conn.createStatement();
        st.executeUpdate("insert into task(name,title,description,main_content,group_id)values('"+c.getName()+"','"+c.getTitle()+ "','"+c.getDescription()+"','"+c.getMain_content()+"','"+id+"')");
    }
    public List<task> selectAll(int id)throws SQLException{
        st=conn.createStatement();
        rs=st.executeQuery("select * from task where group_id='"+id+"'");
        List<task> courses=new ArrayList<>();
        while (rs.next()){
            courses.add(new task( rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6)));
        }
        return courses;
    }
    public task selectbyid(int id)throws SQLException{
        st=conn.createStatement();
        rs=st.executeQuery("select * from task where task_id='"+id+"'");
        rs.next();
        task data=new task(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6));
        return data;
    }
    public void delete(int id)throws SQLException{
        st=conn.createStatement();
        st.executeUpdate("delete from task where task_id='"+id+"'");
    }
    public void update(task c, int id)throws SQLException{
        st=conn.createStatement();
        st.executeUpdate("UPDATE task SET name='"+c.getName()+"', title='"+c.getTitle()+"', description='"+c.getDescription()+"', main_content='"+c.getMain_content()+"' WHERE task_id='"+id+"';");
    }
}
