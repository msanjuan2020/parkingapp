package com.upc.group.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuscarEstacionamiento extends AppCompatActivity {

    Button btnVerDetalleSede;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_estacionamiento);
        asignarReferencias();
    }

    private void asignarReferencias() {
        btnVerDetalleSede = findViewById(R.id.btnVerDetalleSede);

        btnVerDetalleSede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuscarEstacionamiento.this, VerDetalleSede.class);
                startActivity(intent);
            }
        });
    }
}