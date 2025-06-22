package View.ViewBangun3D.PrismaPersegiPanjang;

import Benda3D.PrismaPersegiPanjang;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;
// Diasumsikan ada kelas HasilPrismaPersegiPanjangView di package yang sesuai
//import View.ViewBangun3D.Hasil.HasilPrismaPersegiPanjangView;

import javax.swing.*;
import java.awt.*;

public class PrismaPersegiPanjangView extends JFrame {

    PrismaPersegiPanjang balok;
    JTextField jTextFieldPanjang = new JTextField();
    JTextField jTextFieldLebar = new JTextField();
    JTextField jTextFieldTinggi = new JTextField();

    public PrismaPersegiPanjangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Balok");
    }

    public PrismaPersegiPanjangView(PrismaPersegiPanjang balok) {
        this.balok = balok;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Balok");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("BALOK");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(190, 20, 300, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Panjang:", jTextFieldPanjang, 100);
        addLabelAndText("Lebar:", jTextFieldLebar, 140);
        addLabelAndText("Tinggi:", jTextFieldTinggi, 180);
        addSeparator(0, 350);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setBounds(55, 370, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(195, 370, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(335, 370, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputPanjang = jTextFieldPanjang.getText();
                String inputLebar = jTextFieldLebar.getText();
                String inputTinggi = jTextFieldTinggi.getText();

                // Validasi input kosong
                if (inputPanjang.isEmpty() || inputLebar.isEmpty() || inputTinggi.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputPanjang);
                new ValidasiFormatAngka().operasiFormatAngka(inputLebar);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggi);

                // Konversi setelah validasi
                double panjang = Double.parseDouble(inputPanjang);
                double lebar = Double.parseDouble(inputLebar);
                double tinggi = Double.parseDouble(inputTinggi);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(panjang);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(lebar);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggi);

                // Validasi logika: jika semua sisi sama, itu adalah kubus
                if (panjang == lebar && lebar == tinggi) {
                    throw new IllegalArgumentException("Semua sisi sama (itu adalah Kubus/Prisma Persegi).");
                }

                // Jalankan perhitungan pada thread
                PrismaPersegiPanjang newBalok = new PrismaPersegiPanjang(panjang, lebar, tinggi);
                Thread thread = new Thread(new HitungBendaTask(newBalok));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilPrismaPersegiPanjangView(newBalok).setVisible(true);
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
            jTextFieldTinggi.setText("");
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
        if (balok != null) {
            // Diasumsikan kelas PrismaPersegiPanjang dan parent-nya memiliki getter ini
            jTextFieldPanjang.setText(String.valueOf(balok.panjang));
            jTextFieldLebar.setText(String.valueOf(balok.lebar));
            jTextFieldTinggi.setText(String.valueOf(balok.getTinggiBalok()));
        }
    }
}