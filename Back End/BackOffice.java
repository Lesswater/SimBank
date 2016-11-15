import java.io.*;
import java.util.ArrayList;
import Components.*;
public class BackOffice{
   public static void main (String[]args){
      //Read in the Master Accounts file and the Merged Transaction Summary file
      Shared.masterAccounts = createArrayListFromFile(args[0]);
      Shared.dailyTransactions = createArrayListFromFile(args[1]);
      int numberOfTransactions = Shared.dailyTransactions.size();
      
      //Loop through Transactions in the dailyTransactions ArrayList, and execute each one
      for(int i = 0 ; i < numberOfTransactions ; i++){
         String[]currentTransactionLine = Shared.dailyTransactions.get(i);
         Transactions currentTransaction;
         if(currentTransactionLine[0].equals("DE")){
            currentTransaction = new Deposit();
            currentTransaction.completeTransaction(currentTransactionLine);
         }else if(currentTransactionLine[0].equals("WD")){
            currentTransaction = new Withdraw();
            currentTransaction.completeTransaction(currentTransactionLine);
         }else if(currentTransactionLine[0].equals("TR")){
            currentTransaction = new Transfer();
            currentTransaction.completeTransaction(currentTransactionLine);
         }else if(currentTransactionLine[0].equals("CR")){
            currentTransaction = new Create();
            currentTransaction.completeTransaction(currentTransactionLine);
         }else if(currentTransactionLine[0].equals("DL")){
            currentTransaction = new Delete();
            currentTransaction.completeTransaction(currentTransactionLine);
         }else if(currentTransactionLine[0].equals("ES")){
            //Do nothing
         }else{
            System.out.println("Fatal Error: Unrecognized Transaction deteceted!");
            System.exit(1);
         }
      }
      writeToFile(args[0],"Valid Accounts.txt");
   }
   
   /* Overwrites the current Master Accounts file and Valid Accounts file
   with data from the Master Accounts ArrayList
   */
   private static void writeToFile(String master, String valids) {
       String tempMsg = "";
       try{
           FileWriter masterFile = new FileWriter(master);
           FileWriter validAccFile = new FileWriter(valids);
           
           //Writes each line of the Master Accounts file and Valid Accounts file
           for (int i = 0; i < Shared.masterAccounts.size(); i++) {
               tempMsg = Shared.masterAccounts.get(i)[0] + " " + Shared.masterAccounts.get(i)[1] + " " + Shared.masterAccounts.get(i)[2];
               masterFile.write(tempMsg + "\r\n");
               validAccFile.write(Shared.masterAccounts.get(i)[0] + "\r\n");
            }
            validAccFile.close();
            masterFile.close();
        }catch (IOException e) {
   		   e.printStackTrace();
   	  }
    }
   /* Creates an ArrayList from a file, which has a name determined by the given paramter.
   Returns a new ArrayList, where the ith element is a a String Array conatining x elements,
   where x = the number of space delimeted tokens on the ith line of the file.
   */ 
   public static ArrayList<String[]> createArrayListFromFile(String filename){
      String currentLine = "";
      ArrayList <String[]> tempList = new ArrayList<String[]>();
      //Reads in each line of a file and appends it to currentLine. To
      //be separated into tokens for easier use
      
      try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            //Adds each line to the new ArrayList
            while((currentLine = br.readLine()) != null){
                tempList.add(Shared.tokenize(currentLine));
            }   
            br.close();
      }catch(FileNotFoundException e){
            System.out.println(e);
      }catch(IOException e) {
         System.out.println(e);
      }
      return tempList;
   }
}