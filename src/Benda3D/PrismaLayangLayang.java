package Benda3D;

import Benda.Benda3D;
import Benda2D.LayangLayang;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class PrismaLayangLayang extends LayangLayang implements Benda3D{
    private double tinggiPrismaLayangLayang;
    private double volumePrismaLayangLayang;
    private double luasPermukaanPrismaLayangLayang;

    public PrismaLayangLayang(double diagonal1, double diagonal2, double sisi1, double sisi2, double tinggiPrismaLayangLayang) {
        super(diagonal1, diagonal2, sisi1, sisi2);
        this.tinggiPrismaLayangLayang = tinggiPrismaLayangLayang;
        this.volumePrismaLayangLayang = hitungVolume();
        this.luasPermukaanPrismaLayangLayang = hitungLuasPermukaan();
    }

    public double getTinggiPrismaLayangLayang() {
        return tinggiPrismaLayangLayang;
    }

    @Override
    public String getNama(){
        return "Prisma Layang-Layang";
    }

    @Override
    public double hitungVolume() {
        volumePrismaLayangLayang = super.luasLayangLayang * tinggiPrismaLayangLayang;
        return volumePrismaLayangLayang;
    }

    public double hitungVolume(double diagonal1Baru, double diagonal2Baru, double tinggiBaru) {
        volumePrismaLayangLayang = (diagonal1Baru * diagonal2Baru / 2) * tinggiBaru;
        return volumePrismaLayangLayang;
    }

    public double getVolumePrismaLayangLayang() {
        return volumePrismaLayangLayang;
    }

    @Override
    public double hitungLuasPermukaan() {
        volumePrismaLayangLayang =  2 * super.luasLayangLayang + super.kelilingLayangLayang * tinggiPrismaLayangLayang;
        return luasPermukaanPrismaLayangLayang;
    }

    public double hitungLuasPermukaan(double diagonal1Baru, double diagonal2Baru, double tinggiBaru) {
        double luasAlas = (diagonal1Baru * diagonal2Baru) / 2;
        double kelilingBaru = 2 * (diagonal1Baru + diagonal2Baru);
        luasPermukaanPrismaLayangLayang = 2 * luasAlas + kelilingBaru * tinggiBaru;
        return luasPermukaanPrismaLayangLayang;
    }

    public double getLuasPermukaanPrismaLayangLayang() {
        return luasPermukaanPrismaLayangLayang;
    }

}