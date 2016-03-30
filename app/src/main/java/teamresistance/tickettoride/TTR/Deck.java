package teamresistance.tickettoride.TTR;

import java.util.ArrayList;

/**
 *
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class Deck {
    /** Says whether or not the card has been selected */
    private boolean highlight;
    /** Name of the deck. IE: destinationDeck or trainCardDeck or playerHandDeck */
    private String deckName;
    /** the arraylist of train cards acting as a deck */
    private ArrayList<Card> cards;

    /*
     * Constructor for a Deck
     * @deckName
     * @cards
     */
    public Deck(String deckName, Card[] newCards) {
        cards = new ArrayList<Card>();
        for (int i = 0; i < newCards.length; i++){
            cards.add(newCards[i]);
        }
        highlight = false;
    }

    /*
     * Creates a new Deck based on a already created one
     * @orig
     */
    public Deck(Deck orig) {
        for (int i =0; i < orig.getCards().size(); i++){
            cards.add(orig.getCards().get(i));
        }
        highlight = orig.getHighlight();
    }

    public final void firstDeck() {
        return;
    }

    public void shuffle() {
        return;
    }

    public void moveTopCardTo(Deck targetDeck, Deck sourceDeck) {
        return;
    }

    public void moveAllCardsTo(Deck targetDeck, Deck sourceDeck) {
        return;
    }

    public void add(Card c) {
        cards.add(c);
    }

    public int size() {
         return cards.size();
    }

    public Card removeTopCard() {
        return null;
    }

    public Card peekAtTopCard() {
        return cards.get(0);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setHighlight(boolean value) {
        highlight = value;
    }

    public boolean getHighlight() {
        return highlight;
    }
}
