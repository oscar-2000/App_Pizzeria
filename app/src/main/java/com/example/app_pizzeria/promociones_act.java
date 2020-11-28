package com.example.app_pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_pizzeria.Clases.Pizzas;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class promociones_act extends AppCompatActivity {
    private EditText promo,envio;
    private TextView resultado,cantidad;
    private Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);
        promo = (EditText)findViewById(R.id.edtPromocion);
        envio = (EditText)findViewById(R.id.editValorEnvio);
        resultado = (TextView)findViewById(R.id.txtRespuesta);
        cantidad= (TextView)findViewById(R.id.txtCantidad);
        spn = (Spinner)findViewById(R.id.spnPromo);
        String[] listaClientes = {"Ramiro","Rosa","Robert"};
        //ARRAYLIST PARA SPINNER
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaClientes);
        spn.setAdapter(adaptador);
    }

    public void CalcularPromo(View view){
        String promocion = promo.getText().toString();
        String precio_envio = envio.getText().toString();
        String cliente = spn.getSelectedItem().toString();
        Pizzas pizzas = new Pizzas();
        int precio;
        if(!promocion.equalsIgnoreCase("") && !precio_envio.equalsIgnoreCase(""))
        {
            if(promocion.equalsIgnoreCase("Pizza promo") || promocion.equalsIgnoreCase("Master pizza") || promocion.equalsIgnoreCase("Pizza max"))
            {
                if(promocion.equalsIgnoreCase("Pizza promo")){
                    precio = pizzas.getPrecio_1() + Integer.parseInt(precio_envio);
                    String total = String.valueOf(precio);
                    cantidad.setText("$" + total);
                    resultado.setText("Estimado " + cliente + " el final según promoción y envío es:");
                }
                else if(promocion.equalsIgnoreCase("Master pizza")){
                    precio = pizzas.getPrecio_2() + Integer.parseInt(precio_envio);
                    String total = String.valueOf(precio);
                    cantidad.setText("$" + total);
                    resultado.setText("Estimado " + cliente + " el final según promoción y envío es:");
                }
                else if(promocion.equalsIgnoreCase("Pizza max")){
                    precio = pizzas.getPrecio_3() + Integer.parseInt(precio_envio);
                    String total = String.valueOf(precio);
                    cantidad.setText("$" + total);
                    resultado.setText("Estimado " + cliente + " el final según promoción y envío es:");
                }
            }
            else{
                Toast.makeText(getBaseContext(),"No existe esta promocion", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(getBaseContext(),"Inserte datos en los campos",Toast.LENGTH_LONG).show();
        }
    }
}