package Benda3D;

import Benda.Benda3D;
import Benda2D.Trapesium;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class LimasTrapesium extends Trapesium implements Benda3D {
    private double tinggiLimas;
    private double tinggiSisiTegak1;
    private double tinggiSisiTegak2;
    private double volumeLimasTrapesium;
    private double luasPermukaanLimasTrapesium;

    public LimasTrapesium(double sisiSejajar1, double tinggiSisiSejajar2, double tinggi, double tinggiSisiTegak1, double tinggiSisiTegak2) {
        super(sisiSejajar1, tinggiSisiSejajar2, tinggi);
        this.tinggiLimas = tinggi;
        this.tinggiSisiTegak1 = tinggiSisiTegak1;
        this.tinggiSisiTegak2 = tinggiSisiTegak2;
        volumeLimasTrapesium = hitungVolume();
        luasPermukaanLimasTrapesium = hitungLuasPermukaan();
    }

    @Override
    public String getNama(){
        return "Limas Trapesium";
    }

    @Override
    public double hitungVolume() {
        return (double)1/3 * getLuasTrapesium() * tinggiLimas;
    }

    public double getVolumeLimasTrapesium() {
        return volumeLimasTrapesium;
    }

    @Override
    public double hitungLuasPermukaan() {
        return getLuasPermukaanLimasTrapesium() + getKelilingTrapesium();
    }

    public double getLuasPermukaanLimasTrapesium() {
        return 0;
    }

}