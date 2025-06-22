package View.ViewBangun3D.LimasJajarGenjang;

import Benda3D.LimasJajarGenjang;
import Exception.ValidasiFormatAngka;
import Exception.ValidasiAngkaNegatif;
import Threading.HitungBendaTask;

import javax.swing.*;
import java.awt.*;

public class LimasJajarGenjangView extends JFrame {

    LimasJajarGenjang limas;
    JTextField jTextFieldAlas = new JTextField();
    JTextField jTextFieldTinggiAlas = new JTextField();
    JTextField jTextFieldSudut = new JTextField();
    JTextField jTextFieldTinggiLimas = new JTextField();

    public LimasJajarGenjangView() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Jajar Genjang");
    }

    public LimasJajarGenjangView(LimasJajarGenjang limas) {
        this.limas = limas;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kalkulator Limas Jajar Genjang");
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);

        JLabel jLabelTitle = new JLabel("LIMAS JAJAR GENJANG");
        jLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        jLabelTitle.setBounds(50, 20, 400, 37);
        add(jLabelTitle);

        addSeparator(0, 70);
        addLabelAndText("Alas Jajar Genjang:", jTextFieldAlas, 100);
        addLabelAndText("Tinggi Alas:", jTextFieldTinggiAlas, 140);
        addLabelAndText("Sudut Lancip Alas:", jTextFieldSudut, 180);
        addLabelAndText("Tinggi Limas:", jTextFieldTinggiLimas, 220);
        addSeparator(0, 400);

        JButton jButtonsSave = new JButton("Hitung");
        jButtonsSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonsSave.setBounds(55, 420, 100, 30);
        add(jButtonsSave);

        JButton jButtonReset = new JButton("Reset");
        jButtonReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonReset.setBounds(195, 420, 100, 30);
        add(jButtonReset);

        JButton jButtonClose = new JButton("Close");
        jButtonClose.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButtonClose.setBounds(335, 420, 100, 30);
        add(jButtonClose);

        cek();

        jButtonsSave.addActionListener(e -> {
            try {
                String inputAlas = jTextFieldAlas.getText();
                String inputTinggiAlas = jTextFieldTinggiAlas.getText();
                String inputSudut = jTextFieldSudut.getText();
                String inputTinggiLimas = jTextFieldTinggiLimas.getText();

                if (inputAlas.isEmpty() || inputTinggiAlas.isEmpty() || inputSudut.isEmpty() || inputTinggiLimas.isEmpty()) {
                    throw new IllegalArgumentException("Semua input harus diisi!");
                }

                new ValidasiFormatAngka().operasiFormatAngka(inputAlas);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggiAlas);
                new ValidasiFormatAngka().operasiFormatAngka(inputSudut);
                new ValidasiFormatAngka().operasiFormatAngka(inputTinggiLimas);

                double a = Double.parseDouble(inputAlas);
                double ta = Double.parseDouble(inputTinggiAlas);
                double s = Double.parseDouble(inputSudut);
                double tl = Double.parseDouble(inputTinggiLimas);

                new ValidasiAngkaNegatif().operasiAngkaNegatif(a);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(ta);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(s);
                new ValidasiAngkaNegatif().operasiAngkaNegatif(tl);

                LimasJajarGenjang newLimas = new LimasJajarGenjang(a, ta, s, tl);
                Thread thread = new Thread(new HitungBendaTask(newLimas));
                thread.start();
                thread.join();

                new HasilLimasJajarGenjangView(newLimas).setVisible(true);
                dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Thread terganggu: " + ex.getMessage(), "Thread Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonReset.addActionListener(e -> {
            jTextFieldAlas.setText("");
            jTextFieldTinggiAlas.setText("");
            jTextFieldSudut.setText("");
            jTextFieldTinggiLimas.setText("");
        });

        jButtonClose.addActionListener(e -> dispose());
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
        if (limas != null) {
            jTextFieldAlas.setText(String.valueOf(limas.alas));
            jTextFieldTinggiAlas.setText(String.valueOf(limas.tinggi));
            jTextFieldSudut.setText(String.valueOf(limas.sudutLancip));
            jTextFieldTinggiLimas.setText(String.valueOf(limas.getTinggiLimas()));
        }
    }
}
