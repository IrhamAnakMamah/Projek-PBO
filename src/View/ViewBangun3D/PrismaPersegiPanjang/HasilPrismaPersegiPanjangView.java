package View.ViewBangun3D.PrismaPersegiPanjang;

import Benda3D.PrismaPersegiPanjang;
import javax.swing.*;
import java.awt.*;

public class HasilPrismaPersegiPanjangView extends JFrame {

    public HasilPrismaPersegiPanjangView(PrismaPersegiPanjang balok) {
        initComponents(balok);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Balok");
    }

    private void initComponents(PrismaPersegiPanjang balok) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL HITUNG BALOK", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelInputP = new JLabel("Input Panjang :");
        jLabelInputP.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputP.setBounds(70, 100, 150, 25);
        add(jLabelInputP);
        JTextField jTextFieldP = new JTextField(String.valueOf(balok.panjang));
        jTextFieldP.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldP.setBounds(230, 100, 200, 25);
        jTextFieldP.setEditable(false);
        add(jTextFieldP);

        JLabel jLabelInputL = new JLabel("Input Lebar :");
        jLabelInputL.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputL.setBounds(70, 140, 150, 25);
        add(jLabelInputL);
        JTextField jTextFieldL = new JTextField(String.valueOf(balok.lebar));
        jTextFieldL.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldL.setBounds(230, 140, 200, 25);
        jTextFieldL.setEditable(false);
        add(jTextFieldL);

        JLabel jLabelVolume = new JLabel("Volume :");
        jLabelVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelVolume.setBounds(70, 200, 150, 25);
        add(jLabelVolume);

        JTextField jTextFieldVolume = new JTextField(String.format("%.2f", balok.getVolumeBalok())); //
        jTextFieldVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldVolume.setBounds(230, 200, 200, 30);
        jTextFieldVolume.setEditable(false);
        add(jTextFieldVolume);

        JLabel jLabelLuas = new JLabel("Luas Permukaan :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 250, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", balok.getLuasPermukaanBalok())); //
        jTextFieldLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldLuas.setBounds(230, 250, 200, 30);
        jTextFieldLuas.setEditable(false);
        add(jTextFieldLuas);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 400, 500, 10);
        add(jSeparator2);

        JButton jButtonEdit = new JButton("Edit");
        jButtonEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonEdit.setBounds(120, 420, 100, 30);
        add(jButtonEdit);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(280, 420, 100, 30);
        add(jButtonClose);

        jButtonEdit.addActionListener(e -> {
            dispose();
            new PrismaPersegiPanjangView(balok).setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}