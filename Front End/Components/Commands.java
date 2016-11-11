package Components;
public class Commands{
   
   public static boolean loggedIn = false;
   public static boolean agentMode = true;
   public static String recentDeleted = "";
   
   //Stub function that will be overloaded by the corresponding function for each transaction type
   public void executeCommand(){}
   
   //Check to see whether terminal is logged in or not. Returns true if logged in. Returns false and prints error message if not logged in.
   public static boolean commandBeforeLogin(){
      if(loggedIn == false){
         System.out.println("Must login before transactions can occur.");
         return false;
      }else{
         return true;
      }
   }
   
   //Check to see whether terminal is in agent mode or not. Returns true if agent mode is enabled. Returns false and prints error message if atm mode is enabled.
   public static boolean agentOnlyCommand(String errorMessage){
      if(agentMode == false){
         System.out.println(errorMessage);
         return false;
      }else{
         return true;
      }
   }
   
   /**   This method checks to see whether an account is able to withdraw
   more money, which is limited at $1000 in atm mode. Checks the current 
   withdrawn amount for the provided parameter account, and determines whether the 
   provided amount can be succesfully added without exceeding $1000.
   **/   
   public static boolean belowLimit(String account, String amount){
      long amountToAdd = Long.parseLong(amount);
      
      if(!agentMode){
         for(int i = 0 ; i < Shared.validAccountsArray.length ; i++){
            if(Shared.validAccountsArray[i].equals(account)){
               if(Shared.dailyWithdrawals[i] + amountToAdd <= 100000){
                  Shared.dailyWithdrawals[i] += amountToAdd;
                  return true;
               }else{
                  System.out.println("Error: session withdraw limit reached, transaction cancelled.");
                  return false;
               }
            }
         }
      }
      return true;
   }
   
   /**Check to see if a given dollar amount is within the correct dollar 
   range (given the terminals current mode), as well as error checks the 
   provided amount to makue sure it only contains digits
   **/
   public static boolean checkRange(String amount){
      String errorMessage = "Error amount is not in the range 0.00 - 1,000.00.";
      if(agentMode){
         errorMessage = "Error amount is not in the range 0.00 - 999,999.99.";
      }
      
      //Loop through each char of 'amount' in order to makue sure they are all digits
      //and that the first char is not a minus sign (indicating negative amount)
      for(int i = 0 ; i < amount.length() ; i++){
         if (Character.isDigit(amount.charAt(i)) == false){
            System.out.println(errorMessage);
            return false;
         }
      }
      
      long convertedAmount = Long.parseLong(amount);
       
      //Checks to see whether 'amount' is within the proper range (given the current mode)
      if(agentMode){
         if(convertedAmount > 99999999){
            System.out.println(errorMessage);
            return false;
         }
      }else{
         if(convertedAmount > 100000){
            System.out.println(errorMessage);
            return false;
         }
      }
      return true;
   }
   
   //Validates that the given account number is a syntactically correct account number
   public static boolean validAccountNumber(String account){
      int len = account.length();
      //Check that the given account number is exactly 8 charcters
      if (len == 8){
         //Check for non-digits
         boolean containsNonDigits = false;
         for(int i = 0 ; i < len ; i++){
            if (Character.isDigit(account.charAt(i)) == false){
               containsNonDigits = true;
            }
         }
         if(containsNonDigits == false){
            //Check that it does not begin with 0
            if (account.charAt(0) != '0'){
               return true;
            }
         }
      }
      System.out.println("One or more Invalid Account numbers. Account numbers must be unique, 8 digits long, and must not start with 0.");
      return false;
   }
   
   /**   Determines whether the parameter account has been deleted during this
   session (returns false), or whether the paramter account is a previously 
   created account number (via the Valid Accounts file, which has been imported 
   into "validAccountsArray").
   **/
   public static boolean accountExists(String account){
      String[]currentDeleted = Shared.tokenize(recentDeleted);
      for(int i = 0 ; i < currentDeleted.length ; i++){
         if(currentDeleted[i].equals(account)){
            return false;
         }
      }
      
      for(int i = 0 ; i < Shared.validAccountsArray.length ; i++){
         if(Shared.validAccountsArray[i].equals(account)){
            return true;
         }
      }
      return false;
   }
   
   //Validates that the given account name is a syntactically correct account name
   public static boolean validAccountName(String name){
      int len = name.length();
      //Check that the name is between 3 and 30 characters
      if (len <= 30 && len >= 3){      
         //Check for Leading or trailing whitespace
         if (Character.isSpaceChar(name.charAt(0)) == false && Character.isSpaceChar(name.charAt(len - 1)) == false){            
            //Check for any non-alphanumeric characters
            boolean containsNonAlphaNumeric = false;
            for(int i = 0 ; i < len ; i++){
               if (Character.isDigit(name.charAt(i)) == false && Character.isLetter(name.charAt(i)) == false){
                  containsNonAlphaNumeric = true;
               }
            }
            if(containsNonAlphaNumeric == false){
               return true;
            }
         }
      }
      System.out.println("Error. Account name must be between 3 and 30 Alpha-numeric characters, and cannot begin or end with a space.");
      return false;
   }   
}