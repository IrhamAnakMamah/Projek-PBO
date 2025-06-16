package Benda3D;

import Benda.Benda3D;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class CincinBola extends Bola implements Benda3D, Runnable{
    private double jariJariDalam;
    private double jarakDuaBidang;
    private double volumeCincinBola;
    private double luasPermukaanCincinBola;


    public CincinBola(double jariJari, double jariJariDalam, double jarakDuaBidang) {
        super(jariJari);
        this.jarakDuaBidang = jarakDuaBidang;
    }

    @Override
    public void run() {
        System.out.println("Hitung Cincin Bola");
        super.run();
        luasPermukaanCincinBola = hitungLuasPermukaan();
    }

    public double getJariJariDalam() {
        return jariJariDalam;
    }

    public double getJarakDuaBidang() {
        return jarakDuaBidang;
    }

    @Override
    public String getNama(){
        return "Cincin Bola";
    }


    @Override
    public double hitungLuasPermukaan() {
        return 2 * getPi() * jariJari * jarakDuaBidang ;
    }

    public double getLuasPermukaanCincinBola() {
        return luasPermukaanCincinBola;
    }

}