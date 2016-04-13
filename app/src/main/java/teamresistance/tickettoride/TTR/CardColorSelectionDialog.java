package teamresistance.tickettoride.TTR;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import teamresistance.tickettoride.R;

/**
 *
 * Created by Parker on 4/12/2016.
 */
public class CardColorSelectionDialog extends Dialog implements android.view.View.OnClickListener{
    private Activity myActivity;
    private Dialog dialog;
    private TTRGameState myState;
    private Button selectBtn;
    private ImageButton train1, train2, train3, train4, train5, train6, train7, train8;
    private ImageButton[] buttons;
    private TextView text;
    private Deck trainCards;
    private boolean complete = false;
    private final String[] trainColors = {"Red", "Orange", "Yellow", "Green",
            "Blue", "Pink", "White", "Black"};
    private boolean[] usable = new boolean[trainColors.length];
    private boolean[] highlighted = new boolean[trainColors.length];
    private boolean selected = false;

    public CardColorSelectionDialog(Activity a, Deck cards, TTRGameState myState, Track track) {
        super(a);
        this.myState = myState;
        this.myActivity = a;
        this.trainCards = cards;
        int min = track.getTrainTrackNum();
        int count = 0;
        for(int i = 0; i < trainColors.length; i++){
            for(int j = 0; j < trainCards.size(); j++){
                if(trainCards.getCards().get(j).toString().equals(trainColors[i])){
                    count++;
                }
                if(count >= min){
                    this.usable[i] = true;
                }
                else{
                    this.usable[i] = false;
                }
            }
            this.highlighted[i] = false;
            count = 0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.card_selection_dialog);

        selectBtn = (Button) findViewById(R.id.btn_select);
        train1 = (ImageButton) findViewById(R.id.train1);
        train2 = (ImageButton) findViewById(R.id.train2);
        train3 = (ImageButton) findViewById(R.id.train3);
        train4 = (ImageButton) findViewById(R.id.train4);
        train5 = (ImageButton) findViewById(R.id.train5);
        train6 = (ImageButton) findViewById(R.id.train6);
        train7 = (ImageButton) findViewById(R.id.train7);
        train8 = (ImageButton) findViewById(R.id.train8);
        train1.setOnClickListener(this);
        train2.setOnClickListener(this);
        train3.setOnClickListener(this);
        train4.setOnClickListener(this);
        train5.setOnClickListener(this);
        train6.setOnClickListener(this);
        train7.setOnClickListener(this);
        train8.setOnClickListener(this);
        if(this.usable[0]){
            train1.setClickable(true);
        }
        else{
            train1.setClickable(false);
            train1.setAlpha(0.5f);
        }
        if(this.usable[1]){
            train2.setClickable(true);
        }
        else{
            train2.setClickable(false);
            train2.setAlpha(0.5f);
        }
        if(this.usable[2]){
            train3.setClickable(true);
        }
        else{
            train3.setClickable(false);
            train3.setAlpha(0.5f);
        }
        if(this.usable[3]){
            train4.setClickable(true);
        }
        else{
            train4.setClickable(false);
            train4.setAlpha(0.5f);
        }
        if(this.usable[4]){
            train5.setClickable(true);
        }
        else{
            train5.setClickable(false);
            train5.setAlpha(0.5f);
        }
        if(this.usable[5]){
            train6.setClickable(true);
        }
        else{
            train6.setClickable(false);
            train6.setAlpha(0.5f);
        }
        if(this.usable[6]){
            train7.setClickable(true);
        }
        else{
            train7.setClickable(false);
            train7.setAlpha(0.5f);
        }
        if(this.usable[7]){
            train8.setClickable(true);
        }
        else{
            train8.setClickable(false);
            train8.setAlpha(0.5f);
        }
        /*
        buttons = new ImageButton[]{train1, train2, train3, train4, train5, train6,
                train7, train8};
        for(int i = 0; i < usable.length; i++){
            if(usable[i]){
                buttons[i].setClickable(true);
            }
            else{
                buttons[i].setClickable(false);
            }
        }*/
        selectBtn.setOnClickListener(this);

        text = (TextView) findViewById(R.id.ccsd_text);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_select){
            if(selected){
                int position = -1;
                for(int i = 0; i < trainColors.length; i++){
                    if(highlighted[i]){
                        position = i;
                    }
                }
                myState.setSelectedCardColor(trainColors[position]);
                dismiss();
            } else {
                text.setText("Please select at least the minimum number of ticket cards.");
            }
        }
        if(v.getId() == R.id.train1){
            if(highlighted[0]){
                highlighted[0] = false;
                train1.setAlpha(1f);
                selected = false;
            } else if(!highlighted[0] && !selected){
                highlighted[0] = true;
                train1.setAlpha(0.5f);
                selected = true;
            }
        }
        else if(v.getId() == R.id.train2){
            if(highlighted[1]){
                highlighted[1] = false;
                train1.setAlpha(1f);
                selected = false;
            } else if(!highlighted[1] && !selected){
                highlighted[1] = true;
                train1.setAlpha(0.5f);
                selected = true;
            }
        }
        else if(v.getId() == R.id.train3){
            if(highlighted[2]){
                highlighted[2] = false;
                train1.setAlpha(1f);
                selected = false;
            } else if(!highlighted[2] && !selected){
                highlighted[2] = true;
                train1.setAlpha(0.5f);
                selected = true;
            }
        }
        else if(v.getId() == R.id.train4){
            if(highlighted[3]){
                highlighted[3] = false;
                train1.setAlpha(1f);
                selected = false;
            } else if(!highlighted[3] && !selected){
                highlighted[3] = true;
                train1.setAlpha(0.5f);
                selected = true;
            }
        }
        else if(v.getId() == R.id.train5){
            if(highlighted[4]){
                highlighted[4] = false;
                train1.setAlpha(1f);
                selected = false;
            } else if(!highlighted[4] && !selected){
                highlighted[4] = true;
                train1.setAlpha(0.5f);
                selected = true;
            }
        }
        else if(v.getId() == R.id.train6){
            if(highlighted[5]){
                highlighted[5] = false;
                train1.setAlpha(1f);
                selected = false;
            } else if(!highlighted[5] && !selected){
                highlighted[5] = true;
                train1.setAlpha(0.5f);
                selected = true;
            }
        }
        else if(v.getId() == R.id.train7){
            if(highlighted[6]){
                highlighted[6] = false;
                train1.setAlpha(1f);
                selected = false;
            } else if(!highlighted[6] && !selected){
                highlighted[6] = true;
                train1.setAlpha(0.5f);
                selected = true;
            }
        }
        else if(v.getId() == R.id.train8){
            if(highlighted[7]){
                highlighted[7] = false;
                train1.setAlpha(1f);
                selected = false;
            } else if(!highlighted[7] && !selected){
                highlighted[7] = true;
                train1.setAlpha(0.5f);
                selected = true;
            }
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
