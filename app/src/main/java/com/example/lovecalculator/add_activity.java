package com.example.lovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class add_activity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
       Love_calc.personName="";
       Love_calc.yourName="";
        startActivity(new Intent(this,Love_calc.class));
        finish();
        //super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Love_calc.personName="";
        Love_calc.yourName="";



        setContentView(R.layout.activity_add_activity);
        findViewById(R.id.img_about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(add_activity.this,about_us.class));
            }
        });
        CustomTextView res = (CustomTextView) findViewById(R.id.tv_result);
        //srequestNewInterstitial();

        YoYo.with(Techniques.Shake).delay(500).duration(500).playOn(findViewById(R.id.img_logo));
        Typeface mTypeface=Typeface.createFromAsset(getAssets(),getString(R.string.font_amatic_bold));
        final Button mButton = (Button) findViewById(R.id.btn_done);
        mButton.setTypeface(mTypeface);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();


            }
        });


        if(getIntent()!=null)
            if(getIntent().getStringExtra("name")!=null){
                String n = getIntent().getStringExtra("name");
                String cn =getIntent().getStringExtra("pname");
                String concat = String.valueOf(n).concat(String.valueOf(cn)).toUpperCase();
                if ((n.toString().trim().length() == 0) || (cn.toString().trim().length() == 0)) {
                    Toast.makeText(add_activity.this, "Please fill both the fields ", Toast.LENGTH_LONG).show();
                } else {
                    int sum = getSum(concat);



                    res.setText("The love between " + n + " and " + cn + " is " + sum % 100 + "%");
                    if (sum % 100 <= 30) {
                        YoYo.with(Techniques.Hinge).delay(1000).duration(1000).playOn(findViewById(R.id.img_logo));

                    } else if (sum % 100 > 30 && sum % 100 <= 60) {
                        YoYo.with(Techniques.Bounce).delay(1000).duration(1000).playOn(findViewById(R.id.img_logo));
                    } else {
                        YoYo.with(Techniques.Shake).repeat(10).duration(500).playOn(findViewById(R.id.img_logo));
                    }
                }
            }

    }

    int counter=0;
    private int getSum(String concat) {
        int sum = 0;
        for (int i = 0; i < concat.length(); i++) {
            char character = concat.charAt(i);
            int ascii = (int) character;
            sum += ascii;
        }
        //This thing is call love hack always number of percent
        if(sum % 100 < 50)
        {
            counter++;
            return getSum(concat+counter);

        }else {
            return sum;
        }
    }


}
