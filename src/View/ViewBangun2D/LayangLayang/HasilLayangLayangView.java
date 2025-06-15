package View.ViewBangun2D.LayangLayang;

import Benda2D.LayangLayang;
import javax.swing.*;
import java.awt.*;

public class HasilLayangLayangView extends JFrame {

    public HasilLayangLayangView(LayangLayang ll) {
        initComponents(ll);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Layang-Layang");
    }

    private void initComponents(LayangLayang ll) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 550);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL HITUNG LAYANG-LAYANG", SwingConstants.CENTER);
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
        JTextField jTextFieldD1 = new JTextField(String.valueOf(ll.diagonal1)); //
        jTextFieldD1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldD1.setBounds(230, 100, 200, 25);
        jTextFieldD1.setEditable(false);
        add(jTextFieldD1);

        JLabel jLabelInputD2 = new JLabel("Input Diagonal 2 :");
        jLabelInputD2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputD2.setBounds(70, 140, 150, 25);
        add(jLabelInputD2);
        JTextField jTextFieldD2 = new JTextField(String.valueOf(ll.diagonal2)); //
        jTextFieldD2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldD2.setBounds(230, 140, 200, 25);
        jTextFieldD2.setEditable(false);
        add(jTextFieldD2);

        JLabel jLabelInputS1 = new JLabel("Input Sisi A :");
        jLabelInputS1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputS1.setBounds(70, 180, 150, 25);
        add(jLabelInputS1);
        JTextField jTextFieldS1 = new JTextField(String.valueOf(ll.sisi1)); //
        jTextFieldS1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldS1.setBounds(230, 180, 200, 25);
        jTextFieldS1.setEditable(false);
        add(jTextFieldS1);

        JLabel jLabelInputS2 = new JLabel("Input Sisi B :");
        jLabelInputS2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jLabelInputS2.setBounds(70, 220, 150, 25);
        add(jLabelInputS2);
        JTextField jTextFieldS2 = new JTextField(String.valueOf(ll.sisi2)); //
        jTextFieldS2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jTextFieldS2.setBounds(230, 220, 200, 25);
        jTextFieldS2.setEditable(false);
        add(jTextFieldS2);

        JLabel jLabelLuas = new JLabel("Luas :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 280, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", ll.getLuasLayangLayang())); //
        jTextFieldLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldLuas.setBounds(230, 280, 200, 30);
        jTextFieldLuas.setEditable(false);
        add(jTextFieldLuas);

        JLabel jLabelKeliling = new JLabel("Keliling :");
        jLabelKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelKeliling.setBounds(70, 330, 150, 25);
        add(jLabelKeliling);

        JTextField jTextFieldKeliling = new JTextField(String.format("%.2f", ll.getKelilingLayangLayang())); //
        jTextFieldKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldKeliling.setBounds(230, 330, 200, 30);
        jTextFieldKeliling.setEditable(false);
        add(jTextFieldKeliling);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 450, 500, 10);
        add(jSeparator2);

        JButton jButtonEdit = new JButton("Edit");
        jButtonEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonEdit.setBounds(120, 470, 100, 30);
        add(jButtonEdit);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(280, 470, 100, 30);
        add(jButtonClose);

        jButtonEdit.addActionListener(e -> {
            dispose();
            new LayangLayangView(ll).setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}