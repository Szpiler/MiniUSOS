package com.example.miniusos.model;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy= InheritanceType.JOINED)
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
            nullable = false
    )
    private int numerTelefonu;

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

    public Uzytkownik(String imie, String nazwisko, String email, int numerTelefonu, String login, String haslo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.numerTelefonu = numerTelefonu;
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

    public int getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(int numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
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
                ", numerTelefonu=" + numerTelefonu +
                ", login='" + login + '\'' +
                '}';
    }
}
