package com.locale.voyage.OnBoarding;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.locale.voyage.Adapters.SliderAdapter;
import com.locale.voyage.MainActivity;
import com.locale.voyage.R;

public class OnBoardingSlider extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter adapter;
    int nextPosition = 1;

    TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_slider);

        //remove status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //hooks
        viewPager = findViewById(R.id.pager);
        dotsLayout = findViewById(R.id.slider_dots);

        //call adapter
        adapter = new SliderAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                addDots(position);
                nextPosition = position+1;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        //adding dots to view
        addDots(0);
    }

    public void next(View view) {

        if(nextPosition == adapter.getCount()) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        viewPager.setCurrentItem(nextPosition);
    }

    private void addDots(int position) {
        dots = new TextView[adapter.getCount()];
        dotsLayout.removeAllViews();

        for(int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.white));

            dotsLayout.addView(dots[i]);
        }
        if(dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.mustard));
        }
    }

}