package View.ViewBangun2D.JuringLingkaran;

import Benda2D.JuringLingkaran;
import javax.swing.*;
import java.awt.*;

public class JuringLingkaranView extends JFrame {

    JuringLingkaran juringLingkaran;
    JTextField jTextFieldJari = new JTextField();
    JTextField jTextFieldSudut = new JTextField();

    public JuringLingkaranView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Juring Lingkaran");
    }

    public JuringLingkaranView(JuringLingkaran juringLingkaran) {
        this.juringLingkaran = juringLingkaran;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Juring Lingkaran");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("JURING LINGKARAN");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(80, 20, 340, 37);
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

        JLabel jLabelSudut = new JLabel("Sudut (derajat) :");
        jLabelSudut.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSudut.setBounds(70, 140, 150, 25);
        add(jLabelSudut);
        jTextFieldSudut.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSudut.setBounds(230, 140, 200, 25);
        add(jTextFieldSudut);

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
                double jari = Double.parseDouble(jTextFieldJari.getText());
                double sudut = Double.parseDouble(jTextFieldSudut.getText());
                if (jari <= 0 || sudut <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                JuringLingkaran newJl = new JuringLingkaran(jari, sudut); //

                Thread calcThread = new Thread(newJl);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilJuringLingkaranView(newJl).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldJari.setText("");
            jTextFieldSudut.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (juringLingkaran != null) {
            jTextFieldJari.setText(String.valueOf(juringLingkaran.jariJari));
            jTextFieldSudut.setText(String.valueOf(juringLingkaran.sudut)); //
        }
    }
}