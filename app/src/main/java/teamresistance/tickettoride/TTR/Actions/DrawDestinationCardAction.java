package teamresistance.tickettoride.TTR.Actions;

import android.app.Activity;

import java.io.Serializable;

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
public class DrawDestinationCardAction extends GameAction implements Serializable {
    private static final long serialVersionUID = 310248245564192016L;
    /*
     * Initializing a new action to change the mode
     */
    public DrawDestinationCardAction(GamePlayer player) {
        super(player);
    }
}
