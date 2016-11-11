package Components;
public class Transfer extends Commands{

   //Attempts to transfer money between two existing accounts
   public void executeCommand(){   
      if (commandBeforeLogin()){
         
         //Check if from-account is syntactically correct, and if it exists
         String account1 = Shared.input.next();
         Shared.input.nextLine();
         if(validAccountNumber(account1)){
            if(accountExists(account1)){
            
               //Check if to-account is syntactically correct, and if it exists
               String account2 = Shared.input.next();
               Shared.input.nextLine();
               if(validAccountNumber(account2)){
                  if(accountExists(account2)){
                     
                     //Check if provided amount is allowed
                     String amount = Shared.input.next();
                     Shared.input.nextLine();
                     if(Commands.checkRange(amount)){
                        if(belowLimit(account1,amount)){
                    	      //Add corresponding transaction code to Summ trans file
                           Shared.transCodes.add("TR " + account1 + " " + account2 + " " + amount + " ***");
                        }
                     }
                  }else{
                     System.out.println("Error. Account does not exist.");
                  }
               }
            }else{
               System.out.println("Error. Account does not exist.");
            }
         }   
      }
   }
}