package com.example.xoff.fragments_1.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xoff.fragments_1.R;
import com.example.xoff.fragments_1.adapter.MascotaAdaptador;
import com.example.xoff.fragments_1.pojo.Mascota;
import com.example.xoff.fragments_1.presentador.IRecyclerViewFragmentPresenter;
import com.example.xoff.fragments_1.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by XOFF on 19/06/2016.
 */
public class RecyclerViewFragment extends android.support.v4.app.Fragment implements IRecyclerViewFragmentView {


    private RecyclerView rvMascotas;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter recyclerAdaptador;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvFavoritos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }



    @Override
    public void generarLinearLayourVertical() {


        LinearLayoutManager layoutManager   = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(layoutManager);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
