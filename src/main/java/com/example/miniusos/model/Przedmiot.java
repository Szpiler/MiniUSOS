package com.example.miniusos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "przedmioty")
@Table(name = "przedmioty")
public class Przedmiot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nazwa;
    private int maxIloscStudentow;

    @ManyToMany(mappedBy = "przedmioty")
    private Set<Student> studenci = new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL,
    mappedBy = "przedmiot")
    private Set<Ocena> oceny = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "pracownik_naukowy_id")
    private PracownikNaukowy prowadzacy;

    @OneToMany(cascade=CascadeType.ALL,
            mappedBy = "przedmiot")
    private Set<Kolokwium> kolokwia = new HashSet<>();

    public Przedmiot() {
    }

    public Przedmiot(String nazwa, int limit) {
        this.nazwa = nazwa;
        this.maxIloscStudentow = limit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getMaxIloscStudentow() {
        return maxIloscStudentow;
    }

    public void setMaxIloscStudentow(int limit) {
        this.maxIloscStudentow = limit;
    }

    public PracownikNaukowy getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(PracownikNaukowy prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public Set<Student> getStudenci() {
        return studenci;
    }

    public void setStudenci(Set<Student> studenci) {
        this.studenci = studenci;
    }

    public Set<Ocena> getOceny() {
        return oceny;
    }

    public void setOceny(Set<Ocena> oceny) {
        this.oceny = oceny;
    }

    public Set<Kolokwium> getKolokwia() {
        return kolokwia;
    }

    public void setKolokwia(Set<Kolokwium> kolokwia) {
        this.kolokwia = kolokwia;
    }

    @Override
    public String toString() {
        return "Przedmiot{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", maxIloscStudentow=" + maxIloscStudentow +
                ", studenci=" + studenci +
                ", oceny=" + oceny +
                ", prowadzacy=" + prowadzacy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Przedmiot przedmiot = (Przedmiot) o;

        return id != null ? id.equals(przedmiot.id) : przedmiot.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
