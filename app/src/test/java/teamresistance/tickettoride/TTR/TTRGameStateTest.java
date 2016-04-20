package teamresistance.tickettoride.TTR;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Jess on 3/30/2016.
 */
public class TTRGameStateTest extends TestCase {
  @Test
  public void testPlayerGraphs(){
      TTRGameState myState = new TTRGameState();
      PlayerGraph myGraph = new PlayerGraph();
      myState.setNumPlayers(2);
      //Give player 1 20 tracks
      for (int i = 0; i < 15; i++){
          myState.myTracks[i].setCovered(true);
          myState.myTracks[i].setPlayerID(0);
      }
      ArrayList<Track> myTracks = myGraph.divideTrackByPlayer(myState.getTracks(), 0);
      myGraph.creteGraph(myTracks, 0);
      assertEquals(true, myGraph.isReachable(0, 5));
  }
}