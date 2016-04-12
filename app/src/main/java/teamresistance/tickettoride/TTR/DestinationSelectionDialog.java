package teamresistance.tickettoride.TTR;

import android.app.Activity;
import android.app.Dialog;
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
public class DestinationSelectionDialog extends Dialog implements android.view.View.OnClickListener {
    private Activity c;
    private Dialog d;
    private Button yes, no;
    private ImageButton ticket1, ticket2, ticket3;
    private int min = 0;
    private int selected = 0;
    private TextView text;

    public DestinationSelectionDialog(Activity a, boolean start) {
        super(a);

        this.c = a;
        if(start){
            min = 2;
        } else {
            min = 1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.destination_selection_dialog);

        yes = (Button) findViewById(R.id.btn_select);
        yes.setOnClickListener(this);


        ticket1 = (ImageButton) findViewById(R.id.ticket1);
        ticket2 = (ImageButton) findViewById(R.id.ticket2);
        ticket3 = (ImageButton) findViewById(R.id.ticket3);
        ticket1.setOnClickListener(this);
        ticket2.setOnClickListener(this);
        ticket3.setOnClickListener(this);

        text = (TextView) findViewById(R.id.dsd_text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_select:
                if(selected > min){
                    dismiss();
                    break;
                } else {
                    text.setText("Please select at least the minimum number of ticket cards.");
                }
            case R.id.ticket1:
                selected++;
            case R.id.ticket2:
                selected++;
            case R.id.ticket3:
                selected++;
            default:
                break;
        }
    }
}
