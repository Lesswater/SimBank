package Components;
public class Deposit extends Transactions{
   /* Attempts to deposit to an existing account x where x is the account 
   number that is given in the parameter provided. If x exists,it deposits
   the amount provided in the parameter. Otherwise, prints an 
   appropriate error message corresponding to the error type.
   */
   public void completeTransaction(String[]currentTransaction){
      
      int tempBalance = 0;
      int accountIndex = getAccountIndex(currentTransaction[1]);
      if(accountIndex >= 0){
          tempBalance = Integer.parseInt(Shared.masterAccounts.get(accountIndex)[1]) + Integer.parseInt(currentTransaction[3]);
          Shared.masterAccounts.get(accountIndex)[1] = Integer.toString(tempBalance);
      }else{
          System.out.println("Fatal Error: Account number does not exist!");
          System.exit(1);
      }
   }
}