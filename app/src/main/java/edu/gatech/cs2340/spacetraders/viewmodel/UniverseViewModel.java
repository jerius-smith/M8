package edu.gatech.cs2340.spacetraders.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.io.FileNotFoundException;

import edu.gatech.cs2340.spacetraders.model.DataStore;
import edu.gatech.cs2340.spacetraders.model.Universe;

public class UniverseViewModel extends AndroidViewModel {
    private Universe uni;

    public UniverseViewModel(@NonNull Application application) {
        super(application);
        try {
            uni = DataStore.getCurrentUniverse(getApplication());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Universe getCurrentUniverse() {
        return uni;
    }

}
