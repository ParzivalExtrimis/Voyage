package com.locale.voyage.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.locale.voyage.Models.DestinationModel;
import com.locale.voyage.R;
import com.locale.voyage.Utils.RecyclerClickListener;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {

    //get destinations data from destinations model
    DestinationModel[] destinations;
    private static RecyclerClickListener clickListener;
    int itemCount;

    public PopularAdapter(DestinationModel[] destinations) {
        this.destinations = destinations;
        this.itemCount = destinations.length;
    }


    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View popularView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.popular_places_layout, parent, false);

        return new PopularViewHolder(popularView);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
        int revPosition = itemCount - position - 1;
        setViewFromModel(holder, revPosition);
    }

    @Override
    public int getItemCount() {
        return this.itemCount;
    }

    // model for featured view
    public static class PopularViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView getPlaceImg() {
            return placeImg;
        }

        public TextView getPlaceTitle() {
            return placeTitle;
        }

        public TextView getPlaceDesc() {
            return placeDesc;
        }

        //view components
        ImageView placeImg;
        TextView placeTitle;
        TextView placeDesc;
        CardView placeContainerCard;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImg = itemView.findViewById(R.id.popular_place_image);
            placeTitle = itemView.findViewById(R.id.popular_place_title);
            placeDesc = itemView.findViewById(R.id.popular_place_desc);
            placeContainerCard = itemView.findViewById(R.id.popular_place_card);

            //set click listener to view
            placeContainerCard.setOnClickListener(this);
        }

        public void onClick(View view) {
            clickListener.onItemClicked(view, getAdapterPosition());
        }
    }

    public void setOnItemClickLister(RecyclerClickListener clickListener) {
        PopularAdapter.clickListener = clickListener;
    }

    private void setViewFromModel(@NonNull PopularViewHolder holder, int position) {
        holder.getPlaceImg().setImageResource(destinations[position].getImage());
        holder.getPlaceTitle().setText(destinations[position].getName());
        holder.getPlaceDesc().setText(destinations[position].getDesc());
    }
}
