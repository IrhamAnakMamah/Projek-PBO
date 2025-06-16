package View.ViewBangun3D.PrismaJajarGenjang;

import Benda3D.PrismaJajarGenjang;
import javax.swing.*;
import java.awt.*;

public class PrismaJajarGenjangView extends JFrame {

    PrismaJajarGenjang prisma;
    JTextField jTextFieldAlas = new JTextField();
    JTextField jTextFieldTinggiAlas = new JTextField();
    JTextField jTextFieldSudut = new JTextField();
    JTextField jTextFieldTinggiPrisma = new JTextField();
    JTextField jTextFieldSisi = new JTextField();

    public PrismaJajarGenjangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Jajar Genjang");
    }

    public PrismaJajarGenjangView(PrismaJajarGenjang prisma) {
        this.prisma = prisma;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Jajar Genjang");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 550);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PRISMA JAJAR GENJANG");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(50, 20, 400, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelAlas = new JLabel("Alas Jajar Genjang:");
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

        JLabel jLabelSudut = new JLabel("Sudut Lancip Alas :");
        jLabelSudut.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSudut.setBounds(70, 180, 150, 25);
        add(jLabelSudut);
        jTextFieldSudut.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSudut.setBounds(230, 180, 200, 25);
        add(jTextFieldSudut);

        JLabel jLabelTinggiPrisma = new JLabel("Tinggi Prisma :");
        jLabelTinggiPrisma.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiPrisma.setBounds(70, 220, 150, 25);
        add(jLabelTinggiPrisma);
        jTextFieldTinggiPrisma.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiPrisma.setBounds(230, 220, 200, 25);
        add(jTextFieldTinggiPrisma);

        JLabel jLabelSisi = new JLabel("Sisi Prisma :");
        jLabelSisi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi.setBounds(70, 260, 150, 25);
        add(jLabelSisi);
        jTextFieldSisi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi.setBounds(230, 260, 200, 25);
        add(jTextFieldSisi);

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
                double a = Double.parseDouble(jTextFieldAlas.getText());
                double ta = Double.parseDouble(jTextFieldTinggiAlas.getText());
                double s = Double.parseDouble(jTextFieldSudut.getText());
                double tp = Double.parseDouble(jTextFieldTinggiPrisma.getText());
                double sisi = Double.parseDouble(jTextFieldSisi.getText());

                PrismaJajarGenjang newPrisma = new PrismaJajarGenjang(a, ta, s, tp, sisi); //

                new HasilPrismaJajarGenjangView(newPrisma).setVisible(true);
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
            // properties private
        }
    }
}