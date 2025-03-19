/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankmanagement;

import com.mycompany.bankmanagement.AccountAppGUI;
import javax.swing.SwingUtilities;

/**
 *
 * @author Zak Groenewold
 */
public class BankManagement {
    public static void main(String[] args) {
        // Ensures that the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AccountAppGUI();  // Create and display the GUI
            }
        });
    }
}
