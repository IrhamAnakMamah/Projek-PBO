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

public class MainMenuView extends JFrame {

    public MainMenuView() {
        // Frame setup
        setTitle("Kalkulator Geometri Super");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(mainPanel);

        // Title Label
        JLabel titleLabel = new JLabel("Pilih Bangun Datar", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(5, 2, 15, 15)); // 5 baris, 2 kolom
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // --- Create and Add Buttons ---

        // Persegi
        JButton btnPersegi = new JButton("Persegi");
        btnPersegi.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnPersegi.addActionListener(e -> new PersegiView().setVisible(true));
        buttonPanel.add(btnPersegi);

        // Lingkaran
        JButton btnLingkaran = new JButton("Lingkaran");
        btnLingkaran.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnLingkaran.addActionListener(e -> new LingkaranView().setVisible(true));
        buttonPanel.add(btnLingkaran);

        // Persegi Panjang
        JButton btnPersegiPanjang = new JButton("Persegi Panjang");
        btnPersegiPanjang.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnPersegiPanjang.addActionListener(e -> new PersegiPanjangView().setVisible(true));
        buttonPanel.add(btnPersegiPanjang);

        // Segitiga
        JButton btnSegitiga = new JButton("Segitiga");
        btnSegitiga.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnSegitiga.addActionListener(e -> new SegitigaView().setVisible(true));
        buttonPanel.add(btnSegitiga);

        // Belah Ketupat
        JButton btnBelahKetupat = new JButton("Belah Ketupat");
        btnBelahKetupat.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnBelahKetupat.addActionListener(e -> new BelahKetupatView().setVisible(true));
        buttonPanel.add(btnBelahKetupat);

        // Jajar Genjang
        JButton btnJajarGenjang = new JButton("Jajar Genjang");
        btnJajarGenjang.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnJajarGenjang.addActionListener(e -> new JajarGenjangView().setVisible(true));
        buttonPanel.add(btnJajarGenjang);

        // Trapesium
        JButton btnTrapesium = new JButton("Trapesium");
        btnTrapesium.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnTrapesium.addActionListener(e -> new TrapesiumView().setVisible(true));
        buttonPanel.add(btnTrapesium);

        // Layang-Layang
        JButton btnLayangLayang = new JButton("Layang-Layang");
        btnLayangLayang.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnLayangLayang.addActionListener(e -> new LayangLayangView().setVisible(true));
        buttonPanel.add(btnLayangLayang);

        // Juring Lingkaran
        JButton btnJuring = new JButton("Juring Lingkaran");
        btnJuring.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnJuring.addActionListener(e -> new JuringLingkaranView().setVisible(true));
        buttonPanel.add(btnJuring);

        // Tembereng Lingkaran
        JButton btnTembereng = new JButton("Tembereng Lingkaran");
        btnTembereng.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnTembereng.addActionListener(e -> new TemberengLingkaranView().setVisible(true));
        buttonPanel.add(btnTembereng);
    }

    public static void main(String[] args) {
        // Best practice to run GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Set Look and Feel to Nimbus for a modern look
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                // If Nimbus is not available, you can set the GUI to default
            }

            MainMenuView menu = new MainMenuView();
            menu.setVisible(true);
        });
    }
}