package com.example.flowershop.models;

import java.io.Serializable;

public class FlowerQuantity implements Serializable, Cloneable {
    private Flower flower;
    private int quantity;

    public FlowerQuantity() {
    }

    public FlowerQuantity(Flower flower, int quantity) {
        this.flower = flower;
        this.quantity = quantity;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public FlowerQuantity clone() {
        try {
            return (FlowerQuantity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
