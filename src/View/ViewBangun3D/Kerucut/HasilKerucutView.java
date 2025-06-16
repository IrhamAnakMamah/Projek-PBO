package View.ViewBangun3D.Kerucut;

import Benda3D.Kerucut;
import javax.swing.*;
import java.awt.*;

public class HasilKerucutView extends JFrame {

    public HasilKerucutView(Kerucut kerucut) {
        initComponents(kerucut);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Kerucut");
    }

    private void initComponents(Kerucut kerucut) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL HITUNG KERUCUT", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelInputJari = new JLabel("Input Jari-Jari :");
        jLabelInputJari.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputJari.setBounds(70, 100, 150, 25);
        add(jLabelInputJari);
        JTextField jTextFieldJari = new JTextField(String.valueOf(kerucut.getJariJari()));
        jTextFieldJari.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldJari.setBounds(230, 100, 200, 25);
        jTextFieldJari.setEditable(false);
        add(jTextFieldJari);

        // tinggiKerucut is private, so we can't display it back.

        JLabel jLabelVolume = new JLabel("Volume :");
        jLabelVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelVolume.setBounds(70, 160, 150, 25);
        add(jLabelVolume);

        JTextField jTextFieldVolume = new JTextField(String.format("%.2f", kerucut.getVolumeKerucut())); //
        jTextFieldVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldVolume.setBounds(230, 160, 200, 30);
        jTextFieldVolume.setEditable(false);
        add(jTextFieldVolume);

        JLabel jLabelLuas = new JLabel("Luas Permukaan :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 210, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", kerucut.getLuasPermukaanKerucut())); //
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
            new KerucutView(kerucut).setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}