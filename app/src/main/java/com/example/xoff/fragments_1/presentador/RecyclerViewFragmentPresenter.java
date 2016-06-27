package com.example.xoff.fragments_1.presentador;

import android.content.Context;

import com.example.xoff.fragments_1.adapter.MascotaAdaptador;
import com.example.xoff.fragments_1.db.ConstructorMascotas;
import com.example.xoff.fragments_1.fragment.IRecyclerViewFragmentView;
import com.example.xoff.fragments_1.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by aoliva on 26/06/16.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{


    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context ){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBBDD();
    }


    @Override
    public void obtenerContactosBBDD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayourVertical();

    }
}
