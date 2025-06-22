import Benda.*;
import Benda2D.*;
import Threading.HitungBendaTask;
import Threading.ThreadExecutor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainMenuView extends JFrame {

    public MainMenuView() {
        setTitle("Menu Sejajar Benda 2D");
        setSize(660, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        // === Menu Bangun Datar Sederhana ===
        menuBar.add(new JMenu("Lingkaran"));
        menuBar.add(new JMenu("Persegi"));
        menuBar.add(new JMenu("Persegi Panjang"));
        menuBar.add(new JMenu("Segitiga"));
        menuBar.add(new JMenu("Trapesium"));
        menuBar.add(new JMenu("Jajar Genjang"));
        menuBar.add(new JMenu("Layang-Layang"));
        menuBar.add(new JMenu("Belah Ketupat"));

        // === Menu Threading ===
        JMenu threadMenu = new JMenu("Thread");

        JMenuItem hitungBendaItem = new JMenuItem("Thread Hitung Benda");
        hitungBendaItem.addActionListener(this::runHitungBendaTask);
        threadMenu.add(hitungBendaItem);

        JMenuItem executorItem = new JMenuItem("Thread Executor");
        executorItem.addActionListener(this::runThreadExecutor);
        threadMenu.add(executorItem);

        menuBar.add(threadMenu);

        setJMenuBar(menuBar);
        setVisible(true);
    }

    // Thread manual: 5 thread satu per satu (HitungBendaTask)
    private void runHitungBendaTask(ActionEvent e) {
        List<Benda2D> bendaList = List.of(
                new Persegi(6),
                new Lingkaran(7),
                new PersegiPanjang(4, 10),
                new Segitiga(3, 4),
                new BelahKetupat(6, 8)
        );

        for (Benda2D benda : bendaList) {
            new Thread(new HitungBendaTask(benda)).start();
        }
    }

    // Thread Executor: menggunakan ExecutorService (minimal 5 objek juga)
    private void runThreadExecutor(ActionEvent e) {
        List<Benda> shapes = List.of(
                new Persegi(8),
                new Lingkaran(5),
                new LayangLayang(4, 6, 3, 4),
                new Trapesium(4, 6, 3),
                new JajarGenjang(7, 4, 5)
        );

        ThreadExecutor.processShapes(shapes);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenuView::new);
    }
}
