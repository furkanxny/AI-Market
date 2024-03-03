package com.example.farmermarket.Models;

public class Person {
    private String Name;
    private String Email;
    private String Password;

    public Person() {
    }

    public Person(String name, String email, String password) {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

}
