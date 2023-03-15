package com.example.shoptoys.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shoptoys.R;
import com.example.shoptoys.controller.ControllerView;
import com.example.shoptoys.databinding.FragmentAddNewToyInStockBinding;
import com.example.shoptoys.model.Toy;

public class AddNewToyInStockFragment extends Fragment {
    FragmentAddNewToyInStockBinding binding;
    ControllerView controllerView = new ControllerView();
//    EditText editTextNameToy;
//    EditText editTextQuantityToy;
//    EditText editTextWinningFrequencyToy;
    Button buttonSaveToy;
    Button buttonCancel;

    public static AddNewToyInStockFragment newInstance() {
        return new AddNewToyInStockFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddNewToyInStockBinding.inflate(LayoutInflater.from(getContext()));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        editTextNameToy = binding.nameToy;
//        editTextQuantityToy = binding.quantityToy;
//        editTextWinningFrequencyToy = binding.winningFrequencyToy;
        buttonSaveToy = binding.buttonSaveAddedToy;
        buttonCancel = binding.buttonCancel;

        buttonSaveToy.setOnClickListener(view1 -> {
            saveToy();
        });

        buttonCancel.setOnClickListener(view1 -> {
            cancel();
        });
    }

    private void cancel() {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_container, ListToysInStockFragment.newInstance())
                .commit();
    }

    private void saveToy() {
        String name = binding.nameToy.getText().toString();
        String quantity = binding.quantityToy.getText().toString();
        String winningFrequency = binding.winningFrequencyToy.getText().toString();

        if (checkingStrings(name, quantity, winningFrequency)) {
            Toy toy = new Toy(name, Integer.parseInt(quantity), Integer.parseInt(winningFrequency));
            controllerView.addToyInStock(requireContext(), toy);
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_main_container, ListToysInStockFragment.newInstance())
                    .commit();
        } else {
            Toast.makeText(requireContext(), "Некорректные данные, позиция не сохранена.", Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkingStrings(String name, String quantity, String winningFrequency) {
        try {
            if (!name.equals("") && Integer.parseInt(quantity) > 0 && Integer.parseInt(winningFrequency) > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
