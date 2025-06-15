package View.ViewBangun2D.BelahKetupat;

import Benda2D.BelahKetupat;
import javax.swing.*;
import java.awt.*;

public class HasilBelahKetupatView extends JFrame {

    public HasilBelahKetupatView(BelahKetupat bk) {
        initComponents(bk);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Belah Ketupat");
    }

    private void initComponents(BelahKetupat bk) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL HITUNG BELAH KETUPAT", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelInputD1 = new JLabel("Input Diagonal 1 :");
        jLabelInputD1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputD1.setBounds(70, 100, 150, 25);
        add(jLabelInputD1);

        JTextField jTextFieldD1 = new JTextField(String.valueOf(bk.diagonal1));
        jTextFieldD1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldD1.setBounds(230, 100, 200, 25);
        jTextFieldD1.setEditable(false);
        add(jTextFieldD1);

        JLabel jLabelInputD2 = new JLabel("Input Diagonal 2 :");
        jLabelInputD2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputD2.setBounds(70, 140, 150, 25);
        add(jLabelInputD2);

        JTextField jTextFieldD2 = new JTextField(String.valueOf(bk.diagonal2));
        jTextFieldD2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldD2.setBounds(230, 140, 200, 25);
        jTextFieldD2.setEditable(false);
        add(jTextFieldD2);

        JLabel jLabelLuas = new JLabel("Luas :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 200, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", bk.getLuasBelahKetupat()));
        jTextFieldLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldLuas.setBounds(230, 200, 200, 30);
        jTextFieldLuas.setEditable(false);
        add(jTextFieldLuas);

        JLabel jLabelKeliling = new JLabel("Keliling :");
        jLabelKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelKeliling.setBounds(70, 250, 150, 25);
        add(jLabelKeliling);

        JTextField jTextFieldKeliling = new JTextField(String.format("%.2f", bk.getKelilingBelahKetupat()));
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
            new BelahKetupatView(bk).setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}