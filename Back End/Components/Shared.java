package Components;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Shared{
   
   public static ArrayList<String[]> masterAccounts = new ArrayList<>();
   public static ArrayList<String[]> dailyTransactions = new ArrayList<>();
   
   public static int MASTER_TOKEN_PER_LINE = 3;
   public static int TRANS_TOKEN_PER_LINE = 5;
   
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