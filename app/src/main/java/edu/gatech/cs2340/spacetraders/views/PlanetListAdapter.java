package edu.gatech.cs2340.spacetraders.views;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.Good;
import edu.gatech.cs2340.spacetraders.model.Planet;

public class PlanetListAdapter extends RecyclerView.Adapter<PlanetListAdapter.MyViewHolder> {
    private ArrayList<Planet> planets;
    private int selectedPosition = -1;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TableRow tableRow;
        public MyViewHolder(TableRow v) {
            super(v);
            tableRow= v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PlanetListAdapter(Set<Planet> planets) {
        this.planets = new ArrayList<>(planets);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PlanetListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        TableRow v = (TableRow) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.planet_item, parent, false);

        PlanetListAdapter.MyViewHolder vh = new PlanetListAdapter.MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PlanetListAdapter.MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Planet planet = planets.get(position);

        TextView planetName = (TextView) holder.tableRow.getChildAt(0);

        planetName.setText(planet.toString());

        holder.tableRow.setOnClickListener(view -> {
            selectedPosition = position;
            holder.tableRow.setBackgroundColor(Color.parseColor("#baefcd"));
            notifyDataSetChanged();
            updateColor(holder, position);

        });

        updateColor(holder, position);


    }

    public String getSelectedPosition() {
        try {
            return planets.get(selectedPosition).getName();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return Good.values().length;
    }

    public void updateColor(PlanetListAdapter.MyViewHolder holder, int position) {
        if (position == selectedPosition) {
            holder.tableRow.setBackgroundColor(Color.parseColor("#baefcd"));
        } else {
            holder.tableRow.setBackgroundColor(Color.parseColor("#95d4ab"));
        }
    }
}
