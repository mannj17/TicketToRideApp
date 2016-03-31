package teamresistance.tickettoride.TTR;

import android.app.Activity;
import android.os.Bundle;

import teamresistance.tickettoride.Game.GamePlayer;
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
public class TTRMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttr_main);
    }
    public static final int PORT_NUMBER = 5213;

    /**
     * a tic-tac-toe game is for two players. The default is human vs. computer
     */
    @Override
    public GameConfig createDefaultConfig() {

        // Define the allowed player types
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();

        // yellow-on-blue GUI
        playerTypes.add(new GamePlayerType("Local Human Player (blue-yellow)") {
            public GamePlayer createPlayer(String name) {
                return new TTRHumanPlayer(name);
            }
        });

        // red-on-yellow GUI
        playerTypes.add(new GamePlayerType("Local Human Player (yellow-red)") {
            public GamePlayer createPlayer(String name) {
                return new TTRHumanPlayer(name);
            }
        });

        // game of 33
        playerTypes.add(new GamePlayerType("Local Human Player (game of 33)") {
            public GamePlayer createPlayer(String name) {
                return new TTRHumanPlayer(name);
            }
        });

        // dumb computer player
        playerTypes.add(new GamePlayerType("Computer Player (dumb)") {
            public GamePlayer createPlayer(String name) {
                return new TTRComputerPlayer(name);
            }
        });

        // smarter computer player
        playerTypes.add(new GamePlayerType("Computer Player (smart)") {
            public GamePlayer createPlayer(String name) {
                return new TTRComputerPlayer(name);
            }
        });

        // Create a game configuration class for Tic-tac-toe
        GameConfig defaultConfig = new GameConfig(playerTypes, 2,2, "Tic-Tac-Toe", PORT_NUMBER);

        // Add the default players
        defaultConfig.addPlayer("Human", 0); // yellow-on-blue GUI
        defaultConfig.addPlayer("Computer", 3); // dumb computer player

        // Set the initial information for the remote player
        defaultConfig.setRemoteData("Remote Player", "", 1); // red-on-yellow GUI

        //done!
        return defaultConfig;

    }//createDefaultConfig


}
