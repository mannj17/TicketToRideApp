package teamresistance.tickettoride.TTR;

/**
 *  DestinationCards is a class representing destination cards and extends Card class
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class DestinationCards extends Card{
    //instance variables for beginning and end destinations, score, and if highlighted/claimed
    /** The first city listed on a destination card */
    private String city1;
    /** The second city listed on a destination card */
    private String city2;
    /** The number of points that can be gained from completing the card */
    private int score;

    //String array containing city names
    private final String[] destNames = {"Denver", "El Paso", "Kansas City",
            "Houston", "New York", "Atlanta", "Chicago", "New Orleans", "Calgary",
            "Salt Lake City", "Helena", "Los Angeles", "Duluth", "Sault Ste Marie",
            "Nashville", "Montreal", "Oklahoma City", "Seattle", "Santa Fe",
            "Toronto", "Miami", "Portland", "Phoenix", "Dallas", "New York City",
            "Pittsburgh", "Winnipeg", "Little Rock", "Boston", "Vancouver",
            "San Francisco"};

    public DestinationCards(int dest1, int dest2, int point){
        if(dest1 > destNames.length-1){
            city1 = "";
        }
        else if (dest2 > destNames.length-1){
            city2 = "";
        } else {
            city1 = destNames[dest1];
            city2 = destNames[dest2];
        }
        score = point;
        setHighlight(false);
    }

    /**
     * Sets the score of the ticket to a new value
     *
     * @param newScore- the new destination tickets score value
     */
    public void setScore(int newScore){
        this.score = newScore;
    }

    /**
     * Tells the destination ticket's score
     *
     * @return
     *      returns the score
     */
    public int getScore(){
        return score;
    }
}
