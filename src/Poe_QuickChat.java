package registration_login;


import java.util.regex.*;
import javax.swing.JOptionPane;



public class Poe_QuickChat {
    
 

 
    //Username format
    public static boolean isValidUsername(String username){
        Pattern pattern = Pattern.compile("^(?=.*_)[a-zA-Z0-9_]{1,5}$");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
    //password complexity
    public static boolean isValidPassword(String password){
    Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()\\-+=<>?/]).{8,20}$");
    Matcher matcher = pattern.matcher(password);
    return matcher.matches();
    }
    //South african phoneNumber
    public static boolean isValidSouthAfricanPhoneNumber(String phoneNumber){
    Pattern pattern = Pattern.compile("^\\+27[6-8][0-9]{8}$");
    Matcher matcher = pattern.matcher(phoneNumber);
    return matcher.matches();
}
     public static boolean isValidDetails(String username, String password, String phoneNumber){
         if (username==null || password ==null || phoneNumber==null){
             return false;
         }
         return username.equals(username)&&
                 password.equals(password)&&
                 phoneNumber.equals(phoneNumber);
     }
     
     //Username Validation
    public static void main(String[] args) {
     //   boolean loggedIn = false;
        
     
    
     String username = JOptionPane.showInputDialog("Enter username: ");
  
     if (isValidUsername(username)){
      JOptionPane.showMessageDialog(null,"Username successfully captured.");
     }else{
        JOptionPane.showMessageDialog(null,"Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
     }
     
     //password validation3
     
     
    String password = JOptionPane.showInputDialog("Enter password: ");
   
     if (isValidPassword(password)){
         JOptionPane.showMessageDialog(null,"Password is successfully captured");
        
     }else{
         JOptionPane.showMessageDialog(null,"Password is not correctly formatted, please ensure that the password contains at least eight characters,a capital letter, a number and a special character.");
     }
     //South African Phone number validation
     String phoneNumber = JOptionPane.showInputDialog("Enter South african Phone number(e.g. +27812368998): ");     
   
     if (isValidSouthAfricanPhoneNumber(phoneNumber)){
         JOptionPane.showMessageDialog(null,"Phone number successfully captured. ");
          }else{
        JOptionPane.showMessageDialog(null,"Phone number is not correctly formatted, please enter a valid south african phone number starting with +27 followed by 9 digits.");
     }
     
      // Login with Registration details

     JOptionPane.showMessageDialog(null,"Login:");          

        String registeredUsername = username; 
        String registeredPassword = password;
        
        boolean loggedIn =false;
        
        while (!loggedIn){
        String loginUsername = JOptionPane.showInputDialog("Enter username: ");
        String loginPassword = JOptionPane.showInputDialog("Enter password: ");
          
       if (!loginUsername.equals(registeredUsername) || !loginPassword.equals(registeredPassword)){
           JOptionPane.showMessageDialog(null,"Username or Password incorrect, Try again.");
           
       }else{
           JOptionPane.showMessageDialog(null,"Login Successful.");
           loggedIn = true;
       }
     
          
       }
          if (loggedIn){
       JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");

        boolean running = true;
        while (running) {
            // Menu options
            String menu = "Select an option:\n1) Send Messages\n2) Show Recently Sent Messages\n3) Quit";
            String option = JOptionPane.showInputDialog(menu);

            switch (option) {
                case "1":
                    int numMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages would you like to send?"));
                    for (int i = 0; i < numMessages; i++) {
                        String recipient = JOptionPane.showInputDialog("Enter recipient phone number (e.g., +27718693002): ");
                        String message = JOptionPane.showInputDialog("Enter your message (max 250 characters): ");
                        
                        
                
//Message actions
                        Message msg = new Message(recipient, message);
                        String sendChoice = JOptionPane.showInputDialog("Choose an option:\n1) Send Message\n2) Disregard Message\n3) Store Message to Send Later");

                        if (sendChoice.equals("1")) {
                            JOptionPane.showMessageDialog(null, "Message successfully sent");
                        } else if (sendChoice.equals("2")) {
                            JOptionPane.showMessageDialog(null, "Message disregarded");
                        } else if (sendChoice.equals("3")) {
                            JOptionPane.showMessageDialog(null, "Message stored");
                        }
                        JOptionPane.showMessageDialog(null, msg.displayMessage(), "Message Details", JOptionPane.INFORMATION_MESSAGE);

                    }
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon.");
                    break;
                case "3":
                    running = false;
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option.");
                }
            
            }
        }
    }
}