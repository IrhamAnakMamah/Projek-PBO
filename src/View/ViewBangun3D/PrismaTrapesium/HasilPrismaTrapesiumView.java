package View.ViewBangun3D.PrismaTrapesium;

import Benda3D.PrismaTrapesium;
import javax.swing.*;
import java.awt.*;

public class HasilPrismaTrapesiumView extends JFrame {

    public HasilPrismaTrapesiumView(PrismaTrapesium prisma) {
        initComponents(prisma);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Prisma Trapesium");
    }

    private void initComponents(PrismaTrapesium prisma) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 600); // Sesuaikan ukuran frame
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL PRISMA TRAPESIUM", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        // Menampilkan nilai input
        JLabel jLabelInputAlasAtas = new JLabel("Input Alas Atas:");
        jLabelInputAlasAtas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputAlasAtas.setBounds(70, 100, 150, 25);
        add(jLabelInputAlasAtas);
        JTextField jTextFieldAlasAtas = new JTextField(String.valueOf(prisma.sisiSejajar1));
        jTextFieldAlasAtas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldAlasAtas.setBounds(230, 100, 200, 25);
        jTextFieldAlasAtas.setEditable(false);
        add(jTextFieldAlasAtas);

        JLabel jLabelInputAlasBawah = new JLabel("Input Alas Bawah:");
        jLabelInputAlasBawah.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputAlasBawah.setBounds(70, 130, 150, 25);
        add(jLabelInputAlasBawah);
        JTextField jTextFieldAlasBawah = new JTextField(String.valueOf(prisma.sisiSejajar2));
        jTextFieldAlasBawah.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldAlasBawah.setBounds(230, 130, 200, 25);
        jTextFieldAlasBawah.setEditable(false);
        add(jTextFieldAlasBawah);

        JLabel jLabelInputTinggiAlas = new JLabel("Input Tinggi Alas:");
        jLabelInputTinggiAlas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputTinggiAlas.setBounds(70, 160, 150, 25);
        add(jLabelInputTinggiAlas);
        JTextField jTextFieldTinggiAlas = new JTextField(String.valueOf(prisma.tinggi));
        jTextFieldTinggiAlas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldTinggiAlas.setBounds(230, 160, 200, 25);
        jTextFieldTinggiAlas.setEditable(false);
        add(jTextFieldTinggiAlas);

        JLabel jLabelInputTinggiPrisma = new JLabel("Input Tinggi Prisma:");
        jLabelInputTinggiPrisma.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputTinggiPrisma.setBounds(70, 190, 150, 25);
        add(jLabelInputTinggiPrisma);
        JTextField jTextFieldTinggiPrisma = new JTextField(String.valueOf(prisma.getTinggiPrismaTrapesium()));
        jTextFieldTinggiPrisma.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldTinggiPrisma.setBounds(230, 190, 200, 25);
        jTextFieldTinggiPrisma.setEditable(false);
        add(jTextFieldTinggiPrisma);

        JLabel jLabelInputSisiA = new JLabel("Input Sisi Miring Kiri:");
        jLabelInputSisiA.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputSisiA.setBounds(70, 220, 150, 25);
        add(jLabelInputSisiA);
        JTextField jTextFieldSisiA = new JTextField(String.valueOf(prisma.getSisiA()));
        jTextFieldSisiA.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldSisiA.setBounds(230, 220, 200, 25);
        jTextFieldSisiA.setEditable(false);
        add(jTextFieldSisiA);

        JLabel jLabelInputSisiB = new JLabel("Input Sisi Miring Kanan:");
        jLabelInputSisiB.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputSisiB.setBounds(70, 250, 160, 25);
        add(jLabelInputSisiB);
        JTextField jTextFieldSisiB = new JTextField(String.valueOf(prisma.getSisiB()));
        jTextFieldSisiB.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldSisiB.setBounds(230, 250, 200, 25);
        jTextFieldSisiB.setEditable(false);
        add(jTextFieldSisiB);

        JLabel jLabelInputSisiC = new JLabel("Input Sisi Atas:");
        jLabelInputSisiC.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputSisiC.setBounds(70, 280, 150, 25);
        add(jLabelInputSisiC);
        JTextField jTextFieldSisiC = new JTextField(String.valueOf(prisma.getSisiC()));
        jTextFieldSisiC.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldSisiC.setBounds(230, 280, 200, 25);
        jTextFieldSisiC.setEditable(false);
        add(jTextFieldSisiC);

        JLabel jLabelInputSisiD = new JLabel("Input Sisi Bawah:");
        jLabelInputSisiD.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputSisiD.setBounds(70, 310, 150, 25);
        add(jLabelInputSisiD);
        JTextField jTextFieldSisiD = new JTextField(String.valueOf(prisma.getSisiD()));
        jTextFieldSisiD.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldSisiD.setBounds(230, 310, 200, 25);
        jTextFieldSisiD.setEditable(false);
        add(jTextFieldSisiD);


        // Tampilan hasil
        JLabel jLabelVolume = new JLabel("Volume :");
        jLabelVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelVolume.setBounds(70, 360, 150, 25); // Sesuaikan posisi
        add(jLabelVolume);

        JTextField jTextFieldVolume = new JTextField(String.format("%.2f", prisma.getVolumePrismaTrapesium()));
        jTextFieldVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldVolume.setBounds(230, 360, 200, 30);
        jTextFieldVolume.setEditable(false);
        add(jTextFieldVolume);

        JLabel jLabelLuas = new JLabel("Luas Permukaan :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 410, 150, 25); // Sesuaikan posisi
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", prisma.getLuasPermukaanPrismaTrapesium()));
        jTextFieldLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldLuas.setBounds(230, 410, 200, 30);
        jTextFieldLuas.setEditable(false);
        add(jTextFieldLuas);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 500, 500, 10); // Sesuaikan posisi separator
        add(jSeparator2);

        JButton jButtonEdit = new JButton("Edit");
        jButtonEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonEdit.setBounds(120, 520, 100, 30); // Sesuaikan posisi tombol
        add(jButtonEdit);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(280, 520, 100, 30); // Sesuaikan posisi tombol
        add(jButtonClose);

        jButtonEdit.addActionListener(e -> {
            dispose();
            new PrismaTrapesiumView(prisma).setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}