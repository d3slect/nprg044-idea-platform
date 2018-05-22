package cz.cuni.mff.d3s.srtplugin

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import cz.cuni.mff.d3s.srtplugin.psi.SrtFile

object SrtElementFactory {
    fun createCounter(project: Project, num: Int): PsiElement {
        val text = """
            ${num}
            00:00:01,000 --> 00:00:02,000
            Dummy text.

        """.trimIndent()

        return createFile(project, text).firstChild.firstChild
    }

    fun createFile(project: Project, text: String): SrtFile {
        val name = "dummy.srt"
        return PsiFileFactory.getInstance(project).createFileFromText(name, SrtFileType, text) as SrtFile
    }
}