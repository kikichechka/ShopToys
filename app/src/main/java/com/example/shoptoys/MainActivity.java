package com.example.shoptoys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.shoptoys.databinding.ActivityMainBinding;
import com.example.shoptoys.view.ChoosingPrizeFragment;
import com.example.shoptoys.view.ListOfWinnersFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_choosing_prize_toy:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_main_container, ChoosingPrizeFragment.newInstance())
                        .commit();
                return true;
            case R.id.action_list_of_winners:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_main_container, ListOfWinnersFragment.newInstance())
                        .commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}