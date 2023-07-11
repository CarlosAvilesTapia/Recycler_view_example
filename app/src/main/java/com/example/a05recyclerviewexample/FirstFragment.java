package com.example.a05recyclerviewexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a05recyclerviewexample.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

private FragmentFirstBinding binding;
List<Item> items = getItemList();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(getLayoutInflater(), container, false);

        // Instancia del adaptador.
        ItemAdapter itemAdapter = new ItemAdapter();

        // Se aplica el método de llenado al adaptador.
        itemAdapter.setData(items);

        // Se setea el método en el recycler view del fragment.
        binding.rvList.setAdapter(itemAdapter);

        // Se setea el Layout manager como uno de tipo lineal.
        binding.rvList.setLayoutManager(new LinearLayoutManager(getContext()));

        // Se agrega un decorativo tipo línea divisoria.
        binding.rvList.addItemDecoration(new DividerItemDecoration(binding.rvList.getContext(),
                DividerItemDecoration.VERTICAL));

        // Se agrega el botón flotante.
        binding.fabAddWord.setOnClickListener(v -> {

            // Agrega elemento al listado.
          //  items.add("Word " + items.size());
            binding.rvList.getAdapter().notifyItemInserted(items.size());
            binding.rvList.smoothScrollToPosition(items.size());
        });

        return binding.getRoot();
    }

    // Método para rellenar listado de palabras.
    public List<Item> getItemList() {
        ArrayList<Item> listItem = new ArrayList<>();
        Item item01 = new Item("Zhuo Cheng you"
                ,"https://unsplash.com/photos/UBvtBr_FmrY/download?force=true&w=640");
        listItem.add(item01);
        Item item02 = new Item("billow926"
                ,"https://unsplash.com/photos/pNoP-qVwBFQ/download?force=true&w=640");
        listItem.add(item02);
        Item item03 = new Item("Philipp Deiß"
                ,"https://unsplash.com/photos/LfJx0gqqiEc/download?force=true&w=640");
        listItem.add(item03);
        Item item04 = new Item("Huper by Joshua Earle"
                ,"https://unsplash.com/photos/_p8gVNNsWw4/download?force=true&w=640");
        listItem.add(item04);
        Item item05 = new Item("Melnychuk Nataliya"
                ,"https://unsplash.com/photos/rnPGCe7LsQo/download?force=true&w=640");
        listItem.add(item05);
        Item item06 = new Item("Teagan Maddux"
                ,"https://unsplash.com/photos/k2DbTXQ0yrQ/download?force=true&w=640");
        listItem.add(item06);
        Item item07 = new Item("Chen Liu"
                ,"https://unsplash.com/photos/kZH8X0q4Nvo/download?force=true&w=640");
        listItem.add(item07);
        Item item08 = new Item("John Fornander"
                ,"https://unsplash.com/photos/iNqJxVOceI/download?force=true&w=640");
        listItem.add(item08);
        Item item09 = new Item("Parker Coffman"
                ,"https://unsplash.com/photos/mNWrQ9O6KZw/download?force=true&w=640");
        listItem.add(item09);
        Item item10 = new Item("XPS"
                ,"https://unsplash.com/photos/8pb7Hq539Zw/download?force=true&w=640");
        listItem.add(item10);
        Item item11 = new Item("Daniel J.Schwarz"
                ,"https://unsplash.com/photos/l8BvDmt8Ac4/download?force=true&w=640");
        listItem.add(item11);
        Item item12 = new Item("Wesley Armstrong"
                ,"https://unsplash.com/photos/q0wqYpyWDpc/download?force=true&w=640");
        listItem.add(item12);

        return listItem;
    }
}
