package com.example.shoptoys.model;

public interface ToyMapper {
    public String mapToString(Toy toy);
    public Toy mapToToy(String line);
}
