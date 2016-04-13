package teamresistance.tickettoride.TTR;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import teamresistance.tickettoride.Game.Game;
import teamresistance.tickettoride.Game.GameHumanPlayer;
import teamresistance.tickettoride.R;
import teamresistance.tickettoride.TTR.Actions.ConfirmSelectionAction;

/**
 * Created by Jess on 4/12/2016.
 */
public class DestinationSelectionDialog extends  Dialog implements android.view.View.OnClickListener {
    private Activity c;
    private Dialog d;
    private TTRGameState myState;
    private Button selectBtn;
    private ImageButton ticket1, ticket2, ticket3;
    private TextView routes1, routes2, routes3;
    private int min;
    private int selected;
    private TextView text;
    private Card[] destinationCards = new Card[3];
    private Game game;
    private TTRHumanPlayer player;

    public DestinationSelectionDialog(TTRHumanPlayer me, boolean start, Deck cards, Game game) {
        super(me.myActivity);
        min = 0;
        selected = 0;
        this.player = me;
        this.game = game;
        this.myState = me.myState;
        this.c = me.myActivity;
        if(start){
            min = 2;
        } else {
            min = 1;
        }

        for(int i = 0; i < 3; i++){
            if(cards != null) {
                destinationCards[i] = cards.getCards().get(i);
                destinationCards[i].setHighlight(false);
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
        routes1 = (TextView) findViewById(R.id.ticket1_destinations);
        routes2 = (TextView) findViewById(R.id.ticket2_destinations);
        routes3 = (TextView) findViewById(R.id.ticket3_destinations);
        DestinationCards tempCard1 = (DestinationCards)destinationCards[0];
        DestinationCards tempCard2 = (DestinationCards)destinationCards[1];
        DestinationCards tempCard3 = (DestinationCards)destinationCards[2];
        routes1.setText("" + tempCard1.getCity1() + " to " + tempCard1.getCity2());
        routes2.setText("" + tempCard2.getCity1() + " to " + tempCard2.getCity2());
        routes3.setText("" + tempCard3.getCity1() + " to " + tempCard3.getCity2());
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
                Card[] tempCards = new Card[selected];
                int count = 0;
                for(int i = 0; i < 3; i++){
                    if(destinationCards[i].getHighlight()){
                        tempCards[count] = destinationCards[i];
                        //myState.getPlayerDestinationDecks()[0].add(destinationCards[i]);
                        count++;
                    } else {
                        myState.getDestinationDiscard().add(destinationCards[i]);
                    }
                }
                destinationCards[0].setHighlight(false);
                destinationCards[1].setHighlight(false);
                destinationCards[2].setHighlight(false);
                Deck tempDeck = new Deck("temporary", tempCards);
                game.sendAction(new ConfirmSelectionAction(player, tempDeck));
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
}
