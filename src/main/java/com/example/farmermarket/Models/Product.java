package com.example.farmermarket.Models;

public class Product {
   private String name;
    private int quantity;
    private int calorie;
    private double price;
    private String kind;

    public Product(String name, int quantity, int calorie, String kind){
        this.name = name;
        this.kind = kind;
        this.quantity = quantity;
        this.calorie = calorie;
        this.price = price;
    }

    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(){
        this.calorie = calorie;
    }
    public int getCalorie(){
        return calorie;
    }

    public void setCalorie(){
        this.name = name;
    }
}
