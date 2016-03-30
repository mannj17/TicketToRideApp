package teamresistance.tickettoride.TTR;

import android.view.View;

import teamresistance.tickettoride.Game.GameMainActivity;
import teamresistance.tickettoride.Game.infoMsg.GameInfo;

/**
 *
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class TTRHumanPlayer {
    private GameMainActivity myActivity;
    private Deck trainDeck;
    private Deck destinationDeck;
    private int score;
    private String name;
    private Boolean isTurn;
    private int trainTokens;

    /*
     * The human player
     * @name
     */
    public TTRHumanPlayer(String name) {
    
    }


    /*
     * returns the top view for the player
     */
    public View getTopView() {
     return null;
    }


    /*
     * Sets the GUI for the player
     * @mainActivity
     */
    public void setAsGui(GameMainActivity mainActivity) {
    
    }


    /*
     * recieves and interprets info from the local game
     * @info
     */
    public void recieveInfo(GameInfo info) {
    
    }
}
