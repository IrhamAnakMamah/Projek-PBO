package View.ViewBangun3D.LimasBelahKetupat;

import Benda3D.LimasBelahKetupat;
import javax.swing.*;
import java.awt.*;

public class LimasBelahKetupatView extends JFrame {

    LimasBelahKetupat limas;
    JTextField jTextFieldD1 = new JTextField();
    JTextField jTextFieldD2 = new JTextField();
    JTextField jTextFieldTinggiLimas = new JTextField();
    JTextField jTextFieldTinggiSisi = new JTextField();

    public LimasBelahKetupatView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Belah Ketupat");
    }

    public LimasBelahKetupatView(LimasBelahKetupat limas) {
        this.limas = limas;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Belah Ketupat");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("LIMAS BELAH KETUPAT");
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

        JLabel jLabelTinggiLimas = new JLabel("Tinggi Limas :");
        jLabelTinggiLimas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiLimas.setBounds(70, 180, 150, 25);
        add(jLabelTinggiLimas);
        jTextFieldTinggiLimas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiLimas.setBounds(230, 180, 200, 25);
        add(jTextFieldTinggiLimas);

        JLabel jLabelTinggiSisi = new JLabel("Tinggi Sisi Tegak :");
        jLabelTinggiSisi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiSisi.setBounds(70, 220, 150, 25);
        add(jLabelTinggiSisi);
        jTextFieldTinggiSisi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiSisi.setBounds(230, 220, 200, 25);
        add(jTextFieldTinggiSisi);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 400, 500, 10);
        add(jSeparator2);

        JButton jButtonsSave = new JButton("Hitung");
        jButtonsSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonsSave.setBounds(55, 420, 100, 30);
        add(jButtonsSave);

        JButton jButtonReset = new JButton("Reset");
        jButtonReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonReset.setBounds(195, 420, 100, 30);
        add(jButtonReset);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(335, 420, 100, 30);
        add(jButtonClose);

        cek();

        jButtonsSave.addActionListener(e -> {
            try {
                double d1 = Double.parseDouble(jTextFieldD1.getText());
                double d2 = Double.parseDouble(jTextFieldD2.getText());
                double tinggiLimas = Double.parseDouble(jTextFieldTinggiLimas.getText());
                double tinggiSisi = Double.parseDouble(jTextFieldTinggiSisi.getText());

                if (d1 <= 0 || d2 <= 0 || tinggiLimas <=0 || tinggiSisi <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                LimasBelahKetupat newLimas = new LimasBelahKetupat(d1, d2, tinggiLimas, tinggiSisi); //

                // This class does not implement runnable, direct call
                new HasilLimasBelahKetupatView(newLimas).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldD1.setText("");
            jTextFieldD2.setText("");
            jTextFieldTinggiLimas.setText("");
            jTextFieldTinggiSisi.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (limas != null) {
            // All properties are private without getters
        }
    }
}