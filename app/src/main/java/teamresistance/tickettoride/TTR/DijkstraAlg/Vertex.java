package teamresistance.tickettoride.TTR.DijkstraAlg;

import java.io.Serializable;

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
public class Vertex implements Serializable {
    private static final long serialVersionUID = 388245564192016L;

    final private String name;
    final private int id;
    private int distance = -1;
    private boolean known = false;
    private int predecessor = -1;


    public Vertex(String name, int id) {
        this.name = name;
        this.id = id;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        return true;
    }
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getDistance(){
        return distance;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

    public boolean getKnown(){
        return known;
    }

    public void setKnown(boolean known){
        this.known = known;
    }

    public int getPredecessor(){
        return predecessor;
    }

    public void setPredecessor(int predecessor){
        this.predecessor = predecessor;
    }
    @Override
    public String toString() {
        return name;
    }
}
