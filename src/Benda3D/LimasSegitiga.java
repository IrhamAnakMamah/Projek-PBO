package Benda3D;

import Benda.Benda3D;
import Benda2D.Segitiga;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class LimasSegitiga extends Segitiga implements Benda3D,Runnable {
    private double tinggiLimasSegitiga;
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
    }

    @Override
    public void run() {
        System.out.println("Menghitung " + getNama());
        super.run();
        volumeLimasSegitiga = hitungVolume();
        luasPermukaanLimasSegitiga = hitungLuasPermukaan();
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
        return (double)1.0/3.0 * (tinggiLimasSegitiga * getLuasSegitiga());
    }

    public double getVolumeLimasSegitiga() {
        return volumeLimasSegitiga;
    }

    @Override
    public double hitungLuasPermukaan() {
        return getLuasSegitiga() + totalSisi;
    }

    public double getLuasPermukaanLimasPersegiPanjang() {
        return luasPermukaanLimasSegitiga;
    }

}