import com.intellij.ide.structureView.*
import com.intellij.psi.PsiFile
import cz.cuni.mff.d3s.srtplugin.SrtStructureViewElement

class SrtStructureViewModel(psiFile: PsiFile) : StructureViewModelBase(psiFile, SrtStructureViewElement(psiFile)),
        StructureViewModel.ElementInfoProvider {
    //override fun isAlwaysLeaf(element: StructureViewTreeElement?) = element?.value is SrtFile
    override fun isAlwaysLeaf(element: StructureViewTreeElement?) = false

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement?) = false

}
