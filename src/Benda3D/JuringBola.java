package Benda3D;

import Benda.Benda3D;

public class JuringBola extends Bola implements Benda3D{
    private double theta;
    private double volumeJuringBola;
    private double luasPermukaanJuring;

    public JuringBola(double jariJari, double theta) {
        super(jariJari);
        this.theta = theta;
        this.volumeJuringBola = hitungVolume();
        this.luasPermukaanJuring = hitungLuasPermukaan();
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
        volumeJuringBola = (theta/360.0) * super.hitungVolume();
        return volumeJuringBola;
    }

    public double hitungVolume(double thetaBaru, double jariJariBaru) {
        volumeJuringBola = (thetaBaru/360.0) * super.hitungVolume(jariJariBaru);
        return volumeJuringBola;
    }

    public double hitungLuasPermukaan(){
        luasPermukaanJuring = (theta/360.0) * super.hitungLuasPermukaan();
        return luasPermukaanJuring;
    }

    public double hitungLuasPermukaan(double thetaBaru, double jariJariBaru){
        luasPermukaanJuring = (thetaBaru/360.0) * super.hitungLuasPermukaan(jariJariBaru);
        return luasPermukaanJuring;
    }

    public double getLuasPermukaanJuringBola() {
        return luasPermukaanJuring;
    }

    public double getVolumeJuringBola() {
        return volumeJuringBola;
    }


}