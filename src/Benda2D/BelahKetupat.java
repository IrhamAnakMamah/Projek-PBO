package Benda2D;

import Benda.Benda2D;

import java.io.Serializable;

/**
 * 
 */
public class BelahKetupat extends Benda2D{
    public double diagonal1;
    public double diagonal2;
    protected double sisiMiringBelahKetupat;
    protected double luasBelahKetupat;
    protected double kelilingBelahKetupat;

    public BelahKetupat(double diagonal1, double diagonal2) {
        System.out.println("TEST");
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiMiringBelahKetupat = 0.0;
        this.kelilingBelahKetupat = hitungKeliling();
        this.luasBelahKetupat = hitungLuas();
    }

    @Override
    public String getNama(){
        return "Belah Ketupat";
    }

    @Override
    public double hitungLuas() {
        luasBelahKetupat = 0.5 * diagonal1 * diagonal2;
        return luasBelahKetupat;
    }

    public double hitungLuas(double diagonal1Baru, double diagonal2Baru) {
        luasBelahKetupat = 0.5 * diagonal1Baru * diagonal2Baru;
        return luasBelahKetupat;
    }

    public double getLuasBelahKetupat() {
        return luasBelahKetupat;
    }

    @Override
    public double hitungKeliling() {
        kelilingBelahKetupat = 2 * (diagonal1 + diagonal2);
        return kelilingBelahKetupat;
    }

    public double hitungKeliling(double diagonal1Baru, double diagonal2Baru) {
        kelilingBelahKetupat = 2 * (diagonal1Baru + diagonal2Baru);
        return kelilingBelahKetupat;
    }

    public double getKelilingBelahKetupat() {
        return kelilingBelahKetupat;
    }

}