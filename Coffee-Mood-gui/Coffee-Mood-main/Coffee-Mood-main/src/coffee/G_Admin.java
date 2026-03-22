package coffee;
import javax.swing.*;
import java.awt.*;

public class G_Admin extends JFrame {

    private final Color MAIN_BROWN  = new Color(141, 91, 56);   // main brown color for buttons
    private final Color DARK_BROWN  = new Color(110, 65, 36);   // hover color (brown darker)
    private final Color TEXT_BEIGE  = new Color(237, 221, 191); // beige text color
    private final Color LOGOUT_RED  = new Color(210, 38, 38);   // logout button red
    private final Color LOGOUT_RED_HOVER = new Color(172, 22, 22); // hover red

    public G_Admin() {

        // ==== basic window setup ====
        setTitle("Admin - Coffee Mood");
        setSize(1248, 800);
        setLocationRelativeTo(null);     // center screen
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int W = 1248, H = 800;

        // ==== background image (full screen coffee photo) ====
        ImageIcon bgIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\CoffeeHome.jpg");
        Image bgImg = bgIcon.getImage().getScaledInstance(W, H, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setLayout(null);      // using absolute layout
        setContentPane(background);

        // ==== top title text ====
        JLabel logo = new JLabel("COFFEE MOOD");
        logo.setBounds(80, 40, 400, 60);
        logo.setFont(new Font("Serif", Font.BOLD, 40));
        logo.setForeground(TEXT_BEIGE);  // nice beige color
        background.add(logo);

        JLabel adminLabel = new JLabel("ADMIN PANEL");
        adminLabel.setBounds(80, 90, 400, 40);
        adminLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        adminLabel.setForeground(Color.WHITE);
        background.add(adminLabel);

        // ==== main admin buttons ====

        // Place Order Page
        JButton placeOrderBtn = createMainButton("Place Order");
        placeOrderBtn.setBounds(100, 220, 260, 70);
        placeOrderBtn.addActionListener(e -> {
            new H_OrderPage();   // open order page
            dispose();           // close admin panel
        });
        background.add(placeOrderBtn);

        // Edit Menu Page
        JButton editMenuBtn = createMainButton("Edit Menu");
        editMenuBtn.setBounds(420, 220, 260, 70);
        editMenuBtn.addActionListener(e -> {
            new I_EditMenu();    // open menu editor
            dispose();
        });
        background.add(editMenuBtn);

        // Sales Page
        JButton salesBtn = createMainButton("Sales");
        salesBtn.setBounds(260, 330, 260, 70);
        salesBtn.addActionListener(e -> {
            new J_Sales();       // open sales page
            dispose();
        });
        background.add(salesBtn);

        // ==== Logout Button (red button) ====
        JButton logoutBtn = new JButton("LOG OUT");
        logoutBtn.setBounds(260, 460, 260, 60);  // directly under Sales

        logoutBtn.setFont(new Font("SansSerif", Font.BOLD, 20));
        logoutBtn.setBackground(LOGOUT_RED);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        logoutBtn.setMargin(new Insets(10, 35, 10, 35));

        // add hover effect
        addHover(logoutBtn, LOGOUT_RED, LOGOUT_RED_HOVER, Color.WHITE, Color.WHITE);

        logoutBtn.addActionListener(e -> {
            new B_Home();  // return to home screen
            dispose();
        });

        background.add(logoutBtn);

        setVisible(true);
    }

    // ==== helper method to create brown buttons (used all over project) ====
    private JButton createMainButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("SansSerif", Font.BOLD, 20));
        btn.setBackground(MAIN_BROWN);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        btn.setMargin(new Insets(10, 40, 10, 40));

        // hover effect
        addHover(btn, MAIN_BROWN, DARK_BROWN, Color.WHITE, Color.WHITE);
        return btn;
    }

    // ==== universal hover effect for all buttons ====
    private void addHover(JButton btn,
                          Color normalBg, Color hoverBg,
                          Color normalFg, Color hoverFg) {

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(hoverBg);
                btn.setForeground(hoverFg);
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(normalBg);
                btn.setForeground(normalFg);
                btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    // ==== testing shortcut ====
    public static void main(String[] args) {
        new G_Admin();
    }
}
