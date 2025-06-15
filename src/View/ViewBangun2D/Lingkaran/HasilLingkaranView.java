package View.ViewBangun2D.Lingkaran;

import Benda2D.Lingkaran;
import javax.swing.*;
import java.awt.*;

public class HasilLingkaranView extends JFrame {

    public HasilLingkaranView(Lingkaran lingkaran) {
        initComponents(lingkaran);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Lingkaran");
    }

    private void initComponents(Lingkaran lingkaran) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL HITUNG LINGKARAN", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelInputJari = new JLabel("Input Jari-Jari :");
        jLabelInputJari.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputJari.setBounds(70, 100, 150, 25);
        add(jLabelInputJari);

        JTextField jTextFieldJari = new JTextField(String.valueOf(lingkaran.getJariJari()));
        jTextFieldJari.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldJari.setBounds(230, 100, 200, 25);
        jTextFieldJari.setEditable(false);
        add(jTextFieldJari);

        JLabel jLabelLuas = new JLabel("Luas :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 160, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", lingkaran.getLuasLingkaran()));
        jTextFieldLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldLuas.setBounds(230, 160, 200, 30);
        jTextFieldLuas.setEditable(false);
        add(jTextFieldLuas);

        JLabel jLabelKeliling = new JLabel("Keliling :");
        jLabelKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelKeliling.setBounds(70, 210, 150, 25);
        add(jLabelKeliling);

        JTextField jTextFieldKeliling = new JTextField(String.format("%.2f", lingkaran.getKelilingLingkaran()));
        jTextFieldKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldKeliling.setBounds(230, 210, 200, 30);
        jTextFieldKeliling.setEditable(false);
        add(jTextFieldKeliling);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 300, 500, 10);
        add(jSeparator2);

        JButton jButtonEdit = new JButton("Edit");
        jButtonEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonEdit.setBounds(120, 320, 100, 30);
        add(jButtonEdit);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(280, 320, 100, 30);
        add(jButtonClose);

        jButtonEdit.addActionListener(e -> {
            dispose();
            new LingkaranView(lingkaran).setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}