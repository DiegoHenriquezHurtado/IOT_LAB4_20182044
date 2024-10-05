package com.example.telefutbol;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.telefutbol.databinding.ActivityAppBinding;
import com.example.telefutbol.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /******************************* Internet *****************************/
        if(tengoInternet()){
            Toast.makeText(this, "Hay conexion a internet " , Toast.LENGTH_LONG).show();
        }else {
            mostrarNoInternetDialog();
        }

        binding.btnIngresar.setOnClickListener(view -> {
            Intent intent = new Intent(this, AppActivity.class);
            startActivity(intent);
        });

    }


    public boolean tengoInternet() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean tieneInternet = false;
        if (connectivityManager != null) {
            NetworkCapabilities capabilities =
                    connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("msg-Internet", "NetworkCapabilities.TRANSPORT_CELLULAR");
                    tieneInternet = true;
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("msg-Internet", "NetworkCapabilities.TRANSPORT_WIFI");
                    tieneInternet = true;
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("msg-Internet", "NetworkCapabilities.TRANSPORT_ETHERNET");
                    tieneInternet = true;
                }
            }
        }
        return tieneInternet;
    }

    private void mostrarNoInternetDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Sin conexión a Internet")
                .setMessage("No tienes conexión a Internet. ¿Quieres ir a la configuración?")
                .setCancelable(false) // No permitir cerrar el diálogo sin acción
                .setPositiveButton("Configuración", (dialog, which) -> {
                    // Redirigir a la configuración del dispositivo
                    Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                    startActivity(intent);
                })
                .setNegativeButton("Salir", (dialog, which) -> {
                    // Cerrar la aplicación
                    finish();
                })
                .show();
    }
}