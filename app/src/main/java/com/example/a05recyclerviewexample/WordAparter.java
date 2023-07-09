package com.example.a05recyclerviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a05recyclerviewexample.databinding.ItemBinding;

import java.util.List;

public class WordAparter extends RecyclerView.Adapter<WordAparter.ViewHolder> {

    private ItemBinding binding;

    private List<String> words;

    @NonNull
    @Override
    public WordAparter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        binding = binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAparter.ViewHolder holder, int position) {
        
        String item = words.get(position);
        holder.showInfo(item);

    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ItemBinding itemBinding;
        public ViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
        }

        public void showInfo(String words) {
            binding.tvWords.setText(words);
        }
    }


}
