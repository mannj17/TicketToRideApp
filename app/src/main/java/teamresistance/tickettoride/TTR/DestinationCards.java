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

    //The first locations labeled on the destination cards based on the destNames array
    private int[] cities1 = {1, 3, 5, 7, 9, 11, 13, 14, 16, 14, 18, 7, 13, 20, 22, 24,
            1, 27, 27, 29, 30, 9, 16, 12, 31, 22, 30, 12, 12, 18};

    //The second locations labeled on the destination cards based on the destNames array
    private int[] cities2 = {2, 4, 6, 8, 10, 12, 4, 15, 6, 17, 12, 19, 2, 21, 23, 25,
            26, 28, 4, 21, 19, 23, 8, 7, 6, 15, 16, 21, 25, 5};

    /**
     * Constructor for Destination Cards
     *
     * @param dest1 an index to the first city
     * @param dest2 an index to the second city
     * @param point the value received for completing the track
     */
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