package View.ViewBangun2D.JuringLingkaran;

import Benda2D.JuringLingkaran;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;

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

        addSeparator(0, 70);
        addLabelAndText("Jari-Jari:", jTextFieldJari, 100);
        addLabelAndText("Sudut (derajat):", jTextFieldSudut, 140);
        addSeparator(0, 300);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setBounds(55, 320, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(195, 320, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(335, 320, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputJari = jTextFieldJari.getText();
                String inputSudut = jTextFieldSudut.getText();

                // Validasi input kosong
                if (inputJari.isEmpty() || inputSudut.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputJari);
                new ValidasiFormatAngka().operasiFormatAngka(inputSudut);

                // Konversi setelah validasi
                double jari = Double.parseDouble(inputJari);
                double sudut = Double.parseDouble(inputSudut);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(jari);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(sudut);

                // Validasi logika untuk sudut
                if (sudut > 360) {
                    throw new IllegalArgumentException("Sudut tidak boleh lebih dari 360 derajat.");
                }

                // Jalankan perhitungan pada thread
                JuringLingkaran newJl = new JuringLingkaran(jari, sudut);
                Thread thread = new Thread(new HitungBendaTask(newJl));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilJuringLingkaranView(newJl).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldJari.setText("");
            jTextFieldSudut.setText("");
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
        if (juringLingkaran != null) {
            // Diasumsikan kelas JuringLingkaran memiliki getter untuk properti
            jTextFieldJari.setText(String.valueOf(juringLingkaran.getJariJari()));
            jTextFieldSudut.setText(String.valueOf(juringLingkaran.sudut));
        }
    }
}