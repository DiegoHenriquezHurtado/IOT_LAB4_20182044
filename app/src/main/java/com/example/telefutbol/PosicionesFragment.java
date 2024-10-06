package com.example.telefutbol;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.telefutbol.Entity.Posiciones;
import com.example.telefutbol.Entity.Table;
import com.example.telefutbol.adapter.PosicionesAdapter;
import com.example.telefutbol.databinding.FragmentLigasBinding;
import com.example.telefutbol.databinding.FragmentPosicionesBinding;
import com.example.telefutbol.services.SportsDbService;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PosicionesFragment extends Fragment {
    FragmentPosicionesBinding binding;
    SportsDbService sportsDbService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentPosicionesBinding.inflate(inflater,container,false);

        //Creacion de la interfaz para consumir la api
        sportsDbService = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SportsDbService.class);

        binding.btnBuscar.setOnClickListener(view -> {
            if(binding.idLiga.getText().toString().isEmpty() || binding.temporada.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Debe llenar los campos de texto" , Toast.LENGTH_LONG).show();
            }else{
                String idLiga = String.valueOf(binding.idLiga.getText());
                String pais = String.valueOf(binding.temporada.getText());
                sportsDbService.getPosiciones(idLiga,pais).enqueue(new Callback<Posiciones>() {
                    @Override
                    public void onResponse(Call<Posiciones> call, Response<Posiciones> response) {
                        if(response.isSuccessful()){
                            Posiciones posiciones = response.body();
                            Table[] lista =  posiciones.getTable();

                            PosicionesAdapter adapter = new PosicionesAdapter();
                            adapter.setContext(getContext());
                            adapter.setListaPosiciones(Arrays.asList(lista));

                            binding.rvPosiciones.setAdapter(adapter);
                            binding.rvPosiciones.setLayoutManager(new LinearLayoutManager(getContext()));

                        }else {
                            Log.d("msg-test","error en la respuesta del webservice");
                        }
                    }

                    @Override
                    public void onFailure(Call<Posiciones> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });

        return binding.getRoot();
    }
}