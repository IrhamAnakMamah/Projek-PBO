package Benda3D;

import Benda.Benda3D;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class TemberengBola extends Bola implements Benda3D, Runnable{
    private double theta;
    private double jarijariLingkaran;
    private double tinggiTembereng;
    private double volumeTemberengBola;
    private double luasPermukaanTemberengBola;

    public TemberengBola(double jariJariBola, double tinggiTembereng) {
        super(jariJariBola);
        //this.jariLingkaran = jariLingkaran;
        this.jarijariLingkaran = jariJariBola;
        this.tinggiTembereng = tinggiTembereng;
    }

    @Override
    public void run() {
        System.out.println("Menghitung " + getNama());
        super.run();
        volumeTemberengBola = hitungVolume();
        luasPermukaanTemberengBola = hitungLuasPermukaan();
    }

    public double getTheta() {
        return theta;
    }

    public double getTinggiTembereng() {
        return tinggiTembereng;
    }

    @Override
    public String getNama(){
        return "Tembereng Bola";
    }

    @Override
    public double hitungVolume(){
        return ((super.getPi() * Math.pow(tinggiTembereng, 2)) / 3.0) * (3 * super.getJariJari() - tinggiTembereng);
    }

    public double getVolumeTemberengBola(){
        return volumeTemberengBola;
    }

    @Override
    public double hitungLuasPermukaan(){
        return (super.getKelilingLingkaran() * tinggiTembereng) + (super.pi * Math.pow(jarijariLingkaran, 2));
    }

    public double getLuasPermukaanTemberengBola(){
        return luasPermukaanTemberengBola;
    }

}