public class Deposit extends Transactions{
   public void completeTransaction(String[]currentTransaction){
      
      int tempBalance=0;
      int accountIndex=getAccountIndex(currentTransaction[1]);
      
      if(accountIndex>=0){
          tempBalance= Integer.parseInt(Shared.masterAccounts[accountIndex][1]) + Integer.parseInt(currentTransaction[3]);
          Shared.masterAccounts[accountIndex][1] = Integer.toString(tempBalance);
      }else{
          System.out.println("Fatal Error: Account number does not exist!");
          //EXIT HERE!!
      }
   }
}