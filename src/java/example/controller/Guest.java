
package example.controller;

import com.example.model.UserModel;
import example.db.CoreDB;
import example.intaface.User;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Paul
 */
public class Guest implements User {

    @Override
    public String login(String username, String password) throws Exception {
      String redirectTo = "";

		LinkedHashMap<Integer, UserModel> user = CoreDB.getInstance().getData();

		for (Map.Entry<Integer, UserModel> entry : user.entrySet()) {
			
			UserModel currentUser = entry.getValue();
			if (username.equals(currentUser.getUsername()) && password.equals(currentUser.getUserPassword())) {
				redirectTo = "/WEB-INF/detail.jsp";
			} else {
				redirectTo = "/WEB-INF/notfound.jsp";
			}
                        return redirectTo;
		}
		return redirectTo;
    }

    @Override
    public LinkedHashMap<Integer, UserModel> register(UserModel user) throws Exception {
        LinkedHashMap<Integer, UserModel> newUser  = CoreDB.getInstance().getData();
       newUser.put(new Random().nextInt(23), user);
      
       return newUser;
    }
    
}
