package Benda3D;

import Benda.Benda3D;
import Benda2D.LayangLayang;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class PrismaLayangLayang extends LayangLayang implements Benda3D, Runnable{
    private double tinggiPrismaLayangLayang;
    private double volumePrismaLayangLayang;
    private double luasPermukaanPrismaLayangLayang;

    public PrismaLayangLayang(double diagonal1, double diagonal2, double sisi1, double sisi2, double tinggiPrismaLayangLayang) {
        super(diagonal1, diagonal2, sisi1, sisi2);
        this.tinggiPrismaLayangLayang = tinggiPrismaLayangLayang;
    }

    @Override
    public void run() {
        System.out.println("Menghitung " + getNama());
        super.run();
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
        return getLuasLayangLayang() * tinggiPrismaLayangLayang;
    }

    public double getVolumePrismaLayangLayang() {
        return volumePrismaLayangLayang;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * getLuasLayangLayang() + 2 * tinggiPrismaLayangLayang * (super.sisi1 + super.sisi2);
    }

    public double getLuasPermukaanPrismaLayangLayang() {
        return luasPermukaanPrismaLayangLayang;
    }

}