package View.ViewBangun3D.CincinBola;

import Benda3D.CincinBola;
import javax.swing.*;
import java.awt.*;

public class CincinBolaView extends JFrame {

    CincinBola cincinBola;
    JTextField jTextFieldJariBesar = new JTextField();
    JTextField jTextFieldJariKecil = new JTextField();
    JTextField jTextFieldJarak = new JTextField();

    public CincinBolaView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Cincin Bola");
    }

    public CincinBolaView(CincinBola cincinBola) {
        this.cincinBola = cincinBola;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Cincin Bola");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("CINCIN BOLA");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(140, 20, 300, 37);
        add(jLabelTitle);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBounds(0, 70, 500, 10);
        add(jSeparator1);

        JLabel jLabelJariBesar = new JLabel("Jari-Jari Bola (R) :");
        jLabelJariBesar.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelJariBesar.setBounds(70, 100, 150, 25);
        add(jLabelJariBesar);
        jTextFieldJariBesar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldJariBesar.setBounds(230, 100, 200, 25);
        add(jTextFieldJariBesar);

        JLabel jLabelJariKecil = new JLabel("Jari-Jari Dalam (r) :");
        jLabelJariKecil.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelJariKecil.setBounds(70, 140, 150, 25);
        add(jLabelJariKecil);
        jTextFieldJariKecil.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldJariKecil.setBounds(230, 140, 200, 25);
        add(jTextFieldJariKecil);

        JLabel jLabelJarak = new JLabel("Jarak 2 Bidang (t) :");
        jLabelJarak.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelJarak.setBounds(70, 180, 150, 25);
        add(jLabelJarak);
        jTextFieldJarak.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldJarak.setBounds(230, 180, 200, 25);
        add(jTextFieldJarak);

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
                double rBesar = Double.parseDouble(jTextFieldJariBesar.getText());
                double rKecil = Double.parseDouble(jTextFieldJariKecil.getText());
                double jarak = Double.parseDouble(jTextFieldJarak.getText());
                if (rBesar <= 0 || rKecil <= 0 || jarak <=0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                CincinBola newCb = new CincinBola(rBesar, rKecil, jarak); //

                Thread calcThread = new Thread(newCb);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilCincinBolaView(newCb).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldJariBesar.setText("");
            jTextFieldJariKecil.setText("");
            jTextFieldJarak.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (cincinBola != null) {
            jTextFieldJariBesar.setText(String.valueOf(cincinBola.getJariJari()));
            jTextFieldJariKecil.setText(String.valueOf(cincinBola.getJariJariDalam()));
            jTextFieldJarak.setText(String.valueOf(cincinBola.getJarakDuaBidang()));
            // jariJariDalam dan jarakDuaBidang private tanpa getter
        }
    }
}