package Benda2D;

import Benda.Benda2D;

/**
 * 
 */
public class Persegi extends Benda2D {

    public double sisi;
    protected double luasPersegi;
    protected double kelilingPersegi;

    public Persegi(double sisi) {
        this.sisi = sisi;
        this.luasPersegi = hitungLuas();
        this.kelilingPersegi = hitungKeliling();
    }

    @Override
    public String getNama(){
        return "Persegi";
    }

    @Override
    public double hitungLuas() {
        luasPersegi = sisi * sisi;
        return luasPersegi;
    }

    public double hitungLuas(double sisiBaru){
        luasPersegi = sisi * sisi;
        return luasPersegi;
    }

    public double getLuasPersegi() {
        return luasPersegi;
    }

    @Override
    public double hitungKeliling() {
        kelilingPersegi = 4 * sisi;
        return kelilingPersegi;
    }

    public double hitungKeliling(double sisiBaru) {
        kelilingPersegi = 4 * sisiBaru;
        return kelilingPersegi;
    }

    public double getKelilingPersegi() {
        return kelilingPersegi;
    }

}