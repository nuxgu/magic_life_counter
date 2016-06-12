package org.nuxgu.magiclifecounter;

/**
 * Created by m on 3/10/2016.
 */
public class ManaType {

    static final int WHITE = 0;
    static final int BLUE = 1;
    static final int BLACK = 2;
    static final int RED = 3;
    static final int GREEN = 4;

    public static final int buttonDrawables[] = {
            R.drawable.white_mana,
            R.drawable.blue_mana,
            R.drawable.black_mana,
            R.drawable.red_mana,
            R.drawable.green_mana,
    };

    public static final int backgroundDrawables[] = {
            R.drawable.plains,
            R.drawable.island,
            R.drawable.swamp,
            R.drawable.mountain,
            R.drawable.forest,
    };

    public static final int manaButtonsIds1[] = {
            R.id.whiteButton1,
            R.id.blueButton1,
            R.id.blackButton1,
            R.id.redButton1,
            R.id.greenButton1
    };

    public static final int manaButtonsIds2[] = {
            R.id.whiteButton2,
            R.id.blueButton2,
            R.id.blackButton2,
            R.id.redButton2,
            R.id.greenButton2
    };

    static int fromButtonId(int buttonId) {
        for (int i = 0; i < 5; ++i) {
            if (buttonId == manaButtonsIds1[i] || buttonId == manaButtonsIds2[i]) return i;
        }
        assert (false);
        return -1;
    }

}
