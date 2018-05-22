import com.intellij.ide.structureView.*
import com.intellij.psi.PsiFile
import cz.cuni.mff.d3s.srtplugin.SrtStructureViewElement
import cz.cuni.mff.d3s.srtplugin.psi.SrtFile

class SrtStructureViewModel(psiFile: PsiFile) : StructureViewModelBase(psiFile, SrtStructureViewElement(psiFile)),
        StructureViewModel.ElementInfoProvider {
    override fun isAlwaysLeaf(element: StructureViewTreeElement?) = element?.value !is SrtFile

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement?) = false

}
