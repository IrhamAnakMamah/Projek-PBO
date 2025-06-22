package View.ViewBangun2D.LayangLayang;

import Benda2D.LayangLayang;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;
import javax.swing.*;
import java.awt.*;

public class LayangLayangView extends JFrame {

    LayangLayang layangLayang;
    JTextField jTextFieldD1 = new JTextField();
    JTextField jTextFieldD2 = new JTextField();
    JTextField jTextFieldSisi1 = new JTextField();
    JTextField jTextFieldSisi2 = new JTextField();

    public LayangLayangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Layang-Layang");
    }

    public LayangLayangView(LayangLayang layangLayang) {
        this.layangLayang = layangLayang;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Layang-Layang");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("LAYANG-LAYANG");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(110, 20, 300, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Diagonal 1:", jTextFieldD1, 100);
        addLabelAndText("Diagonal 2:", jTextFieldD2, 140);
        addLabelAndText("Sisi A (pendek):", jTextFieldSisi1, 180);
        addLabelAndText("Sisi B (panjang):", jTextFieldSisi2, 220);
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
                String inputS1 = jTextFieldSisi1.getText();
                String inputS2 = jTextFieldSisi2.getText();

                // Validasi input kosong
                if (inputD1.isEmpty() || inputD2.isEmpty() || inputS1.isEmpty() || inputS2.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputD1);
                new ValidasiFormatAngka().operasiFormatAngka(inputD2);
                new ValidasiFormatAngka().operasiFormatAngka(inputS1);
                new ValidasiFormatAngka().operasiFormatAngka(inputS2);

                // Konversi setelah validasi
                double d1 = Double.parseDouble(inputD1);
                double d2 = Double.parseDouble(inputD2);
                double s1 = Double.parseDouble(inputS1);
                double s2 = Double.parseDouble(inputS2);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(d1);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(d2);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(s1);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(s2);

                // Validasi logika: sisi-sisi layang-layang tidak boleh sama
                if (s1 == s2) {
                    throw new IllegalArgumentException("Sisi A dan Sisi B tidak boleh sama (itu adalah Belah Ketupat).");
                }

                // Jalankan perhitungan pada thread
                LayangLayang newLl = new LayangLayang(d1, d2, s1, s2);
                Thread thread = new Thread(new HitungBendaTask(newLl));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilLayangLayangView(newLl).setVisible(true);
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
        if (layangLayang != null) {
            // Diasumsikan kelas LayangLayang memiliki getter untuk properti
            jTextFieldD1.setText(String.valueOf(layangLayang.diagonal1));
            jTextFieldD2.setText(String.valueOf(layangLayang.diagonal2));
            jTextFieldSisi1.setText(String.valueOf(layangLayang.sisi1));
            jTextFieldSisi2.setText(String.valueOf(layangLayang.sisi2));
        }
    }
}