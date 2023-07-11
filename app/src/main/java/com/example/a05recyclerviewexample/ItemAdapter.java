package com.example.a05recyclerviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a05recyclerviewexample.databinding.ItemBinding;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ItemBinding binding;

    private List<Item> items;

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        binding = binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {

        Item item = items.get(position);
        holder.showInfo(item);

    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public void setData(List<Item> item) {

        this.items = item;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ItemBinding itemBinding;
        public ViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
            itemView.setOnClickListener(this);
        }

        public void showInfo(Item item) {

            Glide.with(itemView.getContext()).load(item.getUrl()).into(itemBinding.ivItem);
            binding.tvItem.setText(item.getName());
        }

        @Override
        // Se asigna comportamiento al método.
        public void onClick(View v) {
            int position = getLayoutPosition();
            Item item = items.get(position);

            // Se asigna la palabra solicitada.

           // notifyDataSetChanged();
            Toast.makeText(itemView.getContext(), "You clicked " + item, Toast.LENGTH_SHORT).show();

        }
    }
}
