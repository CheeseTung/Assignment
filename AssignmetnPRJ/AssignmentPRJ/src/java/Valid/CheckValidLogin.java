/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Valid;

import java.io.IOException;

/**
 *
 * @author chitung
 */
public class CheckValidLogin {
    //IDs are only allowed to enter numbers and letters
    private static final String String_VALID = "[0-9A-Za-z]*";
    
    public static String inputString(String raw_username) {
        /*using a while loop makes it possible for the user to 
          re-enter if an exception occurs*/
        while (true) {
            String username = raw_username.trim();
            //ID can not empty
            if (username.isEmpty()) {
                String error = "username or password can't empty! Please try again";
            }//Can not enter special character
            else if (!username.matches(String_VALID)) {
                String error1 = "Do not enter special characters, try again";
            } else {
                return username;
            }
        }
    }
}
