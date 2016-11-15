package Components;
public class Transactions{
   /*A stub function that will be overloaded by each transactions type's
   version of this method.
   */
   public void completeTransaction(String[]currentTransaction){}
   
   /* This method determines whether an account exists by checking
   the account numbers of all lines in the master accounts file. Returns
   i if the account exists and is on the ith line of the file. Returns -1
   otherwise.
   */
   public int getAccountIndex(String account){
       for(int i = 0; i < Shared.masterAccounts.size(); i++){
           if (account.equals(Shared.masterAccounts.get(i)[0])){
               return i;
            }
        }
        return -1;
   }
}