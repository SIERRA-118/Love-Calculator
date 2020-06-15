package com.example.lovecalculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class third_frag extends BaseFrag {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.activity_third_frag,container,false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Typeface mTypeface=Typeface.createFromAsset(getActivity().getAssets(),getString(R.string.font_amatic_bold));
        final Button mButton = (Button) getView().findViewById(R.id.btn_done);
        mButton.setTypeface(mTypeface);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mButton.setText("Calculating");
                loading(mButton);
                mCallback.onThirdFragment();

            }
        });


    }

    int counter=0;
    private void loading(final Button mButton) {
        mButton.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(getActivity()!=null) {
                    if(counter>6)
                        if (mButton.getText().length() == 14)

                            mButton.setText("Calculating");
                    counter++;
                    if(counter==6)
                        mButton.setText("Applying Love Algorithm");
                    if(counter==12){
                        counter=0;
                        mButton.setText("Calculate");
                        return;
                    }


                    mButton.setText(mButton.getText().toString() + ".");
                    loading(mButton);
                }
            }
        },500);
    }
}
