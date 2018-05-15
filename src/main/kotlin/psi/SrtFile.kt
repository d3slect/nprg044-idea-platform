package cz.cuni.mff.d3s.srtplugin.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import cz.cuni.mff.d3s.srtplugin.SrtFileType
import cz.cuni.mff.d3s.srtplugin.SrtLanguage


class SrtFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, SrtLanguage) {

    override fun getFileType() = SrtFileType

    override fun toString() = "Srt File"
}
