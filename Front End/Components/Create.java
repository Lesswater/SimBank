package Components;
public class Create extends Commands{   
   
   //Attempts to create a new user.
   public void executeCommand(){
      if (commandBeforeLogin()){
         if(agentOnlyCommand("Error. Account creation is only permitted in agent mode.")){
            
            //Check to see if account provided does not exist
            String account = Shared.input.next();
            Shared.input.nextLine();
            if(validAccountNumber(account)){
               if(!accountExists(account)){
                  
                  //Check if name provided is syntactically correct
                  String name = Shared.input.nextLine();
                  if(validAccountName(name)){
                     //Add corresponding transaction code to Summ trans file
                     Shared.transCodes.add("CR " + account + " 00000000 000 " + name);
                  }
               }else{
                  System.out.println("Account number already exists.");
               }
            }
         }
      }
   }
}