/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package example.helpers;

/**
 *
 * @author janvier
 */
public class HashPass {
      
	private static HashPass instance = null;
	/**   @param {String } int  
         *    Reverse the whole password.
	 *    @description Concatenate  the result with the age of the user
	      @return Added two asterix at the beginning and two asterix at the end.
	 */
	     public static HashPass getInstance()
	     {
	         if (instance == null)
	             instance = new HashPass();
	  
	         return instance;
	     }
	     
	    public String hashPassword(String pass, String age){
	        String hashed = new StringBuilder(pass).reverse().toString();
	        return "**"+hashed+age+"**";
	                
	    } 
	    public String unHashedPass(String signedUserPass, int age){
	       String pass = signedUserPass.substring(2, signedUserPass.length() - 2); // remove trailling stars
	       String decodedPass =pass.replace(String.valueOf(age),"");
	      return new StringBuilder(decodedPass).reverse().toString();
	    }
    
}
