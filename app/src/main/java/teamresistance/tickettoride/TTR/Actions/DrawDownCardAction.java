package teamresistance.tickettoride.TTR.Actions;

import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.Game.actionMsg.GameAction;

/**
 *  Draws a card from a face down deck
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class DrawDownCardAction extends GameAction{
    public DrawDownCardAction(GamePlayer player) {
        super(player);
    }
}