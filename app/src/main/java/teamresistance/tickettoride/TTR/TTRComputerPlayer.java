package teamresistance.tickettoride.TTR;

import java.util.Random;

import teamresistance.tickettoride.Game.GameComputerPlayer;
import teamresistance.tickettoride.Game.infoMsg.GameInfo;
import teamresistance.tickettoride.Game.infoMsg.GameState;
import teamresistance.tickettoride.TTR.Actions.ConfirmSelectionAction;
import teamresistance.tickettoride.TTR.Actions.DrawDownCardAction;
import teamresistance.tickettoride.TTR.Actions.DrawUpCardAction;

/**
 *  TTRComputerPlayer implements and AI player
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
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
    private Deck trainDeck;
    private Deck destinationDeck;
    private int score;
    private String name;
    private int trainTokens;
    private Boolean isTurn;
    private Random rand;
    private int makeMove;
    private boolean startedMove = false;

//    /*
//     * recieves and interprets info from the local game
//     * @info
//     */
//
//    protected final void recieveInfo(GameInfo info) {
//
//    }


    /*
     * Finds the best move for the computer player and makes that move based on what it finds
     * @info
     */
    protected final void findBestMove(GameInfo info) {
    
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if(info instanceof GameState){
            TTRGameState compState = (TTRGameState) info;
            if(compState.getPlayerID() == this.playerNum){
                this.sleep(1000);
                if(!startedMove){
                    makeMove = rand.nextInt(100);
                }
                if(makeMove < 50) {
                    startedMove = true;
                    int selectedCards = 0;
                    for (int i = 0; i < compState.getFaceUpTrainCards().size(); i++) {
                        if (compState.getFaceUpTrainCards().getCards().get(i).getHighlight()) {
                            if (compState.getFaceUpTrainCards().getCards().get(i).toString().equals("Rainbow")) {
                                selectedCards = 2;
                            } else {
                                selectedCards++;
                            }
                        }
                        if(compState.getOnlyDownDeck()){
                            selectedCards = 2;
                        }
                        else if(compState.getFaceDownTrainCards().getHighlight()){
                            selectedCards++;
                        }
                    }
                    if (selectedCards < 2) {
                        if(Math.random() < .75) {
                            game.sendAction(new DrawUpCardAction(this, rand.nextInt(5)));
                        } else{
                            if(!compState.getOnlyDownDeck()){
                                game.sendAction(new DrawDownCardAction(this));
                            }
                        }
                    } else {
                        startedMove = false;
                        game.sendAction(new ConfirmSelectionAction(this));
                    }
                }
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
        }
    }
}
