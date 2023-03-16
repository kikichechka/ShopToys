package com.example.shoptoys.controller;
import android.content.Context;
import com.example.shoptoys.model.Toy;
import com.example.shoptoys.repo.FileOperableImpl;
import java.util.List;

public class ControllerViewListToysInStockFragment {
    private final String file = "text.txt";
    private final FileOperableImpl repoStockToys = new FileOperableImpl(file);

    public List<Toy> showAllToyInStock(Context context) {
        return repoStockToys.getListToys(context);
    }

    public void addToyInStock(Context context, Toy toy) {
        repoStockToys.addToy(toy, context);
    }

    public void deleteToyInStock(int id, Context context) {
        repoStockToys.deleteToy(id, context);
    }

    public void changeToyInStock(Toy toy, Context context) {
        if (toy.getQuantity() > 1) {
            List<Toy> list = repoStockToys.getListToys(context);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().equals(toy.getName())) {
                    int newQuantity = list.get(i).getQuantity() - 1;
                    list.get(i).setQuantity(newQuantity);
                    break;
                }
            }
            repoStockToys.addListToy(list, context);
        } else {
            deleteToyInStock(toy.getId(), context);
        }

    }
}
