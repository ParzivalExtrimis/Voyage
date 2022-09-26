package com.locale.voyage.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.locale.voyage.Models.DestinationModel;
import com.locale.voyage.R;
import com.locale.voyage.Utils.RecyclerClickListener;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    //get viewable data from destination model
    DestinationModel[] destinations;
    private static RecyclerClickListener clickListener;

    public FeaturedAdapter(DestinationModel[] destinations) {
        this.destinations = destinations;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View featuredView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.featured_places_layout, parent, false);

        FeaturedViewHolder holder = new FeaturedViewHolder(featuredView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        setViewFromModel(holder, position);
    }

    @Override
    public int getItemCount() {
        return this.destinations.length;
    }

    // model for featured view
    public static class FeaturedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView getPlaceImg() {
            return placeImg;
        }
        public TextView getPlaceTitle() {
            return placeTitle;
        }
        public LinearLayout getContainer() {return  container;}

        //view components
        ImageView placeImg;
        TextView placeTitle;
        LinearLayout container;

        @Override
        public void onClick(View view) {
            clickListener.onItemClicked(view, getAdapterPosition());
        }

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImg = itemView.findViewById(R.id.feat_place_img);
            placeTitle = itemView.findViewById(R.id.feat_place_title);
            container = itemView.findViewById(R.id.featured_container);

            //set click listeners to individual views.
            container.setOnClickListener(this);
        }
    }

    public void setOnItemClickedListener(RecyclerClickListener clickListener) {
        FeaturedAdapter.clickListener = clickListener;
    }
    private void setViewFromModel(@NonNull FeaturedAdapter.FeaturedViewHolder holder, int position) {
        holder.getPlaceImg().setImageResource(destinations[position].getImage());
        holder.getPlaceTitle().setText(destinations[position].getName());
    }
}
