package teamresistance.tickettoride.TTR;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.io.Serializable;

import teamresistance.tickettoride.R;

/**
 * This is a surface view class that draws the game board/pieces onto the screen.
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */

public class TTRSurfaceView extends SurfaceView implements Serializable {
    private static final long serialVersionUID = 388245561312013L;

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
    /*
     * These ints correspond to hex colors used by this class
     */
    final int PLAYER1_COLOR = 0xFFFF0000;
    final int PLAYER2_COLOR = 0xFF0000FF;
    final int PLAYER3_COLOR = 0xFF00FF00;
    final int PLAYER4_COLOR = 0xFFFFFF00;
    final int HIGHLIGHT_COLOR = 0xFF00FF00;
    final int SELECTION_COLOR = 0xFF00ffff;

    private Paint paint = new Paint();

    //path initializations
    Track myTracks[] = new Track[0];

    // TicketToRideSurfaceView constructor
    public TTRSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotCacheDrawing(false);
        int maxX = getMaxWidth();
        int maxY = getMaxHeight();

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
                    if(track.getPlayerID() == 0){paint.setColor(PLAYER1_COLOR);}
                    else if(track.getPlayerID() == 1){paint.setColor(PLAYER2_COLOR);}
                    else if(track.getPlayerID() == 2){paint.setColor(PLAYER3_COLOR);}
                    else if(track.getPlayerID() == 3){paint.setColor(PLAYER4_COLOR);}
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

    /**
     * Returns the position of the track clicked by the user if within the track selection area
     * @param xPos
     * @param yPos
     * @return position in myTracks array
     */
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
