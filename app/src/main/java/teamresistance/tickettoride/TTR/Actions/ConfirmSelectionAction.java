package teamresistance.tickettoride.TTR.Actions;

import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.Game.actionMsg.GameAction;
import teamresistance.tickettoride.TTR.Deck;

/**
 * Confirms the GameAction of the player who made the selection
 *
 *@author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class ConfirmSelectionAction extends GameAction {
    private Deck sendDeck = null;

    public ConfirmSelectionAction(GamePlayer player){
        super(player);
    }

    public ConfirmSelectionAction(GamePlayer player, Deck sendDeck) {
        super(player);
        this.sendDeck = sendDeck;
    }

    public Deck getSendDeck(){return this.sendDeck;}
}
