package main.java.services;

import main.java.beans.Choice;

/**
 * Created by Romain on 19/10/2017.
 */
public class ChoiceService extends Service {
    public static final String CHOICE_URL = BASE_URL + "org.acme.bc.vote.Choice/";

    public Choice getById(String id) {
        return (Choice) parseJsonToBean(getUrl(CHOICE_URL + id), Choice.class);
    }
}
