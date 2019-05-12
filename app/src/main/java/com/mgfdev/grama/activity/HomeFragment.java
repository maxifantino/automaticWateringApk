package com.mgfdev.grama.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mgfdev.grama.R;
import com.mgfdev.grama.data.ApkConfig;
import com.mgfdev.grama.dto.Garden;
import com.mgfdev.grama.dto.Patch;
import com.mgfdev.grama.dto.User;
import com.mgfdev.grama.helper.DateHelper;

public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private User user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        user = (User) this.getArguments().get(ApkConfig.USER_KEY);
        populateLayout(rootView);
        return rootView;
    }

    private void populateLayout(View root){
        Garden garden = user.getGardens().get(0);
        Patch sprinkler = garden.getPatches().get(0);
        populateGarden(root, garden);
        populateSprinkler(root, sprinkler);
    }

    private void populateGarden(View root, Garden garden) {
        TextView tempTextView = (TextView)root.findViewById(R.id.temperatureText);
        TextView locationTextView = (TextView)root.findViewById(R.id.locationText);
        tempTextView.setText(garden.getTemperatureAsString());
        locationTextView.setText(garden.getReadableLocation());
    }

    private void populateSprinkler(View root, Patch sprinkler) {
        TextView tempTextView = (TextView)root.findViewById(R.id.humidityText);
        TextView humidityTextView = (TextView)root.findViewById(R.id.humidityText);
        TextView statusTextView = (TextView)root.findViewById(R.id.statusText);
        TextView lastCheck = (TextView) root.findViewById(R.id.lastcheckText);

        tempTextView.setText(sprinkler.getTemperatureAsString());
        humidityTextView.setText(Float.toString(sprinkler.getHumidity()));
        statusTextView.setText(sprinkler.getStatus());
        lastCheck.setText(DateHelper.getDate(sprinkler.getLastCheck()));
    }

}

