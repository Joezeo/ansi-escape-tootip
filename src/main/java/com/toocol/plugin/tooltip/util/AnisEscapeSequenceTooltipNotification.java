package com.toocol.plugin.tooltip.util;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.notification.impl.NotificationsManagerImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.ui.BalloonLayoutData;
import com.intellij.ui.awt.RelativePoint;
import com.toocol.plugin.tooltip.AnisEscapeTooltipBundle;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/6 20:12
 * @version: 0.0.1
 */
public class AnisEscapeSequenceTooltipNotification {
    private static final String CHANNEL = "Anis Escape Sequence Tooltip Notification";

    private static final Logger logger = LoggerFactory.getLogger(AnisEscapeSequenceTooltipNotification.class);
    private static final AnisEscapeTooltipBundle bundle = AnisEscapeTooltipBundle.get();

    public static void showUpdate(Project project) {
        var notification = createNotification(
                bundle.message("notification.update.title", "0.0.1"),
                bundle.message("notification.update.content"),
                NotificationType.INFORMATION
        );
        showFullNotification(project, notification);
    }

    private static Notification createNotification(@NotNull String title, @NotNull String content, NotificationType type) {
        var group = NotificationGroupManager.getInstance().getNotificationGroup(CHANNEL);
        return group.createNotification(title, content, type);
    }

    private static void showFullNotification(Project project, Notification notification) {
        var ideFrame = WindowManager.getInstance().getIdeFrame(project);
        if (ideFrame == null) {
            logger.warn("Get ide frame failed, ideaFrame = null.");
            return;
        }
        var bounds = ideFrame.getComponent().getBounds();
        var target = new RelativePoint(ideFrame.getComponent(), new Point(bounds.x + bounds.width, 20));
        try {
            var balloon = NotificationsManagerImpl.createBalloon(
                    ideFrame,
                    notification,
                    true,
                    true,
                    BalloonLayoutData.fullContent(),
                    project
            );
            balloon.show(target, Balloon.Position.atLeft);
        } catch (Exception e) {
            notification.notify(project);
        }
    }
}
