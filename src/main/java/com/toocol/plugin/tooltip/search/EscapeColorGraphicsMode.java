package com.toocol.plugin.tooltip.search;

import java.util.Optional;

public enum EscapeColorGraphicsMode implements IEscapeMode {
    SET_CURSOR_POSITION(-1, "ESC[1;34;{...}m\nSet graphics modes for cell, separated by semicolon (;)."),
    RESET_ALL_MODE(0, "ESC[0m\nReset <b>all</b> modes (styles and colors)."),
    BOLD_MODE(1, "ESC[1m\nSet <b>bold</b> mode."),
    DIM_FAINT_MODE(2, "ESC[2m\nSet <b>dim/faint</b> mode."),
    RESET_BOLD_DIM_FAINT(22, "ESC[22m\nReset <b>bold/dim/faint</b> mode."),
    ITALIC_MODE(3, "ESC[3m\nSet <b>italic</b> mode."),
    RESET_ITALIC(23, "ESC[23m\nReset <b>italic<b/> mode."),
    UNDERLINE_MODE(4, "ESC[4m\nSet <b>underline</b> mode."),
    RESET_UNDERLINE(24, "ESC[24m\nReset <b>underline</b> mode."),
    BLINKING_MODE(5, "ESC[5m\nSet <b>blinking</b> mode."),
    RESET_BLINKING(25, "ESC[25m\nReset <b>blinking</b> mode."),
    INVERSE_REVERSE_MODE(7, "ESC[7m\nSet <b>inverse/reverse</b> mode."),
    RESET_INVERSE_REVERSE(27, "ESC[27m\nReset <b>inverse/reverse</b> mode."),
    HIDDEN_VISIBLE_MODE(8, "ESC[8m\nSet <b>hidden/visible</b> mode."),
    RESET_HIDDEN_VISIBLE(28, "ESC[28m\nReset <b>hidden/visible</b> mode."),
    STRIKETHROUGH_MODE(9, "ESC[9m\nSet <b>strikethrough<b/> mode."),
    RESET_STRIKETHROUGH(29, "ESC[29m\nReset <b>strikethrough</b> mode."),
    ;
    public final int code;
    public final String desc;

    EscapeColorGraphicsMode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Optional<EscapeColorGraphicsMode> codeOf(int code) {
        for (EscapeColorGraphicsMode mode : values()) {
            if (mode.code == code) {
                return Optional.of(mode);
            }
        }
        return Optional.empty();
    }

    @Override
    public String desc() {
        return desc;
    }
}
