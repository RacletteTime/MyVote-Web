package main.java.services;

import main.java.beans.Vote;

/**
 * Created by Romain on 19/10/2017.
 */
public class VoteService extends Service {
    public static final String VOTE_URL = BASE_URL + "org.acme.bc.vote.Vote/";

    public String vote(String proposal, String choice) {
        Vote vote = new Vote();
        ChoiceService choiceService = new ChoiceService();

        vote.setProposal(proposal);
        vote.setChoice(choiceService.getById(choice));

        return postBean(getUrl(VOTE_URL), vote);
    }
}
