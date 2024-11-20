package com.example.proyectojava_ud2.Modelos;

public class Album {

    private String titulo;
    private String descripcion;
    private String descripcion_extra;
    private int imagenID;
    private String link;

    public Album(String titulo, String descripcion, int imagenID, String descripcion_extra, String link) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenID = imagenID;
        this.descripcion_extra = descripcion_extra;
        this.link = link;
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

    public int getImagenID() {return imagenID;}

    public void setImagenID(int imagenID) {
        this.imagenID = imagenID;
    }

    public String getDescripcion_extra() {return descripcion_extra;}

    public void setDescripcion_extra(String descripcion_extra) {this.descripcion_extra = descripcion_extra;}

    public String getLink() {return link;}

    public void setLink(String link) {this.link = link;}
}
