package com.example.flowershop;

public class Users {
    private String username;
    private String password;
    private String name;
    private String address;
    private String gender;
    private int roleId;

    public Users(String username, String password, String name, String address, String gender, int roleId) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
