package View.ViewBangun3D.LimasTrapesium;

import Benda3D.LimasTrapesium;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;
// Diasumsikan ada kelas HasilLimasTrapesiumView di package yang sesuai
//import View.ViewBangun3D.Hasil.HasilLimasTrapesiumView;

import javax.swing.*;
import java.awt.*;

public class LimasTrapesiumView extends JFrame {

    LimasTrapesium limas;
    JTextField jTextFieldSisi1 = new JTextField();
    JTextField jTextFieldSisi2 = new JTextField();
    JTextField jTextFieldTinggiAlas = new JTextField();
    JTextField jTextFieldTinggiLimas = new JTextField();
    JTextField jTextFieldTinggiSisi1 = new JTextField();
    JTextField jTextFieldTinggiSisi2 = new JTextField();

    public LimasTrapesiumView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Trapesium");
    }

    public LimasTrapesiumView(LimasTrapesium limas) {
        this.limas = limas;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Trapesium");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 600);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("LIMAS TRAPESIUM");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(100, 20, 300, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Sisi Sejajar 1 Alas:", jTextFieldSisi1, 100);
        addLabelAndText("Sisi Sejajar 2 Alas:", jTextFieldSisi2, 140);
        addLabelAndText("Tinggi Alas:", jTextFieldTinggiAlas, 180);
        addLabelAndText("Tinggi Limas:", jTextFieldTinggiLimas, 220);
        addLabelAndText("Tinggi Sisi Tegak 1:", jTextFieldTinggiSisi1, 260);
        addLabelAndText("Tinggi Sisi Tegak 2:", jTextFieldTinggiSisi2, 300);
        addSeparator(0, 500);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setBounds(55, 520, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(195, 520, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(335, 520, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputS1 = jTextFieldSisi1.getText();
                String inputS2 = jTextFieldSisi2.getText();
                String inputTA = jTextFieldTinggiAlas.getText();
                String inputTL = jTextFieldTinggiLimas.getText();
                String inputTS1 = jTextFieldTinggiSisi1.getText();
                String inputTS2 = jTextFieldTinggiSisi2.getText();

                // Validasi input kosong
                if (inputS1.isEmpty() || inputS2.isEmpty() || inputTA.isEmpty() || inputTL.isEmpty() ||
                        inputTS1.isEmpty() || inputTS2.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputS1);
                new ValidasiFormatAngka().operasiFormatAngka(inputS2);
                new ValidasiFormatAngka().operasiFormatAngka(inputTA);
                new ValidasiFormatAngka().operasiFormatAngka(inputTL);
                new ValidasiFormatAngka().operasiFormatAngka(inputTS1);
                new ValidasiFormatAngka().operasiFormatAngka(inputTS2);

                // Konversi setelah validasi
                double s1 = Double.parseDouble(inputS1);
                double s2 = Double.parseDouble(inputS2);
                double ta = Double.parseDouble(inputTA);
                double tl = Double.parseDouble(inputTL);
                double ts1 = Double.parseDouble(inputTS1);
                double ts2 = Double.parseDouble(inputTS2);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(s1);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(s2);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(ta);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tl);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(ts1);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(ts2);

                // Validasi logika: sisi sejajar tidak boleh sama
                if (s1 == s2) {
                    throw new IllegalArgumentException("Sisi sejajar tidak boleh sama (itu adalah Jajar Genjang/Persegi Panjang).");
                }

                // Jalankan perhitungan pada thread
                LimasTrapesium newLimas = new LimasTrapesium(s1, s2, ta, tl, ts1, ts2);
                Thread thread = new Thread(new HitungBendaTask(newLimas));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilLimasTrapesiumView(newLimas).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldSisi1.setText("");
            jTextFieldSisi2.setText("");
            jTextFieldTinggiAlas.setText("");
            jTextFieldTinggiLimas.setText("");
            jTextFieldTinggiSisi1.setText("");
            jTextFieldTinggiSisi2.setText("");
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
            // Diasumsikan kelas LimasTrapesium memiliki getter untuk semua properti
            jTextFieldSisi1.setText(String.valueOf(limas.getSisiSejajar1()));
            jTextFieldSisi2.setText(String.valueOf(limas.getSisiSejajar2()));
            jTextFieldTinggiAlas.setText(String.valueOf(limas.tinggi));
            jTextFieldTinggiLimas.setText(String.valueOf(limas.getTinggiLimas()));
            jTextFieldTinggiSisi1.setText(String.valueOf(limas.getTinggiSisiTegak1()));
            jTextFieldTinggiSisi2.setText(String.valueOf(limas.getTinggiSisiTegak2()));
        }
    }
}