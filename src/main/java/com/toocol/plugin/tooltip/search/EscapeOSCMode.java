package com.toocol.plugin.tooltip.search;

import java.util.Optional;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/26 23:03
 * @version: 0.0.1
 */
public enum EscapeOSCMode implements IEscapeMode{
    RENAMING_TAB_TITLE_0(0, "ESC]0;#BEL\nThe custom tab title will be displayed within the parameter \"#\""),
    RENAMING_TAB_TITLE_1(1, "ESC]1;#BEL\nThe custom tab title will be displayed within the parameter \"#\""),
    RENAMING_WIDOW_TITLE(2, "ESC]2;#BEL\nThe custom window title will be displayed within the parameter \"#\""),
    ECHO_WORKING_DOCUMENT(6, "ESC]6;#BEL\nUpdate the prompt to echo the current working document \"#\""),
    ECHO_WORKING_DIRECTORY(7, "ESC]6;#BEL\nUpdate the prompt to echo the current working directory \"#\""),
    ;
    public final int code;
    public final String desc;

    EscapeOSCMode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String desc() {
        return desc;
    }

    public static Optional<EscapeOSCMode> codeOf(int code) {
        for (EscapeOSCMode value : values()) {
            if (value.code == code) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
