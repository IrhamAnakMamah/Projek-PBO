package View.ViewBangun3D.PrismaTrapesium;

import Benda3D.PrismaTrapesium;
import Exception.ValidasiFormatAngka;
import Exception.ValidasiAngkaNegatif;
import Threading.HitungBendaTask;

import javax.swing.*;
import java.awt.*;

public class PrismaTrapesiumView extends JFrame {

    PrismaTrapesium prisma;
    JTextField jTextFieldAlasAtas = new JTextField();
    JTextField jTextFieldAlasBawah = new JTextField();
    JTextField jTextFieldTinggiAlas = new JTextField();
    JTextField jTextFieldTinggiPrisma = new JTextField();
    JTextField jTextFieldSisiA = new JTextField();
    JTextField jTextFieldSisiB = new JTextField();
    JTextField jTextFieldSisiC = new JTextField();
    JTextField jTextFieldSisiD = new JTextField();

    public PrismaTrapesiumView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Trapesium");
    }

    public PrismaTrapesiumView(PrismaTrapesium prisma) {
        this.prisma = prisma;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Prisma Trapesium");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 650);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("PRISMA TRAPESIUM");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(80, 20, 400, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndField("Alas Atas (a):", jTextFieldAlasAtas, 100);
        addLabelAndField("Alas Bawah (b):", jTextFieldAlasBawah, 140);
        addLabelAndField("Tinggi Alas Trapesium:", jTextFieldTinggiAlas, 180);
        addLabelAndField("Tinggi Prisma (t):", jTextFieldTinggiPrisma, 220);
        addLabelAndField("Sisi Miring Kiri Alas:", jTextFieldSisiA, 260);
        addLabelAndField("Sisi Miring Kanan Alas:", jTextFieldSisiB, 300);
        addLabelAndField("Sisi Alas Atas (C):", jTextFieldSisiC, 340);
        addLabelAndField("Sisi Alas Bawah (D):", jTextFieldSisiD, 380);
        addSeparator(0, 550);

        JButton btnHitung = new JButton("Hitung");
        btnHitung.setBounds(55, 570, 100, 30);
        add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(195, 570, 100, 30);
        add(btnReset);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(335, 570, 100, 30);
        add(btnClose);

        cek();

        btnHitung.addActionListener(e -> {
            try {
                String inputA = jTextFieldAlasAtas.getText();
                String inputB = jTextFieldAlasBawah.getText();
                String inputTinggiAlas = jTextFieldTinggiAlas.getText();
                String inputTinggiPrisma = jTextFieldTinggiPrisma.getText();
                String inputSisiA = jTextFieldSisiA.getText();
                String inputSisiB = jTextFieldSisiB.getText();
                String inputSisiC = jTextFieldSisiC.getText();
                String inputSisiD = jTextFieldSisiD.getText();

                if (inputA.isEmpty() || inputB.isEmpty() || inputTinggiAlas.isEmpty() ||
                        inputTinggiPrisma.isEmpty() || inputSisiA.isEmpty() || inputSisiB.isEmpty() ||
                        inputSisiC.isEmpty() || inputSisiD.isEmpty()) {
                    throw new IllegalArgumentException("Semua input harus diisi!");
                }

                new ValidasiFormatAngka().operasiFormatAngka(inputA);
                new ValidasiFormatAngka().operasiFormatAngka(inputB);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggiAlas);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggiPrisma);
                new ValidasiFormatAngka().operasiFormatAngka(inputSisiA);
                new ValidasiFormatAngka().operasiFormatAngka(inputSisiB);
                new ValidasiFormatAngka().operasiFormatAngka(inputSisiC);
                new ValidasiFormatAngka().operasiFormatAngka(inputSisiD);

                double a = Double.parseDouble(inputA);
                double b = Double.parseDouble(inputB);
                double tinggiAlas = Double.parseDouble(inputTinggiAlas);
                double tinggiPrisma = Double.parseDouble(inputTinggiPrisma);
                double sisiA = Double.parseDouble(inputSisiA);
                double sisiB = Double.parseDouble(inputSisiB);
                double sisiC = Double.parseDouble(inputSisiC);
                double sisiD = Double.parseDouble(inputSisiD);

                new ValidasiAngkaNegatif().operasiAngkaNegatif(a);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(b);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggiAlas);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tinggiPrisma);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(sisiA);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(sisiB);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(sisiC);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(sisiD);

                PrismaTrapesium newPrisma = new PrismaTrapesium(a, b, tinggiAlas, tinggiPrisma, sisiA, sisiB, sisiC, sisiD);
                Thread thread = new Thread(new HitungBendaTask(newPrisma));
                thread.start();
                thread.join();

                new HasilPrismaTrapesiumView(newPrisma).setVisible(true);
                dispose();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            jTextFieldAlasAtas.setText("");
            jTextFieldAlasBawah.setText("");
            jTextFieldTinggiAlas.setText("");
            jTextFieldTinggiPrisma.setText("");
            jTextFieldSisiA.setText("");
            jTextFieldSisiB.setText("");
            jTextFieldSisiC.setText("");
            jTextFieldSisiD.setText("");
        });

        btnClose.addActionListener(e -> dispose());
    }

    private void addLabelAndField(String labelText, JTextField field, int y) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setBounds(70, y, 160, 25);
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
            jTextFieldAlasAtas.setText(String.valueOf(prisma.getSisiSejajar1()));
            jTextFieldAlasBawah.setText(String.valueOf(prisma.getSisiSejajar2()));
            jTextFieldTinggiAlas.setText(String.valueOf(prisma.getTinggi()));
            jTextFieldTinggiPrisma.setText(String.valueOf(prisma.getTinggiPrismaTrapesium()));
            jTextFieldSisiA.setText(String.valueOf(prisma.getSisiA()));
            jTextFieldSisiB.setText(String.valueOf(prisma.getSisiB()));
            jTextFieldSisiC.setText(String.valueOf(prisma.getSisiC()));
            jTextFieldSisiD.setText(String.valueOf(prisma.getSisiD()));
        }
    }
}
