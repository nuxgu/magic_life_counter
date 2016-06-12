package org.nuxgu.magiclifecounter;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

/**
 * Created by m on 2/28/2016.
 */
public class MagicFont {
    private static Typeface font;

    public static Typeface get(Context context) {
        if (font == null) {
            try {
                font = Typeface.createFromAsset(context.getAssets(), "fonts/magic.TTF");
                Log.i("MagicFont", "font loaded");
            } catch (Exception e) {
                Log.e("MagicFont", e.getMessage());
                return null;
            }
        }
        return font;
    }
}
