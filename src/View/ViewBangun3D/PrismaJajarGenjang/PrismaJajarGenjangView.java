package View.ViewBangun3D.PrismaJajarGenjang;

import Benda3D.PrismaJajarGenjang;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;
// Diasumsikan ada kelas HasilPrismaJajarGenjangView di package yang sesuai
//import View.ViewBangun3D.Hasil.HasilPrismaJajarGenjangView;

import javax.swing.*;
import java.awt.*;

public class PrismaJajarGenjangView extends JFrame {

    PrismaJajarGenjang prisma;
    JTextField jTextFieldAlas = new JTextField();
    JTextField jTextFieldTinggiAlas = new JTextField();
    JTextField jTextFieldSisiMiring = new JTextField();
    JTextField jTextFieldSudut = new JTextField();
    JTextField jTextFieldTinggiPrisma = new JTextField();


    public PrismaJajarGenjangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Jajar Genjang");
    }

    public PrismaJajarGenjangView(PrismaJajarGenjang prisma) {
        this.prisma = prisma;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Jajar Genjang");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 550);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PRISMA JAJAR GENJANG");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(50, 20, 400, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Alas Jajar Genjang:", jTextFieldAlas, 100);
        addLabelAndText("Sisi Miring Alas:", jTextFieldSisiMiring, 140);
        addLabelAndText("Tinggi Alas:", jTextFieldTinggiAlas, 180);
        addLabelAndText("Sudut Lancip Alas (°):", jTextFieldSudut, 220);
        addLabelAndText("Tinggi Prisma:", jTextFieldTinggiPrisma, 260);
        addSeparator(0, 450);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setBounds(55, 470, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(195, 470, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(335, 470, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputAlas = jTextFieldAlas.getText();
                String inputSisiMiring = jTextFieldSisiMiring.getText();
                String inputTinggiAlas = jTextFieldTinggiAlas.getText();
                String inputSudut = jTextFieldSudut.getText();
                String inputTinggiPrisma = jTextFieldTinggiPrisma.getText();

                // Validasi input kosong
                if (inputAlas.isEmpty() || inputSisiMiring.isEmpty() || inputTinggiAlas.isEmpty() ||
                        inputSudut.isEmpty() || inputTinggiPrisma.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputAlas);
                new ValidasiFormatAngka().operasiFormatAngka(inputSisiMiring);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggiAlas);
                new ValidasiFormatAngka().operasiFormatAngka(inputSudut);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggiPrisma);

                // Konversi setelah validasi
                double alas = Double.parseDouble(inputAlas);
                double sisiMiring = Double.parseDouble(inputSisiMiring);
                double tinggiAlas = Double.parseDouble(inputTinggiAlas);
                double sudut = Double.parseDouble(inputSudut);
                double tinggiPrisma = Double.parseDouble(inputTinggiPrisma);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(alas);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(sisiMiring);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggiAlas);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(sudut);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggiPrisma);

                // Validasi logika
                if (sudut <= 0 || sudut >= 90) {
                    throw new IllegalArgumentException("Sudut lancip harus lebih dari 0 dan kurang dari 90 derajat.");
                }
                if (tinggiAlas > sisiMiring) {
                    throw new IllegalArgumentException("Tinggi alas tidak boleh lebih besar dari sisi miringnya.");
                }

                // Jalankan perhitungan pada thread
                PrismaJajarGenjang newPrisma = new PrismaJajarGenjang(alas, tinggiAlas, sudut, tinggiPrisma, sisiMiring);
                Thread thread = new Thread(new HitungBendaTask(newPrisma));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilPrismaJajarGenjangView(newPrisma).setVisible(true);
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
            jTextFieldSisiMiring.setText("");
            jTextFieldSudut.setText("");
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
            // Diasumsikan kelas PrismaJajarGenjang dan parent-nya memiliki getter ini
            jTextFieldAlas.setText(String.valueOf(prisma.alas));
            jTextFieldTinggiAlas.setText(String.valueOf(prisma.tinggi));
            jTextFieldSisiMiring.setText(String.valueOf(prisma.getSisiPrismaJajarGenjang()));
            jTextFieldSudut.setText(String.valueOf(prisma.sudutLancip));
            jTextFieldTinggiPrisma.setText(String.valueOf(prisma.getTinggiPrismaJajarGenjang()));
        }
    }
}