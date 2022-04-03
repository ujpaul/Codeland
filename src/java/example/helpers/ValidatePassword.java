/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package example.helpers;

import example.db.CoreDB;

/**
 *
 * @author Paul
 */
public class ValidatePassword {
    
    /**
       @Param {String, String}  password and role entered by user
       * @description verify if password length is equal to 5
       * @return  {Boolean}
     */
    private static final ValidatePassword instance = new ValidatePassword();
    public static ValidatePassword getInstance() {
		return instance;
	}
    
    public Boolean guestPassword(String password){
         if(password.length() != 5){
            return false;
        }
        return true;
        
    }
    
     /**
       @Param {String, String}  password and role entered by user
       * @description verify if password length is equal to 5
       * @return  {Boolean}
     */
    
    public Boolean adminPassword(String password){
        if(password.length() != 10){
            return false;
        }
        return true;
    }
    
}
