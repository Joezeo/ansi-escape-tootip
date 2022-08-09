package com.toocol.plugin.tooltip.config.custom;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
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

    private PersistentState persistentState;
    private AnisEscapeAttributesDescription attributesDescription;
    private Color backgroundColor;
    private Color foregroundColor;

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
        XmlSerializerUtil.copyBean(persistentState, this.persistentState);
        backgroundColor = persistentState.getBackgroundColor();
        foregroundColor = persistentState.getForegroundColor();
    }

    public void setDefault() {
        persistentState = new PersistentState();
        persistentState.background.red = 54;
        persistentState.background.green = 54;
        persistentState.background.blue = 54;
        persistentState.foreground.red = 130;
        persistentState.foreground.green = 130;
        persistentState.foreground.blue = 130;
        backgroundColor = persistentState.getBackgroundColor();
        foregroundColor = persistentState.getForegroundColor();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    static class PersistentState {

        public PersistentColor background = new PersistentColor();
        public PersistentColor foreground = new PersistentColor();

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
