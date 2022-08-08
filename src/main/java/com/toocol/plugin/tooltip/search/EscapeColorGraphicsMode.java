package com.toocol.plugin.tooltip.search;

enum EscapeColorGraphicsMode implements IEscapeMode {
    SET_CURSOR_POSITION(-1, "ESC[1;34;{...}m\nSet graphics modes for cell, separated by semicolon (;)."),
    RESET_ALL_MODE(0, "ESC[0m\nReset all modes (styles and colors)."),
    BOLD_MODE(1, "ESC[1m\nSet bold mode."),
    DIM_FAINT_MODE(2, "ESC[2m\nSet dim/faint mode."),
    RESET_BOLD_DIM_FAINT(22, "ESC[22m\nReset bold/dim/faint mode.."),
    ITALIC_MODE(3, "ESC[3m\nSet italic mode."),
    RESET_ITALIC(23, "ESC[23m\nReset italic mode."),
    UNDERLINE_MODE(4, "ESC[4m\nSet underline mode."),
    RESET_UNDERLINE(24, "ESC[24m\nReset underline mode."),
    BLINKING_MODE(5, "ESC[5m\nSet blinking mode."),
    RESET_BLINKING(25, "ESC[25m\nReset blinking mode."),
    INVERSE_REVERSE_MODE(7, "ESC[7m\nSet inverse/reverse mode."),
    RESET_INVERSE_REVERSE(27, "ESC[27m\nReset inverse/reverse mode."),
    HIDDEN_VISIBLE_MODE(8, "ESC[8m\nSet hidden/visible mode."),
    RESET_HIDDEN_VISIBLE(28, "ESC[28m\nReset hidden/visible mode."),
    STRIKETHROUGH_MODE(9, "ESC[9m\nSet strikethrough mode."),
    RESET_STRIKETHROUGH(29, "ESC[29m\nReset strikethrough mode."),
    ;
    public final int code;
    public final String desc;

    EscapeColorGraphicsMode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static EscapeColorGraphicsMode codeOf(int code) {
        for (EscapeColorGraphicsMode mode : values()) {
            if (mode.code == code) {
                return mode;
            }
        }
        return null;
    }

    @Override
    public String desc() {
        return desc;
    }
}
