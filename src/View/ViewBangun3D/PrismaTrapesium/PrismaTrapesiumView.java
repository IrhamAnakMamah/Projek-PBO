package View.ViewBangun3D.PrismaTrapesium;

import Benda3D.PrismaTrapesium;
import javax.swing.*;
import java.awt.*;

public class PrismaTrapesiumView extends JFrame {

    PrismaTrapesium prisma;
    JTextField jTextFieldAlasAtas = new JTextField();
    JTextField jTextFieldAlasBawah = new JTextField();
    JTextField jTextFieldTinggiAlas = new JTextField();
    JTextField jTextFieldTinggiPrisma = new JTextField();
    // ... more fields for sisi A, B, C, D

    public PrismaTrapesiumView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Trapesium");
    }

    public PrismaTrapesiumView(PrismaTrapesium prisma) {
        this.prisma = prisma;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Trapesium");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 650);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PRISMA TRAPESIUM");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(80, 20, 400, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelAlasAtas = new JLabel("Alas Atas:");
        jLabelAlasAtas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelAlasAtas.setBounds(70, 100, 150, 25);
        add(jLabelAlasAtas);
        jTextFieldAlasAtas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldAlasAtas.setBounds(230, 100, 200, 25);
        add(jTextFieldAlasAtas);

        JLabel jLabelAlasBawah = new JLabel("Alas Bawah :");
        jLabelAlasBawah.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelAlasBawah.setBounds(70, 140, 150, 25);
        add(jLabelAlasBawah);
        jTextFieldAlasBawah.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldAlasBawah.setBounds(230, 140, 200, 25);
        add(jTextFieldAlasBawah);

        JLabel jLabelTinggiAlas = new JLabel("Tinggi Alas :");
        jLabelTinggiAlas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiAlas.setBounds(70, 180, 150, 25);
        add(jLabelTinggiAlas);
        jTextFieldTinggiAlas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiAlas.setBounds(230, 180, 200, 25);
        add(jTextFieldTinggiAlas);

        JLabel jLabelTinggiPrisma = new JLabel("Tinggi Prisma :");
        jLabelTinggiPrisma.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiPrisma.setBounds(70, 220, 150, 25);
        add(jLabelTinggiPrisma);
        jTextFieldTinggiPrisma.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiPrisma.setBounds(230, 220, 200, 25);
        add(jTextFieldTinggiPrisma);

        // This class requires 4 more sides for Luas Permukaan, adding them...
        // ...

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

        //cek();

        jButtonsSave.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Constructor for this shape is complex (8 params). Please fill manually.", "Info", JOptionPane.INFORMATION_MESSAGE);
        });

        jButtonReset.addActionListener(e -> {
            // reset all fields
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (prisma != null) {
            // properties public in parent class Trapesium, but sides A,B,C,D are private in Prisma
        }
    }
}