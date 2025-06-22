import View.ViewBangun2D.BelahKetupat.BelahKetupatView;
import View.ViewBangun2D.JajarGenjang.JajarGenjangView;
import View.ViewBangun2D.JuringLingkaran.JuringLingkaranView;
import View.ViewBangun2D.LayangLayang.LayangLayangView;
import View.ViewBangun2D.Lingkaran.LingkaranView;
import View.ViewBangun2D.Persegi.PersegiView;
import View.ViewBangun2D.PersegiPanjang.PersegiPanjangView;
import View.ViewBangun2D.Segitiga.SegitigaView;
import View.ViewBangun2D.TemberengLingkaran.TemberengLingkaranView;
import View.ViewBangun2D.Trapesium.TrapesiumView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class D2MenuView extends JFrame {

    public D2MenuView() {
        setTitle("Menu Bangun Datar (2D)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cuma close window ini
        setSize(800, 500);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(mainPanel);

        JLabel titleLabel = new JLabel("Pilih Bangun Datar", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 2, 15, 15));
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // --- Tombol-tombol Bangun Datar ---

        buttonPanel.add(createShapeButton("Persegi", e -> new PersegiView().setVisible(true)));
        buttonPanel.add(createShapeButton("Lingkaran", e -> new LingkaranView().setVisible(true)));
        buttonPanel.add(createShapeButton("Persegi Panjang", e -> new PersegiPanjangView().setVisible(true)));
        buttonPanel.add(createShapeButton("Segitiga", e -> new SegitigaView().setVisible(true)));
        buttonPanel.add(createShapeButton("Belah Ketupat", e -> new BelahKetupatView().setVisible(true)));
        buttonPanel.add(createShapeButton("Jajar Genjang", e -> new JajarGenjangView().setVisible(true)));
        buttonPanel.add(createShapeButton("Trapesium", e -> new TrapesiumView().setVisible(true)));
        buttonPanel.add(createShapeButton("Layang-Layang", e -> new LayangLayangView().setVisible(true)));
        buttonPanel.add(createShapeButton("Juring Lingkaran", e -> new JuringLingkaranView().setVisible(true)));
        buttonPanel.add(createShapeButton("Tembereng Lingkaran", e -> new TemberengLingkaranView().setVisible(true)));
    }

    private JButton createShapeButton(String text, java.awt.event.ActionListener listener) {
        JButton button = new JButton(text);
        button.setFont(new Font("Tahoma", Font.BOLD, 16));
        button.addActionListener(listener);
        return button;
    }

}