package View.ViewBangun3D.LimasBelahKetupat;

import Benda3D.LimasBelahKetupat;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;
// Diasumsikan ada kelas HasilLimasBelahKetupatView di package yang sesuai
//import View.ViewBangun3D.Hasil.HasilLimasBelahKetupatView;

import javax.swing.*;
import java.awt.*;

public class LimasBelahKetupatView extends JFrame {

    LimasBelahKetupat limas;
    JTextField jTextFieldD1 = new JTextField();
    JTextField jTextFieldD2 = new JTextField();
    JTextField jTextFieldTinggiLimas = new JTextField();
    JTextField jTextFieldTinggiSisi = new JTextField();

    public LimasBelahKetupatView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Belah Ketupat");
    }

    public LimasBelahKetupatView(LimasBelahKetupat limas) {
        this.limas = limas;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Belah Ketupat");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("LIMAS BELAH KETUPAT");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(50, 20, 400, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Diagonal 1 Alas (d1):", jTextFieldD1, 100);
        addLabelAndText("Diagonal 2 Alas (d2):", jTextFieldD2, 140);
        addLabelAndText("Tinggi Limas:", jTextFieldTinggiLimas, 180);
        addLabelAndText("Tinggi Sisi Tegak:", jTextFieldTinggiSisi, 220);
        addSeparator(0, 400);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setBounds(55, 420, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(195, 420, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(335, 420, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputD1 = jTextFieldD1.getText();
                String inputD2 = jTextFieldD2.getText();
                String inputTinggiLimas = jTextFieldTinggiLimas.getText();
                String inputTinggiSisi = jTextFieldTinggiSisi.getText();

                // Validasi input kosong
                if (inputD1.isEmpty() || inputD2.isEmpty() || inputTinggiLimas.isEmpty() || inputTinggiSisi.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputD1);
                new ValidasiFormatAngka().operasiFormatAngka(inputD2);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggiLimas);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggiSisi);

                // Konversi setelah validasi format
                double d1 = Double.parseDouble(inputD1);
                double d2 = Double.parseDouble(inputD2);
                double tinggiLimas = Double.parseDouble(inputTinggiLimas);
                double tinggiSisi = Double.parseDouble(inputTinggiSisi);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(d1);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(d2);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggiLimas);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggiSisi);

                // Jalankan perhitungan pada thread
                LimasBelahKetupat newLimas = new LimasBelahKetupat(d1, d2, tinggiLimas, tinggiSisi);
                Thread thread = new Thread(new HitungBendaTask(newLimas));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilLimasBelahKetupatView(newLimas).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldD1.setText("");
            jTextFieldD2.setText("");
            jTextFieldTinggiLimas.setText("");
            jTextFieldTinggiSisi.setText("");
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
        if (limas != null) {
            // Diasumsikan kelas LimasBelahKetupat memiliki getter untuk semua properti
            jTextFieldD1.setText(String.valueOf(limas.diagonal1));
            jTextFieldD2.setText(String.valueOf(limas.diagonal2));
            jTextFieldTinggiLimas.setText(String.valueOf(limas.getTinggiLimas()));
            jTextFieldTinggiSisi.setText(String.valueOf(limas.getTinggiSisiTegak()));
        }
    }
}