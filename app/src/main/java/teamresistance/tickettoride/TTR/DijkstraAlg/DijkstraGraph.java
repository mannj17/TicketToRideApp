package teamresistance.tickettoride.TTR.DijkstraAlg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicholas Larson
 * @author Parker Schibel
 * @author Jess Mann
 * @author Nick Scaciotti
 * @version April 2016
 *
 * Creates the nodes for the dijkstra algorithm
 *
 * 4/17/2016
 * Source: http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version April 2016
 */
public class DijkstraGraph {
        private final ArrayList<Vertex> vertexes;
        private final ArrayList<Edge> edges;

        public DijkstraGraph(ArrayList<Vertex> vertexes, ArrayList<Edge> edges) {
            this.vertexes = vertexes;
            this.edges = edges;
        }

        public List<Vertex> getVertexes() {
            return vertexes;
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public void removeEdge(int pos){
            vertexes.remove(pos);
        }
}
