package main.java.actions;

import com.opensymphony.xwork2.ActionContext;
import main.java.beans.User;
import main.java.services.UserService;

import java.util.Map;

/**
 * Created by Romain on 19/10/2017.
 */
public class UserActions extends Action {
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String loginExecute() {
        UserService userService = new UserService();

        User currentUser = userService.login(user.getEmail(), user.getPassword());
        if (currentUser != null) {
            Map session = ActionContext.getContext().getSession();
            session.put("user", currentUser.getEmail());
            return SUCCESS;
        } else {
            return FAILURE;
        }
    }
}
