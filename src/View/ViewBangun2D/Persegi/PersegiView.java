package View.ViewBangun2D.Persegi;

import Benda2D.Persegi;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;

import javax.swing.*;
import java.awt.*;

public class PersegiView extends JFrame {

    Persegi persegi;
    JTextField jTextFieldSisi = new JTextField();

    public PersegiView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Persegi");
    }

    public PersegiView(Persegi persegi) {
        this.persegi = persegi;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Persegi");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 350);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PERSEGI");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(180, 20, 200, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Sisi:", jTextFieldSisi, 100);
        addSeparator(0, 250);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setBounds(55, 270, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(195, 270, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(335, 270, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputSisi = jTextFieldSisi.getText();

                // Validasi input kosong
                if (inputSisi.isEmpty()) {
                    throw new IllegalArgumentException("Input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputSisi);

                // Konversi setelah validasi
                double sisi = Double.parseDouble(inputSisi);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(sisi);

                // Jalankan perhitungan pada thread
                Persegi newPersegi = new Persegi(sisi);
                Thread thread = new Thread(new HitungBendaTask(newPersegi));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilPersegiView(newPersegi).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> jTextFieldSisi.setText(""));

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
        if (persegi != null) {
            // Diasumsikan kelas Persegi memiliki getter untuk properti
            jTextFieldSisi.setText(String.valueOf(persegi.sisi));
        }
    }
}