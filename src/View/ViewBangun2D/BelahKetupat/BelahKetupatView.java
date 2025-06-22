package View.ViewBangun2D.BelahKetupat;

import Benda2D.BelahKetupat;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;

import javax.swing.*;
import java.awt.*;

public class BelahKetupatView extends JFrame {

    BelahKetupat belahKetupat;
    JTextField jTextFieldD1 = new JTextField();
    JTextField jTextFieldD2 = new JTextField();

    public BelahKetupatView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Belah Ketupat");
    }

    public BelahKetupatView(BelahKetupat belahKetupat) {
        this.belahKetupat = belahKetupat;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Belah Ketupat");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("BELAH KETUPAT");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(110, 20, 300, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndField("Diagonal 1 :", jTextFieldD1, 100);
        addLabelAndField("Diagonal 2 :", jTextFieldD2, 140);
        addSeparator(0, 300);

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
                String inputD1 = jTextFieldD1.getText();
                String inputD2 = jTextFieldD2.getText();

                // Validasi kosong
                if (inputD1.isEmpty() || inputD2.isEmpty()) {
                    throw new IllegalArgumentException("Semua input harus diisi!");
                }

                // Validasi format
                new ValidasiFormatAngka().operasiFormatAngka(inputD1);
                new ValidasiFormatAngka().operasiFormatAngka(inputD2);

                double d1 = Double.parseDouble(inputD1);
                double d2 = Double.parseDouble(inputD2);

                // Validasi negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(d1);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(d2);

                // Hitung dalam thread
                BelahKetupat newBk = new BelahKetupat(d1, d2);
                Thread thread = new Thread(new HitungBendaTask(newBk));
                thread.start();
                thread.join();

                new HasilBelahKetupatView(newBk).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldD1.setText("");
            jTextFieldD2.setText("");
        });

        jButtonClose.addActionListener(e -> dispose());
    }

    private void addLabelAndField(String labelText, JTextField field, int y) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setBounds(70, y, 150, 25);
        add(label);

        field.setFont(new Font("Tahoma", Font.PLAIN, 14));
        field.setBounds(230, y, 200, 25);
        add(field);
    }

    private void addSeparator(int x, int y) {
        JSeparator separator = new JSeparator();
        separator.setBounds(x, y, 500, 10);
        add(separator);
    }

    void cek() {
        if (belahKetupat != null) {
            jTextFieldD1.setText(String.valueOf(belahKetupat.diagonal1));
            jTextFieldD2.setText(String.valueOf(belahKetupat.diagonal2));
        }
    }
}
