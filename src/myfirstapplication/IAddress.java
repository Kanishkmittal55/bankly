/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myfirstapplication;

/**
 *
 * @author Kanishk Mittal
 * 
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;




public class IAddress {
    
    // Declaration of Variables
    private String Name;
    private String Street;
    private String houseNo;
    private String houseName;
    private String Area;
    private String postCode;
    private String Town;
    private String Country;
    
    // As the lab prohibits us from implementing any getters or setters hence we initialize the variables using constructors
    public IAddress() {

// Code reuse has been effectively done using the Edit Method
           this.Edit("Default","SpiderHouse","0","Baker Street", "MayFair", "UB8 2TR", "London", "United Kingdom");
         
    }
    
    
    // Constructors with Paramters and as one can observe effective reuse of code has been done.
    public IAddress(String c_Name, String c_house_name, String c_house_no, String c_Street, String c_Area, String c_postCode, String c_Town, String c_Country) {
        this.Edit(c_Name, c_house_name, c_house_no, c_Street, c_Area, c_postCode, c_Town, c_Country);
    }
    
  
    public String ToString(){
        String Details =  (          Name + "\n"
                        + houseName + "\n"
                        + houseNo + "\n" 
                        + Street + "\n"   
                        + Area + "\n" 
                        + Town + "\n" 
                        + postCode + "\n" 
                        + Country + "\n"
                );
        
        System.out.print(Details);
        
        return Details;
         
    }
    
    public String getFullName(){
        return Name;
    }
    
    public void Display(JTextArea outputField){
//        outputField.setText(this.ToString());
//    outputField.setLineWrap(true);
    outputField.append("\n");
    outputField.append(this.ToString());
        
    }
    
    // Display Method belonging to the IAddress Class
//    public void Display(JList List){
//      DefaultListModel model = new DefaultListModel();
//      
//      model.add(0, Name+ ", "+ houseName + ", " + houseNo.toString() + ", " +
//                 Street + ", " + Area + ", " + postCode + ", " + Town + ", " + Country);
//         List.setModel(model);
//        
//    }
    
    public void Edit(String c_Name, String c_house_name, String c_house_no, String c_Street, String c_Area, String c_postCode, String c_Town, String c_Country) {
        Name = c_Name;
        Street = c_Street;
        houseNo = c_house_no;
        houseName = c_house_name;
        Area =  c_Area;
        postCode = c_postCode;
        Town = c_Town ;
        Country = c_Country;
    }
    

    public void loadFromFile(BufferedReader src){
        try {
            this.Edit(src.readLine(),src.readLine(),src.readLine(), src.readLine(), src.readLine(), src.readLine(), src.readLine(), src.readLine());
        } catch (IOException ex) {
            Logger.getLogger(IAddress.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    
//    public void saveToFile(FileWriter theWriter){
//        try {
//            theWriter.write(houseNo + "\n" + Street + "\n" +   houseName + "\n" +Area + "\n" +  postCode + "\n" + Town + "\n" +Country );
//            theWriter.write(System.getProperty("line.separator"));
//        } catch (IOException ex) {
//            Logger.getLogger(IAddress.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
//    
    public void saveToFile(BufferedWriter theWriter){
        try {
            theWriter.append("\n"+ Name+ "\n" + houseName + "\n" + houseNo + "\n" + Street + "\n" + Area + "\n" +Town + "\n" + postCode + "\n" + Country );
            
        } catch (IOException ex) {
            Logger.getLogger(IAddress.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
      public String getBranchID(){
        return Name;
    }
    
    public String getConatctNo(){
        return houseName;
    }
    
    
    public static void main(String[] args){
        
       int A = 10;
       int B = ++A;
       System.out.print(B);
       
    }
   
}
