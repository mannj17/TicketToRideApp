package teamresistance.tickettoride.TTR;

import java.io.Serializable;
import java.util.ArrayList;

import teamresistance.tickettoride.Game.infoMsg.GameState;


/**
 *  TTRGameState creates the GameState
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class TTRGameState extends GameState implements Serializable{

    private static final long serialVersionUID = 388245678192016L;
    private Track tempTrack;
    private ArrayList<Track> tempTracks = new ArrayList<Track>();

    int MAX_NUM_PLAYERS = 4;
//    //The first locations labeled on the destination cards
//    private int[] destinationCities1 = {1, 3, 4, 7, 9, 11, 13, 14, 16, 14, 18, 7, 13, 20, 22, 24,
//            1, 27, 27, 29, 30, 9, 16, 12, 31, 22, 30, 12, 12, 18};
//    //The second locations labeled on the destination cards
//    private int[] destinationCities2 = {2, 4, 6, 8, 10, 12, 4, 14, 6, 17, 12, 19, 2, 21, 23, 24,
//            26, 28, 4, 21, 19, 23, 8, 7, 6, 14, 16, 21, 24, 4};
//    //The score values for each of the destination cards
//    private int[] destinationValues = {4, 4, 6, 7, 7, 8, 8, 8, 9, 9, 9, 9, 10, 10, 11, 11, 11, 11,
//            12, 12, 13, 13, 13, 16, 17, 17, 20, 20, 21, 22};

    /** the face down deck */
    private Deck faceDownTrainCards;
    /** the five face up cards */
    private Deck faceUpTrainCards;
    /** The deck of destination cards */
    private Deck destinationCards;
    /**pool of destination cards for a player to choose from*/
    private Deck destinationPool;
    /** The pile of discarded train cards */
    private Deck trainDiscard;
    /** The pile of discarded destination cards */
    private Deck destinationDiscard;
    /** The pool of destination cards for when a player is selecting new destination cards*/
    private Deck destinationCardsDrawn;
    /** Which player's turn it is */
    private int playerID;
    /** The number of players playing the game */
    private int numPlayers = MAX_NUM_PLAYERS;
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
//    /** Says if the player needs to be given a pool of destination cards to pick from. Always true at the start since each player needs to choose destination cards. */
//    private Boolean isSelectDestinationCards;
    /** If the down deck was clicked on and no face up card was selected, this boolean will say to just pull two cards from the down deck */
    private boolean onlyDownDeck;
    /** The selected track on screen. Set to -1 if no track is selected. */
    private int trackSpot = -1;
    private String selectedTrackColor;
    private boolean useRainbow;
    private boolean gameStart;
    private boolean reset;
    private Boolean isLastRound = false;
    private Boolean isGameOver = false;
    private boolean[] faceUpCardsHighlight = new boolean[5];

    //PARALLEL ARRAYS//
    /** Number of trainTokens per player */
    private int[] trainTokens = new int[numPlayers];
    /** The current score of each player */
    private int[] scores = new int[numPlayers];
    /** The names of each player */
    private String[] names = new String[numPlayers];
    /** All of the hands of each player */
    private Deck[] playerTrainDecks = new Deck[numPlayers];
    /** All of the hands of each player */
    private Deck[] playerDestinationDecks = new Deck[numPlayers];
    private int numRainbows;

    /*
     * Initializes a new GameState
     */
    public TTRGameState() {
        /** initialize train deck */
        faceDownTrainCards = new Deck("Face Down Deck");
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
        //shuffles newly created deck
        faceDownTrainCards.shuffle();
        faceUpTrainCards = new Deck("Face up Cards");
        //place five train cards 'face up'
        for(int i = 0; i < 5; i++){
            faceDownTrainCards.moveTopCardTo(faceUpTrainCards, faceDownTrainCards);
            faceUpCardsHighlight[i] = false;
        }

        /** initialize destination deck */
        //needs to be corrected later
        destinationCards = new Deck("Destination Cards");
        destinationDiscard = new Deck("Destination Discard");
        for (int i = 0; i < 30; i++) {
            destinationCards.add(new DestinationCards(i, i, i));
        }
        destinationCards.shuffle();
        /** initialize array values to max possible size */
        for (int i = 0; i < numPlayers; i++){
            trainTokens[i] = 45;
            int k = 0;
            scores[i] = 0;
            names[i] = "";
            playerTrainDecks[i] = new Deck("Player " + i + " Train Card Deck");
            //places the top 5 cards of the face down deck into the current players train card deck
            while (k != 4) {
                //checks to make sure that player does not get a locomotive card
                if (!faceDownTrainCards.peekAtTopCard().toString().equals("Rainbow")) {
                    faceDownTrainCards.moveTopCardTo(playerTrainDecks[i], faceDownTrainCards);
                    k++;
                } else
                {
                    faceDownTrainCards.shuffle();
                }
            }
            //places 3 destination cards into the current players destination deck
            playerDestinationDecks[i] = new Deck("Player " + i + " Destination Card Deck");
        }
        selectedTrackColor = null;
        trainDiscard = new Deck("Train Card Discard");
        destinationCardsDrawn = new Deck("Destination Cards Drawn");
        destinationPool = new Deck("Destination Card Pool");
        numRainbows = 0;



        //Booleans set to defaults
//        isSelectDestinationCards = false;
        trackModeSelected = false;
        cardModeSelected = false;
        destinationCardsSelected = false;
        trainCardsSelected = false;
        useRainbow = false;
        trackModeSelected = false;
        cardModeSelected = false;
        destinationCardsSelected = true;
        trainCardsSelected = false;
        placeTrainSelected = false;
//        isSelectDestinationCards = false;
        onlyDownDeck = false;
        gameStart = false;
        reset = false;

        //tracks
        tempTrack= new Track(5, "Green", "Portland", "San Francisco");
        tempTracks.add(tempTrack);
        //tempTrack = new Track(5, "Pink", "Portland", "San Francisco");
        //tempTracks.add(tempTrack);
        tempTrack= new Track(3, "Yellow", "San Francisco", "Los Angeles");
        tempTracks.add(tempTrack);
        tempTrack= new Track(2, "Gray", "Los Angeles", "Las Vegas");
        tempTracks.add(tempTrack);
        tempTrack= new Track(2, "Gray", "Montreal", "Boston");
        tempTracks.add(tempTrack);
        tempTrack= new Track(3, "Blue", "Montreal", "New York");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Yellow", "New York", "Boston");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Orange", "New York", "Washington");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Gray", "Raleigh", "Washington");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Gray", "Raleigh", "Charleston");
        tempTracks.add(tempTrack);
        tempTrack = new Track(4, "Pink", "Miami", "Charleston");
        tempTracks.add(tempTrack);
        tempTrack = new Track(5, "Blue", "Atlanta", "Miami");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Gray", "Atlanta", "Charleston");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Gray", "Raleigh", "Atlanta");
        tempTracks.add(tempTrack);
        //tempTrack = new Track(2, "Gray", "Raleigh", "Atlanta");
        tempTrack = new Track(2, "Gray", "Pittsburgh", "Raleigh");
        tempTracks.add(tempTrack);
        // tempTrack = new Track(2, "Gray", "Pittsburgh", "Raleigh");
        tempTrack = new Track(2, "Gray", "Pittsburgh", "Washington");
        tempTracks.add(tempTrack);
        // tempTrack = new Track(2, "White", "Pittsburgh", "New York");
        tempTrack = new Track(2, "White", "Pittsburgh", "New York");
        tempTracks.add(tempTrack);
        //tempTrack = new Track(2, "Gray", "Toronto", "Pittsburgh");
        tempTrack = new Track(2, "Gray", "Toronto", "Pittsburgh");
        tempTracks.add(tempTrack);
        tempTrack = new Track(3, "Gray", "Toronto", "Montreal");
        tempTracks.add(tempTrack);
        tempTrack = new Track(5, "Black", "Sault Ste Marie", "Montreal");
        tempTracks.add(tempTrack);
        tempTrack = new Track(6, "Red", "New Orleans", "Miami");
        tempTracks.add(tempTrack);
        tempTrack = new Track(6, "Black", "Los Angeles", "El Paso");
        tempTracks.add(tempTrack);
        //tempTrack = new Track(1, "Gray", "Vancouver", "Seattle");
        tempTrack = new Track(1, "Gray", "Vancouver", "Seattle");
        tempTracks.add(tempTrack);
        //tempTrack = new Track(1, "Gray", "Seattle", "Portland");
        tempTrack = new Track(1, "Gray", "Seattle", "Portland");
        tempTracks.add(tempTrack);
        tempTrack = new Track(3, "Gray", "Vancouver", "Calgary");
        tempTracks.add(tempTrack);
        tempTrack = new Track(4, "Gray", "Seattle", "Calgary");
        tempTracks.add(tempTrack);
        tempTrack = new Track(3, "Gray", "Los Angeles", "Phoenix");
        tempTracks.add(tempTrack);
        tempTrack = new Track(6, "Yellow", "Seattle", "Helena");
        tempTracks.add(tempTrack);
        tempTrack = new Track(6, "Blue", "Portland", "Salt Lake City");
        tempTracks.add(tempTrack);
        //tempTrack = new Track(5, "White", "San Francisco", "Salt Lake City");
        tempTrack = new Track(5, "Orange", "San Francisco", "Salt Lake City");
        tempTracks.add(tempTrack);
        tempTrack = new Track(3, "Orange", "Las Vegas", "Salt Lake City");
        tempTracks.add(tempTrack);
        tempTrack = new Track(6, "White", "Calgary", "Winnipeg");
        tempTracks.add(tempTrack);
        tempTrack = new Track(4, "Gray", "Calgary", "Helena");
        tempTracks.add(tempTrack);
        tempTrack = new Track(3, "Pink", "Helena", "Salt Lake City");
        tempTracks.add(tempTrack);
        tempTrack = new Track(3, "Red", "Salt Lake City", "Denver");
        tempTracks.add(tempTrack);
        tempTrack = new Track(5, "White", "Phoenix", "Denver");
        tempTracks.add(tempTrack);
        tempTrack = new Track(3, "Gray", "Phoenix", "Santa Fe");
        tempTracks.add(tempTrack);
        tempTrack = new Track(3, "Gray", "Phoenix", "El Paso");
        tempTracks.add(tempTrack);
        tempTrack = new Track(4, "Blue", "Helena", "Winnipeg");
        tempTracks.add(tempTrack);
        tempTrack = new Track(4, "Green", "Helena", "Denver");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Gray", "Denver", "Santa Fe");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Gray", "Santa Fe", "El Paso");
        tempTracks.add(tempTrack);
        tempTrack = new Track(6, "Orange", "Helena", "Duluth");
        tempTracks.add(tempTrack);
        //tempTrack = new Track(4, "Orange", "New Orleans", "Atlanta");
        tempTrack = new Track(4, "Yellow", "New Orleans", "Atlanta");
        tempTracks.add(tempTrack);
        tempTrack = new Track(1, "Gray", "Nashville", "Atlanta");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Black", "Nashville", "Raleigh");
        tempTracks.add(tempTrack);
        tempTrack = new Track(4, "Yellow", "Nashville", "Pittsburgh");
        tempTracks.add(tempTrack);
        tempTrack = new Track(5, "Green", "Saint Louis", "Pittsburgh");
        tempTracks.add(tempTrack);
        tempTrack = new Track(3, "Orange", "Chicago", "Pittsburgh");
        tempTracks.add(tempTrack);
        //tempTrack = new Track(3, "Black", "Chicago", "Pittsburgh");
        tempTrack = new Track(4, "White", "Chicago", "Toronto");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Gray", "Sault Ste Marie", "Toronto");
        tempTracks.add(tempTrack);
        tempTrack = new Track(5, "Red", "Helena", "Omaha");
        tempTracks.add(tempTrack);
        tempTrack = new Track(4, "Pink", "Denver", "Omaha");
        tempTracks.add(tempTrack);
        tempTrack = new Track(4, "Black", "Denver", "Kansas City");
        tempTracks.add(tempTrack);
        //tempTrack = new Track(4, "Orange", "Denver", "Kansas City");
        tempTrack = new Track(4, "Red", "Denver", "Oklahoma City");
        tempTracks.add(tempTrack);
        tempTrack = new Track(3, "Blue", "Santa Fe", "Oklahoma City");
        tempTracks.add(tempTrack);
        tempTrack = new Track(5, "Yellow", "El Paso", "Oklahoma City");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Gray", "Saint Louis", "Nashville");
        tempTracks.add(tempTrack);
        tempTrack = new Track(3, "White", "Little Rock", "Nashville");
        tempTracks.add(tempTrack);
        tempTrack = new Track(3, "Green", "Little Rock", "New Orleans");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Gray", "Houston", "New Orleans");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Gray", "Saint Louis", "Little Rock");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Gray", "Dallas", "Little Rock");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Gray", "Oklahoma City", "Little Rock");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Pink", "Kansas City", "Saint Louis");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Green", "Chicago", "Saint Louis");
        tempTracks.add(tempTrack);
        //tempTrack = new Track(2, "White", "Chicago", "Saint Louis");
        tempTrack = new Track(4, "Blue", "Omaha", "Chicago");
        tempTracks.add(tempTrack);
        tempTrack = new Track(4, "Red", "El Paso", "Dallas");
        tempTracks.add(tempTrack);
        tempTrack = new Track(6, "Green", "El Paso", "Houston");
        tempTracks.add(tempTrack);
        tempTrack = new Track(4, "Black", "Winnipeg", "Duluth");
        tempTracks.add(tempTrack);
        tempTrack = new Track(1, "Gray", "Dallas", "Houston");
        tempTracks.add(tempTrack);
        //tempTrack = new Track(1, "Gray", "Dallas", "Houston");
        tempTrack = new Track(2, "Gray", "Oklahoma City", "Dallas");
        tempTracks.add(tempTrack);
        //tempTrack = new Track(2, "Gray", "Oklahoma City", "Dallas");
        tempTrack = new Track(2, "Gray", "Kansas City", "Oklahoma City");
        tempTracks.add(tempTrack);
        // tempTrack = new Track(2, "Gray", "Kansas City", "Oklahoma City");
        tempTrack = new Track(3, "Red", "Duluth", "Chicago");
        tempTracks.add(tempTrack);
        tempTrack = new Track(6, "Pink", "Duluth", "Toronto");
        tempTracks.add(tempTrack);
        tempTrack = new Track(3, "Gray", "Duluth", "Sault Ste Marie");
        tempTracks.add(tempTrack);
        tempTrack = new Track(6, "Gray", "Winnipeg", "Sault Ste Marie");
        tempTracks.add(tempTrack);
        tempTrack = new Track(2, "Gray", "Duluth", "Omaha");
        tempTracks.add(tempTrack);
        //tempTrack = new Track(2, "Gray", "Duluth", "Omaha");
        tempTrack = new Track(1, "Gray", "Omaha", "Kansas City");
        tempTracks.add(tempTrack);
        //tempTrack = new Track(1, "Gray", "Omaha", "Kansas City");
    }
    /*
     * Creates a deep copy of the GameState
     * @original
     */
    public TTRGameState(TTRGameState original) {
        numPlayers = original.getNumPlayers();
        playerID = original.getPlayerID();
        faceDownTrainCards = new Deck(original.faceDownTrainCards);
        faceUpTrainCards = new Deck(original.faceUpTrainCards);
        for(int i = 0; i < original.getFaceUpCardsHighlight().length; i++){
            faceUpCardsHighlight[i] = original.getFaceUpCardsHighlight()[i];
        }
        destinationCards = new Deck(original.destinationCards);
        trainDiscard = new Deck(original.trainDiscard);
        destinationDiscard = new Deck(original.destinationDiscard);

        for(int i = 0; i < original.getNumPlayers(); i++){
            trainTokens[i] = original.getTrainTokens()[i];
            scores[i] = original.getScores()[i];
            names[i] = original.getNames()[i];
            playerTrainDecks[i] = new Deck(original.getPlayerTrainDecks()[i]);
            playerDestinationDecks[i] = new Deck(original.getPlayerDestinationDecks()[i]);
        }

        tempTracks = original.getTracks();


        trackSpot = original.getTrackSpot();
        numRainbows = original.getNumRainbows();
        selectedTrackColor = original.getSelectedTrackColor();
//            isSelectDestinationCards = original.getIsSelectDestinationCards();
        trackModeSelected = original.getTrackModeSelected();
        cardModeSelected = original.getCardModeSelected();
        destinationCardsSelected = original.getDestinationCardsSelected();
        trainCardsSelected = original.getTrainCardsSelected();
        onlyDownDeck = original.getOnlyDownDeck();
        useRainbow = original.getUseRainbow();
        gameStart = original.getGameStart();
        setNames(original.getNames());
        if(gameStart){
            cardModeSelected = original.getCardModeSelected();
            trackModeSelected = original.getTrackModeSelected();
        }
        else{
            cardModeSelected = false;
            trackModeSelected = false;
        }
    }

    public int getTrackPosition(String city1, String city2){
        int position = -1;
        for(int i = 0; i < tempTracks.size(); i++){
            if(city1.equals(tempTracks.get(i).getStartCity()) && city2.equals(tempTracks.get(i).getEndCity())){
                position = i;
            }
        }
        return position;
    }
//    public int[] getDestinationCities1() {
//        return destinationCities1;
//    }
//
//    public void setDestinationCities1(int[] destinationCities1) {
//        this.destinationCities1 = destinationCities1;
//    }
//
//    public int[] getDestinationCities2() {
//        return destinationCities2;
//    }
//
//    public void setDestinationCities2(int[] destinationCities2) {
//        this.destinationCities2 = destinationCities2;
//    }
//
//    public int[] getDestinationValues() {
//        return destinationValues;
//    }
//
//    public void setDestinationValues(int[] destinationValues) {
//        this.destinationValues = destinationValues;
//    }

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

    public String[] getNames() {
        return names;
    }

    /**
     * Sets the names
     * @param names string array of the names
     */
    public void setNames(String[] names) {
        String[] temp = new String[MAX_NUM_PLAYERS];
        for(int i = 0; i < MAX_NUM_PLAYERS; i ++){
            temp[i] = names[i];
        }
        this.names = temp;
    }

    public Deck getTrainDiscard() {
        return trainDiscard;
    }

    public void setTrainDiscard(Deck trainDiscard) {
        this.trainDiscard = trainDiscard;
    }

    public Deck getDestinationPool() {
        return destinationPool;
    }

    public void setDestinationPool(Deck destinationPool) {
        this.destinationPool = destinationPool;
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

    /**
     * Returns the number of a particular card type in a players hand
     * @param color string reference to train card type
     * @param index int reference to current player
     * @return int of card type
     */
    public int getTrainColorCount(String color, int index){
        int count = 0;
        if(index != -1) {
            for (int i = 0; i < playerTrainDecks[index].size(); i++) {
                if (playerTrainDecks[index].getCards().get(i).toString().equals(color)) {
                    count++;
                }
            }
        }
        else{
            for(int i = 0; i< faceUpTrainCards.size(); i++){
                if (faceUpTrainCards.getCards().get(i).toString().equals(color)){
                    count++;
                }
            }
        }
        return count;
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

    public void setScore(int score, int index) {
        this.scores[index] = score;
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

//    public Boolean getIsSelectDestinationCards() {
//        return isSelectDestinationCards;
//    }
//
//    public void setIsSelectDestinationCards(Boolean isSelectDestinationCards) {
//        this.isSelectDestinationCards = isSelectDestinationCards;
//    }

    public boolean getOnlyDownDeck() {
        return onlyDownDeck;
    }

    public void setOnlyDownDeck(Boolean onlyDownDeck) {
        this.onlyDownDeck = onlyDownDeck;
    }

    public ArrayList<Track> getTracks() { return tempTracks; }

    public void setTracks(ArrayList<Track> tracks) {
        this.tempTracks = tracks;
    }

    public int[] getTrainTokens() {
        return trainTokens;
    }

    public void setTrainToken(int trainToken, int index) {
        this.trainTokens[index] = trainToken;
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

    public String getSelectedTrackColor(){
        return selectedTrackColor;
    }

    public void setSelectedTrackColor(String value){
        this.selectedTrackColor = value;
    }

    public boolean getUseRainbow(){
        return useRainbow;
    }

    public void setUseRainbow(boolean value){
        this.useRainbow = value;
    }

    public int getNumRainbows() {
        return numRainbows;
    }

    public void setNumRainbows(int value) {
        this.numRainbows = value;
    }

    public boolean getGameStart(){ return gameStart; }

    public void setGameStart(boolean val){ gameStart = val; }

    public boolean getReset(){ return reset; }

    public void setReset(boolean reset){ this.reset = reset; }

    public boolean[] getFaceUpCardsHighlight() {
        return faceUpCardsHighlight;
    }
}