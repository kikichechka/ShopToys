package com.example.shoptoys.repo;

import android.content.Context;

import com.example.shoptoys.model.Toy;

import java.util.List;

public interface FileOperable {
    List<Toy> getListToys(Context context);
    void addToy(Toy toy, Context context);
    void deleteToy(int id, Context context);
}
