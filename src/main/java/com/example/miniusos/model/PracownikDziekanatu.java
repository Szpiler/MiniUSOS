package com.example.miniusos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "pracownicy_dziekanatu")
@Table(name = "pracownicy_dziekanatu")
public class PracownikDziekanatu extends Uzytkownik {
    @Id
    private Long id;

    @OneToMany(cascade= CascadeType.ALL,
            mappedBy = "pracownikD")
    private Set<Przedmiot> przedmioty = new HashSet<>();

    public PracownikDziekanatu(){
    }

    public PracownikDziekanatu(String imie, String nazwisko, String email, int numerTelefonu, String login, String haslo, Long index) {
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
        return "PracownikDziekanatu{" +
                "id=" + id +
                ", przedmioty=" + przedmioty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PracownikDziekanatu that = (PracownikDziekanatu) o;

        return przedmioty != null ? przedmioty.equals(that.przedmioty) : that.przedmioty == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
