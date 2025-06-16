package Benda3D;

import Benda.Benda3D;
import Benda2D.Lingkaran;

import java.io.*;
import java.util.*;

import static java.lang.Math.sqrt;

/**
 * 
 */
public class Kerucut extends Lingkaran implements Benda3D, Runnable {
    private double tinggiKerucut;
    private double volumeKerucut;
    private double luasPermukaanKerucut;

    public Kerucut(double jariJari, double tinggiKerucut) {
        super(jariJari);
        this.tinggiKerucut = tinggiKerucut;
    }

    @Override
    public void run() {
        System.out.println("Menghitung Kerucut");
        super.run();
        luasPermukaanKerucut = hitungLuasPermukaan();
        volumeKerucut = hitungVolume();
    }

    public double getTinggiKerucut() {
        return tinggiKerucut;
    }

    @Override
    public String getNama(){
        return "Kerucut";
    }

    @Override
    public double hitungVolume() {
        return (double)1.0/3.0 * getLuasLingkaran() * tinggiKerucut;
    }

    public double getVolumeKerucut() {
        return volumeKerucut;
    }

    @Override
    public double hitungLuasPermukaan() {
        return sqrt((super.jariJari * super.jariJari) + (tinggiKerucut * tinggiKerucut));
    }

    public double getLuasPermukaanKerucut() {
        return luasPermukaanKerucut;
    }

}