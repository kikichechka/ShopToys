package com.example.shoptoys.model;

public interface ToyMapper {
    String mapToString(Toy toy);
    Toy mapToToy(String line);
}
