package com.example.xoff.fragments_1.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xoff.fragments_1.R;
import com.example.xoff.fragments_1.adapter.GaleriaAdaptador;
import com.example.xoff.fragments_1.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {


    ArrayList<Mascota> datosPerfil = new ArrayList<Mascota>();
    private RecyclerView recicladorPerfil;
    private RecyclerView.LayoutManager layoutManagerPerfil;
    private RecyclerView.Adapter recyclerAdaptadorPerfil;
    TextView nombreMascota;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        recicladorPerfil = (RecyclerView)v.findViewById(R.id.rvGridPerfil);
        layoutManagerPerfil = new LinearLayoutManager(getContext());
        recicladorPerfil.setLayoutManager(layoutManagerPerfil);

        nombreMascota = (TextView) v.findViewById(R.id.tvNombrePerfil);
        nombreMascota.setText("Flaco");
        nombreMascota.setTextSize(20);

        inicializarDatosPerfilMascota();
        inicializaAdaptadorGrilla();



        return v;

    }

    void inicializarDatosPerfilMascota(){
        datosPerfil.add(new Mascota(R.drawable.perro4,"flaco",9));
        datosPerfil.add(new Mascota(R.drawable.perro4,"flaco",8));
        datosPerfil.add(new Mascota(R.drawable.perro4,"flaco",2));
        datosPerfil.add(new Mascota(R.drawable.perro4,"flaco",5));
        datosPerfil.add(new Mascota(R.drawable.perro4,"flaco",12));
        datosPerfil.add(new Mascota(R.drawable.perro4,"flaco",9));
        datosPerfil.add(new Mascota(R.drawable.perro4,"flaco",1));
        datosPerfil.add(new Mascota(R.drawable.perro4,"flaco",4));
        datosPerfil.add(new Mascota(R.drawable.perro4,"flaco",12));


    }

    void inicializaAdaptadorGrilla(){
        int Cantidad_de_Columnas = 3;
        recyclerAdaptadorPerfil = new GaleriaAdaptador(datosPerfil);
        recicladorPerfil.setLayoutManager(new GridLayoutManager(getContext(), Cantidad_de_Columnas ));
        recicladorPerfil.setAdapter(recyclerAdaptadorPerfil);
    }

}
