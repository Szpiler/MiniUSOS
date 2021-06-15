package com.example.miniusos.model;

public class DolaczDoPrzedmiotForm {

    private int obecna_ilosc_studentow;
    private Student student;
    private Przedmiot przedmiot;
    private int id_przycisk;

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId_przycisk() {
        return id_przycisk;
    }

    public void setId_przycisk(int id_przycisk) {
        this.id_przycisk = id_przycisk;
    }

    public int getObecna_ilosc_studentow() {
        return obecna_ilosc_studentow;
    }

    public void setObecna_ilosc_studentow(int obecna_ilosc_studentow) {
        this.obecna_ilosc_studentow = obecna_ilosc_studentow;
    }



}
