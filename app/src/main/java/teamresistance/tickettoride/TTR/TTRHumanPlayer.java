package teamresistance.tickettoride.TTR;

import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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
    /** Widjets to control what player Stats display/Scaling*/
    private FrameLayout cpu1FrameLayout;
    private FrameLayout cpu2FrameLayout;
    private FrameLayout cpu3FrameLayout;

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

    private LinearLayout.LayoutParams lp;

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
            TTRGameState myState = (TTRGameState)info;
            int playerNum = ((TTRGameState) info).getNumPlayers();
            for(int i = 0; i < myState.getFaceUpTrainCards().size(); i++){
                if(myState.getFaceUpTrainCards().getCards().get(i).getHighlight()){
                    this.trainCards.get(i).setAlpha(0.5f);
                }
            }
            if(playerNum >= 2) { //2 is the minimum number of players
                lp = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT,1);
                cpu1FrameLayout.setLayoutParams(lp);
                cpu2FrameLayout.setVisibility(View.GONE);
                cpu3FrameLayout.setVisibility(View.GONE);
                this.humanTextView.setText("" + this.allPlayerNames[0]);
                this.humanScoreTextview.setText(""+((TTRGameState) info).getScores()[0]);
                this.humanTrainTokenTextView.setText(""+((TTRGameState) info).getTrainTokens()[0]);
                this.cpu1PlayerTextView.setText(""+this.allPlayerNames[1]);
                this.cpu1TrainTokenTextView.setText(""+((TTRGameState) info).getTrainTokens()[1]);
                this.cpu1ScoreTextview.setText(""+((TTRGameState) info).getScores()[1]);
                this.cpu1DestinationCardTextView.setText(""+((TTRGameState) info).getPlayerDestinationDecks()[1].getCards().size());
                this.cpu1TrainCardTextView.setText(""+((TTRGameState) info).getPlayerTrainDecks()[1].getCards().size());
            }
            if(playerNum >= 3) {
                lp = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT,0.5f);
                cpu1FrameLayout.setLayoutParams(lp);
                cpu2FrameLayout.setLayoutParams(lp);
                cpu2FrameLayout.setVisibility(View.VISIBLE);
                cpu3FrameLayout.setVisibility(View.GONE);
                this.cpu2PlayerTextView.setText(""+this.allPlayerNames[2]);
                this.cpu2ScoreTextview.setText(""+((TTRGameState) info).getScores()[2]);
                this.cpu2DestinationCardTextView.setText(""+((TTRGameState) info).getPlayerDestinationDecks()[2].getCards().size());
                this.cpu2TrainCardTextView.setText(""+((TTRGameState) info).getPlayerTrainDecks()[2].getCards().size());
            }
            if(playerNum >= 4) {
                lp = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT,0.33f);
                cpu1FrameLayout.setLayoutParams(lp);
                cpu2FrameLayout.setLayoutParams(lp);
                cpu3FrameLayout.setLayoutParams(lp);
                cpu2FrameLayout.setVisibility(View.VISIBLE);
                cpu3FrameLayout.setVisibility(View.VISIBLE);
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
        this.cpu1FrameLayout = (FrameLayout)myActivity.findViewById(R.id.CPU1);
        this.cpu2FrameLayout = (FrameLayout)myActivity.findViewById(R.id.CPU2);
        this.cpu3FrameLayout = (FrameLayout)myActivity.findViewById(R.id.CPU3);

        this.trainCard1 = (ImageButton)myActivity.findViewById(R.id.Train1);
        this.trainCard2 = (ImageButton)myActivity.findViewById(R.id.Train2);
        this.trainCard3 = (ImageButton)myActivity.findViewById(R.id.Train3);
        this.trainCard4 = (ImageButton)myActivity.findViewById(R.id.Train4);
        this.trainCard5 = (ImageButton)myActivity.findViewById(R.id.Train5);

        this.trainCard1.setOnClickListener(this);
        this.trainCard2.setOnClickListener(this);
        this.trainCard3.setOnClickListener(this);
        this.trainCard4.setOnClickListener(this);
        this.trainCard5.setOnClickListener(this);

        this.trainCards.add(this.trainCard1);
        this.trainCards.add(this.trainCard2);
        this.trainCards.add(this.trainCard3);
        this.trainCards.add(this.trainCard4);
        this.trainCards.add(this.trainCard5);
    }

    /**
     * The click handler for the buttons.
     */
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.Train1){
            game.sendAction(new DrawUpCardAction(this, 0));
        }
        else if(v.getId() == R.id.Train2){
            game.sendAction(new DrawUpCardAction(this, 1));
        }
        else if(v.getId() == R.id.Train3){
            game.sendAction(new DrawUpCardAction(this, 2));
        }
        else if(v.getId() == R.id.Train4){
            game.sendAction(new DrawUpCardAction(this, 3));
        }
        else if(v.getId() == R.id.Train5){
            game.sendAction(new DrawUpCardAction(this, 4));
        }
    }
    /**
     * The touch handler for the touches.
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
}
