package teamresistance.tickettoride.TTR.DijkstraAlg;

import org.junit.Test;

import java.util.ArrayList;

import teamresistance.tickettoride.TTR.TTRGameState;
import teamresistance.tickettoride.TTR.Track;

import static org.junit.Assert.*;

/**
 * Created by Jess on 4/18/2016.
 */
public class PlayerGraphTest {
    @Test
    public void testPlayerGraphs(){
        TTRGameState myState = new TTRGameState();
        PlayerGraph myGraph = new PlayerGraph();
        myState.setNumPlayers(2);
        //Give player 1 20 tracks
        for (int i = 0; i < 15; i++){
            myState.getTracks()[i].setCovered(true);
            myState.getTracks()[i].setPlayerID(0);
        }
        ArrayList<Track> myTracks = myGraph.divideTrackByPlayer(myState.getTracks(), 0);
        myGraph.creteGraph(myTracks, 0);
        assertEquals(true, myGraph.isReachable(0, 5));
    }
}