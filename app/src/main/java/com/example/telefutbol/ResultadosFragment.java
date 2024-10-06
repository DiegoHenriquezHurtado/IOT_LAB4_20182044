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

import com.example.telefutbol.Entity.Events;
import com.example.telefutbol.Entity.Resultados;
import com.example.telefutbol.adapter.ResultadosAdapter;
import com.example.telefutbol.databinding.FragmentResultadosBinding;
import com.example.telefutbol.services.SportsDbService;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ResultadosFragment extends Fragment {

    FragmentResultadosBinding binding;
    SportsDbService sportsDbService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentResultadosBinding.inflate(inflater,container,false);

        //Creacion de la interfaz para consumir la api
        sportsDbService = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SportsDbService.class);
        binding.btnBuscar.setOnClickListener(view -> {
            if(binding.idLiga.getText().toString().isEmpty() || binding.temporada.getText().toString().isEmpty() || binding.ronda.getText().toString().isEmpty()) {
                Toast.makeText(getContext(), "Debe llenar los campos de texto", Toast.LENGTH_LONG).show();
            }else{
                String idLiga = String.valueOf(binding.idLiga.getText());
                String ronda = String.valueOf(binding.ronda.getText());
                String temporada = String.valueOf(binding.temporada.getText());
                sportsDbService.getResultados(idLiga,ronda,temporada).enqueue(new Callback<Resultados>() {
                    @Override
                    public void onResponse(Call<Resultados> call, Response<Resultados> response) {
                        if(response.isSuccessful()){
                            Resultados resultados = response.body();
                            Events[] lista = resultados.getEvents();

                            ResultadosAdapter adapter = new ResultadosAdapter();
                            adapter.setContext(getContext());
                            adapter.setListEventos(Arrays.asList(lista));

                            binding.rvResultados.setAdapter(adapter);
                            binding.rvResultados.setLayoutManager(new LinearLayoutManager(getContext()));
                        }else{
                            Log.d("msg-test","error en la respuesta del webservice");
                        }
                    }

                    @Override
                    public void onFailure(Call<Resultados> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }

        });

        return binding.getRoot();
    }
}