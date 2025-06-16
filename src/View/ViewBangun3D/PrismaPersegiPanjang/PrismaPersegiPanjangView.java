package View.ViewBangun3D.PrismaPersegiPanjang;

import Benda3D.PrismaPersegiPanjang;
import javax.swing.*;
import java.awt.*;

public class PrismaPersegiPanjangView extends JFrame {

    PrismaPersegiPanjang balok;
    JTextField jTextFieldPanjang = new JTextField();
    JTextField jTextFieldLebar = new JTextField();
    JTextField jTextFieldTinggi = new JTextField();

    public PrismaPersegiPanjangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Balok");
    }

    public PrismaPersegiPanjangView(PrismaPersegiPanjang balok) {
        this.balok = balok;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Balok");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("BALOK");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(190, 20, 300, 37);
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
                double p = Double.parseDouble(jTextFieldPanjang.getText());
                double l = Double.parseDouble(jTextFieldLebar.getText());
                double t = Double.parseDouble(jTextFieldTinggi.getText());
                if (p <= 0 || l <= 0 || t <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                PrismaPersegiPanjang newBalok = new PrismaPersegiPanjang(p, l, t); //

                Thread calcThread = new Thread(newBalok);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilPrismaPersegiPanjangView(newBalok).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldPanjang.setText("");
            jTextFieldLebar.setText("");
            jTextFieldTinggi.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (balok != null) {
            jTextFieldPanjang.setText(String.valueOf(balok.panjang));
            jTextFieldLebar.setText(String.valueOf(balok.lebar));
            // tinggiBalok is private
        }
    }
}