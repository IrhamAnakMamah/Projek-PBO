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
    JTextField jTextFieldSisiA = new JTextField(); // Tambah field untuk sisi A
    JTextField jTextFieldSisiB = new JTextField(); // Tambah field untuk sisi B
    JTextField jTextFieldSisiC = new JTextField(); // Tambah field untuk sisi C
    JTextField jTextFieldSisiD = new JTextField(); // Tambah field untuk sisi D


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
        setSize(500, 650); // Sesuaikan ukuran frame agar semua input terlihat
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PRISMA TRAPESIUM");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(80, 20, 400, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelAlasAtas = new JLabel("Alas Atas (a):");
        jLabelAlasAtas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelAlasAtas.setBounds(70, 100, 150, 25);
        add(jLabelAlasAtas);
        jTextFieldAlasAtas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldAlasAtas.setBounds(230, 100, 200, 25);
        add(jTextFieldAlasAtas);

        JLabel jLabelAlasBawah = new JLabel("Alas Bawah (b) :");
        jLabelAlasBawah.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelAlasBawah.setBounds(70, 140, 150, 25);
        add(jLabelAlasBawah);
        jTextFieldAlasBawah.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldAlasBawah.setBounds(230, 140, 200, 25);
        add(jTextFieldAlasBawah);

        JLabel jLabelTinggiAlas = new JLabel("Tinggi Alas Trapesium:");
        jLabelTinggiAlas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiAlas.setBounds(70, 180, 150, 25);
        add(jLabelTinggiAlas);
        jTextFieldTinggiAlas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiAlas.setBounds(230, 180, 200, 25);
        add(jTextFieldTinggiAlas);

        JLabel jLabelTinggiPrisma = new JLabel("Tinggi Prisma (t) :");
        jLabelTinggiPrisma.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiPrisma.setBounds(70, 220, 150, 25);
        add(jLabelTinggiPrisma);
        jTextFieldTinggiPrisma.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiPrisma.setBounds(230, 220, 200, 25);
        add(jTextFieldTinggiPrisma);

        // Tambah label dan text field untuk sisi A, B, C, D dari alas trapesium
        JLabel jLabelSisiA = new JLabel("Sisi Miring Kiri Alas:");
        jLabelSisiA.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisiA.setBounds(70, 260, 150, 25);
        add(jLabelSisiA);
        jTextFieldSisiA.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisiA.setBounds(230, 260, 200, 25);
        add(jTextFieldSisiA);

        JLabel jLabelSisiB = new JLabel("Sisi Miring Kanan Alas:");
        jLabelSisiB.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisiB.setBounds(70, 300, 160, 25); // Sesuaikan lebar agar tidak terpotong
        add(jLabelSisiB);
        jTextFieldSisiB.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisiB.setBounds(230, 300, 200, 25);
        add(jTextFieldSisiB);

        JLabel jLabelSisiC = new JLabel("Sisi Alas Atas (C):");
        jLabelSisiC.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisiC.setBounds(70, 340, 150, 25);
        add(jLabelSisiC);
        jTextFieldSisiC.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisiC.setBounds(230, 340, 200, 25);
        add(jTextFieldSisiC);

        JLabel jLabelSisiD = new JLabel("Sisi Alas Bawah (D):");
        jLabelSisiD.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisiD.setBounds(70, 380, 150, 25);
        add(jLabelSisiD);
        jTextFieldSisiD.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisiD.setBounds(230, 380, 200, 25);
        add(jTextFieldSisiD);


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

        cek(); // Panggil cek() untuk mengisi field jika ada objek prisma yang sudah ada

        jButtonsSave.addActionListener(e -> {
            try {
                double alasAtas = Double.parseDouble(jTextFieldAlasAtas.getText());
                double alasBawah = Double.parseDouble(jTextFieldAlasBawah.getText());
                double tinggiAlas = Double.parseDouble(jTextFieldTinggiAlas.getText());
                double tinggiPrisma = Double.parseDouble(jTextFieldTinggiPrisma.getText());
                double sisiA = Double.parseDouble(jTextFieldSisiA.getText());
                double sisiB = Double.parseDouble(jTextFieldSisiB.getText());
                double sisiC = Double.parseDouble(jTextFieldSisiC.getText());
                double sisiD = Double.parseDouble(jTextFieldSisiD.getText());

                if (alasAtas <= 0 || alasBawah <= 0 || tinggiAlas <= 0 || tinggiPrisma <= 0 ||
                        sisiA <= 0 || sisiB <= 0 || sisiC <= 0 || sisiD <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }

                PrismaTrapesium newPrisma = new PrismaTrapesium(alasAtas, alasBawah, tinggiAlas, tinggiPrisma, sisiA, sisiB, sisiC, sisiD);

                Thread calcThread = new Thread(newPrisma);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilPrismaTrapesiumView(newPrisma).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldAlasAtas.setText("");
            jTextFieldAlasBawah.setText("");
            jTextFieldTinggiAlas.setText("");
            jTextFieldTinggiPrisma.setText("");
            jTextFieldSisiA.setText("");
            jTextFieldSisiB.setText("");
            jTextFieldSisiC.setText("");
            jTextFieldSisiD.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (prisma != null) {
            jTextFieldAlasAtas.setText(String.valueOf(prisma.sisiSejajar1));
            jTextFieldAlasBawah.setText(String.valueOf(prisma.sisiSejajar2));
            jTextFieldTinggiAlas.setText(String.valueOf(prisma.tinggi));
            jTextFieldTinggiPrisma.setText(String.valueOf(prisma.getTinggiPrismaTrapesium()));
            jTextFieldSisiA.setText(String.valueOf(prisma.getSisiA()));
            jTextFieldSisiB.setText(String.valueOf(prisma.getSisiB()));
            jTextFieldSisiC.setText(String.valueOf(prisma.getSisiC()));
            jTextFieldSisiD.setText(String.valueOf(prisma.getSisiD()));
        }
    }
}