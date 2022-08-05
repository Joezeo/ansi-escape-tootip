package com.toocol.plugin.tooltip;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/5 23:41
 * @version: 0.0.1
 */
public class ExtractEscapeCodeSequenceAction extends AnAction {
    private static final Logger logger = LoggerFactory.getLogger(ExtractEscapeCodeSequenceAction.class);

    @Override
    public void actionPerformed(AnActionEvent event) {
        Editor editor = event.getData(PlatformDataKeys.EDITOR);
        logger.warn("trigger action.");
    }

}
