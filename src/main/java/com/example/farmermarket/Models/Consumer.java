package com.example.farmermarket.Models;

public class Consumer {

    public static final Consumer consumer = null;
    private static Consumer instance = null;
    public String name;

    public Consumer() {
        super();
    }

    public static Consumer getInstance() {
        if (instance == null) {
            instance = new Consumer();
        }
        return instance;
    }


    public String getName(){return name;}
    public void setName(String name) {
        this.name = name;
    }



}
