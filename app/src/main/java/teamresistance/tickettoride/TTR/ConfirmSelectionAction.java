package teamresistance.tickettoride.TTR;

import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.Game.actionMsg.GameAction;

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
    public ConfirmSelectionAction(GamePlayer player) {
        super(player);
    }
}
