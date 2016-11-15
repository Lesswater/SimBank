package Components;
public class Create extends Transactions{
  
   public void completeTransaction(String[]currentTransaction){
      int accountIndex=getAccountIndex(currentTransaction[1]);
      
      if(accountIndex<0){
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