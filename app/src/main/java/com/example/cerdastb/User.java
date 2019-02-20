package com.example.cerdastb;

public class User {
    private String Nama;
    private int Posttest,Pretest;

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public int getPosttest() {
        return Posttest;
    }

    public void setPosttest(int Posttest) {
        this.Posttest = Posttest;
    }

    public int getPretest() {
        return Pretest;
    }

    public void setPretest(int Pretest) {
        this.Pretest = Pretest;
    }

    public User(String Nama, int Posttest, int Pretest) {
        this.Nama = Nama;
        this.Posttest = Posttest;
        this.Pretest = Pretest;
    }

    public User() {
    }
}