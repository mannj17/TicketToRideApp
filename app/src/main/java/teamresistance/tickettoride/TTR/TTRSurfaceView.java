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

    //path initializations
    private Path GRID = new Path();
    Track GRID_TRACK;
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

    public int clickedTrack(int xPos, int yPos){
        int pos = -1;
        for(int i = 0; i < myTracks.length; i++){
            if(myTracks[i].isTouched(xPos, yPos)){
                pos = i;
            }
        }
        return pos;
    }
    public Track[] getTracks(){
        return myTracks;
    }

    public void setTracks(Track[] tracks){this.myTracks = tracks;}
}
