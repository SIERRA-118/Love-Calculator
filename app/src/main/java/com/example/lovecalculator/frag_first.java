package com.example.lovecalculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class frag_first extends BaseFrag implements TextView.OnEditorActionListener {
    private boolean preparedForSending=true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.activity_frag_first,container,false);
        return mView;
    }

    EditText mEditText;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mEditText= (EditText) getView().findViewById(R.id.edt_name);

        YoYo.with(Techniques.FadeInDown).duration(1000).playOn(mEditText);
        mEditText.setOnEditorActionListener(this);
    }

    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        // If triggered by an enter key, this is the event; otherwise, this is null.
        if (event != null) {
            // if shift key is down, then we want to insert the '\n' char in the TextView;
            // otherwise, the default action is to send the message.
            if (!event.isShiftPressed()) {
                if (isPreparedForSending()) {
                    preparedForSending=false;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            preparedForSending=true;
                        }
                    },300);
                    confirmSendMessageIfNeeded();
                }
                return true;
            }
            return false;
        }

        if (isPreparedForSending()) {
            confirmSendMessageIfNeeded();
        }
        return true;
    }

    private void confirmSendMessageIfNeeded() {
        String s =mEditText.getText().toString();
        if(s.equals(""))
            return;
        mCallback.onFristFragment(s);
    }

    public boolean isPreparedForSending() {
        return preparedForSending;
    }

    public void setPreparedForSending(boolean preparedForSending) {
        this.preparedForSending = preparedForSending;
    }
}

