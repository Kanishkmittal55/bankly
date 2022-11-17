/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myfirstapplication;

/**
 *
 * @author Kanishk Mittal
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;


public class Branch {
    
    
    private String WorkingHours;
    private String SortCode;
    private String Manager;
    private IAddress theAddress;
    
    
    // Default Constructor
    public Branch() {
      theAddress = new IAddress();
      this.readFromFile();
    }
    
     public Branch(String WorkingHours, String SortCode, String Manager, IAddress theirAddress) {
        this.WorkingHours = WorkingHours;
        this.SortCode =SortCode;
        this.Manager = Manager;
        this.theAddress = theirAddress;
        
    }
     public void Edit(String WorkingHours, String SortCode, String Manager, String Name, String HouseName, String HouseNo, String Street, String Area, String City, String PostCode, String Country) {
        this.WorkingHours = WorkingHours;
        this.SortCode =SortCode;
        this.Manager = Manager;
        this.theAddress.Edit(Name, HouseName, HouseNo, Street, Area, PostCode, City, Country);
        
        
    }
  
    public void Edit(String inWorkingHours, String inSortCode, String inManager, IAddress Add1){
          WorkingHours = inWorkingHours;
          SortCode = inSortCode;
          Manager = inManager;
          theAddress = Add1;
    }
    
    public void Edit(String inWorkingHours, String inSortCode, String inManager){
          WorkingHours = inWorkingHours;
          SortCode = inSortCode;
          Manager = inManager;
//          theAddress = Add1;
    }
    
    // Making a protected function (~) so that you can access this only inside this package and not anywhere
    // else
    public String toString(){
        
        String Details =     "The working hours of the banks are :" + WorkingHours +"\n" 
                        + "The SORT Code of the Branch is :" + SortCode + "\n" 
                        + "The Name of the Bank Manager is :" + Manager + "\n"
                        + "The Address of the Branch is : " + theAddress.ToString()  ;
                        
        return Details;
        
        
    }
    
    public void Display(JTextArea output){

          output.setLineWrap(true);
          output.append(this.toString());

       
        
    }
    
    public void Display(){
        
          System.out.print(this.toString());

    }
    
    
    public void readFromFile(){
        FileReader newReader;
        
        try {
            
            newReader = new FileReader("EditBranchList.txt");
            BufferedReader theReader = new BufferedReader(newReader);
            this.Edit(theReader.readLine(), theReader.readLine(), theReader.readLine());
            theAddress.loadFromFile(theReader);
            theReader.close();
            theReader = null;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Branch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Branch.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }

    public void saveToFile(BufferedWriter bin){
        try {
          
            bin.append(WorkingHours + "\n" + SortCode + "\n" + Manager);
            theAddress.saveToFile(bin);
            
        } catch (IOException ex) {
            Logger.getLogger(Branch.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
    public String BranchID(){
        return this.theAddress.getBranchID();
    }
    
    public String SortCode(){
        return SortCode;
    }
    
    public static boolean isValid(String s) {
        if( (s.length() % 2) != 0) return false; 
        
        Stack<Character> S1 = new Stack<>();
        for (char c: s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                S1.push(c);
            }
            else if (c == ')' && !S1.isEmpty() && S1.peek() == '('){
                S1.pop();
            }
            else if (c == '}' && !S1.isEmpty() && S1.peek() == '{'){
                S1.pop();
            }
            else if (c == ']' && !S1.isEmpty() && S1.peek() == '['){
                S1.pop();
            }
            
        }
        return S1.isEmpty();
        
    }
    

    public static void main(String[] args){
        
//        IAddress add1 = new IAddress("Ranveer","Kingston Lane",45,"Fleming Hall","Uxbridge","UB8 2TR","Uxbridge","UK");
//        Branch b1 = new Branch("9:00 - 17:00","00-00-00","Ibrahim",add1);
//        System.out.print(b1.toString());
        String s1= "([}}])";
        
        System.out.print(isValid(s1));
    
       
    }
   
}