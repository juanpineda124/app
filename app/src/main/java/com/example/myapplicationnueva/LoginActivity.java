package com.example.myapplicationnueva;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usuario, clave;
    private Button btnIngresar;
    private TextView regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Vincular elementos de la interfaz
        usuario = findViewById(R.id.txtUsername);
        clave = findViewById(R.id.txtPassword);
        regis = findViewById(R.id.textViewRegister);
        btnIngresar = findViewById(R.id.btnLogin);

        // Navegar a la actividad de registro
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        // Configurar botón para iniciar sesión
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresar(); // Llamar a método ingresar al hacer click
            }
        });
    }

    // Método para iniciar sesión
    private void ingresar() {
        String user = usuario.getText().toString().trim();
        String pass = clave.getText().toString().trim();

        // Verifica si hay campos vacíos
        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificar credenciales
        if (Usuario.validateUser(user, pass)) {
            // Mostrar mensaje de éxito
            Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

            // Navegar a DashboardActivity si el login es exitoso
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
            finish(); // Cierra LoginActivity para que no regrese con "Back"
        } else {
            // Si la validación falla
            Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_LONG).show();
            Log.d("LoginActivity", "Fallo en el inicio de sesión para usuario: " + user);
        }
    }
}


