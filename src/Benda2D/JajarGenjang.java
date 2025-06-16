package Benda2D;

import Benda.Benda2D;

/**
 * 
 */
public class JajarGenjang extends Benda2D implements Runnable {

    public double alas;
    public double tinggi;
    public double sudutLancip;
    private double luasJajarGenjang;
    private double kelilingJajarGenjang;
    private double sisiMiringJajarGenjang;

    public JajarGenjang(double alas, double tinggi, double sudutLancip) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sudutLancip = sudutLancip;
    }
    @Override
    public void run() {
        System.out.println("Menghitung Jajar Genjang");
        this.luasJajarGenjang = hitungLuas();
        this.kelilingJajarGenjang = hitungKeliling();
    }

    @Override
    public String getNama(){
        return "Jajar Genjang";
    }

    @Override
    public double hitungLuas() {
        return alas * tinggi;
    }

    public double hitungLuas(double sisiPrisma) {

        return sisiPrisma * tinggi;
    }

    public double hitungLuas(double tinggiPrisma, double sisiPrisma) {

        return sisiPrisma * tinggiPrisma;
    }

    public double getLuasJajarGenjang() {
        return luasJajarGenjang;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (alas + tinggi);
    }

    public double getSisiMiringJajarGenjang() {
        return 0;
    }

    public double getKelilingJajarGenjang() {
        return 0;
    }

}