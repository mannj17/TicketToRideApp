package teamresistance.tickettoride.TTR;

import java.util.Random;

import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.Game.LocalGame;
import teamresistance.tickettoride.Game.actionMsg.GameAction;

/**
 * Controls the game, allowing actions to be performed by
 * the player with the matching ID
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class TTRLocalGame extends LocalGame {
    //instance variables for the TTRLocalGame
    private TTRGameState mainState;
    private boolean noMoreTrains;
    private int turnsLeft;
    private int topScorePlayer = 0;

    /**
     * TTRLocalGame constructor
     */
    public TTRLocalGame(){
        noMoreTrains = false;
        mainState = new TTRGameState();
        turnsLeft = mainState.getNumPlayers();
    }

    /**
     * Sends updated game state
     * @param p - receiving player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        TTRGameState copy = new TTRGameState(mainState);
        p.sendInfo(copy);
    }

    /**
     * Returns if the player can make a move
     * @param playerIdx
     * 		the player's player-number (ID)
     * @return
     */
    @Override
    protected boolean canMove(int playerIdx) {
        return playerIdx == mainState.getPlayerID();
    }

    /**
     * Returns the end game status
     * @return
     */
    @Override
    protected String checkIfGameOver() {
        for(int i = 0; i < mainState.getTrainTokens().length; i++){
            if(mainState.getTrainTokens()[i] <=2){
                noMoreTrains = true;
            }
        }
        if(noMoreTrains){
            turnsLeft--;
        }
        if(turnsLeft == 0){
            for(int j = 0; j < mainState.getScores().length; j++){
                if(mainState.getScores()[j] > mainState.getScores()[topScorePlayer]){
                    topScorePlayer = j;
                }
            }
            return ("Player Wins");
        }
        return null;
    }

    /**
     * Returns if the player made a move
     * @param action
     * 			The move that the player has sent to the game
     * @return
     */
    @Override
    protected boolean makeMove(GameAction action) {

        return false;
    }

    @Override
    public void start(GamePlayer[] players)
    {
        //Sets gameState's numPlayer and play order
        mainState.setNumPlayers(players.length);
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        mainState.setPlayerID(rand.nextInt(players.length));

        super.start(players);
    }
}
