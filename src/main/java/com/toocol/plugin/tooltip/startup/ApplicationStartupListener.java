package com.toocol.plugin.tooltip.startup;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import com.toocol.plugin.tooltip.util.Highlighter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/6 20:06
 * @version: 0.0.1
 */
public class ApplicationStartupListener implements StartupActivity {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationStartupListener.class);

    @Override
    public void runActivity(@NotNull Project project) {
        logger.warn("IntelliJ Idea startup.");
        Highlighter.initialize(project);
    }
}
