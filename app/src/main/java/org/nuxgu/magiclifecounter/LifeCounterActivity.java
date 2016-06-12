package org.nuxgu.magiclifecounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class LifeCounterActivity extends Activity {

    private CustomNumberPicker lifeCounter1;
    private CustomNumberPicker lifeCounter2;

    private void reset() {
        lifeCounter1.reset();
        lifeCounter2.reset();
    }

    private void setupManaButtons(int manaButtonsId, int backgroundViewId) {
        ViewGroup mbs = (ViewGroup)findViewById(manaButtonsId);
        for (int i = 0; i < mbs.getChildCount(); ++i) {
            ImageButton mb = (ImageButton)mbs.getChildAt(i);
            if (mb != null) {
                final int manaType = ManaType.fromButtonId(mb.getId());
                final ImageView backgroundView = (ImageView)findViewById(backgroundViewId);
                mb.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backgroundView.setImageResource(ManaType.backgroundDrawables[manaType]);
                    }
                });
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_counter);

        lifeCounter1 = (CustomNumberPicker)findViewById(R.id.lifeCounter1);
        lifeCounter2 = (CustomNumberPicker)findViewById(R.id.lifeCounter2);

        final Button resetButton = (Button)findViewById(R.id.resetButton);
        resetButton.setTypeface(MagicFont.get(resetButton.getContext()));
        resetButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        setupManaButtons(R.id.manaButtons1, R.id.background1);
        setupManaButtons(R.id.manaButtons2, R.id.background2);
    }
}
