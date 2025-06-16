package View.ViewBangun3D.LimasJajarGenjang;

import Benda3D.LimasJajarGenjang;
import javax.swing.*;
import java.awt.*;

public class LimasJajarGenjangView extends JFrame {

    LimasJajarGenjang limas;
    JTextField jTextFieldAlas = new JTextField();
    JTextField jTextFieldTinggiAlas = new JTextField();
    JTextField jTextFieldSudut = new JTextField();
    JTextField jTextFieldTinggiLimas = new JTextField();

    public LimasJajarGenjangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Jajar Genjang");
    }

    public LimasJajarGenjangView(LimasJajarGenjang limas) {
        this.limas = limas;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Jajar Genjang");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("LIMAS JAJAR GENJANG");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(50, 20, 400, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelAlas = new JLabel("Alas Jajar Genjang:");
        jLabelAlas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelAlas.setBounds(70, 100, 150, 25);
        add(jLabelAlas);
        jTextFieldAlas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldAlas.setBounds(230, 100, 200, 25);
        add(jTextFieldAlas);

        JLabel jLabelTinggiAlas = new JLabel("Tinggi Alas :");
        jLabelTinggiAlas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiAlas.setBounds(70, 140, 150, 25);
        add(jLabelTinggiAlas);
        jTextFieldTinggiAlas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiAlas.setBounds(230, 140, 200, 25);
        add(jTextFieldTinggiAlas);

        JLabel jLabelSudut = new JLabel("Sudut Lancip Alas :");
        jLabelSudut.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSudut.setBounds(70, 180, 150, 25);
        add(jLabelSudut);
        jTextFieldSudut.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSudut.setBounds(230, 180, 200, 25);
        add(jTextFieldSudut);

        JLabel jLabelTinggiLimas = new JLabel("Tinggi Limas :");
        jLabelTinggiLimas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggiLimas.setBounds(70, 220, 150, 25);
        add(jLabelTinggiLimas);
        jTextFieldTinggiLimas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggiLimas.setBounds(230, 220, 200, 25);
        add(jTextFieldTinggiLimas);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 400, 500, 10);
        add(jSeparator2);

        JButton jButtonsSave = new JButton("Hitung");
        jButtonsSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonsSave.setBounds(55, 420, 100, 30);
        add(jButtonsSave);

        JButton jButtonReset = new JButton("Reset");
        jButtonReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonReset.setBounds(195, 420, 100, 30);
        add(jButtonReset);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(335, 420, 100, 30);
        add(jButtonClose);

        cek();

        jButtonsSave.addActionListener(e -> {
            try {
                double a = Double.parseDouble(jTextFieldAlas.getText());
                double ta = Double.parseDouble(jTextFieldTinggiAlas.getText());
                double s = Double.parseDouble(jTextFieldSudut.getText());
                double tl = Double.parseDouble(jTextFieldTinggiLimas.getText());

                LimasJajarGenjang newLimas = new LimasJajarGenjang(a, ta, s, tl);

                new HasilLimasJajarGenjangView(newLimas).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            // reset all fields
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (limas != null) {
            // parent properties are public
            jTextFieldAlas.setText(String.valueOf(limas.alas));
            jTextFieldTinggiAlas.setText(String.valueOf(limas.tinggi));
            jTextFieldSudut.setText(String.valueOf(limas.sudutLancip));
            jTextFieldTinggiLimas.setText(String.valueOf(limas.getTinggiLimas()));
        }
    }
}