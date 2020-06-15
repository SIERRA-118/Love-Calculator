package com.example.lovecalculator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatTextView;

public class CustomTextView extends AppCompatTextView {

    Typeface myTypeface;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode())
            init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            init(attrs);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public CustomTextView(Context context) {
        super(context);
        if (!isInEditMode())
            init(null);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs,
                    R.styleable.CustomTextView);
            String fontName = a.getString(R.styleable.CustomTextView_fontName);
            if (fontName != null) {
                myTypeface = fontCache.getInstance().getTypeface(getContext(), fontName);

            }
            setTypeface(myTypeface);
            a.recycle();
        }
    }


}

