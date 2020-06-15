package com.example.lovecalculator;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.ArrayMap;

import androidx.annotation.RequiresApi;

import java.util.Map;

public class fontCache {
        private static fontCache instance;
        private final Map<String, Typeface> fontCache;

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        private fontCache() {
            //array map is efficient than hash map
            fontCache = new ArrayMap<>();
        }

        public fontCache(Map<String, Typeface> fontCache) {
            this.fontCache = fontCache;
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        public static synchronized fontCache getInstance() {
            if (instance == null) {
                instance = new fontCache();
            }
            return instance;
        }

        public Typeface getTypeface(Context context, String fontName) {
            //using app context to avoid leaks
            Context appContext = context.getApplicationContext();
            Typeface typeface = fontCache.get(fontName);
            if (typeface == null) {
                try {
                    typeface = Typeface.createFromAsset(appContext.getAssets(), fontName);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                fontCache.put(fontName, typeface);
            }
            return typeface;
        }
}
