package com.example.a05recyclerviewexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a05recyclerviewexample.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

private FragmentFirstBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(getLayoutInflater(), container, false);

        WordAdapter wordAdapter = new WordAdapter();
        wordAdapter.setData(getWords());

        binding.rvList.setAdapter(wordAdapter);
        binding.rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvList.addItemDecoration(new DividerItemDecoration(binding.rvList.getContext(),
                DividerItemDecoration.VERTICAL));

        return binding.getRoot();
    }

    public List<String> getWords() {
        List<String> words = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            words.add("Word " + i);
        }
        return words;
    }
}