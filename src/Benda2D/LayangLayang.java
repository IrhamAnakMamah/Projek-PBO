package Benda2D;

import Benda.BendaGeometri;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class LayangLayang implements BendaGeometri, Runnable{

    public double diagonal1;
    public double diagonal2;
    public double sisi1;
    public double sisi2;
    private double luasLayangLayang;
    private double kelilingLayangLayang;

    public LayangLayang(double diagonal1, double diagonal2, double sisi1, double sisi2) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
    }

    @Override
    public void run() {
        System.out.println("Menghitung Layang Layang");
        this.luasLayangLayang = hitungLuas();
        this.kelilingLayangLayang = hitungKeliling();
    }

    @Override
    public double hitungLuas() {
        return 0.5 * diagonal1 * diagonal2;
    }

    public double getLuasLayangLayang() {
        return luasLayangLayang;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (diagonal1 + diagonal2);
    }

    public double getKelilingLayangLayang() {
        return kelilingLayangLayang;
    }

}