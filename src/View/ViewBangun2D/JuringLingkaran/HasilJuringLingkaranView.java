package View.ViewBangun2D.JuringLingkaran;

import Benda2D.JuringLingkaran;
import javax.swing.*;
import java.awt.*;

public class HasilJuringLingkaranView extends JFrame {

    public HasilJuringLingkaranView(JuringLingkaran jl) {
        initComponents(jl);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Juring Lingkaran");
    }

    private void initComponents(JuringLingkaran jl) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL HITUNG JURING LINGKARAN", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelInputJari = new JLabel("Input Jari-Jari :");
        jLabelInputJari.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputJari.setBounds(70, 100, 150, 25);
        add(jLabelInputJari);
        JTextField jTextFieldJari = new JTextField(String.valueOf(jl.jariJari));
        jTextFieldJari.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldJari.setBounds(230, 100, 200, 25);
        jTextFieldJari.setEditable(false);
        add(jTextFieldJari);

        JLabel jLabelInputSudut = new JLabel("Input Sudut :");
        jLabelInputSudut.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputSudut.setBounds(70, 140, 150, 25);
        add(jLabelInputSudut);
        JTextField jTextFieldSudut = new JTextField(String.valueOf(jl.sudut)); //
        jTextFieldSudut.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldSudut.setBounds(230, 140, 200, 25);
        jTextFieldSudut.setEditable(false);
        add(jTextFieldSudut);

        JLabel jLabelLuas = new JLabel("Luas :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 200, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", jl.getLuasJuringLingkaran())); //
        jTextFieldLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldLuas.setBounds(230, 200, 200, 30);
        jTextFieldLuas.setEditable(false);
        add(jTextFieldLuas);

        JLabel jLabelKeliling = new JLabel("Keliling :");
        jLabelKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelKeliling.setBounds(70, 250, 150, 25);
        add(jLabelKeliling);

        JTextField jTextFieldKeliling = new JTextField(String.format("%.2f", jl.getKelilingJuringLingkaran())); //
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
            new JuringLingkaranView(jl).setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}