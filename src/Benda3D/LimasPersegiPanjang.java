package Benda3D;

import Benda.Benda3D;
import Benda2D.PersegiPanjang;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class LimasPersegiPanjang extends PersegiPanjang implements Benda3D{
    public double volumeLimasPersegiPanjang;
    public double tinggiLimasPersegiPanjang;
    public double luasPermukaanLimasPersegiPanjang;

    public LimasPersegiPanjang(double panjang, double lebar, double tinggiLimasPersegiPanjang) {
        super(panjang, lebar);
        this.tinggiLimasPersegiPanjang = tinggiLimasPersegiPanjang;
        this.volumeLimasPersegiPanjang = hitungVolume();
        this.luasPermukaanLimasPersegiPanjang = hitungLuasPermukaan();
    }

    public double getTinggiLimasPersegiPanjang() {
        return tinggiLimasPersegiPanjang;
    }

    @Override
    public String getNama(){
        return "Limas Persegi Panjang";
    }

    @Override
    public double hitungVolume() {
        volumeLimasPersegiPanjang = (double)1.0/3.0 * super.luasPersegiPanjang * tinggiLimasPersegiPanjang;
        return volumeLimasPersegiPanjang;
    }

    public double hitungVolume(double panjangBaru, double lebarBaru, double tinggiBaru) {
        volumeLimasPersegiPanjang = (double)1.0/3.0 * panjangBaru * lebarBaru * tinggiBaru;
        return volumeLimasPersegiPanjang;
    }

    public double getVolumeLimasPersegiPanjang() {
        return volumeLimasPersegiPanjang;
    }

    @Override
    public double hitungLuasPermukaan() {
        double panjang = super.panjang;
        double lebar = super.lebar;

        double tinggiSegitigaPanjang = Math.sqrt(Math.pow(tinggiLimasPersegiPanjang, 2) + Math.pow(lebar / 2, 2));
        double tinggiSegitigaLebar = Math.sqrt(Math.pow(tinggiLimasPersegiPanjang, 2) + Math.pow(panjang / 2, 2));

        double luasSisiPanjang = panjang * tinggiSegitigaPanjang;
        double luasSisiLebar = lebar * tinggiSegitigaLebar;

        luasPermukaanLimasPersegiPanjang =  super.luasPersegiPanjang + 2 * (0.5 * luasSisiPanjang) + 2 * (0.5 * luasSisiLebar);
        return luasPermukaanLimasPersegiPanjang;
    }

    public double hitungLuasPermukaan(double panjangBaru, double lebarBaru, double tinggiBaru) {
        double tinggiSegitigaPanjang = Math.sqrt(Math.pow(tinggiBaru, 2) + Math.pow(lebarBaru / 2, 2));
        double tinggiSegitigaLebar = Math.sqrt(Math.pow(tinggiBaru, 2) + Math.pow(panjangBaru / 2, 2));

        double luasSisiPanjang = panjangBaru * tinggiSegitigaPanjang;
        double luasSisiLebar = lebarBaru * tinggiSegitigaLebar;

        luasPermukaanLimasPersegiPanjang = (panjangBaru * lebarBaru) + 2 * (0.5 * luasSisiPanjang) + 2 * (0.5 * luasSisiLebar);
        return luasPermukaanLimasPersegiPanjang;
    }

    public double getLuasPermukaanLimasPersegiPanjang() {
        return hitungLuasPermukaan();
    }

}