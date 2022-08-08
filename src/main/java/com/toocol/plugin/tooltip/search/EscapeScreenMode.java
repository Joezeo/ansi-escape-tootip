package com.toocol.plugin.tooltip.search;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/7 21:08
 * @version: 0.0.1
 */
public enum EscapeScreenMode implements IEscapeMode{
    MONOCHROME_40_25(0, "<b>40 x 25</b> monochrome (text)."),
    COLOR_4_40_25(1, "<b>40 x 25</b> color (4-color text)."),
    MONOCHROME_80_25(2, "<b>80 x 25</b> monochrome (text)."),
    COLOR_4_80_25(3, "<b>80 x 25</b> color (4-color text)."),
    COLOR_4_320_200(4, "<b>320 x 200</b> (4-color graphics)."),
    MONOCHROME_320_200(5, "<b>320 x 200</b> monochrome (graphics)."),
    MONOCHROME_640_200(6, "<b>640 x 200</b> monochrome (graphics)."),
    ENABLE_LINE_WRAPPING(7, "Enables <b>line wrapping</b>."),
    COLOR_16_320_200(13, "<b>320 x 200</b> color (16-color graphics)."),
    COLOR_16_640_200(14, "<b>640 x 200</b> color (16-color graphics)."),
    MONOCHROME_640_350(15, "<b>640 x 350</b> monochrome (2-color graphics)."),
    COLOR_16_640_350(16, "<b>640 x 350</b> color (16-color graphics)."),
    MONOCHROME_640_480(17, "<b>640 x 480</b> monochrome (2-color graphics)."),
    COLOR_640_480(18, "<b>640 x 480</b> color (16-color graphics)."),
    COLOR_256_320_200(19, "<b>320 x 200</b> color (256-color graphics)."),
    ;
    public final int code;
    public final String desc;

    EscapeScreenMode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static EscapeScreenMode codeOf(int code) {
        for (EscapeScreenMode mode : values()) {
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
