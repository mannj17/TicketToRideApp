package teamresistance.tickettoride.TTR.DijkstraAlg;


import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
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

public class Dijkstra implements Serializable {
    private static final long serialVersionUID = 388245564192016L;
    private DijkstraGraph myGraph;
    final private int MAX = 100000000;

    public Dijkstra(DijkstraGraph myGraph){
        this.myGraph = myGraph;
    }

    public void dijkstra(int source) {
        for (Vertex vertex : myGraph.getVertexes()) {
            vertex.setDistance(MAX);
            vertex.setKnown(false);
            vertex.setPredecessor(-1);
        }

        int currentVertex = source;
        myGraph.getVertexes().get(currentVertex).setDistance(0);
        boolean allHit = true;
        while(currentVertex != -1){
            relax(currentVertex);
            currentVertex = findSmallest();
            for (Vertex vertex : myGraph.getVertexes()) {
                if (!vertex.getKnown()) {
                    allHit = false;
                }
            }
        }

        if(allHit) {
            Log.i("Working: ", "All Done");
        }
    }

    private ArrayList<Edge> getNeighbors(Vertex vertex){
        ArrayList<Edge> neighbors = new ArrayList<Edge>();
        for(Edge edge: myGraph.getEdges()){
            if(edge.getV1().getName().equals(vertex.getName())
                    || edge.getV2().getName().equals(vertex.getName())){
                neighbors.add(edge);
            }
        }
        return neighbors;
    }

    private void relax(int currentVertex){
        ArrayList<Edge> neighbors = getNeighbors(myGraph.getVertexes().get(currentVertex));
        for(Edge edge: neighbors){
            int checking = -1;
            String check1 = edge.getV1().getName();
            String check2 = edge.getV2().getName();
            if(check1.equals(myGraph.getVertexes().get(currentVertex).getName())){
                checking = edge.getV2().getId();
            }
            else if(check2.equals(myGraph.getVertexes().get(currentVertex).getName())){
                checking = edge.getV1().getId();
            }
            if(myGraph.getVertexes().get(checking).getDistance() >
                    (edge.getWeight() + myGraph.getVertexes().get(currentVertex).getDistance())){
                myGraph.getVertexes().get(checking).setDistance(
                        edge.getWeight() + myGraph.getVertexes().get(currentVertex).getDistance());
                myGraph.getVertexes().get(checking).setPredecessor(currentVertex);
            }
        }
        myGraph.getVertexes().get(currentVertex).setKnown(true);
    }

    private int findSmallest(){
        int smallest = MAX;
        int smallestId = -1;
        for(Vertex vertex: myGraph.getVertexes()){
            if(!vertex.getKnown()){
                if(vertex.getDistance() < smallest){
                    smallest = vertex.getDistance();
                    smallestId = vertex.getId();
                }
            }
        }
        return smallestId;
    }

    public ArrayList<Vertex> getPath(int source, int destination){
        dijkstra(source);
        ArrayList<Vertex> path = new ArrayList<Vertex>();
        Vertex currentVertex = myGraph.getVertexes().get(destination);
        path.add(currentVertex);
        while(currentVertex.getPredecessor() != -1){
            int newVertex = currentVertex.getPredecessor();
            currentVertex = myGraph.getVertexes().get(newVertex);
            path.add(currentVertex);
            Log.i("Path: ", currentVertex.getName());
        }
        return path;
    }
}
