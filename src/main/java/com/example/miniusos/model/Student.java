package com.example.miniusos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "studenci")
@Table(name = "studenci")
public class Student extends Uzytkownik {

    @Id
    private Long id;

    @OneToMany(cascade=CascadeType.ALL,
            mappedBy = "student")
    private Set<Ocena> oceny = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "studenci_przedmioty",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "przedmiot_id")
    )
    private Set<Przedmiot> przedmioty = new HashSet<>();

    public Student(){
    }

    public Student(String imie, String nazwisko, String email, int numerTelefonu, String login, String haslo, Long index) {
        super(imie, nazwisko, email, numerTelefonu, login, haslo);
        this.id = index;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long index) {
        this.id = index;
    }

    public Set<Ocena> getOceny() {
        return oceny;
    }

    public void setOceny(Set<Ocena> oceny) {
        this.oceny = oceny;
    }

    public Set<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }

    public void setPrzedmioty(Set<Przedmiot> przedmioty) {
        this.przedmioty = przedmioty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "index=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id != null ? id.equals(student.id) : student.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
