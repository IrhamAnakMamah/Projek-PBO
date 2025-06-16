package View.ViewBangun3D.PrismaSegitiga;

import Benda3D.PrismaSegitiga;
import javax.swing.*;
import java.awt.*;

public class PrismaSegitigaView extends JFrame {

    PrismaSegitiga prisma;
    JTextField jTextFieldAlas = new JTextField();
    JTextField jTextFieldTinggiAlas = new JTextField();
    JTextField jTextFieldTinggiPrisma = new JTextField();

    public PrismaSegitigaView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Segitiga");
    }

    public PrismaSegitigaView(PrismaSegitiga prisma) {
        this.prisma = prisma;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Segitiga");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PRISMA SEGITIGA");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(100, 20, 300, 37);
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

        JLabel jLabelTinggiPrisma = new JLabel("Tinggi Prisma :");
        jLabelTinggiPrisma.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiPrisma.setBounds(70, 180, 150, 25);
        add(jLabelTinggiPrisma);
        jTextFieldTinggiPrisma.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiPrisma.setBounds(230, 180, 200, 25);
        add(jTextFieldTinggiPrisma);

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
                double a = Double.parseDouble(jTextFieldAlas.getText());
                double ta = Double.parseDouble(jTextFieldTinggiAlas.getText());
                double tp = Double.parseDouble(jTextFieldTinggiPrisma.getText());
                if (a <= 0 || ta <= 0 || tp <=0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                PrismaSegitiga newPrisma = new PrismaSegitiga(a,ta,tp); //

                new HasilPrismaSegitigaView(newPrisma).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldAlas.setText("");
            jTextFieldTinggiAlas.setText("");
            jTextFieldTinggiPrisma.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (prisma != null) {
            // properties are private
        }
    }
}