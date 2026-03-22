package coffee;
import javax.swing.*;
import java.awt.*;

public class A_Welcome extends JFrame {

    public A_Welcome() {

        // === Window basic setup (size, title, close action etc.) ===
        setTitle("Coffee Mood");
        setSize(1248, 800);
        setLocationRelativeTo(null);     // center the window fel screen
        setResizable(false);             // don't allow resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // === Load background image and put it as main layout ===
        // bn3ml JLabel w 7ata feh el image zay background panel
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\Welcome.jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new GridBagLayout()); // using GridBag to center the button

        // === Button position settings ===
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;          // place button in the center horizontally
        gbc.gridy = 1;          // push it down a bit vertically
        gbc.insets = new Insets(400, 0, 0, 0); // move the button lower (padding from top)

        // === Create Start button (UI styling) ===
        JButton startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(220, 70));  // button size
        startButton.setFont(new Font("Serif", Font.BOLD, 48)); // text style
        startButton.setForeground(new Color(80, 42, 20));      // text color
        startButton.setBackground(new Color(204, 153, 102));   // button bg
        startButton.setFocusPainted(false);                    // remove border highlight

        // === Button action (go to next page) ===
        // lama user يدوس Start → يفتح صفحة B_Home w y2fl el current frame
        startButton.addActionListener(e -> {
            new B_Home();   // open Home page
            dispose();      // close welcome page
        });

        // === Add button to the background container ===
        backgroundLabel.add(startButton, gbc);

        // === Attach background to the frame ===
        setContentPane(backgroundLabel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new A_Welcome();   // start the app by showing the welcome screen
    }
}
