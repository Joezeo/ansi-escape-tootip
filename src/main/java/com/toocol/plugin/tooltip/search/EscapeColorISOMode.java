package com.toocol.plugin.tooltip.search;

import java.util.Optional;

import static com.toocol.plugin.tooltip.search.ColorClut.*;

public enum EscapeColorISOMode implements IEscapeMode {
    FOREGROUND_BRIGHT_BLACK(90, Black),
    FOREGROUND_BRIGHT_RED(91, Red),
    FOREGROUND_BRIGHT_GREEN(92, Green),
    FOREGROUND_BRIGHT_YELLOW(93, Yellow),
    FOREGROUND_BRIGHT_BLUE(94, Blue),
    FOREGROUND_BRIGHT_MAGENTA(95, Magenta),
    FOREGROUND_BRIGHT_CYAN(96, Cyan),
    FOREGROUND_BRIGHT_WHITE(97, White),
    BACKGROUND_BRIGHT_BLACK(100, Black),
    BACKGROUND_BRIGHT_RED(101, Red),
    BACKGROUND_BRIGHT_GREEN(102, Green),
    BACKGROUND_BRIGHT_YELLOW(103, Yellow),
    BACKGROUND_BRIGHT_BLUE(104, Blue),
    BACKGROUND_BRIGHT_MAGENTA(105, Magenta),
    BACKGROUND_BRIGHT_CYAN(106, Cyan),
    BACKGROUND_BRIGHT_WHITE(107, White),
    ;
    public final int colorCode;
    public final ColorClut color;

    EscapeColorISOMode(int colorCode, ColorClut color) {
        this.colorCode = colorCode;
        this.color = color;
    }

    public static Optional<EscapeColorISOMode> codeOf(int code) {
        for (EscapeColorISOMode mode : values()) {
            if (mode.colorCode == code) {
                return Optional.of(mode);
            }
        }
        return Optional.empty();
    }

    @Override
    public String desc() {
        return String.format("ESC[%dm\n" +
                        "Set <b>%s</b> color to <b>%s</b>.\n" +
                        "The color is set by the user, but have commonly defined meanings.\n" +
                        "Provides bright versions of the ISO colors, without the need to use the bold modifier.",
                colorCode, colorCode < 100 ? "foreground" : "background",  "Bright " + color.name);
    }
}