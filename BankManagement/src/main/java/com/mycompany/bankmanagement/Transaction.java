/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankmanagement;

/**
 *
 * @author Zak Groenewold
 */
public class Transaction {
    private int transactionID;
    private String transactionType;
    private double overdrawLimit = -1000.00;
    
    public Transaction(int startingTransactionNumber){
        this.transactionID = startingTransactionNumber;
    }
    
    public double getOverdrawLimit(){
        return overdrawLimit;
    }
    
    public void setOverdrawLimit(double overdraw){
        this.overdrawLimit = overdraw;
    }
    
    public int getTransactionID(){
        return transactionID;
    }
    
    public String getTransactionType(){
        return transactionType;
    }
    
    public void setTransactionID(int ID){
        this.transactionID = ID;
    }
    
    public void setTransactionType(String type){
        this.transactionType = type;
    }
    
    public void verifyTransaction(double amount, Account account){
        account.setBalance(account.getBalance() - amount);
    }
    
    public void deposit(double amount, Account account){
        account.setBalance(amount + account.getBalance());
    }
    
    public boolean withdraw(double amount, Account account){
        if((account.getBalance() - amount) >= getOverdrawLimit()){
            account.setBalance(account.getBalance() - amount);
            return true;
        }
        return false;
            
    }
    
    public double checkBalance(Account account){
        return account.getBalance();
    }
}
