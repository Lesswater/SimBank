import java.io.*;
public class BackOffice{
   public static void main (String[]args){
      Shared.masterAccounts = createArrayFromFile(args[0]);
      Shared.dailyTransactions = createArrayFromFile(args[1]);
      setUpValidAccounts();
      for(int i = 0 ; i < Shared.dailyTransactions.length ; i++){
         String[]currentTransactionLine = Shared.tokenize(Shared.dailyTransactions[i]);
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
         }
      }
   }
   
   public static void setUpValidAccounts(){
      Shared.validAccounts = new String[Shared.masterAccounts.length];
      for(int i = 0 ; i < Shared.masterAccounts.length ; i++){
         Shared.validAccounts[i] = Shared.tokenize(Shared.masterAccounts[i])[0];
      }
   }
   
   public static String[] createArrayFromFile(String filename){
      String currentLine = "";
      String allTokens = "";
      //Reads in each line of a file and appends it to currentLine. To
      //be separated into tokens for easier use
      try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            while((currentLine = br.readLine()) != null){
                allTokens += currentLine + " ";
            }   
            br.close();
      }catch(FileNotFoundException e){
            System.out.println(e);
      }catch(IOException e) {
         System.out.println(e);
      }
      return Shared.tokenize(allTokens);
   }
}