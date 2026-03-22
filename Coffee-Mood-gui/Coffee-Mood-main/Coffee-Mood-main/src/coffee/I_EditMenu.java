package coffee;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class I_EditMenu extends JFrame {

    // main colors used across the screen (same theme as the app)
    private final Color MAIN_BROWN = new Color(141, 91, 56);
    private final Color DARK_BROWN = new Color(110, 65, 36);
    private final Color TEXT_BEIGE = new Color(237, 221, 191);
    private final Color FIELD_BEIGE = new Color(245, 232, 208);

    // text field where admin types the new price
    private JTextField txtNewPrice;

    // label to show which item is currently selected (name + old price)
    private JLabel lblSelectedItem;

    // store the selected item id
    private int selectedItemId = -1;

    // store selected item name
    private String selectedItemName = null;

    // tabs container
    private JTabbedPane tabs;

    public I_EditMenu() {
        setTitle("Edit Menu - Coffee Mood");
        setSize(1248, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int W = 1248, H = 800;

        // load background image
        ImageIcon bgIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\CoffeeHome.jpg");
        Image bgImg = bgIcon.getImage().getScaledInstance(W, H, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setLayout(null);
        setContentPane(background);

        // ==========================================
        // BACK BUTTON
        // ==========================================
        JButton backBtn = new JButton("←");
        backBtn.setBounds(20, 20, 50, 50);
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 24));
        backBtn.setBackground(new Color(255, 255, 255, 220));
        backBtn.setForeground(MAIN_BROWN);
        backBtn.setFocusPainted(false);
        backBtn.setBorder(BorderFactory.createLineBorder(MAIN_BROWN, 2));
        addHover(backBtn, new Color(255, 255, 255, 220), MAIN_BROWN, MAIN_BROWN, Color.WHITE);

        backBtn.addActionListener(e -> {
            new G_Admin();
            dispose();
        });

        background.add(backBtn);

        // ==========================================
        // TITLE
        // ==========================================
        JLabel title = new JLabel("EDIT MENU");
        title.setBounds(480, 20, 400, 60);
        title.setFont(new Font("Serif", Font.BOLD, 40));
        title.setForeground(new Color(255, 140, 60));
        background.add(title);

        // separator
        JSeparator sep = new JSeparator();
        sep.setBounds(440, 80, 450, 2);
        sep.setForeground(new Color(255, 140, 60));
        background.add(sep);

        // ==========================================
        // LEFT: selected item + new price + buttons
        // ==========================================
        JPanel left = new JPanel(null);
        left.setBounds(20, 100, 360, 650);
        left.setBackground(new Color(30, 20, 15, 230));
        background.add(left);

        lblSelectedItem = new JLabel("Selected: none");
        lblSelectedItem.setBounds(40, 120, 280, 30);
        lblSelectedItem.setForeground(TEXT_BEIGE);
        lblSelectedItem.setFont(new Font("SansSerif", Font.BOLD, 16));
        left.add(lblSelectedItem);

        JLabel lbl = new JLabel("New Price");
        lbl.setBounds(60, 180, 240, 40);
        lbl.setFont(new Font("SansSerif", Font.BOLD, 28));
        lbl.setForeground(TEXT_BEIGE);
        left.add(lbl);

        txtNewPrice = new JTextField();
        txtNewPrice.setBounds(60, 230, 230, 38);
        txtNewPrice.setFont(new Font("SansSerif", Font.PLAIN, 18));
        txtNewPrice.setBackground(FIELD_BEIGE);
        txtNewPrice.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        left.add(txtNewPrice);

        JButton save = new JButton("Save");
        save.setBounds(60, 290, 230, 45);
        save.setFont(new Font("SansSerif", Font.BOLD, 18));
        save.setBackground(MAIN_BROWN);
        save.setForeground(Color.WHITE);
        addHover(save, MAIN_BROWN, DARK_BROWN, Color.WHITE, Color.WHITE);

        save.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "GUI ONLY MODE — No database connected.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        });

        left.add(save);

        JButton addNew = new JButton("Add New Item");
        addNew.setBounds(60, 360, 230, 45);
        addNew.setFont(new Font("SansSerif", Font.BOLD, 16));
        addNew.setBackground(new Color(90, 140, 90));
        addNew.setForeground(Color.WHITE);
        addHover(addNew, new Color(90, 140, 90), new Color(70, 120, 70), Color.WHITE, Color.WHITE);

        addNew.addActionListener(e -> showAddItemDialog());
        left.add(addNew);

        // ==========================================
        // TABS
        // ==========================================
        tabs = new JTabbedPane();
        tabs.setBounds(410, 100, 800, 650);
        tabs.setFont(new Font("SansSerif", Font.BOLD, 14));

        reloadTabs();
        background.add(tabs);

        setVisible(true);
    }

    /* ================================================================
     * BACK-END SECTION (Removed → GUI ONLY MODE)
     * Comments are kept exactly as original.
     * ================================================================
     */

    // Reload tabs (GUI version)
    private void reloadTabs() {
        tabs.removeAll();

        tabs.addTab("Hot Coffee", createPanel("Hot Coffee"));
        tabs.addTab("Iced Coffee", createPanel("Iced Coffee"));
        tabs.addTab("Tea & Drinks", createPanel("Tea & Drinks"));
        tabs.addTab("Desserts", createPanel("Desserts"));

        selectedItemId = -1;
        selectedItemName = null;

        lblSelectedItem.setText("Selected: none");
        txtNewPrice.setText("");
    }

    // Build category panel (GUI ONLY)
    private JPanel createPanel(String category) {

        JPanel grid = new JPanel(new GridLayout(0, 3, 8, 8));
        grid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        grid.setOpaque(false);

        /*
         * Dummy data — replaces DB
         * same format: [id, name, price]
         */
        List<Object[]> items = new ArrayList<>();

        if (category.equals("Hot Coffee")) {
            items.add(new Object[]{1, "Espresso", 35.0});
            items.add(new Object[]{2, "Cappuccino", 45.0});
            items.add(new Object[]{3, "Latte", 50.0});
        }

        if (category.equals("Iced Coffee")) {
            items.add(new Object[]{1, "Iced Latte", 55.0});
            items.add(new Object[]{2, "Iced Mocha", 60.0});
        }

        if (category.equals("Tea & Drinks")) {
            items.add(new Object[]{1, "Tea", 20.0});
            items.add(new Object[]{2, "Milkshake", 40.0});
        }

        if (category.equals("Desserts")) {
            items.add(new Object[]{1, "Brownie", 30.0});
            items.add(new Object[]{2, "Cheesecake", 65.0});
        }

        /*
         * Loop (same as original DB version)
         */
        for (Object[] row : items) {

            int id = (int) row[0];
            String name = (String) row[1];
            double price = (double) row[2];

            JButton btn = new JButton(name);
            btn.setFont(new Font("SansSerif", Font.BOLD, 14));
            btn.setBackground(new Color(210, 130, 70));
            btn.setForeground(Color.WHITE);

            addHover(btn, new Color(210, 130, 70), new Color(190, 110, 50), Color.WHITE, Color.WHITE);

            btn.addActionListener(e -> {
                selectedItemId = id;
                selectedItemName = name;

                lblSelectedItem.setText("Selected: " + name + " (EGP " + price + ")");
                txtNewPrice.setText(String.valueOf(price));
            });

            grid.add(btn);
        }

        JScrollPane scroll = new JScrollPane(grid);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);

        JPanel container = new JPanel(new BorderLayout());
        container.setOpaque(false);
        container.add(scroll);

        return container;
    }

    // Add new item dialog (GUI Only)
    private void showAddItemDialog() {

        JTextField nameF = new JTextField();
        JTextField priceF = new JTextField();

        String[] categories = {"Hot Coffee", "Iced Coffee", "Tea & Drinks", "Desserts"};
        JComboBox<String> catBox = new JComboBox<>(categories);

        JPanel p = new JPanel(new GridLayout(0, 1, 4, 4));
        p.add(new JLabel("Item name:"));
        p.add(nameF);
        p.add(new JLabel("Price (EGP):"));
        p.add(priceF);
        p.add(new JLabel("Category:"));
        p.add(catBox);

        int result = JOptionPane.showConfirmDialog(
                this,
                p,
                "Add New Item (GUI MODE)",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result != JOptionPane.OK_OPTION) return;

        String name = nameF.getText().trim();
        String priceTxt = priceF.getText().trim();
        String cat = (String) catBox.getSelectedItem();

        if (name.isEmpty() || priceTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill all fields.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double price;
        try { price = Double.parseDouble(priceTxt); }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid price.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "GUI MODE ONLY\nItem added (not saved):\n" +
                        name + " — EGP " + price + "\nCategory: " + cat,
                "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    /* ================================================================
     * END OF BACK-END SECTION
     * ================================================================
     */

    private void addHover(JButton btn, Color n, Color h, Color nf, Color hf) {

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(h);
                btn.setForeground(hf);
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(n);
                btn.setForeground(nf);
                btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    public static void main(String[] args) {
        new I_EditMenu();
    }
}
