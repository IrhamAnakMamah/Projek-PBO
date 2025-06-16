package View.ViewBangun3D.Bola;

import Benda3D.Bola;
import javax.swing.*;
import java.awt.*;

public class BolaView extends JFrame {

    Bola bola;
    JTextField jTextFieldJari = new JTextField();

    public BolaView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Bola");
    }

    public BolaView(Bola bola) {
        this.bola = bola;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Bola");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 350);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("BOLA");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(200, 20, 100, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelJari = new JLabel("Jari-Jari :");
        jLabelJari.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelJari.setBounds(70, 100, 150, 25);
        add(jLabelJari);

        jTextFieldJari.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldJari.setBounds(230, 100, 200, 25);
        add(jTextFieldJari);

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
                double jari = Double.parseDouble(jTextFieldJari.getText());
                if (jari <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                Bola newBola = new Bola(jari); //

                Thread calcThread = new Thread(newBola);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilBolaView(newBola).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> jTextFieldJari.setText(""));
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek(){
        if(bola != null){
            jTextFieldJari.setText(String.valueOf(bola.getJariJari()));
        }
    }

    public static void main(String[] args) {
        new  BolaView().setVisible(true);
    }
}