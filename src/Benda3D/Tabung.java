package Benda3D;

import Benda.Benda3D;
import Benda2D.Lingkaran;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Tabung extends Lingkaran implements Benda3D, Runnable{
    private double tinggiTabung;
    private double volumeTabung;
    private double luasPermukaanTabung;

    public Tabung(double jariJari, double tinggiTabung) {
        super(jariJari);
        this.tinggiTabung = tinggiTabung;
    }

    @Override
    public void run() {
        System.out.println("Menghitung " + getNama());
        super.run();
        volumeTabung = hitungVolume();
        luasPermukaanTabung = hitungLuasPermukaan();
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

        return super.getLuasLingkaran() * tinggiTabung;
    }

    public double getVolumeTabung() {
        return volumeTabung;
    }

    @Override
    public double hitungLuasPermukaan() {
        return super.getKelilingLingkaran() * (super.jariJari + tinggiTabung);
    }

    public double getLuasPermukaanTabung() {
        return luasPermukaanTabung;
    }

}