package com.example.app_pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre,contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText)findViewById(R.id.edtNombre);
        contrasena = (EditText)findViewById(R.id.edtContrasena);
    }

    public void iniciarSesion(View view){
        String nombreUsuario = nombre.getText().toString();
        String contraUsuario = contrasena.getText().toString();
        if(!nombreUsuario.equalsIgnoreCase("") && !contraUsuario.equalsIgnoreCase(""))
        {
            if(nombreUsuario.equalsIgnoreCase("android") && contraUsuario.equalsIgnoreCase("123")){
                Intent vistaMenu = new Intent(this,menu_act.class);
                startActivity(vistaMenu);
            }
            else{
                Toast.makeText(getBaseContext(),"Datos incorrectos",Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(getBaseContext(),"Ingrese datos en los campos",Toast.LENGTH_LONG).show();
        }


    }
}