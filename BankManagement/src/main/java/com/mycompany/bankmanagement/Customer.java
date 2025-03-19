/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankmanagement;

/**
 *
 * @author Zak Groenewold
 */
public class Customer {
    private int customerID = 0;
    private String customerName = "Joe Smith";
    private String address = "253 Everywhere Road";
    private String phoneNumber= "867-5309";
    
    
    @Override
    public String toString(){
        return "Customer ID: " + customerID + " Address: " + address + 
                " Phone Number: " + phoneNumber;
    }
}
