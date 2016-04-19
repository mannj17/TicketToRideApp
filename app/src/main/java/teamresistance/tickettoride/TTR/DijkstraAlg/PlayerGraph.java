package teamresistance.tickettoride.TTR.DijkstraAlg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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

    public PlayerGraph() {
        playerNum = -1;
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public int getPlayerNum(){ return playerNum; }

    public ArrayList<Track> divideTrackByPlayer(Track[] tracks, int playerID){
        ArrayList<Track> ownedTracks = new ArrayList<Track>();
        for(int i = 0; i < tracks.length; i++){
            if(tracks[i].getPlayerID() == playerID){
                ownedTracks.add(i, tracks[i]);
            }
        }
        return ownedTracks;
    }

//    public PlayerGraph creteGraph(ArrayList<Track> tracks, int playerID) {
//        List<Vertex> newVertices = new ArrayList<Vertex>();
//        List<Edge> newEdges = new ArrayList<Edge>();
//        for(int i = 0; i < tracks.size(); i++){
//            Vertex temp = new Vertex(tracks.get(i).getEndCity());
//            Vertex temp2 = new Vertex(tracks.get(i).getStartCity());
//            newVertices.add(temp);
//            newVertices.add(temp2);
//            newEdges.add(new Edge(temp,temp2, tracks.get(i).getTrainTrackNum()));
//        }
//        return (new PlayerGraph(newVertices, newEdges, playerID));
//    }

    Boolean isReachable(int s, int d)
    {
        LinkedList<Integer> temp;

        // Mark all the vertices as not visited(By default set
        // as false)
        int V = this.vertexes.size(); //number of total vertices
        boolean visited[] = new boolean[V];

        //Adjacency List
        LinkedList<Integer> adj[] = new LinkedList[V];
        //void addEdge(int v,int w)  {   adj[v].add(w);   }

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        // 'i' will be used to get all adjacent vertices of a vertex
        Iterator<Integer> i;
        while (queue.size()!=0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();

            int n;
            i = adj[s].listIterator();

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            while (i.hasNext())
            {
                n = i.next();

                // If this adjacent node is the destination node,
                // then return true
                if (n==d)
                    return true;

                // Else, continue to do BFS
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        // If BFS is complete without visited d
        return false;
    }
}

