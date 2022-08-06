package com.toocol.plugin.tooltip.visitors;

import com.intellij.codeInsight.daemon.impl.HighlightVisitor;
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/6 19:48
 * @version: 0.0.1
 */
public abstract class AbstractAnisEscapeVisitor implements HighlightVisitor {
    private HighlightInfoHolder highlightInfoHolder = null;

    @NotNull
    public abstract HighlightVisitor clone();

    @Override
    public boolean analyze(@NotNull PsiFile file, boolean updateWholeFile, @NotNull HighlightInfoHolder holder, @NotNull Runnable action) {
        highlightInfoHolder = holder;
        try {
            action.run();
        } catch (Exception e) {
            highlightInfoHolder = null;
        }
        return true;
    }

}
