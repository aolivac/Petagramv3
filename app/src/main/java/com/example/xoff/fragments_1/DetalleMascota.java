package com.example.xoff.fragments_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleMascota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionbar);
        setSupportActionBar(miActionBar);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar().setDisplayShowHomeEnabled(true);


        Bundle parametros = getIntent().getExtras();
        String nombre   = parametros.getString(getResources().getString(R.string.pnombre));
        int    imagen   = parametros.getInt("imagen");
        int    likes   = parametros.getInt("likes");

        TextView tvNombre   = (TextView) findViewById(R.id.tv_nombreCV);
        TextView tvLikes   = (TextView) findViewById(R.id.tv_likesCV);
        ImageView imgFoto   = (ImageView) findViewById(R.id.ImageView_mascotaCV);


        tvNombre.setText(nombre);
        tvLikes.setText(likes);
        imgFoto.setImageResource(imagen);



    }
}

