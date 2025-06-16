package View.ViewBangun3D.PrismaPersegi;

import Benda3D.PrismaPersegi;
import javax.swing.*;
import java.awt.*;

public class PrismaPersegiView extends JFrame {

    PrismaPersegi prismaPersegi;
    JTextField jTextFieldSisi = new JTextField();
    JTextField jTextFieldTinggi = new JTextField();

    public PrismaPersegiView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Persegi");
    }

    public PrismaPersegiView(PrismaPersegi prismaPersegi) {
        this.prismaPersegi = prismaPersegi;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Persegi");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PRISMA PERSEGI");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(100, 20, 300, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelSisi = new JLabel("Sisi Alas:");
        jLabelSisi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi.setBounds(70, 100, 150, 25);
        add(jLabelSisi);
        jTextFieldSisi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi.setBounds(230, 100, 200, 25);
        add(jTextFieldSisi);

        JLabel jLabelTinggi = new JLabel("Tinggi Prisma :");
        jLabelTinggi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggi.setBounds(70, 140, 150, 25);
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
                double sisi = Double.parseDouble(jTextFieldSisi.getText());
                double tinggi = Double.parseDouble(jTextFieldTinggi.getText());
                if (sisi <= 0 || tinggi <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                PrismaPersegi newPrisma = new PrismaPersegi(sisi, tinggi); //

                Thread calcThread = new Thread(newPrisma);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilPrismaPersegiView(newPrisma).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldSisi.setText("");
            jTextFieldTinggi.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (prismaPersegi != null) {
            jTextFieldSisi.setText(String.valueOf(prismaPersegi.sisi));
            // tinggiPrisma is private
        }
    }
}