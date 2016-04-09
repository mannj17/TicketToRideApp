package teamresistance.tickettoride.TTR;

import android.util.Log;

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
        mainState = new TTRGameState();
        noMoreTrains = false;
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
        if(action instanceof ChangeModeAction){
            if(mainState.getCardModeSelected()){
                mainState.setCardModeSelected(false);
                mainState.setTrackModeSelected(true);
                mainState.getFaceDownTrainCards().setHighlight(false);
                mainState.getDestinationCards().setHighlight(false);
                mainState.setDestinationCardsSelected(false);
                mainState.setTrainCardsSelected(false);
                for(int i = 0; i < mainState.getFaceUpTrainCards().size(); i++){
                    mainState.getFaceUpTrainCards().getCards().get(i).setHighlight(false);
                }
            }
            else if(mainState.getTrackModeSelected()){
                mainState.setCardModeSelected(true);
                mainState.setTrackModeSelected(false);
                //TODO
            }
            return true;
        }
        else if(action instanceof ConfirmSelectionAction){
            if(mainState.getTrainCardsSelected()){
                if(mainState.getOnlyDownDeck() && mainState.getFaceDownTrainCards().getHighlight()){
                    mainState.getFaceDownTrainCards().moveTopCardTo(
                            mainState.getPlayerTrainDecks()[mainState.getPlayerID()],
                            mainState.getFaceDownTrainCards());
                    mainState.getFaceDownTrainCards().moveTopCardTo(
                            mainState.getPlayerTrainDecks()[mainState.getPlayerID()],
                            mainState.getFaceDownTrainCards());
                }
                else if(!mainState.getOnlyDownDeck() && mainState.getFaceDownTrainCards().getHighlight()){
                    mainState.getFaceDownTrainCards().moveTopCardTo(
                            mainState.getPlayerTrainDecks()[mainState.getPlayerID()],
                            mainState.getFaceDownTrainCards());
                    for(int i = 0; i < mainState.getFaceUpTrainCards().size(); i++) {
                        if (mainState.getFaceUpTrainCards().getCards().get(i).getHighlight()) {
                            Card temp = mainState.getFaceUpTrainCards().getCards().get(i);
                            mainState.getPlayerTrainDecks()[mainState.getPlayerID()].add(temp);
                            mainState.getFaceUpTrainCards().getCards().remove(i);
                            mainState.getFaceDownTrainCards().moveTopCardTo(
                                    mainState.getFaceUpTrainCards(), mainState.getFaceUpTrainCards());
                            mainState.getFaceUpTrainCards().getCards().get(i).setHighlight(false);
                        }
                    }
                    mainState.getFaceDownTrainCards().setHighlight(false);
                }
                else if(!mainState.getOnlyDownDeck() && !mainState.getFaceDownTrainCards().getHighlight()){
                    for(int i = 0; i < mainState.getFaceUpTrainCards().size(); i++){
                        if(mainState.getFaceUpTrainCards().getCards().get(i).getHighlight()){
                            Card temp = mainState.getFaceUpTrainCards().getCards().get(i);
                            mainState.getPlayerTrainDecks()[mainState.getPlayerID()].add(temp);
                            mainState.getFaceUpTrainCards().getCards().remove(i);
                            mainState.getFaceDownTrainCards().moveTopCardTo(
                                    mainState.getFaceUpTrainCards(), mainState.getFaceDownTrainCards());
                            mainState.getFaceUpTrainCards().getCards().get(i).setHighlight(false);
                        }
                    }

                }
                mainState.setTrainCardsSelected(false);
            }
            else if(mainState.getDestinationCardsSelected()){
                mainState.setIsSelectDestinationCards(true);
                for(int i = 0; i < 3; i++){
                    mainState.getFaceDownTrainCards().moveTopCardTo(
                            mainState.getDestinationCards(),
                            mainState.getDestinationPool());
                }
            }
            mainState.setPlayerID((mainState.getPlayerID()+1)%mainState.getNumPlayers());
            return true;
        }
//        else if(action instanceof TrackPlaceAction){
//            return true;
//        }
        else if(action instanceof DrawUpCardAction){
            if(mainState.getTrackModeSelected()){
                return false;
            }
            else if(mainState.getDestinationCardsSelected()){
                mainState.getDestinationCards().setHighlight(false);
                mainState.setDestinationCardsSelected(false);
            }
            DrawUpCardAction temp = (DrawUpCardAction)action;
            int pos = temp.getPos();
            int numHighlights = 0;
            for(int i = 0; i < mainState.getFaceUpTrainCards().size(); i++){
                if(mainState.getFaceUpTrainCards().getCards().get(i).getHighlight()){
                    numHighlights++;
                    mainState.setOnlyDownDeck(false);
                    mainState.setTrainCardsSelected(true);
                }
            }
            if(mainState.getFaceDownTrainCards().getHighlight()){
                numHighlights++;
                mainState.setTrainCardsSelected(true);
            }
            if(numHighlights < 2){
                if(mainState.getFaceUpTrainCards().getCards().get(pos).getHighlight()){
                    mainState.getFaceUpTrainCards().getCards().get(pos).setHighlight(false);
                    mainState.setTrainCardsSelected(false);
                }
                else{
                    mainState.getFaceUpTrainCards().getCards().get(pos).setHighlight(true);
                    mainState.setTrainCardsSelected(true);
                }
            }
            else if(mainState.getFaceUpTrainCards().getCards().get(pos).getHighlight()){
                mainState.getFaceUpTrainCards().getCards().get(pos).setHighlight(false);
                mainState.setTrainCardsSelected(true);
            }
            return true;
        }
        else if(action instanceof DrawDownCardAction) {
            if(mainState.getTrackModeSelected()){
                return false;
            }
            else if(mainState.getDestinationCardsSelected()){
                mainState.getDestinationCards().setHighlight(false);
                mainState.setDestinationCardsSelected(false);
            }
            else if(mainState.getTrainCardsSelected() &&
                    mainState.getFaceDownTrainCards().getHighlight()){
                if(mainState.getOnlyDownDeck()){
                    mainState.setTrainCardsSelected(false);
                }
                mainState.setOnlyDownDeck(false);
                mainState.getFaceDownTrainCards().setHighlight(false);
            }
            else if(mainState.getTrainCardsSelected()
                    && !mainState.getFaceDownTrainCards().getHighlight()){
                int highlightNum = 0;
                for (int i = 0; i < mainState.getFaceUpTrainCards().size(); i++){
                    if(mainState.getFaceUpTrainCards().getCards().get(i).getHighlight()){
                        highlightNum++;
                    }
                }
                if(highlightNum < 2){
                    mainState.getFaceDownTrainCards().setHighlight(true);
                }
                mainState.setOnlyDownDeck(false);
            }
            else if(!mainState.getTrainCardsSelected() && !mainState.getOnlyDownDeck()){
                mainState.setOnlyDownDeck(true);
                mainState.setTrainCardsSelected(true);
                mainState.getFaceDownTrainCards().setHighlight(true);
            }
            else{
                return false;
            }
        }
        else if (action instanceof DrawDestinationCardAction) {
            if(mainState.getTrackModeSelected()){
                return false;
            }
            else if(mainState.getTrainCardsSelected()){
                mainState.setTrainCardsSelected(false);
                mainState.setOnlyDownDeck(false);
                mainState.getFaceDownTrainCards().setHighlight(false);
                for(int i = 0; i < mainState.getFaceUpTrainCards().size(); i++){
                    mainState.getFaceUpTrainCards().getCards().get(i).setHighlight(false);
                }
                mainState.getDestinationCards().setHighlight(true);
                mainState.setDestinationCardsSelected(true);
            }
            else if(mainState.getDestinationCardsSelected()
                    && mainState.getDestinationCards().getHighlight()){
                mainState.getDestinationCards().setHighlight(false);
                mainState.setDestinationCardsSelected(false);
            }
            else{
                mainState.getDestinationCards().setHighlight(true);
                mainState.setDestinationCardsSelected(true);
            }
        }
        else if (action instanceof ChooseDestinationAction) {
            return true;
        }
        return true;
    }

    @Override
    public void start(GamePlayer[] players)
    {
        //Sets gameState's numPlayer and play order
        mainState.setNumPlayers(players.length);
//        Random rand = new Random();
//        rand.setSeed(System.currentTimeMillis());
//        mainState.setPlayerID(rand.nextInt(players.length));
        super.start(players);
    }
}
