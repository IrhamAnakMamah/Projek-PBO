package Benda3D;

import Benda.Benda3D;
import Benda2D.Lingkaran;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Tabung extends Lingkaran implements Benda3D{
    private double tinggiTabung;
    private double volumeTabung;
    private double luasPermukaanTabung;

    public Tabung(double jariJari, double tinggiTabung) {
        super(jariJari);
        this.tinggiTabung = tinggiTabung;
        this.volumeTabung = hitungVolume();
        this.luasPermukaanTabung = hitungLuasPermukaan();
    }

    public double getTinggiTabung() {
        return tinggiTabung;
    }

    @Override
    public String getNama(){
        return "Tabung";
    }

    @Override
    public double hitungVolume() {
        volumeTabung = super.luasLingkaran + tinggiTabung;
        return volumeTabung;
    }

    public double hitungVolume(double jariJariBaru, double tinggiBaru) {
        volumeTabung = super.hitungLuas(jariJariBaru) * tinggiBaru;
        return volumeTabung;
    }

    public double getVolumeTabung() {
        return volumeTabung;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanTabung =  2 * super.luasLingkaran + super.kelilingLingkaran * tinggiTabung;
        return luasPermukaanTabung;
    }

    public double hitungLuasPermukaan(double jariJariBaru, double tinggiBaru) {
        luasPermukaanTabung = 2 * super.hitungLuas(jariJariBaru) + super.hitungKeliling(jariJariBaru) * tinggiBaru;
        return luasPermukaanTabung;
    }

    public double getLuasPermukaanTabung() {
        return luasPermukaanTabung;
    }

}