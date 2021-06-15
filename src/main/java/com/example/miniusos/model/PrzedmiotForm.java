package com.example.miniusos.model;

public class PrzedmiotForm {
    private String nazwa;
    private int maxIloscStudentow;
    private String nauczyciel;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getMaxIloscStudentow() {
        return maxIloscStudentow;
    }

    public void setMaxIloscStudentow(int maxIloscStudentow) {
        this.maxIloscStudentow = maxIloscStudentow;
    }

    public String getNauczyciel() {
        return nauczyciel;
    }

    public void setNauczyciel(String nauczyciel) {
        this.nauczyciel = nauczyciel;
    }
}
