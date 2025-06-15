package View.ViewBangun2D.PersegiPanjang;

import Benda2D.PersegiPanjang;
import javax.swing.*;
import java.awt.*;

public class PersegiPanjangView extends JFrame {

    PersegiPanjang persegiPanjang;
    JTextField jTextFieldPanjang = new JTextField();
    JTextField jTextFieldLebar = new JTextField();

    public PersegiPanjangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Persegi Panjang");
    }

    public PersegiPanjangView(PersegiPanjang persegiPanjang) {
        this.persegiPanjang = persegiPanjang;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Persegi Panjang");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PERSEGI PANJANG");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(90, 20, 320, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelPanjang = new JLabel("Panjang :");
        jLabelPanjang.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelPanjang.setBounds(70, 100, 150, 25);
        add(jLabelPanjang);

        jTextFieldPanjang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldPanjang.setBounds(230, 100, 200, 25);
        add(jTextFieldPanjang);

        JLabel jLabelLebar = new JLabel("Lebar :");
        jLabelLebar.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelLebar.setBounds(70, 140, 150, 25);
        add(jLabelLebar);

        jTextFieldLebar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldLebar.setBounds(230, 140, 200, 25);
        add(jTextFieldLebar);

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
                double panjang = Double.parseDouble(jTextFieldPanjang.getText());
                double lebar = Double.parseDouble(jTextFieldLebar.getText());
                if (panjang <= 0 || lebar <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                PersegiPanjang newPp = new PersegiPanjang(panjang, lebar);

                Thread calcThread = new Thread(newPp);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilPersegiPanjangView(newPp).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldPanjang.setText("");
            jTextFieldLebar.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (persegiPanjang != null) {
            jTextFieldPanjang.setText(String.valueOf(persegiPanjang.panjang));
            jTextFieldLebar.setText(String.valueOf(persegiPanjang.lebar));
        }
    }
}