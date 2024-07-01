/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrationandloginfeatures;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Keabetswe Masole
 */
public class SignUp {
  private Map<String, String> userCredentials;

    public SignUp(Map<String, String> userCredentials) {
        this.userCredentials = userCredentials; // Initialize the map
    }

    public void main() {
        String username;
        String password;

        do {
            username = JOptionPane.showInputDialog("Enter a new username:");
            password = JOptionPane.showInputDialog("Enter a password:");

            if (username == null || password == null) {
                // User cancelled the registration
                return;
            }

            // Validate username
            if (username.length() < 5 || !username.contains("_")) {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted. Please ensure that your username contains an underscore and is at least 5 characters in length.");
            } else {
                JOptionPane.showMessageDialog(null, "Username successfully captured");
                userCredentials.put(username, password); // Add valid username and password to the map
            }

            // Validate password
            if (password.length() < 8 || !containsUpperCase(password) || !containsDigit(password) || !containsSpecialCharacter(password)) {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            } else {
                JOptionPane.showMessageDialog(null, "Password successfully captured");
            }
        } while (username == null || password == null || username.length() < 5 || !username.contains("_") || password.length() < 8 || !containsUpperCase(password) || !containsDigit(password) || !containsSpecialCharacter(password));
    }

    public Map<String, String> getUserCredentials() {
        return userCredentials;
    }

    // Helper methods for password validation
    private static boolean containsUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsSpecialCharacter(String password) {
        String specialCharacters = "!@#$%^&()+-=[]{};':\"|,.<>?";
        for (char c : password.toCharArray()) {
            if (specialCharacters.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}