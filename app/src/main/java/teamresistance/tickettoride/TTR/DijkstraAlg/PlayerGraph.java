package teamresistance.tickettoride.TTR.DijkstraAlg;

import java.util.ArrayList;
import java.util.List;

import teamresistance.tickettoride.TTR.Track;

/**
 * Created by Jess on 4/17/2016.
 */
public class PlayerGraph {

    private final int playerNum;
    private List<Edge> edges;
    private List<Vertex> vertexes;

    public PlayerGraph(List<Vertex> vertexes, List<Edge> edges, int playerNum) {
        this.vertexes = vertexes;
        this.edges = edges;
        this.playerNum = playerNum;
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Track> divideTrackByPlayer(Track[] tracks, int playerID){
        ArrayList<Track> ownedTracks = new ArrayList<Track>();
        for(int i = 0; i < tracks.length; i++){
            if(tracks[i].getPlayerID() == playerID){
                ownedTracks.add(i, tracks[i]);
            }
        }
        return ownedTracks;
    }

    public PlayerGraph creteGraph(ArrayList<Track> tracks, int playerID) {
        List<Vertex> newVertices = new ArrayList<Vertex>();
        List<Edge> newEdges = new ArrayList<Edge>();
        for(int i = 0; i < tracks.size(); i++){
            Vertex temp = new Vertex(tracks.get(i).getEndCity());
            Vertex temp2 = new Vertex(tracks.get(i).getStartCity());
            newVertices.add(temp);
            newVertices.add(temp2);
            newEdges.add(new Edge(temp,temp2, tracks.get(i).getTrainTrackNum()));
        }
        return (new PlayerGraph(newVertices, newEdges, playerID));
    }
}

