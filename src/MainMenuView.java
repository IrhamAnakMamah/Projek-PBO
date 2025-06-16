import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class
MainMenuView extends JFrame {

    public MainMenuView() {
        setTitle("Kalkulator Geometri Super V2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Main panel dengan BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBorder(new EmptyBorder(30, 50, 50, 50));
        setContentPane(mainPanel);

        // Title Label
        JLabel titleLabel = new JLabel("Pilih Dimensi", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 20, 20));
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // --- Tombol 2D ---
        JButton btn2D = new JButton("Bangun Datar (2D)");
        btn2D.setFont(new Font("Tahoma", Font.BOLD, 24));
        btn2D.addActionListener(e -> new D2MenuView().setVisible(true));
        buttonPanel.add(btn2D);

        // --- Tombol 3D ---
        JButton btn3D = new JButton("Bangun Ruang (3D)");
        btn3D.setFont(new Font("Tahoma", Font.BOLD, 24));
        btn3D.addActionListener(e -> new D3MenuView().setVisible(true));
        buttonPanel.add(btn3D);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                // a lil fallback
            }

            new MainMenuView().setVisible(true);
        });
    }
}