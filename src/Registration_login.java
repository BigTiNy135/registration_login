package registration_login;

import java.util.Scanner;
import java.util.regex.*;


public class Registration_login {

  
 
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
        
     Scanner scanner = new Scanner(System.in);
    
     System.out.print("Enter username: ");
     String username = scanner.next();
     if (isValidUsername(username)){
         System.out.println("Username successfully captured.");
     }else{
         System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
     }
     
     //password validation 
     System.out.print("Enter password: ");
     String password = scanner.next();
     if (isValidPassword(password)){
         System.out.println("Password is successfully captured");
     }else{
         System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters,a capital letter, a number and a special character.");
     }
     //South African Phone number validation
     System.out.print("Enter South african Phone number(e.g. +27812368998): ");
     String phoneNumber = scanner.next();
     if (isValidSouthAfricanPhoneNumber(phoneNumber)){
         System.out.println("Phone number successfully captured. ");
          }else{
         System.out.println("Phone number is not correctly formatted, please enter a valid south african phone number starting with +27 followed by 9 digits.");
     }
     
      // Login with Registration details

     System.out.println("Login:");          
      System.out.print("Enter username: " );
       username = scanner.next();
       System.out.print("Enter password: ");
       password = scanner.next();
       
       if (isValidUsername (username)&& isValidPassword(password)){
         System.out.println("Login Successful.");
         
     }else{
    System.out.println("Username or Password incorrect, Try again.");

       
    
            
          }
}
}

