import java.io.*;
import java.util.StringTokenizer;
import Components.*;
public class SimBank{
   
   //Runs SimBank. Repeatedly accepts input from the user, until they enter 'exit'. 
   //If the user provides valid input corresponding to a transaction type, the appropriate
   //Command is created, and the transaction is executed. Otherwise, prints error message
   //saying that their provided input is not a valid command.
   public static void main(String[]args){   
      //Assume that arguments for the names of the valid accounts file
      //and the to-be-created trans summ file are always provided
      setUpAccounts(args[0]);
      Shared.transSumName = args[1];
      Commands currentCommand;
      
      do{
         
         currentInput = Shared.input.next();
         if(!currentInput.equals("exit")){
            //Stops a weird exception when piping in input files
            Shared.input.nextLine();
         }
         if(currentInput.equalsIgnoreCase("login")){
            currentCommand = new Login();
            currentCommand.executeCommand();
         }else if(currentInput.equalsIgnoreCase("logout")){
            currentCommand = new Logout();
            currentCommand.executeCommand();
         }else if(currentInput.equalsIgnoreCase("create")){
            currentCommand = new Create();
            currentCommand.executeCommand();
         }else if(currentInput.equalsIgnoreCase("delete")){
            currentCommand = new Delete();
            currentCommand.executeCommand();
         }else if(currentInput.equalsIgnoreCase("deposit")){
            currentCommand = new Deposit();
            currentCommand.executeCommand();
         }else if(currentInput.equalsIgnoreCase("withdraw")){
            currentCommand = new Withdraw();
            currentCommand.executeCommand();
         }else if(currentInput.equalsIgnoreCase("transfer")){
            currentCommand = new Transfer();
            currentCommand.executeCommand();
         }else if(currentInput.equalsIgnoreCase("exit")){
            //Do nothing
         }else{
            System.out.println("Error. Not a valid command");
         }
      }while(!currentInput.equalsIgnoreCase("exit"));
   }
   
   /** Creates an array storing the valid account file information, and
   creates an array storing the current withdrawn amount for each valid
   account.
   **/
   public static void setUpAccounts (String filename){
      Shared.validAccountsArray = createArrayFromFile(filename);
      Shared.dailyWithdrawals = new long[Shared.validAccountsArray.length];
   }
   
   /** Given a provided filename, create an array storing all lines of the file
   in each element
   **/
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