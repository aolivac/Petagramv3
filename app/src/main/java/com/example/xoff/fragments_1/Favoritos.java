package com.example.xoff.fragments_1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.xoff.fragments_1.adapter.MascotaAdaptador;
import com.example.xoff.fragments_1.db.ConstructorMascotas;
import com.example.xoff.fragments_1.pojo.Mascota;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {

    private RecyclerView recicladorFav;
    private RecyclerView.LayoutManager layoutManagerFav;
    private RecyclerView.Adapter recyclerAdaptadorFav;
    private Context context;
    private ConstructorMascotas constructorMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miToolbar = (Toolbar) findViewById(R.id.actionBarFavoritos);
        setSupportActionBar(miToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled( true );
        setTitle("Favoritos");

        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        constructorMascotas = new ConstructorMascotas(this);
        mascotas = constructorMascotas.obtenerFavCinco();

        recicladorFav = (RecyclerView)findViewById(R.id.rvFavoritos);
        layoutManagerFav = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recicladorFav.setLayoutManager(layoutManagerFav);

        recyclerAdaptadorFav = new MascotaAdaptador(mascotas, this);
        recicladorFav.setAdapter(recyclerAdaptadorFav);
    }
}
