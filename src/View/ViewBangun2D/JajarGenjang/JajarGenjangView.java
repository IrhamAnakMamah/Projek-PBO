package View.ViewBangun2D.JajarGenjang;

import Benda2D.JajarGenjang;
import javax.swing.*;
import java.awt.*;

public class JajarGenjangView extends JFrame {

    JajarGenjang jajarGenjang;
    JTextField jTextFieldAlas = new JTextField();
    JTextField jTextFieldTinggi = new JTextField();
    JTextField jTextFieldSudut = new JTextField();

    public JajarGenjangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Jajar Genjang");
    }

    public JajarGenjangView(JajarGenjang jajarGenjang) {
        this.jajarGenjang = jajarGenjang;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Jajar Genjang");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("JAJAR GENJANG");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(110, 20, 300, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelAlas = new JLabel("Alas :");
        jLabelAlas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelAlas.setBounds(70, 100, 150, 25);
        add(jLabelAlas);

        jTextFieldAlas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldAlas.setBounds(230, 100, 200, 25);
        add(jTextFieldAlas);

        JLabel jLabelTinggi = new JLabel("Tinggi :");
        jLabelTinggi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggi.setBounds(70, 140, 150, 25);
        add(jLabelTinggi);

        jTextFieldTinggi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggi.setBounds(230, 140, 200, 25);
        add(jTextFieldTinggi);

        JLabel jLabelSudut = new JLabel("Sudut Lancip :");
        jLabelSudut.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSudut.setBounds(70, 180, 150, 25);
        add(jLabelSudut);

        jTextFieldSudut.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSudut.setBounds(230, 180, 200, 25);
        add(jTextFieldSudut);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 350, 500, 10);
        add(jSeparator2);

        JButton jButtonsSave = new JButton("Hitung");
        jButtonsSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonsSave.setBounds(55, 370, 100, 30);
        add(jButtonsSave);

        JButton jButtonReset = new JButton("Reset");
        jButtonReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonReset.setBounds(195, 370, 100, 30);
        add(jButtonReset);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(335, 370, 100, 30);
        add(jButtonClose);

        cek();

        jButtonsSave.addActionListener(e -> {
            try {
                double alas = Double.parseDouble(jTextFieldAlas.getText());
                double tinggi = Double.parseDouble(jTextFieldTinggi.getText());
                double sudut = Double.parseDouble(jTextFieldSudut.getText());
                if (alas <= 0 || tinggi <= 0 || sudut <=0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                JajarGenjang newJg = new JajarGenjang(alas, tinggi, sudut); //

                Thread calcThread = new Thread(newJg);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilJajarGenjangView(newJg).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldAlas.setText("");
            jTextFieldTinggi.setText("");
            jTextFieldSudut.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (jajarGenjang != null) {
            jTextFieldAlas.setText(String.valueOf(jajarGenjang.alas)); //
            jTextFieldTinggi.setText(String.valueOf(jajarGenjang.tinggi)); //
            jTextFieldSudut.setText(String.valueOf(jajarGenjang.sudutLancip)); //
        }
    }
}