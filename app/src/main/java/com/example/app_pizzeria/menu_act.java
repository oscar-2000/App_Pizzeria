package com.example.app_pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class menu_act extends AppCompatActivity {
    private VideoView vd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);
        vd = (VideoView)findViewById(R.id.videoView);

        //RUTA DE VIDEO
        String ruta = "android.resource://" + getPackageName() + "/" +  R.raw.video;
        Uri uri = Uri.parse(ruta);
        vd.setVideoURI(uri);
        vd.start();
        //CONTROLES PARA EL VIDEO
        MediaController media = new MediaController(this);
        vd.setMediaController(media);
    }

    public void Promociones(View view){
        Intent vistaPromociones = new Intent(this,promociones_act.class);
        startActivity(vistaPromociones);
    }

    public void GestionPizzas(View view){
        Intent vistaGestion = new Intent(this,firebase_act.class);
        startActivity(vistaGestion);
    }
}