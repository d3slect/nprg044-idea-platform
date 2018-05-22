package cz.cuni.mff.d3s.srtplugin

import com.intellij.codeInsight.intention.impl.BaseIntentionAction
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import cz.cuni.mff.d3s.srtplugin.psi.SrtSubtitle


class CounterQuickFix : BaseIntentionAction() {
    override fun getText() = "Renumber subtitles"

    override fun getFamilyName() = "Srt subtitles"

    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?) = true

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {
        ApplicationManager.getApplication().invokeLater {

            object : WriteCommandAction.Simple<Unit>(project) {
                override fun run() {
                    PsiTreeUtil.findChildrenOfType(file, SrtSubtitle::class.java)
                            .zip(generateSequence(1) { it + 1 }.asIterable())
                            .forEach {
                                val srtElement = it.first
                                val num = it.second
                                val oldCounter = srtElement.firstChild
                                val newCounter = SrtElementFactory.createCounter(project, num)
                                oldCounter.replace(newCounter)
                            }
                }
            }.execute()
        }
    }

}