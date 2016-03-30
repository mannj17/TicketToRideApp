package teamresistance.tickettoride.TTR;

import teamresistance.tickettoride.Game.infoMsg.GameInfo;

/**
 *  TTRComputerPlayer implements and AI player
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class TTRComputerPlayer {
    /*
     * Sets up the ComputerPlayer and its difficulty
     * @name set by the human player at start
     * @difficulty used to set how hard the AI will be
     */
    public TTRComputerPlayer(String name, boolean difficulty) {

    }

    /*
     * Says if player is smart or dumb
     */

    private boolean isDifficult;
    private Deck trainDeck;
    private Deck destinationDeck;
    private int score;
    private String name;
    private int trainTokens;
    private Boolean isTurn;


    /*
     * recieves and interprets info from the local game
     * @info
     */

    protected final void recieveInfo(GameInfo info) {
    
    }


    /*
     * Finds the best move for the computer player and makes that move based on what it finds
     * @info
     */

    protected final void findBestMove(GameInfo info) {
    
    }

}
