package com.example.shoptoys.controller;
import android.content.Context;
import com.example.shoptoys.model.Toy;
import com.example.shoptoys.repo.FileOperableImpl;
import java.util.List;

public class ControllerView {
    private final String fileForListToysInStock = "text.txt";
    private final FileOperableImpl repoStockToys = new FileOperableImpl(fileForListToysInStock);
//    private Context context;

    public List<Toy> showAllToyInStock(Context context) {
        return repoStockToys.getListToys(context);
    }

    public void addToyInStock(Context context, Toy toy) {
        repoStockToys.addToy(toy, context);
    }

    public void deleteToyInStock(int id, Context context) {
        repoStockToys.deleteToy(id, context);
    }

    public void choosingPrizeToy() {
    }

    public void gettingPrizeToy() {
    }
}
