package com.example.myapplicationnueva;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText usuario, clave;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usuario = findViewById(R.id.txtRegisterUsername);
        clave = findViewById(R.id.txtRegisterPassword);
        btnRegistrar = findViewById(R.id.btnRegister);

        // Configurar botón para registrar
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usuario.getText().toString().trim();
                String pass = clave.getText().toString().trim();

                // Validar que los campos no estén vacíos
                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Verificar si el nombre de usuario ya existe usando SugarORM
                    if (Usuario.userExists(user)) {
                        Toast.makeText(RegisterActivity.this, "El nombre de usuario ya está en uso", Toast.LENGTH_SHORT).show();
                    } else {
                        // Crear un nuevo usuario y guardar en la base de datos
                        Usuario nuevoUsuario = new Usuario(user, pass, "", ""); // Puedes incluir email y phone si están disponibles
                        nuevoUsuario.save();

                        Toast.makeText(RegisterActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                        // Navegar a la pantalla de inicio de sesión
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish(); // Finaliza esta actividad para que el usuario no vuelva aquí
                    }
                }
            }
        });
    }
}
