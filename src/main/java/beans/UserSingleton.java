package main.java.beans;

/**
 * Created by pierre on 18/10/2017.
 */

public class UserSingleton {
    public static final UserSingleton ourInstance = new UserSingleton();

    public static UserSingleton getInstance() {
        return ourInstance;
    }

    public static UserSingleton getOurInstance() {
        return ourInstance;
    }

    public UserSingleton() {
        String email;
        String password;
        String firstName;
        String lastName;
        String cp;
        String city;
        String birthdate;
        String gender;
        String nationality;
    }
}
