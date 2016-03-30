package teamresistance.tickettoride.TTR;

import android.graphics.Path;
import android.graphics.Rect;

/**
 *
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class Track {

    private String trackColor = null;
    private int trainTrackNum = 0;
    private Boolean selected = false;
    private Boolean highlight = false;
    private Boolean covered = false;
    private Path track;
    private Rect touchArea;
    private String startCity;
    private String endCity;
    private Boolean selectHighlight;

    public Boolean isTouched(int x, int y) {
     return false;
    }

    public Track(int trainTrackNum, String trainColor, Path path, Rect touchArea, String startCity, String endCity) {
    
    }


}
