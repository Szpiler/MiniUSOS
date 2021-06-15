package com.example.miniusos.model;

import javax.persistence.*;

@Entity(name = "kolokwia")
@Table(name = "kolokwia")
public class Kolokwium {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "przedmiot_id")
    private Przedmiot przedmiot;


    private String nazwa;

    private int maxIloscPunktow;

    private int zdobytePunkty;

    public Kolokwium() {
    }

    public Kolokwium(Long id, String nazwa, int maxIloscPunktow, int zdobytePunkty) {
        this.id = id;
        this.nazwa = nazwa;
        this.maxIloscPunktow = maxIloscPunktow;
        this.zdobytePunkty = zdobytePunkty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getMaxIloscPunktow() {
        return maxIloscPunktow;
    }

    public void setMaxIloscPunktow(int maxIloscPunktow) {
        this.maxIloscPunktow = maxIloscPunktow;
    }

    public int getZdobytePunkty() {
        return zdobytePunkty;
    }

    public void setZdobytePunkty(int zdobytePunkty) {
        this.zdobytePunkty = zdobytePunkty;
    }

    @Override
    public String toString() {
        return "Kolokwium{" +
                "id=" + id +
                ", przedmiot=" + przedmiot +
                ", nazwa='" + nazwa + '\'' +
                ", maxIloscPunktow=" + maxIloscPunktow +
                ", zdobytePunkty=" + zdobytePunkty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kolokwium kolokwium = (Kolokwium) o;

        return id != null ? id.equals(kolokwium.id) : kolokwium.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
