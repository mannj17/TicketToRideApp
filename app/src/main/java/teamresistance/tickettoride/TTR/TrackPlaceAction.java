package teamresistance.tickettoride.TTR;

import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.Game.actionMsg.GameAction;

/**
 *  TrackPlaceAction places a track
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class TrackPlaceAction extends GameAction{

    private String chosenColor;
    private int xPos;
    private int yPos;


    /*
     * Initializing a new action to change the mode
     * @player
     */

    public TrackPlaceAction(GamePlayer player, String chosenColor, int x, int y) {
        super(player);
        this.chosenColor = chosenColor;
        this.xPos = x;
        this.yPos = y;
    }

    public void setChosenColor(String value){
        this.chosenColor = value;
    }

    public void setXPos(int value){
        this.xPos = value;
    }

    public void setYPos(int value){
        this.yPos = value;
    }

    public String getChosenColor(){
        return this.chosenColor;
    }

    public int getXPos(){
        return this.xPos;
    }

    public int getYPos(){ return this.yPos; }
}
