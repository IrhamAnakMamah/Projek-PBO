package Benda2D;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class JuringLingkaran extends Lingkaran{
    public double sudut;
    private double kelilingJuringLingkaran;
    private double luasJuringLingkaran;

    public JuringLingkaran(double jariJari, double sudut) {
        super(jariJari);
        this.sudut = sudut;
        this.kelilingJuringLingkaran = hitungKeliling();
        this.luasJuringLingkaran = hitungLuas();
    }

    @Override
    public String getNama(){
        return "Juring Lingkaran";
    }

    @Override
    public double hitungLuas() {
        luasJuringLingkaran = (sudut/360.0) * super.hitungLuas();
        return luasJuringLingkaran;
    }

    public double hitungLuas(double jarijariBaru, double sudutBaru) {
        luasJuringLingkaran = (sudutBaru/360.0) * super.hitungLuas(jarijariBaru);
        return luasJuringLingkaran;
    }

    public double getLuasJuringLingkaran() {
        return luasJuringLingkaran;
    }

    @Override
    public double hitungKeliling() {
        kelilingJuringLingkaran = (sudut / 360.0) * super.hitungKeliling() + 2 * super.jariJari;
        return kelilingJuringLingkaran;
    }

    public double hitungKeliling(double jariJariBaru, double sudutBaru) {
        kelilingJuringLingkaran = (sudutBaru / 360.0) * super.hitungKeliling(jariJariBaru) + 2 * jariJariBaru;
        return kelilingJuringLingkaran;
    }

    public double getKelilingJuringLingkaran() {
        return kelilingJuringLingkaran;
    }

}