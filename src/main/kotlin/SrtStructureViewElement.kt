package cz.cuni.mff.d3s.srtplugin

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import cz.cuni.mff.d3s.srtplugin.psi.SrtFile
import cz.cuni.mff.d3s.srtplugin.psi.SrtSubtitle
import cz.cuni.mff.d3s.srtplugin.psi.impl.SrtSubtitleImpl

class SrtStructureViewElement(val element: NavigatablePsiElement): StructureViewTreeElement {

    override fun getValue() = element

    override fun navigate(requestFocus: Boolean) = element.navigate(requestFocus)

    override fun canNavigate() = element.canNavigate()

    override fun canNavigateToSource() = element.canNavigateToSource()

    override fun getPresentation(): ItemPresentation {
        if (element is SrtSubtitle) {
            val text = textPreview(element.textContent)
            return PresentationData(text, null, null, null)
        }
        
        return element.presentation ?: PresentationData()
    }

    private fun textPreview(textContent: String?): String {
        val replaced = textContent?.replace("\\R".toRegex(), " ") ?: ""
        return if (replaced.length > 20) {
            replaced.take(20) + "..."
        } else {
            replaced
        }
    }

    override fun getChildren(): Array<TreeElement> {
        if (element is SrtFile) {
            val children = PsiTreeUtil.getChildrenOfType(element, SrtSubtitle::class.java)
            return if (children != null) {
                children.map { x -> x as SrtSubtitleImpl}
                        .map { x -> SrtStructureViewElement(x) }
                        .toTypedArray()
            } else {
                emptyArray()
            }
        } else {
            return emptyArray()
        }
    }

}