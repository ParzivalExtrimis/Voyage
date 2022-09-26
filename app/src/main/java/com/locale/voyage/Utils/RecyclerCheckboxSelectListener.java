package com.locale.voyage.Utils;

import android.widget.CompoundButton;

public interface RecyclerCheckboxSelectListener {
    void onItemSelected(CompoundButton compoundButton, boolean isChecked, int position);
}
