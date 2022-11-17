/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myfirstapplication;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 44789
 */
public class savingAccount extends Account {
    
    private double withdrawalLimit;
    
    public savingAccount(){
        super(null,-1,-1,null,-1,LocalDate.now(),"B.nil");
        this.edit(-1);
        
    }
    
    public savingAccount(String SortCode, int AccountNo, double Balance, String NameOfBank, double Rate, LocalDate LastReportedDate, String Type, double withdrawalLimit){
        super(SortCode,AccountNo,Balance,NameOfBank,Rate,LastReportedDate,Type);
        this.edit(withdrawalLimit);
    }
    
    public void edit(double setWithdrawalLimit){
        this.withdrawalLimit = setWithdrawalLimit;
    }
    
    public savingAccount create(String SortCode, int AccountNo, double Balance, String NameOfBank, double Rate, LocalDate LastReportedDate, String Type, double withdrawalLimit){
        savingAccount A1 = new savingAccount(SortCode,AccountNo, Balance, NameOfBank, Rate, LastReportedDate, Type,withdrawalLimit);
        return A1;
    }
    
    public String display(){
        String allDetails = super.display() + "\n" + "withdrawalLimit : " + this.withdrawalLimit ;
        return allDetails;
    }
    
    public double withdraw(double amount){
        super.withdraw(amount);
        return this.getBalance();
    }
    
    public void deposit(double amount){
        super.deposit(amount);
    }
    
    public void depositMonthlyInterest(String Date1, String Date2){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse(Date1, dtf);
        LocalDate date2 = LocalDate.parse(Date2, dtf);
        long daysBetween = Duration.between(date1, date2).toDays();
        
        super.getBalance(); //For simply we have chosen to provide simple Interest on the balance on the date on which customer or bank wishes to provide interest 
        double rate = super.getRate();
//        int interestCycles = Integer.parseInt(Integer.parseInt(daysBetween) / rate);
    }
    
    public void calculateCharges(){
//        return super.getBalance();
    }
    
   
    
    @Override
    public boolean saveToFile(BufferedWriter bin){
        boolean isSaved = false;
        try {
            super.saveToFile(bin);
            bin.append( "\n" + withdrawalLimit);
        } catch (IOException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSaved;
        
    }
}
