package View.ViewBangun3D.Bola;

import Benda3D.Bola;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;
// Diasumsikan ada kelas HasilBolaView di package ini atau diimpor dengan benar
//import View.ViewBangun3D.Bola.HasilBolaView;

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
        // Ukuran frame disesuaikan karena input lebih sedikit
        setSize(500, 350);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("BOLA");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(200, 20, 300, 37); // Posisi X disesuaikan
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Jari-Jari:", jTextFieldJari, 100);
        // Posisi separator dan tombol disesuaikan
        addSeparator(0, 220);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setBounds(55, 250, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(195, 250, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(335, 250, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputJari = jTextFieldJari.getText();

                // Validasi input kosong
                if (inputJari.isEmpty()) {
                    throw new IllegalArgumentException("Input tidak boleh kosong!");
                }

                // Validasi format angka (throw NumberFormatException)
                new ValidasiFormatAngka().operasiFormatAngka(inputJari);

                // Konversi setelah validasi format
                double jari = Double.parseDouble(inputJari);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(jari);

                // Jalankan perhitungan pada thread
                Bola newBola = new Bola(jari);
                Thread thread = new Thread(new HitungBendaTask(newBola));
                thread.start();
                thread.join();

                // Menampilkan hasil menggunakan HasilBolaView
                new HasilBolaView(newBola).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldJari.setText("");
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
        if (bola != null) {
            jTextFieldJari.setText(String.valueOf(bola.getJariJari()));
        }
    }
}