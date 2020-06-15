package com.example.lovecalculator;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFrag extends Fragment {
    public selectionCallback mCallback;
    public interface selectionCallback{
        void onFristFragment(String yourname);
        void onSecondFragment(String personName);
        void onThirdFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCallback= (selectionCallback) getActivity();
    }
}

