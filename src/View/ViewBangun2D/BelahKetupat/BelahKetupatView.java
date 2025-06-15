package View.ViewBangun2D.BelahKetupat;

import Benda2D.BelahKetupat;
import javax.swing.*;
import java.awt.*;

public class BelahKetupatView extends JFrame {

    BelahKetupat belahKetupat;
    JTextField jTextFieldD1 = new JTextField();
    JTextField jTextFieldD2 = new JTextField();

    public BelahKetupatView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Belah Ketupat");
    }

    public BelahKetupatView(BelahKetupat belahKetupat) {
        this.belahKetupat = belahKetupat;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Belah Ketupat");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("BELAH KETUPAT");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(110, 20, 300, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelD1 = new JLabel("Diagonal 1 :");
        jLabelD1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelD1.setBounds(70, 100, 150, 25);
        add(jLabelD1);

        jTextFieldD1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldD1.setBounds(230, 100, 200, 25);
        add(jTextFieldD1);

        JLabel jLabelD2 = new JLabel("Diagonal 2 :");
        jLabelD2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelD2.setBounds(70, 140, 150, 25);
        add(jLabelD2);

        jTextFieldD2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldD2.setBounds(230, 140, 200, 25);
        add(jTextFieldD2);

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
                double d1 = Double.parseDouble(jTextFieldD1.getText());
                double d2 = Double.parseDouble(jTextFieldD2.getText());
                if (d1 <= 0 || d2 <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                BelahKetupat newBk = new BelahKetupat(d1, d2);

                Thread calcThread = new Thread(newBk);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilBelahKetupatView(newBk).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldD1.setText("");
            jTextFieldD2.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (belahKetupat != null) {
            jTextFieldD1.setText(String.valueOf(belahKetupat.diagonal1));
            jTextFieldD2.setText(String.valueOf(belahKetupat.diagonal2));
        }
    }
}