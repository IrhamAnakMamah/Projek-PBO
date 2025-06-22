package Benda3D;

import Benda.Benda3D;
import Benda2D.PersegiPanjang;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class PrismaPersegiPanjang extends PersegiPanjang implements Benda3D {
    private double tinggiBalok;
    private double volumeBalok;
    private double luasPermukaanBalok;

    public PrismaPersegiPanjang(double panjang, double lebar, double tinggiBalok) {
        super(panjang, lebar);
        this.tinggiBalok = tinggiBalok;
        this.volumeBalok = hitungVolume();
        this.luasPermukaanBalok = hitungLuasPermukaan();
    }

    public double getTinggiBalok() {
        return tinggiBalok;
    }

    @Override
    public String getNama(){
        return "Prisma Persegi Panjang";
    }

    @Override
    public double hitungVolume() {
        volumeBalok = super.luasPersegiPanjang * tinggiBalok;
        return volumeBalok;
    }

    public double hitungVolume(double panjangBaru, double lebarBaru, double tinggiBaru) {
        volumeBalok = super.hitungLuas(panjangBaru, lebarBaru) * tinggiBaru;
        return volumeBalok;
    }

    public double getVolumeBalok() {
        return volumeBalok;
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasAlas = super.luasPersegiPanjang;
        double kelilingAlas = super.kelilingPersegiPanjang;
        luasPermukaanBalok =  2 * super.luasPersegiPanjang + super.kelilingPersegiPanjang * tinggiBalok;
        return luasPermukaanBalok;
    }

    public double getLuasPermukaanBalok() {
        return luasPermukaanBalok;
    }

}