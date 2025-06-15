package View.ViewBangun2D.LayangLayang;

import Benda2D.LayangLayang;
import javax.swing.*;
import java.awt.*;

public class LayangLayangView extends JFrame {

    LayangLayang layangLayang;
    JTextField jTextFieldD1 = new JTextField();
    JTextField jTextFieldD2 = new JTextField();
    JTextField jTextFieldSisi1 = new JTextField();
    JTextField jTextFieldSisi2 = new JTextField();

    public LayangLayangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Layang-Layang");
    }

    public LayangLayangView(LayangLayang layangLayang) {
        this.layangLayang = layangLayang;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Layang-Layang");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("LAYANG-LAYANG");
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

        JLabel jLabelSisi1 = new JLabel("Sisi A (pendek) :");
        jLabelSisi1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi1.setBounds(70, 180, 150, 25);
        add(jLabelSisi1);
        jTextFieldSisi1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi1.setBounds(230, 180, 200, 25);
        add(jTextFieldSisi1);

        JLabel jLabelSisi2 = new JLabel("Sisi B (panjang) :");
        jLabelSisi2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi2.setBounds(70, 220, 150, 25);
        add(jLabelSisi2);
        jTextFieldSisi2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi2.setBounds(230, 220, 200, 25);
        add(jTextFieldSisi2);

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
                double s1 = Double.parseDouble(jTextFieldSisi1.getText());
                double s2 = Double.parseDouble(jTextFieldSisi2.getText());
                if (d1 <= 0 || d2 <= 0 || s1 <= 0 || s2 <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                LayangLayang newLl = new LayangLayang(d1, d2, s1, s2); //

                Thread calcThread = new Thread(newLl);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilLayangLayangView(newLl).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldD1.setText("");
            jTextFieldD2.setText("");
            jTextFieldSisi1.setText("");
            jTextFieldSisi2.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (layangLayang != null) {
            jTextFieldD1.setText(String.valueOf(layangLayang.diagonal1)); //
            jTextFieldD2.setText(String.valueOf(layangLayang.diagonal2)); //
            jTextFieldSisi1.setText(String.valueOf(layangLayang.sisi1)); //
            jTextFieldSisi2.setText(String.valueOf(layangLayang.sisi2)); //
        }
    }
}