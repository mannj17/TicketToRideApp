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
    private String currentTrackColor = null;

    /**
     * TTRLocalGame constructor
     */
    public TTRLocalGame() {
        mainState = new TTRGameState();
        noMoreTrains = false;
        turnsLeft = mainState.getNumPlayers();
    }

    /**
     * Sends updated game state
     *
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
        for (int i = 0; i < mainState.getTrainTokens().length; i++) {
            if (mainState.getTrainTokens()[i] <= 2) {
                noMoreTrains = true;
            }
        }
        if (noMoreTrains) {
            turnsLeft--;
        }
        if (turnsLeft == 0) {
            for (int j = 0; j < mainState.getScores().length; j++) {
                if (mainState.getScores()[j] > mainState.getScores()[topScorePlayer]) {
                    topScorePlayer = j;
                }
            }
            return ("Player Wins");
        }
        return null;
    }


    /**
     * Returns if the player made a move
     *
     * @param action The move that the player has sent to the game
     * @return
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof ChangeModeAction) {
            if (mainState.getCardModeSelected()) {
                mainState.setCardModeSelected(false);
                mainState.setTrackModeSelected(true);
                mainState.getFaceDownTrainCards().setHighlight(false);
                mainState.getDestinationCards().setHighlight(false);
                mainState.setDestinationCardsSelected(false);
                mainState.setTrainCardsSelected(false);
                for (int i = 0; i < mainState.getFaceUpTrainCards().size(); i++) {
                    mainState.getFaceUpTrainCards().getCards().get(i).setHighlight(false);
                }
            } else if (mainState.getTrackModeSelected()) {
                mainState.setCardModeSelected(true);
                mainState.setTrackModeSelected(false);
                for(int i = 0; i < mainState.getTracks().length; i++){
                    mainState.getTracks()[i].setSelected(false);
                }
            }
            return true;
        } else if (action instanceof ConfirmSelectionAction) {
            if (mainState.getTrainCardsSelected()) {
                if (mainState.getOnlyDownDeck() && mainState.getFaceDownTrainCards().getHighlight()) {
                    mainState.getFaceDownTrainCards().moveTopCardTo(
                            mainState.getPlayerTrainDecks()[mainState.getPlayerID()],
                            mainState.getFaceDownTrainCards());
                    mainState.getFaceDownTrainCards().moveTopCardTo(
                            mainState.getPlayerTrainDecks()[mainState.getPlayerID()],
                            mainState.getFaceDownTrainCards());
                    mainState.getFaceDownTrainCards().setHighlight(false);
                    mainState.setOnlyDownDeck(false);
                } else if (!mainState.getOnlyDownDeck() && mainState.getFaceDownTrainCards().getHighlight()) {
                    mainState.getFaceDownTrainCards().moveTopCardTo(
                            mainState.getPlayerTrainDecks()[mainState.getPlayerID()],
                            mainState.getFaceDownTrainCards());
                    for (int i = 0; i < mainState.getFaceUpTrainCards().size(); i++) {
                        if (mainState.getFaceUpTrainCards().getCards().get(i).getHighlight()) {
                            Card temp = mainState.getFaceUpTrainCards().getCards().get(i);
                            mainState.getPlayerTrainDecks()[mainState.getPlayerID()].add(temp);
                            mainState.getFaceUpTrainCards().getCards().remove(i);
                            mainState.getFaceDownTrainCards().moveTopCardTo(
                                    mainState.getFaceUpTrainCards(), mainState.getFaceDownTrainCards());
                            mainState.getFaceUpTrainCards().getCards().get(i).setHighlight(false);
                        }
                    }
                    mainState.getFaceDownTrainCards().setHighlight(false);
                } else if (!mainState.getOnlyDownDeck() && !mainState.getFaceDownTrainCards().getHighlight()) {
                    for (int i = mainState.getFaceUpTrainCards().size() - 1; i >= 0; i--) {
                        if (mainState.getFaceUpTrainCards().getCards().get(i).getHighlight()) {
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
            } else if (mainState.getDestinationCardsSelected()) {
                mainState.setIsSelectDestinationCards(true);
               /** for (int i = 0; i < 3; i++) {
                    mainState.getFaceDownTrainCards().moveTopCardTo(
                            mainState.getDestinationCards(),
                            mainState.getDestinationPool());
                }*/

                 Deck tempDeck = new Deck("temp");
                 mainState.getDestinationCards().moveTopCardTo(tempDeck, mainState.getDestinationCards());
                 mainState.getDestinationCards().moveTopCardTo(tempDeck, mainState.getDestinationCards());
                 mainState.getDestinationCards().moveTopCardTo(tempDeck, mainState.getDestinationCards());

                if(action.getPlayer() instanceof TTRHumanPlayer){
                    ((TTRHumanPlayer)action.getPlayer()).displayDestinationPopup(tempDeck);
                }

            } else if (mainState.getTrackModeSelected()) {
                for (int i = 0; i < mainState.getTracks().length; i++) {
                    if (mainState.getTracks()[i].getSelected() && !mainState.getTracks()[i].getTrackColor().equals("Gray")) {
                        mainState.getTracks()[i].setCovered(true);
                        mainState.getTracks()[i].setPlayerID(mainState.getPlayerID());
                        mainState.getTracks()[i].setSelected(false);
                        int count = mainState.getTracks()[i].getTrainTrackNum();
                        if(mainState.getUseRainbow()){
                            for(int j =0; j < mainState.getPlayerTrainDecks()[mainState.getPlayerID()].size(); j++){
                                String cardColor = mainState.getPlayerTrainDecks()[mainState.getPlayerID()]
                                        .getCards().get(j).toString();
                                if(cardColor.equals("Rainbow")){
                                    mainState.getPlayerTrainDecks()[mainState.getPlayerID()].getCards().remove(j);
                                    count--;
                                }
                            }
                            mainState.setUseRainbow(false);
                        }
                        for(int j = 0; j < mainState.getPlayerTrainDecks()[mainState.getPlayerID()].size(); j++){
                            String trackColor = mainState.getTracks()[i].getTrackColor();
                            String cardColor = mainState.getPlayerTrainDecks()[mainState.getPlayerID()]
                                    .getCards().get(j).toString();
                            if(trackColor.equals(cardColor) && count != 0){
                                mainState.getPlayerTrainDecks()[mainState.getPlayerID()].getCards().remove(j);
                                count--;
                            }
                        }
                    }
                    else if(mainState.getTracks()[i].getSelected() && mainState.getTracks()[i].getTrackColor().equals("Gray")){
                        if(action.getPlayer() instanceof TTRHumanPlayer){
                            ((TTRHumanPlayer)action.getPlayer()).displayCardSelectionPopup(
                                    mainState.getPlayerTrainDecks()[mainState.getPlayerID()], mainState.getTracks()[i]);
                        }
                        mainState.getTracks()[i].setCovered(true);
                        mainState.getTracks()[i].setPlayerID(mainState.getPlayerID());
                        mainState.getTracks()[i].setSelected(false);
                        int count = mainState.getTracks()[i].getTrainTrackNum();
                        if(mainState.getUseRainbow()){
                            for(int j =0; j < mainState.getPlayerTrainDecks()[mainState.getPlayerID()].size(); j++){
                                String cardColor = mainState.getPlayerTrainDecks()[mainState.getPlayerID()]
                                        .getCards().get(j).toString();
                                if(cardColor.equals("Rainbow")){
                                    mainState.getPlayerTrainDecks()[mainState.getPlayerID()].getCards().remove(j);
                                    count--;
                                }
                            }
                            mainState.setUseRainbow(false);
                        }
                        for(int j = 0; j < mainState.getPlayerTrainDecks()[mainState.getPlayerID()].size(); j++){
                            String trackColor = mainState.getSelectedCardColor();
                            String cardColor = mainState.getPlayerTrainDecks()[mainState.getPlayerID()]
                                    .getCards().get(j).toString();
                            if(trackColor.equals(cardColor) && count != 0){
                                mainState.getPlayerTrainDecks()[mainState.getPlayerID()].getCards().remove(j);
                                count--;
                            }
                        }
                    }
                }
                mainState.setTrackModeSelected(false);
                mainState.setPlaceTrainSelected(false);
            }
            mainState.setCardModeSelected(true);
            mainState.setTrackModeSelected(false);
            mainState.setPlayerID((mainState.getPlayerID() + 1) % mainState.getNumPlayers());
            for(int i = 0; i < mainState.getTracks().length; i++){
                mainState.getTracks()[i].setSelected(false);
            }
            return true;
        } else if (action instanceof TrackPlaceAction) {
            if (mainState.getCardModeSelected()) {
                return false;
            }
            boolean alreadySelected = false;
                for (int i = 0; i < mainState.getTracks().length; i++) {
                    if (mainState.getTracks()[i].getSelected()) {
                        alreadySelected = true;
                        currentTrackColor = mainState.getTracks()[i].toString();
                    }
                }
                TrackPlaceAction temp = (TrackPlaceAction) action;
                int index = temp.getIndex();
                if (mainState.getTracks()[index].getHighlight() &&
                        !mainState.getTracks()[index].getSelected() && !alreadySelected) {
                    mainState.getTracks()[index].setSelected(true);
                    mainState.setPlaceTrainSelected(true);
                    mainState.setSelectedCardColor(temp.getTrackColor());
                    mainState.setUseRainbow(mainState.getTrainColorCount("Rainbow", mainState.getPlayerID()) != 0);
                } else {
                    mainState.getTracks()[index].setSelected(false);
                    mainState.setPlaceTrainSelected(false);
                    mainState.setSelectedCardColor("");
                    mainState.setUseRainbow(false);
                }
                return true;
            }
            else if (action instanceof DrawUpCardAction) {
            if (mainState.getTrackModeSelected()) {
                return false;
            } else if (mainState.getDestinationCardsSelected()) {
                mainState.getDestinationCards().setHighlight(false);
                mainState.setDestinationCardsSelected(false);
            }
            DrawUpCardAction temp = (DrawUpCardAction) action;
            int pos = temp.getPos();
            int numHighlights = 0;
            for (int i = 0; i < mainState.getFaceUpTrainCards().size(); i++) {
                if (mainState.getFaceUpTrainCards().getCards().get(i).getHighlight()) {
                    if (mainState.getFaceUpTrainCards().getCards().get(i).toString().equals("Rainbow")) {
                        numHighlights = numHighlights + 2;
                    } else {
                        numHighlights++;
                        mainState.setOnlyDownDeck(false);
                        mainState.setTrainCardsSelected(true);
                    }
                }
            }
            if (mainState.getFaceDownTrainCards().getHighlight()) {
                numHighlights++;
                mainState.setTrainCardsSelected(true);
            }
            if (numHighlights < 2) {
                if (mainState.getFaceUpTrainCards().getCards().get(pos).toString().equals("Rainbow")) {
                    if (numHighlights == 0) {
                        mainState.getFaceUpTrainCards().getCards().get(pos).setHighlight(true);
                        mainState.setTrainCardsSelected(true);
                    } else {
                        mainState.getFaceUpTrainCards().getCards().get(pos).setHighlight(false);
                    }
                } else if (mainState.getFaceUpTrainCards().getCards().get(pos).getHighlight()) {
                    mainState.getFaceUpTrainCards().getCards().get(pos).setHighlight(false);
                    mainState.setTrainCardsSelected(false);
                } else {
                    mainState.getFaceUpTrainCards().getCards().get(pos).setHighlight(true);
                    mainState.setTrainCardsSelected(true);
                }
            } else if (mainState.getFaceUpTrainCards().getCards().get(pos).getHighlight()) {
                mainState.getFaceUpTrainCards().getCards().get(pos).setHighlight(false);
                mainState.setTrainCardsSelected(true);
            }
            return true;
        } else if (action instanceof DrawDownCardAction) {
            if (mainState.getTrackModeSelected()) {
                return false;
            } else if (mainState.getDestinationCardsSelected()) {
                mainState.getDestinationCards().setHighlight(false);
                mainState.setDestinationCardsSelected(false);
            } else if (mainState.getTrainCardsSelected() &&
                    mainState.getFaceDownTrainCards().getHighlight()) {
                if (mainState.getOnlyDownDeck()) {
                    mainState.setTrainCardsSelected(false);
                }
                mainState.setOnlyDownDeck(false);
                mainState.getFaceDownTrainCards().setHighlight(false);
            } else if (mainState.getTrainCardsSelected()
                    && !mainState.getFaceDownTrainCards().getHighlight()) {
                int highlightNum = 0;
                for (int i = 0; i < mainState.getFaceUpTrainCards().size(); i++) {
                    if (mainState.getFaceUpTrainCards().getCards().get(i).getHighlight()) {
                        if (mainState.getFaceUpTrainCards().getCards().get(i).toString().equals("Rainbow")) {
                            highlightNum = highlightNum + 2;
                        } else {
                            highlightNum++;
                            mainState.setOnlyDownDeck(false);
                            mainState.setTrainCardsSelected(true);
                        }
                    }
                }
                if (highlightNum < 2) {
                    mainState.getFaceDownTrainCards().setHighlight(true);
                }
                mainState.setOnlyDownDeck(false);
            } else if (!mainState.getTrainCardsSelected() && !mainState.getOnlyDownDeck()) {
                mainState.setOnlyDownDeck(true);
                mainState.setTrainCardsSelected(true);
                mainState.getFaceDownTrainCards().setHighlight(true);
            } else {
                return false;
            }
        } else if (action instanceof DrawDestinationCardAction) {
            if (mainState.getTrackModeSelected()) {
                return false;
            } else if (mainState.getTrainCardsSelected()) {
                mainState.setTrainCardsSelected(false);
                mainState.setOnlyDownDeck(false);
                mainState.getFaceDownTrainCards().setHighlight(false);
                for (int i = 0; i < mainState.getFaceUpTrainCards().size(); i++) {
                    mainState.getFaceUpTrainCards().getCards().get(i).setHighlight(false);
                }
                mainState.getDestinationCards().setHighlight(true);
                mainState.setDestinationCardsSelected(true);
            } else if (mainState.getDestinationCardsSelected()
                    && mainState.getDestinationCards().getHighlight()) {
                mainState.getDestinationCards().setHighlight(false);
                mainState.setDestinationCardsSelected(false);
            } else {
                mainState.getDestinationCards().setHighlight(true);
                mainState.setDestinationCardsSelected(true);
            }
        } else if (action instanceof ChooseDestinationAction) {
            return true;
        }
        return true;
    }

    @Override
    public void start(GamePlayer[] players) {
        //Sets gameState's numPlayer and play order
        mainState.setNumPlayers(players.length);
//        Random rand = new Random();
//        rand.setSeed(System.currentTimeMillis());
//        mainState.setPlayerID(rand.nextInt(players.length));
        super.start(players);
    }
}
