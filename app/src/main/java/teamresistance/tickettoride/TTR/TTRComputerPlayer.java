package teamresistance.tickettoride.TTR;

import java.util.Random;

import teamresistance.tickettoride.Game.GameComputerPlayer;
import teamresistance.tickettoride.Game.infoMsg.GameInfo;
import teamresistance.tickettoride.Game.infoMsg.GameState;
import teamresistance.tickettoride.TTR.Actions.ChangeModeAction;
import teamresistance.tickettoride.TTR.Actions.ConfirmSelectionAction;
import teamresistance.tickettoride.TTR.Actions.DrawDestinationCardAction;
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

    private boolean isDifficult;
    private Random rand;
    private boolean moveStarted;
    private boolean finishMove;
    private int currentMove;
    private int rainbowCount;
    private String chosenColor;
    private boolean noTracks;
    private String[] colors = new String[]{"Red", "Orange", "Yellow", "Green", "Blue", "Pink",
            "White", "Black"};
    private boolean destinations;
    private boolean foundTrack;

    public TTRComputerPlayer(String name, boolean difficulty){
        super(name);
        isDifficult = difficulty;
        rand = new Random();
        moveStarted = false;
        noTracks = false;
        finishMove = false;
        destinations = false;
        foundTrack = false;
        currentMove = 0;
        rainbowCount = 0;
        chosenColor = "";
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if(info instanceof GameState) {
            TTRGameState compState = (TTRGameState) info;

            if(compState.getPlayerID() == this.playerNum){
                this.sleep(1000);
                if(compState.getGameStart() && !destinations){
                    if(!moveStarted){
                        if(noTracks){
                            currentMove = rand.nextInt(75);
                        }
                        else {
                            currentMove = rand.nextInt(100);
                        }
                    }
                    if(currentMove > 75){
                        moveStarted = true;
                        if(!compState.getTrackModeSelected()){
                            game.sendAction(new ChangeModeAction(this));
                        }
                        else if(!finishMove){
                            rainbowCount = compState.getTrainColorCount("Rainbow", this.playerNum);
                            for(int i = 0; i < compState.getTracks().length; i++){
                                String trainColor = compState.getTracks()[i].getTrackColor();
                                if(!compState.getTracks()[i].getCovered() && !foundTrack) {
                                    if (trainColor.equals("Gray")) {
                                        for (int j = 0; j < colors.length; j++) {
                                            if ((compState.getTrainColorCount(colors[j], this.playerNum) + rainbowCount)
                                                    >= compState.getTracks()[i].getTrainTrackNum()
                                                    && !foundTrack) {
                                                finishMove = true;
                                                chosenColor = colors[j];
                                                foundTrack = true;
                                                game.sendAction(new TrackPlaceAction(this, chosenColor, i));
                                            }
                                        }
                                    } else {
                                        for (int j = 0; j < colors.length; j++) {
                                            if (compState.getTrainColorCount(colors[j], this.playerNum)
                                                    >= compState.getTracks()[i].getTrainTrackNum()
                                                    && !foundTrack) {
                                                finishMove = true;
                                                chosenColor = colors[j];
                                                foundTrack = true;
                                                game.sendAction(new TrackPlaceAction(this, chosenColor, i));
                                            } else if ((compState.getTrainColorCount(colors[j], this.playerNum) + rainbowCount)
                                                    >= compState.getTracks()[i].getTrainTrackNum()
                                                    && !foundTrack) {
                                                finishMove = true;
                                                chosenColor = colors[j];
                                                foundTrack = true;
                                                game.sendAction(new TrackPlaceAction(this, chosenColor, i));
                                            }
                                        }
                                    }
                                }
                            }
                            if(!finishMove){
                                noTracks = true;
                                moveStarted = false;
                                game.sendAction(new ChangeModeAction(this));
                            }
                        }
                        else{
                            moveStarted = false;
                            noTracks = false;
                            finishMove = false;
                            currentMove = 0;
                            foundTrack = false;
                            game.sendAction(new ConfirmSelectionAction(this, chosenColor, rainbowCount));
                        }
                    }
                    else if(currentMove > 40){
                        moveStarted = true;
                        if(compState.getTrackModeSelected()){
                            game.sendAction(new ChangeModeAction(this));
                        }
                        else if(!finishMove){
                            finishMove = true;
                            game.sendAction(new DrawDownCardAction(this));
                        }
                        else{
                            moveStarted = false;
                            noTracks = false;
                            finishMove = false;
                            currentMove = 0;
                            foundTrack = false;
                            game.sendAction(new ConfirmSelectionAction(this));
                        }
                    }
                    else if(currentMove > 2){
                        moveStarted = true;
                        if(compState.getTrackModeSelected()){
                            game.sendAction(new ChangeModeAction(this));
                        }
                        else if(!finishMove){
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
                            }
                            //if the player is taking from the down deck, increment selectedCards
                            //accordingly.
                            if (compState.getOnlyDownDeck()) {
                                selectedCards = 2;
                            } else if (compState.getFaceDownTrainCards().getHighlight()) {
                                selectedCards++;
                            }
                            if(selectedCards < 2){
                                if(Math.random() < .75 || compState.getFaceDownTrainCards().getHighlight()){
                                    int num = rand.nextInt(5);
                                    if(compState.getFaceUpTrainCards().getCards().get(num).toString().equals("Rainbow") && selectedCards == 0){
                                        selectedCards = selectedCards + 2;
                                    }
                                    else {
                                        selectedCards++;
                                    }
                                    game.sendAction(new DrawUpCardAction(this, num));
                                }
                                else if(!compState.getFaceDownTrainCards().getHighlight()){
                                    if(selectedCards == 0){
                                        selectedCards = selectedCards + 2;
                                    }
                                    else {
                                        selectedCards++;
                                    }
                                    game.sendAction(new DrawDownCardAction(this));
                                }
                                if(selectedCards ==2){
                                    finishMove = true;
                                }
                            }
                        }
                        else{
                            moveStarted = false;
                            noTracks = false;
                            finishMove = false;
                            currentMove = 0;
                            foundTrack = false;
                            game.sendAction(new ConfirmSelectionAction(this));
                        }
                    }
                    else{
                        moveStarted = true;
                        destinations = true;
                        game.sendAction(new DrawDestinationCardAction(this));
                    }
                }
                else{
                    Deck tempDeck = new Deck("temp");
                    compState.getDestinationCards().moveTopCardTo(tempDeck, compState.getDestinationCards());
                    compState.getDestinationCards().moveTopCardTo(tempDeck, compState.getDestinationCards());
                    compState.getDestinationCards().moveTopCardTo(tempDeck, compState.getDestinationCards());

                    int numSelected = 0;
                    while(numSelected < 2) {
                        for (int i = 0; i < tempDeck.size(); i++) {
                            if (Math.random() < 0.8) {
                                if(!tempDeck.getCards().get(i).getHighlight()) {
                                    tempDeck.getCards().get(i).setHighlight(true);
                                    numSelected++;
                                }
                            }
                        }
                    }
                    Card[] tempCards = new Card[numSelected];
                    int count=0;
                    for(int i = 0; i < tempDeck.size(); i++){
                        if(tempDeck.getCards().get(i).getHighlight()){
                            tempCards[count] = tempDeck.getCards().get(i);
                            count++;
                        }
                    }
                    Deck sendDeck = new Deck("Sending", tempCards);
                    currentMove = 0;
                    destinations = false;
                    moveStarted = false;
                    noTracks = false;
                    finishMove = false;
                    currentMove = 0;
                    foundTrack = false;
                    game.sendAction(new ConfirmSelectionAction(this, sendDeck, tempDeck));
                }
            }
        }
    }
}