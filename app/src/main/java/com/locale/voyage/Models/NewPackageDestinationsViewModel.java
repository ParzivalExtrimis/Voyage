package com.locale.voyage.Models;

import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewPackageDestinationsViewModel extends ViewModel {

    TextView cardText;
    CardView card;
    private MutableLiveData<CheckBoxData> checkBoxDataMutableLiveData;

    public NewPackageDestinationsViewModel() {
        checkBoxDataMutableLiveData = new MutableLiveData<CheckBoxData>();
    }

    public TextView getCardText() {
        return cardText;
    }

    public void setCardText(TextView cardText) {
        this.cardText = cardText;
    }

    public CardView getCard() {
        return card;
    }

    public void setCard(CardView card) {
        this.card = card;
    }

    public MutableLiveData<CheckBoxData> getCheckBoxMutableLiveData() {
        return checkBoxDataMutableLiveData;
    }

    public void setCheckBoxDataMutableLiveData(boolean checked, int position) {
        checkBoxDataMutableLiveData.setValue(new CheckBoxData(checked, position));
    }

    public class CheckBoxData {
        int mCheckBoxPosition;
        boolean isChecked;

        public CheckBoxData(boolean isChecked, int mCheckBoxPosition) {
            this.mCheckBoxPosition = mCheckBoxPosition;
            this.isChecked = isChecked;
        }

        public int getCheckBoxPosition() {
            return mCheckBoxPosition;
        }

        public boolean isChecked() {
            return isChecked;
        }

    }
}
