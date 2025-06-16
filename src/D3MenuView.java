import View.ViewBangun3D.Bola.BolaView;
import View.ViewBangun3D.CincinBola.CincinBolaView;
import View.ViewBangun3D.JuringBola.JuringBolaView;
import View.ViewBangun3D.Kerucut.KerucutView;
import View.ViewBangun3D.KerucutTerpancung.KerucutTerpancungView;
import View.ViewBangun3D.LimasBelahKetupat.LimasBelahKetupatView;
import View.ViewBangun3D.LimasJajarGenjang.LimasJajarGenjangView;
import View.ViewBangun3D.LimasLayangLayang.LimasLayangLayangView;
import View.ViewBangun3D.LimasPersegi.LimasPersegiView;
import View.ViewBangun3D.LimasPersegiPanjang.LimasPersegiPanjangView;
import View.ViewBangun3D.LimasSegitiga.LimasSegitigaView;
import View.ViewBangun3D.LimasTrapesium.LimasTrapesiumView;
import View.ViewBangun3D.PrismaBelahKetupat.PrismaBelahKetupatView;
import View.ViewBangun3D.PrismaJajarGenjang.PrismaJajarGenjangView;
import View.ViewBangun3D.PrismaLayangLayang.PrismaLayangLayangView;
import View.ViewBangun3D.PrismaPersegi.PrismaPersegiView;
import View.ViewBangun3D.PrismaPersegiPanjang.PrismaPersegiPanjangView;
import View.ViewBangun3D.PrismaSegitiga.PrismaSegitigaView;
import View.ViewBangun3D.PrismaTrapesium.PrismaTrapesiumView;
import View.ViewBangun3D.Tabung.TabungView;
import View.ViewBangun3D.TemberengBola.TemberengBolaView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class D3MenuView extends JFrame {

    public D3MenuView() {
        setTitle("Menu Bangun Ruang (3D)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(mainPanel);

        JLabel titleLabel = new JLabel("Pilih Bangun Ruang", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(7, 3, 15, 15));
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // --- Tombol-tombol Bangun Ruang ---
        buttonPanel.add(createShapeButton("Bola", e -> new BolaView().setVisible(true)));
        buttonPanel.add(createShapeButton("Cincin Bola", e -> new CincinBolaView().setVisible(true)));
        buttonPanel.add(createShapeButton("Juring Bola", e -> new JuringBolaView().setVisible(true)));
        buttonPanel.add(createShapeButton("Kerucut", e -> new KerucutView().setVisible(true)));
        buttonPanel.add(createShapeButton("Kerucut Terpancung", e -> new KerucutTerpancungView().setVisible(true)));
        buttonPanel.add(createShapeButton("Limas Belah Ketupat", e -> new LimasBelahKetupatView().setVisible(true)));
        buttonPanel.add(createShapeButton("Limas Jajar Genjang", e -> new LimasJajarGenjangView().setVisible(true)));
        buttonPanel.add(createShapeButton("Limas Layang-Layang", e -> new LimasLayangLayangView().setVisible(true)));
        buttonPanel.add(createShapeButton("Limas Persegi", e -> new LimasPersegiView().setVisible(true)));
        buttonPanel.add(createShapeButton("Limas Persegi Panjang", e -> new LimasPersegiPanjangView().setVisible(true)));
        buttonPanel.add(createShapeButton("Limas Segitiga", e -> new LimasSegitigaView().setVisible(true)));
        buttonPanel.add(createShapeButton("Limas Trapesium", e -> new LimasTrapesiumView().setVisible(true)));
        buttonPanel.add(createShapeButton("Prisma Belah Ketupat", e -> new PrismaBelahKetupatView().setVisible(true)));
        buttonPanel.add(createShapeButton("Prisma Jajar Genjang", e -> new PrismaJajarGenjangView().setVisible(true)));
        buttonPanel.add(createShapeButton("Prisma Layang-Layang", e -> new PrismaLayangLayangView().setVisible(true)));
        buttonPanel.add(createShapeButton("Prisma Persegi (Kubus)", e -> new PrismaPersegiView().setVisible(true)));
        buttonPanel.add(createShapeButton("Prisma Persegi Panjang (Balok)", e -> new PrismaPersegiPanjangView().setVisible(true)));
        buttonPanel.add(createShapeButton("Prisma Segitiga", e -> new PrismaSegitigaView().setVisible(true)));
        buttonPanel.add(createShapeButton("Prisma Trapesium", e -> new PrismaTrapesiumView().setVisible(true)));
        buttonPanel.add(createShapeButton("Tabung", e -> new TabungView().setVisible(true)));
        buttonPanel.add(createShapeButton("Tembereng Bola", e -> new TemberengBolaView().setVisible(true)));
    }

    private JButton createShapeButton(String text, java.awt.event.ActionListener listener) {
        JButton button = new JButton(text);
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
        button.addActionListener(listener);
        return button;
    }
}