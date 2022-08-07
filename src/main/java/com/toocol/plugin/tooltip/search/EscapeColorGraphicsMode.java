package com.toocol.plugin.tooltip.search;

enum EscapeColorGraphicsMode {
    RESET_ALL_MODE(0, "Reset all modes (styles and colors)."),
    BOLD_MODE(1, "Set bold mode."),
    DIM_FAINT_MODE(2, "Set dim/faint mode."),
    RESET_BOLD_DIM_FAINT(22, "Reset bold/dim/faint mode.."),
    ITALIC_MODE(3, "Set italic mode."),
    RESET_ITALIC(23, "Reset italic mode."),
    UNDERLINE_MODE(4, "Set underline mode."),
    RESET_UNDERLINE(24, "Reset underline mode."),
    BLINKING_MODE(5, "Set blinking mode."),
    RESET_BLINKING(25, "Reset blinking mode."),
    INVERSE_REVERSE_MODE(7, "Set inverse/reverse mode."),
    RESET_INVERSE_REVERSE(27, "Reset inverse/reverse mode."),
    HIDDEN_VISIBLE_MODE(8, "Set hidden/visible mode."),
    RESET_HIDDEN_VISIBLE(28, "Reset hidden/visible mode."),
    STRIKETHROUGH_MODE(9, "Set strikethrough mode."),
    RESET_STRIKETHROUGH(29, "Reset strikethrough mode."),
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
}
