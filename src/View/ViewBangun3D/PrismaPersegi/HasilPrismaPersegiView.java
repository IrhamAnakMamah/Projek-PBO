package View.ViewBangun3D.PrismaPersegi;

import Benda3D.PrismaPersegi;
import javax.swing.*;
import java.awt.*;

public class HasilPrismaPersegiView extends JFrame {

    public HasilPrismaPersegiView(PrismaPersegi prisma) {
        initComponents(prisma);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Prisma Persegi");
    }

    private void initComponents(PrismaPersegi prisma) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL HITUNG PRISMA PERSEGI", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelInputSisi = new JLabel("Input Sisi Alas :");
        jLabelInputSisi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputSisi.setBounds(70, 100, 150, 25);
        add(jLabelInputSisi);
        JTextField jTextFieldSisi = new JTextField(String.valueOf(prisma.sisi));
        jTextFieldSisi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldSisi.setBounds(230, 100, 200, 25);
        jTextFieldSisi.setEditable(false);
        add(jTextFieldSisi);

        JLabel jLabelVolume = new JLabel("Volume :");
        jLabelVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelVolume.setBounds(70, 160, 150, 25);
        add(jLabelVolume);

        JTextField jTextFieldVolume = new JTextField(String.format("%.2f", prisma.getVolumeKubus())); //
        jTextFieldVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldVolume.setBounds(230, 160, 200, 30);
        jTextFieldVolume.setEditable(false);
        add(jTextFieldVolume);

        JLabel jLabelLuas = new JLabel("Luas Permukaan :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 210, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", prisma.getLuasPermukaanKubus())); //
        jTextFieldLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldLuas.setBounds(230, 210, 200, 30);
        jTextFieldLuas.setEditable(false);
        add(jTextFieldLuas);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 350, 500, 10);
        add(jSeparator2);

        JButton jButtonEdit = new JButton("Edit");
        jButtonEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonEdit.setBounds(120, 370, 100, 30);
        add(jButtonEdit);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(280, 370, 100, 30);
        add(jButtonClose);

        jButtonEdit.addActionListener(e -> {
            dispose();
            new PrismaPersegiView(prisma).setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}