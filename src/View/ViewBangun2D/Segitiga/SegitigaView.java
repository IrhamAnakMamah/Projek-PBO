package View.ViewBangun2D.Segitiga;

import Benda2D.Segitiga;

import javax.swing.*;

import java.awt.*;

public class SegitigaView extends JFrame {

    Segitiga segitiga;

    JTextField jTextFieldTinggi = new JTextField();

    JTextField jTextFieldAlas = new JTextField();

    public SegitigaView() {

        initComponents();

        setLocationRelativeTo(null);

        setTitle("Kalkulator Segitiga");

    }

    public SegitigaView(Segitiga segitiga) {

        this.segitiga = segitiga;

        initComponents();

        setLocationRelativeTo(null);

        setTitle("Kalkulator Segitiga");

    }

    private void initComponents() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(500, 400);

        setLayout(null);

        JLabel jLabelTitle = new JLabel("SEGITIGA");

        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        jLabelTitle.setBounds(170, 20, 300, 37);

        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();

        jSeparator1.setBounds(0, 70, 500, 10);

        add(jSeparator1);

        JLabel jLabelAlas = new JLabel("Alas (Sisi) :");

        jLabelAlas.setFont(new Font("Tahoma", Font.BOLD, 14));

        jLabelAlas.setBounds(70, 100, 150, 25);

        add(jLabelAlas);

        jTextFieldAlas.setFont(new Font("Tahoma", Font.PLAIN, 14));

        jTextFieldAlas.setBounds(230, 100, 200, 25);

        add(jTextFieldAlas);

        JLabel jLabelTinggi = new JLabel("Tinggi :");

        jLabelTinggi.setFont(new Font("Tahoma", Font.BOLD, 14));

        jLabelTinggi.setBounds(70, 140, 150, 25);

        add(jLabelTinggi);

        jTextFieldTinggi.setFont(new Font("Tahoma", Font.PLAIN, 14));

        jTextFieldTinggi.setBounds(230, 140, 200, 25);

        add(jTextFieldTinggi);

        JSeparator jSeparator2 = new JSeparator();

        jSeparator2.setBounds(0, 300, 500, 10);

        add(jSeparator2);

        JButton jButtonsSave = new JButton("Hitung");

        jButtonsSave.setFont(new Font("Tahoma", Font.BOLD, 14));

        jButtonsSave.setBounds(55, 320, 100, 30);

        add(jButtonsSave);

        JButton jButtonReset = new JButton("Reset");

        jButtonReset.setFont(new Font("Tahoma", Font.BOLD, 14));

        jButtonReset.setBounds(195, 320, 100, 30);

        add(jButtonReset);

        JButton jButtonClose = new JButton("Close");

        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));

        jButtonClose.setBounds(335, 320, 100, 30);

        add(jButtonClose);

        cek();

        jButtonsSave.addActionListener(e -> {

            try {

                double alas = Double.parseDouble(jTextFieldAlas.getText());

                double tinggi = Double.parseDouble(jTextFieldTinggi.getText());

                if (alas <= 0 || tinggi <= 0) {

                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");

                }

                Segitiga segitiga = new Segitiga(alas, tinggi); //

                // ==========================================================

                // --- BAGIAN YANG DIUBAH ---

                // ==========================================================

                // 1. Jalankan thread untuk kalkulasi di background

                Thread calcThread = new Thread(segitiga);

                calcThread.start();

                // 2. Tunggu sampai kalkulasi selesai sebelum menampilkan hasil

                try {

                    calcThread.join();

                } catch (InterruptedException ex) {

                    ex.printStackTrace();

                }

                // 3. Tampilkan GUI Hasil

                new HasilSegitigaView(segitiga).setVisible(true);

                // ==========================================================

                // --- AKHIR BAGIAN YANG DIUBAH ---

                // ==========================================================

                // Tutup window input ini

                dispose();

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }

        });

        jButtonReset.addActionListener(e -> {

            jTextFieldAlas.setText("");

            jTextFieldTinggi.setText("");

        });

        jButtonClose.addActionListener(e -> dispose());

    }

    void cek() {

        if (segitiga != null) {

            int alas = (int) segitiga.sisi;

            int tinggi = (int) segitiga.tinggi;

            jTextFieldAlas.setText(Integer.toString(alas));

            jTextFieldTinggi.setText(Integer.toString(tinggi));

        }

    }

}