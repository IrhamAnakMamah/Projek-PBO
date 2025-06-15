package View.ViewBangun2D.PersegiPanjang;

import Benda2D.PersegiPanjang;
import javax.swing.*;
import java.awt.*;

public class HasilPersegiPanjangView extends JFrame {

    public HasilPersegiPanjangView(PersegiPanjang pp) {
        initComponents(pp);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Persegi Panjang");
    }

    private void initComponents(PersegiPanjang pp) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL HITUNG PERSEGI PANJANG", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelInputPanjang = new JLabel("Input Panjang :");
        jLabelInputPanjang.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputPanjang.setBounds(70, 100, 150, 25);
        add(jLabelInputPanjang);

        JTextField jTextFieldPanjang = new JTextField(String.valueOf(pp.panjang));
        jTextFieldPanjang.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldPanjang.setBounds(230, 100, 200, 25);
        jTextFieldPanjang.setEditable(false);
        add(jTextFieldPanjang);

        JLabel jLabelInputLebar = new JLabel("Input Lebar :");
        jLabelInputLebar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputLebar.setBounds(70, 140, 150, 25);
        add(jLabelInputLebar);

        JTextField jTextFieldLebar = new JTextField(String.valueOf(pp.lebar));
        jTextFieldLebar.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldLebar.setBounds(230, 140, 200, 25);
        jTextFieldLebar.setEditable(false);
        add(jTextFieldLebar);

        JLabel jLabelLuas = new JLabel("Luas :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 200, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", pp.getLuasPersegiPanjang()));
        jTextFieldLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldLuas.setBounds(230, 200, 200, 30);
        jTextFieldLuas.setEditable(false);
        add(jTextFieldLuas);

        JLabel jLabelKeliling = new JLabel("Keliling :");
        jLabelKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelKeliling.setBounds(70, 250, 150, 25);
        add(jLabelKeliling);

        JTextField jTextFieldKeliling = new JTextField(String.format("%.2f", pp.getKelilingPersegiPanjang()));
        jTextFieldKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldKeliling.setBounds(230, 250, 200, 30);
        jTextFieldKeliling.setEditable(false);
        add(jTextFieldKeliling);

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
            new PersegiPanjangView(pp).setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}