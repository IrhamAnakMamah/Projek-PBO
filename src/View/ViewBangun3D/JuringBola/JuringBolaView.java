package View.ViewBangun3D.JuringBola;

import Benda3D.JuringBola;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;

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

        addSeparator(0, 70);
        addLabelAndText("Jari-Jari Bola (R):", jTextFieldJari, 100);
        addLabelAndText("Sudut (theta):", jTextFieldTheta, 140);
        addSeparator(0, 300);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnHitung.setBounds(55, 320, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnReset.setBounds(195, 320, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnClose.setBounds(335, 320, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputJari = jTextFieldJari.getText();
                String inputTheta = jTextFieldTheta.getText();

                // Validasi input kosong
                if (inputJari.isEmpty() || inputTheta.isEmpty()) {
                    throw new IllegalArgumentException("Semua input harus diisi!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputJari);
                new ValidasiFormatAngka().operasiFormatAngka(inputTheta);

                // Konversi
                double r = Double.parseDouble(inputJari);
                double t = Double.parseDouble(inputTheta);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(r);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(t);

                // Jalankan perhitungan
                JuringBola newJb = new JuringBola(r, t);
                Thread thread = new Thread(new HitungBendaTask(newJb));
                thread.start();
                thread.join();

                new HasilJuringBolaView(newJb).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldJari.setText("");
            jTextFieldTheta.setText("");
        });

        btnClose.addActionListener(e -> dispose());
    }

    private void addLabelAndText(String labelText, JTextField field, int y) {
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
        if (juringBola != null) {
            jTextFieldJari.setText(String.valueOf(juringBola.getJariJari()));
            jTextFieldTheta.setText(String.valueOf(juringBola.getTheta()));
        }
    }
}
