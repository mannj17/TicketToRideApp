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
    private String chosenColor = null;
    private int useRainbow = 0;

    public ConfirmSelectionAction(GamePlayer player){
        super(player);
    }

    public ConfirmSelectionAction(GamePlayer player, Deck sendDeck) {
        super(player);
        this.sendDeck = sendDeck;
    }

    public ConfirmSelectionAction(GamePlayer player, String chosenColor, int useRainbow){
        super(player);
        this.chosenColor = chosenColor;
        this.useRainbow = useRainbow;
    }

    public Deck getSendDeck(){return this.sendDeck;}

    public String getChosenColor(){return this.chosenColor;}

    public int getUseRainbow(){return this.useRainbow;}
}
