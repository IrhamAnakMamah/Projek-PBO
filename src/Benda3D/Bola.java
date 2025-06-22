package Benda3D;

import Benda.Benda3D;
import Benda2D.Lingkaran;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Bola extends Lingkaran implements Benda3D {
    private double volumeBola;
    private double luasPermukaanBola;

    public Bola(double jariJari) {
        super(jariJari);
        this.volumeBola = hitungVolume();
        this.luasPermukaanBola = hitungLuasPermukaan();
    }

    @Override
    public String getNama(){
        return "Bola";
    }

    @Override
    public double hitungVolume(){
        volumeBola = 4.0/3.0 * super.luasLingkaran * super.jariJari;
        return volumeBola;
    }

    public double hitungVolume(double jariJariBaru) {
        volumeBola = 4.0/3.0 * pi * super.hitungLuas(jariJariBaru) * jariJari;
        return volumeBola;
    }

    public double getVolumeBola() {
        return volumeBola;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanBola = 4 * super.luasLingkaran;
        return luasPermukaanBola;
    }

    public double hitungLuasPermukaan(double jariJariBaru) {
        luasPermukaanBola = 4 * super.hitungLuas(jariJariBaru);
        return luasPermukaanBola;
    }

    public double getLuasPermukaanBola() {
        return luasPermukaanBola;
    }
}