package com.example.shoptoys.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoptoys.databinding.FragmentItemToyForChoosingListBinding;

import java.util.List;

public class AdapterListOfWinners extends RecyclerView.Adapter<AdapterListOfWinners.WinnersViewHolder> {

    private List<String> list;
    public AdapterListOfWinners(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public WinnersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FragmentItemToyForChoosingListBinding binding = FragmentItemToyForChoosingListBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new WinnersViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull WinnersViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class WinnersViewHolder extends RecyclerView.ViewHolder {
        FragmentItemToyForChoosingListBinding binding = FragmentItemToyForChoosingListBinding.bind(itemView);

        public WinnersViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(String str) {
            binding.nameToy.setText(str);
        }
    }
}
