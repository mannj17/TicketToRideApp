package teamresistance.tickettoride.TTR;

import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.Game.actionMsg.GameAction;

/**
 * Draws from the destination card deck
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class DrawDestinationCardAction extends GameAction{
    /*
     * Initializing a new action to change the mode
     */
    public DrawDestinationCardAction(GamePlayer player) {
        super(player);
    }
}
