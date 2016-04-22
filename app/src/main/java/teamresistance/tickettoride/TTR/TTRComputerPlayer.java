package teamresistance.tickettoride.TTR;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import teamresistance.tickettoride.Game.GameComputerPlayer;
import teamresistance.tickettoride.Game.infoMsg.GameInfo;
import teamresistance.tickettoride.Game.infoMsg.GameState;
import teamresistance.tickettoride.TTR.Actions.ChangeModeAction;
import teamresistance.tickettoride.TTR.Actions.ConfirmSelectionAction;
import teamresistance.tickettoride.TTR.Actions.DrawDestinationCardAction;
import teamresistance.tickettoride.TTR.Actions.DrawDownCardAction;
import teamresistance.tickettoride.TTR.Actions.DrawUpCardAction;
import teamresistance.tickettoride.TTR.Actions.TrackPlaceAction;
import teamresistance.tickettoride.TTR.DijkstraAlg.Dijkstra;
import teamresistance.tickettoride.TTR.DijkstraAlg.DijkstraGraph;
import teamresistance.tickettoride.TTR.DijkstraAlg.Edge;
import teamresistance.tickettoride.TTR.DijkstraAlg.Vertex;

/**
 *  TTRComputerPlayer implements and AI player
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version April 2016
 */
public class TTRComputerPlayer extends GameComputerPlayer implements Serializable {
    private static final long serialVersionUID = 388245564192099L;

    private boolean isDifficult;//boolean saying whether the player is smart or dumb
    private Random rand;
    private boolean moveStarted; //boolean that indicates if the player's turn has started.
    private boolean finishMove;  //boolean signifying to the system that it is ready to confirm selection
    private int currentMove;     //Used by the dumb AI to keep track of what turn it's doing
    private int rainbowCount;    //number of rainbow cards the player has and will probably use
    private String chosenColor;  //Used for Gray tracks, used to say which deck the player would like to use
    private boolean noTracks;    //boolean that says if there are tracks to take or not.

    //String array of all the colors of the train cards. Used for evaluating what tracks
    //can be taken and what move to make depending on the color needed by the AI.
    private String[] colors = new String[]{"Red", "Orange", "Yellow", "Green", "Blue", "Pink",
            "White", "Black", "Rainbow"};

    //list of all destinations to assist with determining which destination route to attempt and complete
    private final ArrayList<String> destNames = new ArrayList<String>(Arrays.asList("Denver", "El Paso", "Kansas City",
            "Houston", "New York", "Atlanta", "Chicago", "New Orleans", "Calgary",
            "Salt Lake City", "Helena", "Los Angeles", "Duluth", "Sault Ste Marie",
            "Nashville", "Montreal", "Oklahoma City", "Seattle", "Santa Fe",
            "Toronto", "Miami", "Portland", "Phoenix", "Dallas",
            "Pittsburgh", "Winnipeg", "Little Rock", "Boston", "Vancouver",
            "San Francisco", "Las Vegas", "Washington", "Raleigh", "Charleston",
            "Saint Louis", "Omaha"));
    private boolean destinations; //boolean that says if the player needs to draw more destination cards
    private boolean foundTrack;   //boolean that says if a track to be taken has been found for the dumb AI
    private DijkstraGraph computerGraph; //the Graph of all the Vertexes on the map and Edges owned by the player
    private Dijkstra compDijkstra; //the Dijkstra object to evaluate the computerGraph
    private TTRGameState compState; //the copy of the game state
    private DestinationCards currentCard;//the current route the player is trying to accomplish
    private boolean[] completed; //array of booleans corresponding to which routes have been completed
    private int[] trainHand = new int[9]; //array of ints corresponding to number of each color of
                                          //train card in the player's hand
    private int trainPosition; //index of the train the player is trying to take.
    private String trackColor; //color of the current track that has been selected

    //array of booleans that correspond to whether or not the player needs cards of the colors the
    //indexes correspond to. Works similarly to the trainHand array.
    private boolean[] neededCards = {false, false, false, false, false, false, false, false};

    public TTRComputerPlayer(String name, boolean difficulty){
        super(name);
        isDifficult = difficulty;
        rand = new Random();
        moveStarted = false;
        noTracks = false;
        finishMove = false;
        destinations = false;
        foundTrack = false;
        currentMove = 0;
        rainbowCount = 0;
        chosenColor = "";
        trainPosition = -1;
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if(info instanceof GameState) {
            compState = (TTRGameState) info;
            if(compState.getPlayerID() == this.playerNum){
                this.sleep(1000); //allows the user to see what's happening at a slower pace

                //only enter here if the player is smart, the game has started, and the player does
                //not need more destination cards
                if(isDifficult && compState.getGameStart() && !destinations){

                    //create lists of vertexes and edges not owned by other players
                    ArrayList<Vertex> myVertexList = new ArrayList<Vertex>();
                    ArrayList<Edge> myEdgeList = new ArrayList<Edge>();
                    Vertex temp = null;

                    //Create a Vertex for every city on the map
                    for(int i = 0; i < destNames.size(); i++){
                        temp = new Vertex(destNames.get(i),i);
                            myVertexList.add(temp);
                    }
                    Vertex startCity = null;
                    Vertex endCity = null;

                    //create all of the edges that other player's don't own and save them
                    //to the list of Edges
                    for(int i = 0; i < compState.getTracks().size(); i++){
                        String city1 = compState.getTracks().get(i).getStartCity();
                        String city2 = compState.getTracks().get(i).getEndCity();
                        for(Vertex vert: myVertexList){
                            int spot = vert.getId();
                            if(city1.equals(destNames.get(spot))
                                    && (compState.getTracks().get(i).getPlayerID() == -1
                                    || compState.getTracks().get(i).getPlayerID() == this.playerNum)
                                    && startCity == null){
                                startCity = vert;
                            }
                            else if(city2.equals(destNames.get(spot))
                                    && (compState.getTracks().get(i).getPlayerID() == -1
                                    || compState.getTracks().get(i).getPlayerID() == this.playerNum)
                                    && endCity == null){
                                endCity = vert;
                            }
                        }
                        Edge temporary = null;

                        //if the edge exists, add it to the list of edges
                        if(startCity != null && endCity != null) {
                            temporary = new Edge(compState.getTracks().get(i),startCity, endCity,
                                    compState.getTracks().get(i).getTrainTrackNum());
                        }
                        startCity = null;
                        endCity = null;
                        if(!myEdgeList.contains(temporary) && temporary!= null){
                            myEdgeList.add(temporary);
                        }
                    }

                    //create a graph using the Vertexes as well as the edges not owned by other players
                    computerGraph = new DijkstraGraph(myVertexList, myEdgeList);

                    //create a dijkstra object to assist in evaluating the Graph
                    compDijkstra = new Dijkstra(computerGraph);

                    //if the move has started, find the best move available
                    if(!finishMove && !moveStarted){
                        findBestMove();
                    }

                    //If the move has been started, using booleans to send actions.
                    if(!finishMove && moveStarted){

                        //if there are no tracks that the player wants to take, draw cards.
                        if(noTracks){

                            //check to see how many train cards have already been highlighted.
                            int numSelected = 0;
                            for (int i = 0; i < compState.getFaceUpTrainCards().getCards().size(); i++){
                                if(compState.getFaceUpTrainCards().getCards().get(i).getHighlight()){

                                    //locomotive cards are equal to two cards being highlighted
                                    if(((TrainCards)compState.getFaceUpTrainCards().getCards().get(i))
                                            .getType().equals("Rainbow")) {
                                        numSelected = numSelected + 2;
                                    }
                                    else{
                                        numSelected++;
                                    }
                                }
                            }

                            //only the down deck being highlighted corresponds to two cards being selected
                            if(compState.getOnlyDownDeck()){
                                numSelected = numSelected + 2;
                            }
                            else if(compState.getFaceDownTrainCards().getHighlight()){
                                numSelected++;
                            }

                            //check to see if any of the train cards the player needs are in the
                            //face up train card deck if two cards have not been selected
                            int spot = -1;
                            if(numSelected < 2) {
                                for (int i = 0; i < neededCards.length; i++) {
                                    if (neededCards[i] == true) {
                                        for (int j = 0; j < compState.getFaceUpTrainCards().getCards().size(); j++) {
                                            if (((TrainCards) compState.getFaceUpTrainCards().getCards().get(j)).getType().equals(colors[i])
                                                    && !compState.getFaceUpTrainCards().getCards().get(j).getHighlight()) {
                                                spot = j;
                                            }
                                        }
                                    }
                                }
                            }

                            //if the appropriate number of cards have been chosen, initiate
                            //the end of the turn
                            else{
                                finishMove = true;
                            }

                            //if a card in the face up deck was found that the player wants, select it
                            if(spot != -1){
                                game.sendAction(new DrawUpCardAction(this, spot));
                            }

                            //if the player did not find a card they wanted in the face up cards,
                            //but can still select a card, see if there is a rainbow card
                            else if(!finishMove){
                                for(int i = 0; i < compState.getFaceUpTrainCards().getCards().size(); i++){
                                    if(((TrainCards)compState.getFaceUpTrainCards().getCards().get(i)).getType().equals("Rainbow")){
                                        spot = i;
                                    }
                                }

                                //if a rainbow card has been found, select it, otherwise select
                                //the face down card
                                if(spot != -1 && numSelected == 0){
                                    finishMove = true;
                                    game.sendAction(new DrawUpCardAction(this, spot));
                                }
                                else{
                                    moveStarted = false;
                                    finishMove = false;
                                    game.sendAction(new DrawDownCardAction(this));
                                }
                            }

                            //if a selection is ready to be confirmed, send a confirmSelectionAction
                            else{
                                moveStarted = false;
                                finishMove = false;
                                game.sendAction(new ConfirmSelectionAction(this));
                            }
                        }

                        //if there are tracks the player wants, but they're still in card mode,
                        //change the mode
                        else if(!compState.getTrackModeSelected()){
                            game.sendAction(new ChangeModeAction(this));
                        }

                        //if the player is in the correct mode, select a track that the player wants
                        else{
                            finishMove = true;
                            game.sendAction(new TrackPlaceAction(this, trackColor, trainPosition));
                        }
                    }

                    //confirmSelectionActions
                    else{

                        //if the player couldn't find any tracks they wanted they could get,
                        //take their selected cards.
                        if(noTracks) {
                            moveStarted = false;
                            finishMove = false;
                            game.sendAction(new ConfirmSelectionAction(this));
                        }

                        //if they did find track
                        else{
                            moveStarted = false;
                            finishMove = false;
                            //take a track
                            if(trackColor.equals("Gray")) {
                                game.sendAction(new ConfirmSelectionAction(this, chosenColor, trainHand[8]));
                            }
                            else{
                                game.sendAction(new ConfirmSelectionAction(this, trainHand[8]));
                            }
                        }
                    }
                }

                //if the computer player is dumb and the game has started, enter here.
                else if(!isDifficult && compState.getGameStart() && !destinations){

                    //the dumb AI picks a random move
                    if(!moveStarted){

                        //if no tracks were found on one run through, make it so that it will
                        //not enter the code that lets it choose random tracks
                        if(noTracks){
                            currentMove = rand.nextInt(75);
                        }
                        else {
                            currentMove = rand.nextInt(100);
                        }
                    }

                    //enter here if the move is to place tracks
                    if(currentMove > 75){
                        moveStarted = true;

                        //if not already in train selection mode, change the mode
                        if(!compState.getTrackModeSelected()){
                            game.sendAction(new ChangeModeAction(this));
                        }

                        //if a track has been found, send the appropriate action.
                        else if(!finishMove){
                            rainbowCount = compState.getTrainColorCount("Rainbow", this.playerNum);
                            for(int i = 0; i < compState.getTracks().size(); i++){
                                String trainColor = compState.getTracks().get(i).getTrackColor();
                                if(!compState.getTracks().get(i).getCovered() && !foundTrack) {

                                    //if the track is gray, determine if it can be claimed using
                                    //the appropriate color cards and available rainbow cards.
                                    if (trainColor.equals("Gray")) {
                                        for (int j = 0; j < colors.length; j++) {
                                            if ((compState.getTrainColorCount(colors[j], this.playerNum) + rainbowCount)
                                                    >= compState.getTracks().get(i).getTrainTrackNum()
                                                    && !foundTrack) {
                                                finishMove = true;
                                                chosenColor = colors[j];
                                                foundTrack = true;
                                                game.sendAction(new TrackPlaceAction(this, chosenColor, i));
                                            }
                                        }
                                    }

                                    //if the track is not gray, determine if it can be claimed with the
                                    //current cards in the player's hands.
                                    else {
                                        for (int j = 0; j < colors.length - 1; j++) {
                                            if (compState.getTrainColorCount(colors[j], this.playerNum)
                                                    >= compState.getTracks().get(i).getTrainTrackNum()
                                                    && !foundTrack) {
                                                finishMove = true;
                                                chosenColor = colors[j];
                                                foundTrack = true;
                                                game.sendAction(new TrackPlaceAction(this, chosenColor, i));
                                            } else if ((compState.getTrainColorCount(colors[j], this.playerNum) + rainbowCount)
                                                    >= compState.getTracks().get(i).getTrainTrackNum()
                                                    && !foundTrack) {
                                                finishMove = true;
                                                chosenColor = colors[j];
                                                foundTrack = true;
                                                game.sendAction(new TrackPlaceAction(this, chosenColor, i));
                                            }
                                        }
                                    }
                                }
                            }
                            //if no tracks were found, change the noTracks boolean to true and
                            //change modes
                            if(!finishMove){
                                noTracks = true;
                                moveStarted = false;
                                game.sendAction(new ChangeModeAction(this));
                            }
                        }
                        //if a track was found and chosen, confirm the selection
                        else{
                            moveStarted = false;
                            noTracks = false;
                            finishMove = false;
                            currentMove = 0;
                            foundTrack = false;
                            game.sendAction(new ConfirmSelectionAction(this, chosenColor, rainbowCount));
                        }
                    }

                   //enter here if drawing cards from down deck
                    else if(currentMove > 40){

                        //indicate the move has started
                        moveStarted = true;

                        //change the mode if in track mode
                        if(compState.getTrackModeSelected()){
                            game.sendAction(new ChangeModeAction(this));
                        }
                        //if the move has not been done, select the face down cards
                        else if(!finishMove){
                            finishMove = true;
                            game.sendAction(new DrawDownCardAction(this));
                        }

                        //if the move is finished, confirm the selection
                        else{
                            moveStarted = false;
                            noTracks = false;
                            finishMove = false;
                            currentMove = 0;
                            foundTrack = false;
                            game.sendAction(new ConfirmSelectionAction(this));
                        }
                    }

                    //if selecting cards from the face up deck or a combination enter here
                    else if(currentMove > 2){
                        moveStarted = true;

                        //change the mode if necessary
                        if(compState.getTrackModeSelected()){
                            game.sendAction(new ChangeModeAction(this));
                        }

                        //if cards still need to be drawn, enter here
                        else if(!finishMove){
                            int selectedCards = 0;
                            for (int i = 0; i < compState.getFaceUpTrainCards().size(); i++) {
                                if (compState.getFaceUpTrainCards().getCards().get(i).getHighlight()) {

                                    //if the player randomly choose a rainbow card, take it right away
                                    if (compState.getFaceUpTrainCards().getCards().get(i).toString().equals("Rainbow")) {
                                        selectedCards = 2;
                                    } else {
                                        selectedCards++;
                                    }
                                }
                            }
                            //if the player is taking from the down deck, increment selectedCards
                            //accordingly.
                            if (compState.getOnlyDownDeck()) {
                                selectedCards = 2;
                            } else if (compState.getFaceDownTrainCards().getHighlight()) {
                                selectedCards++;
                            }

                            //if not enough cards have been selected, randomly choose from the face up deck.
                            if(selectedCards < 2){

                                //75% chance of drawing from face up cards
                                if(Math.random() < .75 || compState.getFaceDownTrainCards().getHighlight()){
                                    int num = rand.nextInt(5);
                                    if(compState.getFaceUpTrainCards().getCards().get(num).toString().equals("Rainbow") && selectedCards == 0){
                                        selectedCards = selectedCards + 2;
                                    }
                                    else {
                                        selectedCards++;
                                    }
                                    game.sendAction(new DrawUpCardAction(this, num));
                                }

                                //if not from face up, draw face down cards
                                else if(!compState.getFaceDownTrainCards().getHighlight()){
                                    if(selectedCards == 0){
                                        selectedCards = selectedCards + 2;
                                    }
                                    else {
                                        selectedCards++;
                                    }
                                    game.sendAction(new DrawDownCardAction(this));
                                }

                                //if enough cards have been selected, finish the move
                                if(selectedCards ==2){
                                    finishMove = true;
                                }
                            }
                        }

                        //send a confirm selection if enough cards have been selected
                        else{
                            moveStarted = false;
                            noTracks = false;
                            finishMove = false;
                            currentMove = 0;
                            foundTrack = false;
                            game.sendAction(new ConfirmSelectionAction(this));
                        }
                    }

                    //if no other actions, take more destination cards.
                    else{
                        moveStarted = true;
                        destinations = true;
                        game.sendAction(new DrawDestinationCardAction(this));
                    }
                }

                //if selecting destination cards, enter here
                else{
                    //pull three cards from the deck in the game state
                    Deck tempDeck = new Deck("temp");
                    compState.getDestinationCards().moveTopCardTo(tempDeck, compState.getDestinationCards());
                    compState.getDestinationCards().moveTopCardTo(tempDeck, compState.getDestinationCards());
                    compState.getDestinationCards().moveTopCardTo(tempDeck, compState.getDestinationCards());

                    //depending on if its the start or middle of the game, the minimum number
                    //of cards to select must be enforced.
                    int minimum = 0;
                    if(compState.getGameStart()){ minimum = 1; }
                    else{ minimum = 2; }
                    int numSelected = 0;

                    //randomly select destination cards until the minimum number has been selected
                    while(numSelected < minimum) {
                        for (int i = 0; i < tempDeck.size(); i++) {
                            if (Math.random() < 0.8) {
                                if(!tempDeck.getCards().get(i).getHighlight()) {
                                    tempDeck.getCards().get(i).setHighlight(true);
                                    numSelected++;
                                }
                            }
                        }
                    }

                    //add the cards to the players hand and create an array keeping track of
                    //which cards have been completed
                    Card[] tempCards = new Card[numSelected];
                    completed = new boolean[numSelected + compState.getPlayerDestinationDecks()[this.playerNum].size()];
                    for(int i = 0; i < compState.getPlayerDestinationDecks()[this.playerNum].size(); i++){
                        completed[i] = true;
                    }
                    int count = compState.getPlayerDestinationDecks()[this.playerNum].size();
                    int count2 = 0;
                    for(int i = 0; i < tempDeck.size(); i++){
                        if(tempDeck.getCards().get(i).getHighlight()){
                            tempCards[count2] = tempDeck.getCards().get(i);
                            completed[count] = false;
                            count++;
                            count2++;
                        }
                    }
                    Deck sendDeck = new Deck("Sending", tempCards);
                    currentMove = 0;
                    destinations = false;
                    moveStarted = false;
                    noTracks = false;
                    finishMove = false;
                    currentMove = 0;
                    foundTrack = false;
                    game.sendAction(new ConfirmSelectionAction(this, sendDeck, tempDeck));
                }
            }
        }
    }

    /**
     * Finds the best move for the player given the situation they are in
     *
     */
    protected void findBestMove(){

        //check to see if all of the destination cards have been found
        boolean needCards = true;
        for(int i = 0; i < completed.length; i++){
            if(!completed[i]){
                needCards = false;
            }
        }

        //if the player does not need destination cards, enter here
        if(!needCards) {

            //find the card that has the shortest distance between the two points, therefore,
            //being the easiest to accomplish
            int shortestCard = 0;
            int shortestDistance = -1;
            for (int i = 0; i < compState.getPlayerDestinationDecks()[this.playerNum].size(); i++) {
                //check to see if the card has been reached already
                reachable(i);

                //if it has not been reached, run through and find the two destinations in terms
                //of the destNames list.
                if (!completed[i]) {
                    DestinationCards lookCard =
                            (DestinationCards) compState.getPlayerDestinationDecks()[this.playerNum].getCards().get(i);
                    String city1 = lookCard.getCity1();
                    String city2 = lookCard.getCity2();
                    int cityPos1 = -1;
                    int cityPos2 = -1;
                    for (int j = 0; j < destNames.size(); j++) {
                        if (city1.equals(destNames.get(j))) {
                            cityPos1 = j;
                        } else if (city2.equals(destNames.get(j))) {
                            cityPos2 = j;
                        }
                    }

                    //once the destinations have been found, perform dijkstra on the first city
                    compDijkstra.dijkstra(cityPos1);

                    //if the distance between city1 and city2 is smaller than the last, save
                    //the new card to try and accomplish
                    if (shortestDistance == -1 ||
                            computerGraph.getVertexes().get(cityPos2).getDistance() < shortestDistance) {
                        shortestDistance = computerGraph.getVertexes().get(cityPos2).getDistance();
                        shortestCard = i;
                    }
                }
            }

            //using the current card that is trying to be accomplished. get the two destinations
            //positions in the list Vertexes
            currentCard = (DestinationCards) compState.getPlayerDestinationDecks()[this.playerNum].getCards().get(shortestCard);
            String city1 = currentCard.getCity1();
            String city2 = currentCard.getCity2();
            int cityPos1 = -1;
            int cityPos2 = -1;
            for (int j = 0; j < destNames.size(); j++) {
                if (city1.equals(destNames.get(j))) {
                    cityPos1 = j;
                } else if (city2.equals(destNames.get(j))) {
                    cityPos2 = j;
                }
            }

            //once the cities have been found, get all of the edges between the two points.
            ArrayList<Edge> getTracks = compDijkstra.getEdges(cityPos1, cityPos2);

            //Create a list of all the tracks the player will need to accomplish a destination card
            ArrayList<Track> neededTracks = new ArrayList<Track>();
            int count = 0;

            //if a track has not already been claimed, add it to the list of needed tracks.
            for (Edge edge : getTracks) {
                if (!edge.getTrack().getCovered()) {
                    neededTracks.add(edge.getTrack());
                    Log.i("Track: ", neededTracks.get(count).getStartCity() + " to " + neededTracks.get(count).getEndCity());
                    count++;
                }
            }

            //get the current hand of the player
            getTrainHand();
            boolean entered = false;

            //see if the player has enough of a certain color to claim any of the needed tracks.
            for (int i = 0; i < neededTracks.size(); i++) {
                for (int j = 0; j < trainHand.length - 1; j++) {
                    if ((trainHand[j] + trainHand[8]) >= neededTracks.get(i).getTrainTrackNum()
                            && (colors[j].equals(neededTracks.get(i).getTrackColor())
                            || neededTracks.get(i).getTrackColor().equals("Gray"))) {
                        noTracks = false;
                        entered = true;
                        trackColor = neededTracks.get(i).getTrackColor();
                        chosenColor = destNames.get(j);
                        trainPosition = compState.getTrackPosition(
                                neededTracks.get(i).getStartCity(), neededTracks.get(i).getEndCity());
                        moveStarted = true;
                    }

                    //if the player does not have enough cards to claim one of the tracks, show in
                    //the array of booleans that the player needs that color of cards.
                    else if (colors[j].equals(neededTracks.get(i).getTrackColor())) {
                        neededCards[j] = true;
                    }
                }
            }

            neededTracks.clear();

            //if none of the tracks could be claimed, change noTracks to true, so the player
            //will choose cards instead
            if (!entered) {
                noTracks = true;
                moveStarted = true;
            }
        }

        //if the player has ran out of routes to finish, get more destination cards
        else{
            destinations = true;
        }
    }

    /**
     * Gets a numerical count of the number of each color of card the player has. The number they
     * have of each color is put into an array.
     */
    private void getTrainHand(){
        for(int i = 0; i < trainHand.length; i++){
            String color = colors[i];
            trainHand[i] = compState.getTrainColorCount(color, this.playerNum);
        }
    }

    /**
     * Takes in two positions and returns all of the edges of the shortest path between them
     *
     * @param cardPos the position of the card within the list that represents the
     *                players destination cards hand.
     */
    private void reachable(int cardPos){

        //create a list for all the edges
        ArrayList<Edge> reachEdgeList = new ArrayList<Edge>();
        Vertex startCity = null;
        Vertex endCity = null;

        //Add to the list of edges any edges owned by the player
        for(int i = 0; i < compState.getTracks().size(); i++){
            String city1 = compState.getTracks().get(i).getStartCity();
            String city2 = compState.getTracks().get(i).getEndCity();
            for(Vertex vert: computerGraph.getVertexes()){
                int spot = vert.getId();
                if(city1.equals(destNames.get(spot))
                        && compState.getTracks().get(i).getPlayerID() == this.playerNum
                        && startCity == null){
                    startCity = vert;
                }
                else if(city2.equals(destNames.get(spot))
                        && compState.getTracks().get(i).getPlayerID() == this.playerNum
                        && endCity == null){
                    endCity = vert;
                }
            }
            Edge temporary = null;
            if(startCity != null && endCity != null) {
                temporary = new Edge(compState.getTracks().get(i),startCity, endCity,
                        compState.getTracks().get(i).getTrainTrackNum());
            }
            startCity = null;
            endCity = null;
            if(!reachEdgeList.contains(temporary) && temporary!= null){
                reachEdgeList.add(temporary);
            }
        }

        //Create a Graph and Dijkstra object to evaluate if a point is accessible from another
        DijkstraGraph tempGraph = new DijkstraGraph(computerGraph.getVertexes(), reachEdgeList);
        Dijkstra tempD = new Dijkstra(tempGraph);
        int spot1 = -1;
        int spot2 = -1;

        //local variable of the current destination card trying to be accomplished
        DestinationCards lookCard =
                (DestinationCards) compState.getPlayerDestinationDecks()[this.playerNum].getCards().get(cardPos);

        //find the cities spots in the list of Vertexes
        String city1 = lookCard.getCity1();
        String city2 = lookCard.getCity2();
        for(int j = 0; j < tempGraph.getVertexes().size(); j++) {
            if (tempGraph.getVertexes().get(j).getName().equals(city1)){
                spot1 = j;
            }
            else if(tempGraph.getVertexes().get(j).getName().equals(city2)){
                spot2 = j;
            }
        }

        //perform dijkstra on the first city of the destination card
        tempD.dijkstra(spot1);

        //As long as there are edges for this graph, enter
        if(!tempD.getMyGraph().getEdges().isEmpty()) {

            //if the firs city is the source, enter and then see if the distance of the second city
            //is not equal to the max number unsigned in the dijkstra function. If it is not
            //the max number, the second city is reachable from the first and the card has been completed.
            if (tempD.getMyGraph().getVertexes().get(spot1).getDistance() == 0) {
                if (tempD.getMyGraph().getVertexes().get(spot2).getDistance() != 100000000) {
                    completed[cardPos] = true;
                }
            } else if (tempD.getMyGraph().getVertexes().get(spot2).getDistance() == 0) {
                if (tempD.getMyGraph().getVertexes().get(spot1).getDistance() != 100000000) {
                    completed[cardPos] = true;
                }
            }
        }
    }
}