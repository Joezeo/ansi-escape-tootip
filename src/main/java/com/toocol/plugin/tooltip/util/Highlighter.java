package com.toocol.plugin.tooltip.util;

import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.codeInsight.daemon.impl.HighlightInfoType;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.ui.ColorUtil;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;
import com.toocol.plugin.tooltip.config.custom.AnisEscapeCustomSettingsConfig;
import com.toocol.plugin.tooltip.search.ColorClut;
import com.toocol.plugin.tooltip.search.EscapeSequence;

import java.awt.*;

/**
 * @author ZhaoZhe (joezane.cn@gmail.com)
 * @date 2022/8/8 14:52
 */
@SuppressWarnings("all")
public class Highlighter {
    private static Highlighter instance;

    public static void initialize(Project project) {
        instance = new Highlighter(project);
    }

    private final AnisEscapeCustomSettingsConfig config;

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
                .append(escapeSequence.escapeSequence.replace("\\u001b", "ESC").replace("\\u001B", "ESC"))
                .append("</h3>")
                .append("<hr/>").crlf()
                .append("Contains separated escape sequences: ")
                .append("<ul>");
        escapeSequence.getTooltips().forEach(tooltip -> strBuilder.append("<li>").append(tooltip).append("</li>"));
        strBuilder.append("</ul>");
        builder.escapedToolTip(escapeSequence.getTooltips().size() == 0 ? "No such anis escape code sequence." : strBuilder.toString());
        return builder
                .range(element, escapeSequence.start, escapeSequence.end)
                .create();
    }

    private HighlightInfo.Builder getHighlightInfoBuilder() {
        return HighlightInfo.newHighlightInfo(highlightElement)
                .textAttributes(getAttributesFlyweight());
    }

    private TextAttributes getAttributesFlyweight() {
        var attributes = new TextAttributes();
        var background = EditorColorsManager.getInstance().getGlobalScheme().getDefaultBackground();
        var mix = ColorUtil.mix(background, config.getBackgroundColor(), config.getBackgroundColor().getAlpha() / 255.0);

        return TextAttributes.fromFlyweight(
                attributes
                        .getFlyweight()
                        .withEffectType(EffectType.BOXED)
                        .withBackground(mix)
                        .withForeground(config.getForegroundColor())
        );
    }

    private Highlighter(Project project) {
        config = AnisEscapeCustomSettingsConfig.getSettings(project);
    }
}
