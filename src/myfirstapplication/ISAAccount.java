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

/**
 *
 * @author 44789
 */
public class ISAAccount extends Account{
    
    private double maximumLimitPerYear;
    private double depositedThisYear;
    
    public ISAAccount(){
        super(null,-1,-1,null,-1,LocalDate.now(),"ISA");
        this.edit(3250,0);
    }
    
    public ISAAccount(String SortCode, int AccountNo, double Balance, String NameOfBank, double Rate, LocalDate LastReportedDate, String type, double maximumLimitPerYear, double depositedThisYear){
        super(SortCode, AccountNo, Balance, NameOfBank, Rate, LastReportedDate, type);
        this.edit(maximumLimitPerYear,depositedThisYear);
    }
    
    public void edit(double maximumLimitPerYear, double depositedThisYear){
        this.maximumLimitPerYear = maximumLimitPerYear;
        this.depositedThisYear = depositedThisYear;
    }
    
    @Override
    public boolean saveToFile(BufferedWriter bin){
        boolean isSaved = false;
        try {
            super.saveToFile(bin);
            bin.append( "\n" + maximumLimitPerYear + "\n" + depositedThisYear + "\n");
        } catch (IOException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSaved;
        
    }
}
