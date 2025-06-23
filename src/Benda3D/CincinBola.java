package Benda3D;

import Benda.Benda3D;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class CincinBola extends Bola implements Benda3D{
    private double jariJariDalam;
    private double jarakDuaBidang;
    private double volumeCincinBola;
    private double luasPermukaanCincinBola;


    public CincinBola(double jariJari, double jariJariDalam, double jarakDuaBidang) {
        super(jariJari);
        this.jarakDuaBidang = jarakDuaBidang;
        this.volumeCincinBola = hitungLuas();
        this.luasPermukaanCincinBola = hitungLuasPermukaan();
        this.volumeCincinBola = hitungVolume();
    }

    public double getJariJariDalam() {
        return jariJariDalam;
    }

    public double getJarakDuaBidang() {
        return jarakDuaBidang;
    }

    @Override
    public String getNama(){
        return "Cincin Bola";
    }


    @Override
    public double hitungVolume() {
        double h = jarakDuaBidang;
        double r = super.getJariJari();
        volumeCincinBola = super.pi * h * h * (r - h / 3.0);
        return volumeCincinBola;
    }

    public double hitungVolume(double jariJariBaru, double jarakDuaBidangBaru) {
        volumeCincinBola = super.pi * jarakDuaBidangBaru * jarakDuaBidangBaru * (jariJariBaru - jarakDuaBidangBaru / 3.0);
        return volumeCincinBola;
    }


    @Override
    public double hitungLuasPermukaan() {
        double h = jarakDuaBidang;
        double r = super.getJariJari();
        luasPermukaanCincinBola = 2 * pi * r * h;
        return luasPermukaanCincinBola;
    }
    public double hitungLuasPermukaan(double jariJariBaru, double tinggiCincinBaru) {
        luasPermukaanCincinBola = 2 * super.pi* jariJariBaru * tinggiCincinBaru;
        return luasPermukaanCincinBola;
    }


    public double getLuasPermukaanCincinBola() {
        return luasPermukaanCincinBola;
    }

    public double getVolumeCincinBola() {
        return 0;
    }

}