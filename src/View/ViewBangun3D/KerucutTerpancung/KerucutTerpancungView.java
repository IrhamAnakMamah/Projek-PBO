package View.ViewBangun3D.KerucutTerpancung;

import Benda3D.KerucutTerpancung;
import javax.swing.*;
import java.awt.*;

public class KerucutTerpancungView extends JFrame {

    KerucutTerpancung kerucutTerpancung;
    JTextField jTextFieldTinggi = new JTextField();
    JTextField jTextFieldJariAtas = new JTextField();
    JTextField jTextFieldJariBawah = new JTextField();

    public KerucutTerpancungView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Kerucut Terpancung");
    }

    public KerucutTerpancungView(KerucutTerpancung kerucutTerpancung) {
        this.kerucutTerpancung = kerucutTerpancung;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Kerucut Terpancung");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("KERUCUT TERPANCUNG");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(50, 20, 400, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelTinggi = new JLabel("Tinggi :");
        jLabelTinggi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTinggi.setBounds(70, 100, 150, 25);
        add(jLabelTinggi);
        jTextFieldTinggi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTinggi.setBounds(230, 100, 200, 25);
        add(jTextFieldTinggi);

        JLabel jLabelJariAtas = new JLabel("Jari-Jari Atas (r) :");
        jLabelJariAtas.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelJariAtas.setBounds(70, 140, 150, 25);
        add(jLabelJariAtas);
        jTextFieldJariAtas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldJariAtas.setBounds(230, 140, 200, 25);
        add(jTextFieldJariAtas);

        JLabel jLabelJariBawah = new JLabel("Jari-Jari Bawah (R) :");
        jLabelJariBawah.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelJariBawah.setBounds(70, 180, 150, 25);
        add(jLabelJariBawah);
        jTextFieldJariBawah.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldJariBawah.setBounds(230, 180, 200, 25);
        add(jTextFieldJariBawah);

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
                double tinggi = Double.parseDouble(jTextFieldTinggi.getText());
                double jariAtas = Double.parseDouble(jTextFieldJariAtas.getText());
                double jariBawah = Double.parseDouble(jTextFieldJariBawah.getText());
                if (tinggi <= 0 || jariAtas <= 0 || jariBawah <=0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                KerucutTerpancung newKt = new KerucutTerpancung(tinggi, jariAtas, jariBawah); //

                Thread calcThread = new Thread(newKt);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilKerucutTerpancungView(newKt).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldTinggi.setText("");
            jTextFieldJariAtas.setText("");
            jTextFieldJariBawah.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (kerucutTerpancung != null) {
            jTextFieldTinggi.setText(String.valueOf(kerucutTerpancung.getTinggi()));
            jTextFieldJariAtas.setText(String.valueOf(kerucutTerpancung.getJariJariAtas()));
            jTextFieldJariBawah.setText(String.valueOf(kerucutTerpancung.getJariJari()));
        }
    }
}