package com.toocol.plugin.tooltip.visitors;

import com.intellij.codeInsight.daemon.impl.HighlightVisitor;
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.toocol.plugin.tooltip.util.Highlighter;
import com.toocol.plugin.tooltip.search.AnisEscapeSearchEngine;
import com.toocol.plugin.tooltip.search.EscapeSequence;
import org.jetbrains.annotations.NotNull;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/6 19:48
 * @version: 0.0.1
 */
public abstract class AbstractAnisEscapeVisitor implements HighlightVisitor {
    protected static final AnisEscapeSearchEngine escapeSearchEngine = AnisEscapeSearchEngine.get();
    protected static final Highlighter highlighter = Highlighter.get();

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

    protected void highlight(PsiElement element, EscapeSequence escapeSequence) {
        highlightInfoHolder.add(highlighter.highlightElement(element, escapeSequence));
    }

}
