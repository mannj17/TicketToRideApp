package teamresistance.tickettoride.TTR;

import android.graphics.Path;
import android.graphics.Rect;

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
public class TTRGameState extends GameState {
    //dimensions of the board
    protected int maxX = 1720;
    protected int maxY = 980;

    //Rects that are used to define touchable areas for track selection in Track object
    Rect gridTouch = new Rect(0,0,1,1);
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
    Rect seattleToHelenaRect = new Rect((int)(maxX * .08), (int)(maxY * .2), (int)(maxX * .31), (int)(maxY * .3));
    Rect portlandToSaltLakeCityRect = new Rect((int)(maxX * .09), (int)(maxY * .28), (int)(maxX * .33), (int)(maxY * .43));
    Rect sanFranciscoToSaltLakeCityRect = new Rect((int)(maxX * .05), (int)(maxY * .48), (int)(maxX * .25), (int)(maxY * .61));
    Rect saltLakeCityToLasVegasRect = new Rect((int)(maxX * .19), (int)(maxY * .51), (int)(maxX * .24), (int)(maxY * .73));
    Rect calgaryToWinnipegRect = new Rect((int)(maxX * .22), (int)(maxY * .0), (int)(maxX * .45), (int)(maxY * .1));
    Rect calgaryToHelenaRect = new Rect((int)(maxX * .2), (int)(maxY * .09), (int)(maxX * .33), (int)(maxY * .27));
    Rect helenaToSaltLakeCityRect = new Rect((int)(maxX * .25), (int)(maxY * .3), (int)(maxX * .32), (int)(maxY * .46));
    Rect saltLakeCityToDenverRect = new Rect((int)(maxX * .26), (int)(maxY * .48), (int)(maxX * .37), (int)(maxY * .54));
    Rect phoenixToDenverRect = new Rect((int)(maxX * .25), (int)(maxY * .55), (int)(maxX * .38), (int)(maxY * .76));
    Rect phoenixToSantaFeRect = new Rect((int)(maxX * .25), (int)(maxY * .7), (int)(maxX * .35), (int)(maxY * .78));
    Rect phoenixToElPasoRect = new Rect((int)(maxX * .26), (int)(maxY * .79), (int)(maxX * .36), (int)(maxY * .86));
    Rect helenaToWinnipegRect = new Rect((int)(maxX * .33), (int)(maxY * .08), (int)(maxX * .44), (int)(maxY * .28));
    Rect helenaToDenverRect = new Rect((int)(maxX * .32), (int)(maxY * .3), (int)(maxX * .39), (int)(maxY * .51));
    Rect denverToSantaFeRect = new Rect((int)(maxX * .36), (int)(maxY * .57), (int)(maxX * .39), (int)(maxY * .68));
    Rect santaFeToElPasoRect = new Rect((int)(maxX * .36), (int)(maxY * .71), (int)(maxX * .39), (int)(maxY * .84));
    Rect helenaToDuluthRect = new Rect((int)(maxX * .33), (int)(maxY * .26), (int)(maxX * .56), (int)(maxY * .32));
    Rect newOrleansToAtlantaRect = new Rect((int)(maxX * .7), (int)(maxY * .64), (int)(maxX * .81), (int)(maxY * .82));
    Rect nashvilleToAtlantaRect = new Rect((int)(maxX * .755), (int)(maxY * .59), (int)(maxX * .8), (int)(maxY * .645));
    Rect nashvilleToRaleighRect = new Rect((int)(maxX * .75), (int)(maxY * .5), (int)(maxX * .875), (int)(maxY * .56));
    Rect nashvilleToPittsburghRect = new Rect((int)(maxX * .75), (int)(maxY * .42), (int)(maxX * .83), (int)(maxY * .52));
    Rect saintLouisToPittsburghRect = new Rect((int)(maxX * .7), (int)(maxY * .4), (int)(maxX * .8), (int)(maxY * .5));
    Rect chicagoToPittsburghRect = new Rect((int)(maxX * .7), (int)(maxY * .32), (int)(maxX * .825), (int)(maxY * .37));
    Rect chicagoToTorontoRect = new Rect((int)(maxX * .715), (int)(maxY * .25), (int)(maxX * .8), (int)(maxY * .32));
    Rect saultSteMarieToTorontoRect = new Rect((int)(maxX * .72), (int)(maxY * .15), (int)(maxX * .81), (int)(maxY * .21));
    Rect helenaToOmahaRect= new Rect((int)(maxX * .34), (int)(maxY * .31), (int)(maxX * .51), (int)(maxY * .41));
    Rect denverToOmahaRect = new Rect((int)(maxX * .39), (int)(maxY * .43), (int)(maxX * .53), (int)(maxY * .52));
    Rect denverToKansasCityRect = new Rect((int)(maxX * .4), (int)(maxY * .51), (int)(maxX * .56), (int)(maxY * .6));
    Rect denverToOklahomaCityRect = new Rect((int)(maxX * .38), (int)(maxY * .58), (int)(maxX * .53), (int)(maxY * .67));
    Rect santaFeToOklahomaCityRect = new Rect((int)(maxX * .38), (int)(maxY * .67), (int)(maxX * .5), (int)(maxY * .71));
    Rect elPasoToHoustonRect = new Rect((int)(maxX * .38), (int)(maxY * .85), (int)(maxX * .59), (int)(maxY));
    Rect elPasoToOklahomaCityRect = new Rect((int)(maxX * .37), (int)(maxY * .71), (int)(maxX * .53), (int)(maxY * .83));
    Rect saintLouisToNashvilleRect = new Rect((int)(maxX * .66), (int)(maxY * .52), (int)(maxX * .74), (int)(maxY * .6));
    Rect littleRockToNashvilleRect = new Rect((int)(maxX * .64), (int)(maxY * .59), (int)(maxX * .75), (int)(maxY * .69));
    Rect littleRockToNewOrleansRect = new Rect((int)(maxX * .64), (int)(maxY * .68), (int)(maxX * .7), (int)(maxY * .78));
    Rect houstonToNewOrleanRect = new Rect((int)(maxX * .61), (int)(maxY * .85), (int)(maxX * .7), (int)(maxY * .9));
    Rect saintLouisToLittleRockRect = new Rect((int)(maxX * .61), (int)(maxY * .52), (int)(maxX * .7), (int)(maxY * .6));
    Rect dallasToLittleRockRect = new Rect((int)(maxX * .58), (int)(maxY * .68), (int)(maxX * .635), (int)(maxY * .8));
    Rect oklahomaCityToLittleRockRect = new Rect((int)(maxX * .54), (int)(maxY * .65), (int)(maxX * .64), (int)(maxY * .685));
    Rect kansasCityToSaintLouiseRect = new Rect((int)(maxX * .555), (int)(maxY * .49), (int)(maxX * .65), (int)(maxY * .535));
    Rect saintLouisToChicagoRect = new Rect((int)(maxX * .65), (int)(maxY * .39), (int)(maxX * .71), (int)(maxY * .51));
    Rect omahaToChicagoRect = new Rect((int)(maxX * .545), (int)(maxY * .35), (int)(maxX * .7), (int)(maxY * .435));
    Rect duluthToChicagoRect = new Rect((int)(maxX * .575), (int)(maxY * .285), (int)(maxX * .69), (int)(maxY * .38));
    Rect duluthToTorontoRect = new Rect((int)(maxX * .625), (int)(maxY * .21), (int)(maxX * .755), (int)(maxY * .275));
    Rect duluthToSaultSteMarieRect = new Rect((int)(maxX * .59), (int)(maxY * .155), (int)(maxX * .7), (int)(maxY * .23));
    Rect winnipegToSaultSteMarieRect = new Rect((int)(maxX * .51), (int)(maxY * .08), (int)(maxX * .67), (int)(maxY * .15));
    Rect duluthToOmahaRect = new Rect((int)(maxX * .53), (int)(maxY * .3), (int)(maxX * .58), (int)(maxY * .41));
    Rect winnipegToDuluthRect = new Rect((int)(maxX * .45), (int)(maxY * .09), (int)(maxX * .56), (int)(maxY * .27));
    Rect elPasoToDallasRect = new Rect((int)(maxX * .4), (int)(maxY * .82), (int)(maxX * .55), (int)(maxY * .86));
    Rect dallasToHoustonRect = new Rect((int)(maxX * .55), (int)(maxY * .8), (int)(maxX * .61), (int)(maxY * .87));
    Rect oklahomaCityToDallasRect = new Rect((int)(maxX * .53), (int)(maxY * .68), (int)(maxX * .58), (int)(maxY * .8));
    Rect kansasCityToOklahomaCityRect = new Rect((int)(maxX * .53), (int)(maxY * .53), (int)(maxX * .58), (int)(maxY * .64));
    Rect omahaToKansasCityRect = new Rect((int)(maxX * .54), (int)(maxY * .46), (int)(maxX * .59), (int)(maxY * .5));

   //initializes a path for eeach track
    private Path GRID = new Path();

    //THE WEST!
    private Path vancouverToCalgary = new Path();
    private Path vancouverToSeattle = new Path();
    private Path vancouverToSeattle2 = new Path();
    private Path seattleToCalgary = new Path();
    private Path seattleToHelena = new Path();
    private Path seattleToPortland = new Path();
    private Path seattleToPortland2 = new Path();
    private Path portlandToSanFrancisco = new Path();
    private Path portlandToSanFrancisco2 = new Path();
    private Path portlandToSaltLakeCity = new Path();
    private Path sanFranciscoToLosAngeles = new Path();
    private Path sanFranciscoToLosAngeles2 = new Path();
    private Path sanFranciscoToSaltLakeCity = new Path();
    private Path sanFranciscoToSaltLakeCity2 = new Path();
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
    private Path saltLakeCityToDenver2 = new Path();
    private Path saltLakeCityToLasVegas = new Path();
    private Path phoenixToDenver = new Path();
    private Path phoenixToSantaFe = new Path();
    private Path phoenixToElPaso = new Path();
    private Path denverToOmaha = new Path();
    private Path denverToKansasCity = new Path();
    private Path denverToKansasCity2 = new Path();
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
    private Path duluthToOmaha2 = new Path();
    private Path omahaToChicago = new Path();
    private Path omahatoKansasCity = new Path();
    private Path omahatoKansasCity2 = new Path();
    private Path kansasCityToSaintLouise = new Path();
    private Path kansasCityToOklahomaCity = new Path();
    private Path kansasCityToSaintLouise2 = new Path();
    private Path kansasCityToOklahomaCity2 = new Path();
    private Path oklahomaCityToLittleRock = new Path();
    private Path oklahomaCityToDallas = new Path();
    private Path oklahomaCityToDallas2 = new Path();
    private Path dallasToLittleRock = new Path();
    private Path dallasToHouston = new Path();
    private Path dallasToHouston2 = new Path();
    private Path houstonToNewOrlean = new Path();
    //Mississippi
    private Path saultSteMarieToMontreal = new Path();
    private Path saultSteMarieToToronto = new Path();
    private Path chicagoToToronto = new Path();
    private Path chicagoToPittsburgh = new Path();
    private Path chicagoToPittsburgh2 = new Path();
    private Path chicagoToSaintLouis = new Path();
    private Path chicagoToSaintLouis2 = new Path();
    private Path saintLouisToPittsburgh = new Path();
    private Path saintLouisToNashville = new Path();
    private Path saintLouisToLittleRock = new Path();
    private Path nashvilleToPittsburgh = new Path();
    private Path nashvilleToRaleigh = new Path();
    private Path nashvilleToAtlanta = new Path();
    private Path littleRockToNashville = new Path();
    private Path littleRockToNewOrleans = new Path();
    private Path newOrleansToAtlanta = new Path();
    private Path newOrleansToAtlanta2 = new Path();
    private Path newOrleansToMiami = new Path();
    //Appalachia
    private Path torontoToMontreal = new Path();
    private Path torontoToPittsburgh = new Path();
    private Path pittsburghToNewYork = new Path();
    private Path pittsburghToNewYork2 = new Path();
    private Path pittsburghToWashington = new Path();
    private Path pittsburghToRaleigh = new Path();
    private Path raleighToWashington = new Path();
    private Path raleighToWashington2 = new Path();
    private Path raleighToCharleston = new Path();
    private Path raleighToAtlanta = new Path();
    private Path raleighToAtlanta2 = new Path();
    private Path atlantaToCharleston = new Path();
    private Path atlantaToMiami = new Path();
    private Path miamiToCharleston = new Path();
    //NorthEast
    private Path montrealToBoston = new Path();
    private Path montrealToBoston2 = new Path();
    private Path montrealToNewYork = new Path();
    private Path newYorkToBoston = new Path();
    private Path newYorkToWashington = new Path();
    private Path newYorkToBoston2 = new Path();
    private Path newYorkToWashington2 = new Path();


    //initializes track object for every track in game
    Track GRID_TRACK;
    //THE WEST
    Track vancouverToCalgaryTrack;
    Track vancouverToSeattleTrack;
    Track vancouverToSeattleTrack2;
    Track seattleToCalgaryTrack;
    Track seattleToHelenaTrack;
    Track seattleToPortlandTrack;
    Track seattleToPortlandTrack2;
    Track portlandToSanFranciscoTrack;
    Track portlandToSanFranciscoTrack2;
    Track portlandToSaltLakeCityTrack;
    Track sanFranciscoToLosAngelesTrack;
    Track sanFranciscoToLosAngelesTrack2;
    Track sanFranciscoToSaltLakeCityTrack;
    Track sanFranciscoToSaltLakeCityTrack2;
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
    Track saltLakeCityToDenverTrack2;
    Track saltLakeCityToLasVegasTrack;
    Track phoenixToDenverTrack;
    Track phoenixToSantaFeTrack;
    Track phoenixToElPasoTrack;
    Track denverToOmahaTrack;
    Track denverToKansasCityTrack;
    Track denverToKansasCityTrack2;
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
    Track duluthToOmahaTrack2;
    Track omahaToChicagoTrack;
    Track omahatoKansasCityTrack;
    Track omahatoKansasCityTrack2;
    Track kansasCityToSaintLouiseTrack;
    Track kansasCityToOklahomaCityTrack;
    Track kansasCityToSaintLouiseTrack2;
    Track kansasCityToOklahomaCityTrack2;
    Track oklahomaCityToLittleRockTrack;
    Track oklahomaCityToDallasTrack;
    Track oklahomaCityToDallasTrack2;
    Track dallasToLittleRockTrack;
    Track dallasToHoustonTrack;
    Track dallasToHoustonTrack2;
    Track houstonToNewOrleansTrack;
    //Mississippi
    Track saultSteMarieToMontrealTrack;
    Track saultSteMarieToTorontoTrack;
    Track chicagoToTorontoTrack;
    Track chicagoToPittsburghTrack;
    Track chicagoToPittsburghTrack2;
    Track chicagoToSaintLouisTrack;
    Track chicagoToSaintLouisTrack2;
    Track saintLouisToPittsburghTrack;
    Track saintLouisToNashvilleTrack;
    Track saintLouisToLittleRockTrack;
    Track nashvilleToPittsburghTrack;
    Track nashvilleToRaleighTrack;
    Track nashvilleToAtlantaTrack;
    Track littleRockToNashvilleTrack;
    Track littleRockToNewOrleansTracks;
    Track newOrleansToAtlantaTrack;
    Track newOrleansToAtlantaTrack2;
    Track newOrleansToMiamiTrack;
    //Appalachia
    Track torontoToMontrealTrack;
    Track torontoToPittsburghTrack;
    Track pittsburghToNewYorkTrack;
    Track pittsburghToNewYorkTrack2;
    Track pittsburghToWashingtonTrack;
    Track pittsburghToRaleighTrack;
    Track raleighToWashingtonTrack;
    Track raleighToWashingtonTrack2;
    Track raleighToCharlestonTrack;
    Track raleighToAtlantaTrack;
    Track raleighToAtlantaTrack2;
    Track atlantaToCharlestonTrack;
    Track atlantaToMiamiTrack;
    Track miamiToCharlestonTrack;
    //NorthEast
    Track montrealToBostonTrack;
    Track montrealToBostonTrack2;
    Track montrealToNewYorkTrack;
    Track newYorkToBostonTrack;
    Track newYorkToWashingtonTrack;
    Track newYorkToBostonTrack2;
    Track newYorkToWashingtonTrack2;

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
    private String selectedCardColor;
    private boolean useRainbow;
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
        }

        /** initialize destination deck */
        //needs to be corrected later
        destinationCards = new Deck("Destination Cards");
        destinationDiscard = new Deck("Destination Discard");
        for(int i = 0; i < 30; i++){
            destinationCards.add(new DestinationCards(i, i, i));
        }

        /** initialize array values to max possible size */
        for(int i = 0; i < numPlayers; i++){
            trainTokens[i] = 45;
            int k = 0;
            scores[i] = 0;
            names[i] = "";
            playerTrainDecks[i] = new Deck("Player " + i + " Train Card Deck");
            //places the top 5 cards of the face down deck into the current players train card deck
            while(k!= 5)
            {
                //checks to make sure that player does not get a locomotive card
                if(!faceDownTrainCards.peekAtTopCard().toString().equals("Rainbow"))
                {
                    faceDownTrainCards.moveTopCardTo(playerTrainDecks[i], faceDownTrainCards);
                    k++;
                }
                else
                {
                    faceDownTrainCards.shuffle();
                }
            }
            //places 3 destination cards into the current players destination deck
            playerDestinationDecks[i] = new Deck("Player " + i + " Destination Card Deck");
            for(int j = 0; j != 3;j++)
            {
                destinationCards.moveTopCardTo(playerDestinationDecks[i], destinationCards);
            }
        }
        selectedCardColor = null;
        trainDiscard = new Deck("Train Card Discard");
        destinationCardsDrawn = new Deck("Destination Cards Drawn");
        destinationPool = new Deck("Destination Card Pool");
        numRainbows = 0;

        // GRID creates a "Track" path used to aid in mapping out locations
        GRID.moveTo(0, maxY * .1f);
        GRID.lineTo(maxX, maxY * .1f);
        GRID.moveTo(0, maxY * .2f);
        GRID.lineTo(maxX, maxY * .2f);
        GRID.moveTo(0, maxY * .3f);
        GRID.lineTo(maxX, maxY * .3f);
        GRID.moveTo(0, maxY * .4f);
        GRID.lineTo(maxX, maxY * .4f);
        GRID.moveTo(0, maxY * .5f);
        GRID.lineTo(maxX, maxY * .5f);
        GRID.moveTo(0, maxY * .6f);
        GRID.lineTo(maxX, maxY * .6f);
        GRID.moveTo(0, maxY * .7f);
        GRID.lineTo(maxX, maxY * .7f);
        GRID.moveTo(0, maxY * .8f);
        GRID.lineTo(maxX, maxY * .8f);
        GRID.moveTo(0, maxY * .9f);
        GRID.lineTo(maxX, maxY * .9f);
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
        GRID.lineTo(maxX * .7f, maxY);
        GRID.moveTo(maxX * .8f, 0);
        GRID.lineTo(maxX * .8f, maxY);
        GRID.moveTo(maxX * .9f, 0);
        GRID.lineTo(maxX * .9f, maxY);
        GRID_TRACK = new Track(0, "GRID", "NOWHERE", "NOWHERE", GRID, gridTouch);
        //creates a path for each track
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
        portlandToSanFranciscoTrack = new Track(5, "Green", "Portland", "SanFrancisco",
                portlandToSanFrancisco, sanFranciscoToPortlandRect);

        portlandToSanFrancisco2.moveTo(maxX * .043f, maxY * .286f);
        portlandToSanFrancisco2.lineTo(maxX * .032f, maxY * .338f);
        portlandToSanFrancisco2.lineTo(maxX * .045f, maxY * .343f);
        portlandToSanFrancisco2.lineTo(maxX * .055f, maxY * .294f);
        portlandToSanFrancisco2.close();
        portlandToSanFrancisco2.moveTo(maxX * .030f, maxY * .345f);
        portlandToSanFrancisco2.lineTo(maxX * .024f, maxY * .398f);
        portlandToSanFrancisco2.lineTo(maxX * .034f, maxY * .398f);
        portlandToSanFrancisco2.lineTo(maxX * .039f, maxY * .35f);
        portlandToSanFrancisco2.close();
        portlandToSanFrancisco2.moveTo(maxX * .023f, maxY * .408f);
        portlandToSanFrancisco2.lineTo(maxX * .033f, maxY * .408f);
        portlandToSanFrancisco2.lineTo(maxX * .032f, maxY * .459f);
        portlandToSanFrancisco2.lineTo(maxX * .022f, maxY * .459f);
        portlandToSanFrancisco2.close();
        portlandToSanFrancisco2.moveTo(maxX * .022f, maxY * .469f);
        portlandToSanFrancisco2.lineTo(maxX * .0248f, maxY * .523f);
        portlandToSanFrancisco2.lineTo(maxX * .0327f, maxY * .522f);
        portlandToSanFrancisco2.lineTo(maxX * .0318f, maxY * .469f);
        portlandToSanFrancisco2.close();
        portlandToSanFrancisco2.moveTo(maxX * .0255f, maxY * .5336f);
        portlandToSanFrancisco2.lineTo(maxX * .0336f, maxY * .579f);
        portlandToSanFrancisco2.lineTo(maxX * .044f, maxY * .578f);
        portlandToSanFrancisco2.lineTo(maxX * .0365f, maxY * .5285f);
        portlandToSanFrancisco2.close();
        portlandToSanFranciscoTrack2 = new Track(5, "Pink", "Portland", "SanFrancisco",
                portlandToSanFrancisco2, sanFranciscoToPortlandRect);

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

        sanFranciscoToLosAngeles2.moveTo(maxX * .039f, maxY * .624f);
        sanFranciscoToLosAngeles2.lineTo(maxX * .053f, maxY * .675f);
        sanFranciscoToLosAngeles2.lineTo(maxX * .063f, maxY * .670f);
        sanFranciscoToLosAngeles2.lineTo(maxX * .048f, maxY * .617f);
        sanFranciscoToLosAngeles2.close();
        sanFranciscoToLosAngeles2.moveTo(maxX * .055f, maxY * .681f);
        sanFranciscoToLosAngeles2.lineTo(maxX * .075f, maxY * .726f);
        sanFranciscoToLosAngeles2.lineTo(maxX * .084f, maxY * .718f);
        sanFranciscoToLosAngeles2.lineTo(maxX * .065f, maxY * .673f);
        sanFranciscoToLosAngeles2.close();
        sanFranciscoToLosAngeles2.moveTo(maxX * .078f, maxY * .73f);
        sanFranciscoToLosAngeles2.lineTo(maxX * .101f, maxY * .765f);
        sanFranciscoToLosAngeles2.lineTo(maxX * .109f, maxY * .76f);
        sanFranciscoToLosAngeles2.lineTo(maxX * .087f, maxY * .722f);
        sanFranciscoToLosAngeles2.close();
        sanFranciscoToLosAngelesTrack2 = new Track(3, "Pink", "SanFrancisco", "LosAngeles",
                sanFranciscoToLosAngeles2, sanFranciscoToLosAngelesRect);


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
        montrealToBostonTrack = new Track(2, "Gray", "Montreal", "Boston",
                montrealToBoston, montrealtoBostonRect);

        montrealToBoston2.moveTo(maxX * .923f, maxY * .0683f);
        montrealToBoston2.lineTo(maxX * .9477f, maxY * .1051f);
        montrealToBoston2.lineTo(maxX * .94f, maxY * .115f);
        montrealToBoston2.lineTo(maxX * .917f, maxY * .078f);
        montrealToBoston2.close();
        montrealToBoston2.moveTo(maxX * .944f, maxY * .12f);
        montrealToBoston2.lineTo(maxX * .9513f, maxY * .107f);
        montrealToBoston2.lineTo(maxX * .9766f, maxY * .1398f);
        montrealToBoston2.lineTo(maxX * .9702f, maxY * .1505f);
        montrealToBoston2.close();
        //montrealToBoston2 = montrealToBoston;
        //montrealToBoston2.offset(-.006f, .01f);
        montrealToBostonTrack2 = new Track(2, "Gray", "Montreal", "Boston",
                montrealToBoston2, montrealtoBostonRect);

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
        montrealToNewYorkTrack = new Track(3, "Blue", "Montreal", "New York City", montrealToNewYork,
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
        newYorkToBostonTrack = new Track(2, "Yellow", "New York City", "Boston", newYorkToBoston, newYorkToBostonRect);

        newYorkToBoston2.moveTo(maxX * .981f, maxY * .176f);
        newYorkToBoston2.lineTo(maxX * .991f, maxY * .181f);
        newYorkToBoston2.lineTo(maxX * .976f, maxY * .224f);
        newYorkToBoston2.lineTo(maxX * .963f, maxY * .216f);
        newYorkToBoston2.close();
        newYorkToBoston2.moveTo(maxX * .961f, maxY * .224f);
        newYorkToBoston2.lineTo(maxX * .970f, maxY * .234f);
        newYorkToBoston2.lineTo(maxX * .954f, maxY * .278f);
        newYorkToBoston2.lineTo(maxX * .945f, maxY * .269f);
        newYorkToBoston2.close();
        newYorkToBostonTrack2 = new Track(2, "Red", "New York City", "Boston",
                newYorkToBoston2, newYorkToBostonRect);

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
        newYorkToWashingtonTrack = new Track(2, "Orange", "New York City", "Washington", newYorkToWashington,
                newYorkToWashingtonRect);

        newYorkToWashington2.moveTo(maxX * .936f, maxY * .299f);
        newYorkToWashington2.lineTo(maxX * .949f, maxY * .299f);
        newYorkToWashington2.lineTo(maxX * .951f, maxY * .356f);
        newYorkToWashington2.lineTo(maxX * .937f, maxY * .353f);
        newYorkToWashington2.close();
        newYorkToWashington2.moveTo(maxX * .939f, maxY * .359f);
        newYorkToWashington2.lineTo(maxX * .949f, maxY * .359f);
        newYorkToWashington2.lineTo(maxX * .953f, maxY * .416f);
        newYorkToWashington2.lineTo(maxX * .942f, maxY * .416f);
        newYorkToWashington2.close();
        newYorkToWashingtonTrack2 = new Track(2, "Black", "New York City", "Washington", newYorkToWashington2,
                newYorkToWashingtonRect);

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
        raleighToWashingtonTrack = new Track(2, "Gray", "Raleigh", "Washington",
                raleighToWashington, raleighToWashingtonRect);

        raleighToWashington2.moveTo(maxX * .935f, maxY * .449f);
        raleighToWashington2.lineTo(maxX * .946f, maxY * .461f);
        raleighToWashington2.lineTo(maxX * .922f, maxY * .503f);
        raleighToWashington2.lineTo(maxX * .912f, maxY * .493f);
        raleighToWashington2.close();
        raleighToWashington2.moveTo(maxX * .909f, maxY * .500f);
        raleighToWashington2.lineTo(maxX * .916f, maxY * .510f);
        raleighToWashington2.lineTo(maxX * .899f, maxY * .547f);
        raleighToWashington2.lineTo(maxX * .889f, maxY * .538f);
        raleighToWashington2.close();
        raleighToWashingtonTrack2 = new Track(2, "Gray", "Raleigh", "Washington",
                raleighToWashington2, raleighToWashingtonRect);

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
        raleighToCharlestonTrack = new Track(2, "Gray", "Raleigh", "Charleston",
                raleighToCharleston, raleighToCharlestonRect);

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
        miamiToCharlestonTrack = new Track(4, "Pink", "Miami", "Charleston",
                miamiToCharleston, miamiToChaelestonRect);

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
        atlantaToMiamiTrack = new Track(5, "Blue", "Atlanta", "Miami",
                atlantaToMiami, atlantaToMiamiRect);

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
        atlantaToCharlestonTrack = new Track(2, "Gray", "Atlanta", "Charleston",
                atlantaToCharleston, atlantaToCharlestonRect);

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
        raleighToAtlantaTrack = new Track(2, "Gray", "Raleigh", "Atlanta",
                raleighToAtlanta, raleighToAtlantaRect);

        raleighToAtlanta2.moveTo(maxX * .872f, maxY * .557f);
        raleighToAtlanta2.lineTo(maxX * .881f, maxY * .568f);
        raleighToAtlanta2.lineTo(maxX * .854f, maxY * .612f);
        raleighToAtlanta2.lineTo(maxX * .844f, maxY * .593f);
        raleighToAtlanta2.close();
        raleighToAtlanta2.moveTo(maxX * .844f, maxY * .601f);
        raleighToAtlanta2.lineTo(maxX * .853f, maxY * .612f);
        raleighToAtlanta2.lineTo(maxX * .825f, maxY * .645f);
        raleighToAtlanta2.lineTo(maxX * .818f, maxY * .631f);
        raleighToAtlanta2.close();
        raleighToAtlantaTrack2 = new Track(2, "Gray", "Raleigh", "Atlanta",
                raleighToAtlanta2, raleighToAtlantaRect);

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
        pittsburghToRaleighTrack = new Track(2, "Gray", "Pittsburgh", "Raleigh",
                pittsburghToRaleigh, pittsburghToRaleighRect);

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
        pittsburghToWashingtonTrack = new Track(2, "Gray", "Pittsburgh", "Washington",
                pittsburghToWashington, pittsburghToWashingtonRect);

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
        pittsburghToNewYorkTrack = new Track(2, "White", "Pittsburgh", "New York City",
                pittsburghToNewYork, pittsburghToNewYorkRect);

        pittsburghToNewYork2.moveTo(maxX * .854f, maxY * .342f);
        pittsburghToNewYork2.lineTo(maxX * .884f, maxY * .312f);
        pittsburghToNewYork2.lineTo(maxX * .892f, maxY * .325f);
        pittsburghToNewYork2.lineTo(maxX * .862f, maxY * .352f);
        pittsburghToNewYork2.close();
        pittsburghToNewYork2.moveTo(maxX * .888f, maxY * .307f);
        pittsburghToNewYork2.lineTo(maxX * .919f, maxY * .282f);
        pittsburghToNewYork2.lineTo(maxX * .924f, maxY * .297f);
        pittsburghToNewYork2.lineTo(maxX * .893f, maxY * .322f);
        pittsburghToNewYork2.close();
        pittsburghToNewYorkTrack2 = new Track(2, "Green", "Pittsburgh", "New York City",
                pittsburghToNewYork2, pittsburghToNewYorkRect);

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
        torontoToPittsburghTrack = new Track(2, "Gray", "Toronto", "Pittsburgh",
                torontoToPittsburgh, torontoToPittsburghRect);

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
        torontoToMontrealTrack = new Track(3, "Gray", "Toronto", "Montreal",
                torontoToMontreal, torontoToMontrealRect);

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
        saultSteMarieToMontrealTrack = new Track(5, "Black", "Sault Ste Marie", "Montreal",
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
        newOrleansToMiamiTrack = new Track(6, "Red", "New Orleans", "Miami",
                newOrleansToMiami, newOrleansToMiamiRect);

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
        losAngelesToElPasoTrack = new Track(6, "Black", "LosAngeles", "ElPaso",
                losAngelesToElPaso,losAngelesToElPasoRect);

        vancouverToSeattle.moveTo(maxX * .072f, maxY * .115f);
        vancouverToSeattle.lineTo(maxX * .072f, maxY * .165f);
        vancouverToSeattle.lineTo(maxX * .085f, maxY * .165f);
        vancouverToSeattle.lineTo(maxX * .085f, maxY * .115f);
        vancouverToSeattle.close();
        vancouverToSeattleTrack = new Track(1, "Gray", "Vancouver", "Seattle",
                vancouverToSeattle, vancouverToSeattleRect);

        vancouverToSeattle2.moveTo(maxX * .058f, maxY * .115f);
        vancouverToSeattle2.lineTo(maxX * .058f, maxY * .165f);
        vancouverToSeattle2.lineTo(maxX * .07f, maxY * .165f);
        vancouverToSeattle2.lineTo(maxX * .07f, maxY * .115f);
        vancouverToSeattle2.close();
        vancouverToSeattleTrack2 = new Track(1, "Gray", "Vancouver", "Seattle",
                vancouverToSeattle2, vancouverToSeattleRect);

        seattleToPortland.moveTo(maxX * .053f, maxY * .200f);
        seattleToPortland.lineTo(maxX * .040f, maxY * .252f);
        seattleToPortland.lineTo(maxX * .050f, maxY * .257f);
        seattleToPortland.lineTo(maxX * .060f, maxY * .205f);
        seattleToPortland.close();
        seattleToPortlandTrack = new Track(1, "Gray", "Seattle", "Portland",
                seattleToPortland, seattleToPortlandRect);


        seattleToPortland2.moveTo(maxX * .066f, maxY * .206f);
        seattleToPortland2.lineTo(maxX * .053f, maxY * .256f);
        seattleToPortland2.lineTo(maxX * .060f, maxY * .263f);
        seattleToPortland2.lineTo(maxX * .075f, maxY * .212f);
        seattleToPortland2.close();
        seattleToPortlandTrack2 = new Track(1, "Gray", "Seattle", "Portland",
                seattleToPortland2, seattleToPortlandRect);

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
        vancouverToCalgaryTrack = new Track(3, "Gray", "Vancouver", "Calgary",
                vancouverToCalgary, vancouverToCalgaryRect);

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
        seattleToCalgaryTrack = new Track(4, "Gray", "Seattle", "Calgary",
                seattleToCalgary, seattleToCalgaryRect);

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
        losAngelesToPhoenixTrack = new Track(3, "Gray", "LosAngeles", "Phoenix",
                losAngelesToPheonix, losAngelesToPhoenixRect);

        seattleToHelena.moveTo(maxX * .082f, maxY * .205f);
        seattleToHelena.lineTo(maxX * .081f, maxY * .216f);
        seattleToHelena.lineTo(maxX * .117f, maxY * .228f);
        seattleToHelena.lineTo(maxX * .119f, maxY * .212f);
        seattleToHelena.close();
        seattleToHelena.moveTo(maxX * .124f, maxY * .218f);
        seattleToHelena.lineTo(maxX * .122f, maxY * .230f);
        seattleToHelena.lineTo(maxX * .154f, maxY * .240f);
        seattleToHelena.lineTo(maxX * .154f, maxY * .229f);
        seattleToHelena.close();
        seattleToHelena.moveTo(maxX * .159f, maxY * .231f);
        seattleToHelena.lineTo(maxX * .158f, maxY * .243f);
        seattleToHelena.lineTo(maxX * .189f, maxY * .250f);
        seattleToHelena.lineTo(maxX * .191f, maxY * .239f);
        seattleToHelena.close();
        seattleToHelena.moveTo(maxX * .196f, maxY * .242f);
        seattleToHelena.lineTo(maxX * .197f, maxY * .257f);
        seattleToHelena.lineTo(maxX * .228f, maxY * .267f);
        seattleToHelena.lineTo(maxX * .229f, maxY * .251f);
        seattleToHelena.close();
        seattleToHelena.moveTo(maxX * .234f, maxY * .257f);
        seattleToHelena.lineTo(maxX * .234f, maxY * .272f);
        seattleToHelena.lineTo(maxX * .266f, maxY * .283f);
        seattleToHelena.lineTo(maxX * .266f, maxY * .266f);
        seattleToHelena.close();
        seattleToHelena.moveTo(maxX * .270f, maxY * .268f);
        seattleToHelena.lineTo(maxX * .269f, maxY * .282f);
        seattleToHelena.lineTo(maxX * .302f, maxY * .295f);
        seattleToHelena.lineTo(maxX * .304f, maxY * .278f);
        seattleToHelena.close();
        seattleToHelenaTrack = new Track(6, "Yellow", "Seattle", "Helena",
                seattleToHelena, seattleToHelenaRect);

        portlandToSaltLakeCity.moveTo(maxX * .062f, maxY * .270f);
        portlandToSaltLakeCity.lineTo(maxX * .060f, maxY * .285f);
        portlandToSaltLakeCity.lineTo(maxX * .092f, maxY * .293f);
        portlandToSaltLakeCity.lineTo(maxX * .095f, maxY * .280f);
        portlandToSaltLakeCity.close();
        portlandToSaltLakeCity.moveTo(maxX * .100f, maxY * .280f);
        portlandToSaltLakeCity.lineTo(maxX * .098f, maxY * .300f);
        portlandToSaltLakeCity.lineTo(maxX * .128f, maxY * .316f);
        portlandToSaltLakeCity.lineTo(maxX * .131f, maxY * .300f);
        portlandToSaltLakeCity.close();
        portlandToSaltLakeCity.moveTo(maxX * .136f, maxY * .303f);
        portlandToSaltLakeCity.lineTo(maxX * .134f, maxY * .319f);
        portlandToSaltLakeCity.lineTo(maxX * .161f, maxY * .344f);
        portlandToSaltLakeCity.lineTo(maxX * .164f, maxY * .332f);
        portlandToSaltLakeCity.close();
        portlandToSaltLakeCity.moveTo(maxX * .171f, maxY * .340f);
        portlandToSaltLakeCity.lineTo(maxX * .168f, maxY * .351f);
        portlandToSaltLakeCity.lineTo(maxX * .191f, maxY * .384f);
        portlandToSaltLakeCity.lineTo(maxX * .195f, maxY * .374f);
        portlandToSaltLakeCity.close();
        portlandToSaltLakeCity.moveTo(maxX * .200f, maxY * .380f);
        portlandToSaltLakeCity.lineTo(maxX * .195f, maxY * .391f);
        portlandToSaltLakeCity.lineTo(maxX * .216f, maxY * .428f);
        portlandToSaltLakeCity.lineTo(maxX * .222f, maxY * .419f);
        portlandToSaltLakeCity.close();
        portlandToSaltLakeCity.moveTo(maxX * .226f, maxY * .423f);
        portlandToSaltLakeCity.lineTo(maxX * .219f, maxY * .432f);
        portlandToSaltLakeCity.lineTo(maxX * .233f, maxY * .479f);
        portlandToSaltLakeCity.lineTo(maxX * .241f, maxY * .471f);
        portlandToSaltLakeCity.close();
        portlandToSaltLakeCityTrack = new Track(6, "Blue", "Portland", "SaltLakeCity",
                portlandToSaltLakeCity, portlandToSaltLakeCityRect);

        sanFranciscoToSaltLakeCity.moveTo(maxX * .050f, maxY * .575f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .052f, maxY * .590f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .082f, maxY * .578f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .080f, maxY * .563f);
        sanFranciscoToSaltLakeCity.close();
        sanFranciscoToSaltLakeCity.moveTo(maxX * .085f, maxY * .559f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .088f, maxY * .573f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .120f, maxY * .558f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .117f, maxY * .542f);
        sanFranciscoToSaltLakeCity.close();
        sanFranciscoToSaltLakeCity.moveTo(maxX * .122f, maxY * .538f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .124f, maxY * .553f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .154f, maxY * .540f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .150f, maxY * .527f);
        sanFranciscoToSaltLakeCity.close();
        sanFranciscoToSaltLakeCity.moveTo(maxX * .155f, maxY * .523f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .158f, maxY * .535f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .189f, maxY * .522f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .185f, maxY * .505f);
        sanFranciscoToSaltLakeCity.close();
        sanFranciscoToSaltLakeCity.moveTo(maxX * .193f, maxY * .501f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .196f, maxY * .514f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .225f, maxY * .502f);
        sanFranciscoToSaltLakeCity.lineTo(maxX * .220f, maxY * .487f);
        sanFranciscoToSaltLakeCity.close();
        sanFranciscoToSaltLakeCityTrack = new Track(5, "Orange", "SanFrancisco", "SaltLakeCity",
                sanFranciscoToSaltLakeCity, sanFranciscoToSaltLakeCityRect);

        sanFranciscoToSaltLakeCity2.moveTo(maxX * .053f, maxY * .591f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .055f, maxY * .606f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .085f, maxY * .594f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .083f, maxY * .579f);
        sanFranciscoToSaltLakeCity2.close();
        sanFranciscoToSaltLakeCity2.moveTo(maxX * .088f, maxY * .575f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .091f, maxY * .599f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .123f, maxY * .574f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .120f, maxY * .558f);
        sanFranciscoToSaltLakeCity2.close();
        sanFranciscoToSaltLakeCity2.moveTo(maxX * .125f, maxY * .554f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .127f, maxY * .569f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .157f, maxY * .556f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .153f, maxY * .543f);
        sanFranciscoToSaltLakeCity2.close();
        sanFranciscoToSaltLakeCity2.moveTo(maxX * .158f, maxY * .539f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .161f, maxY * .551f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .192f, maxY * .538f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .188f, maxY * .521f);
        sanFranciscoToSaltLakeCity2.close();
        sanFranciscoToSaltLakeCity2.moveTo(maxX * .196f, maxY * .517f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .199f, maxY * .530f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .228f, maxY * .518f);
        sanFranciscoToSaltLakeCity2.lineTo(maxX * .223f, maxY * .503f);
        sanFranciscoToSaltLakeCity2.close();
        sanFranciscoToSaltLakeCityTrack2 = new Track(5, "White", "SanFrancisco", "SaltLakeCity",
                sanFranciscoToSaltLakeCity2, sanFranciscoToSaltLakeCityRect);

        saltLakeCityToLasVegas.moveTo(maxX * .194f, maxY * .670f);
        saltLakeCityToLasVegas.lineTo(maxX * .201f, maxY * .680f);
        saltLakeCityToLasVegas.lineTo(maxX * .224f, maxY * .641f);
        saltLakeCityToLasVegas.lineTo(maxX * .217f, maxY * .631f);
        saltLakeCityToLasVegas.close();
        saltLakeCityToLasVegas.moveTo(maxX * .219f, maxY * .626f);
        saltLakeCityToLasVegas.lineTo(maxX * .229f, maxY * .629f);
        saltLakeCityToLasVegas.lineTo(maxX * .239f, maxY * .585f);
        saltLakeCityToLasVegas.lineTo(maxX * .230f, maxY * .581f);
        saltLakeCityToLasVegas.close();
        saltLakeCityToLasVegas.moveTo(maxX * .232f, maxY * .578f);
        saltLakeCityToLasVegas.lineTo(maxX * .241f, maxY * .579f);
        saltLakeCityToLasVegas.lineTo(maxX * .246f, maxY * .523f);
        saltLakeCityToLasVegas.lineTo(maxX * .237f, maxY * .521f);
        saltLakeCityToLasVegas.close();
        saltLakeCityToLasVegasTrack = new Track(3, "Orange", "LasVegas", "SaltLakeCity",
                saltLakeCityToLasVegas, saltLakeCityToLasVegasRect);

        calgaryToWinnipeg.moveTo(maxX * .224f, maxY * .05f);
        calgaryToWinnipeg.lineTo(maxX * .227f, maxY * .063f);
        calgaryToWinnipeg.lineTo(maxX * .258f, maxY * .045f);
        calgaryToWinnipeg.lineTo(maxX * .255f, maxY * .032f);
        calgaryToWinnipeg.close();
        calgaryToWinnipeg.moveTo(maxX * .261f, maxY * .031f);
        calgaryToWinnipeg.lineTo(maxX * .263f, maxY * .044f);
        calgaryToWinnipeg.lineTo(maxX * .294f, maxY * .036f);
        calgaryToWinnipeg.lineTo(maxX * .291f, maxY * .021f);
        calgaryToWinnipeg.close();
        calgaryToWinnipeg.moveTo(maxX * .297f, maxY * .019f);
        calgaryToWinnipeg.lineTo(maxX * .298f, maxY * .032f);
        calgaryToWinnipeg.lineTo(maxX * .332f, maxY * .032f);
        calgaryToWinnipeg.lineTo(maxX * .332f, maxY * .019f);
        calgaryToWinnipeg.close();
        calgaryToWinnipeg.moveTo(maxX * .338f, maxY * .018f);
        calgaryToWinnipeg.lineTo(maxX * .337f, maxY * .031f);
        calgaryToWinnipeg.lineTo(maxX * .366f, maxY * .033f);
        calgaryToWinnipeg.lineTo(maxX * .367f, maxY * .021f);
        calgaryToWinnipeg.close();
        calgaryToWinnipeg.moveTo(maxX * .376f, maxY * .022f);
        calgaryToWinnipeg.lineTo(maxX * .374f, maxY * .034f);
        calgaryToWinnipeg.lineTo(maxX * .405f, maxY * .048f);
        calgaryToWinnipeg.lineTo(maxX * .408f, maxY * .034f);
        calgaryToWinnipeg.close();
        calgaryToWinnipeg.moveTo(maxX * .416f, maxY * .037f);
        calgaryToWinnipeg.lineTo(maxX * .414f, maxY * .052f);
        calgaryToWinnipeg.lineTo(maxX * .443f, maxY * .072f);
        calgaryToWinnipeg.lineTo(maxX * .445f, maxY * .063f);
        calgaryToWinnipeg.close();
        calgaryToWinnipegTrack  = new Track(6, "White", "Calgary", "Winnipeg",
                calgaryToWinnipeg, calgaryToWinnipegRect);

        calgaryToHelena.moveTo(maxX * .228f, maxY * .082f);
        calgaryToHelena.lineTo(maxX * .220f, maxY * .093f);
        calgaryToHelena.lineTo(maxX * .241f, maxY * .132f);
        calgaryToHelena.lineTo(maxX * .246f, maxY * .126f);
        calgaryToHelena.close();
        calgaryToHelena.moveTo(maxX * .251f, maxY * .129f);
        calgaryToHelena.lineTo(maxX * .243f, maxY * .135f);
        calgaryToHelena.lineTo(maxX * .264f, maxY * .174f);
        calgaryToHelena.lineTo(maxX * .271f, maxY * .168f);
        calgaryToHelena.close();
        calgaryToHelena.moveTo(maxX * .276f, maxY * .171f);
        calgaryToHelena.lineTo(maxX * .268f, maxY * .179f);
        calgaryToHelena.lineTo(maxX * .289f, maxY * .221f);
        calgaryToHelena.lineTo(maxX * .299f, maxY * .208f);
        calgaryToHelena.close();
        calgaryToHelena.moveTo(maxX * .301f, maxY * .223f);
        calgaryToHelena.lineTo(maxX * .295f, maxY * .231f);
        calgaryToHelena.lineTo(maxX * .313f, maxY * .269f);
        calgaryToHelena.lineTo(maxX * .323f, maxY * .263f);
        calgaryToHelena.close();
        calgaryToHelenaTrack = new Track(4, "Gray", "Calgary", "Helena",
                calgaryToHelena, calgaryToHelenaRect);

        helenaToSaltLakeCity.moveTo(maxX * .251f, maxY * .458f);
        helenaToSaltLakeCity.lineTo(maxX * .259f, maxY * .464f);
        helenaToSaltLakeCity.lineTo(maxX * .275f, maxY * .421f);
        helenaToSaltLakeCity.lineTo(maxX * .268f, maxY * .415f);
        helenaToSaltLakeCity.close();
        helenaToSaltLakeCity.moveTo(maxX * .270f, maxY * .408f);
        helenaToSaltLakeCity.lineTo(maxX * .277f, maxY * .412f);
        helenaToSaltLakeCity.lineTo(maxX * .292f, maxY * .369f);
        helenaToSaltLakeCity.lineTo(maxX * .285f, maxY * .360f);
        helenaToSaltLakeCity.close();
        helenaToSaltLakeCity.moveTo(maxX * .287f, maxY * .354f);
        helenaToSaltLakeCity.lineTo(maxX * .298f, maxY * .360f);
        helenaToSaltLakeCity.lineTo(maxX * .318f, maxY * .312f);
        helenaToSaltLakeCity.lineTo(maxX * .308f, maxY * .304f);
        helenaToSaltLakeCity.close();
        helenaToSaltLakeCityTrack = new Track(3, "Pin", "Helena", "SaltLakeCity",
                helenaToSaltLakeCity, helenaToSaltLakeCityRect);

        saltLakeCityToDenver.moveTo(maxX * .259f, maxY * .483f);
        saltLakeCityToDenver.lineTo(maxX * .258f, maxY * .497f);
        saltLakeCityToDenver.lineTo(maxX * .288f, maxY * .504f);
        saltLakeCityToDenver.lineTo(maxX * .291f, maxY * .491f);
        saltLakeCityToDenver.close();
        saltLakeCityToDenver.moveTo(maxX * .294f, maxY * .491f);
        saltLakeCityToDenver.lineTo(maxX * .293f, maxY * .506f);
        saltLakeCityToDenver.lineTo(maxX * .325f, maxY * .519f);
        saltLakeCityToDenver.lineTo(maxX * .326f, maxY * .502f);
        saltLakeCityToDenver.close();
        saltLakeCityToDenver.moveTo(maxX * .330f, maxY * .503f);
        saltLakeCityToDenver.lineTo(maxX * .329f, maxY * .518f);
        saltLakeCityToDenver.lineTo(maxX * .361f, maxY * .531f);
        saltLakeCityToDenver.lineTo(maxX * .362f, maxY * .514f);
        saltLakeCityToDenver.close();
        saltLakeCityToDenverTrack = new Track(3, "Red", "SaltLakeCity", "Denver",
                saltLakeCityToDenver, saltLakeCityToDenverRect);

        saltLakeCityToDenver2.moveTo(maxX * .257f, maxY * .498f);
        saltLakeCityToDenver2.lineTo(maxX * .256f, maxY * .512f);
        saltLakeCityToDenver2.lineTo(maxX * .286f, maxY * .519f);
        saltLakeCityToDenver2.lineTo(maxX * .289f, maxY * .506f);
        saltLakeCityToDenver2.close();
        saltLakeCityToDenver2.moveTo(maxX * .292f, maxY * .506f);
        saltLakeCityToDenver2.lineTo(maxX * .291f, maxY * .521f);
        saltLakeCityToDenver2.lineTo(maxX * .323f, maxY * .534f);
        saltLakeCityToDenver2.lineTo(maxX * .324f, maxY * .517f);
        saltLakeCityToDenver2.close();
        saltLakeCityToDenver2.moveTo(maxX * .328f, maxY * .518f);
        saltLakeCityToDenver2.lineTo(maxX * .327f, maxY * .533f);
        saltLakeCityToDenver2.lineTo(maxX * .359f, maxY * .546f);
        saltLakeCityToDenver2.lineTo(maxX * .360f, maxY * .529f);
        saltLakeCityToDenver2.close();
        saltLakeCityToDenverTrack2 = new Track(3, "Yellow", "SaltLakeCity", "Denver",
                saltLakeCityToDenver2, saltLakeCityToDenverRect);

        phoenixToDenver.moveTo(maxX * .243f, maxY * .773f);
        phoenixToDenver.lineTo(maxX * .252f, maxY * .778f);
        phoenixToDenver.lineTo(maxX * .263f, maxY * .723f);
        phoenixToDenver.lineTo(maxX * .254f, maxY * .720f);
        phoenixToDenver.close();
        phoenixToDenver.moveTo(maxX * .258f, maxY * .715f);
        phoenixToDenver.lineTo(maxX * .265f, maxY * .717f);
        phoenixToDenver.lineTo(maxX * .283f, maxY * .676f);
        phoenixToDenver.lineTo(maxX * .276f, maxY * .666f);
        phoenixToDenver.close();
        phoenixToDenver.moveTo(maxX * .275f, maxY * .658f);
        phoenixToDenver.lineTo(maxX * .283f, maxY * .669f);
        phoenixToDenver.lineTo(maxX * .303f, maxY * .628f);
        phoenixToDenver.lineTo(maxX * .296f, maxY * .616f);
        phoenixToDenver.close();
        phoenixToDenver.moveTo(maxX * .301f, maxY * .611f);
        phoenixToDenver.lineTo(maxX * .309f, maxY * .619f);
        phoenixToDenver.lineTo(maxX * .330f, maxY * .590f);
        phoenixToDenver.lineTo(maxX * .326f, maxY * .58f);
        phoenixToDenver.close();
        phoenixToDenver.moveTo(maxX * .334f, maxY * .572f);
        phoenixToDenver.lineTo(maxX * .336f, maxY * .582f);
        phoenixToDenver.lineTo(maxX * .369f, maxY * .566f);
        phoenixToDenver.lineTo(maxX * .365f, maxY * .556f);
        phoenixToDenver.close();
        phoenixToDenverTrack = new Track(5, "White", "Phoenix", "Denver",
                phoenixToDenver, phoenixToDenverRect);


        phoenixToSantaFe.moveTo(maxX * .260f, maxY * .770f);
        phoenixToSantaFe.lineTo(maxX * .263f, maxY * .781f);
        phoenixToSantaFe.lineTo(maxX * .293f, maxY * .764f);
        phoenixToSantaFe.lineTo(maxX * .290f, maxY * .751f);
        phoenixToSantaFe.close();
        phoenixToSantaFe.moveTo(maxX * .293f, maxY * .748f);
        phoenixToSantaFe.lineTo(maxX * .298f, maxY * .761f);
        phoenixToSantaFe.lineTo(maxX * .329f, maxY * .738f);
        phoenixToSantaFe.lineTo(maxX * .325f, maxY * .727f);
        phoenixToSantaFe.close();
        phoenixToSantaFe.moveTo(maxX * .326f, maxY * .726f);
        phoenixToSantaFe.lineTo(maxX * .332f, maxY * .735f);
        phoenixToSantaFe.lineTo(maxX * .365f, maxY * .717f);
        phoenixToSantaFe.lineTo(maxX * .360f, maxY * .7f);
        phoenixToSantaFe.close();
        phoenixToSantaFeTrack = new Track(3, "Gray", "Phoenix", "SantaFe",
                phoenixToSantaFe, phoenixToSantaFeRect);

        phoenixToElPaso.moveTo(maxX * .255f, maxY * .789f);
        phoenixToElPaso.lineTo(maxX * .250f, maxY * .806f);
        phoenixToElPaso.lineTo(maxX * .283f, maxY * .816f);
        phoenixToElPaso.lineTo(maxX * .287f, maxY * .800f);
        phoenixToElPaso.close();
        phoenixToElPaso.moveTo(maxX * .290f, maxY * .805f);
        phoenixToElPaso.lineTo(maxX * .286f, maxY * .821f);
        phoenixToElPaso.lineTo(maxX * .321f, maxY * .832f);
        phoenixToElPaso.lineTo(maxX * .325f, maxY * .816f);
        phoenixToElPaso.close();
        phoenixToElPaso.moveTo(maxX * .328f, maxY * .818f);
        phoenixToElPaso.lineTo(maxX * .324f, maxY * .835f);
        phoenixToElPaso.lineTo(maxX * .356f, maxY * .849f);
        phoenixToElPaso.lineTo(maxX * .360f, maxY * .833f);
        phoenixToElPaso.close();
        phoenixToElPasoTrack = new Track(3, "Gray", "Phoenix", "ElPaso",
                phoenixToElPaso, phoenixToElPasoRect);

        helenaToWinnipeg.moveTo(maxX * .328f, maxY * .263f);
        helenaToWinnipeg.lineTo(maxX * .337f, maxY * .271f);
        helenaToWinnipeg.lineTo(maxX * .359f, maxY * .234f);
        helenaToWinnipeg.lineTo(maxX * .35f, maxY * .224f);
        helenaToWinnipeg.close();
        helenaToWinnipeg.moveTo(maxX * .355f, maxY * .219f);
        helenaToWinnipeg.lineTo(maxX * .364f, maxY * .229f);
        helenaToWinnipeg.lineTo(maxX * .386f, maxY * .190f);
        helenaToWinnipeg.lineTo(maxX * .380f, maxY * .176f);
        helenaToWinnipeg.close();
        helenaToWinnipeg.moveTo(maxX * .385f, maxY * .173f);
        helenaToWinnipeg.lineTo(maxX * .391f, maxY * .183f);
        helenaToWinnipeg.lineTo(maxX * .413f, maxY * .146f);
        helenaToWinnipeg.lineTo(maxX * .407f, maxY * .132f);
        helenaToWinnipeg.close();
        helenaToWinnipeg.moveTo(maxX * .412f, maxY * .129f);
        helenaToWinnipeg.lineTo(maxX * .418f, maxY * .139f);
        helenaToWinnipeg.lineTo(maxX * .440f, maxY * .103f);
        helenaToWinnipeg.lineTo(maxX * .434f, maxY * .092f);
        helenaToWinnipeg.close();
        helenaToWinnipegTrack = new Track(4, "Blue", "Helena", "Winnipeg",
                helenaToWinnipeg, helenaToWinnipegRect);

        helenaToDenver.moveTo(maxX * .330f, maxY * .3f);
        helenaToDenver.lineTo(maxX * .320f, maxY * .307f);
        helenaToDenver.lineTo(maxX * .334f, maxY * .356f);
        helenaToDenver.lineTo(maxX * .341f, maxY * .351f);
        helenaToDenver.close();
        helenaToDenver.moveTo(maxX * .342f, maxY * .354f);
        helenaToDenver.lineTo(maxX * .336f, maxY * .361f);
        helenaToDenver.lineTo(maxX * .347f, maxY * .410f);
        helenaToDenver.lineTo(maxX * .357f, maxY * .405f);
        helenaToDenver.close();
        helenaToDenver.moveTo(maxX * .358f, maxY * .412f);
        helenaToDenver.lineTo(maxX * .349f, maxY * .418f);
        helenaToDenver.lineTo(maxX * .363f, maxY * .467f);
        helenaToDenver.lineTo(maxX * .370f, maxY * .465f);
        helenaToDenver.close();
        helenaToDenver.moveTo(maxX * .371f, maxY * .468f);
        helenaToDenver.lineTo(maxX * .362f, maxY * .472f);
        helenaToDenver.lineTo(maxX * .376f, maxY * .521f);
        helenaToDenver.lineTo(maxX * .382f, maxY * .514f);
        helenaToDenver.close();
        helenaToDenverTrack = new Track(4, "Green", "Helena", "Denver",
                helenaToDenver, helenaToDenverRect);

        denverToSantaFe.moveTo(maxX * .381f, maxY * .572f);
        denverToSantaFe.lineTo(maxX * .370f, maxY * .570f);
        denverToSantaFe.lineTo(maxX * .368f, maxY * .623f);
        denverToSantaFe.lineTo(maxX * .379f, maxY * .624f);
        denverToSantaFe.close();
        denverToSantaFe.moveTo(maxX * .381f, maxY * .629f);
        denverToSantaFe.lineTo(maxX * .370f, maxY * .631f);
        denverToSantaFe.lineTo(maxX * .367f, maxY * .684f);
        denverToSantaFe.lineTo(maxX * .378f, maxY * .685f);
        denverToSantaFe.close();
        denverToSantaFeTrack = new Track(2, "Gray", "Denver", "SantaFe",
                denverToSantaFe, denverToSantaFeRect);

        santaFeToElPaso.moveTo(maxX * .375f, maxY * .721f);
        santaFeToElPaso.lineTo(maxX * .365f, maxY * .720f);
        santaFeToElPaso.lineTo(maxX * .362f, maxY * .773f);
        santaFeToElPaso.lineTo(maxX * .374f, maxY * .774f);
        santaFeToElPaso.close();
        santaFeToElPaso.moveTo(maxX * .374f, maxY * .781f);
        santaFeToElPaso.lineTo(maxX * .364f, maxY * .780f);
        santaFeToElPaso.lineTo(maxX * .361f, maxY * .831f);
        santaFeToElPaso.lineTo(maxX * .373f, maxY * .832f);
        santaFeToElPaso.close();
        santaFeToElPasoTrack = new Track(2, "Gray", "SantaFe", "ElPaso",
                santaFeToElPaso, santaFeToElPasoRect);

        helenaToDuluth.moveTo(maxX * .332f, maxY * .280f);
        helenaToDuluth.lineTo(maxX * .332f, maxY * .297f);
        helenaToDuluth.lineTo(maxX * .368f, maxY * .297f);
        helenaToDuluth.lineTo(maxX * .368f, maxY * .279f);
        helenaToDuluth.close();
        helenaToDuluth.moveTo(maxX * .372f, maxY * .279f);
        helenaToDuluth.lineTo(maxX * .372f, maxY * .296f);
        helenaToDuluth.lineTo(maxX * .406f, maxY * .296f);
        helenaToDuluth.lineTo(maxX * .406f, maxY * .278f);
        helenaToDuluth.close();
        helenaToDuluth.moveTo(maxX * .410f, maxY * .278f);
        helenaToDuluth.lineTo(maxX * .410f, maxY * .296f);
        helenaToDuluth.lineTo(maxX * .444f, maxY * .296f);
        helenaToDuluth.lineTo(maxX * .444f, maxY * .278f);
        helenaToDuluth.close();
        helenaToDuluth.moveTo(maxX * .448f, maxY * .276f);
        helenaToDuluth.lineTo(maxX * .448f, maxY * .294f);
        helenaToDuluth.lineTo(maxX * .483f, maxY * .294f);
        helenaToDuluth.lineTo(maxX * .483f, maxY * .276f);
        helenaToDuluth.close();
        helenaToDuluth.moveTo(maxX * .487f, maxY * .273f);
        helenaToDuluth.lineTo(maxX * .487f, maxY * .291f);
        helenaToDuluth.lineTo(maxX * .521f, maxY * .291f);
        helenaToDuluth.lineTo(maxX * .521f, maxY * .272f);
        helenaToDuluth.close();
        helenaToDuluth.moveTo(maxX * .525f, maxY * .272f);
        helenaToDuluth.lineTo(maxX * .525f, maxY * .291f);
        helenaToDuluth.lineTo(maxX * .559f, maxY * .290f);
        helenaToDuluth.lineTo(maxX * .559f, maxY * .271f);
        helenaToDuluth.close();
        helenaToDuluthTrack = new Track(6, "Orange", "Helena", "Duluth",
                helenaToDuluth, helenaToDuluthRect);

        newOrleansToAtlanta.moveTo(maxX * .716f, maxY * .784f);
        newOrleansToAtlanta.lineTo(maxX * .726f, maxY * .793f);
        newOrleansToAtlanta.lineTo(maxX * .71f, maxY * .84f);
        newOrleansToAtlanta.lineTo(maxX * .7f, maxY * .835f);
        newOrleansToAtlanta.close();
        newOrleansToAtlanta.moveTo(maxX * .737f, maxY * .73f);
        newOrleansToAtlanta.lineTo(maxX * .748f, maxY * .74f);
        newOrleansToAtlanta.lineTo(maxX * .727f, maxY * .787f);
        newOrleansToAtlanta.lineTo(maxX * .716f, maxY * .775f);
        newOrleansToAtlanta.close();
        newOrleansToAtlanta.moveTo(maxX * .763f, maxY * .685f);
        newOrleansToAtlanta.lineTo(maxX * .77f, maxY * .695f);
        newOrleansToAtlanta.lineTo(maxX * .75f, maxY * .733f);
        newOrleansToAtlanta.lineTo(maxX * .74f, maxY * .725f);
        newOrleansToAtlanta.close();
        newOrleansToAtlanta.moveTo(maxX * .792f, maxY * .638f);
        newOrleansToAtlanta.lineTo(maxX * .8f, maxY * .657f);
        newOrleansToAtlanta.lineTo(maxX * .775f, maxY * .693f);
        newOrleansToAtlanta.lineTo(maxX * .764f, maxY * .68f);
        newOrleansToAtlanta.close();
        newOrleansToAtlantaTrack = new Track(4, "Yellow", "New Orleans", "Atlanta",
                newOrleansToAtlanta, newOrleansToAtlantaRect);

        newOrleansToAtlanta2.moveTo(maxX * .725f, maxY * .804f);
        newOrleansToAtlanta2.lineTo(maxX * .735f, maxY * .813f);
        newOrleansToAtlanta2.lineTo(maxX * .719f, maxY * .86f);
        newOrleansToAtlanta2.lineTo(maxX * .709f, maxY * .855f);
        newOrleansToAtlanta2.close();
        newOrleansToAtlanta2.moveTo(maxX * .746f, maxY * .75f);
        newOrleansToAtlanta2.lineTo(maxX * .757f, maxY * .76f);
        newOrleansToAtlanta2.lineTo(maxX * .736f, maxY * .807f);
        newOrleansToAtlanta2.lineTo(maxX * .725f, maxY * .795f);
        newOrleansToAtlanta2.close();
        newOrleansToAtlanta2.moveTo(maxX * .772f, maxY * .705f);
        newOrleansToAtlanta2.lineTo(maxX * .779f, maxY * .715f);
        newOrleansToAtlanta2.lineTo(maxX * .759f, maxY * .753f);
        newOrleansToAtlanta2.lineTo(maxX * .749f, maxY * .745f);
        newOrleansToAtlanta2.close();
        newOrleansToAtlanta2.moveTo(maxX * .801f, maxY * .658f);
        newOrleansToAtlanta2.lineTo(maxX * .809f, maxY * .677f);
        newOrleansToAtlanta2.lineTo(maxX * .784f, maxY * .713f);
        newOrleansToAtlanta2.lineTo(maxX * .773f, maxY * .700f);
        newOrleansToAtlanta2.close();
        newOrleansToAtlantaTrack2 = new Track(4, "Orange", "New Orleans", "Atlanta",
                newOrleansToAtlanta2, newOrleansToAtlantaRect);

        nashvilleToAtlanta.moveTo(maxX * .757f, maxY * .605f);
        nashvilleToAtlanta.lineTo(maxX * .764f, maxY * .586f);
        nashvilleToAtlanta.lineTo(maxX * .797f, maxY * .62f);
        nashvilleToAtlanta.lineTo(maxX * .788f, maxY * .637f);
        nashvilleToAtlanta.close();
        nashvilleToAtlantaTrack = new Track(1, "Gray", "Nashville", "Atlanta",
                nashvilleToAtlanta, nashvilleToAtlantaRect);

        nashvilleToRaleigh.moveTo(maxX * .756f, maxY * .565f);
        nashvilleToRaleigh.lineTo(maxX * .789f, maxY * .535f);
        nashvilleToRaleigh.lineTo(maxX * .794f, maxY * .553f);
        nashvilleToRaleigh.lineTo(maxX * .762f, maxY * .58f);
        nashvilleToRaleigh.close();
        nashvilleToRaleigh.moveTo(maxX * .79f, maxY * .53f);
        nashvilleToRaleigh.lineTo(maxX * .83f, maxY * .52f);
        nashvilleToRaleigh.lineTo(maxX * .831f, maxY * .537f);
        nashvilleToRaleigh.lineTo(maxX * .795f, maxY * .55f);
        nashvilleToRaleigh.close();
        nashvilleToRaleigh.moveTo(maxX * .834f, maxY * .52f);
        nashvilleToRaleigh.lineTo(maxX * .869f, maxY * .522f);
        nashvilleToRaleigh.lineTo(maxX * .868f, maxY * .542f);
        nashvilleToRaleigh.lineTo(maxX * .834f, maxY * .54f);
        nashvilleToRaleigh.close();
        nashvilleToRaleighTrack = new Track(3, "Black", "Nashville", "Raleigh",
                nashvilleToRaleigh, nashvilleToRaleighRect);

        nashvilleToPittsburgh.moveTo(maxX * .754f, maxY * .518f);
        nashvilleToPittsburgh.lineTo(maxX * .763f, maxY * .527f);
        nashvilleToPittsburgh.lineTo(maxX * .745f, maxY * .578f);
        nashvilleToPittsburgh.lineTo(maxX * .734f, maxY * .572f);
        nashvilleToPittsburgh.close();
        nashvilleToPittsburgh.moveTo(maxX * .775f, maxY * .471f);
        nashvilleToPittsburgh.lineTo(maxX * .784f, maxY * .48f);
        nashvilleToPittsburgh.lineTo(maxX * .764f, maxY * .523f);
        nashvilleToPittsburgh.lineTo(maxX * .755f, maxY * .51f);
        nashvilleToPittsburgh.close();
        nashvilleToPittsburgh.moveTo(maxX * .81f, maxY * .43f);
        nashvilleToPittsburgh.lineTo(maxX * .818f, maxY * .447f);
        nashvilleToPittsburgh.lineTo(maxX * .787f, maxY * .478f);
        nashvilleToPittsburgh.lineTo(maxX * .783f, maxY * .467f);
        nashvilleToPittsburgh.close();
        nashvilleToPittsburgh.moveTo(maxX * .833f, maxY * .388f);
        nashvilleToPittsburgh.lineTo(maxX * .845f, maxY * .4f);
        nashvilleToPittsburgh.lineTo(maxX * .822f, maxY * .45f);
        nashvilleToPittsburgh.lineTo(maxX * .813f, maxY * .432f);
        nashvilleToPittsburgh.close();
        nashvilleToPittsburghTrack = new Track(4, "Yellow", "Nashville", "Pittsburgh",
                nashvilleToPittsburgh, nashvilleToPittsburghRect);

        saintLouisToPittsburgh.moveTo(maxX * .693f, maxY * .49f);
        saintLouisToPittsburgh.lineTo(maxX * .7f, maxY * .505f);
        saintLouisToPittsburgh.lineTo(maxX * .667f, maxY * .53f);
        saintLouisToPittsburgh.lineTo(maxX * .663f, maxY * .518f);
        saintLouisToPittsburgh.close();
        saintLouisToPittsburgh.moveTo(maxX * .725f, maxY * .457f);
        saintLouisToPittsburgh.lineTo(maxX * .733f, maxY * .468f);
        saintLouisToPittsburgh.lineTo(maxX * .7f, maxY * .504f);
        saintLouisToPittsburgh.lineTo(maxX * .694f, maxY * .487f);
        saintLouisToPittsburgh.close();
        saintLouisToPittsburgh.moveTo(maxX * .761f, maxY * .43f);
        saintLouisToPittsburgh.lineTo(maxX * .766f, maxY * .443f);
        saintLouisToPittsburgh.lineTo(maxX * .734f, maxY * .468f);
        saintLouisToPittsburgh.lineTo(maxX * .73f, maxY * .455f);
        saintLouisToPittsburgh.close();
        saintLouisToPittsburgh.moveTo(maxX * .79f, maxY * .4f);
        saintLouisToPittsburgh.lineTo(maxX * .797f, maxY * .413f);
        saintLouisToPittsburgh.lineTo(maxX * .767f, maxY * .44f);
        saintLouisToPittsburgh.lineTo(maxX * .763f, maxY * .425f);
        saintLouisToPittsburgh.close();
        saintLouisToPittsburgh.moveTo(maxX * .827f, maxY * .37f);
        saintLouisToPittsburgh.lineTo(maxX * .833f, maxY * .385f);
        saintLouisToPittsburgh.lineTo(maxX * .8f, maxY * .41f);
        saintLouisToPittsburgh.lineTo(maxX * .793f, maxY * .396f);
        saintLouisToPittsburgh.close();
        saintLouisToPittsburghTrack = new Track(5, "Green", "Saint Louis", "Pittsburgh",
                saintLouisToPittsburgh, saintLouisToPittsburghRect);

        chicagoToPittsburgh.moveTo(maxX * .708f, maxY * .345f);
        chicagoToPittsburgh.lineTo(maxX * .745f, maxY * .335f);
        chicagoToPittsburgh.lineTo(maxX * .745f, maxY * .354f);
        chicagoToPittsburgh.lineTo(maxX * .712f, maxY * .37f);
        chicagoToPittsburgh.close();
        chicagoToPittsburgh.moveTo(maxX * .75f, maxY * .33f);
        chicagoToPittsburgh.lineTo(maxX * .78f, maxY * .324f);
        chicagoToPittsburgh.lineTo(maxX * .783f, maxY * .345f);
        chicagoToPittsburgh.lineTo(maxX * .752f, maxY * .355f);
        chicagoToPittsburgh.close();
        chicagoToPittsburgh.moveTo(maxX * .785f, maxY * .325f);
        chicagoToPittsburgh.lineTo(maxX * .823f, maxY * .328f);
        chicagoToPittsburgh.lineTo(maxX * .821f, maxY * .348f);
        chicagoToPittsburgh.lineTo(maxX * .788f, maxY * .344f);
        chicagoToPittsburgh.close();
        chicagoToPittsburghTrack = new Track(3, " Orange", "Chicago", "Pittsburgh",
                chicagoToPittsburgh, chicagoToPittsburghRect);

        chicagoToPittsburgh2.moveTo(maxX * .713f, maxY * .371f);
        chicagoToPittsburgh2.lineTo(maxX * .75f, maxY * .361f);
        chicagoToPittsburgh2.lineTo(maxX * .75f, maxY * .38f);
        chicagoToPittsburgh2.lineTo(maxX * .717f, maxY * .396f);
        chicagoToPittsburgh2.close();
        chicagoToPittsburgh2.moveTo(maxX * .755f, maxY * .356f);
        chicagoToPittsburgh2.lineTo(maxX * .785f, maxY * .350f);
        chicagoToPittsburgh2.lineTo(maxX * .788f, maxY * .371f);
        chicagoToPittsburgh2.lineTo(maxX * .757f, maxY * .381f);
        chicagoToPittsburgh2.close();
        chicagoToPittsburgh2.moveTo(maxX * .79f, maxY * .351f);
        chicagoToPittsburgh2.lineTo(maxX * .828f, maxY * .354f);
        chicagoToPittsburgh2.lineTo(maxX * .826f, maxY * .374f);
        chicagoToPittsburgh2.lineTo(maxX * .793f, maxY * .370f);
        chicagoToPittsburgh2.close();
        chicagoToPittsburghTrack2 = new Track(3, " Black", "Chicago", "Pittsburgh",
                chicagoToPittsburgh2, chicagoToPittsburghRect);

        chicagoToToronto.moveTo(maxX * .715f, maxY * .309f);
        chicagoToToronto.lineTo(maxX * .724f, maxY * .32f);
        chicagoToToronto.lineTo(maxX * .7f, maxY * .36f);
        chicagoToToronto.lineTo(maxX * .692f, maxY * .348f);
        chicagoToToronto.close();
        chicagoToToronto.moveTo(maxX * .748f, maxY * .27f);
        chicagoToToronto.lineTo(maxX * .752f, maxY * .28f);
        chicagoToToronto.lineTo(maxX * .725f, maxY * .317f);
        chicagoToToronto.lineTo(maxX * .719f, maxY * .302f);
        chicagoToToronto.close();
        chicagoToToronto.moveTo(maxX * .787f, maxY * .255f);
        chicagoToToronto.lineTo(maxX * .79f, maxY * .265f);
        chicagoToToronto.lineTo(maxX * .757f, maxY * .28f);
        chicagoToToronto.lineTo(maxX * .752f, maxY * .267f);
        chicagoToToronto.close();
        chicagoToToronto.moveTo(maxX * .816f, maxY * .215f);
        chicagoToToronto.lineTo(maxX * .824f, maxY * .227f);
        chicagoToToronto.lineTo(maxX * .795f, maxY * .264f);
        chicagoToToronto.lineTo(maxX * .79f, maxY * .248f);
        chicagoToToronto.close();
        chicagoToTorontoTrack = new Track(4, "White", "Chicago", "Toronto",
                chicagoToToronto, chicagoToTorontoRect);


        saultSteMarieToToronto.moveTo(maxX * .723f, maxY * .165f);
        saultSteMarieToToronto.lineTo(maxX * .76f, maxY * .176f);
        saultSteMarieToToronto.lineTo(maxX * .758f, maxY * .19f);
        saultSteMarieToToronto.lineTo(maxX * .72f, maxY * .18f);
        saultSteMarieToToronto.close();
        saultSteMarieToToronto.moveTo(maxX * .765f, maxY * .178f);
        saultSteMarieToToronto.lineTo(maxX * .8f, maxY * .187f);
        saultSteMarieToToronto.lineTo(maxX * .797f, maxY * .203f);
        saultSteMarieToToronto.lineTo(maxX * .762f, maxY * .192f);
        saultSteMarieToToronto.close();
        saultSteMarieToTorontoTrack = new Track(2, "Gray", "Sault Ste Marie", "Toronto",
                saultSteMarieToToronto, saultSteMarieToTorontoRect);


        helenaToOmaha.moveTo(maxX * .344f, maxY * .302f);
        helenaToOmaha.lineTo(maxX * .340f, maxY * .316f);
        helenaToOmaha.lineTo(maxX * .374f, maxY * .337f);
        helenaToOmaha.lineTo(maxX * .378f, maxY * .323f);
        helenaToOmaha.close();
        helenaToOmaha.moveTo(maxX * .381f, maxY * .326f);
        helenaToOmaha.lineTo(maxX * .377f, maxY * .340f);
        helenaToOmaha.lineTo(maxX * .410f, maxY * .361f);
        helenaToOmaha.lineTo(maxX * .414f, maxY * .347f);
        helenaToOmaha.close();
        helenaToOmaha.moveTo(maxX * .417f, maxY * .350f);
        helenaToOmaha.lineTo(maxX * .413f, maxY * .364f);
        helenaToOmaha.lineTo(maxX * .444f, maxY * .385f);
        helenaToOmaha.lineTo(maxX * .448f, maxY * .371f);
        helenaToOmaha.close();
        helenaToOmaha.moveTo(maxX * .452f, maxY * .372f);
        helenaToOmaha.lineTo(maxX * .449f, maxY * .384f);
        helenaToOmaha.lineTo(maxX * .480f, maxY * .403f);
        helenaToOmaha.lineTo(maxX * .484f, maxY * .393f);
        helenaToOmaha.close();
        helenaToOmaha.moveTo(maxX * .489f, maxY * .394f);
        helenaToOmaha.lineTo(maxX * .484f, maxY * .413f);
        helenaToOmaha.lineTo(maxX * .513f, maxY * .431f);
        helenaToOmaha.lineTo(maxX * .518f, maxY * .416f);
        helenaToOmaha.close();
        helenaToOmahaTrack = new Track(5, "Red", "Helena", "Omaha",
                helenaToOmaha, helenaToOmahaRect);

        denverToOmaha.moveTo(maxX * .389f, maxY * .524f);
        denverToOmaha.lineTo(maxX * .391f, maxY * .534f);
        denverToOmaha.lineTo(maxX * .420f, maxY * .503f);
        denverToOmaha.lineTo(maxX * .415f, maxY * .492f);
        denverToOmaha.close();
        denverToOmaha.moveTo(maxX * .421f, maxY * .486f);
        denverToOmaha.lineTo(maxX * .425f, maxY * .496f);
        denverToOmaha.lineTo(maxX * .452f, maxY * .479f);
        denverToOmaha.lineTo(maxX * .448f, maxY * .468f);
        denverToOmaha.close();
        denverToOmaha.moveTo(maxX * .452f, maxY * .461f);
        denverToOmaha.lineTo(maxX * .456f, maxY * .476f);
        denverToOmaha.lineTo(maxX * .487f, maxY * .460f);
        denverToOmaha.lineTo(maxX * .484f, maxY * .445f);
        denverToOmaha.close();
        denverToOmaha.moveTo(maxX * .489f, maxY * .442f);
        denverToOmaha.lineTo(maxX * .493f, maxY * .456f);
        denverToOmaha.lineTo(maxX * .528f, maxY * .445f);
        denverToOmaha.lineTo(maxX * .527f, maxY * .431f);
        denverToOmaha.close();
        denverToOmahaTrack = new Track(4, "Pink", "Denver", "Omaha",
                denverToOmaha, denverToOmahaRect);

        denverToKansasCity.moveTo(maxX * .400f, maxY * .541f);
        denverToKansasCity.lineTo(maxX * .399f, maxY * .558f);
        denverToKansasCity.lineTo(maxX * .434f, maxY * .560f);
        denverToKansasCity.lineTo(maxX * .434f, maxY * .543f);
        denverToKansasCity.close();
        denverToKansasCity.moveTo(maxX * .438f, maxY * .544f);
        denverToKansasCity.lineTo(maxX * .439f, maxY * .561f);
        denverToKansasCity.lineTo(maxX * .471f, maxY * .560f);
        denverToKansasCity.lineTo(maxX * .472f, maxY * .541f);
        denverToKansasCity.close();
        denverToKansasCity.moveTo(maxX * .475f, maxY * .541f);
        denverToKansasCity.lineTo(maxX * .477f, maxY * .558f);
        denverToKansasCity.lineTo(maxX * .511f, maxY * .548f);
        denverToKansasCity.lineTo(maxX * .509f, maxY * .530f);
        denverToKansasCity.close();
        denverToKansasCity.moveTo(maxX * .515f, maxY * .529f);
        denverToKansasCity.lineTo(maxX * .518f, maxY * .544f);
        denverToKansasCity.lineTo(maxX * .547f, maxY * .522f);
        denverToKansasCity.lineTo(maxX * .543f, maxY * .504f);
        denverToKansasCity.close();
        denverToKansasCityTrack = new Track(4, "Black", "Denver", "KansasCity",
                denverToKansasCity, denverToKansasCityRect);

        denverToKansasCity2.moveTo(maxX * .400f, maxY * .559f);
        denverToKansasCity2.lineTo(maxX * .399f, maxY * .576f);
        denverToKansasCity2.lineTo(maxX * .434f, maxY * .578f);
        denverToKansasCity2.lineTo(maxX * .434f, maxY * .561f);
        denverToKansasCity2.close();
        denverToKansasCity2.moveTo(maxX * .438f, maxY * .562f);
        denverToKansasCity2.lineTo(maxX * .439f, maxY * .579f);
        denverToKansasCity2.lineTo(maxX * .471f, maxY * .578f);
        denverToKansasCity2.lineTo(maxX * .472f, maxY * .559f);
        denverToKansasCity2.close();
        denverToKansasCity2.moveTo(maxX * .475f, maxY * .559f);
        denverToKansasCity2.lineTo(maxX * .477f, maxY * .576f);
        denverToKansasCity2.lineTo(maxX * .511f, maxY * .566f);
        denverToKansasCity2.lineTo(maxX * .509f, maxY * .548f);
        denverToKansasCity2.close();
        denverToKansasCity2.moveTo(maxX * .515f, maxY * .547f);
        denverToKansasCity2.lineTo(maxX * .518f, maxY * .562f);
        denverToKansasCity2.lineTo(maxX * .547f, maxY * .540f);
        denverToKansasCity2.lineTo(maxX * .543f, maxY * .522f);
        denverToKansasCity2.close();
        denverToKansasCityTrack2 = new Track(4, "Orange", "Denver", "KansasCity",
                denverToKansasCity2, denverToKansasCityRect);

        denverToOklahomaCity.moveTo(maxX * .391f, maxY * .577f);
        denverToOklahomaCity.lineTo(maxX * .385f, maxY * .586f);
        denverToOklahomaCity.lineTo(maxX * .410f, maxY * .622f);
        denverToOklahomaCity.lineTo(maxX * .415f, maxY * .611f);
        denverToOklahomaCity.close();
        denverToOklahomaCity.moveTo(maxX * .420f, maxY * .612f);
        denverToOklahomaCity.lineTo(maxX * .416f, maxY * .629f);
        denverToOklahomaCity.lineTo(maxX * .445f, maxY * .647f);
        denverToOklahomaCity.lineTo(maxX * .448f, maxY * .633f);
        denverToOklahomaCity.close();
        denverToOklahomaCity.moveTo(maxX * .455f, maxY * .635f);
        denverToOklahomaCity.lineTo(maxX * .453f, maxY * .651f);
        denverToOklahomaCity.lineTo(maxX * .484f, maxY * .663f);
        denverToOklahomaCity.lineTo(maxX * .485f, maxY * .648f);
        denverToOklahomaCity.close();
        denverToOklahomaCity.moveTo(maxX * .490f, maxY * .649f);
        denverToOklahomaCity.lineTo(maxX * .489f, maxY * .665f);
        denverToOklahomaCity.lineTo(maxX * .520f, maxY * .670f);
        denverToOklahomaCity.lineTo(maxX * .521f, maxY * .654f);
        denverToOklahomaCity.close();
        denverToOklahomaCityTrack =new Track(4, "Red", "Denver", "OklahomaCity",
                denverToOklahomaCity, denverToOklahomaCityRect);

        santaFeToOklahomaCity.moveTo(maxX * .388f, maxY * .695f);
        santaFeToOklahomaCity.lineTo(maxX * .389f, maxY * .710f);
        santaFeToOklahomaCity.lineTo(maxX * .421f, maxY * .703f);
        santaFeToOklahomaCity.lineTo(maxX * .420f, maxY * .687f);
        santaFeToOklahomaCity.close();
        santaFeToOklahomaCity.moveTo(maxX * .425f, maxY * .686f);
        santaFeToOklahomaCity.lineTo(maxX * .426f, maxY * .701f);
        santaFeToOklahomaCity.lineTo(maxX * .458f, maxY * .694f);
        santaFeToOklahomaCity.lineTo(maxX * .457f, maxY * .678f);
        santaFeToOklahomaCity.close();
        santaFeToOklahomaCity.moveTo(maxX * .462f, maxY * .679f);
        santaFeToOklahomaCity.lineTo(maxX * .461f, maxY * .694f);
        santaFeToOklahomaCity.lineTo(maxX * .498f, maxY * .687f);
        santaFeToOklahomaCity.lineTo(maxX * .496f, maxY * .671f);
        santaFeToOklahomaCity.close();
        santaFeToOklahomaCityTrack = new Track(3, "Blue", "santaFe", "OklahomaCity",
                santaFeToOklahomaCity, santaFeToOklahomaCityRect);
        
        elPasoToOklahomaCity.moveTo(maxX * .381f, maxY * .836f);
        elPasoToOklahomaCity.lineTo(maxX * .382f, maxY * .849f);
        elPasoToOklahomaCity.lineTo(maxX * .414f, maxY * .834f);
        elPasoToOklahomaCity.lineTo(maxX * .413f, maxY * .824f);
        elPasoToOklahomaCity.close();
        elPasoToOklahomaCity.moveTo(maxX * .418f, maxY * .820f);
        elPasoToOklahomaCity.lineTo(maxX * .420f, maxY * .832f);
        elPasoToOklahomaCity.lineTo(maxX * .450f, maxY * .803f);
        elPasoToOklahomaCity.lineTo(maxX * .446f, maxY * .791f);
        elPasoToOklahomaCity.close();
        elPasoToOklahomaCity.moveTo(maxX * .449f, maxY * .791f);
        elPasoToOklahomaCity.lineTo(maxX * .451f, maxY * .802f);
        elPasoToOklahomaCity.lineTo(maxX * .479f, maxY * .773f);
        elPasoToOklahomaCity.lineTo(maxX * .472f, maxY * .760f);
        elPasoToOklahomaCity.close();
        elPasoToOklahomaCity.moveTo(maxX * .478f, maxY * .755f);
        elPasoToOklahomaCity.lineTo(maxX * .484f, maxY * .767f);
        elPasoToOklahomaCity.lineTo(maxX * .510f, maxY * .735f);
        elPasoToOklahomaCity.lineTo(maxX * .505f, maxY * .720f);
        elPasoToOklahomaCity.close();
        elPasoToOklahomaCity.moveTo(maxX * .509f, maxY * .718f);
        elPasoToOklahomaCity.lineTo(maxX * .513f, maxY * .726f);
        elPasoToOklahomaCity.lineTo(maxX * .538f, maxY * .685f);
        elPasoToOklahomaCity.lineTo(maxX * .528f, maxY * .678f);
        elPasoToOklahomaCity.close();
        elPasoToOklahomaCityTrack = new Track(5, "Yellow", "ElPaso", "OklahomaCity",
                elPasoToOklahomaCity, elPasoToOklahomaCityRect);
        
        saintLouisToNashville.moveTo(maxX * .665f, maxY * .542f);
        saintLouisToNashville.lineTo(maxX * .7f, maxY * .557f);
        saintLouisToNashville.lineTo(maxX * .697f, maxY * .57f);
        saintLouisToNashville.lineTo(maxX * .662f, maxY * .557f);
        saintLouisToNashville.close();
        saintLouisToNashville.moveTo(maxX * .702f, maxY * .557f);
        saintLouisToNashville.lineTo(maxX * .735f, maxY * .575f);
        saintLouisToNashville.lineTo(maxX * .735f, maxY * .589f);
        saintLouisToNashville.lineTo(maxX * .699f, maxY * .575f);
        saintLouisToNashville.close();
        saintLouisToNashvilleTrack = new Track(2, "Gray", "Saint Louis", "Nashville",
                saintLouisToNashville, saintLouisToNashvilleRect);

        littleRockToNashville.moveTo(maxX * .646f, maxY * .662f);
        littleRockToNashville.lineTo(maxX * .678f, maxY * .659f);
        littleRockToNashville.lineTo(maxX * .683f, maxY * .675f);
        littleRockToNashville.lineTo(maxX * .647f, maxY * .676f);
        littleRockToNashville.close();
        littleRockToNashville.moveTo(maxX * .684f, maxY * .657f);
        littleRockToNashville.lineTo(maxX * .715f, maxY * .631f);
        littleRockToNashville.lineTo(maxX * .72f, maxY * .646f);
        littleRockToNashville.lineTo(maxX * .684f, maxY * .67f);
        littleRockToNashville.close();
        littleRockToNashville.moveTo(maxX * .72f, maxY * .628f);
        littleRockToNashville.lineTo(maxX * .745f, maxY * .595f);
        littleRockToNashville.lineTo(maxX * .752f, maxY * .606f);
        littleRockToNashville.lineTo(maxX * .725f, maxY * .64f);
        littleRockToNashville.close();
        littleRockToNashvilleTrack = new Track(3, "White", "Little Rock", "Nashville",
                littleRockToNashville, littleRockToNashvilleRect);

        littleRockToNewOrleans.moveTo(maxX * .638f, maxY * .69f);
        littleRockToNewOrleans.lineTo(maxX * .648f, maxY * .685f);
        littleRockToNewOrleans.lineTo(maxX * .66f, maxY * .73f);
        littleRockToNewOrleans.lineTo(maxX * .653f, maxY * .737f);
        littleRockToNewOrleans.close();
        littleRockToNewOrleans.moveTo(maxX * .654f, maxY * .742f);
        littleRockToNewOrleans.lineTo(maxX * .664f, maxY * .738f);
        littleRockToNewOrleans.lineTo(maxX * .681f, maxY * .79f);
        littleRockToNewOrleans.lineTo(maxX * .671f, maxY * .795f);
        littleRockToNewOrleans.close();
        littleRockToNewOrleans.moveTo(maxX * .674f, maxY * .8f);
        littleRockToNewOrleans.lineTo(maxX * .682f, maxY * .792f);
        littleRockToNewOrleans.lineTo(maxX * .7f, maxY * .845f);
        littleRockToNewOrleans.lineTo(maxX * .69f, maxY * .85f);
        littleRockToNewOrleans.close();
        littleRockToNewOrleansTracks = new Track(3, "Green", "Little Rock", "New Orleans",
                littleRockToNewOrleans, littleRockToNewOrleansRect);

        houstonToNewOrlean.moveTo(maxX * .615f, maxY * .867f);
        houstonToNewOrlean.lineTo(maxX * .65f, maxY * .86f);
        houstonToNewOrlean.lineTo(maxX * .655f, maxY * .88f);
        houstonToNewOrlean.lineTo(maxX * .618f, maxY * .89f);
        houstonToNewOrlean.close();
        houstonToNewOrlean.moveTo(maxX * .654f, maxY * .86f);
        houstonToNewOrlean.lineTo(maxX * .69f, maxY * .85f);
        houstonToNewOrlean.lineTo(maxX * .691f, maxY * .87f);
        houstonToNewOrlean.lineTo(maxX * .655f, maxY * .878f);
        houstonToNewOrlean.close();
        houstonToNewOrleansTrack = new Track(2, "Gray", "Houston", "New Orleans",
                houstonToNewOrlean, houstonToNewOrleanRect);

        saintLouisToLittleRock.moveTo(maxX * .65f, maxY * .53f);
        saintLouisToLittleRock.lineTo(maxX * .658f, maxY * .534f);
        saintLouisToLittleRock.lineTo(maxX * .652f, maxY * .595f);
        saintLouisToLittleRock.lineTo(maxX * .642f, maxY * .59f);
        saintLouisToLittleRock.close();
        saintLouisToLittleRock.moveTo(maxX * .64f, maxY * .595f);
        saintLouisToLittleRock.lineTo(maxX * .651f, maxY * .6f);
        saintLouisToLittleRock.lineTo(maxX * .642f, maxY * .653f);
        saintLouisToLittleRock.lineTo(maxX * .63f, maxY * .65f);
        saintLouisToLittleRock.close();
        saintLouisToLittleRockTrack = new Track(2, "Gray", "Saint Louis", "Little Rock",
                saintLouisToLittleRock, saintLouisToLittleRockRect);

        dallasToLittleRock.moveTo(maxX * .573f, maxY * .778f);
        dallasToLittleRock.lineTo(maxX * .595f, maxY * .73f);
        dallasToLittleRock.lineTo(maxX * .607f, maxY * .74f);
        dallasToLittleRock.lineTo(maxX * .583f, maxY * .79f);
        dallasToLittleRock.close();
        dallasToLittleRock.moveTo(maxX * .596f, maxY * .728f);
        dallasToLittleRock.lineTo(maxX * .618f, maxY * .678f);
        dallasToLittleRock.lineTo(maxX * .629f, maxY * .69f);
        dallasToLittleRock.lineTo(maxX * .61f, maxY * .73f);
        dallasToLittleRock.close();
        dallasToLittleRockTrack = new Track(2, "Gray", "Dallas", "Little Rock",
                dallasToLittleRock, dallasToLittleRockRect);

        oklahomaCityToLittleRock.moveTo(maxX * .551f, maxY * .659f);
        oklahomaCityToLittleRock.lineTo(maxX * .59f, maxY * .658f);
        oklahomaCityToLittleRock.lineTo(maxX * .591f, maxY * .67f);
        oklahomaCityToLittleRock.lineTo(maxX * .553f, maxY * .675f);
        oklahomaCityToLittleRock.close();
        oklahomaCityToLittleRock.moveTo(maxX * .592f, maxY * .659f);
        oklahomaCityToLittleRock.lineTo(maxX * .625f, maxY * .655f);
        oklahomaCityToLittleRock.lineTo(maxX * .628f, maxY * .67f);
        oklahomaCityToLittleRock.lineTo(maxX * .591f, maxY * .675f);
        oklahomaCityToLittleRock.close();
        oklahomaCityToLittleRockTrack = new Track(2, "Gray", "Oklahoma City", "Little Rock",
                oklahomaCityToLittleRock, oklahomaCityToLittleRockRect);

        kansasCityToSaintLouise.moveTo(maxX * .572f, maxY * .518f);
        kansasCityToSaintLouise.lineTo(maxX * .605f, maxY * .518f);
        kansasCityToSaintLouise.lineTo(maxX * .606f, maxY * .533f);
        kansasCityToSaintLouise.lineTo(maxX * .574f, maxY * .533f);
        kansasCityToSaintLouise.close();
        kansasCityToSaintLouise.moveTo(maxX * .61f, maxY * .518f);
        kansasCityToSaintLouise.lineTo(maxX * .645f, maxY * .518f);
        kansasCityToSaintLouise.lineTo(maxX * .645f, maxY * .534f);
        kansasCityToSaintLouise.lineTo(maxX * .612f, maxY * .534f);
        kansasCityToSaintLouise.close();
        kansasCityToSaintLouiseTrack = new Track(2, "Pink", "Kansas City", "Saint Louis",
                kansasCityToSaintLouise, kansasCityToSaintLouiseRect);

        kansasCityToSaintLouise2.moveTo(maxX * .572f, maxY * .502f);
        kansasCityToSaintLouise2.lineTo(maxX * .605f, maxY * .502f);
        kansasCityToSaintLouise2.lineTo(maxX * .606f, maxY * .517f);
        kansasCityToSaintLouise2.lineTo(maxX * .574f, maxY * .517f);
        kansasCityToSaintLouise2.close();
        kansasCityToSaintLouise2.moveTo(maxX * .61f, maxY * .502f);
        kansasCityToSaintLouise2.lineTo(maxX * .645f, maxY * .502f);
        kansasCityToSaintLouise2.lineTo(maxX * .645f, maxY * .518f);
        kansasCityToSaintLouise2.lineTo(maxX * .612f, maxY * .518f);
        kansasCityToSaintLouise2.close();
        kansasCityToSaintLouiseTrack2 = new Track(2, "Blue", "Kansas City", "Saint Louis",
                kansasCityToSaintLouise2, kansasCityToSaintLouiseRect);

        chicagoToSaintLouis.moveTo(maxX * .682f, maxY * .395f);
        chicagoToSaintLouis.lineTo(maxX * .693f, maxY * .402f);
        chicagoToSaintLouis.lineTo(maxX * .673f, maxY * .45f);
        chicagoToSaintLouis.lineTo(maxX * .664f, maxY * .442f);
        chicagoToSaintLouis.close();
        chicagoToSaintLouis.moveTo(maxX * .66f, maxY * .445f);
        chicagoToSaintLouis.lineTo(maxX * .672f, maxY * .454f);
        chicagoToSaintLouis.lineTo(maxX * .653f, maxY * .501f);
        chicagoToSaintLouis.lineTo(maxX * .642f, maxY * .494f);
        chicagoToSaintLouis.close();
        chicagoToSaintLouisTrack = new Track(2, "Green", "Chicago", "Saint Louis",
                chicagoToSaintLouis, saintLouisToChicagoRect);

        chicagoToSaintLouis2.moveTo(maxX * .694f, maxY * .403f);
        chicagoToSaintLouis2.lineTo(maxX * .705f, maxY * .410f);
        chicagoToSaintLouis2.lineTo(maxX * .685f, maxY * .458f);
        chicagoToSaintLouis2.lineTo(maxX * .676f, maxY * .450f);
        chicagoToSaintLouis2.close();
        chicagoToSaintLouis2.moveTo(maxX * .672f, maxY * .423f);
        chicagoToSaintLouis2.lineTo(maxX * .685f, maxY * .462f);
        chicagoToSaintLouis2.lineTo(maxX * .665f, maxY * .509f);
        chicagoToSaintLouis2.lineTo(maxX * .654f, maxY * .502f);
        chicagoToSaintLouis2.close();
        chicagoToSaintLouisTrack2 = new Track(2, "White", "Chicago", "Saint Louis",
                chicagoToSaintLouis2, saintLouisToChicagoRect);

        omahaToChicago.moveTo(maxX * .545f, maxY * .425f);
        omahaToChicago.lineTo(maxX * .575f, maxY * .395f);
        omahaToChicago.lineTo(maxX * .585f, maxY * .41f);
        omahaToChicago.lineTo(maxX * .555f, maxY * .436f);
        omahaToChicago.close();
        omahaToChicago.moveTo(maxX * .576f, maxY * .39f);
        omahaToChicago.lineTo(maxX * .607f, maxY * .362f);
        omahaToChicago.lineTo(maxX * .615f, maxY * .378f);
        omahaToChicago.lineTo(maxX * .587f, maxY * .405f);
        omahaToChicago.close();
        omahaToChicago.moveTo(maxX * .617f, maxY * .36f);
        omahaToChicago.lineTo(maxX * .653f, maxY * .367f);
        omahaToChicago.lineTo(maxX * .651f, maxY * .38f);
        omahaToChicago.lineTo(maxX * .616f, maxY * .372f);
        omahaToChicago.close();
        omahaToChicago.moveTo(maxX * .656f, maxY * .37f);
        omahaToChicago.lineTo(maxX * .687f, maxY * .375f);
        omahaToChicago.lineTo(maxX * .688f, maxY * .39f);
        omahaToChicago.lineTo(maxX * .655f, maxY * .385f);
        omahaToChicago.close();
        omahaToChicagoTrack = new Track(4, "Blue", "Omaha", "Chicago",
                omahaToChicago, omahaToChicagoRect);

        elPasoToDallas.moveTo(maxX * .399f, maxY * .850f);
        elPasoToDallas.lineTo(maxX * .400f, maxY * .865f);
        elPasoToDallas.lineTo(maxX * .435f, maxY * .860f);
        elPasoToDallas.lineTo(maxX * .434f, maxY * .843f);
        elPasoToDallas.close();
        elPasoToDallas.moveTo(maxX * .439f, maxY * .842f);
        elPasoToDallas.lineTo(maxX * .440f, maxY * .857f);
        elPasoToDallas.lineTo(maxX * .473f, maxY * .851f);
        elPasoToDallas.lineTo(maxX * .472f, maxY * .832f);
        elPasoToDallas.close();
        elPasoToDallas.moveTo(maxX * .478f, maxY * .831f);
        elPasoToDallas.lineTo(maxX * .479f, maxY * .846f);
        elPasoToDallas.lineTo(maxX * .508f, maxY * .840f);
        elPasoToDallas.lineTo(maxX * .507f, maxY * .824f);
        elPasoToDallas.close();
        elPasoToDallas.moveTo(maxX * .512f, maxY * .825f);
        elPasoToDallas.lineTo(maxX * .513f, maxY * .839f);
        elPasoToDallas.lineTo(maxX * .543f, maxY * .833f);
        elPasoToDallas.lineTo(maxX * .542f, maxY * .817f);
        elPasoToDallas.close();
        elPasoToDallasTrack = new Track(4, "Red", "ElPaso", "Dallas",
                elPasoToDallas, elPasoToDallasRect);
        
        elPasoToHouston.moveTo(maxX * .380f, maxY * .867f);
        elPasoToHouston.lineTo(maxX * .375f, maxY * .877f);
        elPasoToHouston.lineTo(maxX * .403f, maxY * .904f);
        elPasoToHouston.lineTo(maxX * .408f, maxY * .889f);
        elPasoToHouston.close();
        elPasoToHouston.moveTo(maxX * .412f, maxY * .890f);
        elPasoToHouston.lineTo(maxX * .408f, maxY * .902f);
        elPasoToHouston.lineTo(maxX * .440f, maxY * .914f);
        elPasoToHouston.lineTo(maxX * .443f, maxY * .903f);
        elPasoToHouston.close();
        elPasoToHouston.moveTo(maxX * .448f, maxY * .905f);
        elPasoToHouston.lineTo(maxX * .445f, maxY * .919f);
        elPasoToHouston.lineTo(maxX * .482f, maxY * .926f);
        elPasoToHouston.lineTo(maxX * .482f, maxY * .912f);
        elPasoToHouston.close();
        elPasoToHouston.moveTo(maxX * .485f, maxY * .912f);
        elPasoToHouston.lineTo(maxX * .485f, maxY * .928f);
        elPasoToHouston.lineTo(maxX * .520f, maxY * .930f);
        elPasoToHouston.lineTo(maxX * .521f, maxY * .914f);
        elPasoToHouston.close();
        elPasoToHouston.moveTo(maxX * .524f, maxY * .914f);
        elPasoToHouston.lineTo(maxX * .524f, maxY * .930f);
        elPasoToHouston.lineTo(maxX * .556f, maxY * .927f);
        elPasoToHouston.lineTo(maxX * .554f, maxY * .911f);
        elPasoToHouston.close();
        elPasoToHouston.moveTo(maxX * .558f, maxY * .908f);
        elPasoToHouston.lineTo(maxX * .560f, maxY * .925f);
        elPasoToHouston.lineTo(maxX * .594f, maxY * .903f);
        elPasoToHouston.lineTo(maxX * .587f, maxY * .889f);
        elPasoToHouston.close();
        elPasoToHoustonTrack = new Track(6, "Green", "ElPaso", "Houston", elPasoToHouston, elPasoToHoustonRect);


        winnipegToDuluth.moveTo(maxX * .463f, maxY * .095f);
        winnipegToDuluth.lineTo(maxX * .456f, maxY * .107f);
        winnipegToDuluth.lineTo(maxX * .479f, maxY * .139f);
        winnipegToDuluth.lineTo(maxX * .484f, maxY * .131f);
        winnipegToDuluth.close();
        winnipegToDuluth.moveTo(maxX * .488f, maxY * .138f);
        winnipegToDuluth.lineTo(maxX * .481f, maxY * .15f);
        winnipegToDuluth.lineTo(maxX * .507f, maxY * .182f);
        winnipegToDuluth.lineTo(maxX * .512f, maxY * .171f);
        winnipegToDuluth.close();
        winnipegToDuluth.moveTo(maxX * .518f, maxY * .176f);
        winnipegToDuluth.lineTo(maxX * .512f, maxY * .187f);
        winnipegToDuluth.lineTo(maxX * .533f, maxY * .228f);
        winnipegToDuluth.lineTo(maxX * .540f, maxY * .215f);
        winnipegToDuluth.close();
        winnipegToDuluth.moveTo(maxX * .545f, maxY * .216f);
        winnipegToDuluth.lineTo(maxX * .538f, maxY * .229f);
        winnipegToDuluth.lineTo(maxX * .559f, maxY * .270f);
        winnipegToDuluth.lineTo(maxX * .566f, maxY * .257f);
        winnipegToDuluth.close();
        winnipegToDuluthTrack = new Track(4, "Black", "Winnipeg", "Duluth",
                winnipegToDuluth, winnipegToDuluthRect);

        dallasToHouston.moveTo(maxX * .57f, maxY * .826f);
        dallasToHouston.lineTo(maxX * .563f, maxY * .835f);
        dallasToHouston.lineTo(maxX * .583f, maxY * .876f);
        dallasToHouston.lineTo(maxX * .593f, maxY * .864f);
        dallasToHouston.close();
        dallasToHoustonTrack = new Track(1, "Gray", "Dallas", "Houston",
                dallasToHouston, dallasToHoustonRect);

        dallasToHouston2.moveTo(maxX * .58f, maxY * .816f);
        dallasToHouston2.lineTo(maxX * .573f, maxY * .823f);
        dallasToHouston2.lineTo(maxX * .6f, maxY * .864f);
        dallasToHouston2.lineTo(maxX * .606f, maxY * .856f);
        dallasToHouston2.close();
        dallasToHoustonTrack2 = new Track(1, "Gray", "Dallas", "Houston",
                dallasToHouston2, dallasToHoustonRect);
        
        oklahomaCityToDallas.moveTo(maxX * .564f, maxY * .680f);
        oklahomaCityToDallas.lineTo(maxX * .552f, maxY * .682f);
        oklahomaCityToDallas.lineTo(maxX * .556f, maxY * .735f);
        oklahomaCityToDallas.lineTo(maxX * .568f, maxY * .734f);
        oklahomaCityToDallas.close();
        oklahomaCityToDallas.moveTo(maxX * .567f, maxY * .738f);
        oklahomaCityToDallas.lineTo(maxX * .555f, maxY * .740f);
        oklahomaCityToDallas.lineTo(maxX * .559f, maxY * .793f);
        oklahomaCityToDallas.lineTo(maxX * .571f, maxY * .792f);
        oklahomaCityToDallas.close();
        oklahomaCityToDallasTrack = new Track(2, "Gray", "OklahomaCity", "Dallas",
                oklahomaCityToDallas, oklahomaCityToDallasRect);

        oklahomaCityToDallas2.moveTo(maxX * .551f, maxY * .682f);
        oklahomaCityToDallas2.lineTo(maxX * .539f, maxY * .684f);
        oklahomaCityToDallas2.lineTo(maxX * .543f, maxY * .737f);
        oklahomaCityToDallas2.lineTo(maxX * .555f, maxY * .736f);
        oklahomaCityToDallas2.close();
        oklahomaCityToDallas2.moveTo(maxX * .554f, maxY * .74f);
        oklahomaCityToDallas2.lineTo(maxX * .542f, maxY * .742f);
        oklahomaCityToDallas2.lineTo(maxX * .546f, maxY * .795f);
        oklahomaCityToDallas2.lineTo(maxX * .558f, maxY * .794f);
        oklahomaCityToDallas2.close();
        oklahomaCityToDallasTrack2 = new Track(2, "Gray", "OklahomaCity", "Dallas",
                oklahomaCityToDallas2, oklahomaCityToDallasRect);
        
        kansasCityToOklahomaCity.moveTo(maxX * .578f, maxY * .542f);
        kansasCityToOklahomaCity.lineTo(maxX * .568f, maxY * .538f);
        kansasCityToOklahomaCity.lineTo(maxX * .557f, maxY * .589f);
        kansasCityToOklahomaCity.lineTo(maxX * .566f, maxY * .593f);
        kansasCityToOklahomaCity.close();
        kansasCityToOklahomaCity.moveTo(maxX * .567f, maxY * .601f);
        kansasCityToOklahomaCity.lineTo(maxX * .557f, maxY * .596f);
        kansasCityToOklahomaCity.lineTo(maxX * .546f, maxY * .647f);
        kansasCityToOklahomaCity.lineTo(maxX * .555f, maxY * .651f);
        kansasCityToOklahomaCity.close();
        kansasCityToOklahomaCityTrack = new Track(2, "Gray", "KansasCity", "OklahomaCity",
                kansasCityToOklahomaCity, kansasCityToOklahomaCityRect);

        kansasCityToOklahomaCity2.moveTo(maxX * .567f, maxY * .537f);
        kansasCityToOklahomaCity2.lineTo(maxX * .557f, maxY * .533f);
        kansasCityToOklahomaCity2.lineTo(maxX * .546f, maxY * .584f);
        kansasCityToOklahomaCity2.lineTo(maxX * .555f, maxY * .588f);
        kansasCityToOklahomaCity2.close();
        kansasCityToOklahomaCity2.moveTo(maxX * .556f, maxY * .596f);
        kansasCityToOklahomaCity2.lineTo(maxX * .545f, maxY * .591f);
        kansasCityToOklahomaCity2.lineTo(maxX * .535f, maxY * .642f);
        kansasCityToOklahomaCity2.lineTo(maxX * .544f, maxY * .646f);
        kansasCityToOklahomaCity2.close();
        kansasCityToOklahomaCityTrack2 = new Track(2, "Gray", "KansasCity", "OklahomaCity",
                kansasCityToOklahomaCity2, kansasCityToOklahomaCityRect);
        
        duluthToChicago.moveTo(maxX * .579f, maxY * .29f);
        duluthToChicago.lineTo(maxX * .613f, maxY * .315f);
        duluthToChicago.lineTo(maxX * .61f, maxY * .326f);
        duluthToChicago.lineTo(maxX * .573f, maxY * .302f);
        duluthToChicago.close();
        duluthToChicago.moveTo(maxX * .613f, maxY * .317f);
        duluthToChicago.lineTo(maxX * .648f, maxY * .335f);
        duluthToChicago.lineTo(maxX * .643f, maxY * .35f);
        duluthToChicago.lineTo(maxX * .61f, maxY * .333f);
        duluthToChicago.close();
        duluthToChicago.moveTo(maxX * .652f, maxY * .341f);
        duluthToChicago.lineTo(maxX * .685f, maxY * .353f);
        duluthToChicago.lineTo(maxX * .682f, maxY * .364f);
        duluthToChicago.lineTo(maxX * .65f, maxY * .355f);
        duluthToChicago.close();
        duluthToChicagoTrack = new Track(3, "Red", "Duluth", "Chicago",
                duluthToChicago, duluthToChicagoRect);

        duluthToToronto.moveTo(maxX * .582f, maxY * .267f);
        duluthToToronto.lineTo(maxX * .618f, maxY * .258f);
        duluthToToronto.lineTo(maxX * .62f, maxY * .278f);
        duluthToToronto.lineTo(maxX * .582f, maxY * .283f);
        duluthToToronto.close();
        duluthToToronto.moveTo(maxX * .621f, maxY * .257f);
        duluthToToronto.lineTo(maxX * .657f, maxY * .248f);
        duluthToToronto.lineTo(maxX * .657f, maxY * .263f);
        duluthToToronto.lineTo(maxX * .622f, maxY * .275f);
        duluthToToronto.close();
        duluthToToronto.moveTo(maxX * .66f, maxY * .246f);
        duluthToToronto.lineTo(maxX * .692f, maxY * .235f);
        duluthToToronto.lineTo(maxX * .695f, maxY * .255f);
        duluthToToronto.lineTo(maxX * .66f, maxY * .263f);
        duluthToToronto.close();
        duluthToToronto.moveTo(maxX * .698f, maxY * .233f);
        duluthToToronto.lineTo(maxX * .732f, maxY * .225f);
        duluthToToronto.lineTo(maxX * .733f, maxY * .242f);
        duluthToToronto.lineTo(maxX * .7f, maxY * .255f);
        duluthToToronto.close();
        duluthToToronto.moveTo(maxX * .73f, maxY * .223f);
        duluthToToronto.lineTo(maxX * .763f, maxY * .218f);
        duluthToToronto.lineTo(maxX * .768f, maxY * .235f);
        duluthToToronto.lineTo(maxX * .735f, maxY * .24f);
        duluthToToronto.close();
        duluthToToronto.moveTo(maxX * .767f, maxY * .213f);
        duluthToToronto.lineTo(maxX * .806f, maxY * .205f);
        duluthToToronto.lineTo(maxX * .808f, maxY * .223f);
        duluthToToronto.lineTo(maxX * .773f, maxY * .232f);
        duluthToToronto.close();
        duluthToTorontoTrack = new Track(6, "Pink", "Duluth", "Toronto", 
                duluthToToronto, duluthToTorontoRect);

        duluthToSaultSteMarie.moveTo(maxX * .59f, maxY * .245f);
        duluthToSaultSteMarie.lineTo(maxX * .62f, maxY * .22f);
        duluthToSaultSteMarie.lineTo(maxX * .625f, maxY * .233f);
        duluthToSaultSteMarie.lineTo(maxX * .592f, maxY * .26f);
        duluthToSaultSteMarie.close();
        duluthToSaultSteMarie.moveTo(maxX * .625f, maxY * .218f);
        duluthToSaultSteMarie.lineTo(maxX * .656f, maxY * .196f);
        duluthToSaultSteMarie.lineTo(maxX * .66f, maxY * .21f);
        duluthToSaultSteMarie.lineTo(maxX * .633f, maxY * .23f);
        duluthToSaultSteMarie.close();
        duluthToSaultSteMarie.moveTo(maxX * .66f, maxY * .195f);
        duluthToSaultSteMarie.lineTo(maxX * .693f, maxY * .174f);
        duluthToSaultSteMarie.lineTo(maxX * .698f, maxY * .191f);
        duluthToSaultSteMarie.lineTo(maxX * .663f, maxY * .21f);
        duluthToSaultSteMarie.close();
        duluthToSaultSteMarieTrack = new Track(3, "Gray", "Duluth", "Sault Ste Marie",
                duluthToSaultSteMarie, duluthToSaultSteMarieRect);


        winnipegToSaultSteMarie.moveTo(maxX * .475f, maxY * .075f);
        winnipegToSaultSteMarie.lineTo(maxX * .508f, maxY * .087f);
        winnipegToSaultSteMarie.lineTo(maxX * .506f, maxY * .102f);
        winnipegToSaultSteMarie.lineTo(maxX * .471f, maxY * .087f);
        winnipegToSaultSteMarie.close();
        winnipegToSaultSteMarie.moveTo(maxX * .514f, maxY * .088f);
        winnipegToSaultSteMarie.lineTo(maxX * .547f, maxY * .098f);
        winnipegToSaultSteMarie.lineTo(maxX * .545f, maxY * .112f);
        winnipegToSaultSteMarie.lineTo(maxX * .509f, maxY * .104f);
        winnipegToSaultSteMarie.close();
        winnipegToSaultSteMarie.moveTo(maxX * .552f, maxY * .098f);
        winnipegToSaultSteMarie.lineTo(maxX * .58f, maxY * .108f);
        winnipegToSaultSteMarie.lineTo(maxX * .58f, maxY * .125f);
        winnipegToSaultSteMarie.lineTo(maxX * .55f, maxY * .114f);
        winnipegToSaultSteMarie.close();
        winnipegToSaultSteMarie.moveTo(maxX * .587f, maxY * .106f);
        winnipegToSaultSteMarie.lineTo(maxX * .622f, maxY * .12f);
        winnipegToSaultSteMarie.lineTo(maxX * .618f, maxY * .132f);
        winnipegToSaultSteMarie.lineTo(maxX * .585f, maxY * .124f);
        winnipegToSaultSteMarie.close();
        winnipegToSaultSteMarie.moveTo(maxX * .623f, maxY * .12f);
        winnipegToSaultSteMarie.lineTo(maxX * .66f, maxY * .13f);
        winnipegToSaultSteMarie.lineTo(maxX * .655f, maxY * .15f);
        winnipegToSaultSteMarie.lineTo(maxX * .62f, maxY * .138f);
        winnipegToSaultSteMarie.close();
        winnipegToSaultSteMarie.moveTo(maxX * .66f, maxY * .135f);
        winnipegToSaultSteMarie.lineTo(maxX * .697f, maxY * .143f);
        winnipegToSaultSteMarie.lineTo(maxX * .692f, maxY * .162f);
        winnipegToSaultSteMarie.lineTo(maxX * .659f, maxY * .15f);
        winnipegToSaultSteMarie.close();
        winnipegToSaultSteMarieTrack = new Track(6, "Gray", "Winnipeg", "Sault Ste Marie",
                winnipegToSaultSteMarie, winnipegToSaultSteMarieRect);

        duluthToOmaha.moveTo(maxX * .565f, maxY * .303f);
        duluthToOmaha.lineTo(maxX * .555f, maxY * .297f);
        duluthToOmaha.lineTo(maxX * .542f, maxY * .345f);
        duluthToOmaha.lineTo(maxX * .553f, maxY * .35f);
        duluthToOmaha.close();
        duluthToOmaha.moveTo(maxX * .552f, maxY * .357f);
        duluthToOmaha.lineTo(maxX * .542f, maxY * .351f);
        duluthToOmaha.lineTo(maxX * .529f, maxY * .402f);
        duluthToOmaha.lineTo(maxX * .540f, maxY * .408f);
        duluthToOmaha.close();
        duluthToOmahaTrack = new Track(2, "Gray", "Duluth", "Omaha",
                duluthToOmaha, duluthToOmahaRect);

        duluthToOmaha2.moveTo(maxX * .575f, maxY * .310f);
        duluthToOmaha2.lineTo(maxX * .565f, maxY * .304f);
        duluthToOmaha2.lineTo(maxX * .552f, maxY * .352f);
        duluthToOmaha2.lineTo(maxX * .563f, maxY * .357f);
        duluthToOmaha2.close();
        duluthToOmaha2.moveTo(maxX * .562f, maxY * .364f);
        duluthToOmaha2.lineTo(maxX * .552f, maxY * .358f);
        duluthToOmaha2.lineTo(maxX * .539f, maxY * .409f);
        duluthToOmaha2.lineTo(maxX * .550f, maxY * .415f);
        duluthToOmaha2.close();
        duluthToOmahaTrack2 = new Track(2, "Gray", "Duluth", "Omaha",
                duluthToOmaha2, duluthToOmahaRect);

        omahatoKansasCity.moveTo(maxX * .543f, maxY * .450f);
        omahatoKansasCity.lineTo(maxX * .533f, maxY * .463f);
        omahatoKansasCity.lineTo(maxX * .547f, maxY * .511f);
        omahatoKansasCity.lineTo(maxX * .558f, maxY * .499f);
        omahatoKansasCity.close();
        omahatoKansasCityTrack = new Track(1,"Gray", "Omaha", "KansasCity",
                omahatoKansasCity, omahaToKansasCityRect);

        omahatoKansasCity2.moveTo(maxX * .554f, maxY * .436f);
        omahatoKansasCity2.lineTo(maxX * .544f, maxY * .449f);
        omahatoKansasCity2.lineTo(maxX * .558f, maxY * .497f);
        omahatoKansasCity2.lineTo(maxX * .569f, maxY * .485f);
        omahatoKansasCity2.close();
        omahatoKansasCityTrack2 = new Track(1,"Gray", "Omaha", "KansasCity",
                omahatoKansasCity2, omahaToKansasCityRect);

        //initializes the track array with above tracks
        myTracks = new Track[]{portlandToSanFranciscoTrack,seattleToHelenaTrack,
                losAngelesToLasVegasTrack, sanFranciscoToLosAngelesTrack, sanFranciscoToLosAngelesTrack2,
                montrealToBostonTrack, losAngelesToPhoenixTrack, montrealToNewYorkTrack,
                newYorkToBostonTrack, newYorkToWashingtonTrack, raleighToWashingtonTrack,
                raleighToCharlestonTrack, miamiToCharlestonTrack, atlantaToMiamiTrack, //,GRID_TRACK,
                atlantaToCharlestonTrack, raleighToAtlantaTrack, pittsburghToRaleighTrack,
                pittsburghToWashingtonTrack, pittsburghToNewYorkTrack, torontoToPittsburghTrack,
                torontoToMontrealTrack, saultSteMarieToMontrealTrack, newOrleansToMiamiTrack,
                losAngelesToElPasoTrack, vancouverToSeattleTrack, seattleToPortlandTrack, vancouverToCalgaryTrack,
                seattleToCalgaryTrack, portlandToSaltLakeCityTrack, sanFranciscoToSaltLakeCityTrack,
                saltLakeCityToLasVegasTrack, calgaryToWinnipegTrack, calgaryToHelenaTrack,
                helenaToSaltLakeCityTrack, saltLakeCityToDenverTrack, phoenixToDenverTrack,
                phoenixToSantaFeTrack, phoenixToElPasoTrack, helenaToWinnipegTrack,
                helenaToDenverTrack, denverToSantaFeTrack, santaFeToElPasoTrack,
                helenaToDuluthTrack, helenaToOmahaTrack, helenaToDuluthTrack,
                newOrleansToAtlantaTrack, nashvilleToAtlantaTrack, nashvilleToRaleighTrack,
                nashvilleToPittsburghTrack, saintLouisToPittsburghTrack, chicagoToPittsburghTrack,
                chicagoToTorontoTrack, saultSteMarieToTorontoTrack, denverToOmahaTrack,
                denverToKansasCityTrack, denverToOklahomaCityTrack, santaFeToOklahomaCityTrack,
                elPasoToOklahomaCityTrack, elPasoToDallasTrack,
                littleRockToNashvilleTrack, littleRockToNewOrleansTracks, houstonToNewOrleansTrack,
                saintLouisToLittleRockTrack, dallasToLittleRockTrack, oklahomaCityToLittleRockTrack,
                saintLouisToNashvilleTrack, kansasCityToSaintLouiseTrack, chicagoToSaintLouisTrack,
                elPasoToOklahomaCityTrack, elPasoToDallasTrack, elPasoToHoustonTrack, winnipegToDuluthTrack,
                dallasToHoustonTrack, oklahomaCityToDallasTrack, kansasCityToOklahomaCityTrack,
                dallasToHoustonTrack,winnipegToSaultSteMarieTrack, omahaToChicagoTrack,
                duluthToChicagoTrack, duluthToTorontoTrack, duluthToSaultSteMarieTrack, duluthToOmahaTrack,
                omahatoKansasCityTrack, vancouverToSeattleTrack2, seattleToPortlandTrack2,
                sanFranciscoToSaltLakeCityTrack2, portlandToSanFranciscoTrack2, saltLakeCityToDenverTrack2,
                denverToKansasCityTrack2, duluthToOmahaTrack2, omahatoKansasCityTrack2,
                kansasCityToOklahomaCityTrack2, kansasCityToSaintLouiseTrack2, oklahomaCityToDallasTrack2,
                dallasToHoustonTrack2, newOrleansToAtlantaTrack2, raleighToAtlantaTrack2,
                raleighToWashingtonTrack2, newYorkToWashingtonTrack2, newYorkToBostonTrack2,
                montrealToBostonTrack2, chicagoToPittsburghTrack2
        };

        //Booleans set to defaults
        isSelectDestinationCards = false;
        trackModeSelected = false;
        cardModeSelected = false;
        destinationCardsSelected = false;
        trainCardsSelected = false;
        useRainbow = false;
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
        destinationDiscard = new Deck(original.destinationDiscard);
        for(int i = 0; i < original.getNumPlayers(); i++){
            trainTokens[i] = original.getTrainTokens()[i];
            scores[i] = original.getScores()[i];
            names[i] = original.getNames()[i];
            playerTrainDecks[i] = new Deck(original.getPlayerTrainDecks()[i]);
            playerDestinationDecks[i] = new Deck(original.getPlayerDestinationDecks()[i]);
        }
        myTracks = original.getTracks();
        trackSpot = original.getTrackSpot();
        numRainbows = original.getNumRainbows();
        selectedCardColor = original.getSelectedCardColor();
        //Booleans
        isSelectDestinationCards = original.getIsSelectDestinationCards();
        trackModeSelected = original.getTrackModeSelected();
        cardModeSelected = original.getCardModeSelected();
        destinationCardsSelected = original.getDestinationCardsSelected();
        trainCardsSelected = original.getTrainCardsSelected();
        onlyDownDeck = original.getOnlyDownDeck();
        useRainbow = original.getUseRainbow();
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

    public String getSelectedCardColor(){
        return selectedCardColor;
    }

    public void setSelectedCardColor(String value){
        this.selectedCardColor = value;
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
}
