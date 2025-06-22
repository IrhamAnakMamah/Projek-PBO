package Benda2D;

import Benda.Benda2D;

/**
 * 
 */
public class Trapesium extends Benda2D{
    public double sisiSejajar1;
    public double sisiSejajar2;
    public double tinggi;
    public double sisiMiring;
    private double luasTrapesium;
    private double kelilingTrapesium;

    public Trapesium(double sisiSejajar1, double sisiSejajar2, double tinggi) {
        this.sisiSejajar1 = sisiSejajar1;
        this.sisiSejajar2 = sisiSejajar2;
        this.tinggi = tinggi;
        this.sisiMiring = 0;
        this.kelilingTrapesium = hitungKeliling();
        this.luasTrapesium = hitungLuas();
    }

    @Override
    public String getNama(){
        return "Trapesium";
    }

    @Override
    public double hitungLuas() {
        luasTrapesium = 0.5 * (sisiSejajar1 * sisiSejajar2) * tinggi;
        return luasTrapesium;
    }

    public double hitungLuas(double sisiSejajar1Baru, double sisiSejajar2Baru, double tinggiBaru) {
        luasTrapesium = 0.5 * (sisiSejajar1Baru * sisiSejajar2Baru) * tinggiBaru;
        return luasTrapesium;
    }

    public double getLuasTrapesium() {
        return luasTrapesium;
    }

    @Override
    public double hitungKeliling() {
        kelilingTrapesium = 2 * (sisiSejajar1 + sisiSejajar2);
        return kelilingTrapesium;
    }

    public double hitungKeliling(double sisiSejajar1Baru, double sisiSejajar2Baru) {
        kelilingTrapesium = 2 * (sisiSejajar1Baru + sisiSejajar2Baru);
        return kelilingTrapesium;
    }

    public double getKelilingTrapesium() {
        return kelilingTrapesium;
    }

}