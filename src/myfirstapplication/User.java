package myfirstapplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 44789
 */
public class User{
    private String firstName;
    private String surName;
    private String role;
    private String Email;
    private String contactNo;
    private String password;
    private String fileName;
    private String password2;

    
    public User(String thefirstName,String theSurName, String theRole,String theEmail,String theContactNo, String thePassword, String thePassword2) {
        
        firstName = thefirstName;
        surName = theSurName;
        role = theRole;
        Email = theEmail;
        contactNo = theContactNo;
        password = thePassword;
        password2 = thePassword2;
        
    }
    
    public User(){
        firstName = "John";
        surName = "Doe";
        role = "God";
        Email = "dummy@gmail.com";
        contactNo = "100";
        password = "1234";
        password2 = "1234";
    }

     public int CountLines() throws IOException{
       
            BufferedReader bufReader = new BufferedReader(new FileReader("login.txt"));
            String line = bufReader.readLine(); 
            int count =0;
             while (line != null) { 
                line = bufReader.readLine();
                count++; 
             }
            bufReader.close();           
        return count;
    }


    public boolean isRegistered (boolean append,String strFirstName,String strSurName,String theRole, String strEmail,String strContactNo ,String strPassword,String strPassword2) throws IOException{
        boolean isRegistered = false;
        
        
        firstName = strFirstName;
        surName = strSurName;
        role = theRole;
        Email = strEmail;
        contactNo = strContactNo;
        password = strPassword;
        password2 = strPassword2;
        
        try {
            FileWriter theWriter;
            
            theWriter = new FileWriter("login.txt",append);
             BufferedWriter bin = new BufferedWriter(theWriter);
            int length = this.CountLines();

            bin.write("\n" );
            bin.write("FullName:"+firstName + surName + "\r\n" );
            bin.write("password:"+ password+"\r\n");
            bin.write("Designation:"+ role +"\r\n");
            bin.write("ContactNo.:"+ contactNo+"\r\n");
            bin.write("Email:"+ Email +"\n");
            
            bin.close();
            bin = null;
                 
            isRegistered = true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isRegistered;
    }
    
   
    public boolean isUser(String checkFullName, String checkPassword)throws IOException{
        
            boolean isFound = false;
             BufferedReader bufReader = new BufferedReader(new FileReader("login.txt"));
            int length = this.CountLines();
            for(int i = 0; i< length; i+=6){
                
                System.out.println("count " + i);
                
                String forFullName = bufReader.readLine().substring(9);

                String forPassword = bufReader.readLine().substring(9);

                String forRole = bufReader.readLine().substring(12);

                String forContactNo = bufReader.readLine().substring(12);

                
                
                if(checkFullName.equals(forFullName) && checkPassword.equals(forPassword)){
                    isFound = true;
                    break;
                    
                }
                else if(i == length) {
                    isFound = false;
                    break;
                }
                
                for(int k=1;k<=2;k++){
                   bufReader.readLine();
                   
                }
                
            }
        return isFound;
    }
    
    
    public boolean isManager(String checkFullName, String checkPassword, String chkDesignation) throws IOException{
        boolean isManager = false;
        BufferedReader bufReader = new BufferedReader(new FileReader("login.txt"));
            int length = this.CountLines();
            for(int i = 0 ; i< length ; i+=6){
                
                System.out.println("count " + i);
                  String forFullName = bufReader.readLine().substring(9);

                  String forPassword = bufReader.readLine().substring(9);

                  String forRole = bufReader.readLine().substring(12);

                  String forContactNo = bufReader.readLine().substring(12);

                
                if(checkFullName.equals(forFullName) && checkPassword.equals(forPassword) && chkDesignation.equals(forRole)){
                    isManager = true;
                    break;
                    
                    
                }
                else if(i==(length-5)){
                    isManager = false;
                    
                }
                
                for(int k=1;k<=2;k++){
                  bufReader.readLine();
                   
                }
                
            }
        return isManager;
    }
    public static void main (String [] args){
        

    }
    
}
