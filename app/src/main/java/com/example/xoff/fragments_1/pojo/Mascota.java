package com.example.xoff.fragments_1.pojo;


/**
 * Created by XOFF on 15/06/2016.
 */
public class Mascota {


    private int     id;
    private String  nombre;
    private int     foto;
    private int     likes;


    public Mascota(int foto, String nombre, int likes) {
        this.foto = foto;
        this.nombre = nombre;
        this.likes  = likes;
    }

    public Mascota() {

    }


    public int getId() {         return id;    }
    public void setId(int id) {        this.id = id;    }

    public String getNombre() {
        return nombre;
    }
    public void   setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int    getFoto() {
        return foto;
    }
    public void   setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() { return likes;    }
    public void setLikes(int likes) { this.likes = likes;    }

}
