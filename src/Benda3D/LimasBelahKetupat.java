package Benda3D;

import Benda.Benda3D;
import Benda2D.BelahKetupat;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class LimasBelahKetupat extends BelahKetupat implements Benda3D{
    private double volumeLimasBelahKetupat;
    private double luasPermukaanLimasBelahKetupat;
    private double tinggiLimas;
    private double tinggiSisiTegak;

    public LimasBelahKetupat(double diagonal1, double diagonal2, double tinggiBelahKetupat, double tinggiSisiTegak) {
        super(diagonal1, diagonal2);
        this.tinggiLimas = tinggiBelahKetupat;
        this.tinggiSisiTegak = tinggiSisiTegak;
        this.volumeLimasBelahKetupat = hitungVolume();
        this.kelilingBelahKetupat = hitungLuasPermukaan();
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
        volumeLimasBelahKetupat = (double)((double)1.0/3.0 * ((double)1.0/2.0 * super.diagonal1 * super.diagonal2) * tinggiLimas);
        return volumeLimasBelahKetupat;
    }

    public double hitungVolume(double diagonal1Baru, double diagonal2Baru, double tinggiLimasBaru) {
        volumeLimasBelahKetupat = (double)((double)1.0/3.0 * ((double)1.0/2.0 * diagonal1Baru * diagonal2Baru) * tinggiLimasBaru);
        return volumeLimasBelahKetupat;
    }

    public double getVolumeLimasBelahKetupat() {
        return volumeLimasBelahKetupat;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanLimasBelahKetupat = 2 * diagonal1 + getKelilingBelahKetupat() * tinggiLimas;
        return luasPermukaanLimasBelahKetupat;
    }

    public double hitungLuasPermukaan(double diagonal1Baru, double diagonal2Baru, double tinggiLimasBaru) {
        luasPermukaanLimasBelahKetupat = 2 * diagonal1Baru + super.hitungKeliling(diagonal1Baru, diagonal2Baru) * tinggiLimasBaru;
        return luasPermukaanLimasBelahKetupat;
    }

    public double getLuasPermukaanBelahKetupat() {
        return luasPermukaanLimasBelahKetupat;
    }


}