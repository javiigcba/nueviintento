package com.javi.pizza.entidades;

public class Platos {


    private String titulo;
    private String descripcion;
    private String precio;
    private int Imagenid;

    public Platos (){}

    public Platos(String titulo, String descripcion, String precio, int imagenid) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        Imagenid = imagenid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getImagenid() {
        return Imagenid;
    }

    public void setImagenid(int imagenid) {
        Imagenid = imagenid;
    }


}
