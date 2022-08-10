package com.toocol.plugin.tooltip.config.custom;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.project.Project;
import com.intellij.ui.Gray;
import com.intellij.util.xmlb.XmlSerializerUtil;
import com.toocol.plugin.tooltip.AnisEscapeTooltipBundle;
import com.toocol.plugin.tooltip.config.ui.AnisEscapeAttributesDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/9 23:21
 * @version: 0.0.1
 */
@State(
        name = "AnisEscapeCustomSettingsConfig",
        storages = {
                @Storage("anis-escape-config.xml")
        }
)
public class AnisEscapeCustomSettingsConfig implements PersistentStateComponent<AnisEscapeCustomSettingsConfig.PersistentState> {
    public static final Color defaultBackgroundColor = Gray._54;
    public static final Color defaultForegroundColor = Gray._130;

    public static Color backgroundColor = defaultBackgroundColor;
    public static Color foregroundColor = defaultForegroundColor;

    private final AnisEscapeTooltipBundle bundle = AnisEscapeTooltipBundle.get();

    public AnisEscapeAttributesDescription attributesDescription;
    private PersistentState persistentState;

    public AnisEscapeCustomSettingsConfig() {
        setDefault();
    }

    public static AnisEscapeCustomSettingsConfig getSettings(Project project) {
        return project.getService(AnisEscapeCustomSettingsConfig.class);
    }

    @Override
    public @Nullable AnisEscapeCustomSettingsConfig.PersistentState getState() {
        return persistentState;
    }

    @Override
    public void loadState(@NotNull PersistentState state) {
        XmlSerializerUtil.copyBean(state, this.persistentState);
        backgroundColor = persistentState.getBackgroundColor();
        foregroundColor = persistentState.getForegroundColor();
        updateAttributes(state);
    }

    public void updateAttributes(PersistentState state) {
        attributesDescription.setBackgroundColor(state.getBackgroundColor());
        attributesDescription.setForegroundColor(state.getForegroundColor());
    }

    public void storeColorInfo(Color backgroundColor, Color foregroundColor) {
        persistentState.storeColorInfo(backgroundColor, foregroundColor);
        updateAttributes(persistentState);
        AnisEscapeCustomSettingsConfig.backgroundColor = persistentState.getBackgroundColor();
        AnisEscapeCustomSettingsConfig.foregroundColor = persistentState.getForegroundColor();
    }

    public void setDefault() {
        persistentState = new PersistentState();
        persistentState.background.red = defaultBackgroundColor.getRed();
        persistentState.background.green = defaultBackgroundColor.getGreen();
        persistentState.background.blue = defaultBackgroundColor.getBlue();
        persistentState.foreground.red = defaultForegroundColor.getRed();
        persistentState.foreground.green = defaultForegroundColor.getGreen();
        persistentState.foreground.blue = defaultForegroundColor.getBlue();
        backgroundColor = persistentState.getBackgroundColor();
        foregroundColor = persistentState.getForegroundColor();

        TextAttributes attributes = new TextAttributes();
        attributes.setBackgroundColor(backgroundColor);
        TextAttributesKey textAttributesKey = TextAttributesKey.createTextAttributesKey(bundle.message("settings.form.external.id"));
        String group = bundle.message("settings.form.group");
        attributesDescription = new AnisEscapeAttributesDescription(group, group, attributes,
                textAttributesKey, EditorColorsManager.getInstance().getGlobalScheme());
    }

    public AnisEscapeAttributesDescription getAttributesDescription() {
        return attributesDescription;
    }

    static class PersistentState {

        public PersistentColor background = new PersistentColor();
        public PersistentColor foreground = new PersistentColor();

        public void storeColorInfo(Color background, Color foreground) {
            this.background.red = background.getRed();
            this.background.green = background.getGreen();
            this.background.blue = background.getBlue();
            this.foreground.red = foreground.getRed();
            this.foreground.green = foreground.getGreen();
            this.foreground.blue = foreground.getBlue();
        }

        public Color getBackgroundColor() {
            return background.getColor();
        }

        public Color getForegroundColor() {
            return foreground.getColor();
        }
    }

    @SuppressWarnings("all")
    static class PersistentColor {
        public Integer red;
        public Integer green;
        public Integer blue;

        public Color getColor() {
            return new Color(red, green, blue);
        }
    }
}
