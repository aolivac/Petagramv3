package com.example.xoff.fragments_1.adapter;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xoff.fragments_1.DetalleMascota;
import com.example.xoff.fragments_1.R;
import com.example.xoff.fragments_1.db.ConstructorMascotas;
import com.example.xoff.fragments_1.pojo.Mascota;

import java.util.ArrayList;


/**
 * Created by XOFF on 09/06/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //esto le da vida a nuestro layout cardview, asocia el layout al recyclerview y lo pasa al viewHolder para obtener
        // cada elemento)views=
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder MascotaViewHolder, int position) {
        // se llama para cada elemento de la lista, asocia cada elemento con cada view
        final Mascota mascota = mascotas.get(position);

        MascotaViewHolder.imagenCV.setImageResource(mascota.getFoto());
        MascotaViewHolder.nombreCV.setText(mascota.getNombre());
        MascotaViewHolder.likesCV.setText(String.valueOf(mascota.getLikes()) + " Likes");

        MascotaViewHolder.imagenCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Ficha de " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                /*
                Intent intent = new Intent(activity, DetalleMascota.class);
                intent.putExtra("nombre", mascota.getNombre());
                intent.putExtra("imagen", mascota.getFoto());
                intent.putExtra("likes", mascota.getLikes());

                activity.startActivity(intent);
*/
            }
        });

        MascotaViewHolder.btnLikeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Like a " + mascota.getNombre() , Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                MascotaViewHolder.likesCV.setText(constructorMascotas.obtenerLikesMascota(mascota) + " Likes");


            }
        });











    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        //declaramos todos los views del layout de mascotas

        private TextView    nombreCV;
        private ImageView   imagenCV;
        private TextView    likesCV;
        private ImageButton btnLikeCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            nombreCV = (TextView)itemView.findViewById(R.id.tv_nombreCV);
            imagenCV = (ImageView)itemView.findViewById(R.id.ImageView_mascotaCV);
            likesCV = (TextView)itemView.findViewById(R.id.tv_likesCV);
            btnLikeCV = (ImageButton) itemView.findViewById(R.id.ImageButton_huesoBlancoCV);



        }


    }

}


