package View.ViewBangun3D.PrismaSegitiga;

import Benda3D.PrismaSegitiga;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;
// Diasumsikan ada kelas HasilPrismaSegitigaView di package yang sesuai
//import View.ViewBangun3D.Hasil.HasilPrismaSegitigaView;

import javax.swing.*;
import java.awt.*;

public class PrismaSegitigaView extends JFrame {

    PrismaSegitiga prisma;
    JTextField jTextFieldAlas = new JTextField();
    JTextField jTextFieldTinggiAlas = new JTextField();
    JTextField jTextFieldTinggiPrisma = new JTextField();

    public PrismaSegitigaView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Segitiga");
    }

    public PrismaSegitigaView(PrismaSegitiga prisma) {
        this.prisma = prisma;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Segitiga");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PRISMA SEGITIGA");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(100, 20, 300, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Alas Segitiga:", jTextFieldAlas, 100);
        addLabelAndText("Tinggi Alas:", jTextFieldTinggiAlas, 140);
        addLabelAndText("Tinggi Prisma:", jTextFieldTinggiPrisma, 180);
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
                String inputAlas = jTextFieldAlas.getText();
                String inputTinggiAlas = jTextFieldTinggiAlas.getText();
                String inputTinggiPrisma = jTextFieldTinggiPrisma.getText();

                // Validasi input kosong
                if (inputAlas.isEmpty() || inputTinggiAlas.isEmpty() || inputTinggiPrisma.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputAlas);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggiAlas);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggiPrisma);

                // Konversi setelah validasi
                double alas = Double.parseDouble(inputAlas);
                double tinggiAlas = Double.parseDouble(inputTinggiAlas);
                double tinggiPrisma = Double.parseDouble(inputTinggiPrisma);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(alas);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggiAlas);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggiPrisma);

                // Jalankan perhitungan pada thread
                PrismaSegitiga newPrisma = new PrismaSegitiga(alas, tinggiAlas, tinggiPrisma);
                Thread thread = new Thread(new HitungBendaTask(newPrisma));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilPrismaSegitigaView(newPrisma).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldAlas.setText("");
            jTextFieldTinggiAlas.setText("");
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
            // Diasumsikan kelas PrismaSegitiga dan parent-nya memiliki getter ini
            jTextFieldAlas.setText(String.valueOf(prisma.sisi));
            jTextFieldTinggiAlas.setText(String.valueOf(prisma.tinggi));
            jTextFieldTinggiPrisma.setText(String.valueOf(prisma.getTinggiPrismaSegitiga()));
        }
    }
}