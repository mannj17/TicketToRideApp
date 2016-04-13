package teamresistance.tickettoride.TTR;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import teamresistance.tickettoride.R;

/**
 * Created by Jess on 4/12/2016.
 */
public class DestinationSelectionDialog extends  Dialog implements android.view.View.OnClickListener {
    private Activity c;
    private Dialog d;
    private TTRGameState myState;
    private Button selectBtn;
    private ImageButton ticket1, ticket2, ticket3;
    private int min = 0;
    private int selected = 0;
    private TextView text;
    private Card[] destinationCards = new Card[3];
    private boolean complete = false;

    public DestinationSelectionDialog(Activity a, boolean start, Deck cards, TTRGameState myState) {
        super(a);

        this.myState = myState;

        this.c = a;
        if(start){
            min = 2;
        } else {
            min = 1;
        }

        for(int i = 0; i < 3; i++){
            if(cards != null) {
                destinationCards[i] = cards.getCards().get(i);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.destination_selection_dialog);

        selectBtn = (Button) findViewById(R.id.btn_select);
        ticket1 = (ImageButton) findViewById(R.id.ticket1);
        ticket2 = (ImageButton) findViewById(R.id.ticket2);
        ticket3 = (ImageButton) findViewById(R.id.ticket3);
        ticket1.setOnClickListener(this);
        ticket2.setOnClickListener(this);
        ticket3.setOnClickListener(this);
        selectBtn.setOnClickListener(this);

        text = (TextView) findViewById(R.id.dsd_text);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_select){
            if(selected >= min){
                for(int i = 0; i < 3; i++){
                    if(destinationCards[i].getHighlight()){
                        myState.getPlayerDestinationDecks()[0].add(destinationCards[i]);
                    } else {
                        myState.getDestinationDiscard().add(destinationCards[i]);
                    }
                }
                //myState.getPlayerDestinationDecks();
                dismiss();
            } else {
                text.setText("Please select at least the minimum number of ticket cards.");
            }
        }
        if(v.getId() == R.id.ticket1){
            if(destinationCards[0].getHighlight()){
                destinationCards[0].setHighlight(false);
                ticket1.setAlpha(1f);
                selected--;
            } else{
                destinationCards[0].setHighlight(true);
                ticket1.setAlpha(0.5f);
                selected++;
            }
        }
        if(v.getId() == R.id.ticket2){
            if(destinationCards[1].getHighlight()){
                destinationCards[1].setHighlight(false);
                ticket2.setAlpha(1f);
                selected--;
            } else{
                destinationCards[1].setHighlight(true);
                ticket2.setAlpha(0.5f);
                selected++;
            }
        }
        if(v.getId() == R.id.ticket3){
            if(destinationCards[2].getHighlight()){
                destinationCards[2].setHighlight(false);
                ticket3.setAlpha(1f);
                selected--;
            } else{
                destinationCards[2].setHighlight(true);
                ticket3.setAlpha(0.5f);
                selected++;
            }
        }

    }

    public boolean isComplete(){
        return  complete;
    }
}
