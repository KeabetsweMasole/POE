/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrationandloginfeatures;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Keabetswe Masole
 */
public class RegistrationAndLoginFeatures {
    public static void main(String[] args) {
        boolean loggedIn = false;
        
        Map<String, String> userCredentials = new HashMap<>();
        SignUp registerUser = new SignUp(userCredentials);
        Login login = new Login(userCredentials);

        while (!loggedIn) {
            String choice = JOptionPane.showInputDialog("Choose an option:\n1. Login\n2. Sign up\n3. Exit");
            switch (choice) {
                case "1":
                    loggedIn = login.main();
                    
                    //Should starrt EasyKandan after sucessful login.
                    if (loggedIn) {
                    }
                    break;

                case "2":
                    registerUser.main();
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    loggedIn = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                    break;

            }
        }
    }
}