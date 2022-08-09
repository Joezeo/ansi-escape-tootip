package com.toocol.plugin.tooltip.util;

import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManagerCore;
import com.intellij.openapi.extensions.PluginId;
import com.toocol.plugin.tooltip.AnisEscapeTooltipBundle;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/9 22:29
 * @version: 0.0.1
 */
public class ProjectUtils {

    public static IdeaPluginDescriptor getPlugin () {
        return PluginManagerCore.getPlugin(PluginId.getId("com.toocol.plugin.anisEscapeTooltip"));
    }

    public static String getVersion() {
        var plugin = getPlugin();
        return plugin == null ? AnisEscapeTooltipBundle.get().message("plugin.version") : plugin.getVersion();
    }

}
