package com.example.lovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        YoYo.with(Techniques.FadeInDown).duration(1000).playOn(findViewById(R.id.img_logo));
        YoYo.with(Techniques.Bounce).delay(1000).duration(1000)
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        finish();
                        overridePendingTransition(0,0);
                        startActivity(new Intent(Splash_Screen.this,Love_calc.class));
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                }).playOn(findViewById(R.id.img_logo));
        YoYo.with(Techniques.FadeInDown).duration(1000).playOn(findViewById(R.id.tv_title));
    }
}
