package Benda3D;

import Benda.Benda3D;
import Benda2D.Lingkaran;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class KerucutTerpancung extends Lingkaran implements Benda3D{
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
        this.volumeKerucutTerpancung = hitungVolume();
        this.luasPermukaanKerucutTerpancung = hitungLuasPermukaan();
        this.luasSelimut = hitungLuasSelimut();
        this.garisPelukis = hitungGarisPelukis();
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
        volumeKerucutTerpancung = ((1.0/3.0) * super.pi * tinggi) * (jariJariAtas * jariJariAtas + super.jariJari * super.jariJari + jariJariAtas * super.jariJari);
        return volumeKerucutTerpancung;
    }

    public double hitungVolume(double jariJariAtasBaru, double tinggiBaru) {
        volumeKerucutTerpancung = ((1.0/3.0) * super.pi * tinggiBaru) * (jariJariAtasBaru * jariJariAtasBaru + super.jariJari * super.jariJari + jariJariAtasBaru * super.jariJari);
        return volumeKerucutTerpancung;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanKerucutTerpancung = luasSelimut + super.getKelilingLingkaran() + (super.pi * Math.pow(jariJariAtas, 2));
        return luasPermukaanKerucutTerpancung;
    }

    public double hitungLuasSelimut() {
        luasSelimut = super.pi * (super.jariJari + jariJariAtas) * garisPelukis;
        return luasSelimut;
    }

    public double hitungGarisPelukis(){
        garisPelukis = Math.sqrt(Math.pow(super.jariJari - jariJariAtas, 2) + Math.pow(tinggi, 2));
        return garisPelukis;
    }

    public double getLuasPermukaanKerucutTerpancung() {
        return luasPermukaanKerucutTerpancung;
    }

    public double getVolumeKerucutTerpancung() {
        return volumeKerucutTerpancung;
    }

}