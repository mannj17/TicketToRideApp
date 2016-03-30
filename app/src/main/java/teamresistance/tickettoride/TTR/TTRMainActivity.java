package teamresistance.tickettoride.TTR;

import android.app.Activity;
import android.os.Bundle;
import teamresistance.tickettoride.R;

/**
 *  TTRMainActivity sets the Main Activity of the game
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class TTRMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttr_main);
    }
}
