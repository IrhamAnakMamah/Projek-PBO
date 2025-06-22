package View.ViewBangun3D.Kerucut;

import Benda3D.Kerucut;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;

import javax.swing.*;
import java.awt.*;

public class KerucutView extends JFrame {

    Kerucut kerucut;
    JTextField jTextFieldJari = new JTextField();
    JTextField jTextFieldTinggi = new JTextField();

    public KerucutView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Kerucut");
    }

    public KerucutView(Kerucut kerucut) {
        this.kerucut = kerucut;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Kerucut");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("KERUCUT");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(170, 20, 300, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Jari-Jari Alas:", jTextFieldJari, 100);
        addLabelAndText("Tinggi Kerucut:", jTextFieldTinggi, 140);
        addSeparator(0, 300);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnHitung.setBounds(55, 320, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnReset.setBounds(195, 320, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
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

                // Konversi angka
                double jari = Double.parseDouble(inputJari);
                double tinggi = Double.parseDouble(inputTinggi);

                // Validasi negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(jari);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggi);

                // Hitung pakai thread
                Kerucut newKerucut = new Kerucut(jari, tinggi);
                Thread thread = new Thread(new HitungBendaTask(newKerucut));
                thread.start();
                thread.join();

                new HasilKerucutView(newKerucut).setVisible(true);
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
        if (kerucut != null) {
            jTextFieldJari.setText(String.valueOf(kerucut.getJariJari()));
            jTextFieldTinggi.setText(String.valueOf(kerucut.getTinggiKerucut()));
        }
    }
}
