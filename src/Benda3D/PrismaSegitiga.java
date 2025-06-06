package Benda3D;

import Benda.Benda3D;
import Benda2D.Segitiga;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class PrismaSegitiga extends Segitiga implements Benda3D {
    private double tinggiPrismaSegitiga;
    private double sisiA, sisiB, sisiC;
    private double volumePrismaSegitiga;
    private double luasSisiTegak;
    private double luasPermukaanPrismaSegitiga;

    public PrismaSegitiga(double alas, double tinggi, double tinggiPrismaSegitiga, double sisiA, double sisiB, double sisiC) {
        super(alas,tinggi);

        volumePrismaSegitiga = hitungVolume();
        luasPermukaanPrismaSegitiga = hitungLuasPermukaan();
        luasSisiTegak = hitungLuasSisiTegak();
    }

    @Override
    public void run() {
        System.out.println("Menghitung Prisma Segitiga");
        this.volumePrismaSegitiga = hitungVolume();
        this.luasPermukaanPrismaSegitiga = hitungLuasPermukaan();
    }

    @Override
    public double hitungVolume() {
        return getLuasSegitiga() * tinggiPrismaSegitiga;
    }

    public double getVolumePrismaSegitiga() {
        return volumePrismaSegitiga;
    }

    public double hitungLuasSisiTegak(){
        return sisiA + sisiB + sisiC * tinggiPrismaSegitiga;
    }

    public double getLuasSisiTegak(){
        return luasSisiTegak;
    }

    @Override
    public double hitungLuasPermukaan() {
        return getLuasSegitiga() + luasSisiTegak;
    }

    public double getLuasPermukaanSegitiga() {
        return luasPermukaanPrismaSegitiga;
    }

}