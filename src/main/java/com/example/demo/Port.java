package com.example.demo;

public class Port {
    private int id_portu;
    private String nazwa_portu;
    private String miasto;
    private int liczba_miejsc;
    private int nr_armatora;
    public Port(){}
    public Port(int id_portu, String nazwa_portu, String miasto, int liczba_miejsc, int nr_armatora) {
        this.id_portu = id_portu;
        this.nazwa_portu = nazwa_portu;
        this.miasto = miasto;
        this.liczba_miejsc = liczba_miejsc;
        this.nr_armatora = nr_armatora;
    }

    public int getId_portu() {
        return id_portu;
    }

    public void setId_portu(int id_portu) {
        this.id_portu = id_portu;
    }

    public String getNazwa_portu() {
        return nazwa_portu;
    }

    public void setNazwa_portu(String nazwa_portu) {
        this.nazwa_portu = nazwa_portu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public int getLiczba_miejsc() {
        return liczba_miejsc;
    }

    public void setLiczba_miejsc(int liczba_miejsc) {
        this.liczba_miejsc = liczba_miejsc;
    }

    public int getNr_armatora() {
        return nr_armatora;
    }

    public void setNr_armatora(int nr_armatora) {
        this.nr_armatora = nr_armatora;
    }
    @Override
    public String toString() {
        return "Port{" +
                "id_portu=" + id_portu +
                ", nazwa_portu='" + nazwa_portu + '\'' +
                ", miasto='" + miasto + '\'' +
                ", liczba_miejsc=" + liczba_miejsc +
                ", nr_armatora=" + nr_armatora +
                '}';
    }
}
