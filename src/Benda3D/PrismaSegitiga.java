package Benda3D;

import Benda.Benda3D;
import Benda2D.Segitiga;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class PrismaSegitiga extends Segitiga implements Benda3D{
    private double tinggiPrismaSegitiga;
    private double sisiA, sisiB, sisiC;
    private double volumePrismaSegitiga;
    private double luasSisiTegak;
    private double luasPermukaanPrismaSegitiga;

    public PrismaSegitiga(double alas, double tinggi, double tinggiPrismaSegitiga) {
        super(alas,tinggi);
        this.tinggiPrismaSegitiga = tinggiPrismaSegitiga;
        this.volumePrismaSegitiga = hitungVolume();
        this.luasPermukaanPrismaSegitiga = hitungLuasPermukaan();
            }

    public double getTinggiPrismaSegitiga() {
        return tinggiPrismaSegitiga;
    }

    public double getSisiA() {
        return sisiA;
    }

    public double getSisiB() {
        return sisiB;
    }

    public double getSisiC() {
        return sisiC;
    }

    @Override
    public String getNama(){
        return "Prisma Segitiga";
    }

    @Override
    public double hitungVolume() {
        volumePrismaSegitiga = super.luasSegitiga * tinggiPrismaSegitiga;
        return volumePrismaSegitiga;
    }

    public double hitungVolume(double alasBaru, double tinggiBaru, double tinggiPrismaBaru) {
        volumePrismaSegitiga = (0.5 * alasBaru * tinggiBaru) * tinggiPrismaBaru;
        return volumePrismaSegitiga;
    }

    public double getVolumePrismaSegitiga() {
        return volumePrismaSegitiga;
    }

    public double hitungLuasSisiTegak(){
        return sisi * tinggiPrismaSegitiga;
    }

    public double getLuasSisiTegak(){
        return luasSisiTegak;
    }

    @Override
    public double hitungLuasPermukaan() {
        double kelilingAlas = super.kelilingSegitiga;
        double luasAlas = super.luasSegitiga;
        luasPermukaanPrismaSegitiga =  (2 * luasAlas) + (kelilingAlas * tinggiPrismaSegitiga);
        return luasPermukaanPrismaSegitiga;
    }

    public double hitungLuasPermukaan(double alasBaru, double tinggiBaru, double tinggiPrismaBaru) {
        double kelilingAlas = 3 * alasBaru;
        double luasAlas = 0.5 * alasBaru * tinggiBaru;
        luasPermukaanPrismaSegitiga = (2 * luasAlas) + (kelilingAlas * tinggiPrismaBaru);
        return luasPermukaanPrismaSegitiga;
    }

    public double getLuasPermukaanSegitiga() {
        return luasPermukaanPrismaSegitiga;
    }

}