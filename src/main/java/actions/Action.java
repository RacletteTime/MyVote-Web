package main.java.actions;

import com.opensymphony.xwork2.ActionContext;
import main.java.beans.User;
import main.java.services.UserService;

/**
 * Created by Romain on 19/10/2017.
 */
public abstract class Action {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILURE = "FAILURE";
    public static final String NOT_LOGGED = "NOT_LOGGED";

    public String getParamValue(String param) {
        return ActionContext.getContext().getParameters().get(param).getValue();
    }
}
