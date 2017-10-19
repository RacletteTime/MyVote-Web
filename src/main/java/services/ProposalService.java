package main.java.services;

import main.java.beans.Choice;
import main.java.beans.Proposal;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romain on 19/10/2017.
 */
public class ProposalService extends Service {
    public static final String PROPOSAL_URL = BASE_URL + "org.acme.bc.vote.Proposal/";

    public List<Proposal> getProposals() {
        List<Object> proposals = parseJsonToBeanList(getUrl(PROPOSAL_URL), Proposal.class);
        if (proposals == null) {
            return null;
        }
        else {
            List<Proposal> newProposals = new ArrayList<>();
            for (Object o : proposals) {
                Proposal proposal = (Proposal) o;
                proposal.setChoiceItems(getChoiceItems(proposal));
                if (proposal.isEnded()) {
                    proposal = calculatePercentages(proposal);
                }
                newProposals.add(proposal);
            }
            return newProposals;
        }
    }

    public Proposal getById(String id) {
        Proposal proposal = (Proposal) parseJsonToBean(getUrl(PROPOSAL_URL + id), Proposal.class);
        proposal = calculatePercentages(proposal);

        return proposal;
    }

    public List<Choice> getChoiceItems(Proposal proposal) {
        ChoiceService choiceService = new ChoiceService();
        List<Choice> choiceItems = new ArrayList<>();

        for (String choice : proposal.getChoices()) {
            choiceItems.add(choiceService.getById(choice));
        }

        return choiceItems;
    }

    public Proposal calculatePercentages(Proposal proposal) {
        ChoiceService choiceService = new ChoiceService();
        List<Choice> tempChoiceItems = new ArrayList<>();
        List<Choice> choiceItems = new ArrayList<>();

        Integer totalVotes = 0;
        for (String choiceId : proposal.getChoices()) {
            Choice choice = choiceService.getById(choiceId);
            totalVotes += Integer.valueOf(choice.getNbVotes());
            tempChoiceItems.add(choice);
        }
        proposal.setTotalVotes(totalVotes);

        for (Choice choice : tempChoiceItems) {
            Double percentage = (Double.valueOf(choice.getNbVotes()) / proposal.getTotalVotes()) * 100;
            choice.setPercentage((double) (Math.round(percentage * 1000) / 1000));
            choiceItems.add(choice);
        }
        proposal.setChoiceItems(choiceItems);

        return proposal;
    }
}
