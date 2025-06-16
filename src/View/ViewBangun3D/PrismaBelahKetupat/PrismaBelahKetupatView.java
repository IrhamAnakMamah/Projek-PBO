package View.ViewBangun3D.PrismaBelahKetupat;

import Benda3D.PrismaBelahKetupat;
import javax.swing.*;
import java.awt.*;

public class PrismaBelahKetupatView extends JFrame {

    PrismaBelahKetupat prisma;
    JTextField jTextFieldD1 = new JTextField();
    JTextField jTextFieldD2 = new JTextField();
    JTextField jTextFieldTinggiPrisma = new JTextField();
    JTextField jTextFieldSisi = new JTextField();

    public PrismaBelahKetupatView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Belah Ketupat");
    }

    public PrismaBelahKetupatView(PrismaBelahKetupat prisma) {
        this.prisma = prisma;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Belah Ketupat");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PRISMA BELAH KETUPAT");
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

        JLabel jLabelTinggiPrisma = new JLabel("Tinggi Prisma :");
        jLabelTinggiPrisma.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiPrisma.setBounds(70, 180, 150, 25);
        add(jLabelTinggiPrisma);
        jTextFieldTinggiPrisma.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiPrisma.setBounds(230, 180, 200, 25);
        add(jTextFieldTinggiPrisma);

        JLabel jLabelSisi = new JLabel("Sisi Alas :");
        jLabelSisi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi.setBounds(70, 220, 150, 25);
        add(jLabelSisi);
        jTextFieldSisi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi.setBounds(230, 220, 200, 25);
        add(jTextFieldSisi);

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
                double tp = Double.parseDouble(jTextFieldTinggiPrisma.getText());
                double sisi = Double.parseDouble(jTextFieldSisi.getText());

                PrismaBelahKetupat newPrisma = new PrismaBelahKetupat(d1, d2, tp, sisi); //

                new HasilPrismaBelahKetupatView(newPrisma).setVisible(true);
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