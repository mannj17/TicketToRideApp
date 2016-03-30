package teamresistance.tickettoride.TTR;

/**
 *
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class DestCards {

    /** The first city listed on a destination card */
    private String city1;
    /** The second city listed on a destination card */
    private String city2;
    /** The number of points that can be gained from completing the card */
    private int score;


    public DestCards(String dest1, String dest2, int point) {
        city1 = dest1;
        city2 = dest2;
        score = point;
    }

    public String getCity1() {
        return city1;
    }

    public void setCity1(String city1) {
        this.city1 = city1;
    }

    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
