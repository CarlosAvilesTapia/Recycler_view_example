package com.example.a05recyclerviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a05recyclerviewexample.databinding.ItemBinding;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private ItemBinding binding;

    private List<String> words;

    @NonNull
    @Override
    public WordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        binding = binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.ViewHolder holder, int position) {
        
        String item = words.get(position);
        holder.showInfo(item);
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    public void setData(List<String> words) {
        this.words = words;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ItemBinding itemBinding;
        public ViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
            itemView.setOnClickListener(this);
        }

        public void showInfo(String words) {
            binding.tvWords.setText(words);
        }

        @Override
        // Se asigna comportamiento al método.
        public void onClick(View v) {
            int position = getLayoutPosition();
            String item = words.get(position);

            // Se asigna la palabra solicitada.
            words.set(position, "Clicked " + item);
            notifyDataSetChanged();
            Toast.makeText(itemView.getContext(), "You clicked " + item, Toast.LENGTH_SHORT).show();

        }
    }
}
