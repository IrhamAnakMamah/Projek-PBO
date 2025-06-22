package Benda3D;

import Benda.Benda3D;
import Benda2D.Trapesium;

import java.io.*;
import java.util.*;

public class LimasTrapesium extends Trapesium implements Benda3D{
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
        this.volumeLimasTrapesium = hitungVolume();
        this.luasPermukaanLimasTrapesium = hitungLuasPermukaan();
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
        volumeLimasTrapesium = (double)1.0/3.0 * super.luasTrapesium * tinggiLimas;
        return volumeLimasTrapesium;
    }

    public double hitungVolume(double alasAtasBaru, double sisiSejajar1Baru, double sisiSejajar2Baru, double tinggiBaru, double tinggiLimasBaru) {
        volumeLimasTrapesium = (1.0 / 3.0) * super.hitungLuas(sisiSejajar1Baru, sisiSejajar2Baru, tinggiBaru) * tinggiLimasBaru;
        return volumeLimasTrapesium;
    }

    public double getVolumeLimasTrapesium() {
        return volumeLimasTrapesium;
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasAlas = super.luasTrapesium;

        double tinggiSisiTegak = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow((super.sisiSejajar1 - super.sisiSejajar2) / 2.0, 2));

        double luasSegitigaAtas = 0.5 * super.sisiSejajar1 * tinggiSisiTegak;
        double luasSegitigaBawah = 0.5 * super.sisiSejajar2 * tinggiSisiTegak;
        double luasSegitigaMiring = 2 * (0.5 * super.sisiMiring * tinggiSisiTegak);

        luasPermukaanLimasTrapesium = luasAlas + luasSegitigaAtas + luasSegitigaBawah + luasSegitigaMiring;
        return luasPermukaanLimasTrapesium;
    }

    public double getLuasPermukaanLimasTrapesium() {
        return luasPermukaanLimasTrapesium;
    }

}