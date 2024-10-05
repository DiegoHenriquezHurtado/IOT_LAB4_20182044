package com.example.telefutbol;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.telefutbol.databinding.FragmentLigasBinding;

public class LigasFragment extends Fragment {

    FragmentLigasBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLigasBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_ligas, container, false);

        NavController navController = NavHostFragment.findNavController(LigasFragment.this);

        binding.btnPosiciones.setOnClickListener(view -> {
            navController.navigate(R.id.action_ligasFragment_to_posicionesFragment);
        });

        binding.btnResultados.setOnClickListener(view -> {
            navController.navigate(R.id.action_ligasFragment_to_resultadosFragment);
        });

        return binding.getRoot();
    }
}