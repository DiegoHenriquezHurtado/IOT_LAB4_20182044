package com.example.telefutbol;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.telefutbol.databinding.FragmentResultadosBinding;


public class ResultadosFragment extends Fragment {

    FragmentResultadosBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentResultadosBinding.inflate(inflater,container,false);
        NavController navController = NavHostFragment.findNavController(ResultadosFragment.this);

        binding.btnLigas.setOnClickListener(view -> {
            navController.navigate(R.id.action_resultadosFragment_to_ligasFragment);
        });

        binding.btnPosiciones.setOnClickListener(view -> {
            navController.navigate(R.id.action_resultadosFragment_to_posicionesFragment);
        });

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_resultados, container, false);

        return binding.getRoot();
    }
}