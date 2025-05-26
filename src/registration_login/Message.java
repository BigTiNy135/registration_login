package registration_login;


import java.util.Random;
import java.util.regex.*;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.*;




public class Message {
    
    
    private  String messageId;
    private  String recipient;
    private String message;
    private static int messageCount = 0;
    private String messageHash;
    
    public Message(String recipient, String message){        
        this.recipient = recipient;
        this.message = message;
        this.messageId = generateMessageId();
        this.messageHash = createMessageHash();
    }
     private String generateMessageId() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++){
            sb.append(rnd.nextInt(10));
        }
        return sb.toString();
    }
     //Method to check message ID length
    public boolean checkMessageID() {
        return messageId.length() <= 10;
    }
    
  // Check if recipient number is valid (starts with +27 and 10 digits)
    public boolean checkRecipientCell() {
        Pattern pattern = Pattern.compile("^\\+27[6-8][0-9]{8}$");
        Matcher matcher = pattern.matcher(this.recipient);
        return matcher.matches();
        
    }
    //method to create message hash
    public String createMessageHash() {
        String firstTwoDigits = messageId.substring(0, 2);
        String messageNumber = String.valueOf(++messageCount);
        String firstWord = message.split(" ")[0].toUpperCase();
        String lastWord = message.split(" ")[message.split(" ").length - 1].toUpperCase();
        return firstTwoDigits + ":" + messageNumber + ":" + firstWord + lastWord;
    }
    
    public String sentMessage() {
        String[] options = {"1", "2", "3"};
        return (String) JOptionPane.showInputDialog(null, "Choose an action: ", "Message Action", JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
    }
    public void storeMessage() throws JSONException{
        JSONObject obj = new JSONObject();
        obj.put("MessageID", messageId);
        obj.put("MessageHash", messageHash);
        obj.put("Recipient", recipient);
        obj.put("Message", message);
        
        JSONArray arr = new JSONArray();
        arr.put(obj);
        
        try (FileWriter file = new FileWriter("storedMessages.json",true)){
            file.write(arr.toString());
            file.flush();
        }catch (IOException e){
                JOptionPane.showMessageDialog(null,"Error storing message: " + e.getMessage());
                }
            
        }
    public String displayMessage(){
        return "Message ID: " + messageId + 
                "\nMessageHash: " + messageHash + 
                "\nRecipient: " + recipient + 
                "\nMessage: " + message;
        
   }
  
    }
               
                

 
