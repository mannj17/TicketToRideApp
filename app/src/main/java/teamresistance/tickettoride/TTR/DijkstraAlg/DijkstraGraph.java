package teamresistance.tickettoride.TTR.DijkstraAlg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicholas Larson
 * @author Parker Schibel
 * @author Jess Mann
 * @author Nick Scaciotti
 * @version April 2016
 *
 * Creates the graph for the dijkstra algorithm
 *
 * 4/17/2016
 /**
External Citation
Date: 4/18/2016
Problem: Had trouble re-visualizing the structure of Dijkstra's algorithm
Resource:
https://www.cs.usfca.edu/~galles/visualization/Dijkstra.html
and C-code from Data Structures class(Spring 2015)
Solution: This tool helped me to visualize the step by step process better
and build my graph based on that. The previously written program helped me check
my steps along the way
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version April 2016
 */
public class DijkstraGraph implements Serializable {
    private static final long serialVersionUID = 3803995564192016L;

        //all the vertices of the graph
        private final ArrayList<Vertex> vertexes;
        //all the tracks and edges of the graph
        private final ArrayList<Edge> edges;

        public DijkstraGraph(ArrayList<Vertex> vertexes, ArrayList<Edge> edges) {
            this.vertexes = vertexes;
            this.edges = edges;
        }

        public ArrayList<Vertex> getVertexes() {
            return vertexes;
        }

        public ArrayList<Edge> getEdges() {
            return edges;
        }

        public void removeEdge(int pos){
            vertexes.remove(pos);
        }
}
