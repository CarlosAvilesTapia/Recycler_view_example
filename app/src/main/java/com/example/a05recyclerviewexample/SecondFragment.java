package com.example.a05recyclerviewexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.a05recyclerviewexample.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private String mParam1;
    private String mParam2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("Url");
            mParam2 = getArguments().getString("Name");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSecondBinding.inflate(getLayoutInflater(), container, false);

        // Implementación de Glide para las imágenes
        Glide.with(getContext()).load(mParam1).into(binding.ivDetail);

        // binding del text view enviado desde el fragment anterior.
        binding.tvDetail.setText(mParam2);

        // Asignación del botón para volver al listado principal.
        binding.backButton.setOnClickListener(v ->
                Navigation.findNavController(getView()).
                navigate(R.id.action_secondFragment_to_firstFragment));

        return binding.getRoot();
    }
}