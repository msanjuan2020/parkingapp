package com.upc.group.parkingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upc.group.parkingapp.modelos.Persona;

import java.util.UUID;

public class MainRegistroUsuario extends AppCompatActivity {

    FloatingActionButton Log_button;
    EditText txtUsuario, txtNombres, txtApellidos, txtDNI,txtEmail, txtPassword, txtCelular;
    Spinner spTipo;
    Button btnRegistrar;

    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro_usuario);
       asignarReferencias();
    }

    //HOLA este cambio.

   private void asignarReferencias() {

       txtUsuario = findViewById(R.id.txtUsuario);
       txtNombres = findViewById(R.id.txtNombres);
       txtApellidos = findViewById(R.id.txtApellidos);
       txtDNI = findViewById(R.id.txtDNI);
       txtCelular = findViewById(R.id.txtCelular);
       txtEmail = findViewById(R.id.txtEmail);
       txtPassword = findViewById(R.id.txtPassword);
       spTipo = findViewById(R.id.spTipo);
       Log_button = findViewById(R.id.log_button);
       btnRegistrar=findViewById(R.id.btnRegistrar);

       inicializarFirebase();
       registrarUsuario();

       Log_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainRegistroUsuario.this, LoginActivity.class);
               startActivity(intent);
           }
       });

       btnRegistrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               registrarUsuario();
           }
       });

   }

    private void registrarUsuario(){

        Persona p = new Persona ();
        p.setId(UUID.randomUUID().toString());
        p.setUsuario(txtUsuario.getText().toString());
        p.setNombres(txtNombres.getText().toString());
        p.setApellidos(txtApellidos.getText().toString());
        p.setDni(txtDNI.getText().toString());
        p.setCelular(txtCelular.getText().toString());
        p.setEmail(txtEmail.getText().toString());

        String tipo="";
        if (spTipo.getSelectedItem().toString().equals("Administrador")) {
            tipo = "A";
        } else if (spTipo.getSelectedItem().toString().equals("Cliente")) {
            tipo = "C";
        }
        p.setTipoUsuario(tipo);
        p.setPassword(txtPassword.getText().toString());


        if (txtUsuario.getText().toString().equals("")){
           // Toast.makeText(this, "Ingrese el usuario", Toast.LENGTH_SHORT).show();
        }
        else {


            if (validacion()==true) {
                reference.child("Persona").child(p.getId()).setValue(p);
                Toast.makeText(this, "¡Usuario agregado en Parkink App!", Toast.LENGTH_SHORT).show();

                /*txtUsuario.setText("");
                txtNombres.setText("");
                txtApellidos.setText("");
                txtDNI.setText("");
                txtCelular.setText("");
                txtEmail.setText("");
                spTipo.
                txtPassword.setText("");*/

                Intent intent = new Intent(MainRegistroUsuario.this, LoginActivity.class);
                startActivity(intent);

            }
        }

        /*

        if(usuario.equals("")|| email.equals("")){
            validacion();
        } else {
            String  url="";

        }*/

    }

   private Boolean validacion(){
        Boolean respuesta=true;

        if(txtUsuario.getText().toString().equals("")|| txtUsuario.getText().equals(null)|| txtUsuario.getText().equals("null")){
           // txtUsuario.setError("Ingrese nombre usuario");

            Toast.makeText(this.getApplicationContext(), "¡Ingrese nombre usuario!", Toast.LENGTH_SHORT).show();

            respuesta=false;

        }


       return respuesta;
   }


    private void inicializarFirebase() {

        FirebaseApp.initializeApp(this);
        db = FirebaseDatabase.getInstance();
        reference = db.getReference();

    }
}


