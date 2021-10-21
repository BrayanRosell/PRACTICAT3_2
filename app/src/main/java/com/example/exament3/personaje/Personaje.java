package com.example.exament3.personaje;

import com.google.gson.annotations.SerializedName;

public class Personaje {
    @SerializedName("name")
    private String nombre;
    @SerializedName("description")
    private String descripcion;
    @SerializedName("img")
    private String imagen;

    public Personaje() {
    }

    public Personaje(String nombre, String descripcion, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
