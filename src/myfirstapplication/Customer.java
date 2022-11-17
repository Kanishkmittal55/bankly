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
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author 44789
 */
public class Customer {
    
    private String FirstName;
    private String SurName;
    private IAddress HomeAddress;
    private LocalDate  DOB;
    private LocalDate CustomerSince;
    private Account[] OwnedAccounts1; 
    private Customer CoOwner;
    protected HashMap<Account, ArrayList<ArrayList<String>>> Statements = new HashMap<>();
    
  
    public Customer (){
        this.Edit("Kanishk", "Mittal", LocalDate.of(2018,10,01),LocalDate.of(1995,9,2) , new IAddress(), new Account[4]);
    }
    
     public Customer(String theFirstName, String theSurName, LocalDate theDOB, LocalDate isCustomerSince,  IAddress theHomeAddress,Account[] OwnedAccounts ){
        this.Edit( theFirstName , theSurName, theDOB, isCustomerSince, theHomeAddress, OwnedAccounts);
    }
     
    // Encapsulation promotes code Reuse.   
     public void Edit(String theFirstName, String theSurName, LocalDate theDOB, LocalDate isCustomerSince, IAddress theHomeAddress, Account[] allAccounts){
        FirstName = theFirstName;
        SurName = theSurName;
        HomeAddress = theHomeAddress;
        DOB = theDOB;
        CustomerSince = isCustomerSince;
        this.OwnedAccounts1 = allAccounts;
        
    }

    
     
      public int CountLines() throws IOException{
       
            BufferedReader bufReader = new BufferedReader(new FileReader("Statement.txt"));
            String line = bufReader.readLine(); 
            int count =0;
             while (line != null) { 
                line = bufReader.readLine();
                count++; 
             }
            bufReader.close();           
        return count;
    }
     
     public boolean createStatementList(){
         boolean isCreated = false;
        try {
           
            ArrayList<String> entry = new ArrayList<>();
            ArrayList<ArrayList<String>> statement = new ArrayList<>();
            
            BufferedReader bufReader = new BufferedReader(new FileReader("Statement.txt"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");       
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
            int length = this.CountLines();
            int length2 = length/18; 

      
              for(int k=1;k <= length2 ;k++){
                
               String Delimitor1 = bufReader.readLine();
               System.out.print( Delimitor1+"\n");
               
               int amount =  Integer.parseInt(bufReader.readLine());
               System.out.print( amount+"\n");
               
               String Delimitor2 = bufReader.readLine();
               System.out.print( Delimitor2+"\n");
               
               String Delimitor3 = bufReader.readLine();
               System.out.print( Delimitor3+"\n");
               
               String senderName = bufReader.readLine();
               System.out.print( senderName+"\n");
               
               String senderAccNo = bufReader.readLine();
               System.out.print( senderAccNo +"\n");
               
               String Delimitor4 = bufReader.readLine();
               System.out.print( Delimitor4+"\n");
               
               String receiverName = bufReader.readLine();
               System.out.print( receiverName+"\n");
               
               String receiverAccNo = bufReader.readLine();
               System.out.print(receiverAccNo+"\n");
               
               String Delimitor5 = bufReader.readLine();
               System.out.print( Delimitor4+"\n");
               
               double oldSenderBalance = Double.parseDouble(bufReader.readLine());
               System.out.print(oldSenderBalance+"\n");
               
               double oldReceiverBalance = Double.parseDouble(bufReader.readLine());
               System.out.print(oldReceiverBalance+"\n");
               
               String Delimitor6 = bufReader.readLine();
               System.out.print( Delimitor4+"\n");
               
               double newSenderBalance = Double.parseDouble(bufReader.readLine());
               System.out.print(newSenderBalance+"\n");
               
               double newReceiverBalance = Double.parseDouble(bufReader.readLine());
               System.out.print(newReceiverBalance+"\n");
               
               String dateTransferred = bufReader.readLine();
               LocalDate thedateTransferred = LocalDate.parse(dateTransferred, formatter);
               System.out.print(thedateTransferred+"\n");
               
               String timeOfTransfer = bufReader.readLine();
               LocalTime theTimeOfTransfer = LocalTime.parse(timeOfTransfer, formatter);
               System.out.print(theTimeOfTransfer+"\n");
               
               String space = bufReader.readLine();
               System.out.print(space);
               
              // For sender , the entry will be of a withdarwal because they sent money to someone or some account 
              
               for(int j= 0; j < this.OwnedAccounts1.length; j++){
                   if(this.OwnedAccounts1[j].getAccountNo() == Integer.parseInt(senderAccNo)){
                        
                        entry.add("");
                        entry.add(senderName);
                        entry.add(senderAccNo);
                        entry.add(receiverName);
                        entry.add(receiverAccNo);
                        entry.add(String.valueOf(oldSenderBalance));
                        entry.add(String.valueOf(oldReceiverBalance));
                        entry.add(String.valueOf(newSenderBalance));
                        entry.add(String.valueOf(newReceiverBalance));
                        entry.add(dateTransferred);
                        entry.add(timeOfTransfer);
                        statement.add(entry);
                        ArrayList<ArrayList<String>> allEntries = new ArrayList<>();
                        allEntries.add(entry);
                        Account A1 = this.OwnedAccounts1[j];
                        
                        this.Statements.put(A1, allEntries);
                   }
                  
               }
               
               //For receiver , the same entry will be of deposit because they received from someone or some account
               
               for(int j= 0; j < this.OwnedAccounts1.length; j++){
                   if(this.OwnedAccounts1[j].getAccountNo() == Integer.parseInt(senderAccNo)){
                        
                        entry.add(String.valueOf(amount));
                        entry.add(senderName);
                        entry.add(senderAccNo);
                        entry.add(receiverName);
                        entry.add(receiverAccNo);
                        entry.add(String.valueOf(oldSenderBalance));
                        entry.add(String.valueOf(oldReceiverBalance));
                        entry.add(String.valueOf(newSenderBalance));
                        entry.add(String.valueOf(newReceiverBalance));
                        entry.add(dateTransferred);
                        entry.add(timeOfTransfer);
                        statement.add(entry);
                        ArrayList<ArrayList<String>> allEntries = new ArrayList<>();
                        allEntries.add(entry);
                        Account A1 = this.OwnedAccounts1[j];
                        
                        this.Statements.put(A1, allEntries);
                   }
               }
               
               }
             
//          System.out.print(length);
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

     
    public void editCustomerAddress(String name, String HouseName, String HouseNo, String Street, String Area, String Town, String PostCode, String Country){
        HomeAddress.Edit(name, HouseName, HouseNo, Street, Area, PostCode, Town, Country);
       
    }
      
     public String getAddress(){
        return HomeAddress.ToString();
    }
    
    public String getCustomerSince(){
        return String.valueOf(CustomerSince);
    }
    
  
   
    public String toString() {
        String Details = "The name of the Person is : \n" + FirstName + " "+ SurName + "\n" 
                        +"His/Her Date of Birth is : " + DOB + "\n" 
                        +"This Person has been the bank's Customer since : " + CustomerSince + "\n"
                        +"The address of the person is : " + "\n" + HomeAddress.ToString() 
                        ;
                        
                        
        
        return Details;
    }
    
    
    public String getSurname(){
        return SurName;
    }
    
    public String getFirstName(){
        return FirstName;
    }
    
    public String getFullName(){
        return FirstName + SurName;
    }
    
    
    public HashMap<Account, ArrayList<ArrayList<String>>> getStatements(){
        return Statements;
    }
    public void Display(JTextArea src){
        
          src.setLineWrap(true);
          src.append(this.toString());
//        HomeAddress.Display(output);
//        String str = output.getText();
//        output.setText(this.ToString() + "\n" + str);
        
    }
    
     public void Display(){

          System.out.print(this.toString());
        
    }
    
    
    public void saveToFile(BufferedWriter bin){
        try {
            
            bin.append(FirstName + "\n" + SurName + "\n" + DOB + "\n" + CustomerSince);
            HomeAddress.saveToFile(bin);
            
            for(int i = 0; i<this.OwnedAccounts1.length; i++){
                OwnedAccounts1[i].saveToFile(bin);
            }
//            OwnedAccounts.saveToFile(bin);
//            bin.append(CoOwner.toString())
           
            
        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
  
     

    
    
    // Overloaded Methods to add any accounts but there has to be a limit.
    public int addAnyAccountCustomer(currentAccount CA, int count){
        OwnedAccounts1[count] = CA;
        return 1;
    }
    
    public int addAnyAccountCustomer(savingAccount SA, int count){
        this.OwnedAccounts1[count] = SA;
        return 1;
    } 
    
    public int addAnyAccountCustomer(ISAAccount ISA1, int count){
        this.OwnedAccounts1[count] = ISA1;
        return 1;
    }
    
    
    
    public String displayAllAccountsOwned(){
        String details = "";
        if (this.OwnedAccounts1 == null){
            details = "You have not set up that variable that is why error";
        }
        else if (this.OwnedAccounts1.length <= 0){
           details  = this.getFullName() + " has no accounts with our bank." ;  
        }
        else{
           details  = this.getFullName() + " has " + this.OwnedAccounts1.length + " accounts with our bank, their details are : \n";   
           for(int i= 0 ;i< this.OwnedAccounts1.length; i++){
              details  += "\n" + this.OwnedAccounts1[i].display()+ "\n";
          }
        }
        return details;
    }
    
    
//    //Above function but for the hashmap
//   public String getAllAccoutLinkedToACustomer(){
//       String details = "";
//       if (this.OwnedAccounts2 == null){
//           details = "You have not set up that variable that is why error";
//       }
//       else if(this.OwnedAccounts2.isEmpty()){
//           details  = this.getFullName() + " has no accounts with our bank." ; 
//       }
//       else{
//           var entrySet = this.OwnedAccounts2.entrySet();
//           
//           for(var entry: entrySet){
//               details += "Account Index : "+ entry.getKey()+ "-->\n" + entry.getValue().display() + "\n";
//           } 
//        }
//       
//       return details;
//   }
    
    
   // Displaying all the account no a customer has with our bank
    public ArrayList<Integer> displayAllAccountNoOwnedOfACustomer(){
        ArrayList<Integer> details = new ArrayList<>();
        if (this.OwnedAccounts1 == null){
            details.add(-1);
        }
        else if (this.OwnedAccounts1.length <= 0){
           details.add(0) ;  
        }
        else{
//           details  = this.getFullName() + " has " + this.OwnedAccounts1.length + " accounts with our bank, their details are : \n";   
           for(int i= 0 ;i< this.OwnedAccounts1.length; i++){
              details.add(this.OwnedAccounts1[i].getAccountNo());
          }
        }
        return details;
    }
    
    
    // Displaying the balances of a specific account number 
    public double displayBalanceOfOneAccount(int AccountNo){
        ArrayList<Integer> details = new ArrayList<>();
        if (this.OwnedAccounts1 == null){
            details.add(-1);
        }
        else if (this.OwnedAccounts1.length <= 0){
           details.add(0) ;  
        }
        else{             
           for(int i= 0 ;i< this.OwnedAccounts1.length; i++){
              if(this.OwnedAccounts1[i].getAccountNo() == AccountNo){
                  return this.OwnedAccounts1[i].getBalance();
              }  
          }
        }
        
        return -1;
        
    }
    
    // getting the account object using an account number 
//    public Account getASpecificAccount(int AccountNo){
//        Account theAccount = new Account();
//        for(int i= 0 ;i< this.OwnedAccounts1.length; i++){
//              if(this.OwnedAccounts1[i].getAccountNo() == AccountNo){
//                  theAccount=  this.OwnedAccounts1[i];
//              }  
//          }
//        return theAccount;
//    }
    
    
  
   
   
   
   
   
    public Account[] getOwnedAccounts1(){
        return OwnedAccounts1;
    }
    
    
    
    

    
  
    
      public static void main(String[] args){
        
//          IAddress A1 = new IAddress();
          Customer C1 = new Customer();
//          C1.getAccounts().deposit(10);
//          System.out.print(C1.getAccounts().getBalance());
          
          C1.OwnedAccounts1 = new Account[2];
          
          currentAccount CA1 = new currentAccount("00-04-00", 234567890 , 96.45, "Lloyds", 1.2, LocalDate.of(1990,11,01),"CA", 100, "should be intelligent", 90, "Ishah");
          savingAccount SA1 = new savingAccount("00-04-00", 234567 , 96.45, "Lloyds", 1.2, LocalDate.of(1990,11,01),"B1", 100);
//          currentAccount CA3 = new currentAccount("00-04-00", 234567890 , 96.45, "Lloyds", 1.2, LocalDate.of(1990,11,01), 100, "should be intelligent", 90, "Ishah");
          
          Account[] allAccounts = new Account[2];
          
          C1.OwnedAccounts1[0] = CA1;
          C1.OwnedAccounts1[1] = SA1;
//          C1.OwnedAccounts2.put(1, CA1);
//          C1.OwnedAccounts2.put(2, SA1);
//          allAccounts[2] = CA1;
//          System.out.print(C1.displayAllAccountsOwned());
          System.out.print(C1.displayAllAccountNoOwnedOfACustomer());
          
    }
   
}
