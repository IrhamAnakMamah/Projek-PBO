package View.ViewBangun3D.KerucutTerpancung;

import Benda3D.KerucutTerpancung;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;
// Diasumsikan ada kelas HasilKerucutTerpancungView di package yang sesuai
//import View.ViewBangun3D.Hasil.HasilKerucutTerpancungView;

import javax.swing.*;
import java.awt.*;

public class KerucutTerpancungView extends JFrame {

    KerucutTerpancung kerucutTerpancung;
    JTextField jTextFieldTinggi = new JTextField();
    JTextField jTextFieldJariAtas = new JTextField();
    JTextField jTextFieldJariBawah = new JTextField();

    public KerucutTerpancungView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Kerucut Terpancung");
    }

    public KerucutTerpancungView(KerucutTerpancung kerucutTerpancung) {
        this.kerucutTerpancung = kerucutTerpancung;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Kerucut Terpancung");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("KERUCUT TERPANCUNG");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(50, 20, 400, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Tinggi (t):", jTextFieldTinggi, 100);
        addLabelAndText("Jari-Jari Atas (r):", jTextFieldJariAtas, 140);
        addLabelAndText("Jari-Jari Bawah (R):", jTextFieldJariBawah, 180);
        addSeparator(0, 350);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setBounds(55, 370, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(195, 370, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(335, 370, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputTinggi = jTextFieldTinggi.getText();
                String inputJariAtas = jTextFieldJariAtas.getText();
                String inputJariBawah = jTextFieldJariBawah.getText();

                // Validasi input kosong
                if (inputTinggi.isEmpty() || inputJariAtas.isEmpty() || inputJariBawah.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggi);
                new ValidasiFormatAngka().operasiFormatAngka(inputJariAtas);
                new ValidasiFormatAngka().operasiFormatAngka(inputJariBawah);

                // Konversi setelah validasi format
                double tinggi = Double.parseDouble(inputTinggi);
                double jariAtas = Double.parseDouble(inputJariAtas);
                double jariBawah = Double.parseDouble(inputJariBawah);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggi);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(jariAtas);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(jariBawah);

                // Validasi logika: jari-jari tidak boleh sama
                if (jariAtas == jariBawah) {
                    throw new IllegalArgumentException("Jari-jari atas dan bawah tidak boleh sama (itu adalah Tabung).");
                }

                // Jalankan perhitungan pada thread
                KerucutTerpancung newKt = new KerucutTerpancung(tinggi, jariAtas, jariBawah);
                Thread thread = new Thread(new HitungBendaTask(newKt));
                thread.start();
                thread.join();

                // Menampilkan hasil menggunakan HasilKerucutTerpancungView
                new HasilKerucutTerpancungView(newKt).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldTinggi.setText("");
            jTextFieldJariAtas.setText("");
            jTextFieldJariBawah.setText("");
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
        if (kerucutTerpancung != null) {
            // Diasumsikan kelas KerucutTerpancung memiliki getter berikut
            jTextFieldTinggi.setText(String.valueOf(kerucutTerpancung.getTinggi()));
            jTextFieldJariAtas.setText(String.valueOf(kerucutTerpancung.getJariJariAtas()));
            // Menggunakan getJariJari() untuk Jari-jari Bawah (sesuai kode asli yang diberikan)
            jTextFieldJariBawah.setText(String.valueOf(kerucutTerpancung.getJariJari()));
        }
    }
}