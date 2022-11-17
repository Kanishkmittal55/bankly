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
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author 44789
 */
public class CustomerList {

    private ArrayList <Customer> Clients;
    
    
    
    public CustomerList(){
       Clients = new ArrayList<Customer>();
    }
    
    public CustomerList(Customer p1){
//    Clients.add(p1);    
    
    }
    
    
    public void Display(JTextArea src){
//        this.loadFromFile(src);
//        System.out.print(Clients.get(1).toString());
        for(int i = 0;i< Clients.size();i++){
            Clients.get(i).Display(src);
        }
        
        
    }
    
     public void Display(){
//        this.loadFromFile(src);
//        System.out.print(Clients.get(1).toString());
        for(int i = 0;i< Clients.size();i++){
            Clients.get(i).Display();
            System.out.print("\n");
        }
        
        
    }
    
    
    
    
    // To save a customer inside the Customer List
    public boolean saveToFile(Customer newCustomer, boolean append){
        boolean isSaved = true;
         try {
            FileWriter theWriter;
            
            theWriter = new FileWriter("ClientList.txt",append);
            BufferedWriter bin = new BufferedWriter(theWriter);
            bin.append("¬¬¬¬¬¬¬¬¬¬¬¬¬"+"\n");
            newCustomer.saveToFile(bin);
//            bin.append("\n");
            bin.close();
            bin = null;
            
        } catch (IOException ex) {
            Logger.getLogger(Branch.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isSaved;
    }
    
    
    // TO Save the entire Customer List Inside the file.
      public boolean saveToFile(boolean append){
        boolean isSaved = false;
         try {
            FileWriter theWriter;
            
            theWriter = new FileWriter("ClientList.txt",append);
            BufferedWriter bin = new BufferedWriter(theWriter);
            for(int i = 0; i<Clients.size();i++){
                bin.append("¬¬¬¬¬¬¬¬¬¬¬¬¬"+"\n");
               Clients.get(i).saveToFile(bin);
               
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
    
    
    // This functions purpose to to recreate the Customer List Object i.e Clients List once, it is created we can print in anywhere,
    // We can do anything to it.
    public boolean loadFromFile(JTextArea src){
        boolean isSaved = false;
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("ClientList.txt"));
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
       
            BufferedReader bufReader = new BufferedReader(new FileReader("ClientList.txt"));
            String line = bufReader.readLine(); 
            int count =0;
             while (line != null) { 
                line = bufReader.readLine();
                count++; 
             }
            bufReader.close();           
        return count;
    }

    
       public boolean createCustomerwithAllAccounts(){
        boolean isCreated = false;
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("ClientList.txt"));
//            ArrayList<String> listOfLines = new ArrayList<>();
            int length = this.CountLines();
            int length2 = length/49; 
//            String line = bufReader.readLine(); 
//            Customer [] myClients = new Customer[10]; 
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            for( int i = 0; i<length; i=+length+10){
               
              for(int k=1;k< length2+1 ;k++){
                
               String Delimitor = bufReader.readLine();
               String FirstName =  bufReader.readLine();
               System.out.print(FirstName+"\n");
               String SurName = bufReader.readLine();
               System.out.print(SurName+"\n");
               String DOB = bufReader.readLine();
               LocalDate finalDOB = LocalDate.parse(DOB, formatter);
               System.out.print(DOB+"\n");
               String CS= bufReader.readLine();
               LocalDate finalIsCustomerSince = LocalDate.parse(CS, formatter);
               System.out.print(CS+"\n");
               String FullName = bufReader.readLine();
               System.out.print(FullName+"\n");
               String NickName =bufReader.readLine();
               System.out.print(NickName+"\n");
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
               
               String CASortCode = bufReader.readLine();
               System.out.print(CASortCode + "\n");
               String CANo = bufReader.readLine();
               System.out.print(CANo + "\n");
               String CAinitialBalance = bufReader.readLine();
               System.out.print(CAinitialBalance + "\n");
               String CANameOfBank = bufReader.readLine();
               System.out.print(CANameOfBank + "\n");
               String CARate = bufReader.readLine();
               System.out.print(CARate + "\n");
               String CALRD = bufReader.readLine();
               LocalDate CAtheLRD = LocalDate.parse(CALRD, formatter);
               System.out.print(CAtheLRD + "\n");
               String typeCA = bufReader.readLine();
               System.out.print(typeCA);
               
               String CAOverDraft = bufReader.readLine();
               System.out.print(CAOverDraft + "\n");
               String CAconditions= bufReader.readLine();
               System.out.print(CAconditions + "\n");
               String CAAvailableBalance = bufReader.readLine();
               System.out.print(CAAvailableBalance + "\n");
               String CAOwnerName = bufReader.readLine();
               System.out.print(CAOwnerName + "\n");
               
               
               String SASortCode = bufReader.readLine();
               System.out.print(SASortCode + "\n");
               String SANo = bufReader.readLine();
               System.out.print(SANo + "\n");
               String SAinitialBalance = bufReader.readLine();
               System.out.print(SAinitialBalance + "\n");
               String SANameOfBank = bufReader.readLine();
               System.out.print(SANameOfBank + "\n");
               String SARate = bufReader.readLine();
               System.out.print(SARate + "\n");
               String SALRD = bufReader.readLine();
               LocalDate SAtheLRD = LocalDate.parse(SALRD, formatter);
               System.out.print(SAtheLRD + "\n");
               String typeSA = bufReader.readLine();
               System.out.print(typeSA);
               String SAwithdrawalLimit = bufReader.readLine();
               System.out.print(SAwithdrawalLimit + "\n");
               
               String SA2SortCode = bufReader.readLine();
               System.out.print(SA2SortCode + "\n");
               String SA2No = bufReader.readLine();
               System.out.print(SA2No + "\n");
               String SA2initialBalance = bufReader.readLine();
               System.out.print(SA2initialBalance + "\n");
               String SA2NameOfBank = bufReader.readLine();
               System.out.print(SA2NameOfBank + "\n");
               String SA2Rate = bufReader.readLine();
               System.out.print(SA2Rate + "\n");
               String SA2LRD = bufReader.readLine();
               LocalDate SA2theLRD = LocalDate.parse(SA2LRD, formatter);
               System.out.print(SA2theLRD + "\n");
               String typeSA2 = bufReader.readLine();
               System.out.print(typeSA2);
               String SA2withdrawalLimit = bufReader.readLine();
               System.out.print(SA2withdrawalLimit + "\n");
               
   
               String ISASortCode = bufReader.readLine();
               System.out.print(ISASortCode + "\n");
               String ISANo = bufReader.readLine();
               System.out.print(ISANo + "\n");
               String ISAinitialBalance = bufReader.readLine();
               System.out.print(ISAinitialBalance + "\n");
               String ISANameOfBank = bufReader.readLine();
               System.out.print(ISANameOfBank + "\n");
               String ISARate = bufReader.readLine();
               System.out.print(ISARate + "\n");
               String ISALRD = bufReader.readLine();
               LocalDate ISAtheLRD = LocalDate.parse(ISALRD, formatter);
               System.out.print(ISAtheLRD + "\n");
               String typeISA = bufReader.readLine();
               System.out.print(typeISA);
               String ISAmaximumLimitPerYear = bufReader.readLine();
               System.out.print(ISAmaximumLimitPerYear + "\n");
               String ISAdepositedThisYear = bufReader.readLine();
               System.out.print(ISAdepositedThisYear + "\n");
               
            
               currentAccount CA = new currentAccount(CASortCode, Integer.parseInt(CANo), Double.parseDouble(CAinitialBalance), CANameOfBank, Double.parseDouble(CARate), CAtheLRD, typeCA ,Double.parseDouble(CAOverDraft), CAconditions,  Double.parseDouble(CAAvailableBalance), CAOwnerName  ) ;
               savingAccount SA = new savingAccount(SASortCode, Integer.parseInt(SANo), Double.parseDouble(SAinitialBalance), SANameOfBank, Double.parseDouble(SARate), SAtheLRD, typeSA, Double.parseDouble(SAwithdrawalLimit) )  ;
               savingAccount SA2 = new savingAccount(SA2SortCode, Integer.parseInt(SA2No), Double.parseDouble(SA2initialBalance), SA2NameOfBank, Double.parseDouble(SA2Rate), SA2theLRD, typeSA2,Double.parseDouble(SA2withdrawalLimit) )  ;     
               ISAAccount ISA = new ISAAccount(ISASortCode, Integer.parseInt(ISANo), Double.parseDouble(ISAinitialBalance), ISANameOfBank, Double.parseDouble(ISARate), ISAtheLRD, typeISA, Double.parseDouble(ISAmaximumLimitPerYear), Double.parseDouble(ISAdepositedThisYear) )  ;
               
               Account[] allAccounts = new Account[4];
               allAccounts[0] = CA;
               allAccounts[1] = SA;
               allAccounts[2] = SA2;
               allAccounts[3] = ISA;
               
               
               Customer newCustomer = new Customer(FirstName,SurName,finalDOB,finalIsCustomerSince,
                       new IAddress(FullName,NickName, HouseNo, Street, Area, Town, PostCode, Country),
                       allAccounts  );
               
               Clients.add(newCustomer);
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
    
       
     
    public boolean createCustomerStatementList(){
        boolean isCreated = false;
        
        
        return isCreated;
    }
     
    
    public void addCustomer(Customer newCustomer){
        Clients.add(newCustomer);
       
    }
    
    public int size(){
        return Clients.size();
        
    }
   
    
    // Overloaded methods to Search Customers 
    

        // Search Customer using Full Name
     public Customer searchCustomer(String fullName){
        
        int length;
        length = Clients.size();
        
        Customer C1 = new Customer();
        
        for( int i = 0; i< length; i++){
            if(Clients.get(i).getFullName().equals(fullName)){
                C1 =  Clients.get(i);
            }
        }
        return C1;
    }
     
     // Helper Search method with different methods used at two places and a different return type as well, to enable popups 
     public boolean searchCustomer( String FirstName, String SurName, JTextArea src){
        src.setText("");
        boolean isFound = false;
        int length = Clients.size();
        for(int i =0;i< length;i++){
            if(Clients.get(i).getSurname().equals(SurName) && Clients.get(i).getFirstName().equals(FirstName)){
               src.append(Clients.get(i).displayAllAccountsOwned());
               isFound = true;
               return isFound;
            }
        }
        return isFound;
    }
    
    
   // Delete Customer using First Name and Sur Name
    public boolean deleteCustomerBySurname(String SurName, String FirstName){
        boolean isDeleted = false;
        int length;
        length = Clients.size();
        for( int i = 0; i< length; i++){
            if(Clients.get(i).getSurname().equals(SurName) && Clients.get(i).getFirstName().equals(FirstName)){
                Clients.remove(i);
                isDeleted = true;
                return isDeleted; 
            }
        }
        return isDeleted;
    } 
    
    
    
    // Our first relevant function that is working with the owned accounts array.
    public boolean displayCustomerAccountFromName(String fullName, JTextArea src){
        
        boolean isFound = false;
        int length = Clients.size();
        for(int i =0;i< length;i++){
            if(Clients.get(i).getFullName().equals(fullName)){
               src.append(Clients.get(i).displayAllAccountsOwned());
               isFound = true;
            }
        }
        
        return isFound;
    }
    
    // Our Second relevant function working with the accounts array.
     public boolean displayCustomerAccountsFromName(String fullName, JComboBox src){
         
        ArrayList<Integer> AccountNo = new ArrayList<>();
        
        boolean isFound = false;
        int length = Clients.size();
        for(int i =0;i< length;i++){
            
            if(Clients.get(i).getFullName().equals(fullName)){
                
               AccountNo =  Clients.get(i).displayAllAccountNoOwnedOfACustomer();
               for(int j=0; j< AccountNo.size();j++){
                  src.addItem(AccountNo.get(j)); 
               }
               
               isFound = true;
            }
        }
        
        return isFound;
    }
    
     
    // Our third relevant function working with the account array, getting its balance.
     public boolean displayCustomerBalance(String fullName, JTextField src, int theAccountNo){
         
        ArrayList<Account> AccountNos = new ArrayList<>();
        Account[] AccountNos1 = new Account[4];
        
        boolean isFound = false;
        int length = Clients.size();
        for(int i =0;i< length;i++){
            if(Clients.get(i).getFullName().equals(fullName)){
               AccountNos1 =  Clients.get(i).getOwnedAccounts1();
               for(int j =0 ; j < AccountNos1.length; j++){
                   if(AccountNos1[j].getAccountNo() == theAccountNo){
                       src.setText(String.valueOf(AccountNos1[j].getBalance()));
                    }
               }
        
               isFound = true;
            }
        }
        
        return isFound;
    }
    
    
    
    public boolean displayCustomerNameFromAccount(String AccountNo, JTextArea src){
        
        boolean isFound = false;
        int length = Clients.size();
        for(int i =0;i< length;i++){
            Account[] Array1 = Clients.get(i).getOwnedAccounts1();
     
        }
        
        return isFound;
    }
    
    
    
     public boolean tranferMoney( String senderName, String receiverName,int senderAcc, int receiverAcc, double amount){
       boolean isTransfered1 = false;
         
       try {
        boolean isTransfered = false;
    
        int length = Clients.size();
        
        double oldSenderBalance = 0;
        double newSenderBalance = 0;
        double oldReceiverBalance = 0;
        double newReceiverBalance = 0;
        
//        Customer sender = new Customer();
        
        
        // Updating senderBalance
        Account[] AccountNos = new Account[4];
        
        for(int i =0;i< length;i++){
            
            // Here is where we find the Customer 
            if(Clients.get(i).getFullName().equals(senderName)){
             
                AccountNos =  Clients.get(i).getOwnedAccounts1();
                Customer sender = Clients.get(i);
                
               
               for(int j =0 ; j < AccountNos.length; j++){
                   
                    // Here is where we find the specific account of a customer from which they intiated the transaction
                   if(AccountNos[j].getAccountNo() == senderAcc){
                       
                       oldSenderBalance = AccountNos[j].getBalance();
                       
                       AccountNos[j].withdraw(amount);
                       
                       newSenderBalance = AccountNos[j].getBalance();
                       
                        ArrayList<String> entry = new ArrayList<>();
                        entry.add("Withdrawal");
                        entry.add(String.valueOf(amount));
                        entry.add(senderName);
                        entry.add(String.valueOf(senderAcc));
                        entry.add(receiverName);
                        entry.add(String.valueOf(receiverAcc));
                        entry.add(String.valueOf(oldSenderBalance));
                        entry.add(String.valueOf(newSenderBalance));
                        entry.add(String.valueOf(LocalDate.now()));
                        entry.add(String.valueOf(LocalTime.now()));
                        
                        ArrayList<ArrayList<String>> allEntries = new ArrayList<>();
                        allEntries.add(entry);
                        sender.getStatements().put(AccountNos[j],allEntries);
                    }
                      
               }
            }
        }
        
         // Updating Receiver Balance 
        Account[] AccountNos2 = new Account[4];
        
        for(int i =0;i< length;i++){
            if(Clients.get(i).getFullName().equals(receiverName)){
               
                AccountNos2 =  Clients.get(i).getOwnedAccounts1();
                Customer receiver = Clients.get(i);
                
                
               for(int j =0 ; j < AccountNos2.length; j++){
                   
                   
                   if(AccountNos2[j].getAccountNo() == receiverAcc){
                       
                       oldReceiverBalance = AccountNos2[j].getBalance();
                       
                       AccountNos2[j].deposit(amount);
                       
                       newReceiverBalance = AccountNos2[j].getBalance();
                       
                       ArrayList<String> entry2 = new ArrayList<>();
                        entry2.add("Deposit");
                        entry2.add(String.valueOf(amount));
                        entry2.add(senderName);
                        entry2.add(String.valueOf(senderAcc));
                        entry2.add(receiverName);
                        entry2.add(String.valueOf(receiverAcc));
                        entry2.add(String.valueOf(oldReceiverBalance));
                        entry2.add(String.valueOf(newReceiverBalance));
                        String date = String.valueOf(LocalDate.now());
                        entry2.add(date);
                        entry2.add(String.valueOf(LocalTime.now()));
                        
                        ArrayList<ArrayList<String>> allEntries = new ArrayList<>();
                        allEntries.add(entry2);
                        receiver.getStatements().put(AccountNos[j],allEntries);
                    }
                      
               }
            }
        }
        
        
       
 
        // Writing all the details of a specific transaction to file
        FileWriter theWriter;
        theWriter = new FileWriter("Statement.txt",true);
        BufferedWriter bin = new BufferedWriter(theWriter);
        bin.write("¬¬¬¬¬¬¬New Transaction¬¬¬¬¬¬¬¬¬¬|\n");
        bin.write(amount+ "\n");
        bin.write("¬¬¬¬¬¬¬Sender and Receiver¬¬¬¬¬¬|\n");
        bin.write("From" + "\n");
        bin.write(senderName + "\n");
        bin.write(senderAcc + "\n");
        bin.write("To" + "\n");
        bin.write(receiverName +"\n");
        bin.write(receiverAcc +"\n");
        bin.write("¬¬¬¬¬¬¬¬¬¬¬Old Balances¬¬¬¬¬¬¬¬|\n");
        bin.write(oldSenderBalance + "\n");
        bin.write(oldReceiverBalance + "\n");
        bin.write("¬¬¬¬¬¬¬¬¬¬New Balances¬¬¬¬¬¬¬¬¬|\n");
        bin.write(newSenderBalance + "\n");
        bin.write(newReceiverBalance + "\n");
        bin.write("¬¬¬¬¬¬¬¬¬¬DATE & TIME¬¬¬¬¬¬¬¬¬¬|\n");
        bin.write(String.valueOf(LocalDate.now()) + "\n");
        bin.write(String.valueOf(LocalTime.now()) + "\n");
        bin.write("\n");
        
        
        bin.close();
        bin = null;
        
        isTransfered = true;
        return isTransfered;
        
        } catch (IOException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
        }

       return isTransfered1; 
    }
     
//     
//     // Getting only Balance For tranfer funds
//     public boolean searchCustomerByAccount( int AccNo, JTextField src){
//        src.setText("");
//        boolean isFound = false;
//        int length = Clients.size();
//        for(int i =0;i< length;i++){
//            if(Clients.get(i).getAccountNo() == AccNo){
//               double Balance = Clients.get(i).getAccounts().getBalance();
//               src.setText(String.valueOf(Balance));
//               isFound = true;
//               return isFound;
//            }
//        }
//        return isFound;
//    }
//     
     // Getting customer By account Number
     public boolean searchCustomerNameByAccountNo( int AccNo, JTextArea src){
        src.setText("");
       boolean isFound = false;
        int length = Clients.size();
        for(int i =0;i< length;i++){
            int length2 = Clients.get(i).getOwnedAccounts1().length;
            for(int j = 0;j<length2;j++){
                if(Clients.get(i).getOwnedAccounts1()[j].getAccountNo() == AccNo){
                   src.setText(Clients.get(i).getFullName() +"\n"+ Clients.get(i).getAddress());
                   isFound = true;
                   return isFound;
                }
            }
       
        }
        return isFound;
    }
     
     // Getting statements By account Number
     public boolean searchStatementsByAccountNo(int AccNo, JTextArea src){
         src.setText("");
         boolean isFound = false;
          int length = Clients.size();
        for(int i =0;i< length;i++){
            int length2 = Clients.get(i).getOwnedAccounts1().length;
            for(int j = 0;j<length2;j++){
                if(Clients.get(i).getOwnedAccounts1()[j].getAccountNo() == AccNo){
                   src.setText(Clients.get(i).getStatements().toString());
                   isFound = true;
                   return isFound;
                }
            }
       
        }
        return isFound;    
     }
 
     

    
    
    public static void main(String[] args){
        
          CustomerList C1 = new CustomerList();
          
          Customer first = new Customer();
          Customer second = new Customer();
          Customer third = new Customer();
          C1.addCustomer(first);
          C1.addCustomer(second);
          C1.addCustomer(third);
          C1.createCustomerwithAllAccounts();

          C1.Display();
          System.out.print("\n");
  
    }
    
  
}
