package main.java.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import main.java.actions.Action;
import main.java.services.UserService;

/**
 * Created by Romain on 19/10/2017.
 */
public class LoginInterceptor extends AbstractInterceptor {
    public String intercept(ActionInvocation invocation) throws Exception {
        UserService userService = new UserService();
        String result = null;

        if (userService.getCurrentUser() == null) {
            result = Action.NOT_LOGGED;
        }
        else {
            result = invocation.invoke();
        }

        return result;
    }
}
