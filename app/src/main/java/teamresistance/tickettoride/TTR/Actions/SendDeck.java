package teamresistance.tickettoride.TTR.Actions;

import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.Game.actionMsg.GameAction;
import teamresistance.tickettoride.TTR.Deck;

/**
 *  Sends Deck
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version April 2016
 */
public class SendDeck extends GameAction {
    private Deck sendDeck;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public SendDeck(GamePlayer player) {
        super(player);
    }
}
