package com.example.shoptoys.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shoptoys.R;
import com.example.shoptoys.databinding.FragmentChoosingPrizeBinding;

public class ChoosingPrizeFragment extends Fragment {
    FragmentChoosingPrizeBinding binding;

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
        binding.generateListOfRaffledToys.setOnClickListener(view1 -> {

        });

        Button buttonPlay = binding.playToy;
        buttonPlay.setOnClickListener(view1 -> requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_container, ShowWinnerFragment.newInstance())
                .commit());
    }
}
