package teamresistance.tickettoride.TTR;

import android.graphics.Path;
import android.graphics.Rect;

import java.io.Serializable;

/**
 *  Track is a class representing the tracks
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class Track implements Serializable {
    private static final long serialVersionUID = 388245564192016L;
    //instance variables for tracks
    private int trainTrackNum = 0;
    private int playerID = -1;
    private String trackColor = "";
    private String track2Color = "";
    private Boolean selected = false;
    private Boolean highlight = false;
    private Boolean covered = false;
    private Boolean selected2 = false;
    private Boolean highlight2 = false;
    private Boolean covered2 = false;
    private CustomPath trackPath = new CustomPath();
    private CustomPath trackPath2 = new CustomPath();
    private Rect touchArea = new Rect();
    private String startCity = "";
    private String endCity = "";
    private boolean selectHighlight = false;
    private boolean doubleTrack = false;

    /**
     * Constructor for track object
     * @param trainTrackNum the length/number of train cars needed to claim route
     * @param trackColor  color assigned to track route
     * @param secondCity collection of paths representing the locations for placed train tokens
     * @param firstCity area around path that is selectable by user
     */
    public Track(int trainTrackNum, String trackColor, String firstCity, String secondCity,
                 CustomPath path, Rect passedTouchArea, boolean doubletrackset, String track2color, 
                 CustomPath path2){
        this.trainTrackNum = trainTrackNum;
        this.trackColor = trackColor;
        this.track2Color = track2color;
        this.startCity = firstCity;
        this.endCity = secondCity;
        this.highlight = false;
        this.selected = false;
        this.trackPath.set(path);
        this.trackPath2.set(path2);
        this.touchArea = passedTouchArea;
        this.doubleTrack = doubletrackset;
        this.selected2 = false;
        this.highlight2 = false;
        this.covered2 = false;
    }

    public Track(Track original){
        this.trainTrackNum = original.getTrainTrackNum();
        this.trackColor = original.getTrackColor();
        this.track2Color = original.getTrack2Color();
        startCity = original.getStartCity();
        endCity = original.getEndCity();
        highlight = false;
        selected = false;
        this.trackPath.set(original.getPath());
        this.trackPath2.set(original.getPath2());
        this.touchArea = original.getTouchArea();
        this.doubleTrack = original.getDoubleTrack();
        selected2 = false;
        highlight2 = false;
        covered2 = false;
    }

    public String getTrack2Color(){
        return track2Color;
    }
    public boolean getDoubleTrack(){
        return doubleTrack;
    }
    public boolean isDoubleTrack(){
        return this.doubleTrack;
    }

    /**
     * Sets whether the track is highlighted or not
     *
     * @param val - new value for if track is highlighted
     */
    public void setHighlight(Boolean val){
        highlight = val;
    }

    /**
     * Retruns if highlighted
     *
     * @return
     *      Returns true/false if track is highlighted
     */
    public Boolean getHighlight(){
        return highlight;
    }

    /**
     * Sets whether the track is highlighted or not
     *
     * @param val - new value for if track is highlighted
     */
    public void setHighlight2(Boolean val){
        highlight2 = val;
    }

    /**
     * Retruns if highlighted
     *
     * @return
     *      Returns true/false if track is highlighted
     */
    public Boolean getHighlight2(){
        return highlight2;
    }

    /**
     * Returns the raw x and y values from user touches on screen
     * @param x raw x value
     * @param y raw y value
     * @return
     */
    public Boolean isTouched(int x, int y){
        return (touchArea.contains(x,y));
    }

    /**
     * Returns the tracknumber
     * @return
     */
    public int getTrainTrackNum(){
        return trainTrackNum;
    }

    /**
     * Retruns the track Path
     * @return
     */
    public CustomPath getPath(){
        return trackPath;
    }

    /**
     * Retruns the track Path
     * @return
     */
    public CustomPath getPath2(){
        return trackPath2;
    }
    /**
     * Sets the track path
     * @param path - new Path for graphics
     */
    public void setPath(CustomPath path){
        trackPath.set(path);
    }

    /**
     * Sets the track path
     * @param path - new Path for graphics
     */

    public void setPath2(CustomPath path){
        trackPath2.set(path);
    }

    /**
     * Checks if track is selected
     * @return
     */
    public Boolean getSelected(){
        return selected;
    }

    /**
     * Sets the tracks new selected value
     * @param val - new boolean for if selected
     */
    public void setSelected(Boolean val){
        selected = val;
    }

    /**
     * Checks if track is selected
     * @return
     */
    public Boolean getSelected2(){
        return selected2;
    }

    /**
     * Sets the tracks new selected value
     * @param val - new boolean for if selected
     */
    public void setSelected2(Boolean val){
        selected2 = val;
    }

    /**
     * Retruns if the track is covered
     * @return
     */
    public Boolean getCovered2(){
        return covered2;
    }

    /**
     * Retruns if the track is covered
     * @return
     */
    public Boolean getCovered(){
        return covered;
    }

    public int getPlayerID(){return playerID;}

    public void setPlayerID(int val){this.playerID = val;}

    /**
     * Sets whether the track is/isn't selected
     * @param val - new boolean for if covered
     */
    public void setCovered(Boolean val){
        covered = val;
    }

    /**
     * Sets whether the track is/isn't selected
     * @param val - new boolean for if covered
     */
    public void setCovered2(Boolean val){
        covered2 = val;
    }

    public void setTrainTrackNum(int trainTrackNum) {
        this.trainTrackNum = trainTrackNum;
    }

    public String getTrackColor() {
        return trackColor;
    }

    public void setTrackColor(String trackColor) {
        this.trackColor = trackColor;
    }

    public String getTrackColor2() {
        return track2Color;
    }

    public void setTrackColor2(String trackColor) {
        this.track2Color = trackColor;
    }

    public Rect getTouchArea() {
        return touchArea;
    }

    public void setTouchArea(Rect touchArea) {
        this.touchArea = touchArea;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public boolean isSelectHighlight() {
        return selectHighlight;
    }

    public void setSelectHighlight(boolean selectHighlight) {
        this.selectHighlight = selectHighlight;
    }
}
