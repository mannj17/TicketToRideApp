package teamresistance.tickettoride.TTR;


import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

import teamresistance.tickettoride.Game.Game;
import teamresistance.tickettoride.R;

/**
 *
 * Class that inflates view into dialog for custom handling user view of which destination cards.
 *
 * RESOURCES:
 * 4/11/16
 * http://stackoverflow.com/questions/13341560/how-to-create-a-custom-dialog-box-in-android
 * 4/17/16
 * http://stackoverflow.com/questions/9829453/android-4-0-dialog-gets-canceled-when-touched-outside-of-dialog-window
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version April 2016
 */
public class DestinationViewDialog extends Dialog implements android.view.View.OnClickListener, Serializable {
    private static final long serialVersionUID = 388255575192016L;

    private Deck destinationCards;
    private Game game; //the game used to send action
    private TTRHumanPlayer player; //player used in sending action
    private TTRGameState myState; //TTRGameState
    private Button closeBtn;
    private ImageView ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9;
    private ImageView[] tickets = {ticket1,ticket2,ticket3,ticket4,ticket5,ticket6,ticket7,ticket8,ticket9};
    private TextView destinationDeckTextView;
    /**
     * Contructor for dialog
     * @param me
     * @param cards
     * @param game
     */
    public DestinationViewDialog(TTRHumanPlayer me, Deck cards, Game game) {
        super(me.myActivity);
        this.player = me;
        this.game = game;
        this.myState = me.myState;

        destinationCards = new Deck(cards);
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
        setContentView(R.layout.destination_ticket_view_dialog);
        //set all buttons
        closeBtn = (Button) findViewById(R.id.btn_close);
        closeBtn.setOnClickListener(this);

        tickets[0] = (ImageView)findViewById(R.id.)

        //TEXT
        destinationDeckTextView = (TextView) findViewById(R.id.destinationCardDeck);
        destinationDeckTextView.setWidth(500);
        for(int i = 0; i < destinationCards.getCards().size(); i++){
            destinationDeckTextView.setText(destinationDeckTextView.getText() + " \n" + ((DestinationCards)destinationCards.getCards().get(i)).getCity1() + " to "
                    + ((DestinationCards)destinationCards.getCards().get(i)).getCity2()
                    + " score: " + ((DestinationCards)destinationCards.getCards().get(i)).getScore());
        }

    }

    /**
     * Method for handling user clicks inside the dialog box
     * @param v
     */
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_close) {
            dismiss();
        }
    }
}
