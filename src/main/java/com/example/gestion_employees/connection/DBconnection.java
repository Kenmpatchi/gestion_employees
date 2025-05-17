package com.example.gestion_employees.connection;

import java.sql.*;

public class DBconnection {
    private final String url="jdbc:mysql://localhost:3306/db_employees";
    private final String username="root";
    private final String password=null;
    private Connection conn=null;
    private Statement st=null;
    private  ResultSet rs=null;
    public DBconnection()throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
    public void connect()throws SQLException {
        conn= DriverManager.getConnection(url,username,password);
    }

    public Connection getConn() {
        return conn;
    }

    public ResultSet getRs() {
        return rs;
    }

    public  Statement getSt() {
        return st;
    }
}
