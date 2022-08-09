package com.toocol.plugin.tooltip.search;

import java.util.Optional;

import static com.toocol.plugin.tooltip.search.ColorClut.*;

/**
 * @author ZhaoZhe (joezane.cn@gmail.com)
 * @date 2022/8/8 20:57
 */

public enum EscapeColor8To16Mode implements IEscapeMode {
    FOREGROUND_BLACK(30, Black),
    FOREGROUND_RED(31, Red),
    FOREGROUND_GREEN(32, Green),
    FOREGROUND_YELLOW(33, Yellow),
    FOREGROUND_BLUE(34, Blue),
    FOREGROUND_MAGENTA(35, Magenta),
    FOREGROUND_CYAN(36, Cyan),
    FOREGROUND_WHITE(37, White),
    FOREGROUND_DEFAULT(39, White),
    BACKGROUND_BLACK(40, Black),
    BACKGROUND_RED(41, Red),
    BACKGROUND_GREEN(42, Green),
    BACKGROUND_YELLOW(43, Yellow),
    BACKGROUND_BLUE(44, Blue),
    BACKGROUND_MAGENTA(45, Magenta),
    BACKGROUND_CYAN(46, Cyan),
    BACKGROUND_WHITE(47, White),
    BACKGROUND_DEFAULT(49, Black),
    ;

    public final int colorCode;
    public final ColorClut color;

    EscapeColor8To16Mode(int colorCode, ColorClut color) {
        this.colorCode = colorCode;
        this.color = color;
    }
    
    public static Optional<EscapeColor8To16Mode> codeOf(int code) {
        for (EscapeColor8To16Mode mode : values()) {
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
                        "The color is set by the user, but have commonly defined meanings.",
                colorCode, colorCode < 40 ? "foreground" : "background", color.name);
    }
}
