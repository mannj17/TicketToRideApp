package teamresistance.tickettoride.TTR;

import android.app.Activity;
import android.os.Bundle;

import teamresistance.tickettoride.Game.GameMainActivity;
import teamresistance.tickettoride.Game.GamePlayer;
import teamresistance.tickettoride.Game.LocalGame;
import teamresistance.tickettoride.Game.config.GameConfig;
import teamresistance.tickettoride.Game.config.GamePlayerType;
import teamresistance.tickettoride.R;
import java.util.ArrayList;
/**
 *  TTRMainActivity sets the Main Activity of the game
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class TTRMainActivity extends GameMainActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ttr_main);
//    }
    public static final int PORT_NUMBER = 4567;

    /**
     * ticket to ride game can have two, three, four, or five players
     */
    @Override
    public GameConfig createDefaultConfig() {
        // Define the allowed player types
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();

        playerTypes.add(new GamePlayerType("Local Human Player") {
            public GamePlayer createPlayer(String name) {
                return new TTRHumanPlayer(name);
            }
        });

        // dumb computer player
        playerTypes.add(new GamePlayerType("Computer Player (dumb)") {
            public GamePlayer createPlayer(String name) {
                return new TTRComputerPlayer(name, false);
            }
        });

        // smarter computer player
        playerTypes.add(new GamePlayerType("Computer Player (smart)") {
            public GamePlayer createPlayer(String name) {
                return new TTRComputerPlayer(name, true);
            }
        });

        // Create a game configuration class for TTR
        GameConfig defaultConfig = new GameConfig(playerTypes, 2,5, "Ticket To Ride", PORT_NUMBER);

        // Add the default players
        defaultConfig.addPlayer("Human", 0);
        defaultConfig.addPlayer("Computer", 1); // dumb computer player

        // Set the initial information for the remote player
        defaultConfig.setRemoteData("Remote Player", "", 0);

        //done!
        return defaultConfig;

    }//createDefaultConfig

    @Override
    public LocalGame createLocalGame() {
        return new TTRLocalGame();
    }


}
