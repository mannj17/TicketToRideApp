package teamresistance.tickettoride.TTR;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import teamresistance.tickettoride.Game.GameHumanPlayer;
import teamresistance.tickettoride.Game.GameMainActivity;
import teamresistance.tickettoride.Game.infoMsg.GameInfo;
import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.R;

/**
 *  TTRHumanPlayer implements the human player
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class TTRHumanPlayer extends GameHumanPlayer implements View.OnClickListener, View.OnTouchListener {
    private TTRSurfaceView myBoard;
    private GameMainActivity myActivity;
    private Deck trainDeck;
    private Deck destinationDeck;
    private int score;
    private String name;
    private Boolean isTurn;
    private int trainTokens;


    private Button confirmSelection;
    private Button placeTrain;
    private TextView playerTrainCount = null;

    /** TextViews for player's names*/
    private TextView cpu1PlayerTextView;
    private TextView cpu2Plyaer;
    private TextView cpu3Player;
    private TextView humanPlayer;

    /*
    Variables for all of the buttons on the right side of the screen,
    the place holder variables to eliminate hard coding, and the
    ArrayList for all of the ImageButtons.
     */
    private ImageButton trainCard1;
    private ImageButton trainCard2;
    private ImageButton trainCard3;
    private ImageButton trainCard4;
    private ImageButton trainCard5;
    private ImageButton clickTrain;
    //array that contains booleans that correspond to a button in the ArrayList
    private boolean[] trainPressed;
    private ArrayList<ImageButton> trainCards = new ArrayList<ImageButton>();

    private CheckBox cardCheck;
    private CheckBox trainCheck;

    /*
     * The human player
     * @name
     */
    public TTRHumanPlayer(String name) {
        super(name);
    }

    /**
     * callback method when we get a message (e.g., from the game)
     *
     * @param info the message
     */
    @Override
    public void receiveInfo(GameInfo info) {
        if(info instanceof TTRGameState) {
            info = (TTRGameState) info;
            this.cpu1PlayerTextView.setText(""+((TTRGameState) info).getNumPlayers());
        }
    }

    /*
     * returns the top view for the player
     */
    public View getTopView() {
        return null;
    }


    /*
     * Sets the GUI for the player
     * @mainActivity
     */
    public void setAsGui(GameMainActivity mainActivity) {
        myActivity = mainActivity;
        myActivity.setContentView(R.layout.activity_ttr_main);

        //Initialize the widget reference member variables
        this.cpu1PlayerTextView = (TextView)myActivity.findViewById(R.id.CPU1Title);
    }

    /**
     * The click handler for the buttons.
     */
    @Override
    public void onClick(View v) {

    }
    /**
     * The touch handler for the touches.
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
}
