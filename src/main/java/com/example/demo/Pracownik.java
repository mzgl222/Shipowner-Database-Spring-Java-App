package com.example.demo;

public class Pracownik {
    private int id_pracownika;
    private String imie;
    private String nazwisko;
    //private int pesel;
    private String pesel;

    private String data_zatrudnienia;
    //private int nr_konta;
    private String nr_konta;

    private String email;
    //private int nr_telefonu;
    private String nr_telefonu;

    private String plec;
    private int nr_armatora;
    private int nr_adresu;
    public Pracownik(){}

    //public Pracownik(int id_pracownika, String imie, String nazwisko, int pesel, String data_zatrudnienia, int nr_konta, String email, int nr_telefonu, String plec, int nr_armatora, int nr_adresu) {
    public Pracownik(int id_pracownika, String imie, String nazwisko, String pesel, String data_zatrudnienia, String nr_konta, String email, String nr_telefonu, String plec, int nr_armatora, int nr_adresu) {
        this.id_pracownika = id_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.data_zatrudnienia = data_zatrudnienia;
        this.nr_konta = nr_konta;
        this.email = email;
        this.nr_telefonu = nr_telefonu;
        this.plec = plec;
        this.nr_armatora = nr_armatora;
        this.nr_adresu = nr_adresu;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(String data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public String getNr_konta() {
        return nr_konta;
    }

    public void setNr_konta(String nr_konta) {
        this.nr_konta = nr_konta;
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

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
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
        return "Pracownik{" +
                "id_pracownika=" + id_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel=" + pesel +
                ", data_zatrudnienia='" + data_zatrudnienia + '\'' +
                ", nr_konta=" + nr_konta +
                ", email='" + email + '\'' +
                ", nr_telefonu=" + nr_telefonu +
                ", plec='" + plec + '\'' +
                ", nr_armatora=" + nr_armatora +
                ", nr_adresu=" + nr_adresu +
                '}';
    }
}
