package com.toocol.plugin.tooltip.visitors;

import com.intellij.codeInsight.daemon.impl.HighlightVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiUtilCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.psi.KtFile;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/18 18:10
 * @version: 0.0.1
 */
public class KotlinVisitor extends AbstractAnsiEscapeVisitor {

    private static final Set<String> supports = Arrays.stream(new String[]{
            "INTEGER_CONSTANT",
            "STRING_TEMPLATE",
            "CALL_EXPRESSION",
//            "REFERENCE_EXPRESSION",
            "LITERAL_EXPRESSION"
    }).collect(Collectors.toSet());

    @Override
    public boolean suitableForFile(@NotNull PsiFile file) {
        boolean b = file instanceof KtFile;
        return b;
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
        return new KotlinVisitor();
    }
}
