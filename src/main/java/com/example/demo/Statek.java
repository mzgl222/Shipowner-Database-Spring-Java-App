package com.example.demo;

public class Statek {
    private int id_statku;
    private String nazwa;
    private int rok_produkcji;
    private int zasieg;
    private int nr_armatora;
    private int id_modelu;


    public Statek(int id_statku, String nazwa, int rok_produkcji, int zasieg, int nr_armatora, int id_modelu) {
        this.id_statku = id_statku;
        this.nazwa = nazwa;
        this.rok_produkcji = rok_produkcji;
        this.zasieg = zasieg;
        this.nr_armatora = nr_armatora;
        this.id_modelu = id_modelu;
    }

    public Statek(){}

    public int getId_statku() {
        return id_statku;
    }

    public void setId_statku(int id_statku) {
        this.id_statku = id_statku;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(int rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    public int getZasieg() {
        return zasieg;
    }

    public void setZasieg(int zasieg) {
        this.zasieg = zasieg;
    }

    public int getNr_armatora() {
        return nr_armatora;
    }

    public void setNr_armatora(int nr_armatora) {
        this.nr_armatora = nr_armatora;
    }

    public int getId_modelu() {
        return id_modelu;
    }

    public void setId_modelu(int id_modelu) {
        this.id_modelu = id_modelu;
    }

    @Override
    public String toString() {
        return "Statek{" +
                "id_statku=" + id_statku +
                ", nazwa='" + nazwa + '\'' +
                ", rok_produkcji=" + rok_produkcji +
                ", zasieg=" + zasieg +
                ", nr_armatora=" + nr_armatora +
                ", id_modelu=" + id_modelu +
                '}';
    }
}
