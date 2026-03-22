package coffee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class H_OrderPage extends JFrame {

    // Main theme colors
    private final Color MAIN_BROWN = new Color(141, 91, 56);
    private final Color DARK_BROWN = new Color(110, 65, 36);
    private final Color TEXT_BEIGE = new Color(237, 221, 191);
    private final Color FIELD_BEIGE = new Color(245, 232, 208);

    // Form fields
    private JTextField txtCustomerName, txtAddress, txtPhone, txtQuantity, txtTotal;
    private JLabel lblSelectedItem;

    // Receipt table
    private DefaultTableModel tableModel;

    // Selected item info
    private String selectedItem = null;
    private double selectedPrice = 0.0;
    private double totalCost = 0.0;

    public H_OrderPage() {

        setTitle("Order Page - Coffee Mood");
        setSize(1248, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int W = 1248, H = 800;

        // Background image
        ImageIcon bgIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\CoffeeHome.jpg");
        Image bgImg = bgIcon.getImage().getScaledInstance(W, H, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setLayout(null);
        setContentPane(background);

        // Back button
        JButton backBtn = new JButton("←");
        backBtn.setBounds(20, 20, 50, 50);
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 24));
        backBtn.setBackground(new Color(255, 255, 255, 220));
        backBtn.setForeground(MAIN_BROWN);
        backBtn.setBorder(BorderFactory.createLineBorder(MAIN_BROWN, 2));
        addHover(backBtn, new Color(255, 255, 255, 220), MAIN_BROWN, MAIN_BROWN, Color.WHITE);

       backBtn.addActionListener(e -> {
            new G_Admin();
            dispose();
        });

        background.add(backBtn);

        // Page title
        JLabel title = new JLabel("ORDER PAGE");
        title.setBounds(420, 25, 400, 60);
        title.setFont(new Font("Serif", Font.BOLD, 40));
        title.setForeground(new Color(255, 140, 60));
        background.add(title);

        // Line under title
        JSeparator topSep = new JSeparator();
        topSep.setBounds(380, 80, 500, 2);
        topSep.setForeground(new Color(255, 140, 60));
        background.add(topSep);

        // Left section
        JPanel leftPanel = new JPanel(null);
        leftPanel.setBounds(20, 100, 650, 650);
        leftPanel.setBackground(new Color(30, 20, 15, 230));
        background.add(leftPanel);

        // ----- Customer inputs -----
        int labelX = 30;
        int fieldX = 190;
        int curY = 20;
        int h = 32;

        JLabel lblName = new JLabel("Customer Name :");
        styleLabel(lblName);
        lblName.setBounds(labelX, curY, 160, h);
        leftPanel.add(lblName);

        txtCustomerName = createField();
        txtCustomerName.setBounds(fieldX, curY, 260, h);
        leftPanel.add(txtCustomerName);

        curY += 40;
        JLabel lblAddress = new JLabel("Address :");
        styleLabel(lblAddress);
        lblAddress.setBounds(labelX, curY, 160, h);
        leftPanel.add(lblAddress);

        txtAddress = createField();
        txtAddress.setBounds(fieldX, curY, 260, h);
        leftPanel.add(txtAddress);

        curY += 40;
        JLabel lblPhone = new JLabel("Phone Number :");
        styleLabel(lblPhone);
        lblPhone.setBounds(labelX, curY, 160, h);
        leftPanel.add(lblPhone);

        txtPhone = createField();
        txtPhone.setBounds(fieldX, curY, 260, h);
        leftPanel.add(txtPhone);

        curY += 80;

        lblSelectedItem = new JLabel("Selected: none");
        lblSelectedItem.setBounds(30, curY, 400, 25);
        lblSelectedItem.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblSelectedItem.setForeground(TEXT_BEIGE);
        leftPanel.add(lblSelectedItem);

        JLabel lblQty = new JLabel("Quantity");
        lblQty.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblQty.setForeground(TEXT_BEIGE);
        lblQty.setBounds(470, curY, 150, 25);
        leftPanel.add(lblQty);

        txtQuantity = createField();
        txtQuantity.setBounds(470, curY + 35, 160, 32);
        leftPanel.add(txtQuantity);

        JButton btnConfirm = createOrangeButton("Confirm");
        btnConfirm.setBounds(470, curY + 80, 160, 40);
        leftPanel.add(btnConfirm);

        // ----- Receipt section -----
        JLabel lblReceipt = new JLabel("RECEIPT");
        lblReceipt.setBounds(30, 150, 200, 30);
        lblReceipt.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblReceipt.setForeground(new Color(255, 140, 60));
        leftPanel.add(lblReceipt);

        tableModel = new DefaultTableModel(new Object[]{"Item", "Quantity", "Cost"}, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(30, 190, 400, 360);
        leftPanel.add(scroll);

        JLabel lblTotal = new JLabel("Total");
        lblTotal.setBounds(470, 390, 100, 25);
        lblTotal.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblTotal.setForeground(TEXT_BEIGE);
        leftPanel.add(lblTotal);

        txtTotal = createField();
        txtTotal.setBounds(470, 420, 160, 32);
        txtTotal.setEditable(false);
        leftPanel.add(txtTotal);

        JButton btnReset = createOrangeButton("Reset");
        btnReset.setBounds(470, 470, 160, 40);
        leftPanel.add(btnReset);

        JButton btnSave = createOrangeButton("Save");
        btnSave.setBounds(470, 520, 160, 40);
        leftPanel.add(btnSave);

        btnConfirm.addActionListener(e -> addItemToReceipt());
        btnReset.addActionListener(e -> resetOrder());

        // Save order to database (disabled)
        btnSave.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "This is GUI-only mode.\nNo database connected.");
        });

        // ----- Menu (right side) -----
        JTabbedPane tabs = new JTabbedPane();
        tabs.setBounds(690, 100, 530, 650);

        tabs.addTab("Hot Coffee", createProductPanel("Hot Coffee"));
        tabs.addTab("Iced Coffee", createProductPanel("Iced Coffee"));
        tabs.addTab("Tea & Drinks", createProductPanel("Tea & Drinks"));
        tabs.addTab("Desserts", createProductPanel("Desserts"));

        background.add(tabs);

        setVisible(true);
    }

    /*
    *
    *
    *back end
    *
    *
     */
    // Load menu items per category
    @SuppressWarnings("empty-statement")
    private JPanel createProductPanel(String category) {

        JPanel panel = new JPanel(new GridLayout(0, 3, 10, 10));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ---- Dummy menu items instead of DB ----
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

        // Original loop kept as is
        for (Object[] row : items) {

            String name = (String) row[1];
            double price = (double) row[2];

            JButton btn = new JButton(name);
            btn.setFont(new Font("SansSerif", Font.BOLD, 14));
            btn.setBackground(new Color(210, 130, 70));
            btn.setForeground(Color.WHITE);
            btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

            addHover(btn, new Color(210, 130, 70), new Color(190, 110, 50), Color.WHITE, Color.WHITE);

            btn.addActionListener(e -> {
                selectedItem = name;
                selectedPrice = price;
                lblSelectedItem.setText("Selected: " + name + " (EGP " + price + ")");
            });

            panel.add(btn);
        }

        return panel;
    }

    // Add selected item to receipt table
    private void addItemToReceipt() {

        if (selectedItem == null) {
            JOptionPane.showMessageDialog(this, "Select item first.");
            return;
        }

        String qtyText = txtQuantity.getText().trim();
        if (qtyText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter quantity.");
            return;
        }

        int qty;
        try {
            qty = Integer.parseInt(qtyText);
            if (qty <= 0) {
                throw new NumberFormatException();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid quantity.");
            return;
        }

        double cost = selectedPrice * qty;
        tableModel.addRow(new Object[]{selectedItem, qty, cost});

        totalCost += cost;
        txtTotal.setText(String.valueOf(totalCost));

        txtQuantity.setText("");
    }

    // Clear all fields + table
    private void resetOrder() {
        tableModel.setRowCount(0);
        totalCost = 0;
        selectedItem = null;
        selectedPrice = 0;
        txtTotal.setText("");
        txtQuantity.setText("");
        lblSelectedItem.setText("Selected: none");
    }

    /*
    *
    *
    
    *
    *
     */
    // UI helpers
    private JTextField createField() {
        JTextField f = new JTextField();
        f.setBackground(FIELD_BEIGE);
        f.setFont(new Font("SansSerif", Font.PLAIN, 16));
        f.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        return f;
    }

    private void styleLabel(JLabel lbl) {
        lbl.setFont(new Font("SansSerif", Font.BOLD, 18));
        lbl.setForeground(TEXT_BEIGE);
    }

    private JButton createOrangeButton(String text) {
        JButton b = new JButton(text);
        b.setFont(new Font("SansSerif", Font.BOLD, 16));
        b.setBackground(MAIN_BROWN);
        b.setForeground(Color.WHITE);
        b.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        addHover(b, MAIN_BROWN, DARK_BROWN, Color.WHITE, Color.WHITE);
        return b;
    }

    private void addHover(JButton btn, Color n, Color h, Color nf, Color hf) {
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(h);
                btn.setForeground(hf);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(n);
                btn.setForeground(nf);
            }
        });
    }

    public static void main(String[] args) {
        new H_OrderPage();
    }
}
