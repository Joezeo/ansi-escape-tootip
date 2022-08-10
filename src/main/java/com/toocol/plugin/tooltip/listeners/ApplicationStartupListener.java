package com.toocol.plugin.tooltip.listeners;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import com.toocol.plugin.tooltip.config.home.EscapeApplicationSettingsConfigurable;
import com.toocol.plugin.tooltip.util.Highlighter;
import org.jetbrains.annotations.NotNull;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/6 20:06
 * @version: 0.0.1
 */
public class ApplicationStartupListener implements StartupActivity {

    @Override
    public void runActivity(@NotNull Project project) {
        EscapeApplicationSettingsConfigurable.initialize(project);
    }

}
