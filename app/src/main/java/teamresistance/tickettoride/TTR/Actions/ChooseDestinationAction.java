package teamresistance.tickettoride.TTR.Actions;

import java.io.Serializable;

import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.Game.actionMsg.GameAction;

/**
 * When selecting new destination cards, this action chooses which of the three to take
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class ChooseDestinationAction extends GameAction implements Serializable {
    private static final long serialVersionUID = 388245564192016L;
    public ChooseDestinationAction(GamePlayer player) {
        super(player);
    }
}
