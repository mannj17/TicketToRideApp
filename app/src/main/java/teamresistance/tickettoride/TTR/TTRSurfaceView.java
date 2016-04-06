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
 * @author Jess Mann
 * A: 15 Points: Select Four Element On Surface View
 *
 *      If Place Train checkbox is not selected, surface view will not offer user any stimulus.
 *      Once Place Train is checked, various "tracks" will appear that the player can interact
 *      with. These availible tracks will be highlighted green, and once tapped by the user the
 *      outline changes to blue. Once/if the user taps confirm, the outline selected by the user
 *      will be replaced with a red fill.
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
    Rect touchArea5 = new Rect(1400,200,1460,340);

    /*
     * These ints correspond to hex colors used by this class
     */
    final int RED_COLOR = 0xFFFF0000;
    final int HIGHLIGHT_COLOR = 0xFF00FF00;
    final int SELECTION_COLOR = 0xFF00ffff;


    private Paint paint = new Paint();
    //path initializations
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

    //Initializes all the tracks
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
    //array of tracks
    Track myTracks[];

    // TicketToRideSurfaceView constructor
    public TTRSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotCacheDrawing(false);
        int maxX = getMaxWidth();
        int maxY = getMaxHeight();
        /* Initilize all track objects */
        vancouverToSeattle.addRect(102f, 115f, 125f, 165f, Path.Direction.CW);
        vancouverToSeattleTrack = new Track(1, "Gray", "Vancouver", "Seattle", vancouverToSeattle);

        portlandToSanFrancisco.moveTo(maxX * .028f, maxY * .286f);
        portlandToSanFrancisco.lineTo(maxX * .016f, maxY * .333f);
        portlandToSanFrancisco.lineTo(maxX*.026f, maxY*.341f);
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
        portlandToSanFranciscoTrack = new Track(5, "Green", "Portland", "SanFrancisco", portlandToSanFrancisco);

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
        losAngelesToLasVegasTrack = new Track(2, "Gray", "Los Angeles", "Los Vegas", losAngelesToLasVegas);

        myTracks = new Track[]{portlandToSanFranciscoTrack, losAngelesToLasVegasTrack, vancouverToSeattleTrack};
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
    Boolean previous = false;
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
}
