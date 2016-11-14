import java.io.*;
public class BackOffice{
   public static void main (String[]args){
       
      String[]tempMaster = createArrayFromFile(args[0]);
      String[]tempDaily = createArrayFromFile(args[1]);
      Shared.masterAccounts = makeTwoDArray(tempMaster,Shared.MASTER_TOKEN_PER_LINE);
      Shared.dailyTransactions = makeTwoDArray(tempDaily,Shared.TRANS_TOKEN_PER_LINE);
      
      //setUpValidAccounts();
      for(int i = 0 ; i < Shared.dailyTransactions.length ; i++){
         String[]currentTransactionLine = Shared.dailyTransactions[i];
        
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
      writeToFile();
   }
   
   public static void writeToFile() {
       String tempMsg="";
       
       try{
           FileWriter masterFile = new FileWriter("mastAcc.txt");
           FileWriter validAccFile = new FileWriter("validAcc.txt");
           
           for (int i = 0; i<Shared.masterAccounts.length; i++) {
               tempMsg=Shared.masterAccounts[i][0]+" "+Shared.masterAccounts[i][1] + " " + Shared.masterAccounts[i][2];
               masterFile.write(tempMsg+"\r\n");
               validAccFile.write(Shared.masterAccounts[i][0]+"\r\n");
            }
            validAccFile.close();
            masterFile.close();
        }catch (IOException e) {
   		   e.printStackTrace();
   	   }
       
        
    }
   public static void setUpValidAccounts(){
      Shared.validAccounts = new String[Shared.masterAccounts.length];
      for(int i = 0 ; i < ((Shared.masterAccounts.length+1)/3) ; i++){
         //Shared.validAccounts[i] = Shared.masterAccounts[3*i];
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
   
   /*This method takes an array and the length of the second dimension and returns a 2 dimensional array.
    * This is used to turn the arrays of tokens into a more organised form where each
    * account or transacion is put with their respective information. 
   */
   public static String[][] makeTwoDArray (String[] accountArray, int dimension){
       
       String[][]newArray= new String[accountArray.length / dimension][dimension];
       
       for (int i=0; i<accountArray.length; i++){
           newArray[i/dimension][i%dimension] = accountArray[i];
       }
       
       return newArray;
       
   }
}