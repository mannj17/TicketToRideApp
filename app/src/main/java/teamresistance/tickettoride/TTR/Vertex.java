package teamresistance.tickettoride.TTR;

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
 */
public class Vertex {

    final private String id;
    final private String name;

    public Vertex(String id, String name) {
        this.id = id;
        this.name = name;
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    public String getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}
