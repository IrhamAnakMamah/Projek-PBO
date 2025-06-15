package View.ViewBangun2D.Lingkaran;

import Benda2D.Lingkaran;
import javax.swing.*;
import java.awt.*;

public class LingkaranView extends JFrame {

    Lingkaran lingkaran;
    JTextField jTextFieldJariJari = new JTextField();

    public LingkaranView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Lingkaran");
    }

    public LingkaranView(Lingkaran lingkaran) {
        this.lingkaran = lingkaran;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Lingkaran");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 350);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("LINGKARAN");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(150, 20, 200, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelJariJari = new JLabel("Jari-Jari :");
        jLabelJariJari.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelJariJari.setBounds(70, 100, 150, 25);
        add(jLabelJariJari);

        jTextFieldJariJari.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldJariJari.setBounds(230, 100, 200, 25);
        add(jTextFieldJariJari);

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
                double jariJari = Double.parseDouble(jTextFieldJariJari.getText());
                if (jariJari <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                Lingkaran newLingkaran = new Lingkaran(jariJari);

                Thread calcThread = new Thread(newLingkaran);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilLingkaranView(newLingkaran).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> jTextFieldJariJari.setText(""));
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (lingkaran != null) {
            jTextFieldJariJari.setText(String.valueOf(lingkaran.getJariJari()));
        }
    }
}