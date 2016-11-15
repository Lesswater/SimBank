package Components;
public class Create extends Transactions{
   /* Attempts to create a new account x where x is the account number
   that is given in the parameter provided. If x does not already exist,
   then adds it to the master accounts Arraylist. Otherwise, prints an
   error message stating that the account already exists.
   */ 
   public void completeTransaction(String[]currentTransaction){
      int accountIndex = getAccountIndex(currentTransaction[1]);
      if(accountIndex < 0){
          String[]temp = new String[3];
          temp[0] = currentTransaction[1];
          temp[1] = "000";
          temp[2] = currentTransaction[4];
          Shared.masterAccounts.add(temp);
      }else{
          System.out.println("Error: account already exists, transaction failed.");
        }
   }
}