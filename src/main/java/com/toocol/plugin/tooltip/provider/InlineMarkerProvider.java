package com.toocol.plugin.tooltip.provider;

import com.intellij.codeInsight.daemon.GutterName;
import com.intellij.codeInsight.daemon.LineMarkerInfo;
import com.intellij.codeInsight.daemon.LineMarkerProviderDescriptor;
import com.intellij.psi.PsiElement;
import com.toocol.plugin.tooltip.AnisEscapeTooltipIcon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author ZhaoZhe (joezane.cn@gmail.com)
 * @date 2022/8/8 17:57
 */
public class InlineMarkerProvider extends LineMarkerProviderDescriptor {
    @Override
    public @Nullable("null means disabled") @GutterName String getName() {
        return null;
    }

    @Override
    public LineMarkerInfo<?> getLineMarkerInfo(@NotNull PsiElement element) {
        return null;
    }

    @Override
    public @Nullable Icon getIcon() {
        return AnisEscapeTooltipIcon.icon();
    }
}
