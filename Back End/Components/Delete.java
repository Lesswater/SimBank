package Components;
public class Delete extends Transactions{
   /* Attempts to delete an existing account x where x is the account 
   number that is given in the parameter provided. If x exists, 
   and its current balance is 0, and the name given in the transaction 
   matches the name that is associated with the account in the master 
   accounts file, it removes the account. Otherwise, prints an 
   appropriate error message corresponding to the error type.
   */ 
   public void completeTransaction(String[]currentTransaction){
      int accountIndex = getAccountIndex(currentTransaction[1]);
      if(accountIndex >= 0){
         //Check balance of the account to be deleted.
         if (Integer.parseInt(Shared.masterAccounts.get(accountIndex)[1]) == 0){
             //Check to see if the given account name matches the actual account name.
             if (Shared.masterAccounts.get(accountIndex)[2].equals(currentTransaction[4])){
                //Delete account, how we do this depends on how we output stuff to file.
                Shared.masterAccounts.remove(accountIndex);
            }else{
                System.out.println("Error: invalid account name, transaction failed.");
            }
         }else{
             System.out.println("Error: non-zero balance, transaction failed.");
         }
      }else{
          System.out.println("Fatal Error: Account number does not exist!");
          System.exit(1);
      }
   }
}