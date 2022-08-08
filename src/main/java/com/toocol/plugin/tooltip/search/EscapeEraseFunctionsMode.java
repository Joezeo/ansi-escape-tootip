package com.toocol.plugin.tooltip.search;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/7 22:13
 * @version: 0.0.1
 */
public enum EscapeEraseFunctionsMode implements IEscapeMode {
    ERASE_IN_DISPLAY("J", "ESC[J\nErase in display (same as ESC[0J)."),
    ERASE_CURSOR_LINE_TO_END("0J", "ESC[0J\nErase from cursor until end of screen."),
    ERASE_CURSOR_LINE_TO_BEGINNING("1J", "ESC[1J\nErase from cursor to beginning of screen."),
    ERASE_SCREEN("2J", "ESC[2J\nErase entire screen."),
    ERASE_SAVED_LINE("3J", "ESC[3J\nErase saved lines."),
    ERASE_IN_LINE("K", "ESC[K\nErase in line (same as ESC[0K)."),
    ERASE_CURSOR_TO_LINE_END("0K", "ESC[0K\nErase from cursor to end of line."),
    ERASE_CURSOR_TO_LINE_START("1K", "ESC[1K\nErase start of line to the cursor."),
    ERASE_LINE("2K", "ESC[2K\nErase the entire line."),
    ;
    public final String code;
    public final String desc;

    EscapeEraseFunctionsMode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public EscapeEraseFunctionsMode codeOf(String code) {
        for (EscapeEraseFunctionsMode mode : values()) {
            if (mode.code.equals(code)) {
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
