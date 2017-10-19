package main.java.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Romain on 19/10/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vote {
    String proposal;
    Choice choice;
    String userInfos;

    public String getProposal() {
        return proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    public String getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(String userInfos) {
        this.userInfos = userInfos;
    }
}
