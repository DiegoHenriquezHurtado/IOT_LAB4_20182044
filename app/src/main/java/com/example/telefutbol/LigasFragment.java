package com.example.telefutbol;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.telefutbol.Entity.Countries;
import com.example.telefutbol.Entity.Leagues;
import com.example.telefutbol.Entity.Ligas;
import com.example.telefutbol.adapter.LigaAdapter;
import com.example.telefutbol.databinding.FragmentLigasBinding;
import com.example.telefutbol.services.SportsDbService;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LigasFragment extends Fragment {

    FragmentLigasBinding binding;
    SportsDbService sportsDbService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLigasBinding.inflate(inflater,container,false);

        /*NavController navController = NavHostFragment.findNavController(LigasFragment.this);

        binding.btnPosiciones.setOnClickListener(view -> {
            navController.navigate(R.id.action_ligasFragment_to_posicionesFragment);
        });

        binding.btnResultados.setOnClickListener(view -> {
            navController.navigate(R.id.action_ligasFragment_to_resultadosFragment);
        });*/

        //Creacion de la interfaz para consumir la api
        sportsDbService = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SportsDbService.class);

        //Se espera presionar el boton buscar para capturar lo del placeHolder y mostrar un resultado
        binding.btnBuscar.setOnClickListener(view -> {
            if(binding.buscarPais.getText().toString().isEmpty()){
                sportsDbService.getLigas().enqueue(new Callback<Leagues>() {
                    @Override
                    public void onResponse(Call<Leagues> call, Response<Leagues> response) {
                        if(response.isSuccessful()){
                            Leagues leagues = response.body();
                            Ligas[] lista = leagues.getLeagues();

                            LigaAdapter adapter = new LigaAdapter();
                            adapter.setContext(getContext());
                            adapter.setListaLigas(Arrays.asList(lista));

                            binding.rvLigas.setAdapter(adapter);
                            binding.rvLigas.setLayoutManager(new LinearLayoutManager(getContext()));

                            Log.d("msg-test","Se logro sacar info de la API");
                        } else {
                            Log.d("msg-test","error en la respuesta del webservice");
                        }
                    }

                    @Override
                    public void onFailure(Call<Leagues> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }else {
                String pais = String.valueOf(binding.buscarPais.getText());
                sportsDbService.getLeaguesPorPais(pais).enqueue(new Callback<Countries>() {
                    @Override
                    public void onResponse(Call<Countries> call, Response<Countries> response) {
                        if(response.isSuccessful()){
                            Countries countries = response.body();
                            Ligas[] lista = countries.getCountries();
                            if(lista != null){
                                LigaAdapter adapter = new LigaAdapter();
                                adapter.setContext(getContext());
                                adapter.setListaLigas(Arrays.asList(lista));
                                binding.rvLigas.setAdapter(adapter);
                                binding.rvLigas.setLayoutManager(new LinearLayoutManager(getContext()));
                            }else{
                                Toast.makeText(getContext(), "Pais inexistente" , Toast.LENGTH_LONG).show();
                            }
                        }else {
                            Log.d("msg-test","error en la respuesta del webservice");
                        }
                    }

                    @Override
                    public void onFailure(Call<Countries> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });

        return binding.getRoot();
    }
}