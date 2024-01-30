package com.example.finalproject;

public class User {
    String email;
    String password;
    String fullName;
    String occupation;
    String location;
    public User() {
    }
    public User(String email,String Password){
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String fullName, String occupation, String location) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.occupation = occupation;
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
