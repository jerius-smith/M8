package edu.gatech.cs2340.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.viewmodel.SolarViewModel;

public class SolarActivity extends AppCompatActivity {

    private RecyclerView planetListView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private SolarViewModel viewModel;
    private TextView playerCredits;
    private ImageButton travelButton;

    private String solarName;

    private TextView location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar);

        Bundle extras = getIntent().getExtras();
        solarName = extras.getString("SOLAR_SYSTEM");

        location = findViewById(R.id.location_text);
        location.setText("Solar System: " + solarName);

        planetListView = findViewById(R.id.planet_list_view);
        planetListView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        planetListView.setLayoutManager(layoutManager);

        viewModel = ViewModelProviders.of(this).get(SolarViewModel.class);

        mAdapter = new PlanetListAdapter(viewModel.getPlanetList(solarName));
        planetListView.setAdapter(mAdapter);

        playerCredits = findViewById(R.id.credits_text);
        playerCredits.setText(String.format("Credits: %.2f", viewModel.getPlayerCredits()));

        travelButton = findViewById(R.id.travel_button);

        travelButton.setOnClickListener(view -> {
            PlanetListAdapter adapter = (PlanetListAdapter) planetListView.getAdapter();
            if (adapter.getSelectedPosition() != null) {
                String planetTo = adapter.getSelectedPosition();
                viewModel.travelTo(planetTo);
                adapter.notifyDataSetChanged();
                viewModel.savePlayer();
            }
        });

    }
}
