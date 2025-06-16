package View.ViewBangun3D.Tabung;

import Benda3D.Tabung;
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

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelJari = new JLabel("Jari-Jari Alas:");
        jLabelJari.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelJari.setBounds(70, 100, 150, 25);
        add(jLabelJari);
        jTextFieldJari.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldJari.setBounds(230, 100, 200, 25);
        add(jTextFieldJari);

        JLabel jLabelTinggi = new JLabel("Tinggi Tabung :");
        jLabelTinggi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggi.setBounds(70, 140, 150, 25);
        add(jLabelTinggi);
        jTextFieldTinggi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggi.setBounds(230, 140, 200, 25);
        add(jTextFieldTinggi);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 300, 500, 10);
        add(jSeparator2);

        JButton jButtonsSave = new JButton("Hitung");
        jButtonsSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonsSave.setBounds(55, 320, 100, 30);
        add(jButtonsSave);

        JButton jButtonReset = new JButton("Reset");
        jButtonReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonReset.setBounds(195, 320, 100, 30);
        add(jButtonReset);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(335, 320, 100, 30);
        add(jButtonClose);

        cek();

        jButtonsSave.addActionListener(e -> {
            try {
                double jari = Double.parseDouble(jTextFieldJari.getText());
                double tinggi = Double.parseDouble(jTextFieldTinggi.getText());
                if (jari <= 0 || tinggi <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                Tabung newTabung = new Tabung(jari, tinggi); //

                Thread calcThread = new Thread(newTabung);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilTabungView(newTabung).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldJari.setText("");
            jTextFieldTinggi.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (tabung != null) {
            jTextFieldJari.setText(String.valueOf(tabung.getJariJari()));
            // tinggiTabung is private, need getter
        }
    }
}