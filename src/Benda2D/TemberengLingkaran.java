package Benda2D;

import Benda.BendaGeometri;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class TemberengLingkaran extends JuringLingkaran implements Runnable{

    private double taliBusur;
    private double busur;
    private double sudut;
    private double luasTemberengLingkaran;
    private double kelilingTemberengLingkaran;

    public TemberengLingkaran(double jariJari, double taliBusur, double sudut, double busur) {
        super(jariJari, sudut);
        this.taliBusur = taliBusur;
        this.busur = busur;
    }

    @Override
    public void run() {
        System.out.println("Menghitung Tembereng Lingkaran");
        this.luasTemberengLingkaran = hitungLuas();
        this.kelilingTemberengLingkaran = hitungKeliling();
    }

    @Override
    public double hitungLuas() {
        return getLuasJuringLingkaran() - (0.5 * super.jariJari * super.jariJari * super.sudut);
    }

    public double getLuasTembereng() {
        return luasTemberengLingkaran;
    }

    @Override
    public double hitungKeliling() {
        return 0;
    }

    public double getKelilingTembereng() {
        return kelilingTemberengLingkaran;
    }

}