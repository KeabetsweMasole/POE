/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrationandloginfeatures;

import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Keabetswe Masole
 */
class Login {
   private Map<String, String> userCredentials;
   
   public Login(Map<String, String> userCredentials) {
       this.userCredentials = userCredentials;
   }
   public boolean main() {
       String username = JOptionPane.showInputDialog("Enter your username: ");
       String password = JOptionPane.showInputDialog("Enter your password: ");
       
       if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
           JOptionPane.showConfirmDialog(null, "Welcome, " + username + "!");
           WelcomeToEasyKanban easy = new WelcomeToEasyKanban();
           easy.runApplications();
           return true;  
           //If login details are correct show welcome message. Proceed to main application screen or other options.
           
       } else {
           
           JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
           return false;
           //If login details have a mistake show this error message. 
       }
       }
   }