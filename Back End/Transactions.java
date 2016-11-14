public class Transactions{
   public void completeTransaction(String[]currentTransaction){}
   
   public boolean checkIfAccountExists(String account){
      for(int i = 0 ; i < Shared.validAccounts.length ; i++){
         if(account.equals(Shared.validAccounts[i])){
            return true;
         }
      }
      return false;
   }
}
