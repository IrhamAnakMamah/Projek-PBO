package View.ViewBangun3D.CincinBola;

import Benda3D.CincinBola;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;

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

        addSeparator(0, 70);
        addLabelAndText("Jari-Jari Bola (R):", jTextFieldJariBesar, 100);
        addLabelAndText("Jari-Jari Dalam (r):", jTextFieldJariKecil, 140);
        addLabelAndText("Jarak 2 Bidang (t):", jTextFieldJarak, 180);
        addSeparator(0, 350);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnHitung.setBounds(55, 370, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnReset.setBounds(195, 370, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnClose.setBounds(335, 370, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputRBesar = jTextFieldJariBesar.getText();
                String inputRKecil = jTextFieldJariKecil.getText();
                String inputJarak = jTextFieldJarak.getText();

                // Validasi input kosong
                if (inputRBesar.isEmpty() || inputRKecil.isEmpty() || inputJarak.isEmpty()) {
                    throw new IllegalArgumentException("Semua input harus diisi!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputRBesar);
                new ValidasiFormatAngka().operasiFormatAngka(inputRKecil);
                new ValidasiFormatAngka().operasiFormatAngka(inputJarak);

                // Parsing
                double rBesar = Double.parseDouble(inputRBesar);
                double rKecil = Double.parseDouble(inputRKecil);
                double jarak = Double.parseDouble(inputJarak);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(rBesar);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(rKecil);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(jarak);

                // Hitung dengan thread
                CincinBola newCb = new CincinBola(rBesar, rKecil, jarak);
                Thread thread = new Thread(new HitungBendaTask(newCb));
                thread.start();
                thread.join();

                new HasilCincinBolaView(newCb).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldJariBesar.setText("");
            jTextFieldJariKecil.setText("");
            jTextFieldJarak.setText("");
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
        if (cincinBola != null) {
            jTextFieldJariBesar.setText(String.valueOf(cincinBola.getJariJari()));
            jTextFieldJariKecil.setText(String.valueOf(cincinBola.getJariJariDalam()));
            jTextFieldJarak.setText(String.valueOf(cincinBola.getJarakDuaBidang()));
        }
    }
}
