package com.example.miniusos.model;

import javax.persistence.*;

@Entity(name = "pracownicy_dziekanatu")
@Table(name = "pracownicy_dziekanatu")
public class PracownikDziekanatu extends Uzytkownik {
    @Id
    private Long id;

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

    @Override
    public String toString() {
        return "PracownikDziekanatu{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PracownikDziekanatu that = (PracownikDziekanatu) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
