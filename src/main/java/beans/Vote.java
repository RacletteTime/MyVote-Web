package main.java.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Romain on 19/10/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vote {
    String proposal;
    String choice;
    String voter;

    public String getProposal() {
        return proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }
}
