package View.ViewBangun3D.KerucutTerpancung;

import Benda3D.KerucutTerpancung;
import javax.swing.*;
import java.awt.*;

public class HasilKerucutTerpancungView extends JFrame {

    public HasilKerucutTerpancungView(KerucutTerpancung kt) {
        initComponents(kt);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Kerucut Terpancung");
    }

    private void initComponents(KerucutTerpancung kt) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL KERUCUT TERPANCUNG", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelInputTinggi = new JLabel("Input Tinggi :");
        jLabelInputTinggi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputTinggi.setBounds(70, 100, 150, 25);
        add(jLabelInputTinggi);
        JTextField jTextFieldTinggi = new JTextField(String.valueOf(kt.getTinggi()));
        jTextFieldTinggi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldTinggi.setBounds(230, 100, 200, 25);
        jTextFieldTinggi.setEditable(false);
        add(jTextFieldTinggi);

        JLabel jLabelInputJariAtas = new JLabel("Input Jari-Jari Atas :");
        jLabelInputJariAtas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputJariAtas.setBounds(70, 140, 150, 25);
        add(jLabelInputJariAtas);
        JTextField jTextFieldJariAtas = new JTextField(String.valueOf(kt.getJariJariAtas()));
        jTextFieldJariAtas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldJariAtas.setBounds(230, 140, 200, 25);
        jTextFieldJariAtas.setEditable(false);
        add(jTextFieldJariAtas);

        JLabel jLabelInputJariBawah = new JLabel("Input Jari-Jari Bawah :");
        jLabelInputJariBawah.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputJariBawah.setBounds(70, 180, 150, 25);
        add(jLabelInputJariBawah);
        JTextField jTextFieldJariBawah = new JTextField(String.valueOf(kt.getJariJari()));
        jTextFieldJariBawah.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldJariBawah.setBounds(230, 180, 200, 25);
        jTextFieldJariBawah.setEditable(false);
        add(jTextFieldJariBawah);

        JLabel jLabelVolume = new JLabel("Volume :");
        jLabelVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelVolume.setBounds(70, 240, 150, 25);
        add(jLabelVolume);

        JTextField jTextFieldVolume = new JTextField(String.format("%.2f", kt.getVolumeKerucutTerpancung())); //
        jTextFieldVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldVolume.setBounds(230, 240, 200, 30);
        jTextFieldVolume.setEditable(false);
        add(jTextFieldVolume);

        JLabel jLabelLuas = new JLabel("Luas Permukaan :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 290, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", kt.getLuasPermukaanKerucutTerpancung())); //
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
            new KerucutTerpancungView(kt).setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}