package Benda2D;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class JuringLingkaran extends Lingkaran implements Runnable {
    public double sudut;
    private double luasJuringLingkaran;
    private double kelilingJuringLingkaran;

    public JuringLingkaran(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
    }

    @Override
    public void run() {
        System.out.println("Menghitung Juring Lingkaran");
        super.run();
        luasJuringLingkaran = hitungLuas();
        kelilingJuringLingkaran = hitungKeliling();
    }

    @Override
    public String getNama(){
        return "Juring Lingkaran";
    }

    @Override
    public double hitungLuas() {
        return getLuasLingkaran() * sudut;
    }

    public double getLuasJuringLingkaran() {
        return luasJuringLingkaran;
    }

    @Override
    public double hitungKeliling() {
        return 2 * jariJari + jariJari * sudut;
    }

    public double getKelilingJuringLingkaran() {
        return kelilingJuringLingkaran;
    }

}