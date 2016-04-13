package teamresistance.tickettoride.TTR.Actions;

import teamresistance.tickettoride.Game.Game;
import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.Game.actionMsg.GameAction;
import teamresistance.tickettoride.TTR.Deck;

/**
 * Created by Parker on 4/12/2016.
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
