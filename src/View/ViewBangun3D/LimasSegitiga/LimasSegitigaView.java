package View.ViewBangun3D.LimasSegitiga;

import Benda3D.LimasSegitiga;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;
// Diasumsikan ada kelas HasilLimasSegitigaView di package yang sesuai
//import View.ViewBangun3D.Hasil.HasilLimasSegitigaView;

import javax.swing.*;
import java.awt.*;

public class LimasSegitigaView extends JFrame {

    LimasSegitiga limasSegitiga;
    JTextField jTextFieldAlas = new JTextField();
    JTextField jTextFieldTinggiAlas = new JTextField();
    JTextField jTextFieldTinggiLimas = new JTextField();
    JTextField jTextFieldSisi1 = new JTextField();
    JTextField jTextFieldSisi2 = new JTextField();
    JTextField jTextFieldSisi3 = new JTextField();

    public LimasSegitigaView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Segitiga");
    }

    public LimasSegitigaView(LimasSegitiga limasSegitiga) {
        this.limasSegitiga = limasSegitiga;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Segitiga");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 600);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("LIMAS SEGITIGA");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(110, 20, 300, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Alas Segitiga:", jTextFieldAlas, 100);
        addLabelAndText("Tinggi Alas:", jTextFieldTinggiAlas, 140);
        addLabelAndText("Tinggi Limas:", jTextFieldTinggiLimas, 180);
        addLabelAndText("Sisi Alas 1:", jTextFieldSisi1, 220);
        addLabelAndText("Sisi Alas 2:", jTextFieldSisi2, 260);
        addLabelAndText("Sisi Alas 3:", jTextFieldSisi3, 300);
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
                String inputAlas = jTextFieldAlas.getText();
                String inputTinggiAlas = jTextFieldTinggiAlas.getText();
                String inputTinggiLimas = jTextFieldTinggiLimas.getText();
                String inputS1 = jTextFieldSisi1.getText();
                String inputS2 = jTextFieldSisi2.getText();
                String inputS3 = jTextFieldSisi3.getText();

                // Validasi input kosong
                if (inputAlas.isEmpty() || inputTinggiAlas.isEmpty() || inputTinggiLimas.isEmpty() ||
                        inputS1.isEmpty() || inputS2.isEmpty() || inputS3.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputAlas);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggiAlas);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggiLimas);
                new ValidasiFormatAngka().operasiFormatAngka(inputS1);
                new ValidasiFormatAngka().operasiFormatAngka(inputS2);
                new ValidasiFormatAngka().operasiFormatAngka(inputS3);

                // Konversi setelah validasi
                double alas = Double.parseDouble(inputAlas);
                double tinggiAlas = Double.parseDouble(inputTinggiAlas);
                double tinggiLimas = Double.parseDouble(inputTinggiLimas);
                double s1 = Double.parseDouble(inputS1);
                double s2 = Double.parseDouble(inputS2);
                double s3 = Double.parseDouble(inputS3);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(alas);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggiAlas);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggiLimas);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(s1);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(s2);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(s3);

                // Validasi logika: Pertidaksamaan Segitiga
                if (!((s1 + s2 > s3) && (s1 + s3 > s2) && (s2 + s3 > s1))) {
                    throw new IllegalArgumentException("Sisi-sisi yang diinput tidak dapat membentuk segitiga.");
                }

                // Jalankan perhitungan pada thread
                LimasSegitiga newLimas = new LimasSegitiga(alas, tinggiAlas, tinggiLimas, s1, s2, s3);
                Thread thread = new Thread(new HitungBendaTask(newLimas));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilLimasSegitigaView(newLimas).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldAlas.setText("");
            jTextFieldTinggiAlas.setText("");
            jTextFieldTinggiLimas.setText("");
            jTextFieldSisi1.setText("");
            jTextFieldSisi2.setText("");
            jTextFieldSisi3.setText("");
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
        if (limasSegitiga != null) {
            // Diasumsikan kelas LimasSegitiga memiliki getter untuk semua properti
            jTextFieldAlas.setText(String.valueOf(limasSegitiga.sisi));
            jTextFieldTinggiAlas.setText(String.valueOf(limasSegitiga.tinggi));
            jTextFieldTinggiLimas.setText(String.valueOf(limasSegitiga.tinggiLimasSegitiga));
            jTextFieldSisi1.setText(String.valueOf(limasSegitiga.getSisi1()));
            jTextFieldSisi2.setText(String.valueOf(limasSegitiga.getSisi2()));
            jTextFieldSisi3.setText(String.valueOf(limasSegitiga.getSisi3()));
        }
    }
}