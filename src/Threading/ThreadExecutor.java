package Threading;

import Benda.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadExecutor {

    public static void processShapes(List<Benda> bendaList) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (Benda benda : bendaList) {
            executor.submit(() -> processBenda(benda));
        }

        executor.shutdown(); // Tidak menerima task baru

        try {
            // Tunggu maksimal 10 detik agar semua thread selesai
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Beberapa task belum selesai tepat waktu.");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted saat menunggu executor selesai.");
        }
    }

    private static void processBenda(Benda benda) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Menghitung " + benda.getNama());

        if (benda instanceof Benda2D b2d) {
            double luas = b2d.hitungLuas();
            double keliling = b2d.hitungKeliling();
            System.out.printf("[%s] %s -> Luas: %.2f, Keliling: %.2f%n",
                    threadName, b2d.getNama(), luas, keliling);
        } else if (benda instanceof Benda3D b3d) {
            double volume = b3d.hitungVolume();
            double luasPermukaan = b3d.hitungLuasPermukaan();
            System.out.printf("[%s] %s -> Volume: %.2f, Luas Permukaan: %.2f%n",
                    threadName, b3d.getNama(), volume, luasPermukaan);
        } else {
            System.out.printf("[%s] %s -> Tipe tidak dikenali%n", threadName, benda.getNama());
        }
    }
}
