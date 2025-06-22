package View.ViewBangun3D.LimasPersegi;

import Benda3D.LimasPersegi;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;
// Diasumsikan ada kelas HasilLimasPersegiView di package yang sesuai
//import View.ViewBangun3D.Hasil.HasilLimasPersegiView;

import javax.swing.*;
import java.awt.*;

public class LimasPersegiView extends JFrame {

    LimasPersegi limasPersegi;
    JTextField jTextFieldSisi = new JTextField();
    JTextField jTextFieldTinggi = new JTextField();

    public LimasPersegiView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Persegi");
    }

    public LimasPersegiView(LimasPersegi limasPersegi) {
        this.limasPersegi = limasPersegi;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Persegi");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("LIMAS PERSEGI");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(110, 20, 300, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Sisi Alas:", jTextFieldSisi, 100);
        addLabelAndText("Tinggi Limas:", jTextFieldTinggi, 140);
        addSeparator(0, 300);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setBounds(55, 320, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(195, 320, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(335, 320, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputSisi = jTextFieldSisi.getText();
                String inputTinggi = jTextFieldTinggi.getText();

                // Validasi input kosong
                if (inputSisi.isEmpty() || inputTinggi.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputSisi);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggi);

                // Konversi setelah validasi format
                double sisi = Double.parseDouble(inputSisi);
                double tinggi = Double.parseDouble(inputTinggi);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(sisi);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggi);

                // Jalankan perhitungan pada thread
                LimasPersegi newLimas = new LimasPersegi(sisi, tinggi);
                Thread thread = new Thread(new HitungBendaTask(newLimas));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilLimasPersegiView(newLimas).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldSisi.setText("");
            jTextFieldTinggi.setText("");
        });

        btnClose.addActionListener(e -> dispose());
    }

    private void addLabelAndText(String labelText, JTextField field, int y) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setBounds(70, y, 150, 25);
        add(label);

        field.setFont(new Font("Tahoma", Font.PLAIN, 14));
        field.setBounds(230, y, 200, 25);
        add(field);
    }

    private void addSeparator(int x, int y) {
        JSeparator separator = new JSeparator();
        separator.setBounds(x, y, 500, 10);
        add(separator);
    }

    void cek() {
        if (limasPersegi != null) {
            // Diasumsikan kelas LimasPersegi memiliki getter untuk properti
            jTextFieldSisi.setText(String.valueOf(limasPersegi.sisi));
            jTextFieldTinggi.setText(String.valueOf(limasPersegi.getTinggiLimasPersegi()));
        }
    }
}