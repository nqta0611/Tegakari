package tegakari;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Helper methods for RobotEngineInActive
 * @author anhnguyen
 */
public class RobotEngineInActivePerformAction implements Serializable
{
     
    /**
     * Perform the action with chosen <code>ActionCard</code>.
     * @param action is the chosen <code>ActionCard</code> which was chosen by
     *        <code>RobotEngine</code>
     * @param active is the Robot engine in active class
     * @return a list of object to return to server or null if there is nothing
     *         to return.
     */
    public List<Object> actionPerform(ActionCard action, RobotEngineInActive active)
    {
        List<Object> toReturn = new ArrayList<Object>();
        // IF chosen ActioCard is Snoop
        if (action instanceof SnoopCard)
        {
            toReturn = this.performSnoop(action, active);
        }
        // ELSE IF chosen ActioCard is Sleuth
        else if (action instanceof SuperSleuthCard)
        {          
            toReturn = this.performSleuth(action, active);
        }
        // ELSE IF chosen ActioCard is PrivateTip
        else if (action instanceof PrivateTipCard)
        {
            toReturn = this.performTip(action, active);
        }
        // ELSE IF chosen ActioCard is Suggestion
        else if (action instanceof SuggestionCard)
        {
            // CALL playSuggestion
            toReturn = this.performSuggestion(action, active);
        }
        // ENDIF
        // RETURN objects to send to server.
        return toReturn;
    }
    
    private List<Object> performSuggestion(ActionCard action, RobotEngineInActive active)
    {
        boolean hasDisprover = false;
        List<Object> toReturn = new ArrayList<Object>();
        SuggestionCardLogic tempSuggestLogic = active.getRobotSLogic().playSuggestion();
        HistoryLog log = new HistoryLog(); 
        log.addToLog(active.getState().getLog().toString());
        log.addToLog(active.getState().getSelf().getName() + 
                " played this card: " + action.getActionText()
                + "\nand made this suggestion: " + tempSuggestLogic.getGuess() + ".");
        // Call isDisprovable to set disprover in the logic.
        if (tempSuggestLogic.isDisprovable(active.getState().getPlayers()))
        {
            System.out.println("it is disprovable by " + 
                    tempSuggestLogic.getDisprover().getName());
            active.setExpectedCard(1);
            hasDisprover = true;
        }
        else
        {
            log.addToLog("no one can disprove " + 
                    active.getState().getSelf().getName() + "'s suggestion.");
        }
        toReturn.add(log);
        //Only send suggestion when there is a disprover.
        if (hasDisprover)
        {
            toReturn.add(tempSuggestLogic);
        }
        return toReturn;
    }
    
    private List<Object> performSnoop(ActionCard action, RobotEngineInActive active)
    {
        //System.out.print("\tperform Snoop");
        List<Object> toReturn = new ArrayList<Object>();
        Player target = null;
        ClueCard snooped = null;
        HistoryLog log = new HistoryLog(); 
        // checks if the snoop is an allsnoop
        if (!((SnoopCard)action).isAllSnoop())
        { 
            //System.out.println("\tthis is a regular Snoop Card");
            // determin target player
            target = ((RobotSnoopLogic)active.getRobotLogic()).chooseTargetPlayer(
                active.getState().getNote(), action);
            
            //System.out.println("\ttarget player is " + target.getName());
            
            // CALL playSnoop
            snooped = ((RobotSnoopLogic)active.getRobotLogic()).playSnoop(
                    (SnoopCard)action, active.getState().getNote(), target, 
                    null, active.getEngine().getIntelligentLevel());
            //System.out.println("\tsnooped card is " + snooped.getName());
            
            log.addToLog(active.getState().getLog().toString());
            log.addToLog(active.getState().getSelf().getName() + 
                    " snooped on " + target.getName());
            //System.out.println("\t added history log");
        }
        else
        {
            //System.out.println("\tthis is a All Snoop Card");
            // Determine target player
            ArrayList<Player>  playersList = 
                    new ArrayList<Player>(active.getState().getPlayers());
            int indexTargetPlayer = 0;
            // GET correct target player index
            if (((SnoopCard)action).getDirection().isRight())
            {
                indexTargetPlayer = playersList.size()-1;
            }
            else
            {
                indexTargetPlayer = 1;
            }
            target =  playersList.get(indexTargetPlayer);
            //System.out.println("\ttarget player is " + target.getName());
            
            Random gen = new Random();
            int ndx = gen.nextInt(target.getClueCards().size());
            snooped = target.getClueCards().get(ndx);
            //System.out.println("\tsnooped card is " + snooped.getName());
            
            // CREATE CardMessage with SnoopCard to all player player -- 
            //except self at 1
            for(int ind = 1; ind < playersList.size(); ind++)
            {
                //System.out.println("\tmade card message with Action Snoop 
                //Card to " + playersList.get(ind).getName());
                toReturn.add(new CardMessage(playersList.get(ind),
                        active.getState().getSelf(), (SnoopCard)action));
            }
            //Expected one player to snoop on me
            active.setExpectedCard(1);
            
            log.addToLog(active.getState().getLog().toString());
            log.addToLog(active.getState().getSelf().getName() + 
                    " played " + action.getActionText());
            
        }
        //System.out.println("\t added history log");
        toReturn.add(log);
        active.getState().getNote().mark(snooped, target, NoteEntry.HAS);
        //System.out.println("\t marked note");
        CardMessage mess = new CardMessage(target, active.getState().getSelf(), snooped);
        //System.out.println("\tmade card message with clue card robot 
        //just snoop to " + target.getName());
        toReturn.add(mess);
        
        return toReturn;
    }
    
    
    private List<Object> performSleuth(ActionCard action, RobotEngineInActive active)
    {
        System.out.print("\tperform Sleuth");
        List<Object> toReturn = new ArrayList<Object>();
        // CALL playSleuth
        // WRITE to log "<turnPlayer> play this <sleuthCard> : Everyone shows...."
        HistoryLog log = new HistoryLog(); 
        log.addToLog(active.getState().getLog().toString());
        log.addToLog(active.getState().getTurnPlayer().getName()
            + " played this Super Sleuth card: " + action.getActionText() + ".");

        // SET expectedReceivingCard to 0
        active.setExpectedCard(0);
        SuperSleuthCardLogic sleuthLogic = 
            new SuperSleuthCardLogic((SuperSleuthCard)action,
                active.getState().getTurnPlayer());  
        System.out.println("\tcreated sleuthLogic");

        String names = "";
        List<Object> temp = new ArrayList<Object>();
        //FOR each player who has a appropriate card to show, except turn player
        for (Player player : active.getState().getPlayers())
        {
            // CHECK for a player with an appropriate card to show
            if (!player.equals(active.getState().getTurnPlayer())
                && sleuthLogic.playSuperSleuth(player).size() > 0)
            {         
                names = names + "[" + player.getName() + "] ";
                //INCREMENT expectedReceivingCard
                active.setExpectedCard(active.getExpectedCard() + 1);
                //MAKE a card messenger sending this action card to player
                //ADD this card messeger to the list of card message
                temp.add(new CardMessage(player,
                    active.getState().getSelf(), (SuperSleuthCard)action));
            }
        }
        //IF expectedReceivingSleuth is 0, means no one has card to show
        if (active.getExpectedCard() == 0)
        {
            log.addToLog("No one can respond to " 
                + active.getState().getTurnPlayer().getName() + "'s Super Sleuth card.");
        }
        else
        {
            log.addToLog(names + " each showed "
                        + active.getState().getTurnPlayer().getName()
                        + " a Clue Card in response to a SuperSleuth");
        }
        System.out.println("\texpected clues: " + active.getExpectedCard());
        // ADD history log to the return list
        toReturn.add(log);
        System.out.println("\tadded HistoryLog");
        //Add all card message to return list.
        for(Object object: temp)
        {
            toReturn.add(object);
        }
        return toReturn;
    }
    private List<Object> performTip(ActionCard action, RobotEngineInActive active)
    {
        List<Object> toReturn = new ArrayList<Object>();
        // CALL playPrivateTip
        //OBTAIN user's target player to hand this private tip card to
        
        Player target = ((RobotPrivateTipLogic)active.getRobotLogic()).getTargetPlayer();
        System.out.println("\tTarget Player:" + target.getName());
        
        // In case robot make false calculation and return it self as the target player
        if (target.getName().equals(active.getState().getSelf().getName()))
        {
            ArrayList<Player>  playersList = 
                    new ArrayList<Player>(active.getState().getPlayers());
            target = playersList.get(1);
        }

        //WRITE to log "<turnPlayer> play a private tip on <targetPlayer>"
        HistoryLog log = new HistoryLog(); 
        log.addToLog(active.getState().getLog().toString());
        log.addToLog(active.getState().getTurnPlayer().getName() 
            + " played a Private Tip on " + target.getName() + ".");
        //ADD HistoryLog to the return list
        toReturn.add(log);
        
        PrivateTipCardLogic tipLogic = 
             new PrivateTipCardLogic((PrivateTipCard)action,
                active.getState().getTurnPlayer(), target);

        //IF this PrivateTip card is showAll
        if (((PrivateTipCard)action).isAll())
        {
            // DISPLAY all to turnPlayer
            List<ClueCard> toShow = tipLogic.playPrivateTip(target);
            System.out.println("\tPrivate Tip calls for multiple cards available."
                    + " # of cards: " + toShow.size());
            // EXISTS approriate cards to show
            if (toShow.size() > 0)
            {
                Notepad pad = active.getState().getNote();
                //mark off the notepad
                for(ClueCard card : toShow) 
                {
                    pad.mark(card, target, NoteEntry.HAS);
                }
            }
        }
        //ELSE IF the target player has a card to show
        else if (tipLogic.playPrivateTip(target).size() > 0)
        {
            // SET expectedReceivingCard to 1
            active.setExpectedCard(1);
        }
        //ELSE for debug printing purpose only
        else
        {
            System.out.println("Target has no clues to show robot.");
        }
        
        // MAKE a card message with this privatetip card and add to return list
        toReturn.add(new CardMessage(target,
                active.getState().getSelf(), (PrivateTipCard)action));
        return toReturn;
    }
}
