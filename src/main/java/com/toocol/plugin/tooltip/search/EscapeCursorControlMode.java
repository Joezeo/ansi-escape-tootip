package com.toocol.plugin.tooltip.search;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/7 21:46
 * @version: 0.0.1
 */
public enum EscapeCursorControlMode implements IEscapeMode {
    MOVE_CURSOR_TO_CERTAIN("Hf", "ESC[{line};{column}H\nESC[{line};{column}f\nMoves cursor to line #, column #."),
    MOVE_HOME_POSITION("H", "ESC[H\nMoves cursor to home position (0, 0)."),
    MOVE_CURSOR_UP("A", "ESC[#A\nMoves cursor up # lines."),
    MOVE_CURSOR_DOWN("B", "ESC[#B\nMoves cursor down # lines."),
    MOVE_CURSOR_RIGHT("C", "ESC[#C\nMoves cursor right # lines."),
    MOVE_CURSOR_LEFT("D", "ESC[#D\nMoves cursor left # lines."),
    MOVE_CURSOR_NEXT_LINE_HEAD("E", "ESC[#E\nMoves cursor to beginning of next line, # lines down."),
    MOVE_CURSOR_PREVIOUS_LINE_HEAD("F", "ESC[#F\nMoves cursor to beginning of previous line, # lines up."),
    MOVE_CURSOR_TO_COLUMN("G", "ESC[#G\nMoves cursor to column #."),
    REQUEST_CURSOR_POSITION("6n", "ESC[6n\nRequest cursor position (reports as ESC[#;#R)."),
    MOVE_CURSOR_ONE_LINE_UP("M", "ESC M\nMoves cursor one line up, scrolling if needed."),
    SAVE_CURSOR_POSITION_DEC("7", "ESC 7\nSave cursor position (DEC)."),
    RESTORE_CURSOR_POSITION_DEC("8", "ESC 8\nRestores the cursor to the last saved position (DEC)."),
    SAVE_CURSOR_POSITION_SCO("s", "ESC[s\nSave cursor position (SCO)."),
    RESTORE_CURSOR_POSITION_SCO("u", "ESC[u\nRestores the cursor to the last saved position (SCO)."),
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

    @Override
    public String desc() {
        return desc;
    }
}
