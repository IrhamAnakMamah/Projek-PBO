package Benda3D;

import Benda.Benda3D;
import Benda2D.Trapesium;

import java.io.*;
import java.util.*;

public class LimasTrapesium extends Trapesium implements Benda3D, Runnable{
    private double tinggiLimas;
    private double tinggiSisiTegak1;
    private double tinggiSisiTegak2;
    private double volumeLimasTrapesium;
    private double luasPermukaanLimasTrapesium;

    public LimasTrapesium(double sisiSejajar1, double SisiSejajar2, double tinggi, double tinggiLimas, double tinggiSisiTegak1, double tinggiSisiTegak2) {
        super(sisiSejajar1, SisiSejajar2, tinggi);
        this.tinggiLimas = tinggiLimas;
        this.tinggiSisiTegak1 = tinggiSisiTegak1;
        this.tinggiSisiTegak2 = tinggiSisiTegak2;
    }

    @Override
    public void run() {
        System.out.println("Menghitung " + getNama());
        super.run();
        volumeLimasTrapesium = hitungVolume();
        luasPermukaanLimasTrapesium = hitungLuasPermukaan();
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public double getTinggiSisiTegak1() {
        return tinggiSisiTegak1;
    }

    public double getTinggiSisiTegak2() {
        return tinggiSisiTegak2;
    }

    @Override
    public String getNama(){
        return "Limas Trapesium";
    }

    @Override
    public double hitungVolume() {
        return (double)1.0/3.0 * getLuasTrapesium() * tinggiLimas;
    }

    public double getVolumeLimasTrapesium() {
        return volumeLimasTrapesium;
    }

    @Override
    public double hitungLuasPermukaan() {
        return getLuasPermukaanLimasTrapesium() + getKelilingTrapesium();
    }

    public double getLuasPermukaanLimasTrapesium() {
        return luasPermukaanLimasTrapesium;
    }

}