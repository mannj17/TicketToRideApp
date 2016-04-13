package teamresistance.tickettoride.TTR;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import teamresistance.tickettoride.Game.Game;
import teamresistance.tickettoride.R;
import teamresistance.tickettoride.TTR.Actions.ConfirmSelectionAction;

/**
 *
 * Created by Parker on 4/12/2016.
 */
public class LocomotiveSelectionDialog extends Dialog implements View.OnClickListener{
    private Activity myActivity;
    private Dialog dialog;
    private TTRGameState myState;
    private Button selectBtn;
    private ImageButton train1, train2, train3, train4, train5, train6, train7, train8;
    //private ImageButton[] buttons;
    private RadioButton noLoc, oneLoc, twoLoc, threeLoc, fourLoc, fiveLoc, sixLoc;
    private RadioButton[] locomotives;
    private TextView text;
    private Deck trainCards;
    private boolean complete = false;
    private final String[] trainColors = {"Red", "Orange", "Yellow", "Green",
            "Blue", "Pink", "White", "Black"};
    private boolean[] usable = new boolean[trainColors.length];
    private boolean[] highlighted = new boolean[trainColors.length];
    private boolean selected = false;
    private int numRainbows = 0;
    private int useRainbows = 0;
    private Game game;
    private TTRHumanPlayer player;
    private Track track;

    public LocomotiveSelectionDialog(Activity a, Deck cards, TTRGameState myState, Track track, Game game, TTRHumanPlayer player) {
        super(player.myActivity);
        this.game = game;
        this.player = player;
        this.track = track;
        this.myState = myState;
        this.myActivity = a;
        this.trainCards = cards;
        int min = track.getTrainTrackNum();
        int count = 0;
        selected = false;

        for(int i = 0; i < trainCards.size(); i++){
            if(trainCards.getCards().get(i).toString().equals("Rainbow")){
                numRainbows++;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.locomotive_selection);

        selectBtn = (Button) findViewById(R.id.btn_select);
        selectBtn.setOnClickListener(this);

        noLoc = (RadioButton)findViewById(R.id.None_Rainbow);
        oneLoc = (RadioButton)findViewById(R.id.One_Rainbow);
        twoLoc = (RadioButton)findViewById(R.id.Two_Rainbow);
        threeLoc = (RadioButton)findViewById(R.id.Three_Rainbow);
        fourLoc = (RadioButton)findViewById(R.id.Four_Rainbow);
        fiveLoc = (RadioButton)findViewById(R.id.Five_Rainbow);
        sixLoc = (RadioButton)findViewById(R.id.Six_Rainbow);

        locomotives = new RadioButton[]{noLoc, oneLoc, twoLoc, threeLoc, fourLoc, fiveLoc, sixLoc};

        noLoc.setOnClickListener(this);
        oneLoc.setOnClickListener(this);
        twoLoc.setOnClickListener(this);
        threeLoc.setOnClickListener(this);
        fourLoc.setOnClickListener(this);
        fiveLoc.setOnClickListener(this);
        sixLoc.setOnClickListener(this);

        noLoc.setChecked(true);

        if(numRainbows != 0){
            for(int i = 1; i <= numRainbows; i++){
                locomotives[i].setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_select){
            game.sendAction(new ConfirmSelectionAction(player, useRainbows));
            dismiss();
        }
        else if(v.getId() == R.id.None_Rainbow){
            noLoc.setChecked(true);
            useRainbows = 0;
        }
        else if(v.getId() == R.id.One_Rainbow){
            oneLoc.setChecked(true);
            useRainbows = 1;
        }
        else if(v.getId() == R.id.Two_Rainbow){
            twoLoc.setChecked(true);
            useRainbows = 2;
        }
        else if(v.getId() == R.id.Three_Rainbow){
            threeLoc.setChecked(true);
            useRainbows = 3;
        }
        else if(v.getId() == R.id.Four_Rainbow){
            fourLoc.setChecked(true);
            useRainbows = 4;
        }
        else if(v.getId() == R.id.Five_Rainbow){
            fiveLoc.setChecked(true);
            useRainbows = 5;
        }
        else if(v.getId() == R.id.Six_Rainbow){
            sixLoc.setChecked(true);
            useRainbows = 6;
        }

    }

    public int contains(String trainColor){
        Deck tempDeck = this.trainCards;
        int count = 0;
        for(int i = 0; i < tempDeck.size();i++){
            if(tempDeck.getCards().get(i).toString().equals(trainColor)){
                count++;
            }
        }
        return count;
    }
}
