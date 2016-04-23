package teamresistance.tickettoride.TTR;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

import teamresistance.tickettoride.Game.LocalGame;

/**
 * Created by Jess on 3/30/2016.
 */
public class TTRGameStateTest extends TestCase {
//  @Test
//  public void testPlayerGraphs(){
//      TTRGameState myState = new TTRGameState();
//      PlayerGraph myGraph = new PlayerGraph();
//      myState.setNumPlayers(2);
//      //Give player 1 20 tracks
//      for (int i = 0; i < 15; i++){
//          myState.myTracks[i].setCovered(true);
//          myState.myTracks[i].setPlayerID(0);
//      }
//      ArrayList<Track> myTracks = myGraph.divideTrackByPlayer(myState.getTracks(), 0);
//      myGraph.creteGraph(myTracks, 0);
//      assertEquals(true, myGraph.isReachable(0, 5));
//  }
//}

    /**
     * Tests the copy constructor, checking some values
     * @throws Exception
     */
    @Test
    public void testCopyConstructor() throws Exception
    {
            TTRGameState testState = new TTRGameState();
            testState.setNumPlayers(3);
            TTRGameState copyState = new TTRGameState(testState);
            assertTrue("Number of Players", testState.getNumPlayers() == copyState.getNumPlayers());
            assertNotNull("Face Down Deck", copyState.getFaceDownTrainCards());
            assertNotNull("Destination Deck", copyState.getDestinationCards());
            assertNotNull("Face Up Deck", copyState.getFaceUpTrainCards());
            assertNotNull("trackSets", copyState.getTracks());
    }

    /**
     * Checks the face up deck at game start
     * @throws Exception
     */
    @Test
    public void testDrawFaceUpCards() throws Exception
    {
            TTRGameState testState = new TTRGameState();
            Deck testDeck = testState.getFaceUpTrainCards();
            int size = testDeck.size();
            assertTrue("Not 5 cards", size == 5);
            for (int k =0; k<size; k++)
            {
            assertNotNull("Face Up Deck Draw Cards", testDeck.getCards().get(k));
            }
    }

    /**
     * Checks to see if last turn is triggered
     *
     * @throws Exception
     */
    @Test
    public void testGameOver() throws Exception
    {
            TTRGameState testState = new TTRGameState();
            //TTRLocalGame testLocal = new TTRLocalGame();

            testState.setNumPlayers(2);
            assertFalse("Game over to soon", testState.getIsGameOver());
            testState.setTrainToken(1, 1);
           //testState.setIsLastRound(true);
            //testLocal.checkIfGameOver();
            //TODO  NOT PASSING
            assertTrue("Game not over", testState.getIsGameOver());
    }

    /**
     * test the destination deck
     * @throws Exception
     */
    @Test
    public void testDestinationDeck() throws Exception
    {
        TTRGameState testState = new TTRGameState();
        Deck testDeck = testState.getDestinationCards();
        int size = testDeck.size();
        for(int k =0; k<size; k++)
        {
            assertNotNull("Destination deck has null reference",testDeck.getCards().get(k));
        }
    }

    /**
     * Checks to see if train card deck is null
     * @throws Exception
     */
    @Test
    public void testTrainCardDeck() throws Exception
    {
        TTRGameState testState = new TTRGameState();
        Deck testDeck = testState.getFaceDownTrainCards();
        int size = testDeck.size();
        for(int j =0; j < size; j++)
        {
                assertNotNull("train card deck has null reference", testDeck.getCards().get(j));
        }
    }
}


