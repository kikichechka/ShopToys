package com.example.shoptoys.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shoptoys.R;
import com.example.shoptoys.databinding.FragmentShowWinnerBinding;

public class ShowWinnerFragment extends Fragment {
    FragmentShowWinnerBinding binding;

    public static ShowWinnerFragment newInstance() {
        return new ShowWinnerFragment();
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
        binding.nameToy.setText("");
        binding.nameWinner.setText("");
        binding.exit.setOnClickListener(view1 -> {
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_main_container, ListToysInStockFragment.newInstance())
                    .commit();
        });
    }
}
