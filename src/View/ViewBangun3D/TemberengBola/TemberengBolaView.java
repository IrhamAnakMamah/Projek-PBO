package View.ViewBangun3D.TemberengBola;

import Benda3D.TemberengBola;
import javax.swing.*;
import java.awt.*;

public class TemberengBolaView extends JFrame {

    TemberengBola temberengBola;
    int es;
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

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelJari = new JLabel("Jari-Jari Bola (R):");
        jLabelJari.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelJari.setBounds(70, 100, 150, 25);
        add(jLabelJari);
        jTextFieldJari.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldJari.setBounds(230, 100, 200, 25);
        add(jTextFieldJari);

        JLabel jLabelTinggi = new JLabel("Tinggi Tembereng (t) :");
        jLabelTinggi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggi.setBounds(70, 140, 160, 25);
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
                double r = Double.parseDouble(jTextFieldJari.getText());
                double t = Double.parseDouble(jTextFieldTinggi.getText());
                if (r <= 0 || t <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                TemberengBola newTb = new TemberengBola(r,t); //

                new HasilTemberengBolaView(newTb).setVisible(true);
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
        if (temberengBola != null) {
            // properties private
        }
    }
}