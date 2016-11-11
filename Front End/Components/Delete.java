package Components;
public class Delete extends Commands{
   
   //Attempts to delete an existing account
   public void executeCommand(){
      if (commandBeforeLogin()){
         if(agentOnlyCommand("Error. Account deletion is only permitted in agent mode.")){
            
            //Check if account provided is syntactically correct, and if it exists
            String account = Shared.input.next();
            Shared.input.nextLine();
            if(validAccountNumber(account)){
               if(accountExists(account)){
                  
                  //Check if name provided is syntactically correct
                  String name = Shared.input.nextLine();
                  if(validAccountName(name)){
                	   //Add corresponding transaction code to Summ trans file
                     Shared.transCodes.add("DL" + " " + account + " 00000000 000 " + name);
                     Commands.recentDeleted += account + " ";
                  }
               }else{
                  System.out.println("Error. Account does not exist.");
               }
            }
         }
      }
   }
}