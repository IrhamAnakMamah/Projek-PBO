package View.ViewBangun3D.PrismaBelahKetupat;

import Benda3D.PrismaBelahKetupat;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;
// Diasumsikan ada kelas HasilPrismaBelahKetupatView di package yang sesuai
//import View.ViewBangun3D.Hasil.HasilPrismaBelahKetupatView;

import javax.swing.*;
import java.awt.*;

public class PrismaBelahKetupatView extends JFrame {

    PrismaBelahKetupat prisma;
    JTextField jTextFieldD1 = new JTextField();
    JTextField jTextFieldD2 = new JTextField();
    JTextField jTextFieldTinggiPrisma = new JTextField();
    JTextField jTextFieldSisi = new JTextField();

    public PrismaBelahKetupatView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Belah Ketupat");
    }

    public PrismaBelahKetupatView(PrismaBelahKetupat prisma) {
        this.prisma = prisma;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Belah Ketupat");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PRISMA BELAH KETUPAT");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(40, 20, 420, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Diagonal 1 Alas (d1):", jTextFieldD1, 100);
        addLabelAndText("Diagonal 2 Alas (d2):", jTextFieldD2, 140);
        addLabelAndText("Sisi Alas:", jTextFieldSisi, 180);
        addLabelAndText("Tinggi Prisma:", jTextFieldTinggiPrisma, 220);
        addSeparator(0, 400);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setBounds(55, 420, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(195, 420, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(335, 420, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputD1 = jTextFieldD1.getText();
                String inputD2 = jTextFieldD2.getText();
                String inputSisi = jTextFieldSisi.getText();
                String inputTinggi = jTextFieldTinggiPrisma.getText();

                // Validasi input kosong
                if (inputD1.isEmpty() || inputD2.isEmpty() || inputSisi.isEmpty() || inputTinggi.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputD1);
                new ValidasiFormatAngka().operasiFormatAngka(inputD2);
                new ValidasiFormatAngka().operasiFormatAngka(inputSisi);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggi);

                // Konversi setelah validasi
                double d1 = Double.parseDouble(inputD1);
                double d2 = Double.parseDouble(inputD2);
                double sisi = Double.parseDouble(inputSisi);
                double tinggi = Double.parseDouble(inputTinggi);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(d1);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(d2);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(sisi);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggi);

                // Validasi logika: sisi harus lebih besar dari setengah diagonal manapun
                if (sisi <= d1 / 2 || sisi <= d2 / 2) {
                    throw new IllegalArgumentException("Sisi alas tidak valid untuk membentuk belah ketupat dengan diagonal tersebut.");
                }

                // Jalankan perhitungan pada thread
                PrismaBelahKetupat newPrisma = new PrismaBelahKetupat(d1, d2, tinggi, sisi);
                Thread thread = new Thread(new HitungBendaTask(newPrisma));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilPrismaBelahKetupatView(newPrisma).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldD1.setText("");
            jTextFieldD2.setText("");
            jTextFieldSisi.setText("");
            jTextFieldTinggiPrisma.setText("");
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
        if (prisma != null) {
            // Diasumsikan kelas PrismaBelahKetupat dan parent-nya memiliki getter ini
            jTextFieldD1.setText(String.valueOf(prisma.diagonal1));
            jTextFieldD2.setText(String.valueOf(prisma.diagonal2));
            jTextFieldSisi.setText(String.valueOf(prisma.getSisiPrisma()));
            jTextFieldTinggiPrisma.setText(String.valueOf(prisma.getTinggiPrisma()));
        }
    }
}