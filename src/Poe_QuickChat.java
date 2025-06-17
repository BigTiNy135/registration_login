package registration_login;


import java.util.regex.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;



public class Poe_QuickChat {
    
 
static int messageCounter ;
        static ArrayList<Message> sentMessages = new ArrayList<>();
    static ArrayList<Message> disregardedMessages = new ArrayList<>();
    static ArrayList<Message> storedMessages = new ArrayList<>();
    static ArrayList<Integer> messageHashes = new ArrayList<>();
    static ArrayList<String> messageIDs = new ArrayList<>();
 // Add test data messages
    public static void addTestData() {
        // Test Data Message 1 - Sent
        Message m1 = new Message("+27834557896", "Did you get the cake?", "Sent");
        sentMessages.add(m1);

        // Test Data Message 2 - Stored
        Message m2 = new Message("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        storedMessages.add(m2);

        // Test Data Message 3 - Disregard
        Message m3 = new Message("+27834484567", "Yohoooo, I am at your gate.", "Disregard");
        disregardedMessages.add(m3);

        // Test Data Message 4 - Sent (Developer entry - phone number without +27)
        Message m4 = new Message("0838884567", "It is dinner time !", "Sent");
        sentMessages.add(m4);

        // Test Data Message 5 - Stored
        Message m5 = new Message("+27838884567", "Ok, I am leaving without you.", "Stored");
        storedMessages.add(m5);

        // Update messageIDs and hashes
        for (Message m : sentMessages) {
            messageIDs.add(m.getmessageId());
            messageHashes.add(m.hashCode());
        }
        for (Message m : disregardedMessages) {
            messageIDs.add(m.getmessageId());
            messageHashes.add(m.hashCode());
        }
        for (Message m : storedMessages) {
            messageIDs.add(m.getmessageId());
            messageHashes.add(m.hashCode());
        }
    }
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
        
     String username = JOptionPane.showInputDialog("Enter username: ");
  
     if (isValidUsername(username)){
      JOptionPane.showMessageDialog(null,"Username successfully captured.");
     }else{
        JOptionPane.showMessageDialog(null,"Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
     }
     
     //password validation
     
     
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
            String menu = "Select an option:"
                    + "\n1) Send Messages"
                    + "\n2) Show Recently Sent Messages"
                    + "\n3) Longest Message"
                    + "\n4) Search by message ID"
                    + "\n5) Search by Recepient"
                    + "\n6) Delete message by Hash"
                    + "\n7 Display Report"
                    + "\n8) Quit";
            String option = JOptionPane.showInputDialog(menu);

            switch (option) {
                case "1":
                    int numMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages would you like to send?"));
                    for (int i = 0; i < numMessages; i++) {
                        String recipient = JOptionPane.showInputDialog("Enter recipient phone number (e.g., +27718693002): ");
                        String message = JOptionPane.showInputDialog("Enter your message (max 250 characters): ");
                        
                        
                
//Message actions
                        Message msg = new Message(recipient, message, "Sent");
                        String sendChoice = JOptionPane.showInputDialog("Choose an option:\n1) Send Message\n2) Disregard Message\n3) Store Message ");

                        if (sendChoice.equals("1")) {
                            sentMessages.add(msg);
                            messageHashes.add(msg.hashCode());
                            messageIDs.add(msg.getmessageId());
                            messageCounter++;
                            JOptionPane.showMessageDialog(null, "Message successfully sent");
                        } else if (sendChoice.equals("2")) {
                            disregardedMessages.add(msg);
                            JOptionPane.showMessageDialog(null, "Message disregarded");
                        } else if (sendChoice.equals("3")) {
                            storedMessages.add(msg);
                            JOptionPane.showMessageDialog(null, "Message stored");
                        }
                        JOptionPane.showMessageDialog(null, msg.displayMessage(), "Message Details", JOptionPane.INFORMATION_MESSAGE);

                    }
                    JOptionPane.showMessageDialog(null,"Total messages sent: " +  numMessages);
                    break;
                case "2":
                    showRecentlySentMessages();
                    break;
                case "3":
                    showLongestMessage();
                    break;
                case "4":
                    searchByMessageID();
                    break;
                case "5":
                    searchByRecepient();
                    break;
                case "6":
                    deleteByMessageHash();
                    break;
                case "7":
                    displayReport();
                    break;
                case "8":
                    running = false;
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option.");
                }
            
            }
        }
    }
//Display the sender and recipient of all sent messages
    private static void showRecentlySentMessages() {
    JOptionPane.showMessageDialog(null,"Sent Messages:");
        for (Message m : sentMessages) {
           JOptionPane.showMessageDialog(null,"ID: " + m.getmessageId() + ", Recipient: " + m.getRecipient());
        }  
       
    }
//Display the longest sent message
    private static void showLongestMessage() {
         if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No sent messages.");
            return;
        }
        Message longest = sentMessages.get(0);
        for (Message m : sentMessages) {
            if (m.getMessage().length() > longest.getMessage().length()) {
                longest = m;
            }
        }
        JOptionPane.showMessageDialog(null, "Longest message:\n" + longest.displayMessage());
       }
//Search for a message ID and display the corresponding recipient and message
    private static void searchByMessageID() {
        String id = JOptionPane.showInputDialog("Enter Message ID to search:");
        for (Message m : sentMessages) {
            if (m.getmessageId().equals(id)) {
                JOptionPane.showMessageDialog(null, "Message found:\n" + m.displayMessage());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Message ID not found.");
        }
//Search for all the messages sent to a particular recipient
    private static void searchByRecepient() {
         String recipient = JOptionPane.showInputDialog("Enter recipient phone number to search messages:");
        StringBuilder foundMessages = new StringBuilder();
        for (Message m : sentMessages) {
            if (m.getRecipient().equals(recipient)) {
                foundMessages.append(m.displayMessage()).append("\n\n");
            }
        }
        if (foundMessages.length() == 0) {
            JOptionPane.showMessageDialog(null, "No messages found for recipient " + recipient);
        } else {
            JOptionPane.showMessageDialog(null, foundMessages.toString());
        }
    }
//Delete a message using the message hash
    private static void deleteByMessageHash() {
        String hashStr = JOptionPane.showInputDialog("Enter message hash to delete:");
        int hash;
        try {
            hash = Integer.parseInt(hashStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid hash format.");
            return;
        }
        for (int i = 0; i < sentMessages.size(); i++) {
            if (sentMessages.get(i).hashCode()== hash) {
                sentMessages.remove(i);
                messageHashes.remove(Integer.valueOf(hash));
                messageIDs.remove(i);
                messageCounter--;
                JOptionPane.showMessageDialog(null, "Message deleted.");
                return;
            }    
    }
    }
    //Display a report that lists the full details of all the sent messages
    private static void displayReport() {
       if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No sent messages to report.");
            return;
        }
        StringBuilder sb = new StringBuilder("Sent Messages Report:\n\n");
        for (Message m : sentMessages) {
            sb.append("Hash: ").append(m.hashCode())
              .append("\nRecipient: ").append(m.getRecipient())
              .append("\nMessage: ").append(m.getMessage())
              .append("\n----------------------\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
     }
   
            
}