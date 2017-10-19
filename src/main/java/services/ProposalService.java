package main.java.services;

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
}
