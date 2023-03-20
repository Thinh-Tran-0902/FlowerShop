package com.example.flowershop.models;

public class CartDb {
    private String id;
    private String floweridquantity;

    public CartDb() {
    }

    public CartDb(String id, String floweridquantity) {
        this.id = id;
        this.floweridquantity = floweridquantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFloweridquantity() {
        return floweridquantity;
    }

    public void setFloweridquantity(String floweridquantity) {
        this.floweridquantity = floweridquantity;
    }
}
