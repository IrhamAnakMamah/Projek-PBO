package Benda3D;

import Benda.Benda3D;
import Benda2D.Lingkaran;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class KerucutTerpancung extends Lingkaran implements Benda3D,Runnable {
    private double jariJariAtas;
    private double garisPelukis;
    private double tinggi;
    private double luasSelimut;
    private double volumeKerucutTerpancung;
    private double luasPermukaanKerucutTerpancung;

    public KerucutTerpancung(double tinggi, double jariJariAtas, double jariJari) {
        super(jariJari);
        this.jariJariAtas = jariJariAtas;
        this.tinggi = tinggi;
    }

    @Override
    public void run() {
        System.out.println("Menghitung Kerucut Terpancung");
        super.run();
        garisPelukis = hitungGarisPelukis();
        luasSelimut = hitungLuasSelimut();
        volumeKerucutTerpancung = hitungVolume();
        luasPermukaanKerucutTerpancung = hitungLuasPermukaan();
    }

    public double getJariJariAtas() {
        return jariJariAtas;
    }

    public double getTinggi() {
        return tinggi;
    }

    @Override
    public String getNama(){
        return "Kerucut Terpancung";
    }

    @Override
    public double hitungVolume() {
        return ((1.0/3.0) * super.pi * tinggi) * (jariJariAtas * jariJariAtas + super.jariJari * super.jariJari + jariJariAtas * super.jariJari);
    }

    @Override
    public double hitungLuasPermukaan() {
        return luasSelimut + super.getKelilingLingkaran() + (super.pi * Math.pow(jariJariAtas, 2));
    }

    public double hitungLuasSelimut() {
        return super.pi * (super.jariJari + jariJariAtas) * garisPelukis;
    }

    public double hitungGarisPelukis(){
        return Math.sqrt(Math.pow(super.jariJari - jariJariAtas, 2) + Math.pow(tinggi, 2));
    }

    public double getLuasPermukaanKerucutTerpancung() {
        return luasPermukaanKerucutTerpancung;
    }

    public double getVolumeKerucutTerpancung() {
        return volumeKerucutTerpancung;
    }

}