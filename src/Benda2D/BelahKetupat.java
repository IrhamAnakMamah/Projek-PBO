package Benda2D;

import Benda.BendaGeometri;

import java.io.*;
import java.util.*;

public class BelahKetupat implements BendaGeometri, Runnable{
    public double diagonal1;
    public double diagonal2;
    private double sisiMiringBelahKetupat;
    private double luasBelahKetupat;
    private double kelilingBelahKetupat;

    public BelahKetupat(double diagonal1, double diagonal2) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiMiringBelahKetupat = 0.0;
    }

    @Override
    public void run() {
        System.out.println("Menghitung Belah Ketupat");
        this.luasBelahKetupat = hitungLuas();
        this.kelilingBelahKetupat = hitungKeliling();
    }

    @Override
    public double hitungLuas() {
        return 0.5 * diagonal1 * diagonal2;
    }

    public double getLuasBelahKetupat() {
        return luasBelahKetupat;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (diagonal1 + diagonal2);
    }

    public double getKelilingBelahKetupat() {
        return kelilingBelahKetupat;
    }

}