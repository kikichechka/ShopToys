package com.example.shoptoys.view.adapter;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shoptoys.databinding.FragmentItemToyForListToysInStockBinding;
import com.example.shoptoys.model.Toy;
import java.util.List;

public class AdapterListStock extends RecyclerView.Adapter<AdapterListStock.ToyViewHolder> {

    public interface ButtonDeleteToyClicked {
        void buttonDeleteToyClicked(Toy toy);
    }

    private ButtonDeleteToyClicked buttonDeleteToyClicked;
    public ButtonDeleteToyClicked getButtonDeleteToyClicked() {
        return buttonDeleteToyClicked;
    }
    public void setButtonDeleteToyClicked(ButtonDeleteToyClicked buttonDeleteToyClicked) {
        this.buttonDeleteToyClicked = buttonDeleteToyClicked;
    }

    private List<Toy> list;
    public AdapterListStock(List<Toy> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ToyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FragmentItemToyForListToysInStockBinding binding = FragmentItemToyForListToysInStockBinding.inflate(LayoutInflater.from(parent.getContext()));
        ToyViewHolder toyViewHolder = new ToyViewHolder(binding.getRoot());
        return toyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToyViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class ToyViewHolder extends RecyclerView.ViewHolder {
        FragmentItemToyForListToysInStockBinding binding = FragmentItemToyForListToysInStockBinding.bind(itemView);
        public ToyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding.buttonDeletePosition.setOnClickListener(view -> {
                if (getButtonDeleteToyClicked() != null) {
                    int click = getAdapterPosition();
                    getButtonDeleteToyClicked().buttonDeleteToyClicked(list.get(click));
                }
            });
        }
        @SuppressLint("SetTextI18n")
        public void bind(Toy toy) {
            binding.itemNameToy.setText(toy.getName());
            binding.quantityToy.setText(toy.getQuantity() + " шт");
        }
    }
}
