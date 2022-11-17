/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myfirstapplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 44789
 */
public class Account {
   
    protected String Type;
    protected String SortCode;
    protected int AccountNo;
    protected double Balance;
    protected String NameOfBank;
    protected double Rate;
    protected LocalDate LastReportedDate;
    
    
    // Helper Methods
     private void Edit(String SortCode, int AccountNo, double Balance, String NameOfBank, double Rate, LocalDate LastReportedDate, String type){
        
        this.SortCode = SortCode;
        this.AccountNo = AccountNo;
        this.Balance = Balance;
        this.NameOfBank = NameOfBank;
        this.Rate = Rate;
        this.LastReportedDate = LastReportedDate;
        this.Type = type;
        
        
    }
     
//    public String intoString(){
//       
//       return AccountDetails;
//    }
     
    //Intializing the constructor with help of code reuse
    public Account(){
        this.Edit("00-04-00",234567890 , 96.45, "Lloyds", 1.2, LocalDate.of(1990,11,01),null);
    }
    
    public Account(String SortCode, int AccountNo, double Balance, String NameOfBank, double Rate, LocalDate LastReportedDate, String Type){
        this.Edit(SortCode, AccountNo, Balance, NameOfBank, Rate, LastReportedDate, Type);
    }
    
   // create function
    public Account create(String SortCode, int AccountNo, double Balance, String NameOfBank, double Rate, LocalDate LastReportedDate, String Type){
        Account A1 = new Account(SortCode, AccountNo, Balance, NameOfBank, Rate, LastReportedDate, Type);
        return A1;
    }
    
    public String display(){
        String AccountDetails = "Type :" + this.Type + "SortCode :" + this.SortCode + "\n" + "AccountNo. :" + this.AccountNo +  "\n" + "Balance : " + this.Balance + "\n" + "Name Of Bank : " + this.NameOfBank + "\n" + "Rate : " + this.Rate +  "\n" + "Last Reported Date : " + this.LastReportedDate;
        return AccountDetails;
    }
    
    public void deposit(double Amount){
        this.Balance = this.Balance + Amount;
    }
    
    public double withdraw(double Amount){
        this.Balance = this.Balance - Amount;
        return this.Balance;
    }
    
    public boolean transfer(Account destinationAccount, int Amount){
        boolean istransfered = false;
        
        this.Balance = this.Balance - Amount;
        destinationAccount.Balance = destinationAccount.Balance +Amount;
        
        
        istransfered = true;
        return istransfered;    
    }
    
   
   public boolean saveToFile(BufferedWriter bin){
        boolean isSaved = false;
        try {
            
            bin.append( "\n" + SortCode + "\n" + AccountNo + "\n" + Balance + "\n" + NameOfBank+ "\n" + Rate + "\n" + LocalDate.now() + "\n" +  Type);
        } catch (IOException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSaved;
        
    }
    
        
    public void calculateCharges(){
//        boolean isSaved = false;
//                
//        return isSaved;
        
    }
    
    public boolean printStatement(){
        boolean isSaved = false;
                
        return isSaved;
        
    }
    
    public String getlastReportedDate(){
//        LastReportedDate = LocalDate.now();
        return String.valueOf(LastReportedDate);
    }
    
    public double getBalance(){
        return Balance;
    }
    
    public int getAccountNo(){
        return AccountNo;
    }
    
    public double getRate(){
        return Rate;
    }
    
    public static void main(String [] args){
        
    }
    
    
    
}



