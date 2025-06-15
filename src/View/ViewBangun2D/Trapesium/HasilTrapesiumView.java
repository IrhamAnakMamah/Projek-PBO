package View.ViewBangun2D.Trapesium;

import Benda2D.Trapesium;
import javax.swing.*;
import java.awt.*;

public class HasilTrapesiumView extends JFrame {

    public HasilTrapesiumView(Trapesium trapesium) {
        initComponents(trapesium);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Trapesium");
    }

    private void initComponents(Trapesium trapesium) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL HITUNG TRAPESIUM", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelInputSisi1 = new JLabel("Input Sisi Sejajar 1 :");
        jLabelInputSisi1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputSisi1.setBounds(70, 100, 150, 25);
        add(jLabelInputSisi1);
        JTextField jTextFieldSisi1 = new JTextField(String.valueOf(trapesium.sisiSejajar1)); //
        jTextFieldSisi1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldSisi1.setBounds(230, 100, 200, 25);
        jTextFieldSisi1.setEditable(false);
        add(jTextFieldSisi1);

        JLabel jLabelInputSisi2 = new JLabel("Input Sisi Sejajar 2 :");
        jLabelInputSisi2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputSisi2.setBounds(70, 140, 150, 25);
        add(jLabelInputSisi2);
        JTextField jTextFieldSisi2 = new JTextField(String.valueOf(trapesium.sisiSejajar2)); //
        jTextFieldSisi2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldSisi2.setBounds(230, 140, 200, 25);
        jTextFieldSisi2.setEditable(false);
        add(jTextFieldSisi2);

        JLabel jLabelInputTinggi = new JLabel("Input Tinggi :");
        jLabelInputTinggi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputTinggi.setBounds(70, 180, 150, 25);
        add(jLabelInputTinggi);
        JTextField jTextFieldTinggi = new JTextField(String.valueOf(trapesium.tinggi)); //
        jTextFieldTinggi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldTinggi.setBounds(230, 180, 200, 25);
        jTextFieldTinggi.setEditable(false);
        add(jTextFieldTinggi);

        JLabel jLabelLuas = new JLabel("Luas :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 240, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", trapesium.getLuasTrapesium())); //
        jTextFieldLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldLuas.setBounds(230, 240, 200, 30);
        jTextFieldLuas.setEditable(false);
        add(jTextFieldLuas);

        JLabel jLabelKeliling = new JLabel("Keliling :");
        jLabelKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelKeliling.setBounds(70, 290, 150, 25);
        add(jLabelKeliling);

        JTextField jTextFieldKeliling = new JTextField(String.format("%.2f", trapesium.getKelilingTrapesium())); //
        jTextFieldKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldKeliling.setBounds(230, 290, 200, 30);
        jTextFieldKeliling.setEditable(false);
        add(jTextFieldKeliling);

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
            new TrapesiumView(trapesium).setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}