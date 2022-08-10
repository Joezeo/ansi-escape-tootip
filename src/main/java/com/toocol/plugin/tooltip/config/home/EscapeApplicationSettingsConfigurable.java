package com.toocol.plugin.tooltip.config.home;

import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.util.NlsContexts;
import com.toocol.plugin.tooltip.AnisEscapeTooltipBundle;
import com.toocol.plugin.tooltip.config.custom.AnisEscapeCustomSettingsConfig;
import com.toocol.plugin.tooltip.config.ui.ColorDescriptionPanel;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/9 22:51
 * @version: 0.0.1
 */
@SuppressWarnings("all")
public class EscapeApplicationSettingsConfigurable implements SearchableConfigurable {
    private static AnisEscapeCustomSettingsConfig config;

    private final EditorColorsScheme editorColorsScheme;
    private ColorDescriptionPanel colorDescriptionPanel;

    public EscapeApplicationSettingsConfigurable() {
        this.editorColorsScheme = EditorColorsManager.getInstance().getGlobalScheme();
    }

    public static void initialize(@NotNull Project project) {
        config = AnisEscapeCustomSettingsConfig.getSettings(project);
    }

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return AnisEscapeTooltipBundle.get().message("settings.form.title");
    }

    @Override
    public @NotNull @NonNls String getId() {
        return AnisEscapeTooltipBundle.get().message("settings.form.configurable");
    }

    @Override
    public @Nullable JComponent createComponent() {
        colorDescriptionPanel = new ColorDescriptionPanel();
        return colorDescriptionPanel.getPanel();
    }

    @Override
    public boolean isModified() {
        return true;
    }

    @Override
    public void apply() throws ConfigurationException {
        config.storeColorInfo(colorDescriptionPanel.getSelectedBackground(), colorDescriptionPanel.getSelectedForeground());
        colorDescriptionPanel.apply(config.getAttributesDescription(), editorColorsScheme);
    }
}
