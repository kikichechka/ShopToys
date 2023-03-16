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
import com.example.shoptoys.controller.ControllerViewListOfWinnersFragment;
import com.example.shoptoys.databinding.FragmentListOfWinnersBinding;
import com.example.shoptoys.view.adapter.AdapterListOfWinners;

import java.util.List;

public class ListOfWinnersFragment extends Fragment {
    FragmentListOfWinnersBinding binding;
    ControllerViewListOfWinnersFragment controllerView = new ControllerViewListOfWinnersFragment();

    public static ListOfWinnersFragment newInstance() {
        return new ListOfWinnersFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListOfWinnersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showListOfWinners();

        binding.buttonClearList.setOnClickListener(view1 -> {
            controllerView.updateListOfWinners("", getContext());
            showListOfWinners();
        });

        binding.buttonClose.setOnClickListener(view1 -> requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_container, ListToysInStockFragment.newInstance())
                .commit());
    }

    private void showListOfWinners() {
        List<String> list = controllerView.showListOfWinners(requireContext());
        AdapterListOfWinners adapter = new AdapterListOfWinners(list);
        binding.scroll.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.scroll.setAdapter(adapter);
    }
}
