package com.example.casestudy;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            if (input == 0) {
                return "This will be the driver profile";
            } else if (input == 1) {
                return "This will show the season stats";
            }
            return "This should never happen";
        }
    });

    public LiveData<String> getText() {
        return mText;
    }
}