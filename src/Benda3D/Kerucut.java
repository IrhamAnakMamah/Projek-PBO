package Benda3D;

import Benda.Benda3D;
import Benda2D.Lingkaran;

import java.io.*;
import java.util.*;

import static java.lang.Math.sqrt;

/**
 * 
 */
public class Kerucut extends Lingkaran implements Benda3D{
    private double tinggiKerucut;
    private double volumeKerucut;
    private double luasPermukaanKerucut;

    public Kerucut(double jariJari, double tinggiKerucut) {
        super(jariJari);
        this.tinggiKerucut = tinggiKerucut;
        this.volumeKerucut = hitungVolume();
        this.luasPermukaanKerucut = hitungLuasPermukaan();
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
        volumeKerucut = (double)1.0/3.0 * super.pi * super.jariJari * super.jariJari * tinggiKerucut;
        return volumeKerucut;
    }

    public double hitungVolume(double jariJariBaru, double tinggiKerucutBaru) {
        volumeKerucut = (double)1.0/3.0 * super.pi * jariJariBaru * jariJariBaru * tinggiKerucutBaru;
        return volumeKerucut;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanKerucut = sqrt((super.jariJari * super.jariJari) + (tinggiKerucut * tinggiKerucut));
        return luasPermukaanKerucut;
    }

    public double hitungLuasPermukaan(double jariJariBaru, double tinggiKerucutBaru) {
        luasPermukaanKerucut = sqrt((jariJariBaru * jariJariBaru) + (tinggiKerucutBaru * tinggiKerucutBaru));
        return luasPermukaanKerucut;
    }

    public double getLuasPermukaanKerucut() {
        return luasPermukaanKerucut;
    }

}