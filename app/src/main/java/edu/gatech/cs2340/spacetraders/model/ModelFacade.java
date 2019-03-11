package edu.gatech.cs2340.spacetraders.model;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import java.io.FileOutputStream;

import edu.gatech.cs2340.spacetraders.viewmodel.ConfigurationViewModel;
import edu.gatech.cs2340.spacetraders.views.ConfigurationActivity;

/**
 * The type Model facade.
 */
public class ModelFacade {
    private static final ModelFacade ourInstance = new ModelFacade();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ModelFacade getInstance() {
        return ourInstance;
    }

    private Player player;
    private Universe universe;

    private ModelFacade() {
        universe = Universe.getInstance();
    }

    /**
     * Create player.
     *
     * @param name           the name
     * @param prefDifficulty the pref difficulty
     * @param skillPoints    the skill points
     */
    public void createPlayer(String name, Difficulty prefDifficulty, Skills[] skillPoints, Planet location) {
        if (player == null) {
            player = new Player(name, prefDifficulty, skillPoints, location);
        } else {
            player.setName(name);
            player.setPreferredDifficulty(prefDifficulty);
            player.setSkills(skillPoints);
            player.setLocation(location);
        }
//        Log.d("PLAYER", "\n" + player.toString());
//        Log.d("UNIVERSE", "\n" + universe.toString());
    }

    public void setUpdatedPlayer(Player player) {
        this.player = player;
    }


    /**
     * Gets player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    public Universe getUniverse() { return universe; }

}
