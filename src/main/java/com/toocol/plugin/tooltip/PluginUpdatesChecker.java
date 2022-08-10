package com.toocol.plugin.tooltip;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import com.toocol.plugin.tooltip.util.AnisEscapeSequenceTooltipNotification;
import org.jetbrains.annotations.NotNull;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/6 20:10
 * @version: 0.0.1
 */
public class PluginUpdatesChecker implements StartupActivity.Background {

    @Override
    public void runActivity(@NotNull Project project) {

    }

    public void checkOnProjectOpened(@NotNull Project project) {
        AnisEscapeSequenceTooltipNotification.showUpdate(project);
    }
}
