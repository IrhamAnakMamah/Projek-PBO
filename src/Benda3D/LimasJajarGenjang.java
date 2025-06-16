package Benda3D;

import Benda.Benda3D;
import Benda2D.JajarGenjang;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class LimasJajarGenjang extends JajarGenjang implements Benda3D, Runnable{
    private double volumeLimasJajarGenjang;
    private double luasPermukaanLimasJajarGenjang;
    private double tinggiLimas;

    public LimasJajarGenjang(double alasJajarGenjang, double tinggiJajarGenjang, double sudutLancip, double tinggiLimas) {
        super(alasJajarGenjang, sudutLancip, tinggiJajarGenjang);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public void run() {
        System.out.println("Menghitug " + getNama());
        super.run();
        volumeLimasJajarGenjang = hitungVolume();
        luasPermukaanLimasJajarGenjang = hitungLuasPermukaan();
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
        return getLuasJajarGenjang() * tinggiLimas;
    }

    public double getVolumeLimasJajarGenjang() {
        return volumeLimasJajarGenjang;
    }

    @Override
    public double hitungLuasPermukaan() {
        return (getKelilingJajarGenjang() * tinggiLimas) + (2 * getLuasJajarGenjang());
    }

    public double getLuasPermukaanLimasJajarGenjang() {
        return luasPermukaanLimasJajarGenjang;
    }

}