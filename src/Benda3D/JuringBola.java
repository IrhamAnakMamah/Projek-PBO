package Benda3D;

import Benda.Benda3D;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class JuringBola extends Bola implements Benda3D, Runnable {
    private double theta;
    private double volumeJuringBola;
    private double luasPermukaanJuring;

    public JuringBola(double jariJari, double theta) {
        super(jariJari);
        this.theta = theta;
    }

    @Override
    public void run() {
        System.out.println("Menghitung Juring Bola");
        super.run();
        volumeJuringBola = hitungVolume();
        System.out.println("Volume juring bola: " + volumeJuringBola);
        luasPermukaanJuring = hitungLuasPermukaan();
    }

    public double getTheta() {
        return theta;
    }

    @Override
    public String getNama(){
        return "Juring Bola";
    }

    @Override
    public double hitungVolume() {
        return (theta/360.0) * super.getVolumeBola();
    }

    public double hitungLuasPermukaan(){
        return (theta/360.0) * super.getLuasPermukaanBola();
    }

    public double getLuasPermukaanJuringBola() {
        return luasPermukaanJuring;
    }

    public double getVolumeJuringBola() {
        return volumeJuringBola;
    }


}