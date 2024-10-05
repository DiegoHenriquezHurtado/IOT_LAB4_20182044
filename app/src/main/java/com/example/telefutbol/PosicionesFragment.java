package com.example.telefutbol;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.telefutbol.databinding.FragmentLigasBinding;
import com.example.telefutbol.databinding.FragmentPosicionesBinding;


public class PosicionesFragment extends Fragment {
    FragmentPosicionesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentPosicionesBinding.inflate(inflater,container,false);

        /*NavController navController = NavHostFragment.findNavController(PosicionesFragment.this);
        binding.btnLigas.setOnClickListener(view -> {
            navController.navigate(R.id.action_posicionesFragment_to_ligasFragment);
        });

        binding.btnResultados.setOnClickListener(view -> {
            navController.navigate(R.id.action_posicionesFragment_to_resultadosFragment);
        });*/

        return binding.getRoot();
    }
}