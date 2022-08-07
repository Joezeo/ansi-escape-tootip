package com.toocol.plugin.tooltip.search;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/7 21:46
 * @version: 0.0.1
 */
public enum EscapeCursorControlMode {
    MOVE_HOME_POSITION("H", "moves cursor to home position (0, 0)."),
    MOVE_CURSOR_UP("A", "moves cursor up # lines (# represent a num)."),
    MOVE_CURSOR_DOWN("B", "moves cursor down # lines (# represent a num)."),
    MOVE_CURSOR_RIGHT("C", "moves cursor right # lines (# represent a num)."),
    MOVE_CURSOR_LEFT("D", "moves cursor left # lines (# represent a num)."),
    MOVE_CURSOR_NEXT_LINE_HEAD("E", "moves cursor to beginning of next line, # lines down (# represent a num)."),
    MOVE_CURSOR_PREVIOUS_LINE_HEAD("F", "moves cursor to beginning of previous line, # lines up (# represent a num)."),
    MOVE_CURSOR_TO_COLUMN("G", "moves cursor to column # (# represent a num)."),
    REQUEST_CURSOR_POSITION("6n", "request cursor position (reports as ESC[#;#R) (# represent a num)."),
    MOVE_CURSOR_ONE_LINE_UP("M", "moves cursor one line up, scrolling if needed."),
    SAVE_CURSOR_POSITION_DEC("7", "save cursor position (DEC)."),
    RESTORE_CURSOR_POSITION_DEC("8", "restores the cursor to the last saved position (DEC)."),
    SAVE_CURSOR_POSITION_SCO("s", "save cursor position (SCO)."),
    RESTORE_CURSOR_POSITION_SCO("u", "restores the cursor to the last saved position (SCO)."),
    ;
    public final String code;
    public final String desc;

    EscapeCursorControlMode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public EscapeCursorControlMode codeOf(String code) {
        for (EscapeCursorControlMode mode : values()) {
            if (mode.code.equals(code)) {
                return mode;
            }
        }
        return null;
    }
}
