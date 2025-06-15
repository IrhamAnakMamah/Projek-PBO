package View.ViewBangun2D.Persegi;

import Benda2D.Persegi;
import javax.swing.*;
import java.awt.*;

public class PersegiView extends JFrame {

    Persegi persegi;
    JTextField jTextFieldSisi = new JTextField();

    public PersegiView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Persegi");
    }

    public PersegiView(Persegi persegi) {
        this.persegi = persegi;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Persegi");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 350);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PERSEGI");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(180, 20, 200, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelSisi = new JLabel("Sisi :");
        jLabelSisi.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSisi.setBounds(70, 100, 150, 25);
        add(jLabelSisi);

        jTextFieldSisi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSisi.setBounds(230, 100, 200, 25);
        add(jTextFieldSisi);

        JSeparator jSeparator2 = new JSeparator();
        jSeparator2.setBounds(0, 250, 500, 10);
        add(jSeparator2);

        JButton jButtonsSave = new JButton("Hitung");
        jButtonsSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonsSave.setBounds(55, 270, 100, 30);
        add(jButtonsSave);

        JButton jButtonReset = new JButton("Reset");
        jButtonReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonReset.setBounds(195, 270, 100, 30);
        add(jButtonReset);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(335, 270, 100, 30);
        add(jButtonClose);

        cek();

        jButtonsSave.addActionListener(e -> {
            try {
                double sisi = Double.parseDouble(jTextFieldSisi.getText());
                if (sisi <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                Persegi newPersegi = new Persegi(sisi);

                Thread calcThread = new Thread(newPersegi);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilPersegiView(newPersegi).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> jTextFieldSisi.setText(""));
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek(){
        if(persegi != null){
            jTextFieldSisi.setText(String.valueOf(persegi.sisi));
        }
    }
}