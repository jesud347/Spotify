package com.example.proyectojava_ud2.Modelos;

public class Cancion {
    private Album album;
    private String titulo_cancion;
    private String integrantes;
    private int minutos;
    private int segundos;
    private int imagenID_cancion;

    public Cancion(Album album, String titulo_cancion, String integrantes, int minutos, int segundos, int imagenID_cancion) {
        this.album = album;
        this.titulo_cancion = titulo_cancion;
        this.integrantes = integrantes;
        this.minutos = minutos;
        this.segundos = segundos;
        this.imagenID_cancion = imagenID_cancion;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getTitulo_cancion() {
        return titulo_cancion;
    }

    public void setTitulo_cancion(String titulo_cancion) {
        this.titulo_cancion = titulo_cancion;
    }

    public String getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(String integrantes) {
        this.integrantes = integrantes;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getImagenID_cancion() {
        return imagenID_cancion;
    }

    public void setImagenID_cancion(int imagenID_cancion) {
        this.imagenID_cancion = imagenID_cancion;
    }
}
