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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author 44789
 */
public class BranchList {
    private ArrayList <Branch> Branches;
    
    public BranchList(){
        Branches = new ArrayList<Branch>();
    }
    
    public void Display(JTextArea src){
//        this.loadFromFile(src);
//        System.out.print(Clients.get(1).toString());
        for(int i = 0;i< Branches.size();i++){
            Branches.get(i).Display(src);
        }
        
        
    }
    
    public void Display(){
//        this.loadFromFile(src);
//        System.out.print(Clients.get(1).toString());
        for(int i = 0;i< Branches.size();i++){
            Branches.get(i).Display();
        }
        
        
    }
    
    public boolean saveToFile(Branch newBranch, boolean append){
        boolean isSaved = true;
         try {
            FileWriter theWriter;
            
            theWriter = new FileWriter("EditBranchList.txt",append);
            BufferedWriter bin = new BufferedWriter(theWriter);
            newBranch.saveToFile(bin);
//            bin.append("\n");
            bin.close();
            bin = null;
            
        } catch (IOException ex) {
            Logger.getLogger(Branch.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSaved;
    }
    
    // For the entire file.
    public boolean saveToFile(boolean append){
        boolean isSaved = false;
         try {
            FileWriter theWriter;
            
            theWriter = new FileWriter("EditBranchList.txt",append);
            BufferedWriter bin = new BufferedWriter(theWriter);
            bin.append("¬¬¬¬¬¬¬¬¬¬¬¬¬"+"\n");
            for(int i = 0; i<Branches.size();i++){
               Branches.get(i).saveToFile(bin);
               
            }
            isSaved = true;
            
//            bin.append("\n");
            bin.close();
            bin = null;
            
            return isSaved;
            
        } catch (IOException ex) {
            Logger.getLogger(Branch.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSaved;
    }
    
     public boolean loadFromFile(JTextArea src){
        boolean isSaved = false;
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("EditBranchList.txt"));
            ArrayList<String> listOfLines = new ArrayList<>();
            String line = bufReader.readLine(); 
            
             while (line != null) { 
                listOfLines.add(line); 
                line = bufReader.readLine();
                System.out.print(line+ "\n");
                src.append(line + "\n");
                
                
            }
             
            bufReader.close();
            isSaved = true;            
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSaved; 
    }
     
     public int CountLines() throws IOException{
       
            BufferedReader bufReader = new BufferedReader(new FileReader("EditBranchList.txt"));
            String line = bufReader.readLine(); 
            int count =0;
             while (line != null) { 
                line = bufReader.readLine();
                count++; 
             }
            bufReader.close();           
        return count;
    }
     
     public boolean create(){
        boolean isCreated = false;
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("EditBranchList.txt"));
            ArrayList<String> listOfLines = new ArrayList<>();
            int length = this.CountLines();
            int length2 = length/11; 
//            String line = bufReader.readLine(); 
//            Customer [] myClients = new Customer[10]; 
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            for( int i = 0; i<length; i=+length+10){
               
              for(int k=1;k< length2+1 ;k++){
                
               String Delimitor = bufReader.readLine();
               String WorkingHours =  bufReader.readLine();
               System.out.print(WorkingHours+"\n");
               String SortCode = bufReader.readLine();
               System.out.print(SortCode+"\n");
               String Manager = bufReader.readLine();
               System.out.print(Manager+"\n");
               String BranchID = bufReader.readLine(); // BranchID = full Name
               System.out.print(BranchID+"\n");        // ContactNo = Nick name
               String ContactNo =bufReader.readLine();
               System.out.print(ContactNo+"\n");
               String HouseNo = bufReader.readLine();
               System.out.print(HouseNo+"\n");
               String Street = bufReader.readLine();
               System.out.print(Street+"\n");
               String Area = bufReader.readLine();
               System.out.print(Area+"\n");
               String Town = bufReader.readLine();
               System.out.print(Town+"\n");
               String PostCode = bufReader.readLine();
               System.out.print(PostCode+"\n");
               String Country = bufReader.readLine();
               System.out.print(Country+ "\n");

               Branch newBranch = new Branch(WorkingHours,SortCode,Manager,new IAddress(BranchID, ContactNo, HouseNo, Street, Area, Town, PostCode, Country));
               Branches.add(newBranch);
               }
  
            }

            bufReader.close();
            isCreated = true;
            return isCreated;
      
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCreated; 
    }
     
     
    
    public void addBranch(Branch newBranch){
        Branches.add(newBranch);
       
    }
    
    public int size(){
        return Branches.size();
        
    }
    
    public void deleteBranch(Branch branch){
        Branches.remove(branch);
        
    }
    
    public boolean deleteBranchByID(String branchID, String SortCode){
        boolean isDeleted = false;
        int length;
        length = Branches.size();
        for( int i = 0; i< length; i++){
            if(Branches.get(i).BranchID().equals(branchID) && Branches.get(i).SortCode().equals(SortCode)){
                Branches.remove(i);
                isDeleted = true;
                return isDeleted; 
            }
        }
        return isDeleted;
    }  
    
    public static void main(String[] args){
        
//          BranchList C1 = new BranchList();
//          
////          Customer first = new Customer();
////          Customer second = new Customer();
////          Customer third = new Customer();
////          C1.addCustomer(first);
////          C1.addCustomer(second);
////          C1.addCustomer(third);
////          
//          C1.create();
//          C1.deleteBranchByID("04", "98-87-11");
//           
////          System.out.print(C1);
//          C1.Display();
////         C1.loadFromFile();
//          
////          C1.addCustomer(first);
//          
////          C1.saveToFile(first);
            
        
          
    }
        
    
}
