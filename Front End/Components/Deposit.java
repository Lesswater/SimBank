package Components;
public class Deposit extends Commands{
   
   //Attempts to deposit money to an existing account
   public void executeCommand(){
      if (commandBeforeLogin()){
         
         //Check if account provided is syntactically correct, and if it exists
         String account = Shared.input.next();
         Shared.input.nextLine();
         if(validAccountNumber(account)){
            if(accountExists(account)){
               
               //Check if provided amount is allowed
               String amount = Shared.input.next();
               Shared.input.nextLine();
               if(Commands.checkRange(amount)){
            	   //Add corresponding transaction code to Summ trans file
                  Shared.transCodes.add("DE " + account + " 00000000 " + amount + " ***");
               }
            }else{
               System.out.println("Error. Account does not exist.");
            }
         }
      }
   }
}