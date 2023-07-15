package com.example.a05recyclerviewexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a05recyclerviewexample.databinding.ItemBinding;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> items;

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
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

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private ItemBinding itemBinding;
        public ViewHolder(@NonNull ItemBinding binding) {

            super(binding.getRoot());
            itemBinding = binding;
            itemBinding.cvItem.setOnClickListener(this); // Se asigna binding para click.

            // Se asigna binding al mismo elemento para un long click.
            itemBinding.cvItem.setOnLongClickListener(this);
        }

        public void showInfo(Item item) {

            // Se implementa Glide al adaptador.
            Glide.with(itemView.getContext()).load(item.getUrl()).into(itemBinding.ivItem);
            itemBinding.tvItem.setText(item.getName());
        }

        @Override
        public void onClick(View v) { // Se asigna funcionalidad al click

            int position = getLayoutPosition();
            Item item = items.get(position);
            Toast.makeText(itemView.getContext(), "You clicked the photo of " + item.getName(), Toast.LENGTH_SHORT).show();

        }
        @Override
        public boolean onLongClick(View v) { // Se asigna funcionalidad al long click.

            int position = getLayoutPosition();
            Item item = items.get(position);

            // Se implementa navigation para pasar información al SecondFragment.
            Bundle bundle = new Bundle();
            bundle.putString("Url", item.getUrl());
            bundle.putString("Name", item.getName());
            Navigation.findNavController(itemBinding.getRoot()).
                    navigate(R.id.action_firstFragment_to_secondFragment, bundle);

            return true;
        }
    }
}
