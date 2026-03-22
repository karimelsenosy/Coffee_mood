package coffee;

import javax.swing.*;
import java.awt.*;

public class C_Login extends JFrame {

    // Main UI Colors (theme of the app)
    private final Color MAIN_BROWN = new Color(141, 91, 56);       // main brown used in buttons
    private final Color DARK_BROWN = new Color(110, 65, 36);       // darker brown for hover
    private final Color TEXT_BEIGE = new Color(237, 221, 191);     // beige text color
    private final Color FIELD_BEIGE = new Color(245, 232, 208);    // light beige for input fields

    public C_Login() {

        // Basic window setup
        setTitle("Log In");
        setSize(1248, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int W = 1248, H = 800;

        // === Background image (full screen layout) ===
        ImageIcon bgIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\CoffeeHome.jpg");
        Image bgImg = bgIcon.getImage().getScaledInstance(W, H, Image.SCALE_SMOOTH);
        bgIcon = new ImageIcon(bgImg);

        JLabel background = new JLabel(bgIcon);
        background.setLayout(null);  // we use absolute layout (setBounds)
        setContentPane(background);

        // === Back button (top-left corner) ===
        JButton backBtn = new JButton("←"); // simple back arrow
        backBtn.setBounds(20, 20, 50, 50);
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 24));
        backBtn.setBackground(new Color(255, 255, 255, 220)); // semi-transparent white
        backBtn.setForeground(MAIN_BROWN);
        backBtn.setFocusPainted(false);
        backBtn.setBorder(BorderFactory.createLineBorder(MAIN_BROWN, 2));

        // hover effect
        addHover(backBtn, new Color(255, 255, 255, 220), MAIN_BROWN, MAIN_BROWN, Color.WHITE);

        backBtn.addActionListener(e -> {
            // العودة للصفحة الرئيسية
            new B_Home();
            dispose();
        });
        background.add(backBtn);

        // === Title (LOG IN text) ===
        JLabel title = new JLabel("LOG IN");
        title.setBounds(180, 70, 400, 60);
        title.setFont(new Font("Serif", Font.BOLD, 48));
        title.setForeground(Color.WHITE);
        background.add(title);

        // === Phone number label + input field ===
        JLabel phoneLabel = new JLabel("Phone Number :");
        phoneLabel.setBounds(180, 170, 200, 30);
        phoneLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        phoneLabel.setForeground(TEXT_BEIGE);
        background.add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(180, 205, 350, 40);
        phoneField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        phoneField.setBackground(FIELD_BEIGE);
        phoneField.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        background.add(phoneField);

        // === Password label + input field ===
        JLabel passLabel = new JLabel("Password :");
        passLabel.setBounds(180, 265, 200, 30);
        passLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        passLabel.setForeground(TEXT_BEIGE);
        background.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(180, 300, 350, 40);
        passField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        passField.setBackground(FIELD_BEIGE);
        passField.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        background.add(passField);

        // === Checkbox: show/hide password ===
        JCheckBox showPass = new JCheckBox("show password"); // user can see the password
        showPass.setBounds(180, 345, 200, 25);
        showPass.setOpaque(false);
        showPass.setForeground(TEXT_BEIGE);
        showPass.setFont(new Font("SansSerif", Font.PLAIN, 14));

        char defaultEcho = passField.getEchoChar();

        showPass.addActionListener(e -> {
            // toggle password visibility
            passField.setEchoChar(showPass.isSelected() ? (char) 0 : defaultEcho);
        });

        background.add(showPass);

        // === Login button ===
        JButton loginBtn = new JButton("LOG IN");
        loginBtn.setBounds(180, 385, 260, 55);
        loginBtn.setFont(new Font("SansSerif", Font.BOLD, 20));
        loginBtn.setBackground(MAIN_BROWN);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);
        loginBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        addHover(loginBtn, MAIN_BROWN, DARK_BROWN, Color.WHITE, Color.WHITE);
        background.add(loginBtn);

        // === Small line separator under Login button ===
        JSeparator sep = new JSeparator();
        sep.setBounds(180, 460, 350, 2);
        sep.setForeground(MAIN_BROWN);
        background.add(sep);

        // === Create account button ===
        JButton createBtn = new JButton("CREATE NEW ACCOUNT");
        createBtn.setBounds(180, 485, 260, 55);
        createBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        createBtn.setBackground(MAIN_BROWN);
        createBtn.setForeground(Color.WHITE);
        createBtn.setFocusPainted(false);
        createBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        addHover(createBtn, MAIN_BROWN, DARK_BROWN, Color.WHITE, Color.WHITE);
        background.add(createBtn);

        createBtn.addActionListener(e -> {
            // user wants to register → open sign-up page
            new D_SignUp();
            dispose();
        });
        /*
        *
        *
        *
         *  back-end by kerlos and kareem elbarbary
        *
        *
        *
        *
        *    
         */
        // === Login button action ===
        loginBtn.addActionListener(e -> {
            String phone = phoneField.getText().trim();
            String pass = new String(passField.getPassword());

            new G_Admin();
        });

        setVisible(true);
    }

    /*
    *
    *
    * end back-end
    *
    *
     */

    // === Hover effect for buttons (change color on mouse enter/exit) ===
    private void addHover(JButton btn,
            Color normalBg, Color hoverBg,
            Color normalFg, Color hoverFg) {

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(hoverBg);
                btn.setForeground(hoverFg);
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // pointer icon
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
        new C_Login();
    }
}
