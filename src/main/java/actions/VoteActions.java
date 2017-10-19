package main.java.actions;

import main.java.services.VoteService;

/**
 * Created by Romain on 19/10/2017.
 */
public class VoteActions extends Action {
    public String vote() {
        VoteService voteService = new VoteService();
        return voteService.vote(getParamValue("proposal"), getParamValue("choice"));
    }
}
