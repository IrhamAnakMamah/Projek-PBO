package View.ViewBangun2D.Trapesium;

import Benda2D.Trapesium;
import javax.swing.*;
import java.awt.*;

public class TrapesiumView extends JFrame {

    Trapesium trapesium;
    JTextField jTextFieldSisi1 = new JTextField();
    JTextField jTextFieldSisi2 = new JTextField();
    JTextField jTextFieldTinggi = new JTextField();

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

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelSisi1 = new JLabel("Sisi Sejajar 1 :");
        jLabelSisi1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi1.setBounds(70, 100, 150, 25);
        add(jLabelSisi1);

        jTextFieldSisi1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi1.setBounds(230, 100, 200, 25);
        add(jTextFieldSisi1);

        JLabel jLabelSisi2 = new JLabel("Sisi Sejajar 2 :");
        jLabelSisi2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi2.setBounds(70, 140, 150, 25);
        add(jLabelSisi2);

        jTextFieldSisi2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi2.setBounds(230, 140, 200, 25);
        add(jTextFieldSisi2);

        JLabel jLabelTinggi = new JLabel("Tinggi :");
        jLabelTinggi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggi.setBounds(70, 180, 150, 25);
        add(jLabelTinggi);

        jTextFieldTinggi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggi.setBounds(230, 180, 200, 25);
        add(jTextFieldTinggi);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 350, 500, 10);
        add(jSeparator2);

        JButton jButtonsSave = new JButton("Hitung");
        jButtonsSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonsSave.setBounds(55, 370, 100, 30);
        add(jButtonsSave);

        JButton jButtonReset = new JButton("Reset");
        jButtonReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonReset.setBounds(195, 370, 100, 30);
        add(jButtonReset);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(335, 370, 100, 30);
        add(jButtonClose);

        cek();

        jButtonsSave.addActionListener(e -> {
            try {
                double sisi1 = Double.parseDouble(jTextFieldSisi1.getText());
                double sisi2 = Double.parseDouble(jTextFieldSisi2.getText());
                double tinggi = Double.parseDouble(jTextFieldTinggi.getText());
                if (sisi1 <= 0 || sisi2 <= 0 || tinggi <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                Trapesium newTrapesium = new Trapesium(sisi1, sisi2, tinggi); //

                Thread calcThread = new Thread(newTrapesium);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilTrapesiumView(newTrapesium).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldSisi1.setText("");
            jTextFieldSisi2.setText("");
            jTextFieldTinggi.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (trapesium != null) {
            jTextFieldSisi1.setText(String.valueOf(trapesium.sisiSejajar1)); //
            jTextFieldSisi2.setText(String.valueOf(trapesium.sisiSejajar2)); //
            jTextFieldTinggi.setText(String.valueOf(trapesium.tinggi)); //
        }
    }
}