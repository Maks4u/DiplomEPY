package com.example.diplomepy.helper;

import android.content.Context;

import com.example.diplomepy.R;

public class TextHelper {

    public static void setText(final String text, final Context context, final RecreateApp recreateApp){

        final String small = context.getString(R.string.text_small);
        final String medium = context.getString(R.string.text_medium);
        final String big = context.getString(R.string.text_big);

        int themeID = R.style.FontSizeMedium;

        if (text.equals(small)) {
            themeID = R.style.FontSizeSmall;
        } else if (text.equals(big)) {
            themeID = R.style.FontSizeLarge;
        }

        context.setTheme(themeID);

        if(recreateApp != null){
            recreateApp.recreate();
        }
    }

    public interface RecreateApp{
        void recreate();
    }
}
