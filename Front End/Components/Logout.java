package Components;
import java.io.IOException;
import java.nio.file.*;
public class Logout extends Commands{
   
   Path transSum;
   
   //Attempts to Logout. If already logged out, provides error message.
   //Otherwise, creates a new file with the name specified in the second 
   //argument passed in the command line, with the end-of-session code as 
   //the last line of text in the new file
   public void executeCommand(){
	   if (commandBeforeLogin()){
         loggedIn = false;
         Shared.transCodes.add("ES 00000000 00000000 000 ***");
         String uniqueId = "";
         
         //If this is not the first trans summ file created in this session, give a unique id to this file
         if(Shared.transSumsGenerated > 1){
            uniqueId = "(" + Shared.transSumsGenerated + ")";
         }
         
         //Creates the new Transaction Summary File in the "Transaction Summary" folder
         transSum = Paths.get("Transaction Summary Files\\" + uniqueId + Shared.transSumName);
         Shared.transSumsGenerated++;
         try {
   		   Files.write(transSum, Shared.transCodes);
   	   }catch (IOException e) {
   		   e.printStackTrace();
   	   }
         Shared.transCodes.clear();    
      }      
   }
}