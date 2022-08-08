package com.toocol.plugin.tooltip;

import com.intellij.ui.IconManager;

import javax.swing.*;

/**
 * @author ZhaoZhe (joezane.cn@gmail.com)
 * @date 2022/8/8 17:52
 */
public class AnisEscapeTooltipIcon {
    public static Icon icon() {
        return IconManager.getInstance().getIcon("icons/icon.svg", AnisEscapeTooltipIcon.class);
    }
}
