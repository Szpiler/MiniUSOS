package com.example.miniusos.model;

public class WystawOceneForm {
    private Long idPrzedmiotu;
    private Long studentindeks;
    private int ocena;

    public Long getIdPrzedmiotu() {
        return idPrzedmiotu;
    }

    public void setNazwaPrzedmiotu(Long idPrzedmiotu) {
        this.idPrzedmiotu = idPrzedmiotu;
    }

    public Long getStudentindeks() {
        return studentindeks;
    }

    public void setStudentindeks(Long studentindeks) {
        this.studentindeks = studentindeks;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
}
