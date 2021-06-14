package com.example.miniusos.model;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Uzytkownik {
    @Column(
            name = "imie",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String imie;

    @Column(
            name = "nazwisko",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nazwisko;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;


    @Column(
            name = "numer_telefonu",
            nullable = false,
            columnDefinition = "integer"
    )
    private int numer_telefonu;

    @Column(
            name = "login",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String login;

    @ColumnTransformer(
            forColumn = "haslo",
            write = "HEX(AES_ENCRYPT(?, 'haslo'))",
            read = "AES_DECRYPT(UNHEX(haslo),'haslo')"
    )
    private String haslo;

    public Uzytkownik() {
    }

    public Uzytkownik(String imie, String nazwisko, String email, int numer_telefonu, String login, String haslo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.numer_telefonu = numer_telefonu;
        this.login = login;
        this.haslo = haslo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(int numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                ", numerTelefonu=" + numer_telefonu +
                ", login='" + login + '\'' +
                '}';
    }
}
