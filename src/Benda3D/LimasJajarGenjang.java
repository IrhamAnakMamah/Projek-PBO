package Benda3D;

import Benda.Benda3D;
import Benda2D.JajarGenjang;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class LimasJajarGenjang extends JajarGenjang implements Benda3D{
    private double volumeLimasJajarGenjang;
    private double luasPermukaanLimasJajarGenjang;
    private double tinggiLimas;

    public LimasJajarGenjang(double alasJajarGenjang, double tinggiJajarGenjang, double sudutLancip, double tinggiLimas) {
        super(alasJajarGenjang, sudutLancip, tinggiJajarGenjang);
        this.tinggiLimas = tinggiLimas;
        this.volumeLimasJajarGenjang = hitungVolume();
        this.luasPermukaanLimasJajarGenjang = hitungLuasPermukaan();
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    @Override
    public String getNama(){
        return "Limas Jajar Genjang";
    }

    @Override
    public double hitungVolume() {
        volumeLimasJajarGenjang = (1.0/3.0) * super.luasJajarGenjang * tinggiLimas;
        return volumeLimasJajarGenjang;
    }

    public double hitungVolume(double alasBaru, double tinggiBaru, double tinggiLimasBaru) {
        volumeLimasJajarGenjang = (1.0/3.0) * alasBaru * tinggiBaru * tinggiLimasBaru;
        return volumeLimasJajarGenjang;
    }

    public double getVolumeLimasJajarGenjang() {
        return volumeLimasJajarGenjang;
    }

    @Override
    public double hitungLuasPermukaan() {
        double a = super.alas;
        double b = super.sisi;
        double tinggiSegitigaA = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow((b / 2), 2));
        double tinggiSegitigaB = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow((a / 2), 2));
        double luasSisiA = a * tinggiSegitigaA / 2;
        double luasSisiB = b * tinggiSegitigaB / 2;
        luasPermukaanLimasJajarGenjang = super.luasJajarGenjang + 2 * (luasSisiA + luasSisiB);
        return luasPermukaanLimasJajarGenjang;
    }

    public double hitungLuasPermukaan(double alasBaru, double tinggiBaru, double tinggiLimasBaru) {
        double a = super.alas;
        double b = super.sisi;
        double tinggiSegitigaA = Math.sqrt(Math.pow(tinggiLimasBaru, 2) + Math.pow((b / 2), 2));
        double tinggiSegitigaB = Math.sqrt(Math.pow(tinggiLimasBaru, 2) + Math.pow((a / 2), 2));
        luasPermukaanLimasJajarGenjang = (alasBaru * tinggiBaru) + 2 * (a * tinggiSegitigaA / 2 + b * tinggiSegitigaB / 2);
        return luasPermukaanLimasJajarGenjang;
    }

    public double getLuasPermukaanLimasJajarGenjang() {
        return luasPermukaanLimasJajarGenjang;
    }

}