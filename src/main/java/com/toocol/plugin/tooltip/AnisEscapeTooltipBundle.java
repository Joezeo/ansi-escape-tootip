package com.toocol.plugin.tooltip;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/6 20:18
 * @version: 0.0.1
 */
public class AnisEscapeTooltipBundle extends DynamicBundle {
    private static final String BUNDLE = "messages.AnisEscapeTooltipBundle";
    private static final AnisEscapeTooltipBundle instance = new AnisEscapeTooltipBundle(BUNDLE);

    private AnisEscapeTooltipBundle(@NotNull String pathToBundle) {
        super(pathToBundle);
    }

    public static AnisEscapeTooltipBundle get() {
        return instance;
    }

    public String message(@PropertyKey(resourceBundle = BUNDLE) String key, Object... any) {
        return getMessage(key, any);
    }
}
