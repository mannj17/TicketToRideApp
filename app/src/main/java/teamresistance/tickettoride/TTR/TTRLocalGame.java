package teamresistance.tickettoride.TTR;

import java.io.Serializable;

import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.Game.LocalGame;
import teamresistance.tickettoride.Game.actionMsg.GameAction;
import teamresistance.tickettoride.TTR.Actions.ChangeModeAction;
import teamresistance.tickettoride.TTR.Actions.ChooseDestinationAction;
import teamresistance.tickettoride.TTR.Actions.ConfirmSelectionAction;
import teamresistance.tickettoride.TTR.Actions.DrawDestinationCardAction;
import teamresistance.tickettoride.TTR.Actions.DrawDownCardAction;
import teamresistance.tickettoride.TTR.Actions.DrawUpCardAction;
import teamresistance.tickettoride.TTR.Actions.TrackPlaceAction;

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
public class TTRLocalGame extends LocalGame implements Serializable {
    private static final long serialVersionUID = 388111564192016L;
    //instance variables for the TTRLocalGame
    private TTRGameState mainState; //reference to the game state
    private boolean noMoreTrains; //boolean to indicate the start of a game over
    private int turnsLeft; //number of turns left in the game when a game over state is initiated.
    private int topScorePlayer = 0; //position in the array of players of the player with
                                    //the highest score
    private int numStarted;
    private String currentTrackColor = null; //the track color of the currently chosen track.
    private boolean okayMove;

    /**
     * TTRLocalGame constructor
     */
    public TTRLocalGame() {
        mainState = new TTRGameState();
        noMoreTrains = false;
        turnsLeft = 0;
        okayMove = false;
        numStarted = 0;
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
        //if the criteria for a start of the game over is met, set up the number
        //of turns left.
        for (int i = 0; i < mainState.getTrainTokens().length; i++) {
            if (mainState.getTrainTokens()[i] <= 2 && !mainState.getIsLastRound()) {
                noMoreTrains = true;
                mainState.setIsLastRound(true);
                turnsLeft = mainState.getNumPlayers();
            }
        }
        //if the start of a game over has been initiated, reduce the number of turns.

        //if the final turns are over, find and announce the winner
        if (turnsLeft == 0 && noMoreTrains) {
            /* If final turn over do final turn scoring */

            for (int j = 0; j < mainState.getScores().length; j++) {
                if (mainState.getScores()[j] > mainState.getScores()[topScorePlayer]) {
                    topScorePlayer = j;
                }
            }
            if(topScorePlayer != 0){
                return("" + this.playerNames[topScorePlayer] + "Wins");
            }
            else {
                return ("You're Winner!!!");
            }
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
        //changes the mode of the game if a check box is pressed.
        if (action instanceof ChangeModeAction) {
            //If draw cards is the selected mode, de-highlight all of the tracks on the board
            //and set the necessary booleans
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

            //if track mode is the selected mode, de-highlight all selected cards
            //and set the necessary booleans
            } else if (mainState.getTrackModeSelected()) {
                mainState.setCardModeSelected(true);
                mainState.setTrackModeSelected(false);
                for(int i = 0; i < mainState.getTracks().length; i++){
                    mainState.getTracks()[i].setSelected(false);
                }
            }
            okayMove = true;
            //return true;

        //If ConfirmSelectionAction is thrown, perform one of these changes to the game state.
        } else if (action instanceof ConfirmSelectionAction) {

            if(mainState.getTrainCardsSelected() ||
               mainState.getPlaceTrainSelected() ||
               mainState.getDestinationCardsSelected() ||
               !mainState.getGameStart()){
                //if the player has chosen some train cards from the face up or face down, move
                //them into their train card hand.
                if (mainState.getTrainCardsSelected()) {
                    int numFaceDown = 0;
                    if (mainState.getFaceDownTrainCards().getHighlight()) {
                        if (mainState.getOnlyDownDeck()) {
                            numFaceDown = 2;
                        } else {
                            numFaceDown = 1;
                        }
                    }

                    for (int i = 0; i < numFaceDown; i++) {
                        mainState.getFaceDownTrainCards().moveTopCardTo(
                                mainState.getPlayerTrainDecks()[mainState.getPlayerID()],
                                mainState.getFaceDownTrainCards());
                    }

                    mainState.getFaceDownTrainCards().setHighlight(false);
                    mainState.setOnlyDownDeck(false);

                    for (int i = mainState.getFaceUpTrainCards().size() - 1; i >= 0; i--) {
                        if (mainState.getFaceUpTrainCards().getCards().get(i).getHighlight()) {
                            mainState.getPlayerTrainDecks()[mainState.getPlayerID()].moveCardTo(
                                    mainState.getPlayerTrainDecks()[mainState.getPlayerID()],
                                    mainState.getFaceUpTrainCards(), i);
                        }
                    }
                    if(mainState.getTrainColorCount("Rainbow", -1) >=3){
                        for(int i = 0; i < mainState.getFaceUpTrainCards().size(); i++){
                            mainState.getFaceUpTrainCards().getCards().remove(i);
                            mainState.getFaceDownTrainCards().moveTopCardTo(
                                    mainState.getFaceUpTrainCards(), mainState.getFaceDownTrainCards());
                            mainState.getFaceUpTrainCards().getCards().get(i).setHighlight(false);
                        }
                    }
                    while(mainState.getFaceUpTrainCards().getCards().size() < 5){
                        mainState.getFaceDownTrainCards().moveTopCardTo(
                                mainState.getFaceUpTrainCards(), mainState.getFaceDownTrainCards());
                    }
                    //resets the state of selected cards
                    mainState.setTrainCardsSelected(false);
                }

                //if the player chose to get destination cards, get the deck sent by the action that
                //holds the cards to be moved to the player's hand.
                else if (((ConfirmSelectionAction) action).getSendDeck() != null
                        && ((ConfirmSelectionAction) action).getRemoveDeck() != null) {
                    //checks to see if the destination deck is running low
                    if(mainState.getDestinationCards().size() <= 2)
                    {
                        int k = mainState.getDestinationCards().size();
                        while(k > 0)
                        {
                            //adds leftover cards to discard
                            mainState.getDestinationDiscard().getCards().add(
                                    mainState.getDestinationCards().getCards().get(k));
                            //removes cards from deck
                            mainState.getDestinationCards().getCards().remove(k);
                            k--;
                        }
                        mainState.getDestinationDiscard().shuffle();
                        for(int m=0; m < mainState.getDestinationDiscard().size();m++)
                        {
                            //adds discard into the destination deck
                            mainState.getDestinationCards().getCards().add(
                                    mainState.getDestinationDiscard().getCards().get(m));
                            mainState.getDestinationDiscard().getCards().remove(m);

                        }
                    }
                    for (int i = 0; i < ((ConfirmSelectionAction) action).getSendDeck().size(); i++) {
                        Card tempCard = ((ConfirmSelectionAction) action).getSendDeck().getCards().get(i);
                        mainState.getPlayerDestinationDecks()[mainState.getPlayerID()].getCards().add(tempCard);
                    }
                    for (int i = 0; i < ((ConfirmSelectionAction) action).getRemoveDeck().size(); i++) {
                        mainState.getDestinationCards().getCards().remove(
                                ((ConfirmSelectionAction) action).getRemoveDeck().getCards().get(i));
                    }

                        if(numStarted == players.length-1){ mainState.setGameStart(true);}
                        else{ numStarted++; }
                    mainState.setDestinationCardsSelected(false);
                    mainState.getDestinationCards().setHighlight(false);
                }
                //if the player selected some tracks on the map, enter this if statement
                else if (mainState.getTrackModeSelected()) {

                    //run through the track array and find the track that was selected.
                    for (int i = 0; i < mainState.getTracks().length; i++) {

                        //if the track selected was not Gray, run through the player's hand to find
                        //and remove the cards that share the same color as the track
                        if (mainState.getTracks()[i].getSelected() && !mainState.getTracks()[i].getTrackColor().equals("Gray")) {

                            //cover the track and assign the player's number to the track
                            mainState.getTracks()[i].setCovered(true);
                            mainState.getTracks()[i].setPlayerID(mainState.getPlayerID());
                            mainState.getTracks()[i].setSelected(false);

                            //the length of the track
                            int count = mainState.getTracks()[i].getTrainTrackNum();

                            //if the action says that the player wanted to use rainbow cards, set the
                            //use rainbow state to true.
                            if (((ConfirmSelectionAction) action).getUseRainbow() != 0) {
                                mainState.setUseRainbow(true);
                            }

                            //if the player chose to use rainbow cards, remove the corresponding cards
                            //from their hand and reduce the count for the number of cards used to get
                            //the track.
                            if (((ConfirmSelectionAction) action).getUseRainbow() != 0) {
                                int numRainbows = ((ConfirmSelectionAction) action).getUseRainbow();
                                for (int j = 0; j < mainState.getPlayerTrainDecks()[mainState.getPlayerID()].size(); j++) {
                                    String cardColor = mainState.getPlayerTrainDecks()[mainState.getPlayerID()]
                                            .getCards().get(j).toString();
                                    if (cardColor.equals("Rainbow") && numRainbows != 0 && count != 0) {
                                        mainState.getPlayerTrainDecks()[mainState.getPlayerID()].moveCardTo(
                                                mainState.getTrainDiscard(),
                                                mainState.getPlayerTrainDecks()[mainState.getPlayerID()], j);
                                        count--;
                                        numRainbows--;
                                    }
                                }

                                //reset the state of useRainbow
                                mainState.setUseRainbow(false);
                            }

                            //remove the correct number of cards that match the color of the track. Once
                            //one card is removed, the count is reduced, which indicates how many more
                            //cards need to be removed.
                            for (int j = 0; j < mainState.getPlayerTrainDecks()[mainState.getPlayerID()].size(); j++) {
                                String trackColor = mainState.getTracks()[i].getTrackColor();
                                String cardColor = mainState.getPlayerTrainDecks()[mainState.getPlayerID()]
                                        .getCards().get(j).toString();
                                if (trackColor.equals(cardColor) && count != 0) {
                                    mainState.getPlayerTrainDecks()[mainState.getPlayerID()].moveCardTo(
                                            mainState.getTrainDiscard(),
                                            mainState.getPlayerTrainDecks()[mainState.getPlayerID()], j);
                                    j =0;
                                    //mainState.getPlayerTrainDecks()[mainState.getPlayerID()].getCards().remove(j);
                                    count--;
                                }
                            }

                            //ensure that the track is covered.
                            mainState.getTracks()[i].setCovered(true);
                            int num = mainState.getTracks()[i].getTrainTrackNum();
                            mainState.getTracks()[i].setPlayerID(mainState.getPlayerID());
                            mainState.getTracks()[i].setSelected(false);

                            //depending on the size of the track, assign the correct number of points
                            //to the player.
                            switch (num) {
                                case 1:
                                    mainState.setScore(mainState.getScores()[mainState.getPlayerID()] + 1, mainState.getPlayerID());
                                    mainState.setTrainToken(mainState.getTrainTokens()[mainState.getPlayerID()] - 1, mainState.getPlayerID());
                                    break;
                                case 2:
                                    mainState.setScore(mainState.getScores()[mainState.getPlayerID()] + 2, mainState.getPlayerID());
                                    mainState.setTrainToken(mainState.getTrainTokens()[mainState.getPlayerID()] - 2, mainState.getPlayerID());
                                    break;
                                case 3:
                                    mainState.setScore(mainState.getScores()[mainState.getPlayerID()] + 4, mainState.getPlayerID());
                                    mainState.setTrainToken(mainState.getTrainTokens()[mainState.getPlayerID()] - 3, mainState.getPlayerID());
                                    break;
                                case 4:
                                    mainState.setScore(mainState.getScores()[mainState.getPlayerID()] + 7, mainState.getPlayerID());
                                    mainState.setTrainToken(mainState.getTrainTokens()[mainState.getPlayerID()] - 4, mainState.getPlayerID());
                                    break;
                                case 5:
                                    mainState.setScore(mainState.getScores()[mainState.getPlayerID()] + 10, mainState.getPlayerID());
                                    mainState.setTrainToken(mainState.getTrainTokens()[mainState.getPlayerID()] - 5, mainState.getPlayerID());
                                    break;
                                case 6:
                                    mainState.setScore(mainState.getScores()[mainState.getPlayerID()] + 15, mainState.getPlayerID());
                                    mainState.setTrainToken(mainState.getTrainTokens()[mainState.getPlayerID()] - 6, mainState.getPlayerID());
                                    break;
                            }
                        }

                        //if the color of the track is Gray, remove the cards of the chosen card colors
                        //until enough have been removed.
                        else if (mainState.getTracks()[i].getSelected() && mainState.getTracks()[i].getTrackColor().equals("Gray")) {

                            //holder for the length of the track to indicate how many cards are needed
                            int count = mainState.getTracks()[i].getTrainTrackNum();

                            //if the player chose to use rainbow cards, remove the corresponding cards
                            //from their hand and reduce the count for the number of cards used to get
                            //the track.
                            if (((ConfirmSelectionAction) action).getUseRainbow() != 0) {
                                mainState.setUseRainbow(true);
                                int takeRainbows = ((ConfirmSelectionAction) action).getUseRainbow();
                                for (int j = 0; j < mainState.getPlayerTrainDecks()[mainState.getPlayerID()].size(); j++) {
                                    String cardColor = mainState.getPlayerTrainDecks()[mainState.getPlayerID()]
                                            .getCards().get(j).toString();
                                    if (cardColor.equals("Rainbow") && count != 0 && takeRainbows != 0) {
                                        mainState.getPlayerTrainDecks()[mainState.getPlayerID()].moveCardTo(
                                                mainState.getTrainDiscard(),
                                                mainState.getPlayerTrainDecks()[mainState.getPlayerID()], j);
                                        count--;
                                        takeRainbows--;
                                    }
                                }
                                mainState.setUseRainbow(false);
                            }

                            //remove the correct number of cards that match the color of the track. Once
                            //one card is removed, the count is reduced, which indicates how many more
                            //cards need to be removed.
                            if (((ConfirmSelectionAction) action).getChosenColor() != null) {
                                for (int j = 0; j < mainState.getPlayerTrainDecks()[mainState.getPlayerID()].size(); j++) {
                                    String trackColor = ((ConfirmSelectionAction) action).getChosenColor();
                                    String cardColor = mainState.getPlayerTrainDecks()[mainState.getPlayerID()]
                                            .getCards().get(j).toString();
                                    if (trackColor.equals(cardColor) && count != 0) {
                                        mainState.getPlayerTrainDecks()[mainState.getPlayerID()].moveCardTo(
                                                mainState.getTrainDiscard(),
                                                mainState.getPlayerTrainDecks()[mainState.getPlayerID()],j);
                                        //mainState.getPlayerTrainDecks()[mainState.getPlayerID()].getCards().remove(j);
                                        count--;
                                    }
                                }
                            }

                            //ensure the track that was selected is covered and assigned a player.
                            mainState.getTracks()[i].setCovered(true);
                            int num = mainState.getTracks()[i].getTrainTrackNum();
                            mainState.getTracks()[i].setPlayerID(mainState.getPlayerID());
                            mainState.getTracks()[i].setSelected(false);

                            //depending on the size of the track, assign the correct number of points
                            //to the player.
                            switch (num) {
                                case 1:
                                    mainState.setScore(mainState.getScores()[mainState.getPlayerID()] + 1, mainState.getPlayerID());
                                    mainState.setTrainToken(mainState.getTrainTokens()[mainState.getPlayerID()] - 1, mainState.getPlayerID());
                                    break;
                                case 2:
                                    mainState.setScore(mainState.getScores()[mainState.getPlayerID()] + 2, mainState.getPlayerID());
                                    mainState.setTrainToken(mainState.getTrainTokens()[mainState.getPlayerID()] - 2, mainState.getPlayerID());
                                    break;
                                case 3:
                                    mainState.setScore(mainState.getScores()[mainState.getPlayerID()] + 4, mainState.getPlayerID());
                                    mainState.setTrainToken(mainState.getTrainTokens()[mainState.getPlayerID()] - 3, mainState.getPlayerID());
                                    break;
                                case 4:
                                    mainState.setScore(mainState.getScores()[mainState.getPlayerID()] + 7, mainState.getPlayerID());
                                    mainState.setTrainToken(mainState.getTrainTokens()[mainState.getPlayerID()] - 4, mainState.getPlayerID());
                                    break;
                                case 5:
                                    mainState.setScore(mainState.getScores()[mainState.getPlayerID()] + 10, mainState.getPlayerID());
                                    mainState.setTrainToken(mainState.getTrainTokens()[mainState.getPlayerID()] - 5, mainState.getPlayerID());
                                    break;
                                case 6:
                                    mainState.setScore(mainState.getScores()[mainState.getPlayerID()] + 15, mainState.getPlayerID());
                                    mainState.setTrainToken(mainState.getTrainTokens()[mainState.getPlayerID()] - 6, mainState.getPlayerID());
                                    break;
                            }

                        }
                    }

                    //reset the state of the modes in the game state.
                    mainState.setTrackModeSelected(false);
                    mainState.setPlaceTrainSelected(false);
                }

                //reset the mode of the game state so that card mode is selected and track mode is not.
                mainState.setCardModeSelected(true);
                mainState.setTrackModeSelected(false);
                mainState.setPlayerID((mainState.getPlayerID() + 1) % mainState.getNumPlayers());

                if (noMoreTrains) {
                    turnsLeft--;
                }

                //deselect all of the games tracks.
                for (int i = 0; i < mainState.getTracks().length; i++) {
                    mainState.getTracks()[i].setSelected(false);
                    mainState.getTracks()[i].setHighlight(false);
                }

                if(mainState.getTrainColorCount("Rainbow", -1) >=3){
                    while(!mainState.getFaceUpTrainCards().getCards().isEmpty()){
                        mainState.getFaceUpTrainCards().getCards().remove(0);
                    }
                    for(int i = 0; i < 5; i++){
                        mainState.getFaceDownTrainCards().moveTopCardTo(
                                mainState.getFaceUpTrainCards(), mainState.getFaceDownTrainCards());
                        mainState.getFaceUpTrainCards().getCards().get(i).setHighlight(false);
                    }
                }

                mainState.reset = true;
                return true;
            }

        }

        //if the player wants to select a track enter this if statement.
        else if (action instanceof TrackPlaceAction) {

            //if the card mode is enabled, return false, saying that the current mode is not legal
            //for selecting tracks.
            if (mainState.getCardModeSelected()) {
                return false;
            }

            //this boolean is used to indicate if a track has already been selected
            boolean alreadySelected = false;

            //if a player has already selected a track change alreadySelected.
                for (int i = 0; i < mainState.getTracks().length; i++) {
                    if (mainState.getTracks()[i].getSelected()) {
                        alreadySelected = true;
                        currentTrackColor = mainState.getTracks()[i].toString();
                        mainState.setTrackSpot(i);
                    }
                }

            //once the selected track has been found, change the necessary variables in the game state.
                TrackPlaceAction temp = (TrackPlaceAction) action;
                int index = temp.getIndex();
                if(action.getPlayer() instanceof TTRHumanPlayer) {
                    if (mainState.getTracks()[index].getHighlight() &&
                            !mainState.getTracks()[index].getSelected() && !alreadySelected) {
                        mainState.getTracks()[index].setSelected(true);
                        mainState.setPlaceTrainSelected(true);
                        mainState.setSelectedCardColor(temp.getTrackColor());
                        mainState.setTrackSpot(index);
                    }

                    //if a track has already been selected, set it's selected variable to false.
                    else {
                        mainState.getTracks()[index].setSelected(false);
                        mainState.setPlaceTrainSelected(false);
                        mainState.setSelectedCardColor("");
                    }
                }
                else if(action.getPlayer() instanceof TTRComputerPlayer){
                    mainState.getTracks()[index].setSelected(true);
                    mainState.setPlaceTrainSelected(true);
                    mainState.setSelectedCardColor(temp.getTrackColor());
                    mainState.setTrackSpot(index);
                }
            okayMove = true;
            //return true;
            }

        //if the action is for choosing face up cards, enter this if statement.
            else if (action instanceof DrawUpCardAction) {

            //if the mode is track mode, return false so no cards will be highlighted.
            if (mainState.getTrackModeSelected()) {
                return false;
            }

            //if the destination cards were already highlighted, de-highlight them.
            else if (mainState.getDestinationCardsSelected()) {
                mainState.getDestinationCards().setHighlight(false);
                mainState.setDestinationCardsSelected(false);
            }

            //find out how many cards or decks are already highlighted.
            DrawUpCardAction temp = (DrawUpCardAction) action;
            int pos = temp.getPos();
            int numHighlights = 0;
            for (int i = 0; i < mainState.getFaceUpTrainCards().size(); i++) {
                if (mainState.getFaceUpTrainCards().getCards().get(i).getHighlight()) {
                    //if a rainbow card was selected, numHighlights is automatically set to 2.
                    //Otherwise, it's one.
                    if (mainState.getFaceUpTrainCards().getCards().get(i).toString().equals("Rainbow")) {
                        numHighlights = numHighlights + 2;
                    } else {
                        numHighlights++;
                        mainState.setOnlyDownDeck(false);
                        mainState.setTrainCardsSelected(true);
                    }
                }
            }

            //if the face down deck has been selected add to numHighlights.
            if (mainState.getFaceDownTrainCards().getHighlight()) {
                numHighlights++;
                mainState.setTrainCardsSelected(true);
            }

            //if numHighlights is less than 2 highlight the card if its a legal move
            if (numHighlights < 2) {

                //only highlight a rainbow card if it's the only one.
                if (mainState.getFaceUpTrainCards().getCards().get(pos).toString().equals("Rainbow")) {
                    if (numHighlights == 0) {
                        mainState.getFaceUpTrainCards().getCards().get(pos).setHighlight(true);
                        mainState.setTrainCardsSelected(true);
                    } else {
                        mainState.getFaceUpTrainCards().getCards().get(pos).setHighlight(false);
                    }
                }

                //if its already been highlighted, de-highlight it.
                else if (mainState.getFaceUpTrainCards().getCards().get(pos).getHighlight()) {
                    mainState.getFaceUpTrainCards().getCards().get(pos).setHighlight(false);
                    mainState.setTrainCardsSelected(false);
                }

                //Otherwise, highlight the card
                else {
                    mainState.getFaceUpTrainCards().getCards().get(pos).setHighlight(true);
                    mainState.setTrainCardsSelected(true);
                }
            }
            //if the maximum number of cards are highlighted, don't let the card be highlighted.
            else if (mainState.getFaceUpTrainCards().getCards().get(pos).getHighlight()) {
                mainState.getFaceUpTrainCards().getCards().get(pos).setHighlight(false);
                mainState.setTrainCardsSelected(true);
            }
            okayMove = true;
            //return true;
        }

        //if the down deck was selected, enter this if statement.
        else if (action instanceof DrawDownCardAction) {

            //leave if in track mode.
            if (mainState.getTrackModeSelected()) {
                return false;
            }

            //de-highlight destination card deck.
            else if (mainState.getDestinationCardsSelected()) {
                mainState.getDestinationCards().setHighlight(false);
                mainState.setDestinationCardsSelected(false);
            }

            //set the correct boolean values depending on only if the down deck was selected.
            else if (mainState.getTrainCardsSelected() &&
                    mainState.getFaceDownTrainCards().getHighlight()) {
                if (mainState.getOnlyDownDeck()) {
                    mainState.setTrainCardsSelected(false);
                }
                mainState.setOnlyDownDeck(false);
                mainState.getFaceDownTrainCards().setHighlight(false);
            }

            //if cards have already been selected and the face down deck has not
            else if (mainState.getTrainCardsSelected()
                    && !mainState.getFaceDownTrainCards().getHighlight()) {
                int highlightNum = 0;

                //count how many cards have been highlighted
                for (int i = 0; i < mainState.getFaceUpTrainCards().size(); i++) {
                    if (mainState.getFaceUpTrainCards().getCards().get(i).getHighlight()) {

                        //rainbow cards are equal to two highlights
                        if (mainState.getFaceUpTrainCards().getCards().get(i).toString().equals("Rainbow")) {
                            highlightNum = highlightNum + 2;
                        }

                        //other cards are equal to one highlight
                        else {
                            highlightNum++;
                            mainState.setOnlyDownDeck(false);
                            mainState.setTrainCardsSelected(true);
                        }
                    }
                }

                //if less than two highlights are available, highlight the deck.
                if (highlightNum < 2) {
                    mainState.getFaceDownTrainCards().setHighlight(true);
                }
                mainState.setOnlyDownDeck(false);
            }

            //if no cards have been selected set onlyDownDeck
            else if (!mainState.getTrainCardsSelected() && !mainState.getOnlyDownDeck()) {
                mainState.setOnlyDownDeck(true);
                mainState.setTrainCardsSelected(true);
                mainState.getFaceDownTrainCards().setHighlight(true);
            }
            else {
                return false;
            }
        }

        //if the player wants to get destination cards
        else if (action instanceof DrawDestinationCardAction) {

            //ensure they aren't in track mode
            if (mainState.getTrackModeSelected()) {
                return false;
            }

            //de-highlight any highlighted train cards
            else if (mainState.getTrainCardsSelected()) {
                mainState.setTrainCardsSelected(false);
                mainState.setOnlyDownDeck(false);
                mainState.getFaceDownTrainCards().setHighlight(false);
                for (int i = 0; i < mainState.getFaceUpTrainCards().size(); i++) {
                    mainState.getFaceUpTrainCards().getCards().get(i).setHighlight(false);
                }
                mainState.getDestinationCards().setHighlight(true);
                mainState.setDestinationCardsSelected(true);
            }

            //if destination deck wasn't selected already, highlight it, otherwise,
            //de-highlight it.
            else if (mainState.getDestinationCardsSelected()
                    && mainState.getDestinationCards().getHighlight()) {
                mainState.getDestinationCards().setHighlight(false);
                mainState.setDestinationCardsSelected(false);
            } else {
                mainState.getDestinationCards().setHighlight(true);
                mainState.setDestinationCardsSelected(true);
            }
        } else if (action instanceof ChooseDestinationAction) {
            okayMove = true;
            //return true;
        }
//        if(okayMove){
//            okayMove = false;
            return true;
//        }
//        else {
//            return false;
//        }
    }

    /**
     * Sets the players in the game state
     * @param players
     */
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
