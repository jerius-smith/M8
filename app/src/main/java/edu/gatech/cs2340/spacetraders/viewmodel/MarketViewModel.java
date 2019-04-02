package edu.gatech.cs2340.spacetraders.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.io.FileNotFoundException;

import edu.gatech.cs2340.spacetraders.entities.MarketActivityException;
import edu.gatech.cs2340.spacetraders.model.DataStore;
import edu.gatech.cs2340.spacetraders.model.Good;
import edu.gatech.cs2340.spacetraders.model.Inventory;
import edu.gatech.cs2340.spacetraders.model.Market;
import edu.gatech.cs2340.spacetraders.model.Planet;
import edu.gatech.cs2340.spacetraders.model.Player;
import edu.gatech.cs2340.spacetraders.entities.TransactionProcessor;

/**
 * The type Configuration view model.
 */
public class MarketViewModel extends AndroidViewModel {

    private Player player;
    private Market market;

    /**
     * Instantiates a new Configuration view model.
     *
     * @param application the application
     */
    public MarketViewModel(@NonNull Application application) {
        super(application);
        try {
            player = DataStore.getCurrentPlayer(getApplication());
            Planet planet = player.getLocation();
            market = planet.getPlanetsMarket();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Inventory getMarketInventory() {
        return market.getMarketInventory();
    }

    public Inventory getPlayerInventory() {
        return player.getInventory();
    }

    public void sellItem(Good good) {
        try {
            TransactionProcessor.sellItem(player, good, market);
        } catch (MarketActivityException e) {
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void buyItem(Good good) {
        try {
            TransactionProcessor.buyItem(player, good, market);
        } catch (MarketActivityException e) {
            Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public double getPlayerCredits() { return player.getCredits(); }

    public String getPlayerLocation() {
        Planet planet = player.getLocation();
        return planet.getName();
    }

    public void savePlayer() {
        try {
            DataStore.playerToJson(getApplication(), player);
//            DataStore.universeToJson(getApplication(), ModelFacade.getInstance().getUniverse());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
