/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankmanagement;

/**
 *
 * @author Zak Groenewold
 */
public class Account {
    private String accountNumber;
    private double balance;
    
    public Account(double openingBalance, String accountNum){
        this.balance = openingBalance;
        this.accountNumber = accountNum;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public void setBalance(double amount){
        balance = amount;
    }
    
    public String getAccountNumber(){
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNum){
        this.accountNumber = accountNum;
    }
}
