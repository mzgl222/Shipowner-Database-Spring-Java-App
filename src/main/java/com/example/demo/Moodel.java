package com.example.demo;

public class Moodel {
    public Moodel(){}
    private int id_modelu;
    private String nazwa;
    private int nr_marki;

    public Moodel(int id_modelu, String nazwa, int nr_marki) {
        this.id_modelu = id_modelu;
        this.nazwa = nazwa;
        this.nr_marki = nr_marki;
    }

    public int getId_modelu() {
        return id_modelu;
    }

    public void setId_modelu(int id_modelu) {
        this.id_modelu = id_modelu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getNr_marki() {
        return nr_marki;
    }

    public void setNr_marki(int nr_marki) {
        this.nr_marki = nr_marki;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id_modelu=" + id_modelu +
                ", nazwa='" + nazwa + '\'' +
                ", nr_marki=" + nr_marki +
                '}';
    }

}
