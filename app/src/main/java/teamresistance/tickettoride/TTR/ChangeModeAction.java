package teamresistance.tickettoride.TTR;

import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.Game.actionMsg.GameAction;

/**
 * Changes the GameAction made to the new player
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class ChangeModeAction extends GameAction {
    public ChangeModeAction(GamePlayer player) {
        super(player);
    }
}