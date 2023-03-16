package com.example.shoptoys.controller;
import android.content.Context;
import com.example.shoptoys.repo.FileStringOperableImpl;

import java.util.List;

public class ControllerViewListOfWinnersFragment {
    private final String file = "list_winners.txt";
    private final FileStringOperableImpl repoListWinners = new FileStringOperableImpl(file);

    public List<String> showListOfWinners(Context context) {
        return repoListWinners.getList(context);
    }

    public void updateListOfWinners(String str, Context context) {
        repoListWinners.updateList(str, context);
    }
}
