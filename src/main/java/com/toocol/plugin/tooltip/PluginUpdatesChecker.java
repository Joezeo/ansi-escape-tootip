package com.toocol.plugin.tooltip;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import com.toocol.plugin.tooltip.notification.AnisEscapeSequenceTooltipNotification;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/6 20:10
 * @version: 0.0.1
 */
public class PluginUpdatesChecker implements StartupActivity.Background {
    private static final Logger logger = LoggerFactory.getLogger(PluginUpdatesChecker.class);

    @Override
    public void runActivity(@NotNull Project project) {
        logger.warn("Check plugin update project = {}", project);
        checkOnProjectOpened(project);
    }

    public void checkOnProjectOpened(@NotNull Project project) {
        AnisEscapeSequenceTooltipNotification.showUpdate(project);
    }
}
