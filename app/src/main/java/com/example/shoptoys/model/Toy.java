package com.example.shoptoys.model;

public class Toy {
    private int id;
    private final String name;
    private int quantity;
    private int winningFrequency;

    public Toy(String name, int quantity, int winningFrequency) {
        this.name = name;
        this.quantity = quantity;
        this.winningFrequency = winningFrequency;
    }

    public Toy(int id, String name, int quantity, int winningFrequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.winningFrequency = winningFrequency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getWinningFrequency() {
        return winningFrequency;
    }

    public void setWinningFrequency(int winningFrequency) {
        this.winningFrequency = winningFrequency;
    }
}
