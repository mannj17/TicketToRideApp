package teamresistance.tickettoride.TTR;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

import teamresistance.tickettoride.Game.GamePlayer;

/**
 * Created by Jess on 3/30/2016.
 */
public class TTRGameStateTest extends TestCase {
    /**
     * Various checks to make sure cards drawn from the
     * face down pile are being implemented correctly
     * @throws Exception
     */
    @Test
    public void testDrawFaceDownTrainCard() throws Exception {
        TTRGameState testState = new TTRGameState();
        testState.setNumPlayers(2);
        GamePlayer player = new TTRHumanPlayer("TestMonkey");
        DrawDownCardAction drawDownCardAction = new DrawDownCardAction(player);
        //check face down deck nd is non empty

        /** Case 1: FaceDownDeck Full **/
        //select face down stack
        testState.getFaceDownTrainCards().setHighlight(true);
        //assert on confirm player hand increases by 2
        int oldDeckSize = testState.getPlayerTrainDecks()[0].size();
        testState.setTrainCardsSelected(true);
        ConfirmSelectionAction confirmSelectAction = new ConfirmSelectionAction(player);

      //  testState.confirmSelection(confirmSelectAction);
        assertEquals((oldDeckSize + 2),testState.getPlayerTrainDecks()[0].size());
    }
}