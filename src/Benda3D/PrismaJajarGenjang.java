package Benda3D;

import Benda.Benda3D;
import Benda2D.JajarGenjang;

import java.io.*;
import java.util.*;

public class PrismaJajarGenjang extends JajarGenjang implements Benda3D{
    private double tinggiPrismaJajarGenjang;
    private double sisiPrismaJajarGenjang;
    private double volumePrismaJajarGenjang;
    private double luasPermukaanPrismaJajarGenjang;

    public PrismaJajarGenjang(double alas, double tinggi, double sudutLancip, double tinggiPrismaJajarGenjang, double sisi) {
        super(alas, sudutLancip, tinggi);
        this.sisiPrismaJajarGenjang = sisi;
        this.tinggiPrismaJajarGenjang = tinggi;
        this.volumePrismaJajarGenjang = hitungVolume();
        this.luasPermukaanPrismaJajarGenjang = hitungLuasPermukaan();
    }

    public double getTinggiPrismaJajarGenjang() {
        return tinggiPrismaJajarGenjang;
    }

    public double getSisiPrismaJajarGenjang() {
        return sisiPrismaJajarGenjang;
    }

    @Override
    public String getNama(){
        return "Prisma Jajar Genjang";
    }

    @Override
    public double hitungVolume() {
        volumePrismaJajarGenjang = super.luasJajarGenjang * tinggiPrismaJajarGenjang;
        return volumePrismaJajarGenjang;
    }

    public double hitungVolume(double alasBaru, double tinggiAlasBaru, double tinggiPrismaBaru) {
        volumePrismaJajarGenjang = alasBaru * tinggiAlasBaru * tinggiPrismaBaru;
        return volumePrismaJajarGenjang;
    }


    public double getVolumePrismaJajarGenjang() {
        return volumePrismaJajarGenjang;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanPrismaJajarGenjang = 2 * super.luasJajarGenjang + super.kelilingJajarGenjang * tinggiPrismaJajarGenjang;
        return luasPermukaanPrismaJajarGenjang;
    }

    public double hitungLuasPermukaan(double alasBaru, double tinggiAlasBaru, double tinggiPrismaBaru) {
        double luasAlas = alasBaru * tinggiAlasBaru;
        double kelilingBaru = 2 * (alasBaru + tinggiAlasBaru);
        luasPermukaanPrismaJajarGenjang = 2 * luasAlas + kelilingBaru * tinggiPrismaBaru;
        return luasPermukaanPrismaJajarGenjang;
    }

    public double getLuasPermukaanPrismaJajarGenjang() {
        return luasPermukaanPrismaJajarGenjang;
    }

}