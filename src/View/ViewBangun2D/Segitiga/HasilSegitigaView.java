package View.ViewBangun2D.Segitiga;

import Benda2D.Segitiga;
import javax.swing.*;
import java.awt.*;

public class HasilSegitigaView extends JFrame {

    // Constructor menerima objek Segitiga yang sudah dihitung
    public HasilSegitigaView(Segitiga segitiga) {
        initComponents(segitiga);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Segitiga");
    }

    private void initComponents(Segitiga segitiga) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        // --- Judul ---
        JLabel jLabelTitle = new JLabel("HASIL HITUNG SEGITIGA", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        // --- Tampilan Hasil ---
        // Label untuk input awal
        JLabel jLabelInputAlas = new JLabel("Input Alas (Sisi) :");
        jLabelInputAlas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputAlas.setBounds(70, 100, 150, 25);
        add(jLabelInputAlas);

        JTextField jTextFieldAlas = new JTextField(String.valueOf(segitiga.sisi));
        jTextFieldAlas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldAlas.setBounds(230, 100, 200, 25);
        jTextFieldAlas.setEditable(false); // Biar cuma bisa dibaca
        add(jTextFieldAlas);

        JLabel jLabelInputTinggi = new JLabel("Input Tinggi :");
        jLabelInputTinggi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputTinggi.setBounds(70, 140, 150, 25);
        add(jLabelInputTinggi);

        JTextField jTextFieldTinggi = new JTextField(String.valueOf(segitiga.tinggi));
        jTextFieldTinggi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldTinggi.setBounds(230, 140, 200, 25);
        jTextFieldTinggi.setEditable(false);
        add(jTextFieldTinggi);

        // Label untuk hasil kalkulasi
        JLabel jLabelLuas = new JLabel("Luas :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 200, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", segitiga.getLuasSegitiga()));
        jTextFieldLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldLuas.setBounds(230, 200, 200, 30);
        jTextFieldLuas.setEditable(false);
        add(jTextFieldLuas);

        JLabel jLabelKeliling = new JLabel("Keliling :");
        jLabelKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelKeliling.setBounds(70, 250, 150, 25);
        add(jLabelKeliling);

        JTextField jTextFieldKeliling = new JTextField(String.format("%.2f", segitiga.getKelilingSegitiga()));
        jTextFieldKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldKeliling.setBounds(230, 250, 200, 30);
        jTextFieldKeliling.setEditable(false);
        add(jTextFieldKeliling);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 350, 500, 10);
        add(jSeparator2);

        // --- Tombol Aksi ---
        JButton jButtonEdit = new JButton("Edit");
        jButtonEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonEdit.setBounds(120, 370, 100, 30);
        add(jButtonEdit);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(280, 370, 100, 30);
        add(jButtonClose);

        // Action Listener untuk Tombol Edit
        jButtonEdit.addActionListener(e -> {
            // Tutup window hasil ini
            dispose();
            // Buka lagi window input Segitiga
            new SegitigaView(segitiga).setVisible(true);
        });

        // Action Listener untuk Tombol Close
        jButtonClose.addActionListener(e -> {
            // Tutup window hasil ini
            dispose();
        });
    }
}