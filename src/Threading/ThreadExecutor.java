package Threading;

import Benda.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutor {

    public static void processShapes(List<Benda> shapes) {
        ExecutorService executor = Executors.newFixedThreadPool(4); // pool dengan 4 thread

        try {
            for (Benda benda : shapes) {
                executor.submit(() -> processShape(benda));
            }
        } finally {
            executor.shutdown(); // pastikan shutdown dipanggil
        }
    }

    private static void processShape(Benda benda) {
        String threadName = Thread.currentThread().getName();
        String namaBenda = benda.getNama();
        String kelas = benda.getClass().getSimpleName();

        try {
            if (benda instanceof Benda2D bd) {
                double keliling = bd.hitungKeliling();
                double luas = bd.hitungLuas();
                System.out.printf(
                        "%s - [2D: %s] Keliling: %.2f, Luas: %.2f%n",
                        threadName, namaBenda, keliling, luas
                );
            }

            if (benda instanceof Benda3D br) {
                double volume = br.hitungVolume();
                double luasPermukaan = br.hitungLuasPermukaan();
                System.out.printf(
                        "%s - [3D: %s] Volume: %.2f, Luas Permukaan: %.2f%n",
                        threadName, namaBenda, volume, luasPermukaan
                );
            }

        } catch (Exception e) {
            System.err.printf(
                    "%s - Error saat memproses %s: %s%n",
                    threadName, kelas, e.getMessage()
            );
        }
    }
}
