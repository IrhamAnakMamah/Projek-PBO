package Benda3D;

import Benda.Benda3D;
import Benda2D.PersegiPanjang;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class LimasPersegiPanjang extends PersegiPanjang implements Benda3D, Runnable {
    public double volumeLimasPersegiPanjang;
    public double tinggiLimasPersegiPanjang;
    public double luasPermukaanLimasPersegiPanjang;

    public LimasPersegiPanjang(double panjang, double lebar, double tinggiLimasPersegiPanjang) {
        super(panjang, lebar);
        this.tinggiLimasPersegiPanjang = tinggiLimasPersegiPanjang;
    }

    @Override
    public void run() {
        System.out.println("Menghitung " + getNama());
        super.run();
        volumeLimasPersegiPanjang = hitungVolume();
        luasPermukaanLimasPersegiPanjang = hitungLuasPermukaan();
    }

    public double getTinggiLimasPersegiPanjang() {
        return tinggiLimasPersegiPanjang;
    }

    @Override
    public String getNama(){
        return "Limas Persegi Panjang";
    }

    @Override
    public double hitungVolume() {
        return (double)1.0/3.0 * getLuasPersegiPanjang() * tinggiLimasPersegiPanjang;
    }

    public double getVolumeLimasPersegiPanjang() {
        return volumeLimasPersegiPanjang;
    }

    @Override
    public double hitungLuasPermukaan() {
        return getLuasPersegiPanjang() + (super.panjang * tinggiLimasPersegiPanjang) + (super.lebar * tinggiLimasPersegiPanjang);
    }

    public double getLuasPermukaanLimasPersegiPanjang() {
        return hitungLuasPermukaan();
    }

}