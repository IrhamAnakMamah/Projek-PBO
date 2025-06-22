package Benda3D;

import Benda.Benda3D;
import Benda2D.Persegi;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class PrismaPersegi extends Persegi implements Benda3D{
    private double volumeKubus;
    private double tinggiPrisma;
    private double luasPermukaanKubus;

    public PrismaPersegi(double sisi, double tinggi) {
        super(sisi);
        tinggiPrisma = tinggi;
        this.luasPermukaanKubus = hitungLuasPermukaan();
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    @Override
    public String getNama(){
        return "Prisma Persegi";
    }

    @Override
    public double hitungVolume() {
        volumeKubus = super.luasPersegi * tinggiPrisma;
        return volumeKubus;
    }

    public double hitungVolume(double sisiBaru, double tinggiBaru){
        volumeKubus = super.hitungLuas(sisiBaru) * tinggiBaru;
        return volumeKubus;
    }

    public double getVolumeKubus() {
        return volumeKubus;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanKubus = 2 * super.luasPersegi + super.kelilingPersegi * tinggiPrisma;
        return luasPermukaanKubus;
    }

    public double hitungLuasPermukaan(double sisiBaru, double tinggiBaru) {
        luasPermukaanKubus = 2 * super.hitungLuas(sisiBaru) + super.hitungKeliling(sisiBaru) * tinggiBaru;
        return luasPermukaanKubus;
    }

    public double getLuasPermukaanKubus() {
        return luasPermukaanKubus;
    }

}