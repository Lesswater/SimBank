public class Delete extends Transactions{
   public void completeTransaction(String[]currentTransaction){
       
      int accountIndex=getAccountIndex(currentTransaction[1]);
      if(accountIndex>=0){
         //Check balance of the account to be deleted.
         if (Integer.parseInt(Shared.masterAccounts[accountIndex][1]) == 0){
             //Check to see if the given account name matches the actual account name.
             if (Shared.masterAccounts[accountIndex][2].equals(currentTransaction[4])){
                //Delete account, how we do this depends on how we output stuff to file.
            }else{
                System.out.println("Error: invalid account name, transaction failed.");
            }
         }else{
             System.out.println("Error: non-zero balance, transaction failed.");
         }
      }else{
          System.out.println("Fatal Error: Account number does not exist!");
          //EXIT!!!!!!!!
      }
   }
}