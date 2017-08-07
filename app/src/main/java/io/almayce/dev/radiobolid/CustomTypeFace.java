package io.almayce.dev.radiobolid;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by almayce on 02.06.17.
 */

public class CustomTypeFace {

    private static CustomTypeFace instance;
    private static Typeface typeface;

    public static CustomTypeFace getInstance(Context context) {
        synchronized (CustomTypeFace.class) {
            if (instance == null) {
                instance = new CustomTypeFace();
                typeface = Typeface.createFromAsset(context.getResources().getAssets(), "fonts/lazy_crazy.ttf");
            }
            return instance;
        }
    }

    public Typeface getTypeFace() {
        return typeface;
    }
}