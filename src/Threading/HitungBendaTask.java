package Threading;

import Benda.Benda;
import Benda.Benda2D;
import Benda.Benda3D;

public class HitungBendaTask implements Runnable {
    private final Benda benda;

    public HitungBendaTask(Benda benda) {
        this.benda = benda;
    }

    @Override
    public void run() {
        System.out.println("==========");
        System.out.println("Nama: " + benda.getNama());

        if (benda instanceof Benda2D b2d) {
            System.out.println("Luas: " + b2d.hitungLuas());
            System.out.println("Keliling: " + b2d.hitungKeliling());
        } else if (benda instanceof Benda3D b3d) {
            System.out.println("Luas Permukaan: " + b3d.hitungLuasPermukaan());
            System.out.println("Volume: " + b3d.hitungVolume());
        } else {
            System.out.println("Tipe objek tidak dikenali.");
        }

        System.out.println("==========");
    }
}
