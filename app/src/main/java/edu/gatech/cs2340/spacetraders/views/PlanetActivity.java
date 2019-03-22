package edu.gatech.cs2340.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.viewmodel.MarketViewModel;

public class PlanetActivity extends AppCompatActivity {

    private ImageButton marketBttn;
    private ImageButton travelBttn;
    private TextView playerCredits;

    private MarketViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        marketBttn = findViewById(R.id.market_button);
        travelBttn = findViewById(R.id.travel_button);
        playerCredits = findViewById(R.id.credits_text);

        viewModel = ViewModelProviders.of(this).get(MarketViewModel.class);

        playerCredits.setText(String.format("Credits: %.2f", viewModel.getPlayerCredits()));

        marketBttn.setOnClickListener(view -> {
            Intent intent = new Intent(PlanetActivity.this, MarketActivity.class);
            startActivity(intent);
        });

        travelBttn.setOnClickListener(view -> {
            Intent intent = new Intent(PlanetActivity.this, UniverseActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();
        viewModel = ViewModelProviders.of(this).get(MarketViewModel.class);
        playerCredits.setText(String.format("Credits: %.2f", viewModel.getPlayerCredits()));
    }
}
