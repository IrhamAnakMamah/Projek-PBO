package Benda2D;

import Benda.Benda2D;

/**
 * 
 */
public class JajarGenjang extends Benda2D{

    public double alas;
    public double tinggi;
    public double sudutLancip;
    protected double luasJajarGenjang;
    protected double kelilingJajarGenjang;
    protected double sisi;

    public JajarGenjang(double alas, double tinggi, double sudutLancip) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sudutLancip = sudutLancip;
        this.kelilingJajarGenjang = hitungKeliling();
        this.luasJajarGenjang = hitungLuas();
    }

    @Override
    public String getNama(){
        return "Jajar Genjang";
    }

    @Override
    public double hitungLuas() {
        luasJajarGenjang = alas * tinggi;
        return luasJajarGenjang;
    }

    public double hitungLuas(double alasBaru, double tinggiBaru) {
        luasJajarGenjang = alasBaru * tinggiBaru;
        return luasJajarGenjang;
    }

    public double getLuasJajarGenjang() {
        return luasJajarGenjang;
    }

    @Override
    public double hitungKeliling() {
        kelilingJajarGenjang = 2 * (alas + sisi);
        return kelilingJajarGenjang;
    }

    public double hitungKeliling(double alasBaru, double sisiBaru) {
        kelilingJajarGenjang = 2 * (alasBaru + sisiBaru);
        return kelilingJajarGenjang;
    }

    public double getKelilingJajarGenjang() {
        return 0;
    }

}