package com.example.a05recyclerviewexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a05recyclerviewexample.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

private FragmentFirstBinding binding;
List<String> wordList = getWordList();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(getLayoutInflater(), container, false);

        // Instancia del adaptador.
        WordAdapter wordAdapter = new WordAdapter();

        // Se aplica el método de llenado al adaptador.
        wordAdapter.setData(wordList);

        // Se setea el método en el recycler view del fragment.
        binding.rvList.setAdapter(wordAdapter);

        // Se setea el Layout manager como uno de tipo lineal.
        binding.rvList.setLayoutManager(new LinearLayoutManager(getContext()));

        // Se agrega un decorativo tipo línea divisoria.
        binding.rvList.addItemDecoration(new DividerItemDecoration(binding.rvList.getContext(),
                DividerItemDecoration.VERTICAL));

        // Se agrega el botón flotante.
        binding.fabAddWord.setOnClickListener(v -> {

            // Agrega elemento al listado.
            wordList.add("Word " + wordList.size());
            binding.rvList.getAdapter().notifyItemInserted(wordList.size());
            binding.rvList.smoothScrollToPosition(wordList.size());
        });

        return binding.getRoot();
    }

    // Método para rellenar listado de palabras.
    public List<String> getWordList() {
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            words.add("Word " + i);
        }
        return words;
    }
}
