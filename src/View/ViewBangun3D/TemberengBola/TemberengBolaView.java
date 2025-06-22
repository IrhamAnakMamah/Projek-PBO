package View.ViewBangun3D.TemberengBola;

import Benda3D.TemberengBola;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;
// Diasumsikan ada kelas HasilTemberengBolaView di package yang sesuai
//import View.ViewBangun3D.Hasil.HasilTemberengBolaView;

import javax.swing.*;
import java.awt.*;

public class TemberengBolaView extends JFrame {

    TemberengBola temberengBola;
    JTextField jTextFieldJari = new JTextField();
    JTextField jTextFieldTinggi = new JTextField();

    public TemberengBolaView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Tembereng Bola");
    }

    public TemberengBolaView(TemberengBola temberengBola) {
        this.temberengBola = temberengBola;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Tembereng Bola");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("TEMBERENG BOLA");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(90, 20, 320, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Jari-Jari Bola (R):", jTextFieldJari, 100);
        addLabelAndText("Tinggi Tembereng (t):", jTextFieldTinggi, 140);
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
                String inputJari = jTextFieldJari.getText();
                String inputTinggi = jTextFieldTinggi.getText();

                // Validasi input kosong
                if (inputJari.isEmpty() || inputTinggi.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputJari);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggi);

                // Konversi setelah validasi
                double jari = Double.parseDouble(inputJari);
                double tinggi = Double.parseDouble(inputTinggi);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(jari);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggi);

                // Validasi logika: tinggi tembereng tidak boleh > diameter bola
                if (tinggi > (2 * jari)) {
                    throw new IllegalArgumentException("Tinggi tembereng (t) tidak boleh melebihi diameter bola (2R).");
                }

                // Jalankan perhitungan pada thread
                TemberengBola newTb = new TemberengBola(jari, tinggi);
                Thread thread = new Thread(new HitungBendaTask(newTb));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilTemberengBolaView(newTb).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldJari.setText("");
            jTextFieldTinggi.setText("");
        });

        btnClose.addActionListener(e -> dispose());
    }

    private void addLabelAndText(String labelText, JTextField field, int y) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setBounds(70, y, 160, 25); // Lebar label disesuaikan
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
        if (temberengBola != null) {
            // Diasumsikan kelas TemberengBola memiliki getter untuk properti
            jTextFieldJari.setText(String.valueOf(temberengBola.jariJari));
            jTextFieldTinggi.setText(String.valueOf(temberengBola.getTinggiTembereng()));
        }
    }
}