package Components;
public class Transfer extends Transactions{
   /* Attempts to transfer from an existing account x to another existing 
   account y, where x and y are both accounts given in the parameter provided.
   If x and y exist, and the amount to withdraw from x does not exceed x's
   current balance, it withdraws the amount provided from x, and deposits the
   amount in y. Otherwise, prints an appropriate error message corresponding 
   to the error type.
   */
   public void completeTransaction(String[]currentTransaction){
      int firstBalance = 0;
      int secondBalance = 0;
      int firstIndex = getAccountIndex(currentTransaction[1]);
      int secondIndex = getAccountIndex(currentTransaction[2]);
      //check to see if both accounts exist
      if(firstIndex >= 0 && secondIndex >= 0){
         //assuming this is a transfer from account 1 to account 2
         firstBalance = Integer.parseInt(Shared.masterAccounts.get(firstIndex)[1]) - Integer.parseInt(currentTransaction[3]);
         if (firstBalance >= 0){
            secondBalance = Integer.parseInt(Shared.masterAccounts.get(secondIndex)[1]) + Integer.parseInt(currentTransaction[3]);
            Shared.masterAccounts.get(firstIndex)[1] = Integer.toString(firstBalance);
            Shared.masterAccounts.get(secondIndex)[1] = Integer.toString(secondBalance);
         }else{
            System.out.println("Error: negative balance detected, transaction failed.");
         }
      }else{
         System.out.println("Fatal Error: Account number does not exist!");
         System.exit(1);
      }
   }
}