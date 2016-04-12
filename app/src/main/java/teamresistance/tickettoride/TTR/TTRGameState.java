package teamresistance.tickettoride.TTR;

import android.graphics.Path;
import android.graphics.Rect;

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
    protected int maxX = 1720;
    protected int maxY = 980;

    Rect touchArea5 = new Rect(0,0,1,1);
    Rect vancouverToSeattleRect = new Rect((int)(maxX*.0), (int)(maxY*.1), (int)(maxX*.1), (int)(maxY*.2));
    Rect sanFranciscoToPortlandRect = new Rect((int)(maxX*.0), (int)(maxY*.290), (int)(maxX*.05), (int)(maxY*.8));
    Rect sanFranciscoToLosAngelesRect = new Rect((int)(maxX*.0),(int)(maxY*.6), (int)(maxX*.1), (int)(maxY*.8));
    Rect losAngelesToPhoenixRect = new Rect((int)(maxX*.11), (int)(maxY*.75), (int)(maxX*.23), (int)(maxY*.8));
    Rect montrealtoBostonRect = new Rect((int)(maxX * .91), (int)(maxY * .06), (int)(maxX * .99), (int)(maxY * .18));
    Rect montrealtoNewYorkRect = new Rect((int)(maxX * .895), (int)(maxY * .08), (int)(maxX * .93), (int)(maxY * .27));
    Rect losAngelesToLasVegasRect = new Rect((int)(maxX * .11), (int)(maxY * .67), (int)(maxX * .175), (int)(maxY * .755));
    Rect newYorkToBostonRect = new Rect((int)(maxX * .95), (int)(maxY * .18), (int)(maxX * 1.0), (int)(maxY * .29));
    Rect newYorkToWashingtonRect = new Rect((int)(maxX * .93), (int)(maxY * .298), (int)(maxX * .96), (int)(maxY * .42));
    Rect raleighToWashingtonRect = new Rect((int)(maxX * .87), (int)(maxY * .43), (int)(maxX * .95), (int)(maxY * .55));
    Rect raleighToCharlestonRect = new Rect((int)(maxX * .875), (int)(maxY * .55), (int)(maxX * .94), (int)(maxY * .655));
    Rect miamiToChaelestonRect = new Rect((int)(maxX * .89), (int)(maxY * .655), (int)(maxX * .955), (int)(maxY * .91));
    Rect atlantaToMiamiRect = new Rect((int)(maxX * .8), (int)(maxY * .7), (int)(maxX * .9), (int)(maxY * .8));
    Rect atlantaToCharlestonRect = new Rect((int)(maxX * .81), (int)(maxY * .64), (int)(maxX * .9), (int)(maxY * .685));
    Rect raleighToAtlantaRect = new Rect((int)(maxX * .8), (int)(maxY * .54), (int)(maxX * .88), (int)(maxY * .65));
    Rect pittsburghToRaleighRect = new Rect((int)(maxX * .845), (int)(maxY * .39), (int)(maxX * .865), (int)(maxY * .51));
    Rect pittsburghToWashingtonRect = new Rect((int)(maxX * .85), (int)(maxY * .35), (int)(maxX * .93), (int)(maxY * .43));
    Rect pittsburghToNewYorkRect = new Rect((int)(maxX * .845), (int)(maxY * .26), (int)(maxX * .925), (int)(maxY * .35));
    Rect torontoToPittsburghRect = new Rect((int)(maxX * .815), (int)(maxY * .2), (int)(maxX * .835), (int)(maxY * .35));
    Rect torontoToMontrealRect = new Rect((int)(maxX * .805), (int)(maxY * .06), (int)(maxX * .905), (int)(maxY * .2));
    Rect saultSteMarieToMontrealRect = new Rect((int)(maxX * .7), (int)(maxY * .04), (int)(maxX * .9), (int)(maxY * .15));
    Rect newOrleansToMiamiRect = new Rect((int)(maxX * .725), (int)(maxY * .8), (int)(maxX * .88), (int)(maxY * .88));
    Rect losAngelesToElPasoRect = new Rect((int)(maxX * .12), (int)(maxY * .79), (int)(maxX * .33), (int)(maxY * .9));
    Rect seattleToPortlandRect = new Rect((int)(maxX * .0), (int)(maxY * .19), (int)(maxX * .075), (int)(maxY * .279));
    Rect vancouverToCalgaryRect = new Rect((int)(maxX * .08), (int)(maxY * .0), (int)(maxX * .2), (int)(maxY * .1));
    Rect seattleToCalgaryRect = new Rect((int)(maxX * .08), (int)(maxY * .1), (int)(maxX * .22), (int)(maxY * .19));
    private Path GRID = new Path();
    //THE WEST!
    private Path vancouverToCalgary = new Path();
    private Path vancouverToSeattle = new Path();
    private Path seattleToCalgary = new Path();
    private Path seattleToHelena = new Path();
    private Path seattleToPortland= new Path();
    private Path portlandToSanFrancisco = new Path();
    private Path portlandToSaltLakeCity = new Path();
    private Path sanFranciscoToLosAngeles = new Path();
    private Path sanFranciscoToSaltLakeCity = new Path();
    private Path losAngelesToLasVegas = new Path();
    private Path losAngelesToPheonix = new Path();
    private Path losAngelesToElPaso = new Path();
    //mid-west paths
    private Path calgaryToWinnipeg = new Path();
    private Path calgaryToHelena = new Path();
    private Path helenaToWinnipeg = new Path();
    private Path helenaToDuluth = new Path();
    private Path helenaToOmaha = new Path();
    private Path helenaToDenver = new Path();
    private Path helenaToSaltLakeCity = new Path();
    private Path saltLakeCityToDenver = new Path();
    private Path saltLakeCityToLasVegas = new Path();
    private Path phoenixToDenver = new Path();
    private Path phoenixToSantaFe = new Path();
    private Path phoeixToElPaso = new Path();
    private Path denverToOmaha = new Path();
    private Path denverToKansasCity = new Path();
    private Path denverToOklahomaCity = new Path();
    private Path denverToSantaFe = new Path();
    private Path santaFeToOklahomaCity = new Path();
    private Path santaFeToElPaso = new Path();
    private Path elPasoToOklahomaCity = new Path();
    private Path elPasoToDallas = new Path();
    private Path elPasoToHouston = new Path();
    //fly-over state paths
    private Path winnipegToSaultSteMarie = new Path();
    private Path winnipegToDuluth = new Path();
    private Path duluthToSaultSteMarie = new Path();
    private Path duluthToToronto = new Path();
    private Path duluthToChicago = new Path();
    private Path duluthToOmaha = new Path();
    private Path omahaToChicago = new Path();
    private Path omahatoKansasCity = new Path();
    private Path kansasCityToSaintLouise = new Path();
    private Path kansasCityToOklahomaCity = new Path();
    private Path oklahomaCityToLittleRock = new Path();
    private Path oklahomaCityToDallas = new Path();
    private Path dallasToLittleRock = new Path();
    private Path dallasToHouston = new Path();
    private Path houstonToNewOrlean = new Path();
    //Mississippi
    private Path saultSteMarieToMontreal = new Path();
    private Path saultSteMarieToToronto = new Path();
    private Path chicagoToToronto = new Path();
    private Path chicagoToPittsburgh = new Path();
    private Path chicagoToSaintLouis = new Path();
    private Path saintLouisToPittsburgh = new Path();
    private Path saintLouisToNashville = new Path();
    private Path saintLouisToLittleRock = new Path();
    private Path nashvilleToPittsburgh = new Path();
    private Path nashvilleToRaleigh = new Path();
    private Path nashvilleToAtlanta = new Path();
    private Path littleRockToNashville = new Path();
    private Path littleRockToNewOrleans = new Path();
    private Path newOrleansToAtlanta = new Path();
    private Path newOrleansToMiami = new Path();
    //Appalachia
    private Path torontoToMontreal = new Path();
    private Path torontoToPittsburgh = new Path();
    private Path pittsburghToNewYork = new Path();
    private Path pittsburghToWashington = new Path();
    private Path pittsburghToRaleigh = new Path();
    private Path raleighToWashington = new Path();
    private Path raleighToCharleston = new Path();
    private Path raleighToAtlanta = new Path();
    private Path atlantaToCharleston = new Path();
    private Path atlantaToMiami = new Path();
    private Path miamiToCharleston = new Path();
    //NorthEast
    private Path montrealToBoston = new Path();
    private Path montrealToNewYork = new Path();
    private Path newYorkToBoston = new Path();
    private Path newYorkToWashington = new Path();

    Track GRID_TRACK;
    //THE WEST
    Track vancouverToCalgaryTrack;
    Track vancouverToSeattleTrack;
    Track seattleToCalgaryTrack;
    Track seattleToHelenaTrack;
    Track seattleToPortlandTrack;
    Track portlandToSanFranciscoTrack;
    Track portlandToSaltLakeCityTrack;
    Track sanFranciscoToLosAngelesTrack;
    Track sanFranciscoToSaltLakeCityTrack;
    Track losAngelesToLasVegasTrack;
    Track losAngelesToPhoenixTrack;
    Track losAngelesToElPasoTrack;
    //mid-west tracks
    Track calgaryToWinnipegTrack;
    Track calgaryToHelenaTrack;
    Track helenaToWinnipegTrack;
    Track helenaToDuluthTrack;
    Track helenaToOmahaTrack;
    Track helenaToDenverTrack;
    Track helenaToSaltLakeCityTrack;
    Track saltLakeCityToDenverTrack;
    Track saltLakeCityToLasVegasTrack;
    Track phoenixToDenverTrack;
    Track phoenixToSantaFeTrack;
    Track phoeixToElPasoTrack;
    Track denverToOmahaTrack;
    Track denverToKansasCityTrack;
    Track denverToOklahomaCityTrack;
    Track denverToSantaFeTrack;
    Track santaFeToOklahomaCityTrack;
    Track santaFeToElPasoTrack;
    Track elPasoToOklahomaCityTrack;
    Track elPasoToDallasTrack;
    Track elPasoToHoustonTrack;
    //fly-over state tracks
    Track winnipegToSaultSteMarieTrack;
    Track winnipegToDuluthTrack;
    Track duluthToSaultSteMarieTrack;
    Track duluthToTorontoTrack;
    Track duluthToChicagoTrack;
    Track duluthToOmahaTrack;
    Track omahaToChicagoTrack;
    Track omahatoKansasCityTrack;
    Track kansasCityToSaintLouiseTrack;
    Track kansasCityToOklahomaCityTrack;
    Track oklahomaCityToLittleRockTrack;
    Track oklahomaCityToDallasTrack;
    Track dallasToLittleRockTrack;
    Track dallasToHoustonTrack;
    Track houstonToNewOrleansTrack;
    //Mississippi
    Track saultSteMarieToMontrealTrack;
    Track saultSteMarieToTorontoTrack;
    Track chicagoToTorontoTrack;
    Track chicagoToPittsburghTrack;
    Track chicagoToSaintLouisTrack;
    Track saintLouisToPittsburghTrack;
    Track saintLouisToNashvilleTrack;
    Track saintLouisToLittleRockTrack;
    Track nashvilleToPittsburghTrack;
    Track nashvilleToRaleighTrack;
    Track nashvilleToAtlantaTrack;
    Track littleRockToNashvilleTrack;
    Track littleRockToNewOrleansTracks;
    Track newOrleansToAtlantaTrack;
    Track newOrleansToMiamiTrack;
    //Appalachia
    Track torontoToMontrealTrack;
    Track torontoToPittsburghTrack;
    Track pittsburghToNewYorkTrack;
    Track pittsburghToWashingtonTrack;
    Track pittsburghToRaleighTrack;
    Track raleighToWashingtonTrack;
    Track raleighToCharlestonTrack;
    Track raleighToAtlantaTrack;
    Track atlantaToCharlestonTrack;
    Track atlantaToMiamiTrack;
    Track miamiToCharlestonTrack;
    //NorthEast
    Track montrealToBostonTrack;
    Track montrealToNewYorkTrack;
    Track newYorkToBostonTrack;
    Track newYorkToWashingtonTrack;

    int MAX_NUM_PLAYERS = 4;
    //The first locations labeled on the destination cards
    private int[] destinationCities1 = {1, 3, 4, 7, 9, 11, 13, 14, 16, 14, 18, 7, 13, 20, 22, 24,
            1, 27, 27, 29, 30, 9, 16, 12, 31, 22, 30, 12, 12, 18};

    //The second locations labeled on the destination cards
    private int[] destinationCities2 = {2, 4, 6, 8, 10, 12, 4, 14, 6, 17, 12, 19, 2, 21, 23, 24,
            26, 28, 4, 21, 19, 23, 8, 7, 6, 14, 16, 21, 24, 4};

    //The score values for each of the destination cards
    private int[] destinationValues = {4, 4, 6, 7, 7, 8, 8, 8, 9, 9, 9, 9, 10, 10, 11, 11, 11, 11,
            12, 12, 13, 13, 13, 16, 17, 17, 20, 20, 21, 22};

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
    /** Says if the player needs to be given a pool of destination cards to pick from. Always true at the start since each player needs to choose destination cards. */
    private Boolean isSelectDestinationCards;
    /** If the down deck was clicked on and no face up card was selected, this boolean will say to just pull two cards from the down deck */
    private boolean onlyDownDeck;
    /** The selected track on screen. Set to -1 if no track is selected. */
    private int trackSpot = -1;
    private Boolean isLastRound = false;
    private Boolean isGameOver = false;

    //PARALLEL ARRAYS//
    //array of tracks
    Track myTracks[];
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

        faceDownTrainCards.shuffle();
        faceUpTrainCards = new Deck("Face up Cards");
        //place five train cards 'face up'
        for(int i = 0; i < 5; i++){
            faceDownTrainCards.moveTopCardTo(faceUpTrainCards, faceDownTrainCards);
        }

        /** initialize destination deck */
        //needs to be corrected later
        destinationCards = new Deck("Destination Cards");
        for(int i = 0; i < 30; i++){
            destinationCards.add(new DestinationCards(i, i, i));
        }

        /** initialize array values to max possible size */
        for(int i = 0; i < numPlayers; i++){
            trainTokens[i] = 45;
            scores[i] = 0;
            names[i] = "";
            playerTrainDecks[i] = new Deck("Player " + i + " Train Card Deck");
            playerDestinationDecks[i] = new Deck("Player " + i + " Destination Card Deck");
        }
        trainDiscard = new Deck("Train Card Discard");
        destinationDiscard = new Deck("Destination Card Discard");
        destinationCardsDrawn = new Deck("Destination Cards Drawn");
        destinationPool = new Deck("Destination Card Pool");

        GRID.moveTo(0, maxY * .1f);
        GRID.lineTo(maxX, maxY * .1f);
        GRID.moveTo(0, maxY * .2f);
        GRID.lineTo(maxX, maxY * .2f);
        GRID.moveTo(0, maxY * .3f);
        GRID.lineTo(maxX, maxY*.3f);
        GRID.moveTo(0, maxY*.4f);
        GRID.lineTo(maxX, maxY*.4f);
        GRID.moveTo(0, maxY*.5f);
        GRID.lineTo(maxX, maxY*.5f);
        GRID.moveTo(0, maxY*.6f);
        GRID.lineTo(maxX, maxY*.6f);
        GRID.moveTo(0, maxY*.7f);
        GRID.lineTo(maxX, maxY*.7f);
        GRID.moveTo(0, maxY*.8f);
        GRID.lineTo(maxX, maxY*.8f);
        GRID.moveTo(0, maxY*.9f);
        GRID.lineTo(maxX, maxY*.9f);
        //
        GRID.moveTo(maxX * .1f, 0);
        GRID.lineTo(maxX * .1f, maxY);
        GRID.moveTo(maxX * .2f, 0);
        GRID.lineTo(maxX * .2f, maxY);
        GRID.moveTo(maxX * .3f, 0);
        GRID.lineTo(maxX * .3f, maxY);
        GRID.moveTo(maxX * .4f, 0);
        GRID.lineTo(maxX * .4f, maxY);
        GRID.moveTo(maxX * .5f, 0);
        GRID.lineTo(maxX * .5f, maxY);
        GRID.moveTo(maxX * .6f, 0);
        GRID.lineTo(maxX * .6f, maxY);
        GRID.moveTo(maxX * .7f, 0);
        GRID.lineTo(maxX*.7f, maxY);
        GRID.moveTo(maxX*.8f, 0);
        GRID.lineTo(maxX*.8f, maxY);
        GRID.moveTo(maxX*.9f, 0);
        GRID.lineTo(maxX*.9f, maxY);
        GRID_TRACK = new Track(0, "GRID", "NOWHERE", "NOWHERE", GRID, touchArea5);

        portlandToSanFrancisco.moveTo(maxX * .028f, maxY * .286f);
        portlandToSanFrancisco.lineTo(maxX * .016f, maxY * .333f);
        portlandToSanFrancisco.lineTo(maxX * .026f, maxY * .341f);
        portlandToSanFrancisco.lineTo(maxX * .038f, maxY * .294f);
        portlandToSanFrancisco.close();
        portlandToSanFrancisco.moveTo(maxX * .015f, maxY * .345f);
        portlandToSanFrancisco.lineTo(maxX * .009f, maxY * .398f);
        portlandToSanFrancisco.lineTo(maxX * .019f, maxY * .398f);
        portlandToSanFrancisco.lineTo(maxX * .024f, maxY * .35f);
        portlandToSanFrancisco.close();
        portlandToSanFrancisco.moveTo(maxX * .008f, maxY * .408f);
        portlandToSanFrancisco.lineTo(maxX * .018f, maxY * .408f);
        portlandToSanFrancisco.lineTo(maxX * .017f, maxY * .459f);
        portlandToSanFrancisco.lineTo(maxX * .007f, maxY * .459f);
        portlandToSanFrancisco.close();
        portlandToSanFrancisco.moveTo(maxX * .007f, maxY * .469f);
        portlandToSanFrancisco.lineTo(maxX * .0098f, maxY * .523f);
        portlandToSanFrancisco.lineTo(maxX * .0197f, maxY * .522f);
        portlandToSanFrancisco.lineTo(maxX * .0168f, maxY * .469f);
        portlandToSanFrancisco.close();
        portlandToSanFrancisco.moveTo(maxX * .0105f, maxY * .5336f);
        portlandToSanFrancisco.lineTo(maxX * .0186f, maxY * .579f);
        portlandToSanFrancisco.lineTo(maxX * .029f, maxY * .578f);
        portlandToSanFrancisco.lineTo(maxX * .0215f, maxY * .5285f);
        portlandToSanFrancisco.close();
        portlandToSanFranciscoTrack = new Track(5, "Green", "Portland", "SanFrancisco", portlandToSanFrancisco, sanFranciscoToPortlandRect);

//        vancouverToSeattle.addRect(102f, 115f, 125f, 165f, Path.Direction.CW);
//        vancouverToSeattleTrack = new Track(1, "Gray", "Vancouver", "Seattle", vancouverToSeattle,);

        sanFranciscoToLosAngeles.moveTo(maxX * .029f, maxY * .629f);
        sanFranciscoToLosAngeles.lineTo(maxX * .043f, maxY * .680f);
        sanFranciscoToLosAngeles.lineTo(maxX * .053f, maxY * .675f);
        sanFranciscoToLosAngeles.lineTo(maxX * .038f, maxY * .623f);
        sanFranciscoToLosAngeles.close();
        sanFranciscoToLosAngeles.moveTo(maxX * .043f, maxY * .690f);
        sanFranciscoToLosAngeles.lineTo(maxX * .063f, maxY * .735f);
        sanFranciscoToLosAngeles.lineTo(maxX * .072f, maxY * .725f);
        sanFranciscoToLosAngeles.lineTo(maxX * .053f, maxY * .682f);
        sanFranciscoToLosAngeles.close();
        sanFranciscoToLosAngeles.moveTo(maxX * .067f, maxY * .740f);
        sanFranciscoToLosAngeles.lineTo(maxX * .090f, maxY * .775f);
        sanFranciscoToLosAngeles.lineTo(maxX * .098f, maxY * .770f);
        sanFranciscoToLosAngeles.lineTo(maxX * .076f, maxY * .732f);
        sanFranciscoToLosAngeles.close();
        sanFranciscoToLosAngelesTrack = new Track(3, "Yellow", "SanFrancisco", "LosAngeles",
                sanFranciscoToLosAngeles, sanFranciscoToLosAngelesRect);

        losAngelesToLasVegas.moveTo(maxX * .127f, maxY * .702f);
        losAngelesToLasVegas.lineTo(maxX * .137f, maxY * .707f);
        losAngelesToLasVegas.lineTo(maxX * .124f, maxY * .754f);
        losAngelesToLasVegas.lineTo(maxX * .115f, maxY * .749f);
        losAngelesToLasVegas.close();
        losAngelesToLasVegas.moveTo(maxX * .139f, maxY * .704f);
        losAngelesToLasVegas.lineTo(maxX * .137f, maxY * .685f);
        losAngelesToLasVegas.lineTo(maxX * .170f, maxY * .673f);
        losAngelesToLasVegas.lineTo(maxX * .172f, maxY * .694f);
        losAngelesToLasVegas.close();
        losAngelesToLasVegasTrack = new Track(2, "Gray", "Los Angeles", "Los Vegas",
                losAngelesToLasVegas, losAngelesToLasVegasRect);

        montrealToBoston.moveTo(maxX * .929f, maxY * .0583f);
        montrealToBoston.lineTo(maxX * .9537f, maxY * .0951f);
        montrealToBoston.lineTo(maxX * .9456f, maxY * .10f);
        montrealToBoston.lineTo(maxX * .9235f, maxY * .0678f);
        montrealToBoston.close();
        montrealToBoston.moveTo(maxX * .95f, maxY * .11f);
        montrealToBoston.lineTo(maxX * .9573f, maxY * .097f);
        montrealToBoston.lineTo(maxX * .9826f, maxY * .1298f);
        montrealToBoston.lineTo(maxX * .9762f, maxY * .1405f);
        montrealToBoston.close();
        montrealToBostonTrack = new Track(2, "Gray", "Montreal", "Boston", montrealToBoston, montrealtoBostonRect);

        montrealToNewYork.moveTo(maxX * .899f, maxY * .089f);
        montrealToNewYork.lineTo(maxX * .91f, maxY * .087f);
        montrealToNewYork.lineTo(maxX * .915f, maxY * .145f);
        montrealToNewYork.lineTo(maxX * .904f, maxY * .146f);
        montrealToNewYork.close();
        montrealToNewYork.moveTo(maxX * .9055f, maxY * .148f);
        montrealToNewYork.lineTo(maxX * .916f, maxY * .146f);
        montrealToNewYork.lineTo(maxX * .921f, maxY * .2f);
        montrealToNewYork.lineTo(maxX * .911f, maxY * .2002f);
        montrealToNewYork.close();
        montrealToNewYork.moveTo(maxX * .91f, maxY * .207f);
        montrealToNewYork.lineTo(maxX * .921f, maxY * .2073f);
        montrealToNewYork.lineTo(maxX * .927f, maxY * .26f);
        montrealToNewYork.lineTo(maxX * .916f, maxY * .26f);
        montrealToNewYork.close();
        montrealToNewYorkTrack = new Track(3, "Blue", "Montreal", "New York", montrealToNewYork,
                montrealtoNewYorkRect);

        newYorkToBoston.moveTo(maxX * .97f, maxY * .17f);
        newYorkToBoston.lineTo(maxX * .98f, maxY * .175f);
        newYorkToBoston.lineTo(maxX * .965f, maxY * .218f);
        newYorkToBoston.lineTo(maxX * .952f, maxY * .21f);
        newYorkToBoston.close();
        newYorkToBoston.moveTo(maxX * .95f, maxY * .218f);
        newYorkToBoston.lineTo(maxX * .959f, maxY * .228f);
        newYorkToBoston.lineTo(maxX * .943f, maxY * .272f);
        newYorkToBoston.lineTo(maxX * .934f, maxY * .263f);
        newYorkToBoston.close();
        newYorkToBostonTrack = new Track(2, "Yellow", "New York", "Boston", newYorkToBoston, newYorkToBostonRect);

        newYorkToWashington.moveTo(maxX * .922f, maxY * .3f);
        newYorkToWashington.lineTo(maxX * .935f, maxY * .3f);
        newYorkToWashington.lineTo(maxX * .937f, maxY * .357f);
        newYorkToWashington.lineTo(maxX * .923f, maxY * .354f);
        newYorkToWashington.close();
        newYorkToWashington.moveTo(maxX * .925f, maxY * .36f);
        newYorkToWashington.lineTo(maxX * .935f, maxY * .36f);
        newYorkToWashington.lineTo(maxX * .939f, maxY * .417f);
        newYorkToWashington.lineTo(maxX * .928f, maxY * .417f);
        newYorkToWashington.close();
        newYorkToWashingtonTrack = new Track(2, "Orange", "New York", "Washington", newYorkToWashington, newYorkToWashingtonRect);

        raleighToWashington.moveTo(maxX * .923f, maxY * .436f);
        raleighToWashington.lineTo(maxX * .934f, maxY * .448f);
        raleighToWashington.lineTo(maxX * .91f, maxY * .49f);
        raleighToWashington.lineTo(maxX * .9f, maxY * .48f);
        raleighToWashington.close();
        raleighToWashington.moveTo(maxX * .897f, maxY * .487f);
        raleighToWashington.lineTo(maxX * .904f, maxY * .497f);
        raleighToWashington.lineTo(maxX * .887f, maxY * .534f);
        raleighToWashington.lineTo(maxX * .877f, maxY * .525f);
        raleighToWashington.close();
        raleighToWashingtonTrack = new Track(2, "Gray", "Raleigh", "Washington", raleighToWashington, raleighToWashingtonRect);

        raleighToCharleston.moveTo(maxX * .882f, maxY * .566f);
        raleighToCharleston.lineTo(maxX * .889f, maxY * .551f);
        raleighToCharleston.lineTo(maxX * .915f, maxY * .586f);
        raleighToCharleston.lineTo(maxX * .91f, maxY * .6f);
        raleighToCharleston.close();
        raleighToCharleston.moveTo(maxX * .918f, maxY * .59f);
        raleighToCharleston.lineTo(maxX * .928f, maxY * .595f);
        raleighToCharleston.lineTo(maxX * .915f, maxY * .65f);
        raleighToCharleston.lineTo(maxX * .902f, maxY * .64f);
        raleighToCharleston.close();
        raleighToCharlestonTrack = new Track(2, "Gray", "Raleigh", "Charleston", raleighToCharleston, raleighToCharlestonRect);

        miamiToCharleston.moveTo(maxX * .9f, maxY * .675f);
        miamiToCharleston.lineTo(maxX * .912f, maxY * .675f);
        miamiToCharleston.lineTo(maxX * .915f, maxY * .72f);
        miamiToCharleston.lineTo(maxX * .9f, maxY * .72f);
        miamiToCharleston.close();
        miamiToCharleston.moveTo(maxX * .902f, maxY * .73f);
        miamiToCharleston.lineTo(maxX * .916f, maxY * .73f);
        miamiToCharleston.lineTo(maxX * .92f, maxY * .79f);
        miamiToCharleston.lineTo(maxX * .909f, maxY * .79f);
        miamiToCharleston.close();
        miamiToCharleston.moveTo(maxX * .91f, maxY * .798f);
        miamiToCharleston.lineTo(maxX * .922f, maxY * .796f);
        miamiToCharleston.lineTo(maxX * .93f, maxY * .845f);
        miamiToCharleston.lineTo(maxX * .92f, maxY * .848f);
        miamiToCharleston.close();
        miamiToCharleston.moveTo(maxX * .92f, maxY * .852f);
        miamiToCharleston.lineTo(maxX * .933f, maxY * .846f);
        miamiToCharleston.lineTo(maxX * .951f, maxY * .9f);
        miamiToCharleston.lineTo(maxX * .94f, maxY * .905f);
        miamiToCharleston.close();
        miamiToCharlestonTrack = new Track(4, "Pink", "Miami", "Charleston", miamiToCharleston, miamiToChaelestonRect);

        atlantaToMiami.moveTo(maxX * .807f, maxY * .677f);
        atlantaToMiami.lineTo(maxX * .817f, maxY * .67f);
        atlantaToMiami.lineTo(maxX * .84f, maxY * .715f);
        atlantaToMiami.lineTo(maxX * .828f, maxY * .725f);
        atlantaToMiami.close();
        atlantaToMiami.moveTo(maxX * .832f, maxY * .73f);
        atlantaToMiami.lineTo(maxX * .843f, maxY * .723f);
        atlantaToMiami.lineTo(maxX * .86f, maxY * .76f);
        atlantaToMiami.lineTo(maxX * .85f, maxY * .765f);
        atlantaToMiami.close();
        atlantaToMiami.moveTo(maxX * .856f, maxY * .772f);
        atlantaToMiami.lineTo(maxX * .867f, maxY * .7645f);
        atlantaToMiami.lineTo(maxX * .8875f, maxY * .813f);
        atlantaToMiami.lineTo(maxX * .875f, maxY * .818f);
        atlantaToMiami.close();
        atlantaToMiami.moveTo(maxX * .88f, maxY * .82f);
        atlantaToMiami.lineTo(maxX * .89f, maxY * .812f);
        atlantaToMiami.lineTo(maxX * .912f, maxY * .853f);
        atlantaToMiami.lineTo(maxX * .899f, maxY * .86f);
        atlantaToMiami.close();
        atlantaToMiami.moveTo(maxX * .902f, maxY * .865f);
        atlantaToMiami.lineTo(maxX * .91f, maxY * .856f);
        atlantaToMiami.lineTo(maxX * .935f, maxY * .905f);
        atlantaToMiami.lineTo(maxX * .925f, maxY * .91f);
        atlantaToMiami.close();
        atlantaToMiamiTrack = new Track(5, "Blue", "Atlanta", "Miami", atlantaToMiami, atlantaToMiamiRect);

        atlantaToCharleston.moveTo(maxX * .82f, maxY * .65f);
        atlantaToCharleston.lineTo(maxX * .855f, maxY * .652f);
        atlantaToCharleston.lineTo(maxX * .855f, maxY * .671f);
        atlantaToCharleston.lineTo(maxX * .82f, maxY * .671f);
        atlantaToCharleston.close();
        atlantaToCharleston.moveTo(maxX * .862f, maxY * .652f);
        atlantaToCharleston.lineTo(maxX * .895f, maxY * .653f);
        atlantaToCharleston.lineTo(maxX * .895f, maxY * .673f);
        atlantaToCharleston.lineTo(maxX * .862f, maxY * .673f);
        atlantaToCharleston.close();
        atlantaToCharlestonTrack = new Track(2, "Gray", "Atlanta", "Charleston", atlantaToCharleston, atlantaToCharlestonRect);

        raleighToAtlanta.moveTo(maxX * .862f, maxY * .545f);
        raleighToAtlanta.lineTo(maxX * .871f, maxY * .556f);
        raleighToAtlanta.lineTo(maxX * .844f, maxY * .6f);
        raleighToAtlanta.lineTo(maxX * .834f, maxY * .581f);
        raleighToAtlanta.close();
        raleighToAtlanta.moveTo(maxX * .834f, maxY * .589f);
        raleighToAtlanta.lineTo(maxX * .843f, maxY * .6f);
        raleighToAtlanta.lineTo(maxX * .815f, maxY * .633f);
        raleighToAtlanta.lineTo(maxX * .808f, maxY * .619f);
        raleighToAtlanta.close();
        raleighToAtlantaTrack = new Track(2, "Gray", "Raleigh", "Atlanta", raleighToAtlanta, raleighToAtlantaRect);

        pittsburghToRaleigh.moveTo(maxX * .843f, maxY * .393f);
        pittsburghToRaleigh.lineTo(maxX * .855f, maxY * .39f);
        pittsburghToRaleigh.lineTo(maxX * .864f, maxY * .448f);
        pittsburghToRaleigh.lineTo(maxX * .85f, maxY * .452f);
        pittsburghToRaleigh.close();
        pittsburghToRaleigh.moveTo(maxX * .85f, maxY * .454f);
        pittsburghToRaleigh.lineTo(maxX * .864f, maxY * .45f);
        pittsburghToRaleigh.lineTo(maxX * .873f, maxY * .508f);
        pittsburghToRaleigh.lineTo(maxX * .86f, maxY * .51f);
        pittsburghToRaleigh.close();
        pittsburghToRaleighTrack = new Track(2, "Gray", "Pittsburgh", "Raleigh", pittsburghToRaleigh, pittsburghToRaleighRect);

        pittsburghToWashington.moveTo(maxX * .855f, maxY * .38f);
        pittsburghToWashington.lineTo(maxX * .858f, maxY * .365f);
        pittsburghToWashington.lineTo(maxX * .892f, maxY * .393f);
        pittsburghToWashington.lineTo(maxX * .885f, maxY * .405f);
        pittsburghToWashington.close();
        pittsburghToWashington.moveTo(maxX * .89f, maxY * .408f);
        pittsburghToWashington.lineTo(maxX * .895f, maxY * .396f);
        pittsburghToWashington.lineTo(maxX * .928f, maxY * .418f);
        pittsburghToWashington.lineTo(maxX * .919f, maxY * .434f);
        pittsburghToWashington.close();
        pittsburghToWashingtonTrack = new Track(2, "Gray", "Pittsburgh", "Washington", pittsburghToWashington, pittsburghToWashingtonRect);

        pittsburghToNewYork.moveTo(maxX * .845f, maxY * .33f);
        pittsburghToNewYork.lineTo(maxX * .875f, maxY * .3f);
        pittsburghToNewYork.lineTo(maxX * .883f, maxY * .313f);
        pittsburghToNewYork.lineTo(maxX * .853f, maxY * .34f);
        pittsburghToNewYork.close();
        pittsburghToNewYork.moveTo(maxX * .879f, maxY * .295f);
        pittsburghToNewYork.lineTo(maxX * .91f, maxY * .27f);
        pittsburghToNewYork.lineTo(maxX * .915f, maxY * .285f);
        pittsburghToNewYork.lineTo(maxX * .884f, maxY * .31f);
        pittsburghToNewYork.close();
        pittsburghToNewYorkTrack = new Track(2, "White", "Pittsburgh", "New York", pittsburghToNewYork, pittsburghToNewYorkRect);

        torontoToPittsburgh.moveTo(maxX * .824f, maxY * .216f);
        torontoToPittsburgh.lineTo(maxX * .835f, maxY * .215f);
        torontoToPittsburgh.lineTo(maxX * .838f, maxY * .278f);
        torontoToPittsburgh.lineTo(maxX * .826f, maxY * .279f);
        torontoToPittsburgh.close();
        torontoToPittsburgh.moveTo(maxX * .827f, maxY * .283f);
        torontoToPittsburgh.lineTo(maxX * .838f, maxY * .282f);
        torontoToPittsburgh.lineTo(maxX * .84f, maxY * .335f);
        torontoToPittsburgh.lineTo(maxX * .829f, maxY * .336f);
        torontoToPittsburgh.close();
        torontoToPittsburghTrack = new Track(2, "Gray", "Toronto", "Pittsburgh", torontoToPittsburgh, torontoToPittsburghRect);

        torontoToMontreal.moveTo(maxX * .83f, maxY * .127f);
        torontoToMontreal.lineTo(maxX * .841f, maxY * .137f);
        torontoToMontreal.lineTo(maxX * .821f, maxY * .189f);
        torontoToMontreal.lineTo(maxX * .812f, maxY * .182f);
        torontoToMontreal.close();
        torontoToMontreal.moveTo(maxX * .86f, maxY * .09f);
        torontoToMontreal.lineTo(maxX * .867f, maxY * .1f);
        torontoToMontreal.lineTo(maxX * .842f, maxY * .14f);
        torontoToMontreal.lineTo(maxX * .832f, maxY * .125f);
        torontoToMontreal.close();
        torontoToMontreal.moveTo(maxX * .895f, maxY * .06f);
        torontoToMontreal.lineTo(maxX * .901f, maxY * .075f);
        torontoToMontreal.lineTo(maxX * .87f, maxY * .0999f);
        torontoToMontreal.lineTo(maxX * .865f, maxY * .083f);
        torontoToMontreal.close();
        torontoToMontrealTrack = new Track(3, "Gray", "Toronto", "Montreal", torontoToMontreal, torontoToMontrealRect);

        saultSteMarieToMontreal.moveTo(maxX * .737f, maxY * .108f);
        saultSteMarieToMontreal.lineTo(maxX * .747f, maxY * .12f);
        saultSteMarieToMontreal.lineTo(maxX * .723f, maxY * .16f);
        saultSteMarieToMontreal.lineTo(maxX * .713f, maxY * .15f);
        saultSteMarieToMontreal.close();
        saultSteMarieToMontreal.moveTo(maxX * .775f, maxY * .075f);
        saultSteMarieToMontreal.lineTo(maxX * .78f, maxY * .093f);
        saultSteMarieToMontreal.lineTo(maxX * .75f, maxY * .12f);
        saultSteMarieToMontreal.lineTo(maxX * .74f, maxY * .105f);
        saultSteMarieToMontreal.close();
        saultSteMarieToMontreal.moveTo(maxX * .81f, maxY * .055f);
        saultSteMarieToMontreal.lineTo(maxX * .815f, maxY * .075f);
        saultSteMarieToMontreal.lineTo(maxX * .782f, maxY * .095f);
        saultSteMarieToMontreal.lineTo(maxX * .778f, maxY * .075f);
        saultSteMarieToMontreal.close();
        saultSteMarieToMontreal.moveTo(maxX * .85f, maxY * .045f);
        saultSteMarieToMontreal.lineTo(maxX * .852f, maxY * .062f);
        saultSteMarieToMontreal.lineTo(maxX * .82f, maxY * .075f);
        saultSteMarieToMontreal.lineTo(maxX * .815f, maxY * .056f);
        saultSteMarieToMontreal.close();
        saultSteMarieToMontreal.moveTo(maxX * .89f, maxY * .043f);
        saultSteMarieToMontreal.lineTo(maxX * .89f, maxY * .06f);
        saultSteMarieToMontreal.lineTo(maxX * .855f, maxY * .06f);
        saultSteMarieToMontreal.lineTo(maxX * .855f, maxY * .043f);
        saultSteMarieToMontreal.close();
        saultSteMarieToMontrealTrack = new Track(5, "Black", "Sault St. Marie", "Montreal",
                saultSteMarieToMontreal, saultSteMarieToMontrealRect);

        newOrleansToMiami.moveTo(maxX * .755f, maxY * .83f);
        newOrleansToMiami.lineTo(maxX * .76f, maxY * .843f);
        newOrleansToMiami.lineTo(maxX * .730f, maxY * .870f);
        newOrleansToMiami.lineTo(maxX * .725f, maxY * .86f);
        newOrleansToMiami.close();
        newOrleansToMiami.moveTo(maxX * .795f, maxY * .81f);
        newOrleansToMiami.lineTo(maxX * .799f, maxY * .825f);
        newOrleansToMiami.lineTo(maxX * .763f, maxY * .840f);
        newOrleansToMiami.lineTo(maxX * .76f, maxY * .825f);
        newOrleansToMiami.close();
        newOrleansToMiami.moveTo(maxX * .799f, maxY * .81f);
        newOrleansToMiami.lineTo(maxX * .835f, maxY * .81f);
        newOrleansToMiami.lineTo(maxX * .835f, maxY * .825f);
        newOrleansToMiami.lineTo(maxX * .799f, maxY * .825f);
        newOrleansToMiami.close();
        newOrleansToMiami.moveTo(maxX * .84f, maxY * .811f);
        newOrleansToMiami.lineTo(maxX * .872f, maxY * .838f);
        newOrleansToMiami.lineTo(maxX * .867f, maxY * .853f);
        newOrleansToMiami.lineTo(maxX * .835f, maxY * .83f);
        newOrleansToMiami.close();
        newOrleansToMiami.moveTo(maxX * .876f, maxY * .845f);
        newOrleansToMiami.lineTo(maxX * .903f, maxY * .875f);
        newOrleansToMiami.lineTo(maxX * .895f, maxY * .89f);
        newOrleansToMiami.lineTo(maxX * .87f, maxY * .86f);
        newOrleansToMiami.close();
        newOrleansToMiami.moveTo(maxX * .905f, maxY * .886f);
        newOrleansToMiami.lineTo(maxX * .93f, maxY * .926f);
        newOrleansToMiami.lineTo(maxX * .92f, maxY * .94f);
        newOrleansToMiami.lineTo(maxX * .899f, maxY * .899f);
        newOrleansToMiami.close();
        newOrleansToMiamiTrack = new Track(6, "Red", "New Orleans", "Miami", newOrleansToMiami, newOrleansToMiamiRect);

        losAngelesToElPaso.moveTo(maxX * .130f, maxY * .790f);
        losAngelesToElPaso.lineTo(maxX * .125f, maxY * .805f);
        losAngelesToElPaso.lineTo(maxX * .150f, maxY * .832f);
        losAngelesToElPaso.lineTo(maxX * .155f, maxY * .820f);
        losAngelesToElPaso.close();
        losAngelesToElPaso.moveTo(maxX * .164f, maxY * .825f);
        losAngelesToElPaso.lineTo(maxX * .162f, maxY * .839f);
        losAngelesToElPaso.lineTo(maxX * .188f, maxY * .862f);
        losAngelesToElPaso.lineTo(maxX * .190f, maxY * .848f);
        losAngelesToElPaso.close();
        losAngelesToElPaso.moveTo(maxX * .195f, maxY * .849f);
        losAngelesToElPaso.lineTo(maxX * .193f, maxY * .862f);
        losAngelesToElPaso.lineTo(maxX * .227f, maxY * .874f);
        losAngelesToElPaso.lineTo(maxX * .230f, maxY * .860f);
        losAngelesToElPaso.close();
        losAngelesToElPaso.moveTo(maxX * .235f, maxY * .861f);
        losAngelesToElPaso.lineTo(maxX * .233f, maxY * .876f);
        losAngelesToElPaso.lineTo(maxX * .265f, maxY * .883f);
        losAngelesToElPaso.lineTo(maxX * .267f, maxY * .872f);
        losAngelesToElPaso.close();
        losAngelesToElPaso.moveTo(maxX * .271f, maxY * .872f);
        losAngelesToElPaso.lineTo(maxX * .273f, maxY * .884f);
        losAngelesToElPaso.lineTo(maxX * .303f, maxY * .879f);
        losAngelesToElPaso.lineTo(maxX * .301f, maxY * .868f);
        losAngelesToElPaso.close();
        losAngelesToElPaso.moveTo(maxX * .308f, maxY * .863f);
        losAngelesToElPaso.lineTo(maxX * .310f, maxY * .875f);
        losAngelesToElPaso.lineTo(maxX * .340f, maxY * .865f);
        losAngelesToElPaso.lineTo(maxX * .338f, maxY * .855f);
        losAngelesToElPaso.close();
        losAngelesToElPasoTrack = new Track(6, "Black", "LosAngeles", "ElPaso", losAngelesToElPaso,losAngelesToElPasoRect);

        vancouverToSeattle.moveTo(maxX * .072f, maxY * .115f);
        vancouverToSeattle.lineTo(maxX * .072f, maxY * .165f);
        vancouverToSeattle.lineTo(maxX * .085f, maxY * .165f);
        vancouverToSeattle.lineTo(maxX * .085f, maxY * .115f);
        vancouverToSeattle.close();
        vancouverToSeattleTrack = new Track(1, "Gray", "Vancouver", "Seattle", vancouverToSeattle, vancouverToSeattleRect);

        seattleToPortland.moveTo(maxX * .053f, maxY * .200f);
        seattleToPortland.lineTo(maxX * .040f, maxY * .252f);
        seattleToPortland.lineTo(maxX * .050f, maxY * .257f);
        seattleToPortland.lineTo(maxX * .060f, maxY * .205f);
        seattleToPortland.close();
        seattleToPortlandTrack = new Track(1, "Gray", "Seattle", "Portland", seattleToPortland, seattleToPortlandRect);


        vancouverToCalgary.moveTo(maxX * .09f, maxY * .08f);
        vancouverToCalgary.lineTo(maxX * .091f, maxY * .098f);
        vancouverToCalgary.lineTo(maxX * .122f, maxY * .09f);
        vancouverToCalgary.lineTo(maxX * .122f, maxY * .07f);
        vancouverToCalgary.close();
        vancouverToCalgary.moveTo(maxX * .128f, maxY * .071f);
        vancouverToCalgary.lineTo(maxX * .129f, maxY * .088f);
        vancouverToCalgary.lineTo(maxX * .160f, maxY * .085f);
        vancouverToCalgary.lineTo(maxX * .159f, maxY * .068f);
        vancouverToCalgary.close();
        vancouverToCalgary.moveTo(maxX * .163f, maxY * .066f);
        vancouverToCalgary.lineTo(maxX * .165f, maxY * .082f);
        vancouverToCalgary.lineTo(maxX * .200f, maxY * .080f);
        vancouverToCalgary.lineTo(maxX * .198f, maxY * .064f);
        vancouverToCalgary.close();
        vancouverToCalgaryTrack = new Track(3, "Gray", "Vancouver", "Calgary", vancouverToCalgary, vancouverToCalgaryRect);

        seattleToCalgary.moveTo(maxX * .085f, maxY * .181f);
        seattleToCalgary.lineTo(maxX * .085f, maxY * .195f);
        seattleToCalgary.lineTo(maxX * .122f, maxY * .195f);
        seattleToCalgary.lineTo(maxX * .122f, maxY * .180f);
        seattleToCalgary.close();
        seattleToCalgary.moveTo(maxX * .125f, maxY * .175f);
        seattleToCalgary.lineTo(maxX * .127f, maxY * .192f);
        seattleToCalgary.lineTo(maxX * .160f, maxY * .187f);
        seattleToCalgary.lineTo(maxX * .158f, maxY * .170f);
        seattleToCalgary.close();
        seattleToCalgary.moveTo(maxX * .162f, maxY * .168f);
        seattleToCalgary.lineTo(maxX * .164f, maxY * .179f);
        seattleToCalgary.lineTo(maxX * .190f, maxY * .146f);
        seattleToCalgary.lineTo(maxX * .183f, maxY * .140f);
        seattleToCalgary.close();
        seattleToCalgary.moveTo(maxX * .186f, maxY * .135f);
        seattleToCalgary.lineTo(maxX * .200f, maxY * .140f);
        seattleToCalgary.lineTo(maxX * .215f, maxY * .091f);
        seattleToCalgary.lineTo(maxX * .203f, maxY * .085f);
        seattleToCalgary.close();
        seattleToCalgaryTrack = new Track(4, "Gray", "Seattle", "Calgary", seattleToCalgary, seattleToCalgaryRect);

        losAngelesToPheonix.moveTo(maxX * .126f, maxY * .760f);
        losAngelesToPheonix.lineTo(maxX * .128f, maxY * .779f);
        losAngelesToPheonix.lineTo(maxX * .161f, maxY * .774f);
        losAngelesToPheonix.lineTo(maxX * .159f, maxY * .756f);
        losAngelesToPheonix.close();
        losAngelesToPheonix.moveTo(maxX * .165f, maxY * .753f);
        losAngelesToPheonix.lineTo(maxX * .166f, maxY * .772f);
        losAngelesToPheonix.lineTo(maxX * .198f, maxY * .772f);
        losAngelesToPheonix.lineTo(maxX * .198f, maxY * .753f);
        losAngelesToPheonix.close();
        losAngelesToPheonix.moveTo(maxX * .200f, maxY * .758f);
        losAngelesToPheonix.lineTo(maxX * .200f, maxY * .773f);
        losAngelesToPheonix.lineTo(maxX * .235f, maxY * .783f);
        losAngelesToPheonix.lineTo(maxX * .238f, maxY * .770f);
        losAngelesToPheonix.close();
        losAngelesToPhoenixTrack = new Track(3, "Gray", "LosAngeles", "Phoenix", losAngelesToPheonix, losAngelesToPhoenixRect);

        myTracks = new Track[]{portlandToSanFranciscoTrack, GRID_TRACK,//vancouverToSeattleTrack,
                losAngelesToLasVegasTrack, sanFranciscoToLosAngelesTrack,
                montrealToBostonTrack, losAngelesToPhoenixTrack, montrealToNewYorkTrack,
                newYorkToBostonTrack, newYorkToWashingtonTrack, raleighToWashingtonTrack,
                raleighToCharlestonTrack, miamiToCharlestonTrack, atlantaToMiamiTrack,
                atlantaToCharlestonTrack, raleighToAtlantaTrack, pittsburghToRaleighTrack,
                pittsburghToWashingtonTrack, pittsburghToNewYorkTrack, torontoToPittsburghTrack,
                torontoToMontrealTrack, saultSteMarieToMontrealTrack, newOrleansToMiamiTrack,
                losAngelesToElPasoTrack, vancouverToSeattleTrack, seattleToPortlandTrack, vancouverToCalgaryTrack,
                seattleToCalgaryTrack
        };

        //Booleans set to defaults
        isSelectDestinationCards = false;
        trackModeSelected = false;
        cardModeSelected = false;
        destinationCardsSelected = false;
        trainCardsSelected = false;

        trackModeSelected = false;
        cardModeSelected = true;
        destinationCardsSelected = false;
        trainCardsSelected = false;
        placeTrainSelected = false;
        isSelectDestinationCards = false;
        onlyDownDeck = false;
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
        destinationCards = new Deck(original.destinationCards);
        for(int i = 0; i < original.getNumPlayers(); i++){
            trainTokens[i] = original.getTrainTokens()[i];
            scores[i] = original.getScores()[i];
            names[i] = original.getNames()[i];
            playerTrainDecks[i] = new Deck(original.getPlayerTrainDecks()[i]);
            playerDestinationDecks[i] = new Deck(original.getPlayerDestinationDecks()[i]);
        }

        myTracks = original.getTracks();
        //Booleans
        isSelectDestinationCards = original.getIsSelectDestinationCards();
        trackModeSelected = original.getTrackModeSelected();
        cardModeSelected = original.getCardModeSelected();
        destinationCardsSelected = original.getDestinationCardsSelected();
        trainCardsSelected = original.getTrainCardsSelected();
        onlyDownDeck = original.getOnlyDownDeck();
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

    public String[] getNames() {
        return names;
    }

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

    public int getTrainColorCount(String color, int index){
        int count = 0;
        for(int i = 0; i< playerTrainDecks[index].size(); i++){
            if (playerTrainDecks[index].getCards().get(i).toString().equals(color)){
                count++;
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

    public boolean getOnlyDownDeck() {
        return onlyDownDeck;
    }

    public void setOnlyDownDeck(Boolean onlyDownDeck) {
        this.onlyDownDeck = onlyDownDeck;
    }

    public Track[] getTracks() {
        return myTracks;
    }

    public void setTracks(Track[] tracks) {
        this.myTracks = tracks;
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
