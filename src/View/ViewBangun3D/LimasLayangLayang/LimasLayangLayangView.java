package View.ViewBangun3D.LimasLayangLayang;

import Benda3D.LimasLayangLayang;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;
// Diasumsikan ada kelas HasilLimasLayangLayangView di package yang sesuai
//import View.ViewBangun3D.Hasil.HasilLimasLayangLayangView;

import javax.swing.*;
import java.awt.*;

public class LimasLayangLayangView extends JFrame {

    LimasLayangLayang limas;
    JTextField jTextFieldD1 = new JTextField();
    JTextField jTextFieldD2 = new JTextField();
    JTextField jTextFieldSisi1 = new JTextField();
    JTextField jTextFieldSisi2 = new JTextField();
    JTextField jTextFieldTinggiLimas = new JTextField();
    JTextField jTextFieldTinggiSisi1 = new JTextField();
    JTextField jTextFieldTinggiSisi2 = new JTextField();

    public LimasLayangLayangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Layang-Layang");
    }

    public LimasLayangLayangView(LimasLayangLayang limas) {
        this.limas = limas;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Layang-Layang");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 650);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("LIMAS LAYANG-LAYANG");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(50, 20, 400, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Diagonal 1 Alas (d1):", jTextFieldD1, 100);
        addLabelAndText("Diagonal 2 Alas (d2):", jTextFieldD2, 140);
        addLabelAndText("Sisi A Alas:", jTextFieldSisi1, 180);
        addLabelAndText("Sisi B Alas:", jTextFieldSisi2, 220);
        addLabelAndText("Tinggi Limas:", jTextFieldTinggiLimas, 260);
        addLabelAndText("Tinggi Sisi Tegak 1:", jTextFieldTinggiSisi1, 300);
        addLabelAndText("Tinggi Sisi Tegak 2:", jTextFieldTinggiSisi2, 340);
        addSeparator(0, 550);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setBounds(55, 570, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(195, 570, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(335, 570, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputD1 = jTextFieldD1.getText();
                String inputD2 = jTextFieldD2.getText();
                String inputS1 = jTextFieldSisi1.getText();
                String inputS2 = jTextFieldSisi2.getText();
                String inputTL = jTextFieldTinggiLimas.getText();
                String inputTS1 = jTextFieldTinggiSisi1.getText();
                String inputTS2 = jTextFieldTinggiSisi2.getText();

                // Validasi input kosong
                if (inputD1.isEmpty() || inputD2.isEmpty() || inputS1.isEmpty() || inputS2.isEmpty() ||
                        inputTL.isEmpty() || inputTS1.isEmpty() || inputTS2.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputD1);
                new ValidasiFormatAngka().operasiFormatAngka(inputD2);
                new ValidasiFormatAngka().operasiFormatAngka(inputS1);
                new ValidasiFormatAngka().operasiFormatAngka(inputS2);
                new ValidasiFormatAngka().operasiFormatAngka(inputTL);
                new ValidasiFormatAngka().operasiFormatAngka(inputTS1);
                new ValidasiFormatAngka().operasiFormatAngka(inputTS2);

                // Konversi setelah validasi
                double d1 = Double.parseDouble(inputD1);
                double d2 = Double.parseDouble(inputD2);
                double s1 = Double.parseDouble(inputS1);
                double s2 = Double.parseDouble(inputS2);
                double tl = Double.parseDouble(inputTL);
                double ts1 = Double.parseDouble(inputTS1);
                double ts2 = Double.parseDouble(inputTS2);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(d1);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(d2);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(s1);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(s2);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tl);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(ts1);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(ts2);

                // Validasi logika: sisi-sisi layang-layang tidak boleh sama
                if (s1 == s2) {
                    throw new IllegalArgumentException("Sisi A dan Sisi B tidak boleh sama (itu adalah Belah Ketupat).");
                }

                // Jalankan perhitungan pada thread
                LimasLayangLayang newLimas = new LimasLayangLayang(d1, d2, s1, s2, tl, ts1, ts2);
                Thread thread = new Thread(new HitungBendaTask(newLimas));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilLimasLayangLayangView(newLimas).setVisible(true);
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
            jTextFieldSisi1.setText("");
            jTextFieldSisi2.setText("");
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
            jTextFieldD1.setText(String.valueOf(limas.diagonal1));
            jTextFieldD2.setText(String.valueOf(limas.diagonal2));
            jTextFieldSisi1.setText(String.valueOf(limas.sisi1));
            jTextFieldSisi2.setText(String.valueOf(limas.sisi2));
            jTextFieldTinggiLimas.setText(String.valueOf(limas.getTinggiLimas()));
            jTextFieldTinggiSisi1.setText(String.valueOf(limas.getTinggiSisiTegak1()));
            jTextFieldTinggiSisi2.setText(String.valueOf(limas.getTinggiSisiTegak2()));
        }
    }
}