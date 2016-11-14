public class Transactions{
   public void completeTransaction(String[]currentTransaction){}
   
   public int getAccountIndex(String account){
       for(int i=0; i < Shared.masterAccounts.length; i++){
           if (account.equals(Shared.masterAccounts[i][0])){
               return i;
            }
        }
        return -1;
   }
}