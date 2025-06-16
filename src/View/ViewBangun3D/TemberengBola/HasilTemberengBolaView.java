package View.ViewBangun3D.TemberengBola;

import Benda3D.TemberengBola;
import javax.swing.*;
import java.awt.*;

public class HasilTemberengBolaView extends JFrame {

    public HasilTemberengBolaView(TemberengBola tb) {
        initComponents(tb);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Tembereng Bola");
    }

    private void initComponents(TemberengBola tb) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL TEMBERENG BOLA", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelVolume = new JLabel("Volume :");
        jLabelVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelVolume.setBounds(70, 160, 150, 25);
        add(jLabelVolume);

        JTextField jTextFieldVolume = new JTextField(String.format("%.2f", tb.getVolumeTemberengBola())); //
        jTextFieldVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldVolume.setBounds(230, 160, 200, 30);
        jTextFieldVolume.setEditable(false);
        add(jTextFieldVolume);

        JLabel jLabelLuas = new JLabel("Luas Permukaan :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 210, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", tb.getLuasPermukaanTemberengBola())); //
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
            new TemberengBolaView(tb).setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}