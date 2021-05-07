package com.example.miniusos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student extends Uzytkownik {

    @Id
    private Long index;

    //private Set<Ocena> oceny = new HashSet<>();

    @ManyToMany(mappedBy = "studenci")
    private Set<Przedmiot> przedmioty = new HashSet<>();

    public Student(){
    }

    public Student(String imie, String nazwisko, String email, int numerTelefonu, String login, String haslo, Long index) {
        super(imie, nazwisko, email, numerTelefonu, login, haslo);
        this.index = index;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    //public Set<Ocena> getOceny() {
       // return oceny;
   // }

   // public void setOceny(Set<Ocena> oceny) {
      //  this.oceny = oceny;
   // }

    public Set<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }

    public void setPrzedmioty(Set<Przedmiot> przedmioty) {
        this.przedmioty = przedmioty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "index=" + index +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return index != null ? index.equals(student.index) : student.index == null;
    }

    @Override
    public int hashCode() {
        return index != null ? index.hashCode() : 0;
    }
}
