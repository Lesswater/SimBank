package Components;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Shared{
   public static Scanner input = new Scanner(System.in); //Used to accept input from the command line
   public static ArrayList<String> transCodes = new ArrayList<>(); //A list used to store all transactions to be written to transaction summary file
   public static String[]validAccountsArray; //Stores all currently valid account numbers
   public static String transSumName = ""; //Stores the name of the to-be-created Transaction Summary file
   public static int transSumsGenerated = 1; //If more than one login-logouts happen in a single run, each additional transaction file will have be numbered (starting at 2)
   public static long[] dailyWithdrawals = new long[0]; //Used to store the current amount that has been withdrawn from each account
   
   
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