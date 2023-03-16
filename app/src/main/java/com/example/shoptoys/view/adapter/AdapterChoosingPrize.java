package com.example.shoptoys.view.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoptoys.databinding.FragmentItemToyForChoosingListBinding;
import com.example.shoptoys.model.Toy;

import java.util.List;

public class AdapterChoosingPrize extends RecyclerView.Adapter<AdapterChoosingPrize.ChoosingViewHolder> {

    private List<Toy> list;
    public AdapterChoosingPrize(List<Toy> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ChoosingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FragmentItemToyForChoosingListBinding binding = FragmentItemToyForChoosingListBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ChoosingViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ChoosingViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ChoosingViewHolder extends RecyclerView.ViewHolder {
        FragmentItemToyForChoosingListBinding binding = FragmentItemToyForChoosingListBinding.bind(itemView);

        public ChoosingViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Toy toy) {
            binding.nameToy.setText(toy.getName());
        }
    }
}
