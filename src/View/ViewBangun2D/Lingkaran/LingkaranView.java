package View.ViewBangun2D.Lingkaran;

import Benda2D.Lingkaran;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;

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

        addSeparator(0, 70);
        addLabelAndText("Jari-Jari:", jTextFieldJariJari, 100);
        addSeparator(0, 250);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setBounds(55, 270, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(195, 270, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(335, 270, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputJari = jTextFieldJariJari.getText();

                // Validasi input kosong
                if (inputJari.isEmpty()) {
                    throw new IllegalArgumentException("Input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputJari);

                // Konversi setelah validasi
                double jariJari = Double.parseDouble(inputJari);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(jariJari);

                // Jalankan perhitungan pada thread
                Lingkaran newLingkaran = new Lingkaran(jariJari);
                Thread thread = new Thread(new HitungBendaTask(newLingkaran));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilLingkaranView(newLingkaran).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> jTextFieldJariJari.setText(""));

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
        if (lingkaran != null) {
            jTextFieldJariJari.setText(String.valueOf(lingkaran.getJariJari()));
        }
    }
}