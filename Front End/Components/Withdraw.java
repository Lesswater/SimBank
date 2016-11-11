package Components;
public class Withdraw extends Commands{
   
   //Attempts to withdraw from an existing account
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
               if(checkRange(amount)){
            	   if(belowLimit(account,amount)){
                     //Add corresponding transaction code to Summ trans file
                     Shared.transCodes.add("WD " + " " + account + " 00000000 " + amount + " ***");
                  }
               }
            }else{
               System.out.println("Error. Account does not exist.");
            }
         }   
      }
   }
}