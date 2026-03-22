package coffee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


public class J_Sales extends JFrame {

    // ----- theme colors -----
    private final Color MAIN_BROWN = new Color(141, 91, 56);
    private final Color DARK_BROWN = new Color(110, 65, 36);
    private final Color TITLE_ORANGE = new Color(255, 140, 60);

    private JTable tableReceipts;
    private JTable tableDetails;
    private JTextField idField;
    private JTextField phoneSearchField;

    public J_Sales() {

        // basic window settings
        setTitle("Sales - Coffee Mood");
        setSize(1248, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int W = 1248, H = 800;

        // ----- background image -----
        ImageIcon bgIcon = new ImageIcon("C:\\Users\\HP\\Desktop\\CoffeeHome.jpg");
        Image bgImg = bgIcon.getImage().getScaledInstance(W, H, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImg));
        background.setLayout(null);
        setContentPane(background);

        // ----- back button -----
        JButton backBtn = new JButton("←");
        backBtn.setBounds(20, 20, 50, 50);
        styleBackButton(backBtn);
        backBtn.addActionListener(e -> {
            new G_Admin();
            dispose();
        });
        background.add(backBtn);

        // ====== RECEIPTS title ======
        JLabel lblReceipts = new JLabel("RECEIPTS", SwingConstants.CENTER);
        lblReceipts.setBounds(40, 40, 550, 40);
        lblReceipts.setFont(new Font("SansSerif", Font.BOLD, 28));
        lblReceipts.setForeground(TITLE_ORANGE);
        background.add(lblReceipts);

        // label "Phone :" next to search bar (front-end improvement)
        JLabel lblPhoneSearch = new JLabel("Phone :");
        lblPhoneSearch.setBounds(40, 60, 120, 30);
        lblPhoneSearch.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblPhoneSearch.setForeground(TITLE_ORANGE);
        background.add(lblPhoneSearch);

        // ----- phone search field -----
        phoneSearchField = new JTextField();
        phoneSearchField.setBounds(40, 90, 200, 28);
        phoneSearchField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        background.add(phoneSearchField);

        // search button
        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(250, 85, 100, 35);
        btnSearch.setBackground(MAIN_BROWN);
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("SansSerif", Font.BOLD, 14));
        addHover(btnSearch, MAIN_BROWN, DARK_BROWN, Color.WHITE, Color.WHITE);
        background.add(btnSearch);

        // ----- receipts table (left box) -----
        tableReceipts = new JTable();
        tableReceipts.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Phone", "Name", "Total Price"}));
        tableReceipts.setEnabled(false);

        JScrollPane spReceipts = new JScrollPane(tableReceipts);
        spReceipts.setBounds(40, 130, 550, 620);
        background.add(spReceipts);

        // ===== RECEIPT DETAILS title =====
        JLabel lblDetails = new JLabel("RECEIPT DETAILS", SwingConstants.CENTER);
        lblDetails.setBounds(630, 40, 550, 40);
        lblDetails.setFont(new Font("SansSerif", Font.BOLD, 28));
        lblDetails.setForeground(TITLE_ORANGE);
        background.add(lblDetails);

        // ----- ID field -----
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(640, 90, 40, 25);
        lblId.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblId.setForeground(TITLE_ORANGE);
        background.add(lblId);

        idField = new JTextField();
        idField.setBounds(680, 90, 160, 28);
        idField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        background.add(idField);

        // show details button
        JButton btnShow = new JButton("Show Details");
        btnShow.setBounds(860, 85, 180, 38);
        btnShow.setBackground(MAIN_BROWN);
        btnShow.setForeground(Color.WHITE);
        btnShow.setFont(new Font("SansSerif", Font.BOLD, 16));
        addHover(btnShow, MAIN_BROWN, DARK_BROWN, Color.WHITE, Color.WHITE);
        background.add(btnShow);

        // delete receipt button (admin tool)
        JButton btnDelete = new JButton("Delete Receipt");
        btnDelete.setBounds(1050, 85, 150, 38);
        btnDelete.setBackground(Color.RED);
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new Font("SansSerif", Font.BOLD, 14));
        background.add(btnDelete);


        // ----- details table -----
        tableDetails = new JTable();
        tableDetails.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Item", "Price", "Quantity"}));
        tableDetails.setEnabled(false);

        JScrollPane spDetails = new JScrollPane(tableDetails);
        spDetails.setBounds(630, 130, 550, 620);
        background.add(spDetails);

        /*
        =====================================================================
                               B A C K   E N D
                (Database reading, searching, loading, deleting)
        ---------------------------------------------------------------------
            - loadReceipts(): search receipts by phone number
            - loadReceiptDetails(): show all items under receipt_id
            - deleteReceipt(): delete full invoice (receipt + items)
        =====================================================================
         */
        setVisible(true);
    }

    /*
    *
    
    *
    *
    *
    */
    // ====== styling helpers ======
    private void styleBackButton(JButton btn) {
        btn.setFont(new Font("SansSerif", Font.BOLD, 24));
        btn.setBackground(new Color(255, 255, 255, 220));
        btn.setForeground(MAIN_BROWN);
        btn.setBorder(BorderFactory.createLineBorder(MAIN_BROWN, 2));
        btn.setFocusPainted(false);
        addHover(btn, new Color(255, 255, 255, 220), MAIN_BROWN, MAIN_BROWN, Color.WHITE);
    }

    private void addHover(JButton btn, Color normalBg, Color hoverBg, Color normalFg, Color hoverFg) {
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBackground(hoverBg);
                btn.setForeground(hoverFg);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBackground(normalBg);
                btn.setForeground(normalFg);
            }
        });
    }

    public static void main(String[] args) {
        new J_Sales();
    }
}
