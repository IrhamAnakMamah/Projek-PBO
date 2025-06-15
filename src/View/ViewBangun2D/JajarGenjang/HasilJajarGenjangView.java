package View.ViewBangun2D.JajarGenjang;

import Benda2D.JajarGenjang;
import javax.swing.*;
import java.awt.*;

public class HasilJajarGenjangView extends JFrame {

    public HasilJajarGenjangView(JajarGenjang jg) {
        initComponents(jg);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Jajar Genjang");
    }

    private void initComponents(JajarGenjang jg) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL HITUNG JAJAR GENJANG", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelInputAlas = new JLabel("Input Alas :");
        jLabelInputAlas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputAlas.setBounds(70, 100, 150, 25);
        add(jLabelInputAlas);
        JTextField jTextFieldAlas = new JTextField(String.valueOf(jg.alas)); //
        jTextFieldAlas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldAlas.setBounds(230, 100, 200, 25);
        jTextFieldAlas.setEditable(false);
        add(jTextFieldAlas);

        JLabel jLabelInputTinggi = new JLabel("Input Tinggi :");
        jLabelInputTinggi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputTinggi.setBounds(70, 140, 150, 25);
        add(jLabelInputTinggi);
        JTextField jTextFieldTinggi = new JTextField(String.valueOf(jg.tinggi)); //
        jTextFieldTinggi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldTinggi.setBounds(230, 140, 200, 25);
        jTextFieldTinggi.setEditable(false);
        add(jTextFieldTinggi);

        JLabel jLabelInputSudut = new JLabel("Input Sudut Lancip :");
        jLabelInputSudut.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputSudut.setBounds(70, 180, 150, 25);
        add(jLabelInputSudut);
        JTextField jTextFieldSudut = new JTextField(String.valueOf(jg.sudutLancip)); //
        jTextFieldSudut.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldSudut.setBounds(230, 180, 200, 25);
        jTextFieldSudut.setEditable(false);
        add(jTextFieldSudut);

        JLabel jLabelLuas = new JLabel("Luas :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 240, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", jg.getLuasJajarGenjang())); //
        jTextFieldLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldLuas.setBounds(230, 240, 200, 30);
        jTextFieldLuas.setEditable(false);
        add(jTextFieldLuas);

        JLabel jLabelKeliling = new JLabel("Keliling :");
        jLabelKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelKeliling.setBounds(70, 290, 150, 25);
        add(jLabelKeliling);

        JTextField jTextFieldKeliling = new JTextField(String.format("%.2f", jg.getKelilingJajarGenjang())); //
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
            new JajarGenjangView(jg).setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}