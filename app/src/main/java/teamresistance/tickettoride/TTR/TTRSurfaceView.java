package teamresistance.tickettoride.TTR;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;

import teamresistance.tickettoride.R;

/**
 * This is a surface view class that draws the game board/pieces onto the screen.
 *
 */

public class TTRSurfaceView extends SurfaceView{

    Bitmap boardImage = BitmapFactory.decodeResource(getResources(), R.drawable.game_board);

    /*
    * Booleans relating to the placement process for trains
    */
    public Boolean highlightMode = false;
    public Boolean drawTrain = false;
    public Boolean isArea1 = false;
    public Boolean isArea2 = false;
    protected int maxX = 1720;
    protected int maxY = 980;
    Rect touchArea1 = new Rect(90, 90, 140, 185);
    Rect touchArea2 = new Rect(180, 650, 310, 750);
    Rect touchArea3 = new Rect(410,290,560,460);
    Rect touchArea4 = new Rect(970,470,1120,540);
    Rect touchArea5 = new Rect(0,0,1,1);

    /*
     * These ints correspond to hex colors used by this class
     */
    final int RED_COLOR = 0xFFFF0000;
    final int HIGHLIGHT_COLOR = 0xFF00FF00;
    final int SELECTION_COLOR = 0xFF00ffff;

    private Paint paint = new Paint();

    //rectangular touch area declarations
//    Rect sanFranciscoToPortlandRect = new Rect((int)(maxX*.0), (int)(maxY*.28), (int)(maxX*.05), (int)(maxY*.5));
//    Rect sanFranciscoToLosAngelesRect = new Rect((int)(maxX*0),(int)(maxY*.6), (int)(maxX*.1), (int)(maxY*.2));
//    Rect losAngelesToPhoenixRect = new Rect((int)(maxX*.11), (int)(maxY*.65), (int)(maxX*.12), (int)(maxY*.05));
//    Rect montrealtoBostonRect = new Rect((int)(maxX * .91), (int)(maxY * .06), (int)(maxX * .99), (int)(maxY * .18));
//    Rect montrealtoNewYorkRect = new Rect((int)(maxX * .895), (int)(maxY * .08), (int)(maxX * .93), (int)(maxY * .27));
//    Rect losAngelesToLasVegasRect = new Rect((int)(maxX * .11), (int)(maxY * .67), (int)(maxX * .175), (int)(maxY * .755));
//    Rect newYorkToBostonRect = new Rect((int)(maxX * .95), (int)(maxY * .18), (int)(maxX * 1), (int)(maxY * .29));
//    Rect newYorkToWashingtonRect = new Rect((int)(maxX * .93), (int)(maxY * .298), (int)(maxX * .96), (int)(maxY * .42));
//    Rect raleighToWashingtonRect = new Rect((int)(maxX * .87), (int)(maxY * .43), (int)(maxX * .95), (int)(maxY * .55));
//    Rect raleighToCharlestonRect = new Rect((int)(maxX * .875), (int)(maxY * .55), (int)(maxX * .94), (int)(maxY * .655));
//    Rect miamiToChaelestonRect = new Rect((int)(maxX * .89), (int)(maxY * .655), (int)(maxX * .955), (int)(maxY * .91));
//    Rect atlantaToMiamiRect = new Rect((int)(maxX * .8), (int)(maxY * .7), (int)(maxX * .9), (int)(maxY * .8));
//    Rect atlantaToCharlestonRect = new Rect((int)(maxX * .81), (int)(maxY * .64), (int)(maxX * .9), (int)(maxY * .685));
//    Rect raleighToAtlantaRect = new Rect((int)(maxX * .8), (int)(maxY * .54), (int)(maxX * .88), (int)(maxY * .65));
//    Rect pittsburghToRaleighRect = new Rect((int)(maxX * .845), (int)(maxY * .39), (int)(maxX * .865), (int)(maxY * .51));
//    Rect pittsburghToWashingtonRect = new Rect((int)(maxX * .85), (int)(maxY * .35), (int)(maxX * .93), (int)(maxY * .43));
//    Rect pittsburghToNewYorkRect = new Rect((int)(maxX * .845), (int)(maxY * .26), (int)(maxX * .925), (int)(maxY * .35));
//    Rect torontoToPittsburghRect = new Rect((int)(maxX * .815), (int)(maxY * .2), (int)(maxX * .835), (int)(maxY * .35));
//    Rect torontoToMontrealRect = new Rect((int)(maxX * .805), (int)(maxY * .06), (int)(maxX * .905), (int)(maxY * .2));
//    Rect saultSteMarieToMontrealRect = new Rect((int)(maxX * .7), (int)(maxY * .04), (int)(maxX * .9), (int)(maxY * .15));
//    Rect newOrleansToMiamiRect = new Rect((int)(maxX * .725), (int)(maxY * .8), (int)(maxX * .88), (int)(maxY * .88));

    //path initializations
    private Path GRID = new Path();
    //THE WEST!
//    private Path vancouverToCalgary = new Path();
//    private Path vancouverToSeattle = new Path();
//    private Path seattleToCalgary = new Path();
//    private Path seattleToHelena = new Path();
//    private Path seattleToPortland= new Path();
//    private Path portlandToSanFrancisco = new Path();
//    private Path portlandToSaltLakeCity = new Path();
//    private Path sanFranciscoToLosAngeles = new Path();
//    private Path sanFranciscoToSaltLakeCity = new Path();
//    private Path losAngelesToLasVegas = new Path();
//    private Path losAngelesToPheonix = new Path();
//    private Path losAngelesToElPaso = new Path();
//    //mid-west paths
//    private Path calgaryToWinnipeg = new Path();
//    private Path calgaryToHelena = new Path();
//    private Path helenaToWinnipeg = new Path();
//    private Path helenaToDuluth = new Path();
//    private Path helenaToOmaha = new Path();
//    private Path helenaToDenver = new Path();
//    private Path helenaToSaltLakeCity = new Path();
//    private Path saltLakeCityToDenver = new Path();
//    private Path saltLakeCityToLasVegas = new Path();
//    private Path phoenixToDenver = new Path();
//    private Path phoenixToSantaFe = new Path();
//    private Path phoeixToElPaso = new Path();
//    private Path denverToOmaha = new Path();
//    private Path denverToKansasCity = new Path();
//    private Path denverToOklahomaCity = new Path();
//    private Path denverToSantaFe = new Path();
//    private Path santaFeToOklahomaCity = new Path();
//    private Path santaFeToElPaso = new Path();
//    private Path elPasoToOklahomaCity = new Path();
//    private Path elPasoToDallas = new Path();
//    private Path elPasoToHouston = new Path();
//    //fly-over state paths
//    private Path winnipegToSaultSteMarie = new Path();
//    private Path winnipegToDuluth = new Path();
//    private Path duluthToSaultSteMarie = new Path();
//    private Path duluthToToronto = new Path();
//    private Path duluthToChicago = new Path();
//    private Path duluthToOmaha = new Path();
//    private Path omahaToChicago = new Path();
//    private Path omahatoKansasCity = new Path();
//    private Path kansasCityToSaintLouise = new Path();
//    private Path kansasCityToOklahomaCity = new Path();
//    private Path oklahomaCityToLittleRock = new Path();
//    private Path oklahomaCityToDallas = new Path();
//    private Path dallasToLittleRock = new Path();
//    private Path dallasToHouston = new Path();
//    private Path houstonToNewOrlean = new Path();
//    //Mississippi
//    private Path saultSteMarieToMontreal = new Path();
//    private Path saultSteMarieToToronto = new Path();
//    private Path chicagoToToronto = new Path();
//    private Path chicagoToPittsburgh = new Path();
//    private Path chicagoToSaintLouis = new Path();
//    private Path saintLouisToPittsburgh = new Path();
//    private Path saintLouisToNashville = new Path();
//    private Path saintLouisToLittleRock = new Path();
//    private Path nashvilleToPittsburgh = new Path();
//    private Path nashvilleToRaleigh = new Path();
//    private Path nashvilleToAtlanta = new Path();
//    private Path littleRockToNashville = new Path();
//    private Path littleRockToNewOrleans = new Path();
//    private Path newOrleansToAtlanta = new Path();
//    private Path newOrleansToMiami = new Path();
//    //Appalachia
//    private Path torontoToMontreal = new Path();
//    private Path torontoToPittsburgh = new Path();
//    private Path pittsburghToNewYork = new Path();
//    private Path pittsburghToWashington = new Path();
//    private Path pittsburghToRaleigh = new Path();
//    private Path raleighToWashington = new Path();
//    private Path raleighToCharleston = new Path();
//    private Path raleighToAtlanta = new Path();
//    private Path atlantaToCharleston = new Path();
//    private Path atlantaToMiami = new Path();
//    private Path miamiToCharleston = new Path();
//    //NorthEast
//    private Path montrealToBoston = new Path();
//    private Path montrealToNewYork = new Path();
//    private Path newYorkToBoston = new Path();
//    private Path newYorkToWashington = new Path();
//
//    //Initializes all the tracks
    Track GRID_TRACK;
//    //THE WEST
//    Track vancouverToCalgaryTrack;
//    Track vancouverToSeattleTrack;
//    Track seattleToCalgaryTrack;
//    Track seattleToHelenaTrack;
//    Track seattleToPortlandTrack;
//    Track portlandToSanFranciscoTrack;
//    Track portlandToSaltLakeCityTrack;
//    Track sanFranciscoToLosAngelesTrack;
//    Track sanFranciscoToSaltLakeCityTrack;
//    Track losAngelesToLasVegasTrack;
//    Track losAngelesToPhoenixTrack;
//    Track losAngelesToElPasoTrack;
//    //mid-west tracks
//    Track calgaryToWinnipegTrack;
//    Track calgaryToHelenaTrack;
//    Track helenaToWinnipegTrack;
//    Track helenaToDuluthTrack;
//    Track helenaToOmahaTrack;
//    Track helenaToDenverTrack;
//    Track helenaToSaltLakeCityTrack;
//    Track saltLakeCityToDenverTrack;
//    Track saltLakeCityToLasVegasTrack;
//    Track phoenixToDenverTrack;
//    Track phoenixToSantaFeTrack;
//    Track phoeixToElPasoTrack;
//    Track denverToOmahaTrack;
//    Track denverToKansasCityTrack;
//    Track denverToOklahomaCityTrack;
//    Track denverToSantaFeTrack;
//    Track santaFeToOklahomaCityTrack;
//    Track santaFeToElPasoTrack;
//    Track elPasoToOklahomaCityTrack;
//    Track elPasoToDallasTrack;
//    Track elPasoToHoustonTrack;
//    //fly-over state tracks
//    Track winnipegToSaultSteMarieTrack;
//    Track winnipegToDuluthTrack;
//    Track duluthToSaultSteMarieTrack;
//    Track duluthToTorontoTrack;
//    Track duluthToChicagoTrack;
//    Track duluthToOmahaTrack;
//    Track omahaToChicagoTrack;
//    Track omahatoKansasCityTrack;
//    Track kansasCityToSaintLouiseTrack;
//    Track kansasCityToOklahomaCityTrack;
//    Track oklahomaCityToLittleRockTrack;
//    Track oklahomaCityToDallasTrack;
//    Track dallasToLittleRockTrack;
//    Track dallasToHoustonTrack;
//    Track houstonToNewOrleansTrack;
//    //Mississippi
//    Track saultSteMarieToMontrealTrack;
//    Track saultSteMarieToTorontoTrack;
//    Track chicagoToTorontoTrack;
//    Track chicagoToPittsburghTrack;
//    Track chicagoToSaintLouisTrack;
//    Track saintLouisToPittsburghTrack;
//    Track saintLouisToNashvilleTrack;
//    Track saintLouisToLittleRockTrack;
//    Track nashvilleToPittsburghTrack;
//    Track nashvilleToRaleighTrack;
//    Track nashvilleToAtlantaTrack;
//    Track littleRockToNashvilleTrack;
//    Track littleRockToNewOrleansTracks;
//    Track newOrleansToAtlantaTrack;
//    Track newOrleansToMiamiTrack;
//    //Appalachia
//    Track torontoToMontrealTrack;
//    Track torontoToPittsburghTrack;
//    Track pittsburghToNewYorkTrack;
//    Track pittsburghToWashingtonTrack;
//    Track pittsburghToRaleighTrack;
//    Track raleighToWashingtonTrack;
//    Track raleighToCharlestonTrack;
//    Track raleighToAtlantaTrack;
//    Track atlantaToCharlestonTrack;
//    Track atlantaToMiamiTrack;
//    Track miamiToCharlestonTrack;
//    //NorthEast
//    Track montrealToBostonTrack;
//    Track montrealToNewYorkTrack;
//    Track newYorkToBostonTrack;
//    Track newYorkToWashingtonTrack;
    //array of tracks
    Track myTracks[] = new Track[0];

    // TicketToRideSurfaceView constructor
    public TTRSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotCacheDrawing(false);
        int maxX = getMaxWidth();
        int maxY = getMaxHeight();
//        /* Initilize all track objects */
//        vancouverToSeattle.addRect(102f, 115f, 125f, 165f, Path.Direction.CW);
//        vancouverToSeattleTrack = new Track(1, "Gray", "Vancouver", "Seattle", vancouverToSeattle, touchArea1);

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
    //    vancouverToCalgaryTrack = new Track(3, "Gray", "Vancouver", "Calgary");
        //not initialized
//        vancouverToSeattleTrack = new Track(1, "Gray", "Vancouver", "Seattle");
//        vancouverToSeattle.addRect(102f, 115f, 125f, 165f, Path.Direction.CW);

//        portlandToSanFrancisco.moveTo(maxX * .028f, maxY * .286f);
//        portlandToSanFrancisco.lineTo(maxX * .016f, maxY * .333f);
//        portlandToSanFrancisco.lineTo(maxX * .026f, maxY * .341f);
//        portlandToSanFrancisco.lineTo(maxX * .038f, maxY * .294f);
//        portlandToSanFrancisco.close();
//        portlandToSanFrancisco.moveTo(maxX * .015f, maxY * .345f);
//        portlandToSanFrancisco.lineTo(maxX * .009f, maxY * .398f);
//        portlandToSanFrancisco.lineTo(maxX * .019f, maxY * .398f);
//        portlandToSanFrancisco.lineTo(maxX * .024f, maxY * .35f);
//        portlandToSanFrancisco.close();
//        portlandToSanFrancisco.moveTo(maxX * .008f, maxY * .408f);
//        portlandToSanFrancisco.lineTo(maxX * .018f, maxY * .408f);
//        portlandToSanFrancisco.lineTo(maxX * .017f, maxY * .459f);
//        portlandToSanFrancisco.lineTo(maxX * .007f, maxY * .459f);
//        portlandToSanFrancisco.close();
//        portlandToSanFrancisco.moveTo(maxX * .007f, maxY * .469f);
//        portlandToSanFrancisco.lineTo(maxX * .0098f, maxY * .523f);
//        portlandToSanFrancisco.lineTo(maxX * .0197f, maxY * .522f);
//        portlandToSanFrancisco.lineTo(maxX * .0168f, maxY * .469f);
//        portlandToSanFrancisco.close();
//        portlandToSanFrancisco.moveTo(maxX * .0105f, maxY * .5336f);
//        portlandToSanFrancisco.lineTo(maxX * .0186f, maxY * .579f);
//        portlandToSanFrancisco.lineTo(maxX * .029f, maxY * .578f);
//        portlandToSanFrancisco.lineTo(maxX * .0215f, maxY * .5285f);
//        portlandToSanFrancisco.close();
//        portlandToSanFranciscoTrack = new Track(5, "Green", "Portland", "SanFrancisco", portlandToSanFrancisco, sanFranciscoToPortlandRect);
//
//        sanFranciscoToLosAngeles.moveTo(maxX * .029f, maxY * .629f);
//        sanFranciscoToLosAngeles.lineTo(maxX * .043f, maxY * .680f);
//        sanFranciscoToLosAngeles.lineTo(maxX * .053f, maxY * .675f);
//        sanFranciscoToLosAngeles.lineTo(maxX * .038f, maxY * .623f);
//        sanFranciscoToLosAngeles.close();
//        sanFranciscoToLosAngeles.moveTo(maxX * .043f, maxY * .690f);
//        sanFranciscoToLosAngeles.lineTo(maxX * .063f, maxY * .735f);
//        sanFranciscoToLosAngeles.lineTo(maxX * .072f, maxY * .725f);
//        sanFranciscoToLosAngeles.lineTo(maxX * .053f, maxY * .682f);
//        sanFranciscoToLosAngeles.close();
//        sanFranciscoToLosAngeles.moveTo(maxX * .067f, maxY * .740f);
//        sanFranciscoToLosAngeles.lineTo(maxX * .090f, maxY * .775f);
//        sanFranciscoToLosAngeles.lineTo(maxX * .098f, maxY * .770f);
//        sanFranciscoToLosAngeles.lineTo(maxX * .076f, maxY * .732f);
//        sanFranciscoToLosAngeles.close();
//        sanFranciscoToLosAngelesTrack = new Track(3, "Yellow", "SanFrancisco", "LosAngeles",
//                sanFranciscoToLosAngeles, sanFranciscoToLosAngelesRect);
//
//        losAngelesToLasVegas.moveTo(maxX * .127f, maxY * .702f);
//        losAngelesToLasVegas.lineTo(maxX * .137f, maxY * .707f);
//        losAngelesToLasVegas.lineTo(maxX * .124f, maxY * .754f);
//        losAngelesToLasVegas.lineTo(maxX * .115f, maxY * .749f);
//        losAngelesToLasVegas.close();
//        losAngelesToLasVegas.moveTo(maxX * .139f, maxY * .704f);
//        losAngelesToLasVegas.lineTo(maxX * .137f, maxY * .685f);
//        losAngelesToLasVegas.lineTo(maxX * .170f, maxY * .673f);
//        losAngelesToLasVegas.lineTo(maxX * .172f, maxY * .694f);
//        losAngelesToLasVegas.close();
//        losAngelesToLasVegasTrack = new Track(2, "Gray", "Los Angeles", "Los Vegas",
//                losAngelesToLasVegas, losAngelesToLasVegasRect);
//
//        montrealToBoston.moveTo(maxX * .929f, maxY * .0583f);
//        montrealToBoston.lineTo(maxX * .9537f, maxY * .0951f);
//        montrealToBoston.lineTo(maxX * .9456f, maxY * .10f);
//        montrealToBoston.lineTo(maxX * .9235f, maxY * .0678f);
//        montrealToBoston.close();
//        montrealToBoston.moveTo(maxX * .95f, maxY * .11f);
//        montrealToBoston.lineTo(maxX * .9573f, maxY * .097f);
//        montrealToBoston.lineTo(maxX * .9826f, maxY * .1298f);
//        montrealToBoston.lineTo(maxX * .9762f, maxY * .1405f);
//        montrealToBoston.close();
//        montrealToBostonTrack = new Track(2, "Gray", "Montreal", "Boston", montrealToBoston, montrealtoBostonRect);
//
//        montrealToNewYork.moveTo(maxX * .899f, maxY * .089f);
//        montrealToNewYork.lineTo(maxX * .91f, maxY * .087f);
//        montrealToNewYork.lineTo(maxX * .915f, maxY * .145f);
//        montrealToNewYork.lineTo(maxX * .904f, maxY * .146f);
//        montrealToNewYork.close();
//        montrealToNewYork.moveTo(maxX * .9055f, maxY * .148f);
//        montrealToNewYork.lineTo(maxX * .916f, maxY * .146f);
//        montrealToNewYork.lineTo(maxX * .921f, maxY * .2f);
//        montrealToNewYork.lineTo(maxX * .911f, maxY * .2002f);
//        montrealToNewYork.close();
//        montrealToNewYork.moveTo(maxX * .91f, maxY * .207f);
//        montrealToNewYork.lineTo(maxX * .921f, maxY * .2073f);
//        montrealToNewYork.lineTo(maxX * .927f, maxY * .26f);
//        montrealToNewYork.lineTo(maxX * .916f, maxY * .26f);
//        montrealToNewYork.close();
//        montrealToNewYorkTrack = new Track(3, "Blue", "Montreal", "New York", montrealToNewYork,
//                montrealtoNewYorkRect);
//
//        newYorkToBoston.moveTo(maxX * .97f, maxY * .17f);
//        newYorkToBoston.lineTo(maxX * .98f, maxY * .175f);
//        newYorkToBoston.lineTo(maxX * .965f, maxY * .218f);
//        newYorkToBoston.lineTo(maxX * .952f, maxY * .21f);
//        newYorkToBoston.close();
//        newYorkToBoston.moveTo(maxX * .95f, maxY * .218f);
//        newYorkToBoston.lineTo(maxX * .959f, maxY * .228f);
//        newYorkToBoston.lineTo(maxX * .943f, maxY * .272f);
//        newYorkToBoston.lineTo(maxX * .934f, maxY * .263f);
//        newYorkToBoston.close();
//        newYorkToBostonTrack = new Track(2, "Yellow", "New York", "Boston", newYorkToBoston, newYorkToBostonRect);
//
//        newYorkToWashington.moveTo(maxX * .922f, maxY * .3f);
//        newYorkToWashington.lineTo(maxX * .935f, maxY * .3f);
//        newYorkToWashington.lineTo(maxX * .937f, maxY * .357f);
//        newYorkToWashington.lineTo(maxX * .923f, maxY * .354f);
//        newYorkToWashington.close();
//        newYorkToWashington.moveTo(maxX * .925f, maxY * .36f);
//        newYorkToWashington.lineTo(maxX * .935f, maxY * .36f);
//        newYorkToWashington.lineTo(maxX * .939f, maxY * .417f);
//        newYorkToWashington.lineTo(maxX * .928f, maxY * .417f);
//        newYorkToWashington.close();
//        newYorkToWashingtonTrack = new Track(2, "Orange", "New York", "Washington", newYorkToWashington, newYorkToWashingtonRect);
//
//        raleighToWashington.moveTo(maxX * .923f, maxY * .436f);
//        raleighToWashington.lineTo(maxX * .934f, maxY * .448f);
//        raleighToWashington.lineTo(maxX * .91f, maxY * .49f);
//        raleighToWashington.lineTo(maxX * .9f, maxY * .48f);
//        raleighToWashington.close();
//        raleighToWashington.moveTo(maxX * .897f, maxY * .487f);
//        raleighToWashington.lineTo(maxX * .904f, maxY * .497f);
//        raleighToWashington.lineTo(maxX * .887f, maxY * .534f);
//        raleighToWashington.lineTo(maxX * .877f, maxY * .525f);
//        raleighToWashington.close();
//        raleighToWashingtonTrack = new Track(2, "Gray", "Raleigh", "Washington", raleighToWashington, raleighToWashingtonRect);
//
//        raleighToCharleston.moveTo(maxX * .882f, maxY * .566f);
//        raleighToCharleston.lineTo(maxX * .889f, maxY * .551f);
//        raleighToCharleston.lineTo(maxX * .915f, maxY * .586f);
//        raleighToCharleston.lineTo(maxX * .91f, maxY * .6f);
//        raleighToCharleston.close();
//        raleighToCharleston.moveTo(maxX * .918f, maxY * .59f);
//        raleighToCharleston.lineTo(maxX * .928f, maxY * .595f);
//        raleighToCharleston.lineTo(maxX * .915f, maxY * .65f);
//        raleighToCharleston.lineTo(maxX * .902f, maxY * .64f);
//        raleighToCharleston.close();
//        raleighToCharlestonTrack = new Track(2, "Gray", "Raleigh", "Charleston", raleighToCharleston, raleighToCharlestonRect);
//
//        miamiToCharleston.moveTo(maxX * .9f, maxY * .675f);
//        miamiToCharleston.lineTo(maxX * .912f, maxY * .675f);
//        miamiToCharleston.lineTo(maxX * .915f, maxY * .72f);
//        miamiToCharleston.lineTo(maxX * .9f, maxY * .72f);
//        miamiToCharleston.close();
//        miamiToCharleston.moveTo(maxX * .902f, maxY * .73f);
//        miamiToCharleston.lineTo(maxX * .916f, maxY * .73f);
//        miamiToCharleston.lineTo(maxX * .92f, maxY * .79f);
//        miamiToCharleston.lineTo(maxX * .909f, maxY * .79f);
//        miamiToCharleston.close();
//        miamiToCharleston.moveTo(maxX * .91f, maxY * .798f);
//        miamiToCharleston.lineTo(maxX * .922f, maxY * .796f);
//        miamiToCharleston.lineTo(maxX * .93f, maxY * .845f);
//        miamiToCharleston.lineTo(maxX * .92f, maxY * .848f);
//        miamiToCharleston.close();
//        miamiToCharleston.moveTo(maxX * .92f, maxY * .852f);
//        miamiToCharleston.lineTo(maxX * .933f, maxY * .846f);
//        miamiToCharleston.lineTo(maxX * .951f, maxY * .9f);
//        miamiToCharleston.lineTo(maxX * .94f, maxY * .905f);
//        miamiToCharleston.close();
//        miamiToCharlestonTrack = new Track(4, "Pink", "Miami", "Charleston", miamiToCharleston, miamiToChaelestonRect);
//
//        atlantaToMiami.moveTo(maxX * .807f, maxY * .677f);
//        atlantaToMiami.lineTo(maxX * .817f, maxY * .67f);
//        atlantaToMiami.lineTo(maxX * .84f, maxY * .715f);
//        atlantaToMiami.lineTo(maxX * .828f, maxY * .725f);
//        atlantaToMiami.close();
//        atlantaToMiami.moveTo(maxX * .832f, maxY * .73f);
//        atlantaToMiami.lineTo(maxX * .843f, maxY * .723f);
//        atlantaToMiami.lineTo(maxX * .86f, maxY * .76f);
//        atlantaToMiami.lineTo(maxX * .85f, maxY * .765f);
//        atlantaToMiami.close();
//        atlantaToMiami.moveTo(maxX * .856f, maxY * .772f);
//        atlantaToMiami.lineTo(maxX * .867f, maxY * .7645f);
//        atlantaToMiami.lineTo(maxX * .8875f, maxY * .813f);
//        atlantaToMiami.lineTo(maxX * .875f, maxY * .818f);
//        atlantaToMiami.close();
//        atlantaToMiami.moveTo(maxX * .88f, maxY * .82f);
//        atlantaToMiami.lineTo(maxX * .89f, maxY * .812f);
//        atlantaToMiami.lineTo(maxX * .912f, maxY * .853f);
//        atlantaToMiami.lineTo(maxX * .899f, maxY * .86f);
//        atlantaToMiami.close();
//        atlantaToMiami.moveTo(maxX * .902f, maxY * .865f);
//        atlantaToMiami.lineTo(maxX * .91f, maxY * .856f);
//        atlantaToMiami.lineTo(maxX * .935f, maxY * .905f);
//        atlantaToMiami.lineTo(maxX * .925f, maxY * .91f);
//        atlantaToMiami.close();
//        atlantaToMiamiTrack = new Track(5, "Blue", "Atlanta", "Miami", atlantaToMiami, atlantaToMiamiRect);
//
//        atlantaToCharleston.moveTo(maxX * .82f, maxY * .65f);
//        atlantaToCharleston.lineTo(maxX * .855f, maxY * .652f);
//        atlantaToCharleston.lineTo(maxX * .855f, maxY * .671f);
//        atlantaToCharleston.lineTo(maxX * .82f, maxY * .671f);
//        atlantaToCharleston.close();
//        atlantaToCharleston.moveTo(maxX * .862f, maxY * .652f);
//        atlantaToCharleston.lineTo(maxX * .895f, maxY * .653f);
//        atlantaToCharleston.lineTo(maxX * .895f, maxY * .673f);
//        atlantaToCharleston.lineTo(maxX * .862f, maxY * .673f);
//        atlantaToCharleston.close();
//        atlantaToCharlestonTrack = new Track(2, "Gray", "Atlanta", "Charleston", atlantaToCharleston, atlantaToCharlestonRect);
//
//        raleighToAtlanta.moveTo(maxX * .862f, maxY * .545f);
//        raleighToAtlanta.lineTo(maxX * .871f, maxY * .556f);
//        raleighToAtlanta.lineTo(maxX * .844f, maxY * .6f);
//        raleighToAtlanta.lineTo(maxX * .834f, maxY * .581f);
//        raleighToAtlanta.close();
//        raleighToAtlanta.moveTo(maxX * .834f, maxY * .589f);
//        raleighToAtlanta.lineTo(maxX * .843f, maxY * .6f);
//        raleighToAtlanta.lineTo(maxX * .815f, maxY * .633f);
//        raleighToAtlanta.lineTo(maxX * .808f, maxY * .619f);
//        raleighToAtlanta.close();
//        raleighToAtlantaTrack = new Track(2, "Gray", "Raleigh", "Atlanta", raleighToAtlanta, raleighToAtlantaRect);
//
//        pittsburghToRaleigh.moveTo(maxX * .843f, maxY * .393f);
//        pittsburghToRaleigh.lineTo(maxX * .855f, maxY * .39f);
//        pittsburghToRaleigh.lineTo(maxX * .864f, maxY * .448f);
//        pittsburghToRaleigh.lineTo(maxX * .85f, maxY * .452f);
//        pittsburghToRaleigh.close();
//        pittsburghToRaleigh.moveTo(maxX * .85f, maxY * .454f);
//        pittsburghToRaleigh.lineTo(maxX * .864f, maxY * .45f);
//        pittsburghToRaleigh.lineTo(maxX * .873f, maxY * .508f);
//        pittsburghToRaleigh.lineTo(maxX * .86f, maxY * .51f);
//        pittsburghToRaleigh.close();
//        pittsburghToRaleighTrack = new Track(2, "Gray", "Pittsburgh", "Raleigh", pittsburghToRaleigh, pittsburghToRaleighRect);
//
//        pittsburghToWashington.moveTo(maxX * .855f, maxY * .38f);
//        pittsburghToWashington.lineTo(maxX * .858f, maxY * .365f);
//        pittsburghToWashington.lineTo(maxX * .892f, maxY * .393f);
//        pittsburghToWashington.lineTo(maxX * .885f, maxY * .405f);
//        pittsburghToWashington.close();
//        pittsburghToWashington.moveTo(maxX * .89f, maxY * .408f);
//        pittsburghToWashington.lineTo(maxX * .895f, maxY * .396f);
//        pittsburghToWashington.lineTo(maxX * .928f, maxY * .418f);
//        pittsburghToWashington.lineTo(maxX * .919f, maxY * .434f);
//        pittsburghToWashington.close();
//        pittsburghToWashingtonTrack = new Track(2, "Gray", "Pittsburgh", "Washington", pittsburghToWashington, pittsburghToWashingtonRect);
//
//        pittsburghToNewYork.moveTo(maxX * .845f, maxY * .33f);
//        pittsburghToNewYork.lineTo(maxX * .875f, maxY * .3f);
//        pittsburghToNewYork.lineTo(maxX * .883f, maxY * .313f);
//        pittsburghToNewYork.lineTo(maxX * .853f, maxY * .34f);
//        pittsburghToNewYork.close();
//        pittsburghToNewYork.moveTo(maxX * .879f, maxY * .295f);
//        pittsburghToNewYork.lineTo(maxX * .91f, maxY * .27f);
//        pittsburghToNewYork.lineTo(maxX * .915f, maxY * .285f);
//        pittsburghToNewYork.lineTo(maxX * .884f, maxY * .31f);
//        pittsburghToNewYork.close();
//        pittsburghToNewYorkTrack = new Track(2, "White", "Pittsburgh", "New York", pittsburghToNewYork, pittsburghToNewYorkRect);
//
//        torontoToPittsburgh.moveTo(maxX * .824f, maxY * .216f);
//        torontoToPittsburgh.lineTo(maxX * .835f, maxY * .215f);
//        torontoToPittsburgh.lineTo(maxX * .838f, maxY * .278f);
//        torontoToPittsburgh.lineTo(maxX * .826f, maxY * .279f);
//        torontoToPittsburgh.close();
//        torontoToPittsburgh.moveTo(maxX * .827f, maxY * .283f);
//        torontoToPittsburgh.lineTo(maxX * .838f, maxY * .282f);
//        torontoToPittsburgh.lineTo(maxX * .84f, maxY * .335f);
//        torontoToPittsburgh.lineTo(maxX * .829f, maxY * .336f);
//        torontoToPittsburgh.close();
//        torontoToPittsburghTrack = new Track(2, "Gray", "Toronto", "Pittsburgh", torontoToPittsburgh, torontoToPittsburghRect);
//
//        torontoToMontreal.moveTo(maxX * .83f, maxY * .127f);
//        torontoToMontreal.lineTo(maxX * .841f, maxY * .137f);
//        torontoToMontreal.lineTo(maxX * .821f, maxY * .189f);
//        torontoToMontreal.lineTo(maxX * .812f, maxY * .182f);
//        torontoToMontreal.close();
//        torontoToMontreal.moveTo(maxX * .86f, maxY * .09f);
//        torontoToMontreal.lineTo(maxX * .867f, maxY * .1f);
//        torontoToMontreal.lineTo(maxX * .842f, maxY * .14f);
//        torontoToMontreal.lineTo(maxX * .832f, maxY * .125f);
//        torontoToMontreal.close();
//        torontoToMontreal.moveTo(maxX * .895f, maxY * .06f);
//        torontoToMontreal.lineTo(maxX * .901f, maxY * .075f);
//        torontoToMontreal.lineTo(maxX * .87f, maxY * .0999f);
//        torontoToMontreal.lineTo(maxX * .865f, maxY * .083f);
//        torontoToMontreal.close();
//        torontoToMontrealTrack = new Track(3, "Gray", "Toronto", "Montreal", torontoToMontreal, torontoToMontrealRect);
//
//        saultSteMarieToMontreal.moveTo(maxX * .737f, maxY * .108f);
//        saultSteMarieToMontreal.lineTo(maxX * .747f, maxY * .12f);
//        saultSteMarieToMontreal.lineTo(maxX * .723f, maxY * .16f);
//        saultSteMarieToMontreal.lineTo(maxX * .713f, maxY * .15f);
//        saultSteMarieToMontreal.close();
//        saultSteMarieToMontreal.moveTo(maxX * .775f, maxY * .075f);
//        saultSteMarieToMontreal.lineTo(maxX * .78f, maxY * .093f);
//        saultSteMarieToMontreal.lineTo(maxX * .75f, maxY * .12f);
//        saultSteMarieToMontreal.lineTo(maxX * .74f, maxY * .105f);
//        saultSteMarieToMontreal.close();
//        saultSteMarieToMontreal.moveTo(maxX * .81f, maxY * .055f);
//        saultSteMarieToMontreal.lineTo(maxX * .815f, maxY * .075f);
//        saultSteMarieToMontreal.lineTo(maxX * .782f, maxY * .095f);
//        saultSteMarieToMontreal.lineTo(maxX * .778f, maxY * .075f);
//        saultSteMarieToMontreal.close();
//        saultSteMarieToMontreal.moveTo(maxX * .85f, maxY * .045f);
//        saultSteMarieToMontreal.lineTo(maxX * .852f, maxY * .062f);
//        saultSteMarieToMontreal.lineTo(maxX * .82f, maxY * .075f);
//        saultSteMarieToMontreal.lineTo(maxX * .815f, maxY * .056f);
//        saultSteMarieToMontreal.close();
//        saultSteMarieToMontreal.moveTo(maxX * .89f, maxY * .043f);
//        saultSteMarieToMontreal.lineTo(maxX * .89f, maxY * .06f);
//        saultSteMarieToMontreal.lineTo(maxX * .855f, maxY * .06f);
//        saultSteMarieToMontreal.lineTo(maxX * .855f, maxY * .043f);
//        saultSteMarieToMontreal.close();
//        saultSteMarieToMontrealTrack = new Track(5, "Black", "Sault St. Marie", "Montreal",
//                saultSteMarieToMontreal, saultSteMarieToMontrealRect);
//
//        newOrleansToMiami.moveTo(maxX * .755f, maxY * .83f);
//        newOrleansToMiami.lineTo(maxX * .76f, maxY * .843f);
//        newOrleansToMiami.lineTo(maxX * .73f, maxY * .87f);
//        newOrleansToMiami.lineTo(maxX * .725f, maxY * .86f);
//        newOrleansToMiami.close();
//        newOrleansToMiami.moveTo(maxX * .795f, maxY * .81f);
//        newOrleansToMiami.lineTo(maxX * .799f, maxY * .825f);
//        newOrleansToMiami.lineTo(maxX * .763f, maxY * .84f);
//        newOrleansToMiami.lineTo(maxX * .76f, maxY * .825f);
//        newOrleansToMiami.close();
//        newOrleansToMiami.moveTo(maxX * .799f, maxY * .81f);
//        newOrleansToMiami.lineTo(maxX * .835f, maxY * .81f);
//        newOrleansToMiami.lineTo(maxX * .835f, maxY * .825f);
//        newOrleansToMiami.lineTo(maxX * .799f, maxY * .825f);
//        newOrleansToMiami.close();
//        newOrleansToMiami.moveTo(maxX * .84f, maxY * .811f);
//        newOrleansToMiami.lineTo(maxX * .872f, maxY * .838f);
//        newOrleansToMiami.lineTo(maxX * .867f, maxY * .853f);
//        newOrleansToMiami.lineTo(maxX * .835f, maxY * .83f);
//        newOrleansToMiami.close();
//        newOrleansToMiami.moveTo(maxX * .876f, maxY * .845f);
//        newOrleansToMiami.lineTo(maxX * .903f, maxY * .875f);
//        newOrleansToMiami.lineTo(maxX * .895f, maxY * .89f);
//        newOrleansToMiami.lineTo(maxX * .87f, maxY * .86f);
//        newOrleansToMiami.close();
//        newOrleansToMiami.moveTo(maxX * .905f, maxY * .886f);
//        newOrleansToMiami.lineTo(maxX * .93f, maxY * .926f);
//        newOrleansToMiami.lineTo(maxX * .92f, maxY * .94f);
//        newOrleansToMiami.lineTo(maxX * .899f, maxY * .899f);
//        newOrleansToMiami.close();
//        newOrleansToMiamiTrack = new Track(6, "Red", "New Orleans", "Miami", newOrleansToMiami, newOrleansToMiamiRect);
//
//        losAngelesToPhoenixTrack = new Track(3, "Gray", "LosAngeles", "LasVegas", losAngelesToPheonix, losAngelesToPhoenixRect);
//        myTracks = new Track[]{portlandToSanFranciscoTrack, vancouverToSeattleTrack,
//                losAngelesToLasVegasTrack, GRID_TRACK, sanFranciscoToLosAngelesTrack,
//                montrealToBostonTrack, losAngelesToPhoenixTrack, montrealToNewYorkTrack,
//                newYorkToBostonTrack, newYorkToWashingtonTrack, raleighToWashingtonTrack,
//                raleighToCharlestonTrack, miamiToCharlestonTrack, atlantaToMiamiTrack,
//                atlantaToCharlestonTrack, raleighToAtlantaTrack, pittsburghToRaleighTrack,
//                pittsburghToWashingtonTrack, pittsburghToNewYorkTrack, torontoToPittsburghTrack,
//                torontoToMontrealTrack, saultSteMarieToMontrealTrack, newOrleansToMiamiTrack};
    }

    /*
     * onDraw method handles canvas and drawing (like paint() in java)
     */
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        drawBoard(canvas);
        for(Track track : myTracks){
            if(track != null) {
                if (track.getHighlight()) {
                    paint.setColor(HIGHLIGHT_COLOR);
                    paint.setStrokeWidth(5);
                    paint.setStyle(Paint.Style.STROKE);
                    canvas.drawPath(track.getPath(), paint);
                }
                if (track.getSelected()) {
                    paint.setColor(SELECTION_COLOR);
                    canvas.drawPath(track.getPath(), paint);
                }
                if (track.getCovered()) {
                    paint.setColor(RED_COLOR);
                    paint.setStyle(Paint.Style.FILL);
                    canvas.drawPath(track.getPath(), paint);
                }
            }
        }
    }
    public int getMaxWidth(){return maxX;}
    public int getMaxHeight(){return maxY;}
    /*
     * Method which draws the board image onto the canvas
     */
    protected void drawBoard(Canvas canvas){
        boardImage = Bitmap.createScaledBitmap(boardImage, maxX, maxY, false);
        canvas.drawBitmap(boardImage, 0, 0, new Paint());
    }

    /*
     * Method which enables highlighting track mode
     * and then refresh the onDraw method to show highlight
     */
    protected void setHighlightTrainMode(){
        highlightMode = true;
        for(Track track : myTracks) {
            if(!track.getCovered()){
                track.setSelected(!highlightMode);
                track.setHighlight(highlightMode);
            }
        }
        // Refreshes the view by calling onDraw function
        postInvalidate();
    }

    /*
     * Method which refreshes the canvas and draws a train
     */
    protected void drawTrain(){
        for(Track track : myTracks){
            track.setHighlight(false);
            if(track.getSelected()){
                track.setCovered(true);
            }
            track.setSelected(false);
        }
        highlightMode = false;
        // Refreshes the view by calling onDraw function
        postInvalidate();
    }

    /*
     * Method which changes from green highlight to blue highlight to indicate selection
     */
    public void setSelection(int x, int y) {
        for(Track track : myTracks){
            if(track.isTouched(x, y) && !track.getSelected() && !track.getCovered()){
                for(Track trackZ : myTracks) {
                    trackZ.setSelected(false);
                }
                track.setSelected(true);
            }
        }
        postInvalidate();
    }

    public int getTracksLength(){
        int size = myTracks.length;
        return size;
    }
    public Track[] getTracks(){
        return myTracks;
    }

    public void setTracks(Track[] tracks){this.myTracks = tracks;}
}
