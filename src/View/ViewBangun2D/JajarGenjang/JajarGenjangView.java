package View.ViewBangun2D.JajarGenjang;

import Benda2D.JajarGenjang;
import Exception.ValidasiAngkaNegatif;
import Exception.ValidasiFormatAngka;
import Threading.HitungBendaTask;

import javax.swing.*;
import java.awt.*;

public class JajarGenjangView extends JFrame {

    JajarGenjang jajarGenjang;
    JTextField jTextFieldAlas = new JTextField();
    JTextField jTextFieldTinggi = new JTextField();
    JTextField jTextFieldSudut = new JTextField();

    public JajarGenjangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Jajar Genjang");
    }

    public JajarGenjangView(JajarGenjang jajarGenjang) {
        this.jajarGenjang = jajarGenjang;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Jajar Genjang");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("JAJAR GENJANG");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        jLabelTitle.setBounds(110, 20, 300, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Alas:", jTextFieldAlas, 100);
        addLabelAndText("Tinggi:", jTextFieldTinggi, 140);
        addLabelAndText("Sudut Lancip (°):", jTextFieldSudut, 180);
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
                String inputTinggi = jTextFieldTinggi.getText();
                String inputSudut = jTextFieldSudut.getText();

                // Validasi input kosong
                if (inputAlas.isEmpty() || inputTinggi.isEmpty() || inputSudut.isEmpty()) {
                    throw new IllegalArgumentException("Semua input tidak boleh kosong!");
                }

                // Validasi format angka
                new ValidasiFormatAngka().operasiFormatAngka(inputAlas);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggi);
                new ValidasiFormatAngka().operasiFormatAngka(inputSudut);

                // Konversi setelah validasi
                double alas = Double.parseDouble(inputAlas);
                double tinggi = Double.parseDouble(inputTinggi);
                double sudut = Double.parseDouble(inputSudut);

                // Validasi angka negatif
                new ValidasiAngkaNegatif().operasiAngkaNegatif(alas);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggi);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(sudut);

                // Validasi logika untuk sudut lancip
                if (sudut <= 0 || sudut >= 90) {
                    throw new IllegalArgumentException("Sudut lancip harus lebih dari 0 dan kurang dari 90 derajat.");
                }

                // Jalankan perhitungan pada thread
                JajarGenjang newJg = new JajarGenjang(alas, tinggi, sudut);
                Thread thread = new Thread(new HitungBendaTask(newJg));
                thread.start();
                thread.join();

                // Menampilkan hasil
                new HasilJajarGenjangView(newJg).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldAlas.setText("");
            jTextFieldTinggi.setText("");
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
        if (jajarGenjang != null) {
            // Diasumsikan kelas JajarGenjang memiliki getter untuk properti
            jTextFieldAlas.setText(String.valueOf(jajarGenjang.alas));
            jTextFieldTinggi.setText(String.valueOf(jajarGenjang.tinggi));
            jTextFieldSudut.setText(String.valueOf(jajarGenjang.sudutLancip));
        }
    }
}