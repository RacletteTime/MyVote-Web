package main.java.services;

import com.opensymphony.xwork2.ActionContext;
import main.java.beans.Submitter;
import main.java.beans.User;
import main.java.beans.Voter;

import java.net.URL;

/**
 * Created by Romain on 19/10/2017.
 */
public class UserService extends Service {
    public User login(String email, String password) {
        User user = getByEmail(email);

        if (user != null && password.equals(user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    public User getByEmail(String email) {
        User user = null;

        URL url = getUrl(VoterService.VOTER_URL + email);
        if (url != null) {
            user = (Voter) parseJsonToBean(url, Voter.class);
            if (user != null)
                user.setType(User.VOTER_TYPE);
        }
        else {
            url = getUrl(SubmitterService.SUBMITTER_URL);
            if (url != null) {
                user = (Submitter) parseJsonToBean(url, Submitter.class);
                if (user != null)
                    user.setType(User.SUBMITTER_TYPE);
            }
        }

        return user;
    }

    public User getCurrentUser() {
        UserService userService = new UserService();
        return userService.getByEmail((String) ActionContext.getContext().getSession().get("user"));
    }
}
