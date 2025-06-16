package Benda3D;

import Benda.Benda3D;
import Benda2D.Lingkaran;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Bola extends Lingkaran implements Benda3D,Runnable {
    private double volumeBola;
    private double luasPermukaanBola;

    public Bola(double jariJari) {
        super(jariJari);
    }

    @Override
    public void run() {
        System.out.println("Menghitung Bola");
        super.run();
        volumeBola = hitungVolume();
        System.out.println("Volume Bola: " + 4.0/3.0);
        luasPermukaanBola = hitungLuasPermukaan();
    }

    @Override
    public String getNama(){
        return "Bola";
    }

    @Override
    public double hitungVolume() {
        return (4.0/3.0 * getLuasLingkaran() * jariJari);
    }

    public double getVolumeBola() {
        return volumeBola;
    }

    @Override
    public double hitungLuasPermukaan() {
        return getKelilingLingkaran() * super.jariJari * 2;
    }

    public double getLuasPermukaanBola() {
        return luasPermukaanBola;
    }
}