package Benda3D;

import Benda.Benda3D;
import Benda2D.Persegi;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class LimasPersegi extends Persegi implements Benda3D{
    private double tinggiLimasPersegi;
    private double volumeLimasPersegi;
    private double luasPermukaanLimasPersegi;

    public LimasPersegi(double sisi, double tinggiLimasPersegi) {
        super(sisi);
        this.tinggiLimasPersegi = tinggiLimasPersegi;
        this.volumeLimasPersegi = hitungVolume();
        this.luasPermukaanLimasPersegi = hitungLuasPermukaan();
    }

    public double getTinggiLimasPersegi() {
        return tinggiLimasPersegi;
    }

    @Override
    public String getNama(){
        return "Limas Persegi";
    }

    @Override
    public double hitungVolume() {
        volumeLimasPersegi = (double)1.0/3.0 * tinggiLimasPersegi * super.luasPersegi;
        return volumeLimasPersegi;
    }

    public double hitungVolume(double sisiBaru, double tinggiLimasPersegiBaru) {
        volumeLimasPersegi = (double)1.0/3.0 * tinggiLimasPersegiBaru * super.hitungLuas(sisiBaru);
        return volumeLimasPersegi;
    }

    public double getVolumeLimasPersegi() {
        return volumeLimasPersegi;
    }

    @Override
    public double hitungLuasPermukaan() {
        double tinggiSegitiga = Math.sqrt(Math.pow((super.sisi / 2), 2) + Math.pow(tinggiLimasPersegi, 2));
        double luasSegitiga = 0.5 * super.sisi * tinggiSegitiga;
        luasPermukaanLimasPersegi =  super.luasPersegi + 4 * luasSegitiga;
        return luasPermukaanLimasPersegi;
    }

    public double hitungLuasPermukaan(double sisiBaru, double tinggiBaru) {
        double tinggiSegitiga = Math.sqrt(Math.pow((sisiBaru / 2), 2) + Math.pow(tinggiBaru, 2));
        double luasSegitiga = 0.5 * sisiBaru * tinggiSegitiga;
        luasPermukaanLimasPersegi = super.hitungLuas(sisiBaru) + 4 * luasSegitiga;
        return luasPermukaanLimasPersegi;
    }

    public double getLuasPermukaanLimasPersegi() {
        return luasPermukaanLimasPersegi;
    }

}