package Components;
public class Transfer extends Transactions{
   
   public void completeTransaction(String[]currentTransaction){
      
      int firstBalance=0;
      int secondBalance=0;
      int firstIndex=getAccountIndex(currentTransaction[1]);
      int secondIndex=getAccountIndex(currentTransaction[2]);
      
      //check to see if both accounts exist
      if(firstIndex>=0){
          if (secondIndex>=0){
              //assuming this is a transfer from account 1 to account 2
              firstBalance= Integer.parseInt(Shared.masterAccounts.get(firstIndex)[1]) - Integer.parseInt(currentTransaction[3]);
              
              if (firstBalance>=0){
                  secondBalance= Integer.parseInt(Shared.masterAccounts.get(secondIndex)[1]) + Integer.parseInt(currentTransaction[3]);
                  
                  Shared.masterAccounts.get(firstIndex)[1] = Integer.toString(firstBalance);
                  Shared.masterAccounts.get(secondIndex)[1] = Integer.toString(secondBalance);
                  
              }else{
                    System.out.println("Error: negative balance detected, transaction failed.");
              }
         }else{
             System.out.println("Fatal Error: Account number does not exist!");
          //EXIT HERE!!
         }
      }else{
          System.out.println("Fatal Error: Account number does not exist!");
          //EXIT HERE!!
      }
   }
}