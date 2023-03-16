package com.example.shoptoys.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.shoptoys.R;
import com.example.shoptoys.controller.ControllerViewListToysInStockFragment;
import com.example.shoptoys.databinding.FragmenListToysInStockBinding;
import com.example.shoptoys.model.Toy;
import com.example.shoptoys.view.adapter.AdapterListStock;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ListToysInStockFragment extends Fragment {
    ControllerViewListToysInStockFragment controllerView = new ControllerViewListToysInStockFragment();
    FragmenListToysInStockBinding binding;

    public static ListToysInStockFragment newInstance() {
        return new ListToysInStockFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmenListToysInStockBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton buttonAddToy = binding.buttonAddToyInStock;
        buttonAddToy.setOnClickListener(view1 -> requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_container, AddNewToyInStockFragment.newInstance())
                .commit());
        showListToysInStock();
    }

    public void showListToysInStock() {
        List<Toy> list = controllerView.showAllToyInStock(getContext());
        AdapterListStock adapterListStock = new AdapterListStock(list);
        adapterListStock.setButtonDeleteToyClicked(toy -> deleteToyInStock(toy.getId()));
        binding.scroll.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.scroll.setAdapter(adapterListStock);
    }

    public void deleteToyInStock(int id) {
        controllerView.deleteToyInStock(id, getContext());
        showListToysInStock();
    }
}
