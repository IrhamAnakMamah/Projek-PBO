package Benda3D;

import Benda.Benda3D;
import Benda2D.BelahKetupat;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class LimasBelahKetupat extends BelahKetupat implements Benda3D, Runnable{
    private double volumeLimasBelahKetupat;
    private double luasPermukaanLimasBelahKetupat;
    private double tinggiLimas;
    private double tinggiSisiTegak;

    public LimasBelahKetupat(double diagonal1, double diagonal2, double tinggiBelahKetupat, double tinggiSisiTegak) {
        super(diagonal1, diagonal2);
        this.tinggiLimas = tinggiBelahKetupat;
        this.tinggiSisiTegak = tinggiSisiTegak;
    }

    @Override
    public void run() {
        System.out.println("Menghitung Limas Belah Ketupat");
        super.run();
        volumeLimasBelahKetupat = hitungVolume();
        luasPermukaanLimasBelahKetupat = hitungLuas();
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public double getTinggiSisiTegak() {
        return tinggiSisiTegak;
    }

    @Override
    public String getNama(){
        return "Limas Belah Ketupat";
    }

    @Override
    public double hitungVolume() {
        return (double)((double)1/3 * ((double)1/2 * super.diagonal1 * super.diagonal2) * tinggiLimas);
    }

    public double getVolumeLimasBelahKetupat() {
        return volumeLimasBelahKetupat;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * diagonal1 + getKelilingBelahKetupat() * tinggiLimas;
    }

    public double getLuasPermukaanBelahKetupat() {
        return luasPermukaanLimasBelahKetupat;
    }


}