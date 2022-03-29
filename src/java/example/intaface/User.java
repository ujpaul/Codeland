/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package example.intaface;

import com.example.model.UserModel;
import java.util.LinkedHashMap;

/**
 *
 * @author janvier
 */
public interface User {
    public String  login(String password , String username) throws Exception;
    public LinkedHashMap<Integer,UserModel> register( UserModel user)throws Exception; 

}
