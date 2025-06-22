package View.ViewBangun2D.PersegiPanjang;

import Benda2D.PersegiPanjang;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;

import javax.swing.*;
import java.awt.*;

public class PersegiPanjangView extends JFrame {

    PersegiPanjang persegiPanjang;
    JTextField jTextFieldPanjang = new JTextField();
    JTextField jTextFieldLebar = new JTextField();

    public PersegiPanjangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Persegi Panjang");
    }

    public PersegiPanjangView(PersegiPanjang persegiPanjang) {
        this.persegiPanjang = persegiPanjang;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Persegi Panjang");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PERSEGI PANJANG");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(90, 20, 320, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Panjang:", jTextFieldPanjang, 100);
        addLabelAndText("Lebar:", jTextFieldLebar, 140);
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
                String inputPanjang = jTextFieldPanjang.getText();
                String inputLebar = jTextFieldLebar.getText();

                // Validasi input kosong
                if (inputPanjang.isEmpty() || inputLebar.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputPanjang);
                new ValidasiFormatAngka().operasiFormatAngka(inputLebar);

                // Konversi setelah validasi
                double panjang = Double.parseDouble(inputPanjang);
                double lebar = Double.parseDouble(inputLebar);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(panjang);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(lebar);

                // Validasi logika: panjang dan lebar tidak boleh sama
                if (panjang == lebar) {
                    throw new IllegalArgumentException("Panjang dan Lebar tidak boleh sama (itu adalah Persegi).");
                }

                // Jalankan perhitungan pada thread
                PersegiPanjang newPp = new PersegiPanjang(panjang, lebar);
                Thread thread = new Thread(new HitungBendaTask(newPp));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilPersegiPanjangView(newPp).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldPanjang.setText("");
            jTextFieldLebar.setText("");
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
        if (persegiPanjang != null) {
            jTextFieldPanjang.setText(String.valueOf(persegiPanjang.panjang));
            jTextFieldLebar.setText(String.valueOf(persegiPanjang.lebar));
        }
    }
}