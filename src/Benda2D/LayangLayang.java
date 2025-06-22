package Benda2D;

import Benda.Benda2D;

/**
 * 
 */
public class LayangLayang extends Benda2D{

    public double diagonal1;
    public double diagonal2;
    public double sisi1;
    public double sisi2;
    protected double luasLayangLayang;
    protected double kelilingLayangLayang;

    public LayangLayang(double diagonal1, double diagonal2, double sisi1, double sisi2) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.kelilingLayangLayang = hitungKeliling();
        this.luasLayangLayang = hitungLuas();
    }

    @Override
    public String getNama(){
        return "Layang-Layang" ;
    }

    @Override
    public double hitungLuas() {
        luasLayangLayang = 0.5 * diagonal1 * diagonal2;
        return luasLayangLayang;
    }

    public double hitungLuas(double diagonal1Baru, double diagonal2Baru) {
        luasLayangLayang = 0.5 * diagonal1Baru * diagonal2Baru;
        return luasLayangLayang;
    }

    public double getLuasLayangLayang() {
        return luasLayangLayang;
    }

    @Override
    public double hitungKeliling() {
        kelilingLayangLayang = 2 * (diagonal1 + diagonal2);
        return kelilingLayangLayang;
    }

    public double hitungKeliling(double diagonal1Baru, double diagonal2Baru) {
        kelilingLayangLayang = 2 * (diagonal1Baru + diagonal2Baru);
        return kelilingLayangLayang;
    }

    public double getKelilingLayangLayang() {
        return kelilingLayangLayang;
    }

}