package com.example.app_pizzeria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import Modelo.Clientes;

//FIREBASE
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class listadoCliente_act extends AppCompatActivity {

    private ListView lista;
    private ArrayList<Clientes> Clientes = new ArrayList<Clientes>();
    //DATA BASE
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;
    Clientes clienteSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_cliente_act);
        lista = (ListView)findViewById(R.id.listaCliente);
        inicializarFireBase();

        //LISTAMOS CLIENTES DE FIREBASE
        Listado();

        //ELIMINAR CLIENTE
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {
                clienteSeleccionado = (Clientes) parent.getItemAtPosition(position);
            }
        });
    }

    public void inicializarFireBase(){
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }

    public void EliminarClientes(View view){
        Clientes clientes = new Clientes();
        clientes.setId(clienteSeleccionado.getId());
        databaseReference.child("Clientes").child(clientes.getId()).removeValue();
        Toast.makeText(getBaseContext(),"Se ha eliminado el cliente",Toast.LENGTH_LONG).show();
        LimpiarLista();
        Listado();
    }

    public void Listado(){
        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot objSnapshot : snapshot.getChildren())
                {
                    Clientes clientes = objSnapshot.getValue(Clientes.class);
                    Clientes.add(clientes);
                    ArrayAdapter adaptador = new ArrayAdapter(getBaseContext(),android.R.layout.simple_list_item_1,Clientes);
                    lista.setAdapter(adaptador);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void LimpiarLista(){
        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot objSnapshot : snapshot.getChildren())
                {
                    Clientes clientes = objSnapshot.getValue(Clientes.class);
                    Clientes.add(clientes);
                    ArrayAdapter adaptador = new ArrayAdapter(getBaseContext(),android.R.layout.simple_list_item_1,Clientes);
                    adaptador.clear();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}