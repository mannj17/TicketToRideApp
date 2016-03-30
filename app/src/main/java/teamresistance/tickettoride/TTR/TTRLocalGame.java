package teamresistance.tickettoride.TTR;

import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.Game.actionMsg.GameAction;

/**
 *
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
class TTRLocalGame {


    /*
     * the current game state of the game
     */

    private TTRGameState mainState;

    /*
     * Says if the game is down to the last turn for each player
     */

    private boolean noMoreTrains;

    /*
     * Once one of the conditions has been met for a game over, this int keeps track of how many more players need to make their final turn
     */

    private int turnsLeft;

    /*
     * Holds the current highest score in the case that the game is over and the winner needs to be found.
     */

    private int scorePlayer;


    /*
     * Sends the state of the game to a player
     * @p
     */

    protected void sendUpdatedStateTo(GamePlayer p) {
    
    }


    /*
     * Says if the player can move
     * @playerIdx
     */

    protected boolean canMove(int playerIdx) {
     return false;
    }


    /*
     * Checks if the game is over and if it is, returns the result
     */

    protected final String checkIfGameOver() {
     return null;
    }


    /*
     * Takes a GameAction and makes changes to the GameState depending on what action it is
     * @action
     */

    protected boolean makeMove(GameAction action) {
     return false;
    }


    /*
     * Sets up the local game
     */

    public TTRLocalGame() {
    
    }


}
