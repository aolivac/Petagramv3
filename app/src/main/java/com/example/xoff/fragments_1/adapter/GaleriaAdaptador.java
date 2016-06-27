package com.example.xoff.fragments_1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xoff.fragments_1.R;
import com.example.xoff.fragments_1.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by XOFF on 20/06/2016.
 */
public class GaleriaAdaptador extends RecyclerView.Adapter<GaleriaAdaptador.mascotaViewHolder> {


    public GaleriaAdaptador(ArrayList<Mascota> item) {
        this.item = item;
    }
    private ArrayList <Mascota> item;



    @Override
    public mascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_galeria,parent,false);
        return new mascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(mascotaViewHolder productoViewHolder, int i) {

     //   productoViewHolder.nombre.setText(item.get(i).getNombre());
        productoViewHolder.foto.setImageResource(item.get(i).getFoto());
        productoViewHolder.likes.setText("9");

    }

    @Override
    public int getItemCount() {
        return item.size();
        }

    public class mascotaViewHolder extends RecyclerView.ViewHolder{

        TextView nombre;
        ImageView foto;
        TextView likes;


        public mascotaViewHolder(View itemView) {
            super(itemView);


            foto = (ImageView)itemView.findViewById(R.id.ivMascota);
            likes = (TextView)itemView.findViewById(R.id.tvLikes);


        }
    }
}
