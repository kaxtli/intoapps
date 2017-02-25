package com.kaxtli.intoapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    // Creación de la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Asignar un layout a la actividad
        // R -> Carpeta de recursos -> layout -> activity_main
        setContentView(R.layout.activity_main);
        // Creando logs en el sistema
        Log.d("MainActivity", "onCreate() launched");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart() launched");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy() launched");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop() launched");
    }
}
