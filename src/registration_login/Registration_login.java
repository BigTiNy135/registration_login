package registration_login;
import java.util.Scanner;
import java.util.regex.*;

public class Registration_login {
    public static boolean ValidUsername(String username){
        Pattern pattern = Pattern.compile("^(?=.*_)[a-zA-Z0-9_]{1,5}$");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
  }
    public static boolean ValidPassword(String password){
    Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()\\-+=<>?/]).{8,20}$");
    Matcher matcher = pattern.matcher(password);
    return matcher.matches();
  }
    public static boolean ValidSouthAfricanPhoneNumber(String phoneNumber){
    Pattern pattern = Pattern.compile("^\\+27[6-8][0-9]{8}$");
    Matcher matcher = pattern.matcher(phoneNumber);
    return matcher.matches();
  }
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     //Username Validation
     System.out.print("Enter username: ");
     String username = scanner.next();
     if (ValidUsername(username)){
         System.out.println("Welcome " + username + " It is great to see you.");
   }else{
         System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length."); 
   }
     //passwordvalidation 
     System.out.print("Enter password: ");
     String password = scanner.next();
     if (ValidPassword(password)){
         System.out.println("Password is successfully captured");
   }else{
         System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters,a capital letter, a number and a special character.");
   }
     //South African Phone number validation
     System.out.print("Enter South african Phone number(e.g. +27812368998): ");
     String phoneNumber = scanner.next();
     if (ValidSouthAfricanPhoneNumber(phoneNumber)){
         System.out.println("Phone number successfully captured. ");
   }else{
         System.out.println("Phone number is incorrectly formatted or does not contain an international code, please correct the number and try again. ");
   }
   }
    
}
