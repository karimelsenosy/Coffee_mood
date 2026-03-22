package coffee;
import javax.swing.*;
import java.awt.*;

public class B_Home extends JFrame {

    // path bta3 background image
    private static final String IMAGE_PATH = "C:\\Users\\HP\\Desktop\\CoffeeHome.jpg";

    // app color palette (3ady nsta8dmha  bel buttons)
    private final Color MAIN_BROWN       = new Color(141, 91, 56);
    private final Color MAIN_BROWN_HOVER = new Color(170, 100, 50);
    private final Color LIGHT_BEIGE      = new Color(230, 200, 160);

    public B_Home() {

        // === Basic frame setup (size, title, close action) ===
        setTitle("Coffee Mood");
        setSize(1248, 800);
        setLocationRelativeTo(null);   // center fel screen
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // === Load background image and stretch it to full window ===
        ImageIcon bgIcon = new ImageIcon(IMAGE_PATH);
        Image bgImg = bgIcon.getImage().getScaledInstance(1248, 800, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setLayout(new BorderLayout());
        setContentPane(background);

        // === Overlay panel that sits above background (transparent) ===
        // bn7ot feh kol el content w ysib el background zaher
        JPanel overlay = new JPanel();
        overlay.setOpaque(false);
        overlay.setLayout(new BorderLayout());
        overlay.setBorder(BorderFactory.createEmptyBorder(120, 40, 40, 40)); // move content down
        background.add(overlay, BorderLayout.CENTER);

        // === Top area (logo centered horizontally) ===
        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        top.setOpaque(false);

        JLabel logo = new JLabel("COFFEE MOOD");
        logo.setFont(new Font("Serif", Font.BOLD, 52));
        logo.setForeground(LIGHT_BEIGE);
        top.add(logo);

        overlay.add(top, BorderLayout.NORTH);

        // === Center area: main buttons section ===
        JPanel center = new JPanel();
        center.setOpaque(false);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        center.add(Box.createVerticalGlue()); // pushes items to center vertically

        // === LOG IN button (main) ===
        JButton loginBtn = new JButton("LOG IN");
        styleMainButton(loginBtn);
        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginBtn.setPreferredSize(new Dimension(380, 72));
        loginBtn.setMaximumSize(new Dimension(420, 72)); // fix size in BoxLayout

        // === SIGN UP button (main) ===
        JButton signupBtn = new JButton("SIGN UP");
        styleMainButton(signupBtn);
        signupBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupBtn.setPreferredSize(new Dimension(380, 72));
        signupBtn.setMaximumSize(new Dimension(420, 72));

        // spacing between main buttons
        center.add(loginBtn);
        center.add(Box.createVerticalStrut(24));
        center.add(signupBtn);
        center.add(Box.createVerticalStrut(28));

        // === Separator line under main buttons ===
        // el space tb2a thabtaaa
        // 2 zorar gamb ba3d bmasafa 18 
        JSeparator sep = new JSeparator();
        sep.setMaximumSize(new Dimension(420, 2));
        sep.setForeground(new Color(200, 180, 150));
        center.add(sep);
        center.add(Box.createVerticalStrut(18));

        // === Small buttons (Contact – About) ===
        JPanel smallBtns = new JPanel();
        smallBtns.setOpaque(false);
        smallBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 18, 0));

        JButton contactBtn = new JButton("Contact us");
        styleSmallButton(contactBtn);

        JButton aboutBtn = new JButton("About us");
        styleSmallButton(aboutBtn);

        smallBtns.add(contactBtn);
        smallBtns.add(aboutBtn);

        center.add(smallBtns);
        center.add(Box.createVerticalGlue()); // push group to center

        overlay.add(center, BorderLayout.CENTER);

        // === Actions: open other pages ===
        loginBtn.addActionListener(e -> {
            new C_Login();   // opens login page
            dispose();       // close home page
        });

        signupBtn.addActionListener(e -> {
            new D_SignUp();  // opens signup page
            dispose();
        });

        contactBtn.addActionListener(e -> {
            new E_Contact();
            dispose();
        });

        aboutBtn.addActionListener(e -> {
            new F_About();
            dispose();
        });

        setVisible(true);
    }

    // === Style for big main buttons (LOG IN / SIGN UP) ===
    // handles font, bg color, hover, borders etc.
    private void styleMainButton(JButton btn) {
        btn.setFont(new Font("SansSerif", Font.BOLD, 22));
        btn.setForeground(Color.WHITE);
        btn.setBackground(MAIN_BROWN);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setOpaque(true);
        btn.setMargin(new Insets(12, 20, 12, 20));

        // hover effect (lighter brown)
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(MAIN_BROWN_HOVER.darker().brighter());
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(MAIN_BROWN);
            }
        });
    }

    // === Style for small white buttons (Contact / About) ===
    private void styleSmallButton(JButton btn) {
        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn.setForeground(MAIN_BROWN);
        btn.setBackground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(MAIN_BROWN, 2));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setOpaque(true);
        btn.setPreferredSize(new Dimension(120, 34));

        // hover (invert colors)
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(MAIN_BROWN);
                btn.setForeground(Color.WHITE);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(Color.WHITE);
                btn.setForeground(MAIN_BROWN);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(B_Home::new);
    }
}
