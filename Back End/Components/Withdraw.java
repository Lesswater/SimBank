package Components;
public class Withdraw extends Transactions{
   
   public void completeTransaction(String[]currentTransaction){
      
      int tempBalance=0;
      int accountIndex=getAccountIndex(currentTransaction[1]);
      
      //check to see if the account exists.
      if(accountIndex>=0){
          
          tempBalance= Integer.parseInt(Shared.masterAccounts.get(accountIndex)[1]) - Integer.parseInt(currentTransaction[3]);
          
          //check if the new balance will be a positive amount.
          if (tempBalance>=0){
              Shared.masterAccounts.get(accountIndex)[1] = Integer.toString(tempBalance);
          }else{
              System.out.println("Error: negative balance detected, transaction failed.");
          }
      }else{
          System.out.println("Fatal Error: Account number does not exist!");
          //EXIT HERE!!
      }
   }
}