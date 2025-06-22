package Benda3D;

import Benda.Benda3D;
import Benda2D.BelahKetupat;

import java.io.*;
import java.util.*;

/**
 *
 */
public class PrismaBelahKetupat extends BelahKetupat implements Benda3D{
    private double tinggiPrisma;
    private double sisiPrisma;
    private double volumePrismaBelahKetupat;
    private double luasPermukaanPrismaBelahKetupat;

    public PrismaBelahKetupat(double diagonal1, double diagonal2, double tinggiPrisma, double sisi) {
        super(diagonal1, diagonal2);
        this.tinggiPrisma = tinggiPrisma;
        this.sisiPrisma = sisi;
        this.volumePrismaBelahKetupat = hitungVolume();
        this.luasPermukaanPrismaBelahKetupat = hitungLuasPermukaan();
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public double getSisiPrisma() {
        return sisiPrisma;
    }

    @Override
    public String getNama(){
        return "Prisma Belah Ketupat";
    }

    @Override
    public double hitungVolume() {
        volumePrismaBelahKetupat = super.luasBelahKetupat * tinggiPrisma;
        return volumePrismaBelahKetupat;
    }

    public double hitungVolume(double diagonal1Baru, double diagonal2Baru, double tinggiBaru) {
        volumePrismaBelahKetupat = (diagonal1Baru * diagonal2Baru / 2) * tinggiBaru;
        return volumePrismaBelahKetupat;
    }

    public double getVolumePrismaBelahKetupat() {
        return volumePrismaBelahKetupat;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanPrismaBelahKetupat =  2 * super.luasBelahKetupat + super.kelilingBelahKetupat * tinggiPrisma;
        return luasPermukaanPrismaBelahKetupat;
    }

    public double hitungLuasPermukaan(double diagonal1Baru, double diagonal2Baru, double tinggiBaru) {
        double luasAlas = (diagonal1Baru * diagonal2Baru) / 2;
        double kelilingBaru = 2 * (diagonal1Baru + diagonal2Baru);
        luasPermukaanPrismaBelahKetupat = 2 * luasAlas + kelilingBaru * tinggiBaru;
        return luasPermukaanPrismaBelahKetupat;
    }

    public double getLuasPermukaanPrismaBelahKetupat() {
        return luasPermukaanPrismaBelahKetupat;
    }

}