package com.toocol.plugin.tooltip.config.ui;

import com.intellij.application.options.colors.ColorAndFontDescription;
import com.intellij.application.options.colors.OptionsPanelImpl;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.colors.EditorSchemeAttributeDescriptor;
import com.intellij.ui.ColorPanel;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.intellij.util.EventDispatcher;
import com.intellij.util.ui.JBUI;
import com.toocol.plugin.tooltip.config.custom.AnisEscapeCustomSettingsConfig;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author ：JoeZane (joezane.cn@gmail.com)
 * @date: 2022/8/10 0:29
 * @version:
 */
@SuppressWarnings("all")
public class ColorDescriptionPanel extends JPanel implements OptionsPanelImpl.ColorDescriptionPanel {
    private final EventDispatcher<Listener> dispatcher = EventDispatcher.create(Listener.class);

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel;
    private JLabel background;
    private ColorPanel backgroundChooser;
    private JLabel foreground;
    private ColorPanel foregroundChooser;

    public ColorDescriptionPanel() {
        super(new BorderLayout());
        initComponents();
        add(panel, BorderLayout.CENTER);
        setBorder(JBUI.Borders.empty(4, 0, 4, 4));

        ActionListener actionListener = e -> {
            dispatcher.getMulticaster().onSettingsChanged(e);
        };

        backgroundChooser.setEnabled(true);
        foregroundChooser.setEnabled(true);
        backgroundChooser.setEditable(true);
        foregroundChooser.setEditable(true);
        backgroundChooser.addActionListener(actionListener);
        foregroundChooser.addActionListener(actionListener);

        backgroundChooser.setSelectedColor(AnisEscapeCustomSettingsConfig.backgroundColor);
        foregroundChooser.setSelectedColor(AnisEscapeCustomSettingsConfig.foregroundColor);
    }

    private void createUIComponents() {
    }

    @Override
    public @NotNull JComponent getPanel() {
        return this;
    }

    @Override
    public void resetDefault() {
        backgroundChooser.setSelectedColor(AnisEscapeCustomSettingsConfig.defaultBackgroundColor);
        foregroundChooser.setSelectedColor(AnisEscapeCustomSettingsConfig.defaultForegroundColor);
    }

    @Override
    public void reset(@NotNull EditorSchemeAttributeDescriptor description) {
        if (description instanceof ColorAndFontDescription) {
            var descr = (ColorAndFontDescription) description;
            backgroundChooser.setSelectedColor(descr.getBackgroundColor());
            foregroundChooser.setSelectedColor(descr.getForegroundColor());
        }
    }

    @Override
    public void apply(@NotNull EditorSchemeAttributeDescriptor descriptor, EditorColorsScheme scheme) {
        reset(descriptor);
    }

    @Override
    public void addListener(@NotNull Listener listener) {

    }

    public Color getSelectedBackground() {
        return backgroundChooser.getSelectedColor();
    }

    public Color getSelectedForeground() {
        return foregroundChooser.getSelectedColor();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        panel = new JPanel();
        background = new JLabel();
        var hSpacer1 = new Spacer();
        backgroundChooser = new ColorPanel();
        var vSpacer1 = new Spacer();
        foreground = new JLabel();
        foregroundChooser = new ColorPanel();

        //======== panel ========
        {
            panel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
                    new javax.swing.border.EmptyBorder(0, 0, 0, 0), ""
                    , javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM
                    , new java.awt.Font("Dialo\u0067", java.awt.Font.BOLD, 12)
                    , java.awt.Color.red), panel.getBorder()));
            panel.addPropertyChangeListener(
                    new java.beans.PropertyChangeListener() {
                        @Override
                        public void propertyChange(java.beans.PropertyChangeEvent e
                        ) {
                            if ("borde\u0072".equals(e.getPropertyName())) throw new RuntimeException()
                                    ;
                        }
                    });
            panel.setLayout(new GridLayoutManager(4, 6, new Insets(0, 10, 0, 0), -1, -1));

            //---- background ----
            background.setText("Background");
            background.setToolTipText("Set the anis escape code sequence background color.");
            panel.add(background, new GridConstraints(1, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_FIXED,
                    GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null));
            panel.add(hSpacer1, new GridConstraints(0, 2, 3, 4,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                    GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    null, null, null));
            panel.add(backgroundChooser, new GridConstraints(1, 1, 1, 1,
                    GridConstraints.ANCHOR_EAST, GridConstraints.FILL_VERTICAL,
                    GridConstraints.SIZEPOLICY_FIXED,
                    GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null));
            panel.add(vSpacer1, new GridConstraints(3, 0, 1, 4,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    null, null, null));

            //---- foreground ----
            foreground.setText("Foreground");
            foreground.setToolTipText("Set the anis escape code sequence foreground color.");
            panel.add(foreground, new GridConstraints(2, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_FIXED,
                    GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null));
            panel.add(foregroundChooser, new GridConstraints(2, 1, 1, 1,
                    GridConstraints.ANCHOR_EAST, GridConstraints.FILL_VERTICAL,
                    GridConstraints.SIZEPOLICY_FIXED,
                    GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
