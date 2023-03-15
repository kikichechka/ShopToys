package com.example.shoptoys.model;

public class ToyMapperImpl implements ToyMapper{
    @Override
    public String mapToString(Toy toy) {
        return String.format("%s|%s|%s|%s", toy.getId(), toy.getName(), toy.getQuantity(), toy.getWinningFrequency());
    }

    @Override
    public Toy mapToToy(String line) {
        String[] lines = line.split("\\|");
        return new Toy(lines[1], Integer.parseInt(lines[2]), Integer.parseInt(lines[3]));
    }
}
