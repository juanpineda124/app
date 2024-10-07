package com.example.myapplicationnueva;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    TextView nameuser;
    EditText name, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        nameuser = findViewById(R.id.txtUser);
        name = findViewById(R.id.txtNombre);
        email = findViewById(R.id.txtEmail);
        phone = findViewById(R.id.txtPhone);

        // Obtener el nombre de usuario de la intención
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nameuser.setText(bundle.getString("user"));
        } else {
            nameuser.setText("Usuario no encontrado");
        }
    }
}
