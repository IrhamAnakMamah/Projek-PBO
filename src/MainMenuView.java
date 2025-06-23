import Benda.*;
import Benda2D.*;
import Benda3D.*;
import Benda3D.Kerucut;
import Benda3D.KerucutTerpancung;
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

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Threading.*;

public class MainMenuView extends JFrame {
    public MainMenuView(){
        JFrame frame = new JFrame("Menu Sejajar Benda 2D");
        frame.setSize(660, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        // === Menu Lingkaran ===
        JMenu lingkaranMenu = new JMenu("Lingkaran");

        JMenuItem hitungLingkaranItem = new JMenuItem("Hitung Lingkaran");
        hitungLingkaranItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LingkaranView().setVisible(true); // Tampilkan form lain
            }
        });

        JMenuItem temberengLingkaranItem = new JMenuItem("Tembereng");
        temberengLingkaranItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TemberengLingkaranView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem juringLingkaranItem = new JMenuItem("Juring Lingkaran");
        juringLingkaranItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JuringLingkaranView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem tabungItem = new JMenuItem("Tabung");
        tabungItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TabungView().setVisible(true); // Tampilkan form lain
            }
        });

        JMenu bolaMenu = new JMenu("Bola");
        JMenuItem hitungBolaItem = new JMenuItem("Hitung Bola");
        hitungBolaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BolaView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem cincinBolaItem = new JMenuItem("Cincin Bola");
        cincinBolaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CincinBolaView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem juringBolaItem = new JMenuItem("Juring Bola");
        juringBolaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JuringBolaView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem temberengBolaItem = new JMenuItem("Tembereng Bola");
        temberengBolaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TemberengBolaView().setVisible(true); // Tampilkan form lain
            }
        });

        JMenu kerucutMenu = new JMenu("Kerucut");
        JMenuItem hitungKerucutItem = new JMenuItem("Hitung Kerucut");
        hitungKerucutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KerucutView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem KerucutTerpancungItem = new JMenuItem("Kerucut Terpancung");
        KerucutTerpancungItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KerucutTerpancungView().setVisible(true); // Tampilkan form lain
            }
        });

        bolaMenu.add(hitungBolaItem);
        bolaMenu.add(cincinBolaItem);
        bolaMenu.add(juringBolaItem);
        bolaMenu.add(temberengBolaItem);
        kerucutMenu.add(hitungKerucutItem);
        kerucutMenu.add(KerucutTerpancungItem);

        lingkaranMenu.add(hitungLingkaranItem);
        lingkaranMenu.add(temberengLingkaranItem);
        lingkaranMenu.add(juringLingkaranItem);
        lingkaranMenu.addSeparator();
        lingkaranMenu.add(bolaMenu);
        lingkaranMenu.add(kerucutMenu);
        lingkaranMenu.add(tabungItem);

        // === Menu Persegi (kosong/tanpa submenu) ===
        JMenu persegiMenu = new JMenu("Persegi");

        JMenuItem hitungPersegiItem = new JMenuItem("Hitung Persegi");
        hitungPersegiItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersegiView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem limasPersegiItem = new JMenuItem("Limas Persegi");
        limasPersegiItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LimasPersegiView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem prismaPersegiItem = new JMenuItem("Prisma Persegi");
        prismaPersegiItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrismaPersegiView().setVisible(true); // Tampilkan form lain
            }
        });


        persegiMenu.add(hitungPersegiItem);
        persegiMenu.addSeparator();
        persegiMenu.add(limasPersegiItem);
        persegiMenu.add(prismaPersegiItem);



        // === Menu Persegi Panjang ===
        JMenu persegiPanjangMenu = new JMenu("Persegi Panjang");

        JMenuItem hitungpersegiPanjangItem = new JMenuItem("Hitung Persegi Panjang");
        hitungpersegiPanjangItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersegiPanjangView().setVisible(true); // Tampilkan form lain
            }
        });

        JMenuItem limaspersegiPanjangItem = new JMenuItem("Limas Persegi Panjang");
        limaspersegiPanjangItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LimasPersegiPanjangView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem prismapersegiPanjangItem = new JMenuItem("Prisma Persegi Panjang");
        prismapersegiPanjangItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrismaPersegiPanjangView().setVisible(true); // Tampilkan form lain
            }
        });


        persegiPanjangMenu.add(hitungpersegiPanjangItem);
        persegiPanjangMenu.addSeparator();
        persegiPanjangMenu.add(limaspersegiPanjangItem);
        persegiPanjangMenu.add(prismapersegiPanjangItem);




        // === Menu Segitiga ===
        JMenu segitigaMenu = new JMenu("Segitiga");

        JMenuItem hitungSegitigaItem = new JMenuItem("Hitung Segitiga");
        hitungSegitigaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SegitigaView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem limasSegitigaItem = new JMenuItem("Limas Segitiga");
        limasSegitigaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LimasSegitigaView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem prismaSegitigaItem = new JMenuItem("Prisma Segitiga");
        prismaSegitigaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrismaSegitigaView().setVisible(true); // Tampilkan form lain
            }
        });


        segitigaMenu.add(hitungSegitigaItem);
        segitigaMenu.addSeparator();
        segitigaMenu.add(limasSegitigaItem);
        segitigaMenu.add(prismaSegitigaItem);

        // === Menu Trapesium ===
        JMenu trapesiumMenu = new JMenu("Trapesium");

        JMenuItem hitungTrapesiumItem = new JMenuItem("Hitung Trapesium");
        hitungTrapesiumItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TrapesiumView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem prismaTrapesiumItem = new JMenuItem("Prisma Trapesium");
        prismaTrapesiumItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrismaTrapesiumView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem limasTrapesiumItem = new JMenuItem("Limas Trapesium");
        limasTrapesiumItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LimasTrapesiumView().setVisible(true); // Tampilkan form lain
            }
        });

        trapesiumMenu.add(hitungTrapesiumItem);
        trapesiumMenu.addSeparator();
        trapesiumMenu.add(limasTrapesiumItem);
        trapesiumMenu.add(prismaTrapesiumItem);

        // === Menu Jajar Genjang ===
        JMenu jajarGenjangMenu = new JMenu("Jajar Genjang");

        JMenuItem hitungjajarGenjangItem = new JMenuItem("Hitung Jajar Genjang");
        hitungjajarGenjangItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JajarGenjangView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem prismajajarGenjangItem = new JMenuItem("Prisma Jajar Genjang");
        prismajajarGenjangItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrismaJajarGenjangView().setVisible(true); // Tampilkan form lain
            }
        });

        JMenuItem limasjajarGenjangItem = new JMenuItem("Limas Jajar Genjang");
        limasjajarGenjangItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LimasJajarGenjangView().setVisible(true); // Tampilkan form lain
            }
        });

        jajarGenjangMenu.add(hitungjajarGenjangItem);
        jajarGenjangMenu.addSeparator();
        jajarGenjangMenu.add(limasjajarGenjangItem);
        jajarGenjangMenu.add(prismajajarGenjangItem);


        // === Menu Layang_Layang ===
        JMenu layangLayangMenu = new JMenu("Layang-Layang");

        JMenuItem hitunglayangLayangItem = new JMenuItem("Hitung Layang-Layang");
        hitunglayangLayangItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LayangLayangView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem prismalayangLayangItem = new JMenuItem("Prisma Layang-Layang");
        prismalayangLayangItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrismaLayangLayangView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem limaslayangLayangItem = new JMenuItem("Limas Layang Layang");
        limaslayangLayangItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LimasLayangLayangView().setVisible(true); // Tampilkan form lain
            }
        });

        layangLayangMenu.add(hitunglayangLayangItem);
        layangLayangMenu.addSeparator();
        layangLayangMenu.add(limaslayangLayangItem);
        layangLayangMenu.add(prismalayangLayangItem);

        // === Menu Belah Ketupat ===
        JMenu belahKetupatMenu = new JMenu("Belah Ketupat");

        JMenuItem hitungbelahKetupatItem = new JMenuItem("Hitung Belah Ketupat");
        hitungbelahKetupatItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BelahKetupatView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem limasbelahKetupatItem = new JMenuItem("Limas Belah Ketupat");
        limasbelahKetupatItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LimasBelahKetupatView().setVisible(true); // Tampilkan form lain
            }
        });
        JMenuItem prismabelahKetupatItem = new JMenuItem("Prisma Belah Ketupat");
        prismabelahKetupatItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrismaBelahKetupatView().setVisible(true); // Tampilkan form lain
            }
        });

        belahKetupatMenu.add(hitungbelahKetupatItem);
        belahKetupatMenu.addSeparator();
        belahKetupatMenu.add(limasbelahKetupatItem);
        belahKetupatMenu.add(prismabelahKetupatItem);

        // Tambahkan semua menu ke MenuBar (sejajar)
        menuBar.add(lingkaranMenu);
        menuBar.add(persegiMenu);
        menuBar.add(persegiPanjangMenu);
        menuBar.add(segitigaMenu);
        menuBar.add(trapesiumMenu);
        menuBar.add(jajarGenjangMenu);
        menuBar.add(layangLayangMenu);
        menuBar.add(belahKetupatMenu);

        // === Menu Threading ===
        JMenu threadMenu = new JMenu("Thread");

        JMenuItem hitungBendaItem = new JMenuItem("Thread Hitung Benda");
        hitungBendaItem.addActionListener(this::runHitungBendaTask);
        threadMenu.add(hitungBendaItem);

        JMenuItem executorItem = new JMenuItem("Thread Executor");
        executorItem.addActionListener(this::runThreadExecutor);
        threadMenu.add(executorItem);

        menuBar.add(threadMenu);

        // Pasang ke frame
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    // Thread manual: 5 thread satu per satu (HitungBendaTask)
    private void runHitungBendaTask(ActionEvent e) {
        List<Benda> bendaList = List.of(
                new Persegi(6),
                new Lingkaran(7),
                new PersegiPanjang(4, 10),
                new Segitiga(3, 4),
                new BelahKetupat(6, 8)
        );

        for (Benda benda : bendaList) {
            new Thread(new HitungBendaTask(benda)).start();
        }
    }

    // Thread Executor: menggunakan ExecutorService (minimal 5 objek juga)
    private void runThreadExecutor(ActionEvent e) {
        List<Benda> shapes = List.of(
                new Persegi(8),
                new Lingkaran(5),
                new Tabung(7, 10),
                new Bola(6),
                new LimasPersegi(5, 8)
        );
        ThreadExecutor.processShapes(shapes);
    }

}