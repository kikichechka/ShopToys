package com.example.shoptoys.view;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.shoptoys.R;
import com.example.shoptoys.controller.ControllerViewChoosingPrizeFragment;
import com.example.shoptoys.databinding.FragmentChoosingPrizeBinding;
import com.example.shoptoys.model.Toy;
import com.example.shoptoys.view.adapter.AdapterChoosingPrize;

import java.util.List;

public class ChoosingPrizeFragment extends Fragment {
    FragmentChoosingPrizeBinding binding;
    ControllerViewChoosingPrizeFragment controllerView = new ControllerViewChoosingPrizeFragment();

    public static ChoosingPrizeFragment newInstance() {
        return new ChoosingPrizeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentChoosingPrizeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showListChoosingPrize();

        binding.generateListOfRaffledToys.setOnClickListener(view1 -> generateListChoosingPrize());

        binding.playToy.setOnClickListener(view12 -> {
            List<Toy> list = controllerView.showAllToyChoosingPrize(requireContext());
            deleteToy(list);
        });

        binding.buttonCancel.setOnClickListener(view1 -> requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_container, ListToysInStockFragment.newInstance())
                .commit());
    }

    public void generateListChoosingPrize() {
        List<Toy> list = controllerView.showAllToyChoosingPrize(requireContext());

        if (list.size() == 0) {
            controllerView.choosingPrizeToy(getContext());
            showListChoosingPrize();
        } else {
            Toast.makeText(requireContext(), "Список уже сформирован", Toast.LENGTH_LONG).show();
        }
    }

    public void showListChoosingPrize() {
        List<Toy> list = controllerView.showAllToyChoosingPrize(requireContext());
        AdapterChoosingPrize adapter = new AdapterChoosingPrize(list);
        binding.scroll.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.scroll.setAdapter(adapter);
    }

    public void deleteToy(List<Toy> list) {
        if (list.size() != 0) {
            controllerView.deleteToy(list.get(0).getId(), requireContext());

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_main_container, ShowWinnerFragment.newInstance(list.get(0)))
                    .commit();
        } else {
            Toast.makeText(requireContext(), "Невозможно провести розыгрыш, сформируйте список", Toast.LENGTH_LONG).show();
        }
    }
}
