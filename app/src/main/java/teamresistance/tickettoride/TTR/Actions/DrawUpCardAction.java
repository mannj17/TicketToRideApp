package teamresistance.tickettoride.TTR.Actions;

import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.Game.actionMsg.GameAction;

/**
 *  Draws a card from a face up deck
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class DrawUpCardAction extends GameAction {
    private int pos;
    public DrawUpCardAction(GamePlayer player, int pos) {
        super(player);
        this.pos = pos;
    }

    public int getPos(){
        return pos;
    }
}
