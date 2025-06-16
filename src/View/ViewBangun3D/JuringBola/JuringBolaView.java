package View.ViewBangun3D.JuringBola;

import Benda3D.JuringBola;
import javax.swing.*;
import java.awt.*;

public class JuringBolaView extends JFrame {

    JuringBola juringBola;
    JTextField jTextFieldJari = new JTextField();
    JTextField jTextFieldTheta = new JTextField();

    public JuringBolaView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Juring Bola");
    }

    public JuringBolaView(JuringBola juringBola) {
        this.juringBola = juringBola;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Juring Bola");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("JURING BOLA");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(140, 20, 320, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelJari = new JLabel("Jari-Jari Bola (R):");
        jLabelJari.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelJari.setBounds(70, 100, 150, 25);
        add(jLabelJari);
        jTextFieldJari.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldJari.setBounds(230, 100, 200, 25);
        add(jTextFieldJari);

        JLabel jLabelTheta = new JLabel("Sudut (theta) :");
        jLabelTheta.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTheta.setBounds(70, 140, 160, 25);
        add(jLabelTheta);
        jTextFieldTheta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTheta.setBounds(230, 140, 200, 25);
        add(jTextFieldTheta);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 300, 500, 10);
        add(jSeparator2);

        JButton jButtonsSave = new JButton("Hitung");
        jButtonsSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonsSave.setBounds(55, 320, 100, 30);
        add(jButtonsSave);

        JButton jButtonReset = new JButton("Reset");
        jButtonReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonReset.setBounds(195, 320, 100, 30);
        add(jButtonReset);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(335, 320, 100, 30);
        add(jButtonClose);

        cek();

        jButtonsSave.addActionListener(e -> {
            try {
                double r = Double.parseDouble(jTextFieldJari.getText());
                double t = Double.parseDouble(jTextFieldTheta.getText());
                if (r <= 0 || t <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                JuringBola newJb = new JuringBola(r,t); //

                Thread calcThread = new Thread(newJb);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilJuringBolaView(newJb).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldJari.setText("");
            jTextFieldTheta.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (juringBola != null) {
            jTextFieldJari.setText(String.valueOf(juringBola.getJariJari()));
            jTextFieldTheta.setText(String.valueOf(juringBola.getTheta()));
        }
    }

    public static void main(String[] args) {
        new JuringBolaView().setVisible(true);
    }
}