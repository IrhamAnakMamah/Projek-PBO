package View.ViewBangun2D.Trapesium;

import Benda2D.Trapesium;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;

import javax.swing.*;
import java.awt.*;

public class TrapesiumView extends JFrame {

    private Trapesium trapesium;
    private final JTextField jTextFieldSisi1 = new JTextField();
    private final JTextField jTextFieldSisi2 = new JTextField();
    private final JTextField jTextFieldTinggi = new JTextField();

    public TrapesiumView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Trapesium");
    }

    public TrapesiumView(Trapesium trapesium) {
        this.trapesium = trapesium;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Trapesium");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("TRAPESIUM");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(150, 20, 300, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Sisi Sejajar 1:", jTextFieldSisi1, 100);
        addLabelAndText("Sisi Sejajar 2:", jTextFieldSisi2, 140);
        addLabelAndText("Tinggi:", jTextFieldTinggi, 180);
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
                String inputSisi1 = jTextFieldSisi1.getText();
                String inputSisi2 = jTextFieldSisi2.getText();
                String inputTinggi = jTextFieldTinggi.getText();

                // Validasi input kosong
                if (inputSisi1.isEmpty() || inputSisi2.isEmpty() || inputTinggi.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputSisi1);
                new ValidasiFormatAngka().operasiFormatAngka(inputSisi2);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggi);

                // Konversi setelah validasi
                double sisi1 = Double.parseDouble(inputSisi1);
                double sisi2 = Double.parseDouble(inputSisi2);
                double tinggi = Double.parseDouble(inputTinggi);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(sisi1);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(sisi2);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggi);

                // Validasi logika
                if (sisi1 == sisi2) {
                    throw new IllegalArgumentException("Sisi sejajar tidak boleh sama (itu adalah Jajar Genjang).");
                }

                // Jalankan perhitungan pada thread
                Trapesium newTrapesium = new Trapesium(sisi1, sisi2, tinggi);
                Thread thread = new Thread(new HitungBendaTask(newTrapesium));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilTrapesiumView(newTrapesium).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Perhitungan terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldSisi1.setText("");
            jTextFieldSisi2.setText("");
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
        if (trapesium != null) {
            // Diasumsikan kelas Trapesium memiliki getter untuk properti
            jTextFieldSisi1.setText(String.valueOf(trapesium.getSisiSejajar1()));
            jTextFieldSisi2.setText(String.valueOf(trapesium.getSisiSejajar2()));
            jTextFieldTinggi.setText(String.valueOf(trapesium.getTinggi()));
        }
    }
}