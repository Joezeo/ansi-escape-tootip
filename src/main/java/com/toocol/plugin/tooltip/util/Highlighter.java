package com.toocol.plugin.tooltip.util;

import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.codeInsight.daemon.impl.HighlightInfoType;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.psi.PsiElement;
import com.intellij.ui.ColorUtil;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;
import com.toocol.plugin.tooltip.search.EscapeSequence;

/**
 * @author ZhaoZhe (joezane.cn@gmail.com)
 * @date 2022/8/8 14:52
 */
public class Highlighter {
    private static final Highlighter instance = new Highlighter();

    public static Highlighter get() {
        return instance;
    }

    private final HighlightInfoType.HighlightInfoTypeImpl highlightElement = new HighlightInfoType.HighlightInfoTypeImpl(
            HighlightSeverity.INFORMATION,
            DefaultLanguageHighlighterColors.CONSTANT
    );

    public HighlightInfo highlightElement(PsiElement element, EscapeSequence escapeSequence) {
        var builder = getHighlightInfoBuilder();
        var strBuilder = new AnisStringBuilder();
        strBuilder
                .append("<h3>")
                .append(escapeSequence.escapeSequence.replace("\\u001b", "ESC"))
                .append("</h3>")
                .append("<hr/>").crlf()
                .append("contains separated escape sequences: ")
                .append("<ul>");
        escapeSequence.getEscapeModes().forEach(escapeMode -> strBuilder.append("<li>").append(escapeMode.tooltip()).append("</li>"));
        strBuilder.append("</ul>");
        builder.escapedToolTip(escapeSequence.getEscapeModes().size() == 0 ? "No such anis code sequence." : strBuilder.toString());
        return builder
                .range(element, escapeSequence.start, escapeSequence.end)
                .create();
    }

    private HighlightInfo.Builder getHighlightInfoBuilder() {
        return HighlightInfo.newHighlightInfo(highlightElement)
                .textAttributes(getAttributesFlyweight());
    }

    private TextAttributes getAttributesFlyweight() {
        var color = JBColor.CYAN;
        var attributes = new TextAttributes();
        var background = EditorColorsManager.getInstance().getGlobalScheme().getDefaultBackground();
        var mix = ColorUtil.mix(background, color, color.getAlpha() / 255.0);

        return TextAttributes.fromFlyweight(
                attributes
                        .getFlyweight()
                        .withBackground(mix)
                        .withForeground((ColorUtil.isDark(mix)) ? Gray._254 : Gray._1)
        );
    }

    private Highlighter() {

    }
}
