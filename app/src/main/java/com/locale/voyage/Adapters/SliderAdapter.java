package com.locale.voyage.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.locale.voyage.R;

public class SliderAdapter extends PagerAdapter{

    Context mContext;
    LayoutInflater inflater;


    public SliderAdapter(Context context) {
        mContext = context;
    }

    private int[] backgroundImgs = {
            R.drawable.travel_guy_bagpack,
            R.drawable.food,
            R.drawable.amsterdam,
            R.drawable.hiking
    };

    private int[] gradientImgs = {
            R.drawable.background1,
            R.drawable.background2,
            R.drawable.background3,
            R.drawable.background4
    };

    private int[] icon1 = {
            R.drawable.car,
            R.drawable.plane,
            R.drawable.boot,
            R.drawable.nav
    };

    private int[] icon2 = {
            R.drawable.dollar,
            R.drawable.cutlery,
            R.drawable.road_pin,
            R.drawable.cycle
    };

    private int[] icon3 = {
            R.drawable.passport_n_plane,
            R.drawable.cocktail,
            R.drawable.bagpack,
            R.drawable.tent,
    };


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.onboarding_view, container, false);

        //hooks
        ImageView backgrImg = view.findViewById(R.id.view_img);
        ImageView gradientImg = view.findViewById(R.id.splash_background_img);
        ImageView iconImg1 = view.findViewById(R.id.icon1);
        ImageView iconImg2 = view.findViewById(R.id.icon2);
        ImageView iconImg3 = view.findViewById(R.id.icon3);

        //setting views
        backgrImg.setImageResource(backgroundImgs[position]);
        gradientImg.setImageResource(gradientImgs[position]);
        iconImg1.setImageResource(icon1[position]);
        iconImg2.setImageResource(icon2[position]);
        iconImg3.setImageResource(icon3[position]);

        container.addView(view);
        return view;
    }


    @Override
    public int getCount() {
        return gradientImgs.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
