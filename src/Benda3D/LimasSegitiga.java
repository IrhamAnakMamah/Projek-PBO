package Benda3D;

import Benda.Benda3D;
import Benda2D.Segitiga;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class LimasSegitiga extends Segitiga implements Benda3D{
    public double tinggiLimasSegitiga;
    private double volumeLimasSegitiga;
    private double luasPermukaanLimasSegitiga;
    private double totalSisi;
    private double sisi1,sisi2,sisi3;

    public LimasSegitiga(double alas, double tinggi, double tinggiLimasSegitiga, double sisi1, double sisi2, double sisi3) {
        super(alas, tinggi);
        this.tinggiLimasSegitiga = tinggiLimasSegitiga;
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
        totalSisi = sisi1 + sisi2 + sisi3;
        this.volumeLimasSegitiga = hitungVolume();
        this.luasPermukaanLimasSegitiga = hitungLuasPermukaan();
    }

    public double getTotalSisi() {
        return totalSisi;
    }

    public double getTinggiLimasSegitiga() {
        return tinggiLimasSegitiga;
    }

    public double getSisi1() {
        return sisi1;
    }

    public double getSisi2() {
        return sisi2;
    }

    public double getSisi3() {
        return sisi3;
    }

    @Override
    public String getNama(){
        return "Limas Segitiga";
    }

    @Override
    public double hitungVolume() {
        volumeLimasSegitiga = (double)1.0/3.0 * (tinggiLimasSegitiga * super.luasSegitiga);
        return volumeLimasSegitiga;
    }

    public double hitungVolume(double alasBaru, double tinggiBaru, double tinggiLimasBaru) {
        volumeLimasSegitiga = (1.0 / 3.0) * super.hitungLuas(alasBaru, tinggiBaru) * tinggiLimasBaru;
        return volumeLimasSegitiga;
    }

    public double getVolumeLimasSegitiga() {
        return volumeLimasSegitiga;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanLimasSegitiga = 4 * ((Math.sqrt(3) / 4.0) * Math.pow(super.sisi, 2));
        return luasPermukaanLimasSegitiga;
    }

    public double hitungLuasPermukaan(double alasBaru, double tinggiBaru, double tinggiLimasBaru) {
        double luasAlas = (Math.sqrt(3) / 4.0) * Math.pow(alasBaru, 2);
        double luasSisiTegak = 3 * 0.5 * alasBaru * tinggiBaru;
        luasPermukaanLimasSegitiga = luasAlas + luasSisiTegak;
        return luasPermukaanLimasSegitiga;
    }

    public double getLuasPermukaanLimasPersegiPanjang() {
        return luasPermukaanLimasSegitiga;
    }

}