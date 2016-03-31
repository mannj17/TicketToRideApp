package teamresistance.tickettoride.TTR;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

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

    /*
     * General variables used by the class in relation to drawing
     */
    private Paint paint = new Paint();
    private Path path1 = new Path();
    private Path path2 = new Path();
    Path path3 = new Path();

    //My Tracks
    Track track1;
    Track track2;
    Track track3;
    Track myTracks[];

    // TicketToRideSurfaceView constructor
    public TTRSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotCacheDrawing(false);

        /* Initilize all track objects */
        path1.addRect(102f, 115f, 125f, 165f, Path.Direction.CW);
        track1 = new Track(1, "Red", "City1", "City2");
        track1.setTrack(path1);

        /*
        path2.moveTo(219, 688);
        path2.lineTo(235, 693);
        path2.lineTo(214, 739);
        path2.lineTo(197, 734);
        path2.close();

        path2.moveTo(239, 690);
        path2.lineTo(236, 671);
        path2.lineTo(292, 660);
        path2.lineTo(295, 680);
        path2.close();
        track2 = new Track(2, RED_COLOR, path2, touchArea2);
        //path.reset();

        path3.moveTo(430,441);
        path3.lineTo(450, 456);
        path3.lineTo(475, 415);
        path3.lineTo(455,402);
        path3.close();
        path3.moveTo(484, 405);
        path3.lineTo(465, 395);
        path3.lineTo(490, 355);
        path3.lineTo(510,364);
        path3.close();
        path3.moveTo(495, 340);
        path3.lineTo(514, 350);
        path3.lineTo(540, 310);
        path3.lineTo(520,298);
        path3.close();
        track3 = new Track(3, RED_COLOR, path3, touchArea3);
        */

        myTracks = new Track[]{track1};
    }

    /*
     * onDraw method handles canvas and drawing (like paint() in java)
     */
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        drawBoard(canvas);

        for(Track track : myTracks){
            if(track.getHighlight()){
                paint.setColor(HIGHLIGHT_COLOR);
                paint.setStrokeWidth(5);
                paint.setStyle(Paint.Style.STROKE);
                canvas.drawPath(track.getTrack(), paint);
            }
            if(track.getSelected()) {
                paint.setColor(SELECTION_COLOR);
                canvas.drawPath(track.getTrack(), paint);
            }
            if(track.getCovered()) {
                paint.setColor(RED_COLOR);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawPath(track.getTrack(), paint);
            }
        }
    }

    /*
     * Method which draws the board image onto the canvas
     */
    protected void drawBoard(Canvas canvas){
        boardImage = Bitmap.createScaledBitmap(boardImage, 1720, 980, false);
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
                track.setSelected(false);
                track.setHighlight(true);
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
}
