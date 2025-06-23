package Benda3D;

import Benda.Benda3D;

public class TemberengBola extends Bola implements Benda3D{
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
        this.volumeTemberengBola = hitungVolume();
        this.luasPermukaanTemberengBola = hitungLuasPermukaan();
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
        double r = super.jariJari;
        double h = tinggiTembereng;
        volumeTemberengBola = (1.0 / 6.0) * super.pi * h * (3 * r * r + h * h);
        return volumeTemberengBola;
    }

    public double hitungVolume(double jariJariBaru, double tinggiTemberengBaru) {
        volumeTemberengBola = (1.0 / 6.0) * super.pi * tinggiTemberengBaru * (3 * jariJariBaru * jariJariBaru + tinggiTemberengBaru * tinggiTemberengBaru);
        return volumeTemberengBola;
    }

    public double getVolumeTemberengBola(){
        return volumeTemberengBola;
    }

    @Override
    public double hitungLuasPermukaan(){
        double r = super.jariJari;
        double h = tinggiTembereng;
        luasPermukaanTemberengBola = 2 * super.pi * r * h;
        return luasPermukaanTemberengBola;
    }

    public double hitungLuasPermukaan(double jariJariBaru, double tinggiTemberengBaru) {
        luasPermukaanTemberengBola = 2 * super.pi * jariJariBaru * tinggiTemberengBaru;
        return luasPermukaanTemberengBola;
    }

    public double getLuasPermukaanTemberengBola(){
        return luasPermukaanTemberengBola;
    }

}