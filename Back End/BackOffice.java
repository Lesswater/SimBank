import java.io.*;
import java.util.ArrayList;
import Components.*;
public class BackOffice{
   public static void main (String[]args){
      Shared.masterAccounts = createArrayListFromFile(args[0]);
      Shared.dailyTransactions = createArrayListFromFile(args[1]);
      int numberOfTransactions = Shared.dailyTransactions.size();

      for(int i = 0 ; i < numberOfTransactions ; i++){
         String[]currentTransactionLine = Shared.dailyTransactions.get(i);
         for(int j = 0 ; j < currentTransactionLine.length ; j++){
            System.out.print(currentTransactionLine[j] + " ");
         }
         System.out.println();
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
         }else{
            //Do nothing
            // Fatal error???
         }
      }
      writeToFile(args[0],"Valid Accounts.txt");
   }
   
   public static void writeToFile(String master, String valids) {
       String tempMsg="";
       
       try{
           FileWriter masterFile = new FileWriter(master);
           FileWriter validAccFile = new FileWriter(valids);
           
           for (int i = 0; i<Shared.masterAccounts.size(); i++) {
               tempMsg=Shared.masterAccounts.get(i)[0] + " " + Shared.masterAccounts.get(i)[1] + " " + Shared.masterAccounts.get(i)[2];
               masterFile.write(tempMsg+"\r\n");
               validAccFile.write(Shared.masterAccounts.get(i)[0]+"\r\n");
            }
            validAccFile.close();
            masterFile.close();
        }catch (IOException e) {
   		   e.printStackTrace();
   	  }
    }
   
   public static ArrayList<String[]> createArrayListFromFile(String filename){
      String currentLine = "";
      ArrayList <String[]> tempList = new ArrayList<String[]>();
      //Reads in each line of a file and appends it to currentLine. To
      //be separated into tokens for easier use
      
      try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
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