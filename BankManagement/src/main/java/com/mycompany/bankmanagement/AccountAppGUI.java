/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankmanagement;

/**
 *
 * @author Zak Groenewold
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AccountAppGUI extends JFrame {
    private JTextField accountInfoField;
    private JTextArea messageBox;
    private JComboBox<String> transactionTypeBox;
    private Account bankAccount;
    private Customer customer;
    public static int transactionNumber = 1000; // Global counter for transactions

    public AccountAppGUI() {
        setTitle("Account Manager");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize with a default account/customer
        bankAccount = new Account(0.00, "N/A");  
        customer = new Customer();

        setupUI(); // Set up GUI components

        setVisible(true);  
    }

    private void setupUI() {
        // Top Panel
        JPanel topPanel = new JPanel(new BorderLayout());
        accountInfoField = new JTextField("Account Number: " + bankAccount.getAccountNumber() +
                                          " Balance: $" + bankAccount.getBalance());
        accountInfoField.setEditable(false);
        topPanel.add(accountInfoField, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel amountLabel = new JLabel("Enter Amount: ");
        JTextField amountInputField = new JTextField(10);
        JButton openAccountButton = new JButton("Open Account");
        openAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bankAccount = new Account(1000.00, "ZGR025");
                updateAccountInfo();
            }
        });
        
        JButton customerInfoButton = new JButton("Customer Info");
        customerInfoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                messageBox.setText(customer.toString());
            }
        });
        
        centerPanel.add(openAccountButton);
        centerPanel.add(customerInfoButton);
        centerPanel.add(amountLabel);
        centerPanel.add(amountInputField);

        transactionTypeBox = new JComboBox<>(new String[]{"Deposit", "Withdraw"});
        centerPanel.add(transactionTypeBox);

        Transaction transaction = new Transaction(transactionNumber + 1);
        JButton executeButton = new JButton("Execute");
        executeButton.addActionListener(new ActionListener() {
        @Override
    public void actionPerformed(ActionEvent e) {
        String selectedType = (String) transactionTypeBox.getSelectedItem();
        try {
            double amount = Double.parseDouble(amountInputField.getText());
            
            if ("Deposit".equals(selectedType)) {
                transaction.deposit(amount, bankAccount);  
                messageBox.setText("Deposited: $" + amount);
            } else if ("Withdraw".equals(selectedType)) {
                if(transaction.withdraw(amount,bankAccount) == true){  
                messageBox.setText("Withdrew: $" + amount);
            }else
                    showPopUp();
            }

            // Update account info display
            accountInfoField.setText("Account Number: " + bankAccount.getAccountNumber() +
                    " Balance: " + bankAccount.getBalance());

        } catch (NumberFormatException ex) {
            messageBox.setText("Invalid amount. Please enter a valid number.");
        }
    }
});

        centerPanel.add(executeButton);

        // Bottom Panel (Message Box)
        messageBox = new JTextArea(5, 20);
        messageBox.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageBox);
        add(scrollPane, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void showPopUp() {
        JDialog popUp = new JDialog(this, "Verification", true);
        popUp.setSize(300, 120);
        popUp.setLayout(new FlowLayout());
        popUp.add(new JLabel("Overdraft limit reached. Transaction cancelled."));

        // Confirm notification
        JButton closeButton = new JButton("Confirm");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popUp.dispose();
            }
        });

        popUp.add(closeButton);
        popUp.setVisible(true); 
    }

    private void updateAccountInfo() {
        accountInfoField.setText("Account Number: " + bankAccount.getAccountNumber() +
                                 " Balance: $" + bankAccount.getBalance());
    }

    public static void main(String[] args) {
        new AccountAppGUI(); // Start the GUI
    }
}

