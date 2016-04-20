package teamresistance.tickettoride.TTR.DijkstraAlg;

import teamresistance.tickettoride.TTR.Track;

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
    private final Track track;
    private static final long serialVersionUID = 386249734192016L;
    private final String city1;
    private final String city2;
    private final Vertex v1;
    private final Vertex v2;
    private final int weight;

    public Edge(Track track, Vertex v1, Vertex v2, int weight) {
        this.track = track;
        this.city1 = track.getStartCity();
        this.city2 = track.getEndCity();
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public Track getTrack(){ return track; }
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
