package com.kaxtli.intoapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 209636765 on 18/02/2017.
 */

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // En R se almacenan todos los recursos de android. Ya están indexados.
        setContentView(R.layout.activity_splash); // <- Ligando la vista a la actividad.

        // Creando un nuevo hilo para el contador
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // Cambia a la otra pantalla
                    // Los intents nos ayudan a realizar cambios
                    // origen, destino!!
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    // Este activity ya no sirve. Termínalo (Saca de la pila)
                    finish();
                }
            }
        };
        // Iniciar el hilo
        thread.start();
    }
}
