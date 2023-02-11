package icu.stopit.demo;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import icu.stopit.demo.View.AcitonView.TVIew;
import org.jetbrains.annotations.NotNull;

public class MyToolWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        // 初始化自定义组件对象
        TVIew myToolWindow = new TVIew();
        // 组件添加到idea中
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(myToolWindow, "OpenAI", false);
        toolWindow.getContentManager().addContent(content);
    }
}
