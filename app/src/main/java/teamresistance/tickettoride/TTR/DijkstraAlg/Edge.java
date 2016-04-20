package teamresistance.tickettoride.TTR.DijkstraAlg;

import java.io.Serializable;

/**
 * @author Nicholas Larson
 * @author Parker Schibel
 * @author Jess Mann
 * @author Nick Scaciotti
 * @version April 2016
 *
 * Creates the edges for the dijkstra algorithm
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
public class Edge implements Serializable {
    private static final long serialVersionUID = 388245564192016L;
    private final String city1;
    private final String city2;
    private final Vertex v1;
    private final Vertex v2;
    private final int weight;

    public Edge(String city1, String city2, Vertex v1, Vertex v2, int weight) {
        this.city1 = city1;
        this.city2 = city2;
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return v1.getName() + " to " + v2.getName();
    }
}
