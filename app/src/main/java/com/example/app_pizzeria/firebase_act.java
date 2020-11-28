package com.example.app_pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//FIREBASE
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.FirebaseApp;

import java.util.UUID;

import Modelo.Clientes;

public class firebase_act extends AppCompatActivity {

    private EditText nombre,destino,promo;
    private Button guardar,listado;

    //INSTANCIAR OBJETOS PARA FIREBASE
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);
        nombre = (EditText)findViewById(R.id.edtNombreFb);
        destino = (EditText)findViewById(R.id.edtDestino);
        promo = (EditText)findViewById(R.id.edtPromocion);
        guardar = (Button)findViewById(R.id.btnGuardarCliente);
        listado = (Button)findViewById(R.id.btnListadoCliente);
        inicializarFireBase();

        //AÑADIR CLIENTE
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String opcion_nombre = nombre.getText().toString();
                String opcion_destino = destino.getText().toString();
                String opcion_promo = promo.getText().toString();
                if(!opcion_destino.equalsIgnoreCase("") && !opcion_destino.equalsIgnoreCase("") && !opcion_promo.equalsIgnoreCase("")){
                    Clientes clientes = new Clientes();
                    clientes.setId(UUID.randomUUID().toString());
                    clientes.setNombre(opcion_nombre);
                    clientes.setPromocion(opcion_promo);
                    clientes.setDestino(opcion_destino);
                    //AGREGAMOS LOS CAMPOS A LA BASE DE DATOS
                    databaseReference.child("Clientes").child(clientes.getId()).setValue(clientes);
                    Toast.makeText(getBaseContext(),"Se ha guardado el cliente",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getBaseContext(),"Inserte los datos en los campos",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void inicializarFireBase(){
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }

    public void listadoCliente(View view){
        Intent vistaCliente = new Intent(this,listadoCliente_act.class);
        startActivity(vistaCliente);
    }
}