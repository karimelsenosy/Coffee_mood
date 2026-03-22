package coffee;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class D_SignUp extends JFrame {

    // Main theme colors for the sign up page (coffee vibes)
    private final Color MAIN_BROWN = new Color(141, 91, 56);   
    private final Color DARK_BROWN = new Color(110, 65, 36);   
    private final Color TEXT_BEIGE = new Color(237, 221, 191);
    private final Color FIELD_BEIGE = new Color(245, 232, 208);

    public D_SignUp() { //constractor
        // Basic window setup
        setTitle("Sign Up");
        setSize(1248, 800);//size of window
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int W = 1248;
        int H = 800;

        // --- Background image (full screen) ---
        // background image bt3ty to give the “coffee mood”.
        ImageIcon bgIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\CoffeeHome.jpg");
        Image bgImg = bgIcon.getImage().getScaledInstance(W, H, Image.SCALE_SMOOTH);
        bgIcon = new ImageIcon(bgImg);
        JLabel background = new JLabel(bgIcon);
        background.setLayout(null); // using absolute positioning to control layout like the pizza project.
        setContentPane(background);

        // --- Back button (top-left) ---
        JButton backBtn = new JButton("←");
        backBtn.setBounds(20, 20, 50, 50);
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 24));
        backBtn.setBackground(new Color(255, 255, 255, 220)); // semi-transparent white
        backBtn.setForeground(MAIN_BROWN);
        backBtn.setFocusPainted(false);
        backBtn.setBorder(BorderFactory.createLineBorder(MAIN_BROWN, 2));

        addHover(backBtn, new Color(255,255,255,220), MAIN_BROWN, MAIN_BROWN, Color.WHITE);

        // Clicking back returns to home page
        backBtn.addActionListener(e -> {
            new B_Home();
            dispose();
        });
        background.add(backBtn);

        // --- Page Title ---
        JLabel title = new JLabel("SIGN UP");
        title.setBounds(180, 60, 500, 60);
        title.setFont(new Font("Serif", Font.BOLD, 48));
        title.setForeground(Color.WHITE);
        background.add(title);

        // Layout coordinates
        int leftX = 180;
        int rightX = 650;
        int fieldWidth = 350;
        int fieldHeight = 40;

        // --- Username field ---
        JLabel userLabel = new JLabel("Username :");
        userLabel.setBounds(leftX, 150, 200, 30);
        userLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        userLabel.setForeground(TEXT_BEIGE);
        background.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(leftX, 190, fieldWidth, fieldHeight);
        userField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        userField.setBackground(FIELD_BEIGE);
        userField.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        background.add(userField);

        // --- Address field ---
        JLabel addressLabel = new JLabel("Address :");
        addressLabel.setBounds(rightX, 150, 200, 30);
        addressLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        addressLabel.setForeground(TEXT_BEIGE);
        background.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(rightX, 190, fieldWidth, fieldHeight);
        addressField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        addressField.setBackground(FIELD_BEIGE);
        addressField.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        background.add(addressField);

        // --- Password field ---
        JLabel passLabel = new JLabel("Password :");
        passLabel.setBounds(leftX, 240, 200, 30);
        passLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        passLabel.setForeground(TEXT_BEIGE);
        background.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(leftX, 280, fieldWidth, fieldHeight);
        passField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        passField.setBackground(FIELD_BEIGE);
        passField.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        background.add(passField);

        JCheckBox showPass1 = new JCheckBox("Show password");
        showPass1.setBounds(leftX, 325, 200, 25);
        showPass1.setOpaque(false);
        showPass1.setForeground(TEXT_BEIGE);
        showPass1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        char defaultEcho1 = passField.getEchoChar();

        // toggle password visibility
        showPass1.addActionListener(e -> {
            passField.setEchoChar(showPass1.isSelected() ? (char)0 : defaultEcho1);
        });
        background.add(showPass1);

        // --- Confirm Password field ---
        JLabel confirmLabel = new JLabel("Confirm password :");
        confirmLabel.setBounds(rightX, 240, 220, 30);
        confirmLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        confirmLabel.setForeground(TEXT_BEIGE);
        background.add(confirmLabel);

        JPasswordField confirmField = new JPasswordField();
        confirmField.setBounds(rightX, 280, fieldWidth, fieldHeight);
        confirmField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        confirmField.setBackground(FIELD_BEIGE);
        confirmField.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        background.add(confirmField);

        JCheckBox showPass2 = new JCheckBox("Show password");
        showPass2.setBounds(rightX, 325, 200, 25);
        showPass2.setOpaque(false);
        showPass2.setForeground(TEXT_BEIGE);
        showPass2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        char defaultEcho2 = confirmField.getEchoChar();

        // toggle confirm password visibility
        showPass2.addActionListener(e -> {
            confirmField.setEchoChar(showPass2.isSelected() ? (char)0 : defaultEcho2);
        });
        background.add(showPass2);

        // --- Phone number ---
        JLabel phoneLabel = new JLabel("Phone Number :");
        phoneLabel.setBounds(leftX, 380, 200, 30);
        phoneLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        phoneLabel.setForeground(TEXT_BEIGE);
        background.add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(leftX, 420, fieldWidth, fieldHeight);
        phoneField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        phoneField.setBackground(FIELD_BEIGE);
        phoneField.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        background.add(phoneField);

        // --- Sign Up button ---
        JButton signUpBtn = new JButton("SIGN UP");
        signUpBtn.setBounds(leftX, 490, 260, 55);
        signUpBtn.setFont(new Font("SansSerif", Font.BOLD, 20));
        signUpBtn.setBackground(MAIN_BROWN);
        signUpBtn.setForeground(Color.WHITE);
        signUpBtn.setFocusPainted(false);
        signUpBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        signUpBtn.setMargin(new Insets(10, 40, 10, 40));

        addHover(signUpBtn, MAIN_BROWN, DARK_BROWN, Color.WHITE, Color.WHITE);
        background.add(signUpBtn);
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
        // --- Button action: send input to database class ---
        // This calls the signup method in the DB layer. If signup succeeds → close page.
        signUpBtn.addActionListener(e -> {
            String username = userField.getText().trim();
            String address  = addressField.getText().trim();
            String phone    = phoneField.getText().trim();
            String pass     = new String(passField.getPassword());
            String confirm  = new String(confirmField.getPassword());

            
            
                dispose();
            
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
    
    
    // --- Hover animation on buttons (simple hover effect) ---
    private void addHover(JButton btn, Color normalBg, Color hoverBg,
                          Color normalFg, Color hoverFg) {

        btn.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(hoverBg);
                btn.setForeground(hoverFg);
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // pointer effect
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
        new D_SignUp();
    }
}
