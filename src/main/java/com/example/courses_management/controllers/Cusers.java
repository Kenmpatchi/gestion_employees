package com.example.courses_management.controllers;

import com.example.courses_management.connection.DBconnection;
import com.example.courses_management.model.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Cusers {
    DBconnection db=new DBconnection();
    private Connection conn=null;
    private Statement st=db.getSt();
    private ResultSet rs=db.getRs();
    public Cusers() throws ClassNotFoundException, SQLException {
        db.connect();
        conn=db.getConn();
    }
    public void insert(user u)throws SQLException,Exception {
        st=conn.createStatement();
        rs=st.executeQuery("select count(*) from user where email='"+u.getEmail()+"'");
        rs.next();
        int nb=rs.getInt(1);
        if(nb==1)throw new Exception("invalide email");
        rs.close();
        st.executeUpdate("insert into user(first_name,last_name,email,phone,password,role)values('"+u.getFirst_name()+"','"+u.getLast_name()+ "','"+u.getEmail()+"','"+u.getPhone()+"','"+u.getPassword()+"','"+u.getRole()+"')");
    }
    public List<user> selectAll()throws SQLException{
        st=conn.createStatement();
        rs=st.executeQuery("select * from user");
        List<user> users=new ArrayList<>();
        while (rs.next()){
            users.add(new user(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7)));
        }
        return users;
    }
    public void change(int id,String role)throws SQLException{
        st=conn.createStatement();
        st.executeUpdate("update user set role='"+role+"'where user_id='"+id+"';");
    }
    public user selectOne(String email)throws SQLException,Exception{
        st=conn.createStatement();
        rs=st.executeQuery("select count(*) from user where email='"+email+"'");
        rs.next();
        int nb=rs.getInt(1);
        if(nb==0)throw new Exception("not found");
        rs.close();
        rs=st.executeQuery("select * from user where email='"+email+"'");
        rs.next();
        user data=new user(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
        return data;
    }
    public user selectbyid(int id)throws SQLException{
        st=conn.createStatement();
        rs=st.executeQuery("select * from user where user_id='"+id+"'");
        rs.next();
        user data=new user(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
        return data;
    }
    public void delete(int id)throws SQLException{
        st=conn.createStatement();
        st.executeUpdate("delete from task where group_id in (select group_id from study_group where manager_id = '"+id+"')");
        st.executeUpdate("delete from study_group where manager_id='"+id+"'");
        st.executeUpdate("delete from user where user_id='"+id+"'");
    }
    public void update(user u,int id)throws SQLException{
        st=conn.createStatement();
        st.executeUpdate("UPDATE user SET first_name='"+u.getFirst_name()+"', last_name='"+u.getLast_name()+"', email='"+u.getEmail()+"', phone='"+u.getPhone()+"', password='"+u.getPassword()+"',role='"+u.getRole()+"' WHERE user_id='"+id+"';");
    }
}
