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

    private boolean isDifficult;
    private Random rand;
    private boolean moveStarted;
    private boolean finishMove;
    private int currentMove;
    private int rainbowCount;
    private String chosenColor;
    private boolean noTracks;
    private String[] colors = new String[]{"Red", "Orange", "Yellow", "Green", "Blue", "Pink",
            "White", "Black", "Rainbow"};
    private final ArrayList<String> destNames = new ArrayList<String>(Arrays.asList("Denver", "El Paso", "Kansas City",
            "Houston", "New York", "Atlanta", "Chicago", "New Orleans", "Calgary",
            "Salt Lake City", "Helena", "Los Angeles", "Duluth", "Sault Ste Marie",
            "Nashville", "Montreal", "Oklahoma City", "Seattle", "Santa Fe",
            "Toronto", "Miami", "Portland", "Phoenix", "Dallas",
            "Pittsburgh", "Winnipeg", "Little Rock", "Boston", "Vancouver",
            "San Francisco", "Las Vegas", "Washington", "Raleigh", "Charleston",
            "Saint Louis", "Omaha"));
    private boolean destinations;
    private boolean foundTrack;
    private DijkstraGraph computerGraph;
    private Dijkstra compDijkstra;
    private TTRGameState compState;
    private DestinationCards currentCard;
    private boolean[] completed;
    private int[] trainHand = new int[9];
    private int trainPosition;
    private String trackColor;
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
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if(info instanceof GameState) {
            compState = (TTRGameState) info;
            if(compState.getPlayerID() == this.playerNum){
                this.sleep(1000);
                if(isDifficult && compState.getGameStart() && !destinations){
                    ArrayList<Vertex> myVertexList = new ArrayList<Vertex>();
                    ArrayList<Edge> myEdgeList = new ArrayList<Edge>();
                    Vertex temp = null;
                    for(int i = 0; i < destNames.size(); i++){
                        temp = new Vertex(destNames.get(i),i);
                            myVertexList.add(temp);
                    }
                    Vertex startCity = null;
                    Vertex endCity = null;
                    for(int i = 0; i < compState.getTracks().length; i++){
                        String city1 = compState.getTracks()[i].getStartCity();
                        String city2 = compState.getTracks()[i].getEndCity();
                        for(Vertex vert: myVertexList){
                            int spot = vert.getId();
                            if(city1.equals(destNames.get(spot))
                                    && (compState.getTracks()[i].getPlayerID() == -1
                                    || compState.getTracks()[i].getPlayerID() == this.playerNum)
                                    && startCity == null){
                                startCity = vert;
                            }
                            else if(city2.equals(destNames.get(spot))
                                    && (compState.getTracks()[i].getPlayerID() == -1
                                    || compState.getTracks()[i].getPlayerID() == this.playerNum)
                                    && endCity == null){
                                endCity = vert;
                            }
                        }
                        Edge temporary = null;
                        if(startCity != null && endCity != null) {
                            temporary = new Edge(compState.getTracks()[i],startCity, endCity,
                                    compState.getTracks()[i].getTrainTrackNum());
                        }
                        startCity = null;
                        endCity = null;
                        if(!myEdgeList.contains(temporary) && temporary!= null){
                            myEdgeList.add(temporary);
                        }
                    }
                    computerGraph = new DijkstraGraph(myVertexList, myEdgeList);
                    compDijkstra = new Dijkstra(computerGraph);
                    if(!finishMove && !moveStarted){
                        findBestMove();
                    }
                    if(!finishMove && moveStarted){
                        if(noTracks){
                            int numSelected = 0;
                            for (int i = 0; i < compState.getFaceUpTrainCards().getCards().size(); i++){
                                if(compState.getFaceUpTrainCards().getCards().get(i).getHighlight()){
                                    if(((TrainCards)compState.getFaceUpTrainCards().getCards().get(i))
                                            .getType().equals("Rainbow")) {
                                        numSelected = numSelected + 2;
                                    }
                                    else{
                                        numSelected++;
                                    }
                                }
                            }
                            if(compState.getOnlyDownDeck()){
                                numSelected = numSelected + 2;
                            }
                            else if(compState.getFaceDownTrainCards().getHighlight()){
                                numSelected++;
                            }
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
                            else{
                                finishMove = true;
                            }
                            if(spot != -1){
                                game.sendAction(new DrawUpCardAction(this, spot));
                            }
                            else if(!finishMove){
                                for(int i = 0; i < compState.getFaceUpTrainCards().getCards().size(); i++){
                                    if(((TrainCards)compState.getFaceUpTrainCards().getCards().get(i)).getType().equals("Rainbow")){
                                        spot = i;
                                    }
                                }
                                if(spot != -1){
                                    finishMove = true;
                                    game.sendAction(new DrawUpCardAction(this, spot));
                                }
                                else{
                                    moveStarted = false;
                                    finishMove = false;
                                    game.sendAction(new DrawDownCardAction(this));
                                }
                            }
                            else{
                                //pick up cards(train or destination)
                                moveStarted = false;
                                finishMove = false;
                                game.sendAction(new ConfirmSelectionAction(this));
                            }
                        }
                        else if(!compState.getTrackModeSelected()){
                            finishMove = true;
                            game.sendAction(new ChangeModeAction(this));
                        }
                        else{
                            finishMove = true;
                            game.sendAction(new TrackPlaceAction(this, trackColor, trainPosition));
                        }
                    }
                    else{
                        if(noTracks) {
                            //pick up cards(train or destination)
                            moveStarted = false;
                            finishMove = false;
                            game.sendAction(new ConfirmSelectionAction(this));
                        }
                        else{
                            moveStarted = false;
                            finishMove = false;
                            //take a track
                            if(trackColor.equals("Gray")) {
                                game.sendAction(new ConfirmSelectionAction(this, trainHand[8]));
                            }
                            else{
                                game.sendAction(new ConfirmSelectionAction(this, chosenColor, trainHand[8]));
                            }
                        }
                    }
                }
                else if(!isDifficult && compState.getGameStart() && !destinations){
                    if(!moveStarted){
                        if(noTracks){
                            currentMove = rand.nextInt(75);
                        }
                        else {
                            currentMove = rand.nextInt(100);
                        }
                    }
                    if(currentMove > 75){
                        moveStarted = true;
                        if(!compState.getTrackModeSelected()){
                            game.sendAction(new ChangeModeAction(this));
                        }
                        else if(!finishMove){
                            rainbowCount = compState.getTrainColorCount("Rainbow", this.playerNum);
                            for(int i = 0; i < compState.getTracks().length; i++){
                                String trainColor = compState.getTracks()[i].getTrackColor();
                                if(!compState.getTracks()[i].getCovered() && !foundTrack) {
                                    if (trainColor.equals("Gray")) {
                                        for (int j = 0; j < colors.length; j++) {
                                            if ((compState.getTrainColorCount(colors[j], this.playerNum) + rainbowCount)
                                                    >= compState.getTracks()[i].getTrainTrackNum()
                                                    && !foundTrack) {
                                                finishMove = true;
                                                chosenColor = colors[j];
                                                foundTrack = true;
                                                game.sendAction(new TrackPlaceAction(this, chosenColor, i));
                                            }
                                        }
                                    } else {
                                        for (int j = 0; j < colors.length - 1; j++) {
                                            if (compState.getTrainColorCount(colors[j], this.playerNum)
                                                    >= compState.getTracks()[i].getTrainTrackNum()
                                                    && !foundTrack) {
                                                finishMove = true;
                                                chosenColor = colors[j];
                                                foundTrack = true;
                                                game.sendAction(new TrackPlaceAction(this, chosenColor, i));
                                            } else if ((compState.getTrainColorCount(colors[j], this.playerNum) + rainbowCount)
                                                    >= compState.getTracks()[i].getTrainTrackNum()
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
                            if(!finishMove){
                                noTracks = true;
                                moveStarted = false;
                                game.sendAction(new ChangeModeAction(this));
                            }
                        }
                        else{
                            moveStarted = false;
                            noTracks = false;
                            finishMove = false;
                            currentMove = 0;
                            foundTrack = false;
                            game.sendAction(new ConfirmSelectionAction(this, chosenColor, rainbowCount));
                        }
                    }
                    else if(currentMove > 40){
                        moveStarted = true;
                        if(compState.getTrackModeSelected()){
                            game.sendAction(new ChangeModeAction(this));
                        }
                        else if(!finishMove){
                            finishMove = true;
                            game.sendAction(new DrawDownCardAction(this));
                        }
                        else{
                            moveStarted = false;
                            noTracks = false;
                            finishMove = false;
                            currentMove = 0;
                            foundTrack = false;
                            game.sendAction(new ConfirmSelectionAction(this));
                        }
                    }
                    else if(currentMove > 2){
                        moveStarted = true;
                        if(compState.getTrackModeSelected()){
                            game.sendAction(new ChangeModeAction(this));
                        }
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
                            if(selectedCards < 2){
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
                                else if(!compState.getFaceDownTrainCards().getHighlight()){
                                    if(selectedCards == 0){
                                        selectedCards = selectedCards + 2;
                                    }
                                    else {
                                        selectedCards++;
                                    }
                                    game.sendAction(new DrawDownCardAction(this));
                                }
                                if(selectedCards ==2){
                                    finishMove = true;
                                }
                            }
                        }
                        else{
                            moveStarted = false;
                            noTracks = false;
                            finishMove = false;
                            currentMove = 0;
                            foundTrack = false;
                            game.sendAction(new ConfirmSelectionAction(this));
                        }
                    }
                    else{
                        moveStarted = true;
                        destinations = true;
                        game.sendAction(new DrawDestinationCardAction(this));
                    }
                }
                else{
                    Deck tempDeck = new Deck("temp");
                    compState.getDestinationCards().moveTopCardTo(tempDeck, compState.getDestinationCards());
                    compState.getDestinationCards().moveTopCardTo(tempDeck, compState.getDestinationCards());
                    compState.getDestinationCards().moveTopCardTo(tempDeck, compState.getDestinationCards());
                    int minimum = 0;
                    if(compState.getGameStart()){ minimum = 1; }
                    else{ minimum = 2; }
                    int numSelected = 0;
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
                    Card[] tempCards = new Card[numSelected];
                    completed = new boolean[numSelected];
                    int count=0;
                    for(int i = 0; i < tempDeck.size(); i++){
                        if(tempDeck.getCards().get(i).getHighlight()){
                            tempCards[count] = tempDeck.getCards().get(i);
                            completed[count] = false;
                            count++;
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

    protected void findBestMove(){
        /*
        2. If the computer player has the necessary cards to take another
           piece of track on the path to their destination, claim that track.
           a. First see which tracks are the easiest to get.
         */
        boolean needCards = true;
        for(int i = 0; i < completed.length; i++){
            if(!completed[i]){
                needCards = false;
            }
        }
        if(!needCards) {
            int shortestCard = 0;
            int shortestDistance = -1;
            for (int i = 0; i < compState.getPlayerDestinationDecks()[this.playerNum].size(); i++) {
                reachable(i);
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
                    compDijkstra.dijkstra(cityPos1);
                    if (shortestDistance == -1 ||
                            computerGraph.getVertexes().get(cityPos2).getDistance() < shortestDistance) {
                        shortestDistance = computerGraph.getVertexes().get(cityPos2).getDistance();
                        shortestCard = i;
                    }
                }
            }
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
            ArrayList<Edge> getTracks = compDijkstra.getEdges(cityPos1, cityPos2);

            ArrayList<Track> neededTracks = new ArrayList<Track>();
            int count = 0;
            for (Edge edge : getTracks) {
                if (!edge.getTrack().getCovered()) {
                    neededTracks.add(edge.getTrack());
                    Log.i("Track: ", neededTracks.get(count).getStartCity() + " to " + neededTracks.get(count).getEndCity());
                    count++;
                }
            }
            getTrainHand();
            boolean entered = false;
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
                    } else if (colors[j].equals(neededTracks.get(i).getTrackColor())) {
                        neededCards[j] = true;
                    }
                }
            }
            while (!neededTracks.isEmpty()) {
                neededTracks.remove(0);
            }
            if (!entered) {
                noTracks = true;
                moveStarted = true;
            }
        }
        else{
            destinations = true;
        }
//        if(noTracks){
//
//        }
        /*
        3. If the computer player does not have the necessary cards, assess what
           cards it needs.
           a. if the cards it needs to claim more tracks are available amongst the
              face up cards, take those cards.
           b. if the cards it needs to claim more tracks are not in the face up cards,
              take from the face down deck.
           c. Potential for harder AI: 50-50 chance the AI can peek at the top two cards.
                i. if the top two cards contain a rainbow card, take the down only deck.
                ii. if the face up cards did not contain the necessary cards to claim
                    tracks, player takes the top two face down cards or a rainbow card
                    if present in the face up cards.
        4. If the player has accomplished all their routes or some routes are unattainable,
           draw more destination cards.
           a. calculate which routes will be attainable given number of train tokens.
                i. if more than one can be attained, take one with the highest score.
                ii. if all three can be attained, take one with middle highest score.
                iii. if none can be attained, draw one with lowest score and set mode to
                     simply try to get the longest route.
                     //TODO
                     implement code in DijkstraGraph to allow player to try and connect
                     tracks as much as possible.
                iv. if there are two reasonably attainable cards(i.e. could finish with
                    more than 6-10 train tokens left on shortest path), take both.
         */
    }

    private void getTrainHand(){
        for(int i = 0; i < trainHand.length; i++){
            String color = colors[i];
            trainHand[i] = compState.getTrainColorCount(color, this.playerNum);
            Log.i("Number of ", color + trainHand[i]);
        }
    }

    private void reachable(int cardPos){
        ArrayList<Edge> reachEdgeList = new ArrayList<Edge>();
        Vertex startCity = null;
        Vertex endCity = null;
        for(int i = 0; i < compState.getTracks().length; i++){
            String city1 = compState.getTracks()[i].getStartCity();
            String city2 = compState.getTracks()[i].getEndCity();
            for(Vertex vert: computerGraph.getVertexes()){
                int spot = vert.getId();
                if(city1.equals(destNames.get(spot))
                        && compState.getTracks()[i].getPlayerID() == this.playerNum
                        && startCity == null){
                    startCity = vert;
                }
                else if(city2.equals(destNames.get(spot))
                        && compState.getTracks()[i].getPlayerID() == this.playerNum
                        && endCity == null){
                    endCity = vert;
                }
            }
            Edge temporary = null;
            if(startCity != null && endCity != null) {
                temporary = new Edge(compState.getTracks()[i],startCity, endCity,
                        compState.getTracks()[i].getTrainTrackNum());
            }
            startCity = null;
            endCity = null;
            if(!reachEdgeList.contains(temporary) && temporary!= null){
                reachEdgeList.add(temporary);
            }
        }
        DijkstraGraph tempGraph = new DijkstraGraph(computerGraph.getVertexes(), reachEdgeList);
        Dijkstra tempD = new Dijkstra(tempGraph);
        int spot1 = -1;
        int spot2 = -1;
        DestinationCards lookCard =
                (DestinationCards) compState.getPlayerDestinationDecks()[this.playerNum].getCards().get(cardPos);
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
        tempD.dijkstra(spot1);
        if(!tempD.getMyGraph().getEdges().isEmpty()) {
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