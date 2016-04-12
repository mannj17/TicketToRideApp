package teamresistance.tickettoride.TTR;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
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
    private TTRGameState myState;
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
    /** TextViews for the plaer deck card colors */
    private TextView redColorCount;
    private TextView orangeColorCount;
    private TextView yellowColorCount;
    private TextView greenColorCount;
    private TextView blueColorCount;
    private TextView pinkColorCount;
    private TextView blackColorCount;
    private TextView whiteColorCount;
    private TextView rainbowColorCount;
    /** Widjets to control what player Stats display/Scaling*/
    private FrameLayout cpu1FrameLayout;
    private FrameLayout cpu2FrameLayout;
    private FrameLayout cpu3FrameLayout;

    /*
    Variables for all of the buttons on the right side of the screen,
    the place holder variables to eliminate hard coding, and the
    ArrayList for all of the ImageButtons.
     */
    private ImageButton[] faceUpTrainCards = new ImageButton[5];

    private ImageButton clickTrain;
    private ImageButton clickDestination;
    private boolean[] trainPressed;

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
            myState = (TTRGameState)info;
            myBoard.setTracks(myState.getTracks());
            trainDeck = myState.getPlayerTrainDecks()[playerNum];
            int playerNum = ((TTRGameState) info).getNumPlayers();
            for(int i = 0; i < myState.getFaceUpTrainCards().size(); i++){
                if(myState.getFaceUpTrainCards().getCards().get(i).getHighlight()){
                    this.faceUpTrainCards[i].setAlpha(0.5f);
                }
                else{this.faceUpTrainCards[i].setAlpha(1.0f);}
            }
            if(myState.getFaceDownTrainCards().getHighlight()){this.clickTrain.setAlpha(0.5f);}
            else{this.clickTrain.setAlpha(1.0f);}

            if(myState.getDestinationCards().getHighlight()){this.clickDestination.setAlpha(0.5f);}
            else{this.clickDestination.setAlpha(1.0f);}

            this.trainCheck.setChecked(myState.getTrackModeSelected());
            this.cardCheck.setChecked(myState.getCardModeSelected());

            boolean val = myState.getTrackModeSelected();

            int size = myBoard.getTracksLength();
            for (int i = 0; i < size; i++) {
                //if(canChoose(myBoard.getTracks()[i])) {
                    myBoard.getTracks()[i].setHighlight(val);
                //}
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
                this.cpu2TrainCardTextView.setText("" + ((TTRGameState) info).getPlayerTrainDecks()[2].getCards().size());
            }
            if(playerNum >= 4) {
                lp = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT,0.33f);
                cpu1FrameLayout.setLayoutParams(lp);
                cpu2FrameLayout.setLayoutParams(lp);
                cpu3FrameLayout.setLayoutParams(lp);
                cpu2FrameLayout.setVisibility(View.VISIBLE);
                cpu3FrameLayout.setVisibility(View.VISIBLE);
                this.cpu3PlayerTextView.setText(""+this.allPlayerNames[3]);
                this.cpu3ScoreTextview.setText("" + ((TTRGameState) info).getScores()[3]);
                this.cpu3DestinationCardTextView.setText(""+((TTRGameState) info).getPlayerDestinationDecks()[3].getCards().size());
                this.cpu3TrainCardTextView.setText(""+((TTRGameState) info).getPlayerTrainDecks()[3].getCards().size());
            }
            for( int i = 0; i < 5; i++) {
                if ((myState.getFaceUpTrainCards().getCards().get(i)).toString() == "Black") {
                    faceUpTrainCards[i].setImageResource(R.drawable.black_train);
                } else if (((TrainCards) myState.getFaceUpTrainCards().getCards().get(i)).toString() == "Pink") {
                    faceUpTrainCards[i].setImageResource(R.drawable.pink_train);
                }else if (((TrainCards) myState.getFaceUpTrainCards().getCards().get(i)).toString() == "Blue") {
                    this.faceUpTrainCards[i].setImageResource(R.drawable.blue_train);
                }else if (((TrainCards) myState.getFaceUpTrainCards().getCards().get(i)).toString() == "Green") {
                    this.faceUpTrainCards[i].setImageResource(R.drawable.green_train);
                }else if (((TrainCards) myState.getFaceUpTrainCards().getCards().get(i)).toString() == "Orange") {
                    this.faceUpTrainCards[i].setImageResource(R.drawable.orange_train);
                }else if (((TrainCards) myState.getFaceUpTrainCards().getCards().get(i)).toString() == "Red") {
                    this.faceUpTrainCards[i].setImageResource(R.drawable.red_train);
                }else if (((TrainCards) myState.getFaceUpTrainCards().getCards().get(i)).toString() == "White") {
                    this.faceUpTrainCards[i].setImageResource(R.drawable.white_train);
                }else if (((TrainCards) myState.getFaceUpTrainCards().getCards().get(i)).toString() == "Yellow") {
                    this.faceUpTrainCards[i].setImageResource(R.drawable.yellow_train);
                } else {
                    this.faceUpTrainCards[i].setImageResource(R.drawable.rainbow_train);
                }
            }

            blackColorCount.setText("" + myState.getTrainColorCount("Black", 0));
            whiteColorCount.setText("" + myState.getTrainColorCount("White", 0));
            blueColorCount.setText("" + myState.getTrainColorCount("Blue", 0));
            redColorCount.setText("" + myState.getTrainColorCount("Red", 0));
            orangeColorCount.setText("" + myState.getTrainColorCount("Orange", 0));
            yellowColorCount.setText("" + myState.getTrainColorCount("Yellow", 0));
            pinkColorCount.setText("" + myState.getTrainColorCount("Pink", 0));
            greenColorCount.setText("" + myState.getTrainColorCount("Green", 0));
            rainbowColorCount.setText("" + myState.getTrainColorCount("Rainbow", 0));


            myBoard.postInvalidate();
        }
    }

    public boolean canChoose(Track track){
        if(track.getCovered()){return false;}
        String tempColor = track.getTrackColor();
        int trackLength = track.getTrainTrackNum();
        Deck tempDeck = this.trainDeck;
        int numberOfCards = 0;
        if(!tempColor.equals("Gray")) {
            for (int i = 0; i < tempDeck.size(); i++) {
                if (tempDeck.getCards().get(i).toString().equals(tempColor) ||
                        tempDeck.getCards().get(i).toString().equals("Rainbow")) {
                    numberOfCards++;
                }
            }
        }
        else if(tempColor.equals("Gray")){
            return chooseGray(track);
        }
        if(numberOfCards >= trackLength){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean chooseGray(Track track){
        int rainbowCount = myState.getTrainColorCount("Rainbow", 0);
        if((myState.getTrainColorCount("Black", 0)+ rainbowCount) >= track.getTrainTrackNum()){
            return true;
        }
        else if((myState.getTrainColorCount("White", 0)+ rainbowCount) >= track.getTrainTrackNum()){
            return true;
        }
        else if((myState.getTrainColorCount("Blue", 0)+ rainbowCount) >= track.getTrainTrackNum()){
            return true;
        }
        else if((myState.getTrainColorCount("Red", 0)+ rainbowCount) >= track.getTrainTrackNum()){
            return true;
        }
        else if((myState.getTrainColorCount("Orange", 0)+ rainbowCount) >= track.getTrainTrackNum()){
            return true;
        }
        else if((myState.getTrainColorCount("Yellow", 0)+ rainbowCount) >= track.getTrainTrackNum()){
            return true;
        }
        else if((myState.getTrainColorCount("Pink", 0)+ rainbowCount) >= track.getTrainTrackNum()){
            return true;
        }
        else if((myState.getTrainColorCount("Green", 0)+ rainbowCount) >= track.getTrainTrackNum()){
            return true;
        }
        else{
            return false;
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
        this.myBoard = (TTRSurfaceView)mainActivity.findViewById(R.id.GameBoard);

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
        this.cpu1TrainCardTextView = (TextView)myActivity.findViewById(R.id.CPU1TrainCardCount);
        this.cpu2TrainCardTextView  = (TextView)myActivity.findViewById(R.id.CPU2TrainCardCount);
        this.cpu3TrainCardTextView  = (TextView)myActivity.findViewById(R.id.CPU3TrainCardCount);
        this.cpu1FrameLayout = (FrameLayout)myActivity.findViewById(R.id.CPU1);
        this.cpu2FrameLayout = (FrameLayout)myActivity.findViewById(R.id.CPU2);
        this.cpu3FrameLayout = (FrameLayout)myActivity.findViewById(R.id.CPU3);

        this.redColorCount = (TextView)myActivity.findViewById(R.id.redCardCount);
        this.orangeColorCount = (TextView)myActivity.findViewById(R.id.orangeCardCount);
        this.yellowColorCount = (TextView)myActivity.findViewById(R.id.yellowCardCount);
        this.greenColorCount = (TextView)myActivity.findViewById(R.id.greenCardCount);
        this.blueColorCount = (TextView)myActivity.findViewById(R.id.blueCardCount);
        this.greenColorCount = (TextView)myActivity.findViewById(R.id.greenCardCount);
        this.pinkColorCount = (TextView)myActivity.findViewById(R.id.pinkCardCount);
        this.blackColorCount = (TextView)myActivity.findViewById(R.id.blackCardCount);
        this.whiteColorCount = (TextView)myActivity.findViewById(R.id.whiteCardCount);
        this.rainbowColorCount = (TextView)myActivity.findViewById(R.id.locomotiveCardCount);

        this.confirmSelection = (Button)myActivity.findViewById(R.id.confirmSelection);

        faceUpTrainCards[0] = (ImageButton)myActivity.findViewById(R.id.Train1);
        faceUpTrainCards[1]  = (ImageButton)myActivity.findViewById(R.id.Train2);
        faceUpTrainCards[2]  = (ImageButton)myActivity.findViewById(R.id.Train3);
        faceUpTrainCards[3] = (ImageButton)myActivity.findViewById(R.id.Train4);
        faceUpTrainCards[4]  = (ImageButton)myActivity.findViewById(R.id.Train5);

        this.clickTrain = (ImageButton)myActivity.findViewById(R.id.DrawTrainStack);
        this.clickDestination = (ImageButton)myActivity.findViewById(R.id.DrawTicketStack);
        this.cardCheck = (CheckBox)myActivity.findViewById(R.id.drawCardCheckBox);
        this.trainCheck = (CheckBox)myActivity.findViewById(R.id.drawTrainCheckBox);

        this.confirmSelection.setOnClickListener(this);
        this.clickTrain.setOnClickListener(this);

        faceUpTrainCards[0].setOnClickListener(this);
        faceUpTrainCards[1].setOnClickListener(this);
        faceUpTrainCards[2].setOnClickListener(this);
        faceUpTrainCards[3].setOnClickListener(this);
        faceUpTrainCards[4].setOnClickListener(this);

        this.clickDestination.setOnClickListener(this);
        this.cardCheck.setOnClickListener(this);
        this.trainCheck.setOnClickListener(this);
        this.myBoard.setOnTouchListener(this);
    }

    /**
     * The click handler for the buttons.
     */
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.confirmSelection){
            if(myState.getPlayerID() == 0){
                final TTRHumanPlayer me = this;
                //Popup to display
                AlertDialog.Builder builder1 = new AlertDialog.Builder(myActivity);
                builder1.setTitle("Are you sure you want to make this move?");
                builder1.setMessage("Click to confirm");
                builder1.setCancelable(false);
                builder1.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                builder1.setPositiveButton("Okay",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                game.sendAction(new ConfirmSelectionAction(me));
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        }
        else if(v.getId() == R.id.Train1){
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
        else if(v.getId() == R.id.DrawTrainStack){
            game.sendAction(new DrawDownCardAction(this));
        }
        else if(v.getId() == R.id.DrawTicketStack){
            DestinationSelectionDialog dsd = new DestinationSelectionDialog(myActivity, false);
            dsd.show();
            //game.sendAction(new DrawDestinationCardAction(this));
        }
        else if(v.getId() == R.id.drawCardCheckBox){
            if(myState.getTrackModeSelected() && !myState.getCardModeSelected()){
                game.sendAction(new ChangeModeAction(this));
            }
            else{
                this.cardCheck.setChecked(true);
            }
        }
        else if(v.getId() == R.id.drawTrainCheckBox){
            if(myState.getCardModeSelected() && !myState.getTrackModeSelected()){
                game.sendAction(new ChangeModeAction(this));
            }
            else{
                this.trainCheck.setChecked(true);
            }
        }
    }
    /**
     * The touch handler for the touches.
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int x = (int)event.getRawX();
        int y = (int)event.getRawY();
        if(v.getId() == R.id.GameBoard && event.getAction() == MotionEvent.ACTION_DOWN){
            int index = -1;
            for(int i = 0; i < myBoard.getTracks().length; i++){
                if(myBoard.getTracks()[i].isTouched(x, y-191)){
                    index = i;
                }
            }
            if (index != -1) {
                game.sendAction(new TrackPlaceAction(this,
                        myState.getTracks()[index].getTrackColor(), index));
            }
            else{
                return false;
            }
        }
        return true;
    }
}
