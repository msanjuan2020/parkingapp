package com.upc.group.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button btnEntrar;
    EditText txtUser, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        asignarReferencias();
    }

    private void asignarReferencias() {
        txtUser = findViewById(R.id.txtUser);
        txtPassword = findViewById(R.id.txtPassword);
        btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (txtUser.getText().toString().equals("admin") && txtPassword.getText().toString().equals("admin")) {
                    intent = new Intent(LoginActivity.this, MainMenuAdmin.class);
                    startActivity(intent);
                } else if (txtUser.getText().toString().equals("usuario") && txtPassword.getText().toString().equals("usuario")) {
                    intent = new Intent(LoginActivity.this, MainMenuUsuario.class);
                    startActivity(intent);
                }
            }
        });
    }
}