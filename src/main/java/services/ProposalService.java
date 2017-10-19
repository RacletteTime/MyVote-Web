package main.java.services;

import main.java.beans.Choice;
import main.java.beans.Proposal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romain on 19/10/2017.
 */
public class ProposalService extends Service {
    public static final String PROPOSAL_URL = BASE_URL + "org.acme.bc.vote.Proposal/";

    public List<Proposal> getOnGoingProposals() {
        List<Object> proposals = parseJsonToBeanList(getUrl(PROPOSAL_URL), Proposal.class);
        if (proposals == null) {
            return null;
        }
        else {
            List<Proposal> onGoingProposals = new ArrayList<>();
            for (Object o : proposals) {
                Proposal proposal = (Proposal) o;
                if (proposal.isOnGoing()) {
                    onGoingProposals.add(proposal);
                }
            }
            return onGoingProposals;
        }
    }

    public Proposal getById(String id) {
        Proposal proposal = (Proposal) parseJsonToBean(getUrl(PROPOSAL_URL + id), Proposal.class);

        Integer totalVotes = 0;
        for (Choice choice : proposal.getChoices()) {
            totalVotes += Integer.valueOf(choice.getNbVotes());
        }
        proposal.setTotalVotes(totalVotes);

        for (Choice choice : proposal.getChoices()) {
            choice.setPercentage(Integer.valueOf(choice.getNbVotes()) / proposal.getTotalVotes() * 100);
        }

        return proposal;
    }
}
