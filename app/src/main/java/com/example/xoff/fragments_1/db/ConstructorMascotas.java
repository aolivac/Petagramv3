package com.example.xoff.fragments_1.db;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;


import com.example.xoff.fragments_1.MainActivity;
import com.example.xoff.fragments_1.R;
import com.example.xoff.fragments_1.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by aoliva on 26/06/16.
 */
public class ConstructorMascotas {

    private static final Integer NLIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        if(!tablaMascotasCargada()) {
            insertarVariasMascotas(db);
        }
        return db.obtenerTodosLosDatos();
    }

    public ArrayList<Mascota> obtenerFavoritos(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerTodosLosDatos();
    }



    public void insertarVariasMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE,"Toby");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO,R.drawable.perro1 );
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE,"Pancho");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO,R.drawable.perro2 );
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE,"Titan");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO,R.drawable.perro3 );
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE,"Flaco");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO,R.drawable.perro4 );
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE,"Canelo");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO,R.drawable.perro5 );
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE,"Rantamplan");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO,R.drawable.perro6 );
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE,"Daida");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO,R.drawable.perro7 );
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE,"Sueca");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO,R.drawable.perro8 );
        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_ID, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_LIKES, NLIKE     );
        db.insertarLikeMascota(mascota);





    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

    public boolean tablaMascotasCargada(){
        BaseDatos db = new BaseDatos(context);
        if(db.numRegistrosMascotas() == 0){
            return false;
        }else{return true;}
    }

    public ArrayList<Mascota> obtenerFavCinco(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLosFavoritos();
    }


}
