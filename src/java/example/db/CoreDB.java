/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package example.db;

import com.example.model.UserModel;
import java.util.LinkedHashMap;

/**
 *
 * @author Paul
 */
public class CoreDB {
    private LinkedHashMap<Integer, UserModel> lhmData = new LinkedHashMap<Integer, UserModel>();
	private static final CoreDB instance = new CoreDB();
	private CoreDB() {
		
	}
	public static CoreDB getInstance() {
		return instance;
	}
	public LinkedHashMap<Integer, UserModel> getData() {
		return lhmData;
	}
    
}
