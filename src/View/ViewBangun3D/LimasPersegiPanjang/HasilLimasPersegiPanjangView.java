package View.ViewBangun3D.LimasPersegiPanjang;

import Benda3D.LimasPersegiPanjang;
import javax.swing.*;
import java.awt.*;

public class HasilLimasPersegiPanjangView extends JFrame {

    public HasilLimasPersegiPanjangView(LimasPersegiPanjang limas) {
        initComponents(limas);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Limas Persegi Panjang");
    }

    private void initComponents(LimasPersegiPanjang limas) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL LIMAS PERSEGI PANJANG", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelInputP = new JLabel("Input Panjang Alas:");
        jLabelInputP.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputP.setBounds(70, 100, 150, 25);
        add(jLabelInputP);
        JTextField jTextFieldP = new JTextField(String.valueOf(limas.panjang));
        jTextFieldP.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldP.setBounds(230, 100, 200, 25);
        jTextFieldP.setEditable(false);
        add(jTextFieldP);

        JLabel jLabelInputL = new JLabel("Input Lebar Alas:");
        jLabelInputL.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputL.setBounds(70, 140, 150, 25);
        add(jLabelInputL);
        JTextField jTextFieldL = new JTextField(String.valueOf(limas.lebar));
        jTextFieldL.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldL.setBounds(230, 140, 200, 25);
        jTextFieldL.setEditable(false);
        add(jTextFieldL);

        JLabel jLabelInputT = new JLabel("Input Tinggi Limas:");
        jLabelInputT.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputT.setBounds(70, 180, 150, 25);
        add(jLabelInputT);
        JTextField jTextFieldT = new JTextField(String.valueOf(limas.tinggiLimasPersegiPanjang));
        jTextFieldT.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldT.setBounds(230, 180, 200, 25);
        jTextFieldT.setEditable(false);
        add(jTextFieldT);

        JLabel jLabelVolume = new JLabel("Volume :");
        jLabelVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelVolume.setBounds(70, 240, 150, 25);
        add(jLabelVolume);

        JTextField jTextFieldVolume = new JTextField(String.format("%.2f", limas.getVolumeLimasPersegiPanjang())); //
        jTextFieldVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldVolume.setBounds(230, 240, 200, 30);
        jTextFieldVolume.setEditable(false);
        add(jTextFieldVolume);

        JLabel jLabelLuas = new JLabel("Luas Permukaan :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 290, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", limas.getLuasPermukaanLimasPersegiPanjang())); //
        jTextFieldLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldLuas.setBounds(230, 290, 200, 30);
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
            new LimasPersegiPanjangView(limas).setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}