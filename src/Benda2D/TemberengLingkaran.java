package Benda2D;

/**
 * 
 */
public class TemberengLingkaran extends JuringLingkaran {

    private double taliBusur;
    private double busur;
    private double luasTemberengLingkaran;
    private double kelilingTemberengLingkaran;

    public TemberengLingkaran(double jariJari, double sudut) {
        super(jariJari, sudut);
    }

    @Override
    public String getNama(){
        return "Tembereng Lingkaran";
    }

    @Override
    public double hitungLuas() {
        double sudutRadian = Math.toRadians(super.sudut);
        double luasJuring = (super.sudut / 360.0) * super.pi * super.jariJari * super.jariJari;
        double luasSegitiga = 0.5 * super.jariJari * super.jariJari * Math.sin(sudutRadian);
        this.luasTemberengLingkaran = luasJuring - luasSegitiga;
        return luasTemberengLingkaran;
    }

    public double hitungLuas(double jariJariBaru, double sudutBaru) {
        double sudutRadian = Math.toRadians(sudutBaru);
        double luasJuring = (sudutBaru / 360.0) * super.pi * jariJariBaru * jariJariBaru;
        double luasSegitiga = 0.5 * jariJariBaru * jariJariBaru * Math.sin(sudutRadian);
        this.luasTemberengLingkaran = luasJuring - luasSegitiga;
        return luasTemberengLingkaran;
    }

    public double getLuasTembereng() {
        return luasTemberengLingkaran;
    }

    @Override
    public double hitungKeliling() {
        double sudutRadian = Math.toRadians(super.sudut);
        double panjangBusur = sudutRadian * super.jariJari;
        double taliBusur = 2 * super.jariJari * Math.sin(sudutRadian / 2);
        this.kelilingTemberengLingkaran = panjangBusur + taliBusur;
        return kelilingTemberengLingkaran;
    }

    public double hitungKeliling(double jariJariBaru, double sudutBaru) {
        double sudutRadian = Math.toRadians(sudutBaru);
        double panjangBusur = sudutRadian * jariJariBaru;
        double taliBusur = 2 * jariJariBaru * Math.sin(sudutRadian / 2);
        this.kelilingTemberengLingkaran = panjangBusur + taliBusur;
        return kelilingTemberengLingkaran;
    }

    public double getKelilingTembereng() {
        return kelilingTemberengLingkaran;
    }

}