package Benda3D;

import Benda.Benda3D;
import Benda2D.Trapesium;

import java.io.*;
import java.util.*;

/**
 *
 */
public class PrismaTrapesium extends Trapesium implements Benda3D, Runnable{
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
    }

    @Override
    public void run() {
        System.out.println("Menghitung " + getNama());
        super.run(); // Menghitung luas dan keliling trapesium alas
        this.luasSisiTegak = hitungLuasSisiTegak(); // Hitung luas sisi tegak setelah sisi-sisi diinisialisasi
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
        // Volume Prisma = Luas Alas * Tinggi Prisma
        return super.hitungLuas() * tinggiPrismaTrapesium;
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
    public double hitungLuasPermukaan(){
        // Luas Permukaan Prisma = (2 * Luas Alas) + Luas Selimut (Luas Sisi Tegak)
        return (2 * super.getLuasTrapesium()) + luasSisiTegak;
    }

    public double getLuasPermukaanPrismaTrapesium() {
        return luasPermukaanPrismaTrapesium;
    }

}