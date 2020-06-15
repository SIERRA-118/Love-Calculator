package com.example.lovecalculator;

import android.content.Context;
import android.content.SharedPreferences;

public class Data_to_pref {
    private static final String DEFAULTPREF = "DEFAULTPREF";

    public static void setSharedPreferanceData(Context context, String PrefName, String key, String value) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PrefName, Context.MODE_PRIVATE);
        try {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(key, value);
            editor.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setSharedPreferanceData(Context context, String PrefName, String key, boolean value) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PrefName, Context.MODE_PRIVATE);
        try {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(key, value);
            editor.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getSharedPreferanceData(Context context, String PrefName, String key) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PrefName, Context.MODE_PRIVATE);
        String userObjectString = sharedpreferences.getString(key, "");
        return userObjectString;
    }


    public static boolean getBooleanSharedPref(Context context, String key) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(DEFAULTPREF, Context.MODE_PRIVATE);
        return sharedpreferences.getBoolean(key, false);
    }

    public static void clearPref(Context context, String PrefName) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PrefName, Context.MODE_PRIVATE);
        try {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            editor.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setSharedPreferanceData(Context context, String key, String value) {
        try {
            SharedPreferences sharedpreferences = context.getSharedPreferences(DEFAULTPREF, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(key, value);
            editor.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setSharedPreferanceData(Context context, String key, boolean value) {
        try {
            SharedPreferences sharedpreferences = context.getSharedPreferences(DEFAULTPREF, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(key, value);
            editor.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getSharedPreferanceData(Context context, String key) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(DEFAULTPREF, Context.MODE_PRIVATE);
        String userObjectString = sharedpreferences.getString(key, "");
        return userObjectString;
    }


    public static void clearPref(Context context) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(DEFAULTPREF, Context.MODE_PRIVATE);
        try {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            editor.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removePrefKey(Context context, String key) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(DEFAULTPREF, Context.MODE_PRIVATE);
        try {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.remove(key);
            editor.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

