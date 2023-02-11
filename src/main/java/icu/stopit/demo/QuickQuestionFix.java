package icu.stopit.demo;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import icu.stopit.demo.Thread.Gen;
import icu.stopit.demo.Utils.Utils;

/**
 * @ClassName QuickQuestion
 * @Description
 * @Author 15014
 * @Time 2023/2/11 16:22
 * @Version 1.0
 */
public class QuickQuestionFix extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        new Gen().question(e, Utils.properties.getProperty("FIXING"), true);
    }
}
