package com.iappsan.fixi.demo.models.dto;

public class User {

    private String id;
    private String name;
    private String lastName;
    private String phone;
    
    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.phone = null;
        this.id = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return name + " " + lastName;
    }

}
