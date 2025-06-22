package Benda3D;

import Benda.Benda3D;
import Benda2D.LayangLayang;

import java.io.*;
import java.util.*;

public class LimasLayangLayang extends LayangLayang implements Benda3D{
    private double tinggiLimas;
    private double tinggiSisiTegak1;
    private double tinggiSisiTegak2;
    private double volumeLimasLayangLayang;
    private double luasPermukaanLimasLayangLayang;

    public LimasLayangLayang(double diagonal1, double diagonal2, double sisi1, double sisi2, double tinggiLimas, double tinggiSisiTegak1, double tinggiSisiTegak2) {
        super(diagonal1, diagonal2, sisi1, sisi2);
        this.tinggiLimas = tinggiLimas;
        this.tinggiSisiTegak1 = tinggiSisiTegak1;
        this.tinggiSisiTegak2 = tinggiSisiTegak2;
        this.volumeLimasLayangLayang = hitungVolume();
        this.luasPermukaanLimasLayangLayang = hitungLuasPermukaan();
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
        return "Limas Layang-Layang";
    }

    @Override
    public double hitungVolume() {
        volumeLimasLayangLayang = (1.0 / 3.0) * super.luasLayangLayang * tinggiLimas;
        return volumeLimasLayangLayang;
    }

    public double hitungVolume(double diagonal1Baru, double diagonal2Baru, double tinggiLimasBaru) {
        volumeLimasLayangLayang = (1.0 / 3.0) * (0.5 * diagonal1Baru * diagonal2Baru * tinggiLimasBaru);
        return volumeLimasLayangLayang;
    }

    public double getVolumeLimasLayangLayang() {
        return volumeLimasLayangLayang;
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasAlas = super.luasLayangLayang;
        double a = super.sisi1;
        double b = super.sisi2;
        double tinggiSegitigaPendek = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(a / 2, 2));
        double tinggiSegitigaPanjang = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(b / 2, 2));
        double luasSisiTegak = 2 * (0.5 * a * tinggiSegitigaPendek) + 2 * (0.5 * b * tinggiSegitigaPanjang);
        luasPermukaanLimasLayangLayang =  luasAlas + luasSisiTegak;
        return luasPermukaanLimasLayangLayang;
    }

    public double hitungLuasPermukaan(double diagonal1Baru, double diagonal2Baru, double tinggiBaru) {
        double luasAlas = (diagonal1Baru * diagonal2Baru) / 2;
        double a = super.sisi1;
        double b = super.sisi2;
        double tinggiSegitigaPendek = Math.sqrt(Math.pow(tinggiBaru, 2) + Math.pow(a / 2, 2));
        double tinggiSegitigaPanjang = Math.sqrt(Math.pow(tinggiBaru, 2) + Math.pow(b / 2, 2));
        double luasSisiTegak = 2 * (0.5 * a * tinggiSegitigaPendek) + 2 * (0.5 * b * tinggiSegitigaPanjang);
        luasPermukaanLimasLayangLayang = luasAlas + luasSisiTegak;
        return luasPermukaanLimasLayangLayang;
    }

    public double getLuasPermukaanLimasLayangLayang() {
        return luasPermukaanLimasLayangLayang;
    }

}