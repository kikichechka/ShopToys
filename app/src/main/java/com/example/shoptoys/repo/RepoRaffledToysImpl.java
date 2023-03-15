package com.example.shoptoys.repo;
import com.example.shoptoys.model.Toy;
import com.example.shoptoys.model.ToyMapperImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepoRaffledToysImpl implements RepoRaffledToys {
    private String fileName;
    private ToyMapperImpl toyMapper;

    public RepoRaffledToysImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void formList() {

    }

    @Override
    public List<Toy> getList() {
        return null;
    }
}
