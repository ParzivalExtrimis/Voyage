package com.locale.voyage;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.locale.voyage.Adapters.FeaturedAdapter;
import com.locale.voyage.Adapters.PopularAdapter;
import com.locale.voyage.Models.DestinationModel;
import com.locale.voyage.Utils.MyScrollView;
import com.locale.voyage.Utils.RecyclerClickListener;

public class DashFragment extends Fragment {

    //Destinations data
    DestinationModel[] destinationData;

    //animation hooks
    Animation bottomReturnAnimation;

    //hooks
    MyScrollView dashScrollView;
    BottomNavigationView bottomNavigationView;
    RelativeLayout featContainer;

    //featured recycler
    RecyclerView featRecyclerView;
    FeaturedAdapter featAdapter;
    LinearLayoutManager featLayoutManager;


    //popular recycler
    RecyclerView popularRecyclerView;
    PopularAdapter popularAdapter;
    LinearLayoutManager popularLayoutManager;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //hooks
        featRecyclerView = getView().findViewById(R.id.recycler_featured);
        popularRecyclerView = getView().findViewById(R.id.recycler_popular);
        dashScrollView = getView().findViewById(R.id.dash_scroller);
        bottomNavigationView = getView().getRootView().findViewById(R.id.bottom_navigator);
        featContainer = getView().findViewById(R.id.recycler_featured_container);

        //animations
        bottomReturnAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.bottom_return_anim);

        //destination data
        destinationData = ((MainActivity)getActivity()).getDestinationsData();
        for(int i = 0; i < destinationData.length; i++) {
            Log.d("DashFragment", destinationData[i].getName());
        }
        //recycler view manager
        featLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        popularLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);

        //recycler adapters
        featAdapter = new FeaturedAdapter(destinationData);
        featRecyclerView.setLayoutManager(featLayoutManager);
        featRecyclerView.scrollToPosition(RecyclerView.SCROLLBAR_POSITION_DEFAULT);

        popularAdapter = new PopularAdapter(destinationData);
        popularRecyclerView.setLayoutManager(popularLayoutManager);
        popularRecyclerView.scrollToPosition(RecyclerView.SCROLLBAR_POSITION_DEFAULT);

        featRecyclerView.setAdapter(featAdapter);
        popularRecyclerView.setAdapter(popularAdapter);

        //set status bar and nav bar visibility based on scroll position
        helperBarScrollerHandler(dashScrollView);

        //TODO navigate from recycler clicked to appropriate destinations

        featAdapter.setOnItemClickedListener(new RecyclerClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                Log.d("DashFragment", String.valueOf(position) + " selected.");
            }
        });

        popularAdapter.setOnItemClickLister((new RecyclerClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                Log.d("DashFragment", "Popular " + String.valueOf(position));
            }
        }));
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void helperBarScrollerHandler(MyScrollView dashScrollView) {
        dashScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int curX, int curY, int oldX, int oldY) {
                Log.d("MainActivity", "scrolling now");
                // hide nav bar when scrolled.
                bottomNavigationView.setVisibility(View.INVISIBLE);

                if(curY != 0) {
                    getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
                }
                if(curY == ScrollView.SCROLLBAR_POSITION_DEFAULT){
                    getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    Log.d("MainActivity", "scroll origin");
                }
            }

        });
        dashScrollView.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    dashScrollView.startScrollerTask();
                }
                return false;
            }
        });

        dashScrollView.setOnScrollStoppedListener(new MyScrollView.OnScrollStoppedListener() {
            @Override
            public void onScrollStopped() {
                Log.d("MainActivity", "scroll stopped");
                dashScrollView.setDelay(300);
                bottomNavigationView.startAnimation(bottomReturnAnimation);
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });
    }
}