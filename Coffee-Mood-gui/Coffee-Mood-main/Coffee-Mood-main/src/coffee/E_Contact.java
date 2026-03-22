package coffee;
import javax.swing.*;
import java.awt.*;

public class E_Contact extends JFrame {

    // Main color palette for the contact page (same theme as the app)
    private final Color MAIN_BROWN  = new Color(141, 91, 56);   // main brown color
    private final Color DARK_BROWN  = new Color(110, 65, 36);   // hover brown
    private final Color TEXT_BEIGE  = new Color(237, 221, 191); // light beige for text
    private final Color FIELD_BEIGE = new Color(245, 232, 208); // beige for input fields if needed

    public E_Contact() {
        setTitle("Contact Us");
        setSize(1248, 800);
        setLocationRelativeTo(null);       // center window on screen
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int W = 1248;
        int H = 800;

        // === Load background image and stretch it fullscreen (same style as login/signup) ===
        ImageIcon bgIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\CoffeeHome.jpg");
        Image bgImg = bgIcon.getImage().getScaledInstance(W, H, Image.SCALE_SMOOTH);
        bgIcon = new ImageIcon(bgImg);

        JLabel background = new JLabel(bgIcon);
        background.setLayout(null);   // using absolute layout like the other pages
        setContentPane(background);

        // === Back button (top-left corner) to return to Home ===
        JButton backBtn = new JButton("←");
        backBtn.setBounds(20, 20, 50, 50);
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 24));
        backBtn.setBackground(new Color(255, 255, 255, 220)); // semi-transparent white
        backBtn.setForeground(MAIN_BROWN);
        backBtn.setFocusPainted(false);
        backBtn.setBorder(BorderFactory.createLineBorder(MAIN_BROWN, 2));

        // hover effect for the back button
        addHover(backBtn, new Color(255,255,255,220), MAIN_BROWN, MAIN_BROWN, Color.WHITE);

        backBtn.addActionListener(e -> {
            new B_Home();  // go back to Home page
            dispose();     // close current window
        });
        background.add(backBtn);

        // === Page title "CONTACT US" ===
        JLabel title = new JLabel("CONTACT US");
        title.setBounds(180, 70, 500, 60);
        title.setFont(new Font("Serif", Font.BOLD, 48));
        title.setForeground(Color.WHITE);
        background.add(title);

        // === Display contact details as left-aligned text block ===
        // x positions for labels & values (labeled part + actual info)
        int labelX = 180;
        int valueX = 340;
        int startY = 170;
        int lineH = 35;   // vertical space between each line

        // --- Phone number ---
        JLabel phoneLabel = createLabel("Phone:", labelX, startY);
        JLabel phoneValue = createValue("+20 100 456 7890", valueX, startY);
        background.add(phoneLabel);
        background.add(phoneValue);

        // --- WhatsApp ---
        JLabel waLabel = createLabel("WhatsApp:", labelX, startY + lineH);
        JLabel waValue = createValue("+20 115 234 6789", valueX, startY + lineH);
        background.add(waLabel);
        background.add(waValue);

        // --- Email ---
        JLabel emailLabel = createLabel("Email:", labelX, startY + 2 * lineH);
        JLabel emailValue = createValue("coffeemood.eg@gmail.com", valueX, startY + 2 * lineH);
        background.add(emailLabel);
        background.add(emailValue);

        // --- Instagram ---
        JLabel instaLabel = createLabel("Instagram:", labelX, startY + 3 * lineH);
        JLabel instaValue = createValue("@coffeemood_eg", valueX, startY + 3 * lineH);
        background.add(instaLabel);
        background.add(instaValue);

        // --- Facebook ---
        JLabel fbLabel = createLabel("Facebook:", labelX, startY + 4 * lineH);
        JLabel fbValue = createValue("Coffee Mood Egypt", valueX, startY + 4 * lineH);
        background.add(fbLabel);
        background.add(fbValue);

        // --- Address (Egypt location) ---
        JLabel addrLabel = createLabel("Address:", labelX, startY + 5 * lineH);
        JLabel addrValue1 = createValue("12 Abbas El Akkad St.,", valueX, startY + 5 * lineH);
        JLabel addrValue2 = createValue("Nasr City, Cairo, Egypt", valueX, startY + 6 * lineH);
        background.add(addrLabel);
        background.add(addrValue1);
        background.add(addrValue2);

        // --- Opening hours ---
        JLabel openLabel = createLabel("Opening Hours:", labelX, startY + 7 * lineH);
        JLabel openValue1 = createValue("Sat - Thu: 8:00 AM - 11:30 PM", valueX, startY + 7 * lineH);
        JLabel openValue2 = createValue("Friday: 2:00 PM - 12:30 AM", valueX, startY + 8 * lineH);
        background.add(openLabel);
        background.add(openValue1);
        background.add(openValue2);

        // === Footer text bottom-left (optional branding) ===
        JLabel footer = new JLabel("Coffee Mood © 2025");
        footer.setBounds(180, 520, 400, 30);
        footer.setFont(new Font("SansSerif", Font.PLAIN, 16));
        footer.setForeground(TEXT_BEIGE);
        background.add(footer);

        setVisible(true);
    }

    // Helper method → creates a label name (left column)
    private JLabel createLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 150, 30);
        lbl.setFont(new Font("SansSerif", Font.BOLD, 18));
        lbl.setForeground(TEXT_BEIGE);
        return lbl;
    }

    // Helper method → creates info/value text (right column)
    private JLabel createValue(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 450, 30);
        lbl.setFont(new Font("SansSerif", Font.PLAIN, 18));
        lbl.setForeground(Color.WHITE);
        return lbl;
    }

    // General hover method used for buttons (changes bg & fg on enter/exit)
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

    public static void main(String[] args) {
        new E_Contact();
    }
}
