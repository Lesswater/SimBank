package Components;
public class Login extends Commands{
   
   //Attempts to login to SimBank. If already logged in, prints error message. 
   //Otherwise, accepts input until user chooses agent or atm mode
   public void executeCommand(){
      if (loggedIn){
         System.out.println("This terminal is already logged in. Must log out before new login can occur.");
      }else{
         loggedIn = true;
         String mode = "";
         //Loop until user chooses a mode
         do{
            mode = Shared.input.next();
            Shared.input.nextLine();
            if(mode.equals("agent")){
               agentMode = true;
            }else if(mode.equals("atm")){
               agentMode = false;
            }else{
               System.out.println("Error. Must choose between \"atm\" or \"agent\" mode.");
            }
         }while(!mode.equals("agent") && !mode.equals("atm"));
      }
   }   
}