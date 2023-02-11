package icu.stopit.demo.View.Setting;

import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @ClassName SettingPanel
 * @Description
 * @Author 15014
 * @Time 2023/2/11 15:00
 * @Version 1.0
 */
public class SettingPanel implements SearchableConfigurable {
    public static final String DISPLAY_NAME = "OpenAI参数设置";
    SettingView settingView;

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return this.getId();
    }

    @Override
    public @Nullable JComponent createComponent() {
        if (settingView == null) {
            settingView = new SettingView();
        }
        return settingView.$$$getRootComponent$$$();
    }

    @Override
    public boolean isModified() {
        return true;
    }

    @Override
    public void apply() {
        settingView.save();
    }

    @Override
    public void reset() {
        settingView.readProp();
    }

    @Override
    public @NotNull @NonNls String getId() {
        return DISPLAY_NAME;
    }
}
