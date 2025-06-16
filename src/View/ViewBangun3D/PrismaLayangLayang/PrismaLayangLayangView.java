package View.ViewBangun3D.PrismaLayangLayang;

import Benda3D.PrismaLayangLayang;
import javax.swing.*;
import java.awt.*;

public class PrismaLayangLayangView extends JFrame {

    PrismaLayangLayang prisma;
    JTextField jTextFieldD1 = new JTextField();
    JTextField jTextFieldD2 = new JTextField();
    JTextField jTextFieldSisi1 = new JTextField();
    JTextField jTextFieldSisi2 = new JTextField();
    JTextField jTextFieldTinggiPrisma = new JTextField();

    public PrismaLayangLayangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Layang-Layang");
    }

    public PrismaLayangLayangView(PrismaLayangLayang prisma) {
        this.prisma = prisma;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Layang-Layang");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 550);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PRISMA LAYANG-LAYANG");
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

        JLabel jLabelTinggiPrisma = new JLabel("Tinggi Prisma :");
        jLabelTinggiPrisma.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiPrisma.setBounds(70, 260, 150, 25);
        add(jLabelTinggiPrisma);
        jTextFieldTinggiPrisma.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiPrisma.setBounds(230, 260, 200, 25);
        add(jTextFieldTinggiPrisma);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 450, 500, 10);
        add(jSeparator2);

        JButton jButtonsSave = new JButton("Hitung");
        jButtonsSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonsSave.setBounds(55, 470, 100, 30);
        add(jButtonsSave);

        JButton jButtonReset = new JButton("Reset");
        jButtonReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonReset.setBounds(195, 470, 100, 30);
        add(jButtonReset);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(335, 470, 100, 30);
        add(jButtonClose);

        cek();

        jButtonsSave.addActionListener(e -> {
            try {
                double d1 = Double.parseDouble(jTextFieldD1.getText());
                double d2 = Double.parseDouble(jTextFieldD2.getText());
                double s1 = Double.parseDouble(jTextFieldSisi1.getText());
                double s2 = Double.parseDouble(jTextFieldSisi2.getText());
                double tp = Double.parseDouble(jTextFieldTinggiPrisma.getText());

                PrismaLayangLayang newPrisma = new PrismaLayangLayang(d1, d2, s1, s2, tp); //

                new HasilPrismaLayangLayangView(newPrisma).setVisible(true);
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
        if (prisma != null) {
            // properties public in parent class LayangLayang
            jTextFieldD1.setText(String.valueOf(prisma.diagonal1));
            jTextFieldD2.setText(String.valueOf(prisma.diagonal2));
            jTextFieldSisi1.setText(String.valueOf(prisma.sisi1));
            jTextFieldSisi2.setText(String.valueOf(prisma.sisi2));
        }
    }
}