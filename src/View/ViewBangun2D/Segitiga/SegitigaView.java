package View.ViewBangun2D.Segitiga;

import Benda2D.Segitiga;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;

import javax.swing.*;
import java.awt.*;

public class SegitigaView extends JFrame {

    Segitiga segitiga;
    JTextField jTextFieldTinggi = new JTextField();
    JTextField jTextFieldAlas = new JTextField();

    public SegitigaView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Segitiga");
    }

    public SegitigaView(Segitiga segitiga) {
        this.segitiga = segitiga;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Segitiga");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("SEGITIGA");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(170, 20, 300, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Alas:", jTextFieldAlas, 100);
        addLabelAndText("Tinggi:", jTextFieldTinggi, 140);
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
                String inputAlas = jTextFieldAlas.getText();
                String inputTinggi = jTextFieldTinggi.getText();

                // Validasi input kosong
                if (inputAlas.isEmpty() || inputTinggi.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputAlas);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggi);

                // Konversi setelah validasi
                double alas = Double.parseDouble(inputAlas);
                double tinggi = Double.parseDouble(inputTinggi);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(alas);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggi);

                // Jalankan perhitungan pada thread
                Segitiga newSegitiga = new Segitiga(alas, tinggi);
                Thread thread = new Thread(new HitungBendaTask(newSegitiga));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilSegitigaView(newSegitiga).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldAlas.setText("");
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
        if (segitiga != null) {
            // Diasumsikan kelas Segitiga memiliki getter untuk properti
            jTextFieldAlas.setText(String.valueOf(segitiga.sisi));
            jTextFieldTinggi.setText(String.valueOf(segitiga.tinggi));
        }
    }
}