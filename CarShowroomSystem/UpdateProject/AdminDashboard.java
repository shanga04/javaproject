import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame {

    private final CustomerManager customerManager;
    private final SalespersonManager salespersonManager;
    private final SalesRecordManager salesRecordManager;
    
    // Panels for different sections of the dashboard
    private JPanel customerPanel;
    private JPanel salespersonPanel;
    private JPanel salesRecordPanel;

    public AdminDashboard(CustomerManager customerManager, SalespersonManager salespersonManager, SalesRecordManager salesRecordManager) {
        this.customerManager = customerManager;
        this.salespersonManager = salespersonManager;
        this.salesRecordManager = salesRecordManager;

        // Set up frame properties
        setTitle("Admin Dashboard");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a tabbed pane for different dashboard sections
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create and add panels for customers, salespeople, and sales records
        customerPanel = new JPanel();
        customerPanel.add(new JLabel("Customer Management"));
        JButton viewCustomersButton = new JButton("View Customers");
        viewCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCustomers();
            }
        });
        customerPanel.add(viewCustomersButton);

        salespersonPanel = new JPanel();
        salespersonPanel.add(new JLabel("Salesperson Management"));
        JButton viewSalespeopleButton = new JButton("View Salespeople");
        viewSalespeopleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSalespeople();
            }
        });
        salespersonPanel.add(viewSalespeopleButton);

        salesRecordPanel = new JPanel();
        salesRecordPanel.add(new JLabel("Sales Record Management"));
        JButton viewSalesButton = new JButton("View Sales Records");
        viewSalesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSalesRecords();
            }
        });
        salesRecordPanel.add(viewSalesButton);

        // Add panels to tabbed pane
        tabbedPane.addTab("Customers", customerPanel);
        tabbedPane.addTab("Salespeople", salespersonPanel);
        tabbedPane.addTab("Sales Records", salesRecordPanel);

        // Add the tabbed pane to the frame
        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Method to display customer details
    private void showCustomers() {
        JOptionPane.showMessageDialog(this, "Showing all customers...\n" + customerManager.getAllCustomers(), "Customer List", JOptionPane.INFORMATION_MESSAGE);
    }
    

    // Method to display salesperson details
    private void showSalespeople() {
        JOptionPane.showMessageDialog(this, "Showing all salespeople...\n" + salespersonManager.getAllSalespeople(), "Salesperson List", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to display sales record details
    private void showSalesRecords() {
        JOptionPane.showMessageDialog(this, "Showing all sales records...\n" + salesRecordManager.getAllSales(), "Sales Record List", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        // Sample data to test the Admin Dashboard
        CustomerManager customerManager = new CustomerManager();
        SalespersonManager salespersonManager = new SalespersonManager();
        SalesRecordManager salesRecordManager = new SalesRecordManager();

        // Create an instance of AdminDashboard
        new AdminDashboard(customerManager, salespersonManager, salesRecordManager);
    }
}
