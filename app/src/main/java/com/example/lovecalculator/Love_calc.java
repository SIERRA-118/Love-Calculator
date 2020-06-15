package com.example.lovecalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Love_calc extends AppCompatActivity {
    static String yourName="";
    static String personName="";
    ViewPager viewPager;
  /*  private AdView mAdView;
    InterstitialAd mInterstitialAd;
    private RewardedVideoAd mAd;
    private boolean isReawared;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_calc);


       /* String s = Data_to_pref.getSharedPreferanceData(this,"appcount");
        if(s.equals(""))
            s="0";
        int count=Integer.parseInt(s);
        count++;
        Data_to_pref.setSharedPreferanceData(this,"appcount",count+"");
        if(count%4==0) {
            boolean b = Data_to_pref.getBooleanSharedPref(this, "Rating");
            if (!b) {
                FiveStarsDialog fiveStarsDialog = new FiveStarsDialog(this, "gauswamihk@gmail.com");
                fiveStarsDialog.setRateText("Love this calculator")
                        .setTitle("Love Calculator")
                        .setForceMode(false)

                        .setUpperBound(2) // Market opened if a rating >= 2 is selected
                        .setNegativeReviewListener(new NegativeReviewListener() {
                            @Override
                            public void onNegativeReview(int i) {
                                DataToPref.setSharedPreferanceData(LoveActivity.this, "Rating", true);
                            }
                        }) // OVERRIDE mail intent for negative review
                        .setReviewListener(new ReviewListener() {
                            @Override
                            public void onReview(int i) {
                                DataToPref.setSharedPreferanceData(LoveActivity.this, "Rating", true);
                            }
                        }) // Used to listen for reviews (if you want to track them )
                        .showAfter(0);
            }
        }*/
        YoYo.with(Techniques.FadeInDown).duration(1000).playOn(findViewById(R.id.img_logo));
        YoYo.with(Techniques.Bounce).delay(1000).duration(1000)
                .playOn(findViewById(R.id.img_logo));
        YoYo.with(Techniques.FadeInDown).duration(1000).playOn(findViewById(R.id.tv_title));

       /* viewPager = (ViewPager) findViewById(R.id.viewpager);
        MyPagerAdapter myPagerAdapter
                = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
        mAd = MobileAds.getRewardedVideoAdInstance(this);
        //mAd.t.addTestDevice("32FBF722081962F6ADEFA543F78B9070")
        mAd.setRewardedVideoAdListener(this);
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("32FBF722081962F6ADEFA543F78B9070")
                .build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3189296528074471/8715175540");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                openResult();
            }
        });
        requestNewInterstitial();
        loadRewardedVideoAd();

    }*/

   /* @Override
    public void onRewarded(RewardItem reward) {
        isReawared=true;
        *//*Toast.makeText(this, "onRewarded! currency: " + reward.getType() + "  amount: " +
                reward.getAmount(), Toast.LENGTH_SHORT).show();*//*
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
       *//* Toast.makeText(this, "onRewardedVideoAdLeftApplication",
                Toast.LENGTH_SHORT).show();*//*
    }

    @Override
    public void onRewardedVideoAdClosed() {
        if(isReawared)
            openResult();
        //Toast.makeText(this, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {

        //Toast.makeText(this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdLoaded() {
//        Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdOpened() {
        //      Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoStarted() {
        //    Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }
*/
    @Override
    public void onFristFragment(String yourname) {
        this.yourName=yourname;
        if(this.yourName.equals("")) {
            viewPager.setCurrentItem(0);
            return;
        }
        viewPager.setCurrentItem(1);
    }

    @Override
    public void onSecondFragment(String String personName = Love_calc.personName); {
        this.personName= Love_calc.personName;
        if (checkNames()) return;
        viewPager.setCurrentItem(2);
    }

    @Override
    public void onThirdFragment() {

        if (checkNames()) return;

        YoYo.with(Techniques.Pulse).duration(1000).repeat(5)
                .playOn(findViewById(R.id.img_logo));
        //mButton.setText("Loding...");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Love_calc.this != null) {
                    AlertDialog.Builder mBuilder
                            = new AlertDialog.Builder(Love_calc.this,R.style.Theme_AppCompat_DayNight_Dialog);
                    final AlertDialog mAlertDialog =mBuilder.create();
                    mAlertDialog.setTitle(getString(R.string.app_name));
                    mAlertDialog.setMessage(getString(R.string.complet_msg));

                    mAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE,getString(R.string.watch), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            mAlertDialog.dismiss();
                            //mCallback.onThirdFragment();

                         /*   if(mAd.isLoaded()) {
                                mAd.show();
                                return;
                            }
                            if(mInterstitialAd.isLoaded())
                            {
                                mInterstitialAd.show();
                                return;
                            }
                            else{*/
                                Love_calc.this.openResult();
                            }
                        });
                    }
                )



                }
            }
        );
        }


    }

    private void openResult() {
        Intent mIntent  = new Intent(Love_calc.this,add_activity.class);
        mIntent.putExtra("name",yourName);
        mIntent.putExtra("pname", Love_calc.personName);
        startActivity(mIntent);
        finish();
    }

    private boolean checkNames() {
        if(this.yourName.equals("")) {
            viewPager.setCurrentItem(0);
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(this.personName.equals("")) {
            Toast.makeText(this, "Please enter other person name", Toast.LENGTH_SHORT).show();
            viewPager.setCurrentItem(1);
            return true;
        }
        return false;
    }



 /*   private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    private void loadRewardedVideoAd() {
        mAd.loadAd(getString(R.string.reward_video), new AdRequest.Builder().build());
    }
*/

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return new frag_first();
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return new second_frag();
                case 2: // Fragment # 1 - This will show SecondFragment
                    return new third_frag();
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }


}


