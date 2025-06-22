package Benda2D;

import Benda.Benda2D;

public class Lingkaran extends Benda2D{

    public double jariJari;
    public final double pi = Math.PI;
    protected double luasLingkaran;
    protected double kelilingLingkaran;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
        this.kelilingLingkaran = hitungKeliling();
        this.luasLingkaran = hitungLuas();
    }

    @Override
    public String getNama(){
        return "Lingkaran";
    }

    @Override
    public double hitungLuas() {
        luasLingkaran = pi * jariJari * jariJari;
        return luasLingkaran;
    }

    public double hitungLuas(double jariJariBaru) {
        luasLingkaran = pi * jariJariBaru * jariJariBaru;
        return luasLingkaran;
    }

    @Override
    public double hitungKeliling() {
        kelilingLingkaran = 2 * pi * jariJari;
        return kelilingLingkaran;
    }

    public double hitungKeliling(double jariJariBaru) {
        kelilingLingkaran = 2 * pi * jariJariBaru;
        return kelilingLingkaran;
    }

    public double getJariJari() {
        return jariJari;
    }

    public double getLuasLingkaran() {
        return luasLingkaran;
    }

    public double getKelilingLingkaran() {
        return kelilingLingkaran;
    }

    public double getPi() {
        return pi;
    }
}