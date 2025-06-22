package Benda2D;

import Benda.Benda2D;

/**
 * 
 */
public class PersegiPanjang extends Benda2D{

    public double panjang;
    public double lebar;
    protected double luasPersegiPanjang;
    protected double kelilingPersegiPanjang;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.kelilingPersegiPanjang = hitungKeliling();
        this.luasPersegiPanjang = hitungLuas();
    }

    @Override
    public String getNama(){
        return "Persegi Panjang";
    }

    @Override
    public double hitungLuas() {
        luasPersegiPanjang =  lebar * panjang;
        return luasPersegiPanjang;
    }

    public double hitungLuas(double lebarBaru, double panjangBaru) {
        luasPersegiPanjang =  lebarBaru * panjangBaru;
        return luasPersegiPanjang;
    }

    public double getLuasPersegiPanjang() {
        return luasPersegiPanjang;
    }

    @Override
    public double hitungKeliling() {
        kelilingPersegiPanjang = 2 * (panjang + lebar);
        return kelilingPersegiPanjang;
    }

    public double hitungKeliling(double lebarBaru, double panjangBaru) {
        kelilingPersegiPanjang = 2 * (panjangBaru + lebarBaru);
        return kelilingPersegiPanjang;
    }

    public double getKelilingPersegiPanjang() {
        return kelilingPersegiPanjang;
    }

}