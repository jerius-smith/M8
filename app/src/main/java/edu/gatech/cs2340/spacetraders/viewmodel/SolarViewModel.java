package edu.gatech.cs2340.spacetraders.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.io.FileNotFoundException;
import java.util.Set;

import edu.gatech.cs2340.spacetraders.model.DataStore;
import edu.gatech.cs2340.spacetraders.model.Planet;
import edu.gatech.cs2340.spacetraders.model.Player;
import edu.gatech.cs2340.spacetraders.model.SolarSystem;
import edu.gatech.cs2340.spacetraders.model.Universe;


/**
 * The type Configuration view model.
 */
public class SolarViewModel extends AndroidViewModel {

    private Player player;
    private Universe universe;

    /**
     * Instantiates a new Configuration view model.
     *
     * @param application the application
     */
    public SolarViewModel(@NonNull Application application) {
        super(application);
        try {
            player = DataStore.getCurrentPlayer(getApplication());
            universe = DataStore.getCurrentUniverse(getApplication());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Set<Planet> getPlanetList(String solarName) {
        for (SolarSystem system : universe.getSolarSystems()) {
            if (system.getName().equals(solarName)) {
                return system.getPlanets();
            }
        }
        return null;
    }

    public double getPlayerCredits() {
        return player.getCredits();
    }

    public void travelTo(String planetName) {

    }

    public void savePlayer() {
        try {
            DataStore.playerToJson(getApplication(), player);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}



