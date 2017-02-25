package com.kaxtli.intoapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    // Creación de la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Asignar un layout a la actividad
        // R -> Carpeta de recursos -> layout -> activity_main
        setContentView(R.layout.activity_main);
        // Creando logs en el sistema
        Log.d("MainActivity", "onCreate() launched");

        // Añadiendo los objetos para interactuar con los campos de la UI
        //  control hereda de view, por lo que se puede castear a uno de los controles.
        // Existen dos R: la global de Android y la del proyecto. En el proyecto están las vistas.
        username = (EditText)findViewById(R.id.usernameEditText);
        password = (EditText)findViewById(R.id.passwordEditText);

        // El botón no se comunica con el exterior, puede ser una variable local
        Button login = (Button)findViewById(R.id.loginButton);

        // Escuchar por el evento!! Notar el uso de interfaces y su satisfacción
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validando si los campos tienen contenido
                if (passValidaton()){
                    // Entonces revisa las credenciales
                    checkCredentials();
                }
            }
        });
    }

    private boolean checkCredentials() {
        username.setError(null);
        password.setError(null);
        boolean rightCredentials = true;
        // Obteniendo los valores en los campos son obtenidos
        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();
        if (usernameText.equalsIgnoreCase("merengues")){
            if (passwordText.equalsIgnoreCase("sabanasxd")){
                // El usuario es autenticado. Muestra un mensaje
                Toast.makeText(getApplicationContext(), "Credenciales correctas", Toast.LENGTH_LONG).show();
            } else {
                username.setError("No se pudo autenticar el usuario");
                rightCredentials = false;
            }
        } else {
            username.setError("No se pudo autenticar el usuario");
            rightCredentials = false;
        }
        return rightCredentials;
    }

    private boolean passValidaton() {
        boolean passValidation = true;
        username.setError(null); // Limpiando errores.
        password.setError(null);

        // Texto guardado en el EditText
        String usernameText = username.getText().toString();
        // Si al quitar espacios su longitud es cero, está vacío el campo.
        if(usernameText.trim().length() == 0) {
            username.setError("Username no puede estar vacío");
            passValidation = false; // No pasó la validación.
        }
        String passwordText = password.getText().toString();
        if (passwordText.trim().length() == 0) {
            password.setError("Password no puede estar vacío");
            passValidation = false;
        }
        return passValidation;
    }
}
