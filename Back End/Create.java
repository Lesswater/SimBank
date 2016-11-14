public class Create extends Transactions{
   public void completeTransaction(String[]currentTransaction){
      int accountIndex=getAccountIndex(currentTransaction[1]);
      
      if(accountIndex<0){
          int arrayLength = Shared.masterAccounts.length;
          /*
           * Doesn't work, you can't do this in java.
           */
          Shared.masterAccounts[arrayLength][0]= currentTransaction[1];
          Shared.masterAccounts[arrayLength][1]= "000";
          Shared.masterAccounts[arrayLength][2]= currentTransaction[4];
      }else{
          System.out.println("Error: account already exists, transaction failed.");
          
        }
   }
}