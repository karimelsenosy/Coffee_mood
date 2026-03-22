package coffee;
import javax.swing.*;
import java.awt.*;

public class F_About extends JFrame {

    // Color palette used across the app (same theme)
    private final Color MAIN_BROWN  = new Color(141, 91, 56);    // main brown
    private final Color DARK_BROWN  = new Color(110, 65, 36);    // hover brown
    private final Color TEXT_BEIGE  = new Color(237, 221, 191);  // light beige text

    public F_About() {
        setTitle("About Us");
        setSize(1248, 800);
        setLocationRelativeTo(null);        // center window
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int W = 1248;
        int H = 800;

        // === Background image stretched fullscreen (same style as other pages) ===
        ImageIcon bgIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\CoffeeHome.jpg");
        Image bgImg = bgIcon.getImage().getScaledInstance(W, H, Image.SCALE_SMOOTH);
        bgIcon = new ImageIcon(bgImg);

        JLabel background = new JLabel(bgIcon);
        background.setLayout(null);   // using absolute layout to place elements manually
        setContentPane(background);

        // === Back button (top-left corner) to return to home ===
        JButton backBtn = new JButton("←");
        backBtn.setBounds(20, 20, 50, 50);
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 24));
        backBtn.setBackground(new Color(255, 255, 255, 220)); // semi-transparent white
        backBtn.setForeground(MAIN_BROWN);
        backBtn.setFocusPainted(false);
        backBtn.setBorder(BorderFactory.createLineBorder(MAIN_BROWN, 2));

        // hover effect (simple, clean)
        addHover(backBtn, new Color(255,255,255,220), MAIN_BROWN, MAIN_BROWN, Color.WHITE);

        backBtn.addActionListener(e -> {
            new B_Home();   // go back to home menu
            dispose();
        });
        background.add(backBtn);

        // === Page title ===
        JLabel title = new JLabel("ABOUT COFFEE MOOD");
        title.setBounds(180, 70, 700, 60);
        title.setFont(new Font("Serif", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        background.add(title);

        // === About text area (multi-line description) ===
        JTextArea info = new JTextArea();
        info.setBounds(180, 160, 800, 380);
        info.setOpaque(false);                // keep background image visible
        info.setEditable(false);              // text is static, not user-editable
        info.setLineWrap(true);               // wrap long lines
        info.setWrapStyleWord(true);          // wrap by words (not cutting in middle)
        info.setForeground(Color.WHITE);
        info.setFont(new Font("SansSerif", Font.PLAIN, 18));

        // coffee shop introduction (Egyptian touch + friendly tone)
        info.setText(
                "Coffee Mood هو كافيه مصري في قلب القاهرة، معمول مخصوص لعشّاق القهوة.\n\n" +
                "بنختار حبوب القهوة بعناية من أفضل المحامص المحلية والعالمية، " +
                "وبنحمّصها بدرجات مختلفة علشان نرضي كل الأذواق، من الاسبريسو القوي " +
                "لحد اللاتيه، الكورتادو، والـ Cold Brew.\n\n" +
                "فروعنا الرئيسية في مدينة نصر والتجمع الخامس، ودايمًا بنوفّر جو هادي " +
                "ومناسب للمذاكرة، الشغل، أو قعدة لطيفة مع أصحابك.\n\n" +
                "مش بس قهوة! عندنا حلويات طازة، ساندويتشات خفيفة، وكورنر مخصوص للـ Board Games.\n\n" +
                "هدفنا بسيط: إن كل زيارة تبقى تجربة مختلفة… وتطلع من عندنا " +
                "وإنت مزاجك مظبوط على فنجان قهوة مصري بمود عالمي ☕✨"
        );

        background.add(info);

        // === Footer text (simple branding) ===
        JLabel footer = new JLabel("Coffee Mood • Cairo, Egypt");
        footer.setBounds(180, 560, 400, 30);
        footer.setFont(new Font("SansSerif", Font.PLAIN, 16));
        footer.setForeground(TEXT_BEIGE);
        background.add(footer);

        setVisible(true);
    }

    // === Reusable hover effect for buttons (changes bg/fg colors) ===
    private void addHover(JButton btn,
                          Color normalBg, Color hoverBg,
                          Color normalFg, Color hoverFg) {

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(hoverBg);
                btn.setForeground(hoverFg);
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // show hand icon
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
        new F_About(); // quick standalone test
    }
}
