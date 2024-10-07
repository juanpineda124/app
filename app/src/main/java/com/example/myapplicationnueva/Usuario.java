package com.example.myapplicationnueva;

import com.orm.SugarRecord;
import java.util.List;

public class Usuario extends SugarRecord<Usuario> {
    private String username;
    private String password;
    private String email;
    private String phone;

    public Usuario() {}

    public Usuario(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    // Método para validar si el usuario existe con la contraseña
    public static boolean validateUser(String username, String password) {
        List<Usuario> usuarios = Usuario.find(Usuario.class, "username = ? and password = ?", username, password);
        return !usuarios.isEmpty();
    }
}
