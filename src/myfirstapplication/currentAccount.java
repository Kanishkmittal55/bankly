/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myfirstapplication;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author 44789
 */
public class currentAccount extends Account {
    
    
    private String theOwner;
//    This property should not be used
    private double overdraft;
    private String conditions;
    private double availableBalance;
    
    // Encapsulation help us implment code reuse actually more than inheritance
    public void Edit(double overdraft, String conditions, double availableBalance , String OwnerName){
        this.theOwner = OwnerName;
        this.overdraft = overdraft;
        this.conditions = conditions;
        this.availableBalance = availableBalance;  
    }
    
    public String intoString(){
        
        String currentAccountDetails = super.display() + "\n" + "Owner Name : " + theOwner + "\n" + "Overdraft : "+ overdraft +"\n" + "conditions : " + conditions + "\n" + "Available Balance : " + availableBalance + "\n";
        return currentAccountDetails;
    }
    
    // Default Parameterless Constructor
    public currentAccount(){
        super(null,-1,-1,null,-1,LocalDate.now(),"CA");
        this.Edit(-1, null, 0, null);
        
    }
    
    // Parameterised Constructor
    public currentAccount(String SortCode, int AccountNo, double Balance, String NameOfBank, double Rate, LocalDate LastReportedDate, String Type,double overdraft, String conditions, double availableBalance, String theOwner){
        
        super(SortCode,AccountNo,Balance,NameOfBank,Rate,LastReportedDate, Type); // So it is using the variables of the Base Class Account
        this.Edit(overdraft, conditions, availableBalance, theOwner);
    }
    
    // We will not use the saveToFile in the parent class but define our own implmentation of save to file method for the child class i.e. Current Account
    @Override
    public boolean saveToFile(BufferedWriter bin){
        boolean isSaved = false;
        try {
            super.saveToFile(bin);
            bin.append( "\n" + overdraft + "\n" + conditions + "\n" + availableBalance + "\n" + theOwner );
        } catch (IOException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSaved;
        
    }
    
    // Create Function - objective to create a current account for each customer
    public currentAccount create(String SortCode, int AccountNo, double Balance, String NameOfBank, double Rate, LocalDate LastReportedDate,String Type, double overdraft, String conditions, double availableBalance, String theOwner){
        currentAccount A1 = new currentAccount(SortCode,AccountNo, Balance, NameOfBank, Rate, LastReportedDate, Type,overdraft, conditions,availableBalance, theOwner);
        return A1;
    }
    
    // to display the details of each Customer
    @Override
    public String display(){
        
        return this.intoString();
        
    }
    
    
    // monthly interest deposit
    public void depositMonthlyInterest(){
        
    }
    
    // calculate charges 
    @Override
    public void calculateCharges(){
//        boolean isdone = false;
//        return isdone;
    }
    
    public int getCurrentAccountNo(){
        return super.getAccountNo();
    }
    
    public String getOwnerName(){
        return theOwner;
    }
    
}
