package teamresistance.tickettoride.TTR;

import android.graphics.Color;
import android.util.Log;
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
    private TextView cpu2PlayerTextView;
    private TextView cpu3PlayerTextView;
    private TextView humanTextView;
    /** TextViews for player's scores*/
    private TextView cpu1ScoreTextview;
    private TextView cpu2ScoreTextview;
    private TextView cpu3ScoreTextview;
    private TextView humanScoreTextview;
    /** TextViews for player's trainToken count*/
    private TextView cpu1TrainTokenTextView;
    private TextView cpu2TrainTokenTextView;
    private TextView cpu3TrainTokenTextView;
    private TextView humanTrainTokenTextView;
    /** TextViews for player's destination card count*/
    private TextView cpu1DestinationCardTextView;
    private TextView cpu2DestinationCardTextView;
    private TextView cpu3DestinationCardTextView;
    /** TextViews for player's train card count*/
    private TextView cpu1TrainCardTextView;
    private TextView cpu2TrainCardTextView;
    private TextView cpu3TrainCardTextView;

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
        //Update all TextViews to Display player details properly
        if(info instanceof TTRGameState) {
            int playerNum = ((TTRGameState) info).getNumPlayers();
            if(playerNum >= 1) {
                this.humanTextView.setText(""+this.allPlayerNames[0]);
                this.humanScoreTextview.setText(""+((TTRGameState) info).getScores()[0]);
            }
            if(playerNum >= 2) {
                this.cpu1PlayerTextView.setText(""+this.allPlayerNames[1]);
                this.cpu1ScoreTextview.setText(""+((TTRGameState) info).getScores()[1]);
                this.cpu1DestinationCardTextView.setText(""+((TTRGameState) info).getPlayerDestinationDecks()[1].getCards().size());
                this.cpu1TrainCardTextView.setText(""+((TTRGameState) info).getPlayerTrainDecks()[1].getCards().size());
            }
            if(playerNum >= 3) {
                this.cpu2PlayerTextView.setText(""+this.allPlayerNames[2]);
                this.cpu2ScoreTextview.setText(""+((TTRGameState) info).getScores()[2]);
                this.cpu2DestinationCardTextView.setText(""+((TTRGameState) info).getPlayerDestinationDecks()[2].getCards().size());
                this.cpu2TrainCardTextView.setText(""+((TTRGameState) info).getPlayerTrainDecks()[2].getCards().size());
            }
            if(playerNum >= 4) {
                this.cpu3PlayerTextView.setText(""+this.allPlayerNames[3]);
                this.cpu3ScoreTextview.setText(""+((TTRGameState) info).getScores()[3]);
                this.cpu3DestinationCardTextView.setText(""+((TTRGameState) info).getPlayerDestinationDecks()[3].getCards().size());
                this.cpu3TrainCardTextView.setText(""+((TTRGameState) info).getPlayerTrainDecks()[3].getCards().size());
            }
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
        this.cpu2PlayerTextView = (TextView)myActivity.findViewById(R.id.CPU2Title);
        this.cpu3PlayerTextView = (TextView)myActivity.findViewById(R.id.CPU3Title);
        this.humanTextView = (TextView)myActivity.findViewById(R.id.playerName);
        this.cpu1ScoreTextview = (TextView)myActivity.findViewById(R.id.CPU1Score);
        this.cpu2ScoreTextview = (TextView)myActivity.findViewById(R.id.CPU2Score);
        this.cpu3ScoreTextview = (TextView)myActivity.findViewById(R.id.CPU3Score);
        this.humanScoreTextview = (TextView)myActivity.findViewById(R.id.playerScore);
        this.cpu1TrainTokenTextView = (TextView)myActivity.findViewById(R.id.CPU1TrainCount);
        this.cpu2TrainTokenTextView = (TextView)myActivity.findViewById(R.id.CPU2TrainCount);
        this.cpu3TrainTokenTextView = (TextView)myActivity.findViewById(R.id.CPU3TrainCount);
        this.humanTrainTokenTextView = (TextView)myActivity.findViewById(R.id.playerTrainCount);
        this.cpu1DestinationCardTextView = (TextView)myActivity.findViewById(R.id.CPU1DestinationCardCount);
        this.cpu2DestinationCardTextView = (TextView)myActivity.findViewById(R.id.CPU2DestinationCardCount);
        this.cpu3DestinationCardTextView = (TextView)myActivity.findViewById(R.id.CPU3DestinationCardCount);
        this.cpu1TrainCardTextView = (TextView)myActivity.findViewById(R.id.CPU1TrainCount);
        this.cpu2TrainCardTextView  = (TextView)myActivity.findViewById(R.id.CPU2TrainCount);
        this.cpu3TrainCardTextView  = (TextView)myActivity.findViewById(R.id.CPU3TrainCount);
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
