package com.toocol.plugin.tooltip.startup;

import com.intellij.ide.AppLifecycleListener;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/6 20:06
 * @version: 0.0.1
 */
public class JavaStartupListener implements AppLifecycleListener {
    private static final Logger logger = LoggerFactory.getLogger(JavaStartupListener.class);

    @Override
    public void appFrameCreated(@NotNull List<String> commandLineArgs) {
        logger.warn("Java startup Listener.");
    }
}
