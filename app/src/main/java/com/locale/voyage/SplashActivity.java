package com.locale.voyage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.locale.voyage.OnBoarding.OnBoardingSlider;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 2000;
    ConstraintLayout splashBackground;
    TextView splashText;
    Animation splashAnim;

    SharedPreferences onBoardingPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        //hooks
        splashBackground = findViewById(R.id.splash_background);
        splashText = findViewById(R.id.splash_text);


        // fullscreen management
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:

                splashBackground.setBackgroundColor(getResources().getColor(R.color.black));
                break;
            case Configuration.UI_MODE_NIGHT_NO:
                splashBackground.setBackgroundColor(getResources().getColor(R.color.mustard));
                break;
        }

        //Animations
        splashAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_anim);
        splashText.setAnimation(splashAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingPref = getSharedPreferences("onBoardingSlider", MODE_PRIVATE);
                boolean isFirstTime = onBoardingPref.getBoolean("isFirstTime", true);

                if(isFirstTime) {
                    onBoardingPref.edit().putBoolean("isFirstTime", false).commit();
                    startActivity(new Intent(getApplicationContext(), OnBoardingSlider.class));
                    finish();
                }
                else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        }, SPLASH_DURATION);
    }
}