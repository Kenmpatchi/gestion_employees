package com.example.gestion_employees.model;

public class user {
    private int user_id;
    private String role;
    private String first_name;
    private String last_name;
    private String email;
    private int phone;
    private String password;
    public user(String first_name, String last_name, String email, int phone, String password){
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
        this.phone=phone;
        this.password=password;
        this.role="employee";
    }
    public user(int id,String first_name,String last_name,int phone,String email,String password,String role){
        this.user_id=id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
        this.phone=phone;
        this.password=password;
        this.role=role;
    }

    public int getId() {
        return user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
    public String tostring(){
        return "name "+first_name+" "+last_name+" id "+user_id+" email "+email+" phone number "+phone+" he is a/an "+role;
    }
}
