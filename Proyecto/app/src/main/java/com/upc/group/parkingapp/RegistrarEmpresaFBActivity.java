package com.upc.group.parkingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.upc.group.parkingapp.modelos.Empresa;
import com.upc.group.parkingapp.modelos.Estacionamiento;

import java.util.ArrayList;
import java.util.UUID;

public class RegistrarEmpresaFBActivity extends AppCompatActivity {

    EditText editTextRUC, editTextNombreLocal, editTextRepresentante,
            editTextDireccion, editTextNiveles, editTextTotalEst;
    CheckBox checkBoxTermCondiciones;
    Spinner spHorarios;

    Button btnRegistrarEmpresa, btnEliminarEmpresa;
    FirebaseDatabase db;
    DatabaseReference reference;

    private ArrayList<Empresa> listaEmpresa = new ArrayList<>();
    ArrayAdapter<Empresa> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empresa_f_b);
        asignarReferencias();
    }

    private void asignarReferencias() {

        editTextRUC = findViewById(R.id.editTextRUC);
        editTextNombreLocal = findViewById(R.id.editTextNombreLocal);
        editTextNombreLocal = findViewById(R.id.editTextNombreLocal);
        editTextRepresentante = findViewById(R.id.editTextRepresentante);
        editTextDireccion = findViewById(R.id.editTextDireccion);
        editTextNiveles = findViewById(R.id.editTextNiveles);
        editTextTotalEst = findViewById(R.id.editTextTotalEst);
        checkBoxTermCondiciones = findViewById(R.id.checkBoxTermCondiciones);
        btnRegistrarEmpresa = findViewById(R.id.btnRegistrarEmpresa);
        btnEliminarEmpresa = findViewById(R.id.btnEliminarEmpresa);
        spHorarios = findViewById(R.id.spHorarios);

        inicializarFirebase();
        listarDatos();


            btnRegistrarEmpresa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*boolean result = Boolean.parseBoolean(checkBoxTermCondiciones.getText().toString());
                    if (result==true){*/
                    registrarEmpresa();
                    /*}
                    else {
                        Toast.makeText(RegistrarEmpresaFBActivity.this, "Debe aceptar los términos y condiciones", Toast.LENGTH_SHORT).show();

                    }*/
                }
            });

        btnEliminarEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarEmpresa();
            }
        });
    }

    private void listarDatos() {
        reference.child("Empresa").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaEmpresa.clear();
                for(DataSnapshot item:snapshot.getChildren()){
                    Empresa e = item.getValue(Empresa.class);
                    listaEmpresa.add(e);
                }
                //adapter = new ArrayAdapter<>(FirebaseActivity.this, android.R.layout.simple_list_item_1,listaEmpresa);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void registrarEmpresa() {
        Empresa e = new Empresa();
        Estacionamiento s = new Estacionamiento();
        e.setId(UUID.randomUUID().toString());
        e.setRuc(editTextRUC.getText().toString());
        e.setNombreLocal(editTextNombreLocal.getText().toString());
        e.setRepresentante(editTextRepresentante.getText().toString());
        e.setDireccion(editTextDireccion.getText().toString());
        e.setNiveles(Integer.parseInt(editTextNiveles.getText().toString()));
        e.setTotalEst(Integer.parseInt(editTextTotalEst.getText().toString()));
        e.setHorario(spHorarios.getSelectedItem().toString());
        e.setTermCondiciones(Boolean.parseBoolean(checkBoxTermCondiciones.getText().toString()));
        reference.child("Empresa").child(e.getId()).setValue(e);
        Toast.makeText(this, "Empresa registrada", Toast.LENGTH_SHORT).show();
        editTextRUC.setText("");
        editTextNombreLocal.setText("");
        editTextRepresentante.setText("");
        editTextDireccion.setText("");
        editTextNiveles.setText("");
        spHorarios.setSelected(false);
        checkBoxTermCondiciones.setChecked(true);


    }

    private void eliminarEmpresa() {
        Empresa e = new Empresa();
        Estacionamiento s = new Estacionamiento();
    }

    private void validacion() {
        if (editTextRUC.getText().toString().equals("")){

        }
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        db = FirebaseDatabase.getInstance();
        reference = db.getReference();

    }
}