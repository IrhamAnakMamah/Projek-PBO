package Benda2D;

import Benda.Benda2D;

/**
 * 
 */
public class Segitiga extends Benda2D{

    public double sisi;
    public double tinggi;
    protected double luasSegitiga;
    protected double kelilingSegitiga;

    public Segitiga(double sisi, double tinggi) {
        this.sisi = sisi;
        this.tinggi = tinggi;
        this.kelilingSegitiga = hitungKeliling();
        this.luasSegitiga = hitungLuas();
    }

    @Override
    public String getNama(){
        return "Segitiga";
    }

    @Override
    public double hitungLuas() {
        luasSegitiga = 0.5 * sisi * tinggi;
        return luasSegitiga;
    }

    public double hitungLuas(double sisiBaru, double tinggiBaru) {
        luasSegitiga = 0.5 * sisiBaru * tinggiBaru;
        return luasSegitiga;
    }

    public double getLuasSegitiga() {
        return luasSegitiga;
    }

    @Override
    public double hitungKeliling() {
        kelilingSegitiga = 3 * sisi;
        return kelilingSegitiga;
    }

    public double hitungKeliling(double sisiBaru) {
        kelilingSegitiga = 3 * sisiBaru;
        return kelilingSegitiga;
    }

    public double getKelilingSegitiga() {
        return kelilingSegitiga;
    }

}