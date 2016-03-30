package teamresistance.tickettoride.TTR;

/**
 *  Card class represents any type of card
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class Card {
    private boolean highlight;
    /**
     * Sets the highlight variable to the new variable
     *
     * @param highlighted- new boolean value for if highlighted or not
     */
    public void setHighlight(boolean highlighted){
        this.highlight = highlighted;
    }

    /**
     * Tells whether the Destination ticket is highlighted or not
     *
     * @return
     *      Returns true or false
     */
    public boolean getHighlight(){
        return highlight;
    }
}
