package com.toocol.plugin.tooltip.visitors;

import com.intellij.codeInsight.daemon.impl.HighlightVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/6 19:45
 * @version: 0.0.1
 */
public class TextVisitor extends AbstractAnisEscapeVisitor {

    private static final Pattern filePattern = Pattern.compile(".*\\.(txt|log|rst)$");

    @Override
    public boolean suitableForFile(@NotNull PsiFile file) {
        return filePattern.matcher(file.getName()).find();
    }

    @Override
    public void visit(@NotNull PsiElement element) {
        escapeSearchEngine.getEscapeSequence(element)
                .forEach(escapeSequence -> highlight(element, escapeSequence));
    }

    @Override
    public @NotNull HighlightVisitor clone() {
        return new TextVisitor();
    }
}
