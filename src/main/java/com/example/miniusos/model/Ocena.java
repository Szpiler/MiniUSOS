package com.example.miniusos.model;

import javax.persistence.*;

@Entity(name = "oceny")
@Table(name = "oceny")
public class Ocena {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "ocena",
            nullable = false
    )
    private int ocena;

    @ManyToOne
    @JoinColumn(name = "studenci_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "przedmioty_id")
    private Przedmiot przedmiot;

    public Ocena() {
    }

    public Ocena(int ocena) {
        this.ocena = ocena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    @Override
    public String toString() {
        return "Ocena{" +
                "id=" + id +
                ", ocena=" + ocena +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ocena ocena = (Ocena) o;

        return id != null ? id.equals(ocena.id) : ocena.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
