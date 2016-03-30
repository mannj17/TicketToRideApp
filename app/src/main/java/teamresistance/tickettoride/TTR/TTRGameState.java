package teamresistance.tickettoride.TTR;

import teamresistance.tickettoride.Game.infoMsg.GameState;
import teamresistance.tickettoride.TTR.Track;

/**
 *  TTRGameState creates the GameState
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class TTRGameState extends GameState {
    //The first locations labeled on the destination cards
    private int[] destinationCities1 = {1, 3, 5, 7, 9, 11, 13, 14, 16, 14, 18, 7, 13, 20, 22, 24,
            1, 27, 27, 29, 30, 9, 16, 12, 31, 22, 30, 12, 12, 18};

    //The second locations labeled on the destination cards
    private int[] destinationCities2 = {2, 4, 6, 8, 10, 12, 4, 15, 6, 17, 12, 19, 2, 21, 23, 25,
            26, 28, 4, 21, 19, 23, 8, 7, 6, 15, 16, 21, 25, 5};

    //The score values for each of the destination cards
    private int[] destinationValues = {4, 5, 6, 7, 7, 8, 8, 8, 9, 9, 9, 9, 10, 10, 11, 11, 11, 11,
            12, 12, 13, 13, 13, 16, 17, 17, 20, 20, 21, 22};

    /** the face down deck */
    private Deck faceDownTrainCards;
    /** the five face up cards */
    private Deck faceUpTrainCards;
    /** The deck of destination cards */
    private Deck destinationCards;
    /** The pile of discarded train cards */
    private Deck trainDiscard;
    /** The pile of discarded destination cards */
    private Deck destinationDiscard;
    /** The pool of destination cards for when a player is selecting new destination cards*/
    private Deck destinationCardsDrawn;
    /** All of the hands of each player */
    private Deck[] playerTrainDecks;
    /** All of the hands of each player */
    private Deck[] playerDestinationDecks;
    /** Which player's turn it is */
    private int playerID;
    /** The number of players playing the game */
    private int numPlayers;
    /** The current score of each player */
    private int[] scores;
    /** Says whether or not the player is in track select mode */
    private Boolean trackModeSelected;
    /** Says whether or not the player is in card select mode */
    private Boolean cardModeSelected;
    /** Says if the destination card pile has been clicked */
    private Boolean destinationCardsSelected;
    /** Says if either the face down or face up decks have been selected */
    private Boolean trainCardsSelected;
    /** Says if the player has clicked on a placeable track */
    private Boolean placeTrainSelected;
    /** Says if the player needs to be given a pool of destination cards to pick from. Always true at the start since each player needs to choose destination cards. */
    private Boolean isSelectDestinationCards;
    /** If the down deck was clicked on and no face up card was selected, this boolean will say to just pull two cards from the down deck */
    private Boolean onlyDownDeck;
    /** All the tracks in the game */
    private Track[] tracks;
    /** Number of trainTokens per player */
    private int[] trainTokens;
    /** The selected track on screen. Set to -1 if no track is selected. */
    private int trackSpot = -1;
    private Boolean isLastRound = false;
    private Boolean isGameOver = false;
    Track[] testTracks;
    /*
     * Initializes a new GameState
     */
    public TTRGameState() {
        /** initialize train deck */
        for (int i = 0; i < 9; i++){
            if(i == 8){ // "Yellow", "Blue", "Orange", "White", "Pink", "Black", "Red", "Green",
                for(int j = 0; j < 14; j++){
                    faceDownTrainCards.add(new TrainCards(i));
                }
            }
            else { //"Rainbow"
                for (int k = 0; k < 12; k++){
                    faceDownTrainCards.add(new TrainCards(i));
                }
            }
        }
        //place five train cards 'face up;
        for(int i = 0; i < 5; i++){
            faceDownTrainCards.moveTopCardTo(faceUpTrainCards, faceDownTrainCards);
        }

        /** initialize destination deck */
        //needs to be corrected later
        for(int i = 0; i < 30; i++){
            destinationCards.add(new DestinationCards(i, i, i));
        }

        /** intialize player array values*/
        for(int i =0; i < numPlayers; i++){
            trainTokens[i] = 45;
            scores[i] = 0;
            playerTrainDecks[i] = new Deck("Player " + i + " Train Card Deck");
            playerDestinationDecks[i] = new Deck("Player " + i + " Destination Card Deck");
        }
        trainDiscard = new Deck("Train Card Discard");
        destinationDiscard = new Deck("Destination Card Discard");
        destinationCardsDrawn = new Deck("Destination Cards Drawn");

        //Booleans set to defaults
        isSelectDestinationCards = false;
        trackModeSelected = false;
        cardModeSelected = false;
        destinationCardsSelected = false;
        trainCardsSelected = false;

        testTracks = new Track[8];
        testTracks[0] = new Track(2, "Blue", "PittsBurgh", "Boston");
        testTracks[1] = new Track(2, "Yellow", "PittsBurgh", "Boston");
        testTracks[2] = new Track(2, "Orange", "PittsBurgh", "Boston");
        testTracks[3] = new Track(2, "Black", "PittsBurgh", "Boston");
        testTracks[4] = new Track(2, "White", "PittsBurgh", "Boston");
        testTracks[5] = new Track(2, "Pink", "PittsBurgh", "Boston");
        testTracks[6] = new Track(2, "Red", "PittsBurgh", "Boston");
        testTracks[7] = new Track(2, "Green", "PittsBurgh", "Boston");
    }

    /*
     * Creates a deep copy of the GameState
     * @original
     */
    public TTRGameState(TTRGameState original) {


    
    }

    public int[] getDestinationCities1() {
        return destinationCities1;
    }

    public void setDestinationCities1(int[] destinationCities1) {
        this.destinationCities1 = destinationCities1;
    }

    public int[] getDestinationCities2() {
        return destinationCities2;
    }

    public void setDestinationCities2(int[] destinationCities2) {
        this.destinationCities2 = destinationCities2;
    }

    public int[] getDestinationValues() {
        return destinationValues;
    }

    public void setDestinationValues(int[] destinationValues) {
        this.destinationValues = destinationValues;
    }

    public Deck getFaceDownTrainCards() {
        return faceDownTrainCards;
    }

    public void setFaceDownTrainCards(Deck faceDownTrainCards) {
        this.faceDownTrainCards = faceDownTrainCards;
    }

    public Deck getFaceUpTrainCards() {
        return faceUpTrainCards;
    }

    public void setFaceUpTrainCards(Deck faceUpTrainCards) {
        this.faceUpTrainCards = faceUpTrainCards;
    }

    public Deck getDestinationCards() {
        return destinationCards;
    }

    public void setDestinationCards(Deck destinationCards) {
        this.destinationCards = destinationCards;
    }

    public Deck getTrainDiscard() {
        return trainDiscard;
    }

    public void setTrainDiscard(Deck trainDiscard) {
        this.trainDiscard = trainDiscard;
    }

    public Deck getDestinationDiscard() {
        return destinationDiscard;
    }

    public void setDestinationDiscard(Deck destinationDiscard) {
        this.destinationDiscard = destinationDiscard;
    }

    public Deck getDestinationCardsDrawn() {
        return destinationCardsDrawn;
    }

    public void setDestinationCardsDrawn(Deck destinationCardsDrawn) {
        this.destinationCardsDrawn = destinationCardsDrawn;
    }

    public Deck[] getPlayerTrainDecks() {
        return playerTrainDecks;
    }

    public void setPlayerTrainDecks(Deck[] playerTrainDecks) {
        this.playerTrainDecks = playerTrainDecks;
    }

    public Deck[] getPlayerDestinationDecks() {
        return playerDestinationDecks;
    }

    public void setPlayerDestinationDecks(Deck[] playerDestinationDecks) {
        this.playerDestinationDecks = playerDestinationDecks;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public Boolean getTrackModeSelected() {
        return trackModeSelected;
    }

    public void setTrackModeSelected(Boolean trackModeSelected) {
        this.trackModeSelected = trackModeSelected;
    }

    public Boolean getCardModeSelected() {
        return cardModeSelected;
    }

    public void setCardModeSelected(Boolean cardModeSelected) {
        this.cardModeSelected = cardModeSelected;
    }

    public Boolean getDestinationCardsSelected() {
        return destinationCardsSelected;
    }

    public void setDestinationCardsSelected(Boolean destinationCardsSelected) {
        this.destinationCardsSelected = destinationCardsSelected;
    }

    public Boolean getTrainCardsSelected() {
        return trainCardsSelected;
    }

    public void setTrainCardsSelected(Boolean trainCardsSelected) {
        this.trainCardsSelected = trainCardsSelected;
    }

    public Boolean getPlaceTrainSelected() {
        return placeTrainSelected;
    }

    public void setPlaceTrainSelected(Boolean placeTrainSelected) {
        this.placeTrainSelected = placeTrainSelected;
    }

    public Boolean getIsSelectDestinationCards() {
        return isSelectDestinationCards;
    }

    public void setIsSelectDestinationCards(Boolean isSelectDestinationCards) {
        this.isSelectDestinationCards = isSelectDestinationCards;
    }

    public Boolean getOnlyDownDeck() {
        return onlyDownDeck;
    }

    public void setOnlyDownDeck(Boolean onlyDownDeck) {
        this.onlyDownDeck = onlyDownDeck;
    }

    public Track[] getTracks() {
        return tracks;
    }

    public void setTracks(Track[] tracks) {
        this.tracks = tracks;
    }

    public int[] getTrainTokens() {
        return trainTokens;
    }

    public void setTrainTokens(int[] trainTokens) {
        this.trainTokens = trainTokens;
    }

    public int getTrackSpot() {
        return trackSpot;
    }

    public void setTrackSpot(int trackSpot) {
        this.trackSpot = trackSpot;
    }

    public Boolean getIsLastRound() {
        return isLastRound;
    }

    public void setIsLastRound(Boolean isLastRound) {
        this.isLastRound = isLastRound;
    }

    public Boolean getIsGameOver() {
        return isGameOver;
    }

    public void setIsGameOver(Boolean isGameOver) {
        this.isGameOver = isGameOver;
    }
}
