package com.example.flowershop.models;

public class Flower {
    private int id;
    private int adminId;
    private int categoryId;
    private int img;
    private String name;
    private int price;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Flower(int id, int adminId, int categoryId, int img, String name, int price, String color) {
        this.id = id;
        this.adminId = adminId;
        this.categoryId = categoryId;
        this.img = img;
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public Flower() {
    }
}
