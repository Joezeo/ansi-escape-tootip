package com.toocol.plugin.tooltip.search;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/7 22:13
 * @version: 0.0.1
 */
public enum EscapeEraseFunctionsMode implements IEscapeMode {
    ERASE_IN_DISPLAY("J", "ESC[J\n<b>Erase in display</b> (same as ESC[0J)."),
    ERASE_CURSOR_LINE_TO_END("0J", "ESC[0J\nErase <b>from cursor</b> until <b>end of screen</b>."),
    ERASE_CURSOR_LINE_TO_BEGINNING("1J", "ESC[1J\nErase <b>from cursor</b> to <b>beginning of screen</b>."),
    ERASE_SCREEN("2J", "ESC[2J\nErase <b>entire screen</b>."),
    ERASE_SAVED_LINE("3J", "ESC[3J\nErase <b>saved lines</b>."),
    ERASE_IN_LINE("K", "ESC[K\nErase <b>in line</b> (same as ESC[0K)."),
    ERASE_CURSOR_TO_LINE_END("0K", "ESC[0K\nErase <b>from cursor</b> to <b>end of line</b>."),
    ERASE_CURSOR_TO_LINE_START("1K", "ESC[1K\nErase <b>start of line to the cursor</b>."),
    ERASE_LINE("2K", "ESC[2K\nErase the <b>entire line</b>."),
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
