package com.toocol.plugin.tooltip.visitors;

import com.intellij.codeInsight.daemon.impl.HighlightVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/6 19:45
 * @version: 0.0.1
 */
public class JavaVisitor extends AbstractAnisEscapeVisitor {
    private static final Logger logger = LoggerFactory.getLogger(JavaVisitor.class);

    @Override
    public boolean suitableForFile(@NotNull PsiFile file) {
        logger.warn("suitableForFIle: " + file);
        return true;
    }

    @Override
    public void visit(@NotNull PsiElement element) {
        logger.warn("visit: " + element);
    }

    @Override
    public @NotNull HighlightVisitor clone() {
        return new JavaVisitor();
    }
}
