package com.example.shoptoys.repo;

import android.content.Context;

import com.example.shoptoys.model.Toy;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileOperable {
    List<Toy> getListToys(Context context);
    void addToy(Toy toy, Context context) throws FileNotFoundException;
    void addListToy(List<Toy> list, Context context);
    void deleteToy(int id, Context context);
}
