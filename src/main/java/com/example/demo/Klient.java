package com.example.demo;

public class Klient {
    public Klient(){}
    private int id_klienta;
    private String email;
    private String nr_telefonu;
    private int nr_armatora;
    private int nr_adresu;

    public Klient(int id_klienta, String email, String nr_telefonu, int nr_armatora, int nr_adresu) {
        this.id_klienta = id_klienta;
        this.email = email;
        this.nr_telefonu = nr_telefonu;
        this.nr_armatora = nr_armatora;
        this.nr_adresu = nr_adresu;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public int getNr_armatora() {
        return nr_armatora;
    }

    public void setNr_armatora(int nr_armatora) {
        this.nr_armatora = nr_armatora;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "id_klienta=" + id_klienta +
                ", email='" + email + '\'' +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                ", nr_armatora=" + nr_armatora +
                ", nr_adresu=" + nr_adresu +
                '}';
    }
}
