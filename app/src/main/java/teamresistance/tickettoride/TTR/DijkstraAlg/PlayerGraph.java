package teamresistance.tickettoride.TTR.DijkstraAlg;

import java.util.List;

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

}

