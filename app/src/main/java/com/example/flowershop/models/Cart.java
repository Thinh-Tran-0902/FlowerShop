package com.example.flowershop.models;

public class Cart {
    private int Cartid;
    private String name;
    private int price;
    private int quantity;

    private int img;

    public int getCartid() {
        return Cartid;
    }

    public void setCartid(int cartid) {
        Cartid = cartid;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Cart(int cartid, String name, int price, int quantity, int img) {
        Cartid = cartid;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.img = img;
    }
    public Cart(){

    }
}
