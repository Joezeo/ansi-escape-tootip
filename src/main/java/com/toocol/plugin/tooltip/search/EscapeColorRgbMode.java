package com.toocol.plugin.tooltip.search;

/**
 * @author ZhaoZhe (joezane.cn@gmail.com)
 * @date 2022/8/9 15:18
 */
public enum EscapeColorRgbMode implements IEscapeMode {
    COLOR_RGB_MODE
    ;
    private boolean foreground;

    public EscapeColorRgbMode setForeground(boolean foreground) {
        this.foreground = foreground;
        return this;
    }

    @Override
    public String desc() {
        return String.format("ESC[%d;2;#;#;#m\n" +
                        "Set <b>%s</b> to rgb color <b>(#, #, #)</b>.",
                foreground ? 38 : 48, foreground ? "foreground" : "background"
        );
    }
}
