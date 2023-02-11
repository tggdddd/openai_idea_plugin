package icu.stopit.demo.Thread;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.openapi.wm.ToolWindowManager;
import icu.stopit.demo.Utils.Utils;
import icu.stopit.demo.View.AcitonView.TVIew;

/**
 * @ClassName Gen
 * @Description
 * @Author 15014
 * @Time 2023/2/11 23:12
 * @Version 1.0
 */
public class Gen {
    public void question(AnActionEvent e, String pre, boolean isReplace) {
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        SelectionModel selectionModel = editor.getSelectionModel();
        int start = selectionModel.getSelectionStart();
        int end = selectionModel.getSelectionEnd();
        String text = selectionModel.getSelectedText();
        ToolWindow tw = ToolWindowManager.getInstance(e.getProject()).getToolWindow("OpenAI");
        if (tw == null) {
            ToolWindowManager.getInstance(e.getProject()).registerToolWindow("OpenAI", true, ToolWindowAnchor.RIGHT);
            tw = ToolWindowManager.getInstance(e.getProject()).getToolWindow("OpenAI");
        }
        tw.show(null);
        Utils.tvIew.question.setText(pre + text);
        Utils.tvIew.send.doClick();
        if (isReplace) {
            new runThread(Utils.tvIew, e.getProject(), editor, start, end).start();
        }
    }

    class runThread extends Thread {
        TVIew tvIew;
        Editor editor;
        int start;
        int end;
        Project project;

        public runThread(TVIew tvIew, Project project, Editor editor, int start, int end) {
            this.tvIew = tvIew;
            this.end = end;
            this.start = start;
            this.editor = editor;
            this.project = project;
        }

        @Override
        public void run() {
            synchronized (tvIew.object) {
                WriteCommandAction.runWriteCommandAction(project, () -> {
                    Document document = editor.getDocument();
                    document.replaceString(start, end, tvIew.answer.getText());
                });
            }
        }
    }
}
