package com.example.shoptoys.controller;
import android.content.Context;
import com.example.shoptoys.model.Toy;
import com.example.shoptoys.repo.FileOperableImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ControllerViewChoosingPrizeFragment {
    final Random random = new Random();
    private final String fileChoosing = "choosing_prize.txt";
    private final FileOperableImpl repoChoosingToys = new FileOperableImpl(fileChoosing);

    private final String fileStock = "text.txt";
    private final FileOperableImpl repoStockToys = new FileOperableImpl(fileStock);


    public List<Toy> showAllToyChoosingPrize(Context context) {
        return repoChoosingToys.getListToys(context);
    }

    public void choosingPrizeToy(Context context) {
        List<Toy> list = repoStockToys.getListToys(context);
        List<Toy> newList = new ArrayList<>();

        for (Toy toy: list) {
            int winningFrequency = toy.getWinningFrequency() / 10;
            for (int i = 0; i < winningFrequency; i++) {
                newList.add(toy);
            }
        }

        List<Toy> randomList = new ArrayList<>();
        int elementCount = 10;
        for (int i = 0; i < elementCount; i++) {
            int randomIndex = random.nextInt(list.size());
            Toy randomElement = newList.get(randomIndex);
            randomList.add(randomElement);
        }
        repoChoosingToys.addListToy(randomList, context);
    }

    public void deleteToy(int id, Context context) {
        repoChoosingToys.deleteToy(id, context);
    }
}
