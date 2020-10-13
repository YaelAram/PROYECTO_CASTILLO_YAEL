package com.yaelaram;

import java.awt.*;

public class ColorStyle {
    private final Color greyCool = new Color(130, 130, 130);
    private final Color greyDarkCool = new Color(0, 0, 0);
    private final Color white = new Color(255, 255, 255);
    private final Color orange = new Color(221, 44, 0);
    private final Font primaryFont = new Font("Roboto", Font.BOLD, 22);
    private final Font secondaryFont = new Font("Roboto", Font.BOLD, 14);
    public final static int PRIMARY_LABEL_FLAG = 1;
    public final static int SECONDARY_LABEL_FLAG = 2;
    public final static int ACTIVE_TEXT_FIELD_FLAG = 3;
    public static final int INACTIVE_TEXT_FIELD_FLAG = 4;
    public static final int ACTIVE_BUTTON_FLAG = 5;
    public static final int INACTIVE_BUTTON_FLAG = 6;

    public Color getOrange() {
        return orange;
    }

    public Color getGreyCool() {
        return greyCool;
    }

    public Color getGreyDarkCool() {
        return greyDarkCool;
    }

    public Color getWhite() {
        return white;
    }

    public Font getPrimaryFont() {
        return primaryFont;
    }

    public Font getSecondaryFont() {
        return secondaryFont;
    }
}
