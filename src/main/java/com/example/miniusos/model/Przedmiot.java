package com.example.miniusos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Przedmiot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nazwa;
    private int limit;

    @ManyToMany
    @JoinTable(
            name = "studenci_przedmioty",
            joinColumns = @JoinColumn(name = "przedmiot_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_index", referencedColumnName = "index")
    )
    private Set<Student> studenci = new HashSet<>();

    @OneToMany
    private Set<Ocena> oceny = new HashSet<>();

    public Przedmiot() {
    }

    public Przedmiot(String nazwa, int limit) {
        this.nazwa = nazwa;
        this.limit = limit;
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

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
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

    @Override
    public String toString() {
        return "Przedmiot{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", limit=" + limit +
                ", studenci=" + studenci +
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
