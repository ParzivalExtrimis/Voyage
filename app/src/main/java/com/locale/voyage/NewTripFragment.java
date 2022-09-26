package com.locale.voyage;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.locale.voyage.Adapters.NewPackageDestinationsAdapter;
import com.locale.voyage.Models.DestinationModel;
import com.locale.voyage.Models.NewPackageDestinationsViewModel;
import com.locale.voyage.Utils.RecyclerCheckboxSelectListener;

import java.util.ArrayList;

public class NewTripFragment extends Fragment {

    //hooks
    ImageButton nextButton;

    //recycler
    RecyclerView newPackageRecyclerView;
    NewPackageDestinationsAdapter newPackageDestinationsAdapter;
    LinearLayoutManager newPackageLayoutManager;
    DestinationModel[] destinationData;

    BottomNavigationView bottomNavigationView;
    NavHostFragment navHostFragment;
    NavController navController;

    NewPackageDestinationsViewModel model;
    ArrayList<String> selectedPlaces;
    Bundle selectedPlacesBundle;

    //Animations
    Animation fadeAnim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_trip, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //init
        selectedPlaces = new ArrayList<String>();
        selectedPlacesBundle = new Bundle();

        //hooks
        newPackageRecyclerView = getView().findViewById(R.id.new_destinations_recycler);
        bottomNavigationView = getView().getRootView().findViewById(R.id.bottom_navigator);
        nextButton = getView().findViewById(R.id.b_fragment_new_next);

        //Animation
        fadeAnim = AnimationUtils.loadAnimation(getContext(), R.anim.fade_anim);

        //destination data
        destinationData = ((MainActivity)getActivity()).getDestinationsData();

        //adapter and layout managers
        newPackageDestinationsAdapter = new NewPackageDestinationsAdapter(destinationData);
        newPackageLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        newPackageRecyclerView.setLayoutManager(newPackageLayoutManager);
        newPackageRecyclerView.scrollToPosition(RecyclerView.SCROLLBAR_POSITION_DEFAULT);
        newPackageRecyclerView.setAdapter(newPackageDestinationsAdapter);

        //set list of selected places
        try {
            newPackageDestinationsAdapter.setOnCheckboxSelectListener(new RecyclerCheckboxSelectListener() {
                @Override
                public void onItemSelected(CompoundButton compoundButton, boolean isChecked, int position) {
                    if(isChecked && !selectedPlaces.contains(destinationData[position].getName())) {
                        selectedPlaces.add(destinationData[position].getName());
                    }
                    else if(!isChecked && selectedPlaces.contains(destinationData[position].getName())) {
                        selectedPlaces.remove(destinationData[position].getName());
                    }
                    Log.d("NewTripFragment", selectedPlaces.toString());

                    //handle empty select scenario
                    if (!selectedPlaces.isEmpty()) {
                        nextButton.startAnimation(fadeAnim);
                        nextButton.setVisibility(View.VISIBLE);
                    } else {
                        nextButton.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }
        catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        //get host fragment and controller
        navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        try {
            navController = navHostFragment.getNavController();
        } catch (NullPointerException e) {
            Log.d("NewTripFragment", "get new package nav controller returned null.");
        }

        //navigate
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("NewTripFragment", "next Clicked.");
                selectedPlacesBundle.putStringArrayList("places", selectedPlaces);
                navController.navigate(R.id.action_new_trip_fragment_to_newPackageFragment, selectedPlacesBundle);
            }
        });
    }
}