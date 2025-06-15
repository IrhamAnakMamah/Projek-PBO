package View.ViewBangun2D.TemberengLingkaran;

import Benda2D.TemberengLingkaran;
import javax.swing.*;
import java.awt.*;

public class HasilTemberengLingkaranView extends JFrame {

    public HasilTemberengLingkaranView(TemberengLingkaran tl) {
        initComponents(tl);
        setLocationRelativeTo(null);
        setTitle("Hasil Kalkulasi Tembereng Lingkaran");
    }

    private void initComponents(TemberengLingkaran tl) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("HASIL HITUNG TEMBERENG", SwingConstants.CENTER);
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        jLabelTitle.setBounds(0, 20, 500, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        // Karena input tidak bisa diakses kembali dari objek, kita hanya tampilkan hasil
        JLabel jLabelLuas = new JLabel("Luas :");
        jLabelLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelLuas.setBounds(70, 160, 150, 25);
        add(jLabelLuas);

        JTextField jTextFieldLuas = new JTextField(String.format("%.2f", tl.getLuasTembereng())); //
        jTextFieldLuas.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldLuas.setBounds(230, 160, 200, 30);
        jTextFieldLuas.setEditable(false);
        add(jTextFieldLuas);

        JLabel jLabelKeliling = new JLabel("Keliling :");
        jLabelKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jLabelKeliling.setBounds(70, 210, 150, 25);
        add(jLabelKeliling);

        JTextField jTextFieldKeliling = new JTextField(String.format("%.2f", tl.getKelilingTembereng())); //
        jTextFieldKeliling.setFont(new Font("Tahoma", Font.BOLD, 16));
        jTextFieldKeliling.setBounds(230, 210, 200, 30);
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
            // Karena properti private, kita tidak bisa pass objeknya untuk di-edit
            // Jadi kita buka view kosong baru
            new TemberengLingkaranView().setVisible(true);
        });

        jButtonClose.addActionListener(e -> dispose());
    }
}