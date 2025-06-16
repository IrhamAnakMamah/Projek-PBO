package View.ViewBangun3D.LimasSegitiga;

import Benda3D.LimasSegitiga;
import javax.swing.*;
import java.awt.*;

public class LimasSegitigaView extends JFrame {

    LimasSegitiga limasSegitiga;
    JTextField jTextFieldAlas = new JTextField();
    JTextField jTextFieldTinggiAlas = new JTextField();
    JTextField jTextFieldTinggiLimas = new JTextField();
    JTextField jTextFieldSisi1 = new JTextField();
    JTextField jTextFieldSisi2 = new JTextField();
    JTextField jTextFieldSisi3 = new JTextField();


    public LimasSegitigaView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Segitiga");
    }

    public LimasSegitigaView(LimasSegitiga limasSegitiga) {
        this.limasSegitiga = limasSegitiga;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Segitiga");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 600);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("LIMAS SEGITIGA");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(110, 20, 300, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelAlas = new JLabel("Alas Segitiga:");
        jLabelAlas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelAlas.setBounds(70, 100, 150, 25);
        add(jLabelAlas);
        jTextFieldAlas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldAlas.setBounds(230, 100, 200, 25);
        add(jTextFieldAlas);

        JLabel jLabelTinggiAlas = new JLabel("Tinggi Alas :");
        jLabelTinggiAlas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiAlas.setBounds(70, 140, 150, 25);
        add(jLabelTinggiAlas);
        jTextFieldTinggiAlas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiAlas.setBounds(230, 140, 200, 25);
        add(jTextFieldTinggiAlas);

        JLabel jLabelTinggiLimas = new JLabel("Tinggi Limas :");
        jLabelTinggiLimas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiLimas.setBounds(70, 180, 150, 25);
        add(jLabelTinggiLimas);
        jTextFieldTinggiLimas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiLimas.setBounds(230, 180, 200, 25);
        add(jTextFieldTinggiLimas);

        // sisi1, sisi2, sisi3 untuk luas permukaan
        JLabel jLabelSisi1 = new JLabel("Sisi Alas 1 :");
        jLabelSisi1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi1.setBounds(70, 220, 150, 25);
        add(jLabelSisi1);
        jTextFieldSisi1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi1.setBounds(230, 220, 200, 25);
        add(jTextFieldSisi1);

        JLabel jLabelSisi2 = new JLabel("Sisi Alas 2 :");
        jLabelSisi2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi2.setBounds(70, 260, 150, 25);
        add(jLabelSisi2);
        jTextFieldSisi2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi2.setBounds(230, 260, 200, 25);
        add(jTextFieldSisi2);

        JLabel jLabelSisi3 = new JLabel("Sisi Alas 3 :");
        jLabelSisi3.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi3.setBounds(70, 300, 150, 25);
        add(jLabelSisi3);
        jTextFieldSisi3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi3.setBounds(230, 300, 200, 25);
        add(jTextFieldSisi3);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 500, 500, 10);
        add(jSeparator2);

        JButton jButtonsSave = new JButton("Hitung");
        jButtonsSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonsSave.setBounds(55, 520, 100, 30);
        add(jButtonsSave);

        JButton jButtonReset = new JButton("Reset");
        jButtonReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonReset.setBounds(195, 520, 100, 30);
        add(jButtonReset);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(335, 520, 100, 30);
        add(jButtonClose);

        cek();

        jButtonsSave.addActionListener(e -> {
            try {
                double alas = Double.parseDouble(jTextFieldAlas.getText());
                double tinggiAlas = Double.parseDouble(jTextFieldTinggiAlas.getText());
                double tinggiLimas = Double.parseDouble(jTextFieldTinggiLimas.getText());
                double s1 = Double.parseDouble(jTextFieldSisi1.getText());
                double s2 = Double.parseDouble(jTextFieldSisi2.getText());
                double s3 = Double.parseDouble(jTextFieldSisi3.getText());

                if (alas <= 0 || tinggiAlas <= 0 || tinggiLimas <=0 || s1 <=0 || s2 <=0 || s3 <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                LimasSegitiga newLimas = new LimasSegitiga(alas, tinggiAlas, tinggiLimas, s1, s2, s3); //

                // LimasSegitiga tidak implement Runnable, jadi tidak perlu thread
                new HasilLimasSegitigaView(newLimas).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            // reset all fields
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (limasSegitiga != null) {
            jTextFieldAlas.setText(String.valueOf(limasSegitiga.sisi));
            jTextFieldSisi1.setText(String.valueOf(limasSegitiga.getSisi1()));
            jTextFieldSisi2.setText(String.valueOf(limasSegitiga.getSisi2()));
            jTextFieldSisi3.setText(String.valueOf(limasSegitiga.getSisi3()));
            jTextFieldTinggiAlas.setText(String.valueOf(limasSegitiga.tinggi));
            jTextFieldTinggiLimas.setText(String.valueOf(limasSegitiga.getTinggiLimasSegitiga()));
        }
    }
}