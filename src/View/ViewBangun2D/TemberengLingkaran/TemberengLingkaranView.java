package View.ViewBangun2D.TemberengLingkaran;

import Benda2D.TemberengLingkaran;
import javax.swing.*;
import java.awt.*;

public class TemberengLingkaranView extends JFrame {

    TemberengLingkaran temberengLingkaran;
    JTextField jTextFieldJari = new JTextField();
    JTextField jTextFieldTaliBusur = new JTextField();
    JTextField jTextFieldSudut = new JTextField();
    JTextField jTextFieldBusur = new JTextField();

    public TemberengLingkaranView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Tembereng Lingkaran");
    }

    public TemberengLingkaranView(TemberengLingkaran temberengLingkaran) {
        this.temberengLingkaran = temberengLingkaran;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Tembereng Lingkaran");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("TEMBERENG LINGKARAN");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(30, 20, 440, 37);
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

        JLabel jLabelTaliBusur = new JLabel("Panjang Tali Busur :");
        jLabelTaliBusur.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelTaliBusur.setBounds(70, 140, 150, 25);
        add(jLabelTaliBusur);
        jTextFieldTaliBusur.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldTaliBusur.setBounds(230, 140, 200, 25);
        add(jTextFieldTaliBusur);

        JLabel jLabelSudut = new JLabel("Sudut (radian) :");
        jLabelSudut.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelSudut.setBounds(70, 180, 150, 25);
        add(jLabelSudut);
        jTextFieldSudut.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldSudut.setBounds(230, 180, 200, 25);
        add(jTextFieldSudut);

        JLabel jLabelBusur = new JLabel("Panjang Busur :");
        jLabelBusur.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabelBusur.setBounds(70, 220, 150, 25);
        add(jLabelBusur);
        jTextFieldBusur.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jTextFieldBusur.setBounds(230, 220, 200, 25);
        add(jTextFieldBusur);

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
                double jari = Double.parseDouble(jTextFieldJari.getText());
                double taliBusur = Double.parseDouble(jTextFieldTaliBusur.getText());
                double sudut = Double.parseDouble(jTextFieldSudut.getText());
                double busur = Double.parseDouble(jTextFieldBusur.getText());
                if (jari <= 0 || taliBusur <= 0 || sudut <= 0 || busur <= 0) {
                    throw new NumberFormatException("Input tidak boleh nol atau negatif!");
                }
                TemberengLingkaran newTl = new TemberengLingkaran(jari, taliBusur, sudut, busur); //

                Thread calcThread = new Thread(newTl);
                calcThread.start();
                try {
                    calcThread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                new HasilTemberengLingkaranView(newTl).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldJari.setText("");
            jTextFieldTaliBusur.setText("");
            jTextFieldSudut.setText("");
            jTextFieldBusur.setText("");
        });
        jButtonClose.addActionListener(e -> dispose());
    }

    void cek() {
        if (temberengLingkaran != null) {
            // Karena properti di TemberengLingkaran private, kita tidak bisa akses langsung
            // Untuk fungsionalitas edit yang sempurna, properti di Benda2D perlu getter
            // atau diubah menjadi public/protected.
            // Di sini kita asumsikan tidak bisa akses, jadi field edit akan kosong.
        }
    }
}