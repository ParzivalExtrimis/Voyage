package com.locale.voyage.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.locale.voyage.Models.DestinationModel;
import com.locale.voyage.Models.NewPackageDestinationsViewModel;
import com.locale.voyage.R;
import com.locale.voyage.Utils.RecyclerCheckboxSelectListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class NewPackageDestinationsAdapter extends RecyclerView.Adapter<NewPackageDestinationsAdapter.NewPackageDestinationsAdapterViewHolder> {

    //get viewable data from destination model
    DestinationModel[] destinations;
    private static RecyclerCheckboxSelectListener listener;

    public NewPackageDestinationsAdapter(DestinationModel[] destinations) {
        this.destinations = destinations;
    }

    @NonNull
    @Override
    public NewPackageDestinationsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.new_package_recycler_card, parent, false);
        return new NewPackageDestinationsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewPackageDestinationsAdapterViewHolder holder, int position) {
        setViewFromModel(holder, position);
    }

    @Override
    public int getItemCount() {
        return this.destinations.length;
    }

    static class NewPackageDestinationsAdapterViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener{

        //hooks
       NewPackageDestinationsViewModel model;
       CheckBox checkBox;

        public NewPackageDestinationsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            model = new NewPackageDestinationsViewModel();

            model.setCard(itemView.findViewById(R.id.new_package_recycler_card));
            model.setCardText(itemView.findViewById(R.id.new_package_recycler_card_text));
            checkBox = itemView.findViewById(R.id.new_package_recycler_checkbox);

            checkBox.setOnCheckedChangeListener(this);
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }


        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            listener.onItemSelected(compoundButton, b, getAdapterPosition());
        }
    }

    private void setViewFromModel(@NonNull NewPackageDestinationsAdapterViewHolder holder, int position) {
        holder.model.getCardText().setText(destinations[position].getName());
        Random r = new Random();
        Set<Integer> s = new HashSet<Integer>();
        int[] colors = {
                R.color.candy_red,
                R.color.candy_blue,
                R.color.candy_green,
                R.color.candy_yellow,
                R.color.candy_pink,
                R.color.candy_purple,
                R.color.candy_orange,
                R.color.candy_teal,
                R.color.candy_ruby,
                R.color.ocean,
        };

        for(int i = 0; i < colors.length; i++) {
            s.add(r.nextInt(colors.length));
        }
        List<Integer> list = new ArrayList<Integer>(s);
        int color = holder.model.getCard().getContext().getResources().getColor(colors[list.get(position)]);
        holder.model.getCard().setCardBackgroundColor(color);
    }

    public void setOnCheckboxSelectListener(RecyclerCheckboxSelectListener listener) {
        NewPackageDestinationsAdapter.listener = listener;
    }
}
