package org.nuxgu.magiclifecounter;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

/**
 * Created by m on 2/28/2016.
 */
public class CustomNumberPicker extends NumberPicker {

    static final int MAX_LIFE = 100;
    static final int DEFAULT_LIFE = 20;
    static final String SKULL = "\u2620";

    public CustomNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        String displayedValues[] = new String[101];
        displayedValues[0] = SKULL;
        for (int i = 1; i <= 100; ++i) {
            displayedValues[i] = new Integer(i).toString();
        }
        setDisplayedValues(displayedValues);
        setMaxValue(MAX_LIFE);
        setWrapSelectorWheel(false);
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);

        reset();
    }

    public void reset() {
        setValue(DEFAULT_LIFE);
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        updateView(child);
    }

    @Override
    public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        updateView(child);
    }

    @Override
    public void addView(View child, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, params);
        updateView(child);
    }

    private void updateView(View view) {
        if (view instanceof EditText) {
            EditText text = (EditText)view;
            text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
            Typeface font = MagicFont.get(getContext());
            text.setTypeface(font);
        }
    }
}
