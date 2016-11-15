package Components;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Shared{
   /*Stores the information from each line of the master accounts file
   and Transaction Summary file into two seperate ArrayLists
   */
   public static ArrayList<String[]> masterAccounts = new ArrayList<>();
   public static ArrayList<String[]> dailyTransactions = new ArrayList<>();
   
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