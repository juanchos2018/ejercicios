package com.example.ejercicios.Clases;

public class ClsNoticias {

    public  String id;
    public String titulo;
    public String descrpipion;
    public String fecha;
    public int img1;
    public int img2;

    public ClsNoticias(String id,String titulo, String descrpipion, String fecha, int img1, int img2) {
        this.id=id;
        this.titulo = titulo;
        this.descrpipion = descrpipion;
        this.fecha = fecha;
        this.img1 = img1;
        this.img2 = img2;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescrpipion() {
        return descrpipion;
    }

    public void setDescrpipion(String descrpipion) {
        this.descrpipion = descrpipion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }
}
