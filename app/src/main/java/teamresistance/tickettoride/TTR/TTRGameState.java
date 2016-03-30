package teamresistance.tickettoride.TTR;

import teamresistance.tickettoride.TTR.Track;

/**
 *
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class TTRGameState {


    //The first locations labeled on the destination cards
    private int[] destinationCities1 = {1, 3, 5, 7, 9, 11, 13, 14, 16, 14, 18, 7, 13, 20, 22, 24,
            1, 27, 27, 29, 30, 9, 16, 12, 31, 22, 30, 12, 12, 18};

    //The second locations labeled on the destination cards
    private int[] destinationCities2 = {2, 4, 6, 8, 10, 12, 4, 15, 6, 17, 12, 19, 2, 21, 23, 25,
            26, 28, 4, 21, 19, 23, 8, 7, 6, 15, 16, 21, 25, 5};

    //The score values for each of the destination cards
    private int[] destinationValues = {4, 5, 6, 7, 7, 8, 8, 8, 9, 9, 9, 9, 10, 10, 11, 11, 11, 11,
            12, 12, 13, 13, 13, 16, 17, 17, 20, 20, 21, 22};

    /*
     * the face down deck
     */

    private Deck faceDownTrainCards;

    /*
     * the five face up cards
     */

    private Deck faceUpTrainCards;

    /*
     * The deck of destination cards
     */

    private Deck destinationCards;

    /*
     * The pile of discarded train cards
     */

    private Deck trainDiscard;

    /*
     * The pile of discarded destination cards
     */

    private Deck destinationDiscard;

    /*
     * The pool of destination cards for when a player is selecting new destination cards
     */

    private Deck destinationCardsDrawn;

    /*
     * All of the hands of each player
     */

    private Deck[] playerTrainDecks;

    /*
     * All of the hands of each player
     */

    private Deck[] playerDestinationDecks;

    /*
     * Which player's turn it is
     */

    private int playerID;

    /*
     * The number of players playing the game
     */

    private int numPlayers;

    /*
     * The current score of each player
     */

    private int[] scores;

    /*
     * Says whether or not the player is in track select mode
     */

    private Boolean trackModeSelected;

    /*
     * Says whether or not the player is in card select mode
     */

    private Boolean cardModeSelected;

    /*
     * Says if the destination card pile has been clicked
     */

    private Boolean destinationCardsSelected;

    /*
     * Says if either the face down or face up decks have been selected
     */

    private Boolean trainCardsSelected;

    /*
     * Says if the player has clicked on a placeable track
     */

    private Boolean placeTrainSelected;

    /*
     * Says if the player needs to be given a pool of destination cards to pick from. Always true at the start since each player needs to choose destination cards.
     */

    private Boolean isSelectDestinationCards;

    /*
     * If the down deck was clicked on and no face up card was selected, this boolean will say to just pull two cards from the down deck
     */

    private Boolean onlyDownDeck;

    /*
     * All the tracks in the game
     */

    private Track[] tracks;

    /*
     * Number of trainTokens per player
     */

    private int[] trainTokens;

    /*
     * The selected track on screen. Set to -1 if no track is selected.
     */

    private int trackSpot = -1;
    private Boolean isLastRound = false;
    private Boolean isGameOver = false;


    /*
     * Initializes a new GameState
     */

    public TTRGameState() {
    
    }


    /*
     * Creates a deep copy of the GameState
     * @original
     */

    public TTRGameState(TTRGameState original) {
    
    }
}
