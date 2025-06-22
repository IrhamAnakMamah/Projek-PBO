package View.ViewBangun3D.Tabung;

import Benda3D.Tabung;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;

import javax.swing.*;
import java.awt.*;

public class TabungView extends JFrame {

    Tabung tabung;
    JTextField jTextFieldJari = new JTextField();
    JTextField jTextFieldTinggi = new JTextField();

    public TabungView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Tabung");
    }

    public TabungView(Tabung tabung) {
        this.tabung = tabung;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Tabung");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("TABUNG");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(180, 20, 300, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndField("Jari-Jari Alas:", jTextFieldJari, 100);
        addLabelAndField("Tinggi Tabung:", jTextFieldTinggi, 140);
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
                    throw new IllegalArgumentException("Semua input harus diisi!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputJari);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggi);

                double jari = Double.parseDouble(inputJari);
                double tinggi = Double.parseDouble(inputTinggi);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(jari);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggi);

                // Perhitungan menggunakan threading
                Tabung newTabung = new Tabung(jari, tinggi);
                Thread thread = new Thread(new HitungBendaTask(newTabung));
                thread.start();
                thread.join();

                new HasilTabungView(newTabung).setVisible(true);
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

    private void addLabelAndField(String labelText, JTextField field, int y) {
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
        if (tabung != null) {
            jTextFieldJari.setText(String.valueOf(tabung.getJariJari()));
            jTextFieldTinggi.setText(String.valueOf(tabung.getTinggiTabung()));
        }
    }
}
