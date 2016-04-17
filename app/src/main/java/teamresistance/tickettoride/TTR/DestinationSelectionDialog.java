package teamresistance.tickettoride.TTR;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import teamresistance.tickettoride.Game.Game;
import teamresistance.tickettoride.R;
import teamresistance.tickettoride.TTR.Actions.ConfirmSelectionAction;

/**
 *
 * Class that inflates view into dialog for custom handling user choice of which destination cards
 * to keep.
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version April 2016
 */
public class DestinationSelectionDialog extends  Dialog implements android.view.View.OnClickListener {
    /** Class Instance Variables */
    private TTRGameState myState; //TTRGameState
    private Button selectBtn; //button for user to select their choices
    private ImageButton ticket1, ticket2, ticket3; //imagebuttons for tickets user can click
    private TextView routes1, routes2, routes3; //text views represeing routes listed on tickets
    private int min; //int representing minimum number of cards user must select
    private int selected; //boolean set when select is clicked
    private TextView text; //textview to display any errors/messages to user
    private Card[] destinationCards = new Card[3]; //temp cards representing user's choices
    private Game game; //the game used to send action
    private TTRHumanPlayer player; //player used in sending action

    /**
     * Contructor for dialog
     * @param me
     * @param start
     * @param cards
     * @param game
     */
    public DestinationSelectionDialog(TTRHumanPlayer me, boolean start, Deck cards, Game game) {
        super(me.myActivity);
        min = 0;
        selected = 0;
        this.player = me;
        this.game = game;
        this.myState = me.myState;
        if(start){
            min = 2;
        } else {
            min = 1;
        }
        //deep copy of cards
        for(int i = 0; i < 3; i++){
            if(cards != null) {
                destinationCards[i] = cards.getCards().get(i);
                destinationCards[i].setHighlight(false);
            }
        }
    }

    /**
     * Method called when dialog created, used to initialize all widgets
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.destination_selection_dialog);
        //set all buttons
        selectBtn = (Button) findViewById(R.id.btn_select);
        ticket1 = (ImageButton) findViewById(R.id.ticket1);
        ticket2 = (ImageButton) findViewById(R.id.ticket2);
        ticket3 = (ImageButton) findViewById(R.id.ticket3);
        //set all textviews
        routes1 = (TextView) findViewById(R.id.ticket1_destinations);
        routes2 = (TextView) findViewById(R.id.ticket2_destinations);
        routes3 = (TextView) findViewById(R.id.ticket3_destinations);
        text = (TextView) findViewById(R.id.dsd_text);
        //display text representing destination tickets
        DestinationCards tempCard1 = (DestinationCards)destinationCards[0];
        DestinationCards tempCard2 = (DestinationCards)destinationCards[1];
        DestinationCards tempCard3 = (DestinationCards)destinationCards[2];
        routes1.setText("" + tempCard1.getCity1() + " to " + tempCard1.getCity2());
        routes2.setText("" + tempCard2.getCity1() + " to " + tempCard2.getCity2());
        routes3.setText("" + tempCard3.getCity1() + " to " + tempCard3.getCity2());
        //set listeners
        ticket1.setOnClickListener(this);
        ticket2.setOnClickListener(this);
        ticket3.setOnClickListener(this);
        selectBtn.setOnClickListener(this);
    }

    /**
     * Method for handling user clicks inside the dialog box
     * @param v
     */
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_select){
            if(selected >= min){
                //confirm minimum number of cards selected before confrim
                Card[] tempCards = new Card[selected];
                int count = 0;
                for(int i = 0; i < 3; i++){
                    if(destinationCards[i].getHighlight()){
                        tempCards[count] = destinationCards[i];
                        count++;
                    }
                }
                destinationCards[0].setHighlight(false);
                destinationCards[1].setHighlight(false);
                destinationCards[2].setHighlight(false);
                Deck sendDeck = new Deck("deck with added cards", tempCards);
                Deck removeDeck = new Deck("Cards to be removed", destinationCards);
                game.sendAction(new ConfirmSelectionAction(player, sendDeck, removeDeck));
                dismiss();
            } else { //display error
                text.setText("Please select at least the minimum number of ticket cards.");
            }
        }
        /**  Control for highlighting (aka selecting) the cards */
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
