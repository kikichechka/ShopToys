package com.example.shoptoys.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shoptoys.R;
import com.example.shoptoys.controller.ControllerViewListOfWinnersFragment;
import com.example.shoptoys.controller.ControllerViewListToysInStockFragment;
import com.example.shoptoys.databinding.FragmentShowWinnerBinding;
import com.example.shoptoys.model.Toy;

import java.util.Random;

public class ShowWinnerFragment extends Fragment {
    FragmentShowWinnerBinding binding;
    ControllerViewListToysInStockFragment controllerView = new ControllerViewListToysInStockFragment();
    ControllerViewListOfWinnersFragment controllerViewListOfWinners = new ControllerViewListOfWinnersFragment();
    private static final String KEY = "KEY";
    Random random = new Random();

    public static ShowWinnerFragment newInstance(Toy toy) {
        Bundle args = new Bundle();
        args.putParcelable(KEY, toy);
        ShowWinnerFragment fragment = new ShowWinnerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentShowWinnerBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        Toy toy = bundle.getParcelable(KEY);
        binding.nameToy.setText(toy.getName());

        String userName = "User_" + random.nextInt(1000);
        binding.nameWinner.setText(userName);
        controllerViewListOfWinners.updateListOfWinners(userName, getContext());

        binding.exit.setOnClickListener(view1 -> {
            controllerView.changeToyInStock(toy, getContext());

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_main_container, ListToysInStockFragment.newInstance())
                    .commit();
        });
    }
}
