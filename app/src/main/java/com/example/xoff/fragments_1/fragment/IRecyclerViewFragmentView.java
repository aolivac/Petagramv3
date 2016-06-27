package com.example.xoff.fragments_1.fragment;

import com.example.xoff.fragments_1.adapter.MascotaAdaptador;
import com.example.xoff.fragments_1.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by aoliva on 26/06/16.
 */
public interface IRecyclerViewFragmentView {


    public void generarLinearLayourVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);





}
