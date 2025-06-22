package Test;

import View.ViewBangun2D.BelahKetupat.BelahKetupatView;

import javax.swing.*;

public class NestedMenuExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Sejajar Benda 2D");
        frame.setSize(660, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        // === Menu Lingkaran ===
        JMenu lingkaranMenu = new JMenu("Lingkaran");

        JMenuItem hitungLingkaranItem = new JMenuItem("Hitung Lingkaran");
        JMenuItem temberengItem = new JMenuItem("Tembereng");
        JMenuItem juringItem = new JMenuItem("Juring");

        JMenu bolaMenu = new JMenu("Bola");
        JMenuItem cincinBolaItem = new JMenuItem("Cincin Bola");
        bolaMenu.add(cincinBolaItem); // Bola -> Cincin Bola

        lingkaranMenu.add(hitungLingkaranItem);
        lingkaranMenu.add(temberengItem);
        lingkaranMenu.add(juringItem);
        lingkaranMenu.addSeparator();
        lingkaranMenu.add(bolaMenu);

        // === Menu Persegi (kosong/tanpa submenu) ===
        JMenu persegiMenu = new JMenu("Persegi");

        // === Menu Persegi Panjang ===
        JMenu persegiPanjangMenu = new JMenu("Persegi Panjang");

        // === Menu Segitiga ===
        JMenu segitigaMenu = new JMenu("Segitiga");

        // === Menu Trapesium ===
        JMenu trapesiumMenu = new JMenu("Trapesium");

        // === Menu Jajar Genjang ===
        JMenu jajarGenjangMenu = new JMenu("Jajar Genjang");

        // === Menu Layang_Layang ===
        JMenu layangLayangMenu = new JMenu("Layang-Layang");

        // === Menu Belah Ketupat ===
        JMenu belahKetupatMenu = new JMenu("Belah Ketupat");

        // Tambahkan semua menu ke MenuBar (sejajar)
        menuBar.add(lingkaranMenu);
        menuBar.add(persegiMenu);
        menuBar.add(persegiPanjangMenu);
        menuBar.add(segitigaMenu);
        menuBar.add(trapesiumMenu);
        menuBar.add(jajarGenjangMenu);
        menuBar.add(layangLayangMenu);
        menuBar.add(belahKetupatMenu);

        // Pasang ke frame
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
}