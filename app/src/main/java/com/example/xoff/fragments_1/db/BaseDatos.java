package com.example.xoff.fragments_1.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.xoff.fragments_1.pojo.Mascota;

import java.io.LineNumberReader;
import java.util.ArrayList;

/**
 * Created by aoliva on 26/06/16.
 */
public class BaseDatos extends SQLiteOpenHelper{

    private Context context;
    private int idmascota;
    private int likesMascota;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // definir la tabla igual que el Pojo , todo en una tabla
        String queryCrearTablaMascotas =
                "CREATE TABLE " + ConstantesBaseDatos.TABLA_MASCOTAS +
                    " (" +

                    ConstantesBaseDatos.TABLA_MASCOTAS_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE + " TEXT," +
                    ConstantesBaseDatos.TABLA_MASCOTAS_FOTO   + " INTEGER," +
                    ConstantesBaseDatos.TABLA_MASCOTAS_LIKES  + " INTEGER" +

                    ") ";



        db.execSQL(queryCrearTablaMascotas);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLA_MASCOTAS);

        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodosLosDatos(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLA_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setLikes(registros.getInt(3));

            mascotas.add(mascotaActual);

        }
        db.close();
        return mascotas;
    }
     public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_MASCOTAS,null,contentValues);
        db.close();
    }

    public void insertarLikeMascota(Mascota mascota){
        SQLiteDatabase db = this.getWritableDatabase();

        idmascota = mascota.getId();
        likesMascota = mascota.getLikes() + 1;
        ContentValues data = new ContentValues();
        data.put(ConstantesBaseDatos.TABLA_MASCOTAS_LIKES ,likesMascota);
        db.update(ConstantesBaseDatos.TABLA_MASCOTAS, data, " id = " + idmascota  ,null );
        db.close();
    }


    public int numRegistrosMascotas(){
        int numRegistros = 0;
        String query = "SELECT COUNT(*) " +
                " FROM "  + ConstantesBaseDatos.TABLA_MASCOTAS  ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor  registros = db.rawQuery(query, null);
        registros.moveToFirst();
        numRegistros = registros.getInt(0);
        db.close();
        return numRegistros;
    }


    public ArrayList<Mascota> obtenerLosFavoritos(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT m."+ ConstantesBaseDatos.TABLA_MASCOTAS_LIKES +" as popularidad, " +
                "m." + ConstantesBaseDatos.TABLA_MASCOTAS_ID  + ", " +
                "m." + ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE   + ", " +
                "m." + ConstantesBaseDatos.TABLA_MASCOTAS_FOTO     +
                " FROM "      + ConstantesBaseDatos.TABLA_MASCOTAS + " as m " +

                " ORDER BY popularidad DESC"  +
        " LIMIT 0,5";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setLikes(registros.getInt(0));
            mascotaActual.setId(registros.getInt(1));
            mascotaActual.setNombre(registros.getString(2));
            mascotaActual.setFoto(registros.getInt(3));

            mascotas.add(mascotaActual);

        }
        db.close();
        return mascotas;
    }
    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT " +ConstantesBaseDatos.TABLA_MASCOTAS_LIKES+
                " FROM "  + ConstantesBaseDatos.TABLA_MASCOTAS +
                " WHERE " + ConstantesBaseDatos.TABLA_MASCOTAS_ID + " = " + mascota.getId() ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor  registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();

        return likes;
    }


}


