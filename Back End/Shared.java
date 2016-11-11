import java.util.StringTokenizer;
public class Shared{
   public static String[]masterAccounts;
   public static String[]validAccounts;
   public static String[]dailyTransactions;
   
   /**   This method will take a space-delimeted String as a parameter
   and return an array where each element is a token of the String
   parameter.
   **/
   public static String[] tokenize(String delimeted){
      StringTokenizer st = new StringTokenizer(delimeted);
      String[]returnArray = new String[st.countTokens()];
      for(int i = 0 ; i < returnArray.length ; i++){
         returnArray[i] = st.nextToken();
      }
      return returnArray;
   }
}