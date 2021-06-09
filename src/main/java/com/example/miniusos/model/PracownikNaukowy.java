package com.example.miniusos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "pracownicy_naukowy")
@Table(name = "pracownicy_naukowy")
public class PracownikNaukowy extends Uzytkownik {
    @Id
    private Long id;

    @OneToMany(cascade=CascadeType.ALL,
            mappedBy = "prowadzacy")
    private Set<Przedmiot> przedmioty = new HashSet<>();

    public PracownikNaukowy(){
    }

    public PracownikNaukowy(String imie, String nazwisko, String email, int numerTelefonu, String login, String haslo, Long index) {
        super(imie, nazwisko, email, numerTelefonu, login, haslo);
        this.id = index;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long index) {
        this.id = index;
    }

    public Set<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }

    public void setPrzedmioty(Set<Przedmiot> przedmioty) {
        this.przedmioty = przedmioty;
    }

    @Override
    public String toString() {
        return "PracownikNaukowy{" +
                "id=" + id +
                ", przedmioty=" + przedmioty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PracownikNaukowy that = (PracownikNaukowy) o;

        return przedmioty != null ? przedmioty.equals(that.przedmioty) : that.przedmioty == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
