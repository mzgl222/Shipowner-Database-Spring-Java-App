package com.example.demo;

public class Wynagrodzenie {
    private int id_wynagrodzenia;
    private String data;
    private int kwota;
    private int premia;
    private int id_pracownika;
    public Wynagrodzenie(){}

    public Wynagrodzenie(int id_wynagrodzenia, String data, int kwota, int premia, int id_pracownika) {
        this.id_wynagrodzenia = id_wynagrodzenia;
        this.data = data;
        this.kwota = kwota;
        this.premia = premia;
        this.id_pracownika = id_pracownika;
    }

    public int getId_wynagrodzenia() {
        return id_wynagrodzenia;
    }

    public void setId_wynagrodzenia(int id_wynagrodzenia) {
        this.id_wynagrodzenia = id_wynagrodzenia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getKwota() {
        return kwota;
    }

    public void setKwota(int kwota) {
        this.kwota = kwota;
    }

    public int getPremia() {
        return premia;
    }

    public void setPremia(int premia) {
        this.premia = premia;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    @Override
    public String toString() {
        return "Wynagrodzenie{" +
                "id_wynagrodzenia=" + id_wynagrodzenia +
                ", data='" + data + '\'' +
                ", kwota=" + kwota +
                ", premia=" + premia +
                ", id_pracownika=" + id_pracownika +
                '}';
    }
}
