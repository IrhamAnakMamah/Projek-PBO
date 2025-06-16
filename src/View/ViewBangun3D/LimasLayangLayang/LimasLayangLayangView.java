package View.ViewBangun3D.LimasLayangLayang;

import Benda3D.LimasLayangLayang;
import javax.swing.*;
import java.awt.*;

public class LimasLayangLayangView extends JFrame {

    LimasLayangLayang limas;
    JTextField jTextFieldD1 = new JTextField();
    JTextField jTextFieldD2 = new JTextField();
    JTextField jTextFieldSisi1 = new JTextField();
    JTextField jTextFieldSisi2 = new JTextField();
    JTextField jTextFieldTinggiLimas = new JTextField();
    JTextField jTextFieldTinggiSisi1 = new JTextField();
    JTextField jTextFieldTinggiSisi2 = new JTextField();

    public LimasLayangLayangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Layang-Layang");
    }

    public LimasLayangLayangView(LimasLayangLayang limas) {
        this.limas = limas;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Layang-Layang");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 650);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("LIMAS LAYANG-LAYANG");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(50, 20, 400, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelD1 = new JLabel("Diagonal 1 Alas:");
        jLabelD1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelD1.setBounds(70, 100, 150, 25);
        add(jLabelD1);
        jTextFieldD1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldD1.setBounds(230, 100, 200, 25);
        add(jTextFieldD1);

        JLabel jLabelD2 = new JLabel("Diagonal 2 Alas :");
        jLabelD2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelD2.setBounds(70, 140, 150, 25);
        add(jLabelD2);
        jTextFieldD2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldD2.setBounds(230, 140, 200, 25);
        add(jTextFieldD2);

        JLabel jLabelSisi1 = new JLabel("Sisi A Alas :");
        jLabelSisi1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi1.setBounds(70, 180, 150, 25);
        add(jLabelSisi1);
        jTextFieldSisi1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi1.setBounds(230, 180, 200, 25);
        add(jTextFieldSisi1);

        JLabel jLabelSisi2 = new JLabel("Sisi B Alas :");
        jLabelSisi2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi2.setBounds(70, 220, 150, 25);
        add(jLabelSisi2);
        jTextFieldSisi2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi2.setBounds(230, 220, 200, 25);
        add(jTextFieldSisi2);

        JLabel jLabelTinggiLimas = new JLabel("Tinggi Limas :");
        jLabelTinggiLimas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiLimas.setBounds(70, 260, 150, 25);
        add(jLabelTinggiLimas);
        jTextFieldTinggiLimas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiLimas.setBounds(230, 260, 200, 25);
        add(jTextFieldTinggiLimas);

        JLabel jLabelTinggiSisi1 = new JLabel("Tinggi Sisi Tegak 1 :");
        jLabelTinggiSisi1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiSisi1.setBounds(70, 300, 150, 25);
        add(jLabelTinggiSisi1);
        jTextFieldTinggiSisi1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiSisi1.setBounds(230, 300, 200, 25);
        add(jTextFieldTinggiSisi1);

        JLabel jLabelTinggiSisi2 = new JLabel("Tinggi Sisi Tegak 2 :");
        jLabelTinggiSisi2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiSisi2.setBounds(70, 340, 150, 25);
        add(jLabelTinggiSisi2);
        jTextFieldTinggiSisi2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiSisi2.setBounds(230, 340, 200, 25);
        add(jTextFieldTinggiSisi2);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 550, 500, 10);
        add(jSeparator2);

        JButton jButtonsSave = new JButton("Hitung");
        jButtonsSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonsSave.setBounds(55, 570, 100, 30);
        add(jButtonsSave);

        JButton jButtonReset = new JButton("Reset");
        jButtonReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonReset.setBounds(195, 570, 100, 30);
        add(jButtonReset);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(335, 570, 100, 30);
        add(jButtonClose);

        cek();

        jButtonsSave.addActionListener(e -> {
            try {
                double d1 = Double.parseDouble(jTextFieldD1.getText());
                double d2 = Double.parseDouble(jTextFieldD2.getText());
                double s1 = Double.parseDouble(jTextFieldSisi1.getText());
                double s2 = Double.parseDouble(jTextFieldSisi2.getText());
                double tl = Double.parseDouble(jTextFieldTinggiLimas.getText());
                double ts1 = Double.parseDouble(jTextFieldTinggiSisi1.getText());
                double ts2 = Double.parseDouble(jTextFieldTinggiSisi2.getText());

                LimasLayangLayang newLimas = new LimasLayangLayang(d1, d2, s1, s2, tl, ts1, ts2);

                new HasilLimasLayangLayangView(newLimas).setVisible(true);
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
        if (limas != null) {
            // public properties from parent
            jTextFieldD1.setText(String.valueOf(limas.diagonal1));
            jTextFieldD2.setText(String.valueOf(limas.diagonal2));
            jTextFieldSisi1.setText(String.valueOf(limas.sisi1));
            jTextFieldSisi2.setText(String.valueOf(limas.sisi2));
            jTextFieldTinggiLimas.setText(String.valueOf(limas.getTinggiLimas()));
            jTextFieldTinggiSisi1.setText(String.valueOf(limas.getTinggiSisiTegak1()));
            jTextFieldTinggiSisi2.setText(String.valueOf(limas.getTinggiSisiTegak2()));
        }
    }
}