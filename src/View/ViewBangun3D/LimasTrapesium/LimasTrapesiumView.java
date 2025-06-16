package View.ViewBangun3D.LimasTrapesium;

import Benda3D.LimasTrapesium;
import javax.swing.*;
import java.awt.*;

public class LimasTrapesiumView extends JFrame {

    LimasTrapesium limas;
    JTextField jTextFieldSisi1 = new JTextField();
    JTextField jTextFieldSisi2 = new JTextField();
    JTextField jTextFieldTinggiAlas = new JTextField();
    JTextField jTextFieldTinggiLimas = new JTextField();
    JTextField jTextFieldTinggiSisi1 = new JTextField();
    JTextField jTextFieldTinggiSisi2 = new JTextField();

    public LimasTrapesiumView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Trapesium");
    }

    public LimasTrapesiumView(LimasTrapesium limas) {
        this.limas = limas;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Trapesium");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 600);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("LIMAS TRAPESIUM");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(100, 20, 300, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelSisi1 = new JLabel("Sisi Sejajar 1 Alas:");
        jLabelSisi1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi1.setBounds(70, 100, 150, 25);
        add(jLabelSisi1);
        jTextFieldSisi1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi1.setBounds(230, 100, 200, 25);
        add(jTextFieldSisi1);

        JLabel jLabelSisi2 = new JLabel("Sisi Sejajar 2 Alas :");
        jLabelSisi2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi2.setBounds(70, 140, 150, 25);
        add(jLabelSisi2);
        jTextFieldSisi2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi2.setBounds(230, 140, 200, 25);
        add(jTextFieldSisi2);

        JLabel jLabelTinggiAlas = new JLabel("Tinggi Alas :");
        jLabelTinggiAlas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiAlas.setBounds(70, 180, 150, 25);
        add(jLabelTinggiAlas);
        jTextFieldTinggiAlas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiAlas.setBounds(230, 180, 200, 25);
        add(jTextFieldTinggiAlas);

        JLabel jLabelTinggiLimas = new JLabel("Tinggi Limas :");
        jLabelTinggiLimas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiLimas.setBounds(70, 220, 150, 25);
        add(jLabelTinggiLimas);
        jTextFieldTinggiLimas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiLimas.setBounds(230, 220, 200, 25);
        add(jTextFieldTinggiLimas);

        JLabel jLabelTinggiSisi1 = new JLabel("Tinggi Sisi Tegak 1 :");
        jLabelTinggiSisi1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiSisi1.setBounds(70, 260, 150, 25);
        add(jLabelTinggiSisi1);
        jTextFieldTinggiSisi1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiSisi1.setBounds(230, 260, 200, 25);
        add(jTextFieldTinggiSisi1);

        JLabel jLabelTinggiSisi2 = new JLabel("Tinggi Sisi Tegak 2 :");
        jLabelTinggiSisi2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiSisi2.setBounds(70, 300, 150, 25);
        add(jLabelTinggiSisi2);
        jTextFieldTinggiSisi2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiSisi2.setBounds(230, 300, 200, 25);
        add(jTextFieldTinggiSisi2);

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
                double s1 = Double.parseDouble(jTextFieldSisi1.getText());
                double s2 = Double.parseDouble(jTextFieldSisi2.getText());
                double ta = Double.parseDouble(jTextFieldTinggiAlas.getText());
                double tl = Double.parseDouble(jTextFieldTinggiLimas.getText());
                double ts1 = Double.parseDouble(jTextFieldTinggiSisi1.getText());
                double ts2 = Double.parseDouble(jTextFieldTinggiSisi2.getText());

                LimasTrapesium newLimas = new LimasTrapesium(s1, s2, ta, tl, ts1, ts2); //

                Thread calcThread = new Thread(newLimas);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilLimasTrapesiumView(newLimas).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldSisi1.setText("");
            jTextFieldSisi2.setText("");
            jTextFieldTinggiAlas.setText("");
            jTextFieldTinggiLimas.setText("");
            jTextFieldTinggiSisi1.setText("");
            jTextFieldTinggiSisi2.setText("");
            // reset all fields
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (limas != null) {
            jTextFieldSisi1.setText(Double.toString(limas.sisiSejajar1));
            jTextFieldSisi2.setText(Double.toString(limas.sisiSejajar2));
            jTextFieldTinggiAlas.setText(Double.toString(limas.tinggi));
            jTextFieldTinggiLimas.setText(Double.toString(limas.getTinggiLimas()));
            jTextFieldTinggiSisi1.setText(Double.toString(limas.getTinggiSisiTegak1()));
            jTextFieldTinggiSisi2.setText(Double.toString(limas.getTinggiSisiTegak2()));
        }
    }
}