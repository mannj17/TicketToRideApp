package teamresistance.tickettoride.TTR;

import java.util.Random;

import teamresistance.tickettoride.Game.GameComputerPlayer;
import teamresistance.tickettoride.Game.infoMsg.GameInfo;
import teamresistance.tickettoride.Game.infoMsg.GameState;
import teamresistance.tickettoride.TTR.Actions.ChangeModeAction;
import teamresistance.tickettoride.TTR.Actions.ConfirmSelectionAction;
import teamresistance.tickettoride.TTR.Actions.DrawDownCardAction;
import teamresistance.tickettoride.TTR.Actions.DrawUpCardAction;
import teamresistance.tickettoride.TTR.Actions.TrackPlaceAction;

/**
 *  TTRComputerPlayer implements and AI player
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version April 2016
 */
public class TTRComputerPlayer extends GameComputerPlayer{
    /*
     * Sets up the ComputerPlayer and its difficulty
     * @name set by the human player at start
     * @difficulty used to set how hard the AI will be
     */
    public TTRComputerPlayer(String name, boolean difficulty) {
        super(name);
        isDifficult = difficulty;
        rand = new Random();
    }
    /*
     * Says if player is smart or dumb
     */
    private boolean isDifficult;
    //initializes the variables used by the computer player
    private Deck trainDeck;
    private Deck destinationDeck;
    private int score;
    private String name;
    private int trainTokens;
    private Boolean isTurn;

    //random variable
    private Random rand;

    //indicates which move to make
    private int makeMove;
    private boolean startedMove = false; //boolean that says if the move has started
    private boolean foundTrack = false; //if a track has been found


    /*
     * Finds the best move for the computer player and makes that move based on what it finds
     * @info
     */
    protected final void findBestMove(GameInfo info) {
    }

    /**
     * Computer player actions
     * @param info from game state
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if(info instanceof GameState){
            TTRGameState compState = (TTRGameState) info;

            //if it's the players turn
            if(compState.getPlayerID() == this.playerNum){
                this.sleep(1000);

                //if its the start of a turn, randomly choose its move type
                if(!startedMove){
                    makeMove = rand.nextInt(100);

                    //if makeMove is less than 50, put it in track mode
                    if(makeMove < 50){
                        game.sendAction(new ChangeModeAction(this));
                    }
                }

                //if it is card mode, select randomly between picking from the face up and
                //face down decks
                if(compState.getCardModeSelected()) {
                    if(makeMove< 50) {
                        startedMove = true;
                        int selectedCards = 0;
                        for (int i = 0; i < compState.getFaceUpTrainCards().size(); i++) {
                            if (compState.getFaceUpTrainCards().getCards().get(i).getHighlight()) {

                                //if the player randomly choose a rainbow card, take it right away
                                if (compState.getFaceUpTrainCards().getCards().get(i).toString().equals("Rainbow")) {
                                    selectedCards = 2;
                                } else {
                                    selectedCards++;
                                }
                            }

                            //if the player is taking from the down deck, increment selectedCards
                            //accordingly.
                            if (compState.getOnlyDownDeck()) {
                                selectedCards = 2;
                            } else if (compState.getFaceDownTrainCards().getHighlight()) {
                                selectedCards++;
                            }
                        }

                        //if two cards have not been selected, randomly choose a card.
                        if (selectedCards < 2) {
                            if (Math.random() < .75) {
                                game.sendAction(new DrawUpCardAction(this, rand.nextInt(5)));
                            } else {
                                if (!compState.getOnlyDownDeck()) {
                                    game.sendAction(new DrawDownCardAction(this));
                                }
                            }
                        } else {
                            startedMove = false;
                            game.sendAction(new ConfirmSelectionAction(this));
                        }
                    }

                    //only pull from the down deck
                    else{
                        startedMove = true;
                        if(!compState.getOnlyDownDeck()){
                            game.sendAction(new DrawDownCardAction(this));
                        }
                        else{
                            startedMove = false;
                            game.sendAction(new ConfirmSelectionAction(this));
                        }
                    }
                }

                //if in track mode
                else if(compState.getTrackModeSelected()){

                    //indicates the move has been started
                    startedMove = true;

                    //get the count of the computer players cards for each color.
                    int redCount= compState.getTrainColorCount("Red",this.playerNum);
                    int orangeCount= compState.getTrainColorCount("Orange",this.playerNum);
                    int yellowCount= compState.getTrainColorCount("Yellow",this.playerNum);
                    int greenCount= compState.getTrainColorCount("Green",this.playerNum);
                    int blueCount= compState.getTrainColorCount("Blue",this.playerNum);
                    int pinkCount= compState.getTrainColorCount("Pink",this.playerNum);
                    int whiteCount= compState.getTrainColorCount("White",this.playerNum);
                    int blackCount= compState.getTrainColorCount("Black",this.playerNum);
                    int rainbowCount= compState.getTrainColorCount("Rainbow",this.playerNum);

                    //if a track has not been found
                    if(!foundTrack) {
                        for (int i = 0; i < compState.getTracks().length; i++) {

                            //if a track has not been found
                            if (!compState.getTracks()[i].getCovered() && !foundTrack) {

                                //get the color of the track currently being looked at.
                                String trainColor = compState.getTracks()[i].getTrackColor();

                                //if the track is gray, check to see if the Computer Player has
                                //any combination of colored cards and rainbow cards to claim the track.
                                if (trainColor.equals("Gray")) {

                                    //check each colored card count + rainbow cards against the Gray
                                    //track. If a combination has been found, select that track.
                                    if (redCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        compState.setUseRainbow(true);
                                        foundTrack = true;
                                        compState.setSelectedCardColor("Red");
                                        game.sendAction(new TrackPlaceAction(this, "Red", i));
                                    } else if (orangeCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        compState.setUseRainbow(true);
                                        foundTrack = true;
                                        compState.setSelectedCardColor("Orange");
                                        game.sendAction(new TrackPlaceAction(this, "Orange", i));
                                    } else if (yellowCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        compState.setUseRainbow(true);
                                        foundTrack = true;
                                        compState.setSelectedCardColor("Yellow");
                                        game.sendAction(new TrackPlaceAction(this, "Yellow", i));
                                    } else if (greenCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        compState.setUseRainbow(true);
                                        foundTrack = true;
                                        compState.setSelectedCardColor("Green");
                                        game.sendAction(new TrackPlaceAction(this, "Green", i));
                                    } else if (blueCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        foundTrack = true;
                                        compState.setUseRainbow(true);
                                        compState.setSelectedCardColor("Blue");
                                        game.sendAction(new TrackPlaceAction(this, "Blue", i));
                                    } else if (pinkCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        foundTrack = true;
                                        compState.setUseRainbow(true);
                                        compState.setSelectedCardColor("Pink");
                                        game.sendAction(new TrackPlaceAction(this, "Pink", i));
                                    } else if (whiteCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        foundTrack = true;
                                        compState.setUseRainbow(true);
                                        compState.setSelectedCardColor("White");
                                        game.sendAction(new TrackPlaceAction(this, "White", i));
                                    } else if (blackCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        foundTrack = true;
                                        compState.setUseRainbow(true);
                                        compState.setSelectedCardColor("Black");
                                        game.sendAction(new TrackPlaceAction(this, "Black", i));
                                    }
                                }

                                /*
                                if the track is not Gray, go through these else if statements until
                                its color has been found. Once it has been found check to see if
                                the corresponding there are enough cards of the same color + rainbow
                                cards. If there are enough cards, select the track
                                 */
                                else if (trainColor.equals("Red")) {
                                    if (redCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        foundTrack = true;
                                        game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                    } else if (redCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        foundTrack = true;
                                        compState.setUseRainbow(true);
                                        game.sendAction(new TrackPlaceAction(this, trainColor, i));

                                    }
                                } else if (trainColor.equals("Orange")) {
                                    if (orangeCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        foundTrack = true;
                                        game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                    } else if (orangeCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        foundTrack = true;
                                        compState.setUseRainbow(true);
                                        game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                    }
                                } else if (trainColor.equals("Yellow")) {
                                    if (yellowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        foundTrack = true;
                                        game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                    } else if (yellowCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        foundTrack = true;
                                        compState.setUseRainbow(true);
                                        game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                    }
                                } else if (trainColor.equals("Green")) {
                                    if (greenCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        foundTrack = true;
                                        game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                    } else if (greenCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                        foundTrack = true;
                                        compState.setUseRainbow(true);
                                        game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                    } else if (trainColor.equals("Blue")) {
                                        if (blueCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                            foundTrack = true;
                                            game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                        } else if (blueCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                            foundTrack = true;
                                            compState.setUseRainbow(true);
                                            game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                        }
                                    } else if (trainColor.equals("Pink")) {
                                        if (pinkCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                            foundTrack = true;
                                            game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                        } else if (pinkCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                            foundTrack = true;
                                            compState.setUseRainbow(true);
                                            game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                        }
                                    } else if (trainColor.equals("White")) {
                                        if (whiteCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                            foundTrack = true;
                                            game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                        } else if (whiteCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                            foundTrack = true;
                                            compState.setUseRainbow(true);
                                            game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                        }
                                    } else if (trainColor.equals("Black")) {
                                        if (blackCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                            foundTrack = true;
                                            game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                        } else if (blackCount + rainbowCount >= compState.getTracks()[i].getTrainTrackNum()) {
                                            foundTrack = true;
                                            compState.setUseRainbow(true);
                                            game.sendAction(new TrackPlaceAction(this, trainColor, i));
                                        }
                                    }
                                }
                            }
                        }

                        //if a track was not found, set startedMove to false to indicate that
                        //a different move needs to be made.
                        if(!foundTrack){
                            startedMove = false;
                        }
                    }

                    //if a track was not found, change the mode of the game state
                    if (!startedMove) {
                        game.sendAction(new ChangeModeAction(this));
                    }

                    //if a track was found, reset the boolean values and send a confirmSelectionAction.
                    if(foundTrack){
                        startedMove = false;
                        foundTrack = false;
                        game.sendAction(new ConfirmSelectionAction(this));
                    }
                }
            }
        }
    }
}
