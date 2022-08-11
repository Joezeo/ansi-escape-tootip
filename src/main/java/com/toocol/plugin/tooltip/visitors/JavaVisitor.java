package com.toocol.plugin.tooltip.visitors;

import com.intellij.codeInsight.daemon.impl.HighlightVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.util.PsiUtilCore;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/6 19:45
 * @version: 0.0.1
 */
public class JavaVisitor extends AbstractAnsiEscapeVisitor {
    private static final Set<String> supports = Arrays.stream(new String[]{
            "LITERAL_EXPRESSION"
    }).collect(Collectors.toSet());

    @Override
    public boolean suitableForFile(@NotNull PsiFile file) {
        return file instanceof PsiJavaFile;
    }

    @Override
    public void visit(@NotNull PsiElement element) {
        var elementType = PsiUtilCore.getElementType(element).toString();
        if (!supports.contains(elementType)) {
            return;
        }
        escapeSearchEngine.getEscapeSequence(element)
                .forEach(escapeSequence -> highlight(element, escapeSequence));
    }

    @Override
    public @NotNull HighlightVisitor clone() {
        return new JavaVisitor();
    }
}
