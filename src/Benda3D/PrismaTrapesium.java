package Benda3D;

import Benda.Benda3D;
import Benda2D.Trapesium;

import java.io.*;
import java.util.*;

/**
 *
 */
public class PrismaTrapesium extends Trapesium implements Benda3D{
    private double tinggiPrismaTrapesium;
    private double sisiA, sisiB, sisiC, sisiD; // Sisi-sisi alas trapesium
    private double volumePrismaTrapesium;
    private double luasPermukaanPrismaTrapesium;
    private double luasSisiTegak; // Untuk menyimpan hasil perhitungan luas sisi tegak

    // Konstruktor dengan semua parameter yang dibutuhkan
    public PrismaTrapesium(double alasAtas, double alasBawah, double tinggiAlas, double tinggiPrismaTrapesium, double sisiA, double sisiB, double sisiC, double sisiD) {
        super(alasAtas,alasBawah,tinggiAlas); // alasAtas, alasBawah, tinggi adalah properti trapesium (alas)
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
        this.sisiD = sisiD;
        this.tinggiPrismaTrapesium = tinggiPrismaTrapesium;
        this.volumePrismaTrapesium = hitungVolume();
        this.luasPermukaanPrismaTrapesium = hitungLuasPermukaan();
    }

    public double getTinggiPrismaTrapesium() {
        return tinggiPrismaTrapesium;
    }

    // Menambahkan getter untuk sisi-sisi alas agar bisa diakses dari View
    public double getSisiA() {
        return sisiA;
    }

    public double getSisiB() {
        return sisiB;
    }

    public double getSisiC() {
        return sisiC;
    }

    public double getSisiD() {
        return sisiD;
    }

    public double getLuasSisiTegak() {
        return luasSisiTegak;
    }

    @Override
    public String getNama(){
        return "Prisma Trapesium";
    }

    @Override
    public double hitungVolume(){
        volumePrismaTrapesium = super.luasTrapesium * tinggiPrismaTrapesium;
        return volumePrismaTrapesium;
    }

    public double hitungVolume(double sisiSejajar1, double sisiSejajar2, double tinggiBaru, double tinggiPrismaBaru) {
        volumePrismaTrapesium = (0.5 * (sisiSejajar1 + sisiSejajar2) * tinggiBaru) * tinggiPrismaBaru;
        return volumePrismaTrapesium;
    }

    // Perbaikan rumus hitungLuasSisiTegak() - seharusnya keliling alas * tinggi prisma
    // Keliling alas sudah ada di super.getKelilingTrapesium()
    public double hitungLuasSisiTegak(){
        return super.getKelilingTrapesium() * tinggiPrismaTrapesium;
    }

    public double getVolumePrismaTrapesium() {
        return volumePrismaTrapesium;
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasAlas = super.luasTrapesium;
        double kelilingAlas = super.kelilingTrapesium;
        luasPermukaanPrismaTrapesium = 2 * luasAlas + kelilingAlas * tinggiPrismaTrapesium;
        return luasPermukaanPrismaTrapesium;
    }

    public double getLuasPermukaanPrismaTrapesium() {
        return luasPermukaanPrismaTrapesium;
    }

}